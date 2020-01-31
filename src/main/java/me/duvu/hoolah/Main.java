package me.duvu.hoolah;

public class Main {

    public static void main(String[] args) {
        String fileName = "./input.csv";

        //-- Params to search
        String fromDate = "20/08/2018 12:00:00";
        String toDate = "20/08/2018 13:00:00";
        String merchant = "Kwik-E-Mart";

        // -- //
        TransactionUtils.load(fileName);
        long fromTime = TransactionUtils.getTimestamp(fromDate);
        long toTime = TransactionUtils.getTimestamp(toDate);
        ResultModel result = TransactionUtils.search(fromTime, toTime, merchant);

        System.out.println("Number of transactions: " + result.getNumberOfTrans());
        System.out.println("Average Transaction Value: " + result.getAverageTransValue());
    }
}
