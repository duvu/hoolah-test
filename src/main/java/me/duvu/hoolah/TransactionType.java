package me.duvu.hoolah;

import org.apache.commons.lang3.StringUtils;

public enum TransactionType {
    PAYMENT("PAYMENT"),
    REVERSAL("REVERSAL");

    String type;

    TransactionType(String type) {
        this.type = type;
    }

    public static TransactionType get(String type) {
        if (StringUtils.equals(type, "PAYMENT")) {
            return PAYMENT;
        }

        if (StringUtils.equals(type, "REVERSAL")) {
            return REVERSAL;
        }
        return null;
    }

    @Override
    public String toString() {
        return type;
    }

}
