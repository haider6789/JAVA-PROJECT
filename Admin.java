/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;

import Employee.*;
import Connection.ConnectionToDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Admin {

    ConnectionToDB con = new ConnectionToDB();
    Connection con_obj = null;

    Statement stmt = null;
    PreparedStatement pstmt = null;
    ResultSet res = null;

    public Admin() {
        con_obj = con.EstablishConnection();
    }

    private static String g_loginId;
    private static String g_loginPassword;
    private static final String ROLE = "Employee";
//    private static String g_firstName;
//    private static String g_lastName;
//    private static String g_gender;
//    private static String gcnic;
//    private static String gcontact;
//    private static String gemailAddress;
//    private static String gdateOfBirth;
//    private static String gemployeeID;
//    private static String gaddress;
//    private static String gdesignation;
//    private static String gage;
//    private static double gsalary;
//    private static String gshiftTimings;

    public boolean addEmployee(String loginID, String pass, String employeeID, String firstName, String lastName, String gender, String age, String CNIC, String contact, String emailAddress, String address, String dateOfBirth, String designation, String shiftTimings, String salary) {
        boolean b = false;

        String sql = "Insert into tbl_employee(loginID,Password,Role,EmployeeID,FirstName,LastName,Gender,Age,CNIC,Contact,EmailAddress,Address,DateOfBirth,Designation,ShiftTimings,Salary) values ('" + loginID + "','" + pass + "','" + ROLE + "','" + employeeID + "','" + firstName + "','" + lastName + "','" + gender + "','" + age + "','" + CNIC + "','" + contact + "','" + emailAddress + "','" + address + "','" + dateOfBirth + "','" + designation + "','" + shiftTimings + "','" + salary + "')";
        try {
            stmt = con_obj.createStatement();
            int res = stmt.executeUpdate(sql);
            if (res > 0) {
                b = true;
            } else {
                JOptionPane.showMessageDialog(null, "Error");
                b = false;
            }
            g_loginId = loginID;
            g_loginPassword = pass;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            b = false;
        }
        return b;
    }

    public void add_employee_into_login() {
        String sql = "Insert into tbl_login(loginID,Password,Role) values ('" + g_loginId + "','" + g_loginPassword + "','" + ROLE + "')";
        try {
            stmt = con_obj.createStatement();
            int res = stmt.executeUpdate(sql);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }
    private static String i_loginId;
    private static String i_salary;
    private static String i_newSalary;

    public boolean applyIncrement(String ID) {
        i_loginId = ID;
        String login = "select * from tbl_employee where EmployeeID='" + i_loginId + "'";
        boolean b = false;
        boolean a = false;
        try {
            pstmt = con_obj.prepareStatement(login);
            res = pstmt.executeQuery();
            while (res.next()) {

                i_salary = res.getString("Salary");

                b = true;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            b = false;
        }
        //Applying Increment
        if (b == true) {

            double currentSalary = Double.parseDouble(i_salary);
            double cal_salary = (currentSalary + currentSalary * 0.15);
            i_newSalary = String.valueOf(cal_salary);
            try {
                stmt = con_obj.createStatement();

                int res = stmt.executeUpdate("update tbl_employee " + "set Salary='" + i_newSalary + "'" + " where EmployeeID='" + i_loginId + "'");

                if (res > 0) {

                    a = true;

                } else {

                    a = false;
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);

            }

        }
        return b;

    }

    public String getI_salary() {
        return i_salary;
    }

    public String getI_newSalary() {
        return i_newSalary;
    }
    //ChangeShiftTimings
    private static String currentTimings;

    public boolean changeShiftTimings(String ID, String newTimings) {
        i_loginId = ID;
        String login = "select * from tbl_employee where EmployeeID='" + i_loginId + "'";
        boolean b = false;
        boolean a = false;
        try {
            pstmt = con_obj.prepareStatement(login);
            res = pstmt.executeQuery();
            while (res.next()) {

                currentTimings = res.getString("ShiftTimings");

                b = true;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            b = false;
        }
        if (b == true) {

            try {
                stmt = con_obj.createStatement();

                int res = stmt.executeUpdate("update tbl_employee " + "set ShiftTimings='" + newTimings + "'" + " where EmployeeID='" + i_loginId + "'");

                if (res > 0) {

                    a = true;

                } else {

                    a = false;
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);

            }
        }
        return b;

    }

    public String getCurrentTimings() {
        return currentTimings;
    }
    //Change Admin Password

    public boolean changePassword(String ID, String newPassword) {
        i_loginId = ID;
        String login = "select * from tbl_login where loginID='" + i_loginId + "'";
        boolean b = false;
        boolean a = false;
        try {
            pstmt = con_obj.prepareStatement(login);
            res = pstmt.executeQuery();
            while (res.next()) {

                //currentTimings = res.getString("ShiftTimings");
                b = true;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            b = false;
        }
        if (b == true) {

            try {
                stmt = con_obj.createStatement();

                int res = stmt.executeUpdate("update tbl_login " + "set Password='" + newPassword + "'" + " where loginID='" + i_loginId + "'");

                if (res > 0) {

                    a = true;

                } else {

                    a = false;
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);

            }
        }
        return a;
    }
    //Open Account
    private static String c_loginId;
    private static String c_loginPassword;
    private static final String c_ROLE = "Customer";

    public boolean openAccount(String loginID, String pass, String firstName, String lastName, String gender, String age, String CNIC, String contact, String emailAddress, String address, String dateOfBirth, String martialStatus, String educationQualification, String occupation, String accountBalance, String accountType, String accountHolderType) {
        boolean b = false;

        String sql = "Insert into tbl_customer(loginID,Password,Role,FirstName,LastName,Gender,CNIC,Contact,EmailAddress,Address,DateOfBirth,MaritalStatus,EducationQualification,Occupation,Age,AccountBalance,AccountType,AccountHolderType) values ('" + loginID + "','" + pass + "','" + ROLE + "','" + firstName + "','" + lastName + "','" + gender + "','" + CNIC + "','" + contact + "','" + emailAddress + "','" + address + "','" + dateOfBirth + "','" + martialStatus + "','" + educationQualification + "','" + occupation + "','" + age + "','" + accountBalance + "','" + accountType + "','" + accountHolderType + "')";
        try {
            stmt = con_obj.createStatement();
            int res = stmt.executeUpdate(sql);
            if (res > 0) {
                b = true;
            } else {
                b = false;
            }
            c_loginId = loginID;
            c_loginPassword = pass;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            b = false;
        }
        return b;
    }

    public void add_customer_into_login() {
        String sql = "Insert into tbl_login(loginID,Password,Role) values ('" + c_loginId + "','" + c_loginPassword + "','" + c_ROLE + "')";
        try {
            stmt = con_obj.createStatement();
            int res = stmt.executeUpdate(sql);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }
    //Add Admin
    private static final String a_ROLE = "Admin";

    public boolean addAdmin(String loginID, String password) {
        boolean b = false;
        String sql = "Insert into tbl_login(loginID,Password,Role) values ('" + loginID + "','" + password + "','" + a_ROLE + "')";
        try {
            stmt = con_obj.createStatement();
            int res = stmt.executeUpdate(sql);
            if (res > 0) {

                b = true;
            } else {

                b = false;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            b = false;
        }
        return b;
    }
}
