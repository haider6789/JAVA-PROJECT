/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Customer;

/**
 *
 * @author ihaid
 */
public class JointHolder extends AccountHolderType {
    
    private String accountHolderType;

    @Override
    public void setAccountHolderType(String accountHolderType) {
        this.accountHolderType = accountHolderType;
    }

    @Override
    public String getAccountHolderType() {
        return accountHolderType;
    }
}