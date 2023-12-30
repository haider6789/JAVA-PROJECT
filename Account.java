package Customer;

public class Account {

    private static String accountNumber;
    private static String accountBranchCode;
    private static double accountBalance;
    private static String accountType;
    private static String accountHolderType;
    
    AccountHolderType accountHolder = new AccountHolderType() {
        @Override
        public void setAccountHolderType(String accountHolderType) {
            Account.accountHolderType = accountHolderType;
        }

        @Override
        public String getAccountHolderType() {
            return accountHolderType;
        }
    };
    
    public Account(String accountNumber,String accountBranchCode, String accountType, String accountHolderType, double accountBalance){
        Account.accountNumber = accountNumber;
        Account.accountBranchCode = accountBranchCode;
        Account.accountType = accountType;
        Account.accountHolderType =accountHolderType;
        Account.accountBalance = accountBalance;
    }

    public static String getAccountNumber() {
        return accountNumber;
    }

    public static String getAccountBranchCode() {
        return accountBranchCode;
    }

    public static double getAccountBalance() {
        return accountBalance;
    }

    public static String getAccountType() {
        return accountType;
    }

    public static String getAccountHolderType() {
        return accountHolderType;
    }

    public static void setAccountType(String accountType) {
        Account.accountType = accountType;
    }

    public static void setAccountHolderType(String accountHolderType) {
        Account.accountHolderType = accountHolderType;
    }
    
    public static void setAccountNumber(String accountNumber) {
        Account.accountNumber = accountNumber;
    }

    public static void setAccountBranchCode(String accountBranchCode) {
        Account.accountBranchCode = accountBranchCode;
    }

    public static void setAccountBalance(double accountBalance) {
        Account.accountBalance = accountBalance;
    }

}
