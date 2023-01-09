package enumType;

public enum TransactionType {
    DEPOSIT(5),  //index 0
    WITHDRAW(10),  //index 1
    TRANSFER(15),  //index 2
    PAYMENT(20),  //index 3
    OTHER(100);  //index 4

    private final int transactionCode;

    public int getTransactionCode() {
        return transactionCode;
    }

    private TransactionType(int code){
        this.transactionCode = code;
    }
}
