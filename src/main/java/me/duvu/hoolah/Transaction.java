package me.duvu.hoolah;

import java.util.Date;

public class Transaction {
    private String id;
    private Date date;
    private Long timestamp;
    private Double amount;
    private String merchant;
    private TransactionType type;
    private String relatedTransaction;

    public Transaction() {
    }

    public Transaction(String id, Date date, Double amount, String merchant, TransactionType type) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.merchant = merchant;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
        this.timestamp = date.getTime();
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public String getRelatedTransaction() {
        return relatedTransaction;
    }

    public void setRelatedTransaction(String relatedTransaction) {
        this.relatedTransaction = relatedTransaction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Transaction that = (Transaction) o;

        return new org.apache.commons.lang3.builder.EqualsBuilder()
                .append(id, that.id)
                .append(date, that.date)
                .append(amount, that.amount)
                .append(merchant, that.merchant)
                .append(type, that.type)
                .append(relatedTransaction, that.relatedTransaction)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new org.apache.commons.lang3.builder.HashCodeBuilder(17, 37)
                .append(id)
                .append(date)
                .append(amount)
                .append(merchant)
                .append(type)
                .append(relatedTransaction)
                .toHashCode();
    }

}
