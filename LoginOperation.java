
package Login;

import Connection.ConnectionToDB;
import Customer.CustomerDashboard;
import java.sql.*;
import javax.swing.JOptionPane;



public class LoginOperation {
    
    ConnectionToDB con = new ConnectionToDB();
    Connection con_obj = con.EstablishConnection(); 

    Statement stmt = null; 
    PreparedStatement pstmt = null; 
    ResultSet res = null; 

    
    public boolean LoginUser(String logid, String upass,String urole) {

        String loginString = "Select * from tbl_login where loginID='" + logid + "'and Password='" + upass + "' and Role='"+urole+"'";
        
        boolean b;
        try {

            pstmt = con_obj.prepareStatement(loginString);
            res = pstmt.executeQuery();

            if (res.next()) {
                b = true;
            } else {
                b = false;
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
            b = false;
        }

        return b;

    }
    
    
}
