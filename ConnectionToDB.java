
package Connection;

import java.awt.HeadlessException;
import java.sql.*;
import javax.swing.JOptionPane;

public class ConnectionToDB 
{

    Connection con = null;

    public Connection EstablishConnection() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
           con = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\ihaid\\OneDrive\\Desktop\\OOP Lab Project (2)\\OOP Lab Project\\Database.accdb");
        } catch (HeadlessException | ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        return con;

    }
}
    

    