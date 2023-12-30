/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Customer;

/**
 *
 * @author ihaid
 */
public class SavingAccount extends Account {
    
    private String accountType;
    
    public SavingAccount(String accountNumber, String accountBranchCode, String accountType, String accountHolderType, double accountBalance) {
        super(accountNumber, accountBranchCode, accountType, accountHolderType, accountBalance);
        setAccountType(accountType);
    }
    
    public String getType(){
        return accountType;
    }
}
