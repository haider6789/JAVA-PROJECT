package Customer;

import Connection.ConnectionToDB;
import Transactions.Transactions;
import java.sql.*;
import javax.swing.JOptionPane;

public class Customer {

    ConnectionToDB con = new ConnectionToDB();
    Connection con_obj = con.EstablishConnection();

    Statement stmt = null;
    PreparedStatement pstmt = null;
    ResultSet res = null;

    public void getDetails(String userId) {

        String loginId = userId;

        String str = "select * from tbl_customer where loginID = '" + loginId + "'";

        try {
            pstmt = con_obj.prepareStatement(str);
            res = pstmt.executeQuery();

            while (res.next()) {

                CustomerDashboard.setLoginId(loginId);
                CustomerDashboard.setLoginPassword(res.getString("Password"));
                CustomerDashboard.setFirstName(res.getString("FirstName"));
                CustomerDashboard.setLastName(res.getString("LastName"));
                CustomerDashboard.setGender(res.getString("Gender"));
                CustomerDashboard.setCnic(res.getString("CNIC"));
                CustomerDashboard.setContact(res.getString("Contact"));
                CustomerDashboard.setEmailAddress(res.getString("EmailAddress"));
                CustomerDashboard.setDateOfBirth(res.getString("DateOfBirth"));
                CustomerDashboard.setMaritalStatus(res.getString("MaritalStatus"));
                CustomerDashboard.setEducationQualification(res.getString("EducationQualification"));
                CustomerDashboard.setOccupation(res.getString("Occupation"));
                CustomerDashboard.setAge(res.getString("Age"));
                Account.setAccountNumber(res.getString("AccountNumber"));
                Account.setAccountBalance(Double.parseDouble(res.getString("AccountBalance")));
                Transactions.setDepositedAmount(Double.parseDouble(res.getString("DepositedAmount")));
                Transactions.setWithdrawalAmount(Double.parseDouble(res.getString("WithdrawalAmount")));
                Transactions.setTransactionDate(res.getString("TransactionDate"));

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public boolean DepositAmount(Double postBalance, Double deposit, String transactionDate, String loginId) {
        boolean b = false;

        String sql = "UPDATE tbl_customer set AccountBalance = '" + postBalance + "',DepositedAmount = '" + deposit + "', TransactionDate = '" + transactionDate + "' WHERE loginID = '" + loginId + "' ";

        try {

            stmt = con_obj.createStatement();
            int res = stmt.executeUpdate(sql);

            if (res > 0) {

                b = true;

            } else {

                JOptionPane.showMessageDialog(null, "Error");
                b = false;
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        return b;

    }

    public boolean WithdrawAmount(Double postBalance, Double withdraw, String transactionDate, String loginId) {
        boolean b = false;

        String sql = "UPDATE tbl_customer set AccountBalance = '" + postBalance + "', WithdrawalAmount = '" + withdraw + "', TransactionDate = '" + transactionDate + "' WHERE loginID = '" + loginId + "' ";

        try {

            stmt = con_obj.createStatement();
            int res = stmt.executeUpdate(sql);

            if (res > 0) {

                b = true;

            } else {

                JOptionPane.showMessageDialog(null, "Error");
                b = false;
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        return b;

    }

    public boolean ViewAmount(String loginId) {

        String str = "select * from tbl_customer where loginID = '" + loginId + "'";
        boolean b = false;

        try {
            pstmt = con_obj.prepareStatement(str);
            res = pstmt.executeQuery();

            while (res.next()) {
                Account.setAccountNumber(res.getString("AccountNumber"));
                Account.setAccountBranchCode(res.getString("BranchCode"));
                Account.setAccountType(res.getString("AccountType"));
                Account.setAccountBalance(Double.parseDouble(res.getString("AccountBalance")));
                b = true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            b = false;
        }
        return b;
    }

    public void setBeneficiaryAmount(String benAccountNumber) {

        String str = "select * from tbl_customer where AccountNumber = '" + benAccountNumber + "'";

        try {
            pstmt = con_obj.prepareStatement(str);
            res = pstmt.executeQuery();

            while (res.next()) {
                Transactions.setBeneficiaryAmount(Double.parseDouble(res.getString("AccountBalance")));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public boolean FundReciever(Double postBalance, String benAccountNumber) {
        boolean b = false;

        String sql = "UPDATE tbl_customer set AccountBalance = '" + postBalance + "' WHERE AccountNumber = '" + benAccountNumber + "' ";

        try {

            stmt = con_obj.createStatement();
            int res = stmt.executeUpdate(sql);

            if (res > 0) {

                b = true;

            } else {

                JOptionPane.showMessageDialog(null, "Error");
                b = false;
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        return b;

    }

    public boolean FundSender(Double postBalance, String loginID) {
        boolean b = false;

        String sql = "UPDATE tbl_customer set AccountBalance = '" + postBalance + "' WHERE loginID = '" + loginID + "' ";

        try {

            stmt = con_obj.createStatement();
            int res = stmt.executeUpdate(sql);

            if (res > 0) {

                b = true;

            } else {

//                JOptionPane.showMessageDialog(null, "Error");
                b = false;
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        return b;

    }

    public boolean UpdateInformation(String pass, String fname, String lname, String contact, String email, String qualification, String occupation, String loginID) {

        boolean b = false;

        String sql = "UPDATE tbl_customer set Password = '" + pass + "', FirstName = '" + fname + "', LastName = '" + lname + "', Contact = '" + contact + "', EmailAddress = '" + email + "', EducationQualification = '" + qualification + "', Occupation = '" + occupation + "' WHERE loginID = '" + loginID + "' ";

        try {

            stmt = con_obj.createStatement();
            int res = stmt.executeUpdate(sql);

            if (res > 0) {

                b = true;

            } else {

                JOptionPane.showMessageDialog(null, "Error");
                b = false;
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        return b;

    }

}
