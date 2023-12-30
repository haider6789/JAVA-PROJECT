
package Employee;

import Connection.ConnectionToDB;
import java.sql.*;
import javax.swing.JOptionPane;

public class Employee {

    ConnectionToDB con = new ConnectionToDB();
    Connection con_obj = con.EstablishConnection();

    Statement stmt = null;
    PreparedStatement pstmt = null;
    ResultSet res = null;
    private static String loginId;
    private static String loginpassword;
    private static String employeeid;
    private static String firstName;
    private static String lastName;
    private static String gender;
    private static String cnic;
    private static String contact;
    private static String emailAddress;
    private static String address;
    private static String dateOfbirth;
    private static String designation;
    private static String shiftTimings;
    private static String role;
  static int salary;

    public void setCon(ConnectionToDB con) {
        this.con = con;
    }

    public void setCon_obj(Connection con_obj) {
        this.con_obj = con_obj;
    }

    public void setStmt(Statement stmt) {
        this.stmt = stmt;
    }

    public void setPstmt(PreparedStatement pstmt) {
        this.pstmt = pstmt;
    }

    public void setRes(ResultSet res) {
        this.res = res;
    }

    public static void setLoginId(String loginId) {
        Employee.loginId = loginId;
    }

    public static void setLoginpassword(String loginpassword) {
        Employee.loginpassword = loginpassword;
    }

    public static void setEmployeeid(String employeeid) {
        Employee.employeeid = employeeid;
    }

    public static void setFirstName(String firstName) {
        Employee.firstName = firstName;
    }

    public static void setLastName(String lastName) {
        Employee.lastName = lastName;
    }

    public static void setGender(String gender) {
        Employee.gender = gender;
    }

    public static void setCnic(String cnic) {
        Employee.cnic = cnic;
    }

    public static void setContact(String contact) {
        Employee.contact = contact;
    }

    public static void setEmailAddress(String emailAddress) {
        Employee.emailAddress = emailAddress;
    }

    public static void setAddress(String address) {
        Employee.address = address;
    }

    public static void setDateOfbirth(String dateOfbirth) {
        Employee.dateOfbirth = dateOfbirth;
    }

    public static void setDesignation(String designation) {
        Employee.designation = designation;
    }

    public static void setShiftTimings(String shiftTimings) {
        Employee.shiftTimings = shiftTimings;
    }

    public static void setRole(String role) {
        Employee.role = role;
    }

    public static void setSalary(int salary) {
        Employee.salary = salary;
    }

    public static void setAge(int age) {
        Employee.age = age;
    }

    public ConnectionToDB getCon() {
        return con;
    }

    public Connection getCon_obj() {
        return con_obj;
    }

    public Statement getStmt() {
        return stmt;
    }

    public PreparedStatement getPstmt() {
        return pstmt;
    }

    public ResultSet getRes() {
        return res;
    }

    public static String getLoginId() {
        return loginId;
    }

    public static String getLoginpassword() {
        return loginpassword;
    }

    public static String getEmployeeid() {
        return employeeid;
    }

    public static String getFirstName() {
        return firstName;
    }

    public static String getLastName() {
        return lastName;
    }

    public static String getGender() {
        return gender;
    }

    public static String getCnic() {
        return cnic;
    }

    public static String getContact() {
        return contact;
    }

    public static String getEmailAddress() {
        return emailAddress;
    }

    public static String getAddress() {
        return address;
    }

    public static String getDateOfbirth() {
        return dateOfbirth;
    }

    public static String getDesignation() {
        return designation;
    }

    public static String getShiftTimings() {
        return shiftTimings;
    }

    public static String getRole() {
        return role;
    }

    public static int getSalary() {
        return salary;
    }

    public static int getAge() {
        return age;
    }
    private static int age;

public boolean ChangePassword(String userId, String password){
    String role="Employee";
    loginId=userId;
  boolean a = false;
        String sql = "update tbl_employee set Password='" + password + "'where loginID='" + userId + "'";
String sqr = "update tbl_login set Password='" + password + "'where loginID='" + userId + "'and Role='" + role + "'";
        try {
            stmt = con_obj.createStatement();
            int rs = stmt.executeUpdate(sql);
            int res=stmt.executeUpdate(sqr);
            if (rs > 0&& res>0) {
                a = true;
            } else {
                a = false;
            }
        } catch (Exception c) {
            JOptionPane.showMessageDialog(null, c);

        }
        return a;
    }
public String ViewShiftTimings(String userID){
    loginId = userID;
    String timings = null;
      
        String str = "select * from tbl_employee where loginID = '" + loginId + "'";
        try{
    pstmt = con_obj.prepareStatement(str);
            res = pstmt.executeQuery();
            if(res.next()){
                timings=res.getNString("ShiftTimings");
             return timings;   
            }}
            catch(Exception ex){
                JOptionPane.showMessageDialog(null, ex);
                    }
        return timings;
}
public int ViewSalary(String userId) {

        loginId = userId;
       
int employee_salary = 0;
        String str = "select * from tbl_employee where loginID = '" + loginId + "'";
try {
            pstmt = con_obj.prepareStatement(str);
            res = pstmt.executeQuery();
            if(res.next()){
                employee_salary=res.getInt("Salary");
                
            }

        } catch (Exception c) {
            JOptionPane.showMessageDialog(null, c);
          
        }
        return employee_salary;
}
public boolean UpdateEmail(String UserId, String Email){
    loginId=UserId;
    
    boolean a=false;
    String sql = "update tbl_employee set EmailAddress='" + Email + "'where loginID='" + UserId + "'";
      
      try {
            stmt = con_obj.createStatement();
            int rs = stmt.executeUpdate(sql);
           
            if (rs > 0) {
                a = true;
            } else {
                a = false;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);

        }
        return a;
}
public boolean UpdateContact(String UserId, String Contact){
    loginId=UserId;
    
    boolean a=false;
    String sql = "update tbl_employee set Contact='" + Contact + "'where loginID='" + UserId + "'";
      
      try {
            stmt = con_obj.createStatement();
            int rs = stmt.executeUpdate(sql);
           
            if (rs > 0) {
                a = true;
            } else {
                a = false;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);

        }
        return a;
}
public boolean UpdateAddress(String UserId, String Address){
    loginId=UserId;
    
    boolean a=false;
    String sql = "update tbl_employee set Address='" + Address + "'where loginID='" + UserId + "'";
      
      try {
            stmt = con_obj.createStatement();
            int rs = stmt.executeUpdate(sql);
           
            if (rs > 0) {
                a = true;
            } else {
                a = false;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);

        }
        return a;
}
}





    

