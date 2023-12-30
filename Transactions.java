
package Transactions;

public class Transactions {
    
    private static double depositedAmount;
    private static double withdrawalAmount;
    private static String transactionDate;
    private static double beneficiaryAmount;

    public static double getBeneficiaryAmount() {
        return beneficiaryAmount;
    }

    public static double getDepositedAmount() {
        return depositedAmount;
    }

    public static double getWithdrawalAmount() {
        return withdrawalAmount;
    }

    public static String getTransactionDate() {
        return transactionDate;
    }

    public static void setBeneficiaryAmount(double beneficiaryAmount) {
        Transactions.beneficiaryAmount = beneficiaryAmount;
    }
    
    public static void setDepositedAmount(double depositedAmount) {
        Transactions.depositedAmount = depositedAmount;
    }

    public static void setWithdrawalAmount(double withdrawalAmount) {
        Transactions.withdrawalAmount = withdrawalAmount;
    }

    public static void setTransactionDate(String transactionDate) {
        Transactions.transactionDate = transactionDate;
    }
}
