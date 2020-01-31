package me.duvu.hoolah;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public class TransactionUtils {
    private static final String DATE_FMT = "DD/MM/YYYY hh:mm:ss";

    private static List<Transaction> transactionList = new ArrayList<>();

    public static ResultModel search(long fromTimestamp, long toTimestamp, String merchant) {
        ResultModel result = new ResultModel(merchant);
        result.setFromTimestamp(fromTimestamp);
        result.setToTimestamp(toTimestamp);
        transactionList.stream().filter(x -> (x.getTimestamp() >= fromTimestamp ) && (x.getTimestamp() <= toTimestamp) && (StringUtils.equals(x.getMerchant(), merchant)) && (x.getType().equals(TransactionType.PAYMENT)))
                .forEach(xx -> result.addTransValue(xx.getAmount()));

        return result;
    }

    public static void load(String fileName) {
        try (Stream<String> ss = Files.lines(Paths.get(fileName)).skip(1)) {
            //ss.forEach(System.out::println);
            ss.forEach(s -> {
                Transaction aTrans = TransactionUtils.parse(s);
                transactionList.add(aTrans);
            });
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Something went wrong!");
        }
    }

    public static Transaction parse(String trans) {
        //WLMFRDGD, 20/08/2018 12:45:33, 59.99, Kwik-E-Mart, PAYMENT
        String[] transInArr = StringUtils.split(trans, ",");
        if (transInArr != null && transInArr.length >= 5) {
            Transaction aTrans = new Transaction();
            aTrans.setId(transInArr[0]);
            aTrans.setDate(parseDate(transInArr[1]));
            aTrans.setAmount(parseDouble(transInArr[2]));
            aTrans.setMerchant(StringUtils.trim(transInArr[3]));
            aTrans.setType(TransactionType.get(StringUtils.trim(transInArr[4])));

            if (transInArr.length > 5) {
                aTrans.setRelatedTransaction(transInArr[5]);
            }

            return aTrans;
        }
        return null;
    }

    public static Date parseDate(String dtStr) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FMT);
        try {
            return sdf.parse(dtStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static long getTimestamp(String dtStr) {
        Date date = parseDate(dtStr);
        return date != null ? date.getTime() : 0;
    }

    private static Double parseDouble(String amountStr) {
        return Double.parseDouble(amountStr);
    }
}
