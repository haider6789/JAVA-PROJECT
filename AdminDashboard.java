/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;

import Connection.ConnectionToDB;
import Customer.*;
import Login.Login;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 *
 * @author Ahmed
 */
public class AdminDashboard extends javax.swing.JFrame {

    /**
     * Creates new form Customer
     */
    ConnectionToDB con = new ConnectionToDB();
    Connection con_obj = con.EstablishConnection();
    Border default_border = BorderFactory.createMatteBorder(1, 0, 1, 0, new Color(36, 37, 42));
    Border golden_border = BorderFactory.createMatteBorder(1, 0, 1, 0, new Color(198, 160, 89));

    JLabel[] menuLabels = new JLabel[7];

    JPanel[] panels = new JPanel[7];

    public AdminDashboard() {

        initComponents();

        menuLabels[0] = lbl_dashboard;
        menuLabels[1] = lbl_openAccount;
        menuLabels[2] = lbl_addAdmin;
        menuLabels[3] = lbl_addEmployee;
        menuLabels[4] = lbl_applyIncrement;
        menuLabels[5] = lbl_changeShiftTimings;
        menuLabels[6] = lbl_changePassword;

        panels[0] = pnl_dashboard;
        panels[1] = pnl_openAccount;
        panels[2] = pnl_addAdmin;
        panels[3] = pnl_addEmployee;
        panels[4] = pnl_applyIncrement;
        panels[5] = pnl_changeShiftTimings;
        panels[6] = pnl_changePassword;

        addActionToMenuLabels();

    }

    // create a function to set the label background color
    public void setLabelBackround(JLabel label) {
        // reset labels to their default design
        for (JLabel menuItem : menuLabels) {
            // change the jlabel background color to white
            menuItem.setBackground(new Color(36, 37, 42));
            // change the jlabel Foreground color to blue
            menuItem.setForeground(Color.white);
        }

        // change the jlabel background color to white
        label.setBackground(new Color(65, 67, 77));
        // change the jlabel Foreground color to blue
        label.setForeground(new Color(198, 160, 89));
    }

    public void showPanel(JPanel panel) {
        // hide panels
        for (JPanel pnl : panels) {
            pnl.setVisible(false);
        }

        // and show only this panel
        panel.setVisible(true);
    }
    
     public void showDashboard() {

        for (JPanel pnl : panels) {
            pnl.setVisible(false);
        }

        pnl_dashboard.setVisible(true);
    }

    public void addActionToMenuLabels() {
        // get labels in the jpanel menu
        Component[] components = pnl_menu.getComponents();

        for (Component component : components) {
            if (component instanceof JLabel) {
                JLabel label = (JLabel) component;

                label.addMouseListener(new MouseListener() {

                    @Override
                    public void mouseClicked(MouseEvent e) {

                        setLabelBackround(label);

                        switch (label.getText().trim()) {

                            case "Dashboard":
                                showPanel(pnl_dashboard);
                                break;

                            case "Open Account":
                                RefreshOpenAccount();
                                showPanel(pnl_openAccount);
                                break;

                            case "Add Admin":
                                RefreshAddAmin();
                                showPanel(pnl_addAdmin);
                                break;

                            case "Add Employee":
                                RefreshAddEmployee();
                                showPanel(pnl_addEmployee);

                                break;

                            case "Apply Increment":
                                RefreshIncrement();
                                showPanel(pnl_applyIncrement);

                                break;

                            case "Change Shift Timings":
                                RefreshShiftTimings();
                                showPanel(pnl_changeShiftTimings);

                                break;

                            case "Change Password":
                                RefreshChangePassword();
                                showPanel(pnl_changePassword);

                                break;

                        }

                    }

                    @Override
                    public void mousePressed(MouseEvent e) {
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        label.setBorder(golden_border);
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        label.setBorder(default_border);
                    }
                });

            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_panel1 = new javax.swing.JPanel();
        pnl_menu = new javax.swing.JPanel();
        pnl_titleAndLogo = new javax.swing.JPanel();
        lbl_bankLogo = new javax.swing.JLabel();
        lbl_logoHeading = new javax.swing.JLabel();
        lbl_dashboard = new javax.swing.JLabel();
        lbl_openAccount = new javax.swing.JLabel();
        lbl_addAdmin = new javax.swing.JLabel();
        lbl_addEmployee = new javax.swing.JLabel();
        lbl_applyIncrement = new javax.swing.JLabel();
        lbl_changeShiftTimings = new javax.swing.JLabel();
        lbl_changePassword = new javax.swing.JLabel();
        pnl_header = new javax.swing.JPanel();
        btn_signOut = new javax.swing.JButton();
        lbl_heading = new javax.swing.JLabel();
        pnl_dashboard = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pnl_openAccount = new javax.swing.JPanel();
        pnl_openAccount2 = new javax.swing.JPanel();
        lbl_headingWithdraw4 = new javax.swing.JLabel();
        spr_seperatorWithdraw9 = new javax.swing.JSeparator();
        lbl_withdrawAmountHeading4 = new javax.swing.JLabel();
        lbl_currentWithdrawHeading4 = new javax.swing.JLabel();
        spr_seperatorWithdraw10 = new javax.swing.JSeparator();
        btn_openAccount = new javax.swing.JButton();
        txt_loginID_oa = new javax.swing.JTextField();
        lbl_newAmountWithdrawHeading17 = new javax.swing.JLabel();
        lbl_newAmountWithdrawHeading18 = new javax.swing.JLabel();
        lbl_newAmountWithdrawHeading19 = new javax.swing.JLabel();
        cmb_gender_oa = new javax.swing.JComboBox();
        lbl_newAmountWithdrawHeading20 = new javax.swing.JLabel();
        lbl_newAmountWithdrawHeading21 = new javax.swing.JLabel();
        lbl_newAmountWithdrawHeading22 = new javax.swing.JLabel();
        lbl_newAmountWithdrawHeading23 = new javax.swing.JLabel();
        lbl_newAmountWithdrawHeading24 = new javax.swing.JLabel();
        lbl_newAmountWithdrawHeading25 = new javax.swing.JLabel();
        lbl_newAmountWithdrawHeading26 = new javax.swing.JLabel();
        lbl_newAmountWithdrawHeading27 = new javax.swing.JLabel();
        lbl_newAmountWithdrawHeading28 = new javax.swing.JLabel();
        txt_firstName_oa = new javax.swing.JTextField();
        txt_password_oa = new javax.swing.JTextField();
        txt_age_oa = new javax.swing.JTextField();
        txt_lastName_oa = new javax.swing.JTextField();
        txt_email_oa = new javax.swing.JTextField();
        txt_cnic_oa = new javax.swing.JTextField();
        txt_address_oa = new javax.swing.JTextField();
        txt_dateOfBirth_oa = new javax.swing.JTextField();
        txt_contact_oa = new javax.swing.JTextField();
        txt_occupation = new javax.swing.JTextField();
        txt_qualification = new javax.swing.JTextField();
        cmb_martialStatus = new javax.swing.JComboBox();
        lbl_newAmountWithdrawHeading29 = new javax.swing.JLabel();
        txt_accountBalance = new javax.swing.JTextField();
        lbl_newAmountWithdrawHeading30 = new javax.swing.JLabel();
        cmb_accountHolderType = new javax.swing.JComboBox();
        lbl_newAmountWithdrawHeading31 = new javax.swing.JLabel();
        cmb_accountType = new javax.swing.JComboBox();
        lbl_openAccountPicture = new javax.swing.JLabel();
        pnl_addAdmin = new javax.swing.JPanel();
        pnl_addAdmin2 = new javax.swing.JPanel();
        lbl_headingWithdraw5 = new javax.swing.JLabel();
        spr_seperatorWithdraw11 = new javax.swing.JSeparator();
        lbl_currentWithdrawHeading5 = new javax.swing.JLabel();
        lbl_newAmountWithdrawHeading16 = new javax.swing.JLabel();
        spr_seperatorWithdraw12 = new javax.swing.JSeparator();
        btn_addAdmin = new javax.swing.JButton();
        txt_adminLoginID = new javax.swing.JTextField();
        txt_adminPassword = new javax.swing.JTextField();
        lbl_addAdminPicture = new javax.swing.JLabel();
        pnl_addEmployee = new javax.swing.JPanel();
        pnl_addemployee = new javax.swing.JPanel();
        lbl_headingWithdraw = new javax.swing.JLabel();
        spr_seperatorWithdraw1 = new javax.swing.JSeparator();
        lbl_withdrawAmountHeading = new javax.swing.JLabel();
        lbl_currentWithdrawHeading = new javax.swing.JLabel();
        lbl_newAmountWithdrawHeading = new javax.swing.JLabel();
        spr_seperatorWithdraw2 = new javax.swing.JSeparator();
        btn_addEmployee = new javax.swing.JButton();
        txt_loginID = new javax.swing.JTextField();
        lbl_newAmountWithdrawHeading1 = new javax.swing.JLabel();
        lbl_newAmountWithdrawHeading2 = new javax.swing.JLabel();
        lbl_newAmountWithdrawHeading3 = new javax.swing.JLabel();
        cmb_gender = new javax.swing.JComboBox();
        lbl_newAmountWithdrawHeading4 = new javax.swing.JLabel();
        lbl_newAmountWithdrawHeading5 = new javax.swing.JLabel();
        lbl_newAmountWithdrawHeading6 = new javax.swing.JLabel();
        lbl_newAmountWithdrawHeading7 = new javax.swing.JLabel();
        lbl_newAmountWithdrawHeading8 = new javax.swing.JLabel();
        lbl_newAmountWithdrawHeading9 = new javax.swing.JLabel();
        lbl_newAmountWithdrawHeading10 = new javax.swing.JLabel();
        lbl_newAmountWithdrawHeading12 = new javax.swing.JLabel();
        lbl_newAmountWithdrawHeading13 = new javax.swing.JLabel();
        txt_employeeID = new javax.swing.JTextField();
        txt_firstName = new javax.swing.JTextField();
        txt_password = new javax.swing.JTextField();
        txt_age = new javax.swing.JTextField();
        txt_lastName = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        txt_cnic = new javax.swing.JTextField();
        txt_address = new javax.swing.JTextField();
        txt_dateOfBirth = new javax.swing.JTextField();
        txt_contact = new javax.swing.JTextField();
        txt_salary = new javax.swing.JTextField();
        txt_shiftTimings = new javax.swing.JTextField();
        txt_designation = new javax.swing.JTextField();
        lbl_addEmployeePicture = new javax.swing.JLabel();
        pnl_applyIncrement = new javax.swing.JPanel();
        pnl_applyIncrement2 = new javax.swing.JPanel();
        lbl_headingWithdraw1 = new javax.swing.JLabel();
        spr_seperatorWithdraw3 = new javax.swing.JSeparator();
        lbl_withdrawAmountHeading1 = new javax.swing.JLabel();
        lbl_currentWithdrawHeading1 = new javax.swing.JLabel();
        lbl_currentSalary = new javax.swing.JLabel();
        lbl_newAmountWithdrawHeading11 = new javax.swing.JLabel();
        spr_seperatorWithdraw4 = new javax.swing.JSeparator();
        btn_applyIncrement = new javax.swing.JButton();
        txt_enteredEmployeeID = new javax.swing.JTextField();
        lbl_newSalary = new javax.swing.JLabel();
        lbl_applyIncrementPicture = new javax.swing.JLabel();
        pnl_changeShiftTimings = new javax.swing.JPanel();
        pnl_changeShiftTimings2 = new javax.swing.JPanel();
        lbl_headingWithdraw2 = new javax.swing.JLabel();
        spr_seperatorWithdraw5 = new javax.swing.JSeparator();
        lbl_withdrawAmountHeading2 = new javax.swing.JLabel();
        lbl_currentWithdrawHeading2 = new javax.swing.JLabel();
        lbl_currentTimings = new javax.swing.JLabel();
        lbl_newAmountWithdrawHeading14 = new javax.swing.JLabel();
        spr_seperatorWithdraw6 = new javax.swing.JSeparator();
        btn_changeTimings = new javax.swing.JButton();
        txt_timingEmployeeID = new javax.swing.JTextField();
        txt_newTimings = new javax.swing.JTextField();
        btn_showCurrentTimings = new javax.swing.JButton();
        lbl_changeShiftTimingsPicture = new javax.swing.JLabel();
        pnl_changePassword = new javax.swing.JPanel();
        pnl_changePassword2 = new javax.swing.JPanel();
        lbl_headingWithdraw3 = new javax.swing.JLabel();
        spr_seperatorWithdraw7 = new javax.swing.JSeparator();
        lbl_currentWithdrawHeading3 = new javax.swing.JLabel();
        lbl_newAmountWithdrawHeading15 = new javax.swing.JLabel();
        spr_seperatorWithdraw8 = new javax.swing.JSeparator();
        btn_changePassword = new javax.swing.JButton();
        txt_adminID = new javax.swing.JTextField();
        txt_newPassword = new javax.swing.JTextField();
        lbl_passwordPicture = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Admin Dashboard");
        setSize(new java.awt.Dimension(1100, 700));

        pnl_panel1.setBackground(new java.awt.Color(207, 206, 206));
        pnl_panel1.setPreferredSize(new java.awt.Dimension(1100, 700));

        pnl_menu.setBackground(new java.awt.Color(153, 153, 153));

        pnl_titleAndLogo.setBackground(new java.awt.Color(36, 37, 42));
        pnl_titleAndLogo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(198, 160, 89)));

        lbl_bankLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Bank Logo 50x50.png"))); // NOI18N

        lbl_logoHeading.setFont(new java.awt.Font("Sitka Heading", 1, 18)); // NOI18N
        lbl_logoHeading.setForeground(new java.awt.Color(255, 255, 255));
        lbl_logoHeading.setText("Celestial Finance Ltd.");

        javax.swing.GroupLayout pnl_titleAndLogoLayout = new javax.swing.GroupLayout(pnl_titleAndLogo);
        pnl_titleAndLogo.setLayout(pnl_titleAndLogoLayout);
        pnl_titleAndLogoLayout.setHorizontalGroup(
            pnl_titleAndLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_titleAndLogoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_bankLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lbl_logoHeading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnl_titleAndLogoLayout.setVerticalGroup(
            pnl_titleAndLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_titleAndLogoLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(pnl_titleAndLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_bankLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_logoHeading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19))
        );

        lbl_dashboard.setBackground(new java.awt.Color(36, 37, 42));
        lbl_dashboard.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lbl_dashboard.setForeground(new java.awt.Color(255, 255, 255));
        lbl_dashboard.setText("                  Dashboard");
        lbl_dashboard.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_dashboard.setOpaque(true);

        lbl_openAccount.setBackground(new java.awt.Color(36, 37, 42));
        lbl_openAccount.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lbl_openAccount.setForeground(new java.awt.Color(255, 255, 255));
        lbl_openAccount.setText("               Open Account");
        lbl_openAccount.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_openAccount.setOpaque(true);

        lbl_addAdmin.setBackground(new java.awt.Color(36, 37, 42));
        lbl_addAdmin.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lbl_addAdmin.setForeground(new java.awt.Color(255, 255, 255));
        lbl_addAdmin.setText("                 Add Admin");
        lbl_addAdmin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_addAdmin.setOpaque(true);

        lbl_addEmployee.setBackground(new java.awt.Color(36, 37, 42));
        lbl_addEmployee.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lbl_addEmployee.setForeground(new java.awt.Color(255, 255, 255));
        lbl_addEmployee.setText("              Add Employee");
        lbl_addEmployee.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_addEmployee.setOpaque(true);

        lbl_applyIncrement.setBackground(new java.awt.Color(36, 37, 42));
        lbl_applyIncrement.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lbl_applyIncrement.setForeground(new java.awt.Color(255, 255, 255));
        lbl_applyIncrement.setText("             Apply Increment");
        lbl_applyIncrement.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_applyIncrement.setOpaque(true);

        lbl_changeShiftTimings.setBackground(new java.awt.Color(36, 37, 42));
        lbl_changeShiftTimings.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lbl_changeShiftTimings.setForeground(new java.awt.Color(255, 255, 255));
        lbl_changeShiftTimings.setText("         Change Shift Timings");
        lbl_changeShiftTimings.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_changeShiftTimings.setOpaque(true);

        lbl_changePassword.setBackground(new java.awt.Color(36, 37, 42));
        lbl_changePassword.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lbl_changePassword.setForeground(new java.awt.Color(255, 255, 255));
        lbl_changePassword.setText("          Change Password");
        lbl_changePassword.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_changePassword.setOpaque(true);

        javax.swing.GroupLayout pnl_menuLayout = new javax.swing.GroupLayout(pnl_menu);
        pnl_menu.setLayout(pnl_menuLayout);
        pnl_menuLayout.setHorizontalGroup(
            pnl_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_titleAndLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbl_dashboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbl_openAccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbl_addAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbl_applyIncrement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbl_changeShiftTimings, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbl_changePassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbl_addEmployee, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnl_menuLayout.setVerticalGroup(
            pnl_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_menuLayout.createSequentialGroup()
                .addComponent(pnl_titleAndLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(lbl_dashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_openAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_addAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_addEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_applyIncrement, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_changeShiftTimings, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_changePassword, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 215, Short.MAX_VALUE))
        );

        pnl_header.setBackground(new java.awt.Color(65, 67, 77));

        btn_signOut.setBackground(new java.awt.Color(0, 0, 5));
        btn_signOut.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btn_signOut.setForeground(new java.awt.Color(207, 206, 206));
        btn_signOut.setText("Sign Out");
        btn_signOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_signOutActionPerformed(evt);
            }
        });

        lbl_heading.setFont(new java.awt.Font("Californian FB", 1, 36)); // NOI18N
        lbl_heading.setForeground(new java.awt.Color(255, 255, 255));
        lbl_heading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_heading.setText("Admin Dashboard");

        javax.swing.GroupLayout pnl_headerLayout = new javax.swing.GroupLayout(pnl_header);
        pnl_header.setLayout(pnl_headerLayout);
        pnl_headerLayout.setHorizontalGroup(
            pnl_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_headerLayout.createSequentialGroup()
                .addContainerGap(144, Short.MAX_VALUE)
                .addComponent(lbl_heading, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(btn_signOut)
                .addContainerGap())
        );
        pnl_headerLayout.setVerticalGroup(
            pnl_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_headerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnl_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_heading)
                    .addComponent(btn_signOut))
                .addContainerGap())
        );

        pnl_dashboard.setBackground(new java.awt.Color(207, 206, 206));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dashboard bg.jpg"))); // NOI18N

        javax.swing.GroupLayout pnl_dashboardLayout = new javax.swing.GroupLayout(pnl_dashboard);
        pnl_dashboard.setLayout(pnl_dashboardLayout);
        pnl_dashboardLayout.setHorizontalGroup(
            pnl_dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnl_dashboardLayout.setVerticalGroup(
            pnl_dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnl_openAccount.setBackground(new java.awt.Color(207, 206, 206));

        pnl_openAccount2.setBackground(new java.awt.Color(102, 102, 102));

        lbl_headingWithdraw4.setBackground(new java.awt.Color(102, 102, 102));
        lbl_headingWithdraw4.setFont(new java.awt.Font("Sitka Heading", 1, 40)); // NOI18N
        lbl_headingWithdraw4.setForeground(new java.awt.Color(255, 255, 255));
        lbl_headingWithdraw4.setText("Open Account");

        spr_seperatorWithdraw9.setBackground(new java.awt.Color(198, 160, 89));
        spr_seperatorWithdraw9.setOpaque(true);

        lbl_withdrawAmountHeading4.setBackground(new java.awt.Color(102, 102, 102));
        lbl_withdrawAmountHeading4.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_withdrawAmountHeading4.setForeground(new java.awt.Color(255, 255, 255));
        lbl_withdrawAmountHeading4.setText("Password:");

        lbl_currentWithdrawHeading4.setBackground(new java.awt.Color(102, 102, 102));
        lbl_currentWithdrawHeading4.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_currentWithdrawHeading4.setForeground(new java.awt.Color(255, 255, 255));
        lbl_currentWithdrawHeading4.setText("LoginID:");

        spr_seperatorWithdraw10.setBackground(new java.awt.Color(198, 160, 89));
        spr_seperatorWithdraw10.setOpaque(true);

        btn_openAccount.setBackground(new java.awt.Color(102, 102, 102));
        btn_openAccount.setForeground(new java.awt.Color(255, 255, 255));
        btn_openAccount.setText("Open Account");
        btn_openAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_openAccountActionPerformed(evt);
            }
        });

        txt_loginID_oa.setBackground(new java.awt.Color(0, 0, 0));
        txt_loginID_oa.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        txt_loginID_oa.setForeground(new java.awt.Color(255, 255, 255));
        txt_loginID_oa.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(198, 160, 89)));

        lbl_newAmountWithdrawHeading17.setBackground(new java.awt.Color(102, 102, 102));
        lbl_newAmountWithdrawHeading17.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_newAmountWithdrawHeading17.setForeground(new java.awt.Color(255, 255, 255));
        lbl_newAmountWithdrawHeading17.setText("Last Name:");

        lbl_newAmountWithdrawHeading18.setBackground(new java.awt.Color(102, 102, 102));
        lbl_newAmountWithdrawHeading18.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_newAmountWithdrawHeading18.setForeground(new java.awt.Color(255, 255, 255));
        lbl_newAmountWithdrawHeading18.setText("First Name:");

        lbl_newAmountWithdrawHeading19.setBackground(new java.awt.Color(102, 102, 102));
        lbl_newAmountWithdrawHeading19.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_newAmountWithdrawHeading19.setForeground(new java.awt.Color(255, 255, 255));
        lbl_newAmountWithdrawHeading19.setText("Gender:");

        cmb_gender_oa.setBackground(new java.awt.Color(36, 37, 42));
        cmb_gender_oa.setForeground(new java.awt.Color(255, 255, 255));
        cmb_gender_oa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "Female" }));
        cmb_gender_oa.setToolTipText("");
        cmb_gender_oa.setAutoscrolls(true);
        cmb_gender_oa.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(198, 160, 89)));
        cmb_gender_oa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_gender_oaActionPerformed(evt);
            }
        });

        lbl_newAmountWithdrawHeading20.setBackground(new java.awt.Color(102, 102, 102));
        lbl_newAmountWithdrawHeading20.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_newAmountWithdrawHeading20.setForeground(new java.awt.Color(255, 255, 255));
        lbl_newAmountWithdrawHeading20.setText("Contact:");

        lbl_newAmountWithdrawHeading21.setBackground(new java.awt.Color(102, 102, 102));
        lbl_newAmountWithdrawHeading21.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_newAmountWithdrawHeading21.setForeground(new java.awt.Color(255, 255, 255));
        lbl_newAmountWithdrawHeading21.setText("CNIC:");

        lbl_newAmountWithdrawHeading22.setBackground(new java.awt.Color(102, 102, 102));
        lbl_newAmountWithdrawHeading22.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_newAmountWithdrawHeading22.setForeground(new java.awt.Color(255, 255, 255));
        lbl_newAmountWithdrawHeading22.setText("Address:");

        lbl_newAmountWithdrawHeading23.setBackground(new java.awt.Color(102, 102, 102));
        lbl_newAmountWithdrawHeading23.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_newAmountWithdrawHeading23.setForeground(new java.awt.Color(255, 255, 255));
        lbl_newAmountWithdrawHeading23.setText("Date Of Birth:");

        lbl_newAmountWithdrawHeading24.setBackground(new java.awt.Color(102, 102, 102));
        lbl_newAmountWithdrawHeading24.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_newAmountWithdrawHeading24.setForeground(new java.awt.Color(255, 255, 255));
        lbl_newAmountWithdrawHeading24.setText("Email Address:");

        lbl_newAmountWithdrawHeading25.setBackground(new java.awt.Color(102, 102, 102));
        lbl_newAmountWithdrawHeading25.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_newAmountWithdrawHeading25.setForeground(new java.awt.Color(255, 255, 255));
        lbl_newAmountWithdrawHeading25.setText("Qualification:");

        lbl_newAmountWithdrawHeading26.setBackground(new java.awt.Color(102, 102, 102));
        lbl_newAmountWithdrawHeading26.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_newAmountWithdrawHeading26.setForeground(new java.awt.Color(255, 255, 255));
        lbl_newAmountWithdrawHeading26.setText("Occupation:");

        lbl_newAmountWithdrawHeading27.setBackground(new java.awt.Color(102, 102, 102));
        lbl_newAmountWithdrawHeading27.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_newAmountWithdrawHeading27.setForeground(new java.awt.Color(255, 255, 255));
        lbl_newAmountWithdrawHeading27.setText("Martial Status:");

        lbl_newAmountWithdrawHeading28.setBackground(new java.awt.Color(102, 102, 102));
        lbl_newAmountWithdrawHeading28.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_newAmountWithdrawHeading28.setForeground(new java.awt.Color(255, 255, 255));
        lbl_newAmountWithdrawHeading28.setText("Age:");

        txt_firstName_oa.setBackground(new java.awt.Color(0, 0, 0));
        txt_firstName_oa.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        txt_firstName_oa.setForeground(new java.awt.Color(255, 255, 255));
        txt_firstName_oa.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(198, 160, 89)));

        txt_password_oa.setBackground(new java.awt.Color(0, 0, 0));
        txt_password_oa.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        txt_password_oa.setForeground(new java.awt.Color(255, 255, 255));
        txt_password_oa.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(198, 160, 89)));

        txt_age_oa.setBackground(new java.awt.Color(0, 0, 0));
        txt_age_oa.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        txt_age_oa.setForeground(new java.awt.Color(255, 255, 255));
        txt_age_oa.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(198, 160, 89)));

        txt_lastName_oa.setBackground(new java.awt.Color(0, 0, 0));
        txt_lastName_oa.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        txt_lastName_oa.setForeground(new java.awt.Color(255, 255, 255));
        txt_lastName_oa.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(198, 160, 89)));

        txt_email_oa.setBackground(new java.awt.Color(0, 0, 0));
        txt_email_oa.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        txt_email_oa.setForeground(new java.awt.Color(255, 255, 255));
        txt_email_oa.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(198, 160, 89)));

        txt_cnic_oa.setBackground(new java.awt.Color(0, 0, 0));
        txt_cnic_oa.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        txt_cnic_oa.setForeground(new java.awt.Color(255, 255, 255));
        txt_cnic_oa.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(198, 160, 89)));

        txt_address_oa.setBackground(new java.awt.Color(0, 0, 0));
        txt_address_oa.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        txt_address_oa.setForeground(new java.awt.Color(255, 255, 255));
        txt_address_oa.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(198, 160, 89)));

        txt_dateOfBirth_oa.setBackground(new java.awt.Color(0, 0, 0));
        txt_dateOfBirth_oa.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        txt_dateOfBirth_oa.setForeground(new java.awt.Color(255, 255, 255));
        txt_dateOfBirth_oa.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(198, 160, 89)));

        txt_contact_oa.setBackground(new java.awt.Color(0, 0, 0));
        txt_contact_oa.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        txt_contact_oa.setForeground(new java.awt.Color(255, 255, 255));
        txt_contact_oa.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(198, 160, 89)));

        txt_occupation.setBackground(new java.awt.Color(0, 0, 0));
        txt_occupation.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        txt_occupation.setForeground(new java.awt.Color(255, 255, 255));
        txt_occupation.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(198, 160, 89)));
        txt_occupation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_occupationActionPerformed(evt);
            }
        });

        txt_qualification.setBackground(new java.awt.Color(0, 0, 0));
        txt_qualification.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        txt_qualification.setForeground(new java.awt.Color(255, 255, 255));
        txt_qualification.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(198, 160, 89)));

        cmb_martialStatus.setBackground(new java.awt.Color(36, 37, 42));
        cmb_martialStatus.setForeground(new java.awt.Color(255, 255, 255));
        cmb_martialStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Married", "Single", "Divorced", "Other" }));
        cmb_martialStatus.setToolTipText("");
        cmb_martialStatus.setAutoscrolls(true);
        cmb_martialStatus.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(198, 160, 89)));
        cmb_martialStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_martialStatusActionPerformed(evt);
            }
        });

        lbl_newAmountWithdrawHeading29.setBackground(new java.awt.Color(102, 102, 102));
        lbl_newAmountWithdrawHeading29.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_newAmountWithdrawHeading29.setForeground(new java.awt.Color(255, 255, 255));
        lbl_newAmountWithdrawHeading29.setText("Deposit Money:");

        txt_accountBalance.setBackground(new java.awt.Color(0, 0, 0));
        txt_accountBalance.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        txt_accountBalance.setForeground(new java.awt.Color(255, 255, 255));
        txt_accountBalance.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(198, 160, 89)));
        txt_accountBalance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_accountBalanceActionPerformed(evt);
            }
        });

        lbl_newAmountWithdrawHeading30.setBackground(new java.awt.Color(102, 102, 102));
        lbl_newAmountWithdrawHeading30.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_newAmountWithdrawHeading30.setForeground(new java.awt.Color(255, 255, 255));
        lbl_newAmountWithdrawHeading30.setText("Account Type:");

        cmb_accountHolderType.setBackground(new java.awt.Color(36, 37, 42));
        cmb_accountHolderType.setForeground(new java.awt.Color(255, 255, 255));
        cmb_accountHolderType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Minor", "Firm", "Joint Holder", "Individual", " " }));
        cmb_accountHolderType.setToolTipText("");
        cmb_accountHolderType.setAutoscrolls(true);
        cmb_accountHolderType.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(198, 160, 89)));
        cmb_accountHolderType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_accountHolderTypeActionPerformed(evt);
            }
        });

        lbl_newAmountWithdrawHeading31.setBackground(new java.awt.Color(255, 255, 255));
        lbl_newAmountWithdrawHeading31.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_newAmountWithdrawHeading31.setForeground(new java.awt.Color(255, 255, 255));
        lbl_newAmountWithdrawHeading31.setText("Account Holder Type:");

        cmb_accountType.setBackground(new java.awt.Color(36, 37, 42));
        cmb_accountType.setForeground(new java.awt.Color(255, 255, 255));
        cmb_accountType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Current Account", "Saving Account", " " }));
        cmb_accountType.setToolTipText("");
        cmb_accountType.setAutoscrolls(true);
        cmb_accountType.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(198, 160, 89)));
        cmb_accountType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_accountTypeActionPerformed(evt);
            }
        });

        lbl_openAccountPicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Account Open Resized.png"))); // NOI18N

        javax.swing.GroupLayout pnl_openAccount2Layout = new javax.swing.GroupLayout(pnl_openAccount2);
        pnl_openAccount2.setLayout(pnl_openAccount2Layout);
        pnl_openAccount2Layout.setHorizontalGroup(
            pnl_openAccount2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_openAccount2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_openAccount2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_newAmountWithdrawHeading31)
                    .addComponent(lbl_newAmountWithdrawHeading29)
                    .addComponent(lbl_newAmountWithdrawHeading30))
                .addGap(18, 18, 18)
                .addGroup(pnl_openAccount2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmb_accountType, 0, 252, Short.MAX_VALUE)
                    .addComponent(cmb_accountHolderType, 0, 252, Short.MAX_VALUE)
                    .addComponent(txt_accountBalance))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_openAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(127, 127, 127))
            .addGroup(pnl_openAccount2Layout.createSequentialGroup()
                .addGroup(pnl_openAccount2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_openAccount2Layout.createSequentialGroup()
                        .addGroup(pnl_openAccount2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_openAccount2Layout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addComponent(lbl_newAmountWithdrawHeading21)
                                .addGap(26, 26, 26))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_openAccount2Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(pnl_openAccount2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbl_withdrawAmountHeading4)
                                    .addComponent(lbl_currentWithdrawHeading4)
                                    .addComponent(lbl_newAmountWithdrawHeading18)
                                    .addComponent(lbl_newAmountWithdrawHeading17)
                                    .addComponent(lbl_newAmountWithdrawHeading28)
                                    .addComponent(lbl_newAmountWithdrawHeading19))
                                .addGap(18, 18, 18)))
                        .addGroup(pnl_openAccount2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_firstName_oa, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                            .addComponent(txt_password_oa, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                            .addComponent(txt_age_oa, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                            .addComponent(txt_cnic_oa, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                            .addComponent(txt_loginID_oa, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                            .addComponent(cmb_gender_oa, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_lastName_oa))
                        .addGroup(pnl_openAccount2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_openAccount2Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(pnl_openAccount2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_newAmountWithdrawHeading27)
                                    .addGroup(pnl_openAccount2Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(pnl_openAccount2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(pnl_openAccount2Layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(lbl_newAmountWithdrawHeading26))
                                            .addComponent(lbl_newAmountWithdrawHeading25)))))
                            .addGroup(pnl_openAccount2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(pnl_openAccount2Layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addComponent(lbl_newAmountWithdrawHeading24)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                                    .addComponent(txt_email_oa, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(pnl_openAccount2Layout.createSequentialGroup()
                                    .addGap(78, 78, 78)
                                    .addComponent(lbl_newAmountWithdrawHeading20)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_contact_oa, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(pnl_openAccount2Layout.createSequentialGroup()
                                    .addGap(33, 33, 33)
                                    .addGroup(pnl_openAccount2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lbl_newAmountWithdrawHeading23)
                                        .addComponent(lbl_newAmountWithdrawHeading22))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(pnl_openAccount2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cmb_martialStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(pnl_openAccount2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_address_oa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_dateOfBirth_oa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(txt_qualification, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txt_occupation, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(pnl_openAccount2Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(pnl_openAccount2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spr_seperatorWithdraw10, javax.swing.GroupLayout.PREFERRED_SIZE, 771, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnl_openAccount2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(pnl_openAccount2Layout.createSequentialGroup()
                                    .addGap(29, 29, 29)
                                    .addComponent(lbl_headingWithdraw4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbl_openAccountPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(spr_seperatorWithdraw9, javax.swing.GroupLayout.PREFERRED_SIZE, 695, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        pnl_openAccount2Layout.setVerticalGroup(
            pnl_openAccount2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_openAccount2Layout.createSequentialGroup()
                .addGroup(pnl_openAccount2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_openAccount2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(lbl_headingWithdraw4))
                    .addComponent(lbl_openAccountPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(spr_seperatorWithdraw9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnl_openAccount2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_openAccount2Layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addGroup(pnl_openAccount2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_newAmountWithdrawHeading17, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_lastName_oa, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnl_openAccount2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(pnl_openAccount2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_currentWithdrawHeading4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnl_openAccount2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txt_loginID_oa, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbl_newAmountWithdrawHeading20, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_contact_oa, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnl_openAccount2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_withdrawAmountHeading4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_password_oa, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_newAmountWithdrawHeading24, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_email_oa, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnl_openAccount2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_newAmountWithdrawHeading18, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_firstName_oa, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_address_oa, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_newAmountWithdrawHeading22, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(pnl_openAccount2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_newAmountWithdrawHeading23, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_dateOfBirth_oa, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(pnl_openAccount2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_openAccount2Layout.createSequentialGroup()
                        .addGroup(pnl_openAccount2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_openAccount2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbl_newAmountWithdrawHeading19, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbl_newAmountWithdrawHeading27, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cmb_gender_oa, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnl_openAccount2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_age_oa, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_newAmountWithdrawHeading28, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_newAmountWithdrawHeading25, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnl_openAccount2Layout.createSequentialGroup()
                        .addComponent(cmb_martialStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_qualification, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(pnl_openAccount2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_openAccount2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(pnl_openAccount2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbl_newAmountWithdrawHeading21, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_cnic_oa, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnl_openAccount2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnl_openAccount2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_occupation, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_newAmountWithdrawHeading26, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(18, 18, 18)
                .addComponent(spr_seperatorWithdraw10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnl_openAccount2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_accountBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_newAmountWithdrawHeading29, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_openAccount2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_newAmountWithdrawHeading30, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmb_accountType, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_openAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnl_openAccount2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmb_accountHolderType, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_newAmountWithdrawHeading31, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnl_openAccountLayout = new javax.swing.GroupLayout(pnl_openAccount);
        pnl_openAccount.setLayout(pnl_openAccountLayout);
        pnl_openAccountLayout.setHorizontalGroup(
            pnl_openAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_openAccountLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnl_openAccount2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnl_openAccountLayout.setVerticalGroup(
            pnl_openAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_openAccountLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnl_openAccount2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnl_addAdmin.setBackground(new java.awt.Color(207, 206, 206));
        pnl_addAdmin.setForeground(new java.awt.Color(255, 255, 255));

        pnl_addAdmin2.setBackground(new java.awt.Color(102, 102, 102));

        lbl_headingWithdraw5.setFont(new java.awt.Font("Sitka Heading", 1, 40)); // NOI18N
        lbl_headingWithdraw5.setForeground(new java.awt.Color(255, 255, 255));
        lbl_headingWithdraw5.setText("Add Admin");

        spr_seperatorWithdraw11.setBackground(new java.awt.Color(198, 160, 89));
        spr_seperatorWithdraw11.setOpaque(true);

        lbl_currentWithdrawHeading5.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_currentWithdrawHeading5.setForeground(new java.awt.Color(255, 255, 255));
        lbl_currentWithdrawHeading5.setText("LoginID:");

        lbl_newAmountWithdrawHeading16.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_newAmountWithdrawHeading16.setForeground(new java.awt.Color(255, 255, 255));
        lbl_newAmountWithdrawHeading16.setText("Password:");

        spr_seperatorWithdraw12.setBackground(new java.awt.Color(198, 160, 89));
        spr_seperatorWithdraw12.setOpaque(true);

        btn_addAdmin.setBackground(new java.awt.Color(65, 67, 77));
        btn_addAdmin.setForeground(new java.awt.Color(255, 255, 255));
        btn_addAdmin.setText("Add Admin");
        btn_addAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addAdminActionPerformed(evt);
            }
        });

        txt_adminLoginID.setBackground(new java.awt.Color(0, 0, 0));
        txt_adminLoginID.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        txt_adminLoginID.setForeground(new java.awt.Color(255, 255, 255));
        txt_adminLoginID.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(198, 160, 89)));

        txt_adminPassword.setBackground(new java.awt.Color(0, 0, 0));
        txt_adminPassword.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        txt_adminPassword.setForeground(new java.awt.Color(255, 255, 255));
        txt_adminPassword.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(198, 160, 89)));
        txt_adminPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_adminPasswordActionPerformed(evt);
            }
        });

        lbl_addAdminPicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Add Admin.png"))); // NOI18N

        javax.swing.GroupLayout pnl_addAdmin2Layout = new javax.swing.GroupLayout(pnl_addAdmin2);
        pnl_addAdmin2.setLayout(pnl_addAdmin2Layout);
        pnl_addAdmin2Layout.setHorizontalGroup(
            pnl_addAdmin2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_addAdmin2Layout.createSequentialGroup()
                .addGroup(pnl_addAdmin2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_addAdmin2Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(pnl_addAdmin2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spr_seperatorWithdraw12, javax.swing.GroupLayout.PREFERRED_SIZE, 695, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spr_seperatorWithdraw11, javax.swing.GroupLayout.PREFERRED_SIZE, 695, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnl_addAdmin2Layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addGroup(pnl_addAdmin2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_newAmountWithdrawHeading16)
                            .addComponent(lbl_currentWithdrawHeading5))
                        .addGap(29, 29, 29)
                        .addGroup(pnl_addAdmin2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_adminPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_adminLoginID, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(56, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_addAdmin2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btn_addAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(145, 145, 145))
            .addGroup(pnl_addAdmin2Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(lbl_headingWithdraw5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_addAdminPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(162, 162, 162))
        );
        pnl_addAdmin2Layout.setVerticalGroup(
            pnl_addAdmin2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_addAdmin2Layout.createSequentialGroup()
                .addGroup(pnl_addAdmin2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_addAdmin2Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(lbl_headingWithdraw5))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_addAdmin2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbl_addAdminPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spr_seperatorWithdraw11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(pnl_addAdmin2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_currentWithdrawHeading5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_adminLoginID, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(pnl_addAdmin2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_adminPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_newAmountWithdrawHeading16, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addComponent(spr_seperatorWithdraw12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_addAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(128, 128, 128))
        );

        javax.swing.GroupLayout pnl_addAdminLayout = new javax.swing.GroupLayout(pnl_addAdmin);
        pnl_addAdmin.setLayout(pnl_addAdminLayout);
        pnl_addAdminLayout.setHorizontalGroup(
            pnl_addAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_addAdminLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(pnl_addAdmin2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        pnl_addAdminLayout.setVerticalGroup(
            pnl_addAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_addAdminLayout.createSequentialGroup()
                .addComponent(pnl_addAdmin2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 130, Short.MAX_VALUE))
        );

        pnl_addEmployee.setBackground(new java.awt.Color(207, 206, 206));

        pnl_addemployee.setBackground(new java.awt.Color(102, 102, 102));
        pnl_addemployee.setForeground(new java.awt.Color(255, 255, 255));

        lbl_headingWithdraw.setFont(new java.awt.Font("Sitka Heading", 1, 40)); // NOI18N
        lbl_headingWithdraw.setForeground(new java.awt.Color(255, 255, 255));
        lbl_headingWithdraw.setText("Add Employee");

        spr_seperatorWithdraw1.setBackground(new java.awt.Color(198, 160, 89));
        spr_seperatorWithdraw1.setOpaque(true);

        lbl_withdrawAmountHeading.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_withdrawAmountHeading.setForeground(new java.awt.Color(255, 255, 255));
        lbl_withdrawAmountHeading.setText("Password:");

        lbl_currentWithdrawHeading.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_currentWithdrawHeading.setForeground(new java.awt.Color(255, 255, 255));
        lbl_currentWithdrawHeading.setText("LoginID:");

        lbl_newAmountWithdrawHeading.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_newAmountWithdrawHeading.setForeground(new java.awt.Color(255, 255, 255));
        lbl_newAmountWithdrawHeading.setText("Employee ID:");

        spr_seperatorWithdraw2.setBackground(new java.awt.Color(198, 160, 89));
        spr_seperatorWithdraw2.setOpaque(true);

        btn_addEmployee.setBackground(new java.awt.Color(65, 67, 77));
        btn_addEmployee.setForeground(new java.awt.Color(255, 255, 255));
        btn_addEmployee.setText("Add");
        btn_addEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addEmployeeActionPerformed(evt);
            }
        });

        txt_loginID.setBackground(new java.awt.Color(0, 0, 0));
        txt_loginID.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        txt_loginID.setForeground(new java.awt.Color(255, 255, 255));
        txt_loginID.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(198, 160, 89)));

        lbl_newAmountWithdrawHeading1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_newAmountWithdrawHeading1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_newAmountWithdrawHeading1.setText("Last Name:");

        lbl_newAmountWithdrawHeading2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_newAmountWithdrawHeading2.setForeground(new java.awt.Color(255, 255, 255));
        lbl_newAmountWithdrawHeading2.setText("First Name:");

        lbl_newAmountWithdrawHeading3.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_newAmountWithdrawHeading3.setForeground(new java.awt.Color(255, 255, 255));
        lbl_newAmountWithdrawHeading3.setText("Gender:");

        cmb_gender.setBackground(new java.awt.Color(36, 37, 42));
        cmb_gender.setForeground(new java.awt.Color(255, 255, 255));
        cmb_gender.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "Female" }));
        cmb_gender.setToolTipText("");
        cmb_gender.setAutoscrolls(true);
        cmb_gender.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(198, 160, 89)));
        cmb_gender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_genderActionPerformed(evt);
            }
        });

        lbl_newAmountWithdrawHeading4.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_newAmountWithdrawHeading4.setForeground(new java.awt.Color(255, 255, 255));
        lbl_newAmountWithdrawHeading4.setText("Contact:");

        lbl_newAmountWithdrawHeading5.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_newAmountWithdrawHeading5.setForeground(new java.awt.Color(255, 255, 255));
        lbl_newAmountWithdrawHeading5.setText("CNIC:");

        lbl_newAmountWithdrawHeading6.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_newAmountWithdrawHeading6.setForeground(new java.awt.Color(255, 255, 255));
        lbl_newAmountWithdrawHeading6.setText("Address:");

        lbl_newAmountWithdrawHeading7.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_newAmountWithdrawHeading7.setForeground(new java.awt.Color(255, 255, 255));
        lbl_newAmountWithdrawHeading7.setText("Date Of Birth:");

        lbl_newAmountWithdrawHeading8.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_newAmountWithdrawHeading8.setForeground(new java.awt.Color(255, 255, 255));
        lbl_newAmountWithdrawHeading8.setText("Email Address:");

        lbl_newAmountWithdrawHeading9.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_newAmountWithdrawHeading9.setForeground(new java.awt.Color(255, 255, 255));
        lbl_newAmountWithdrawHeading9.setText("Shift Timings:");

        lbl_newAmountWithdrawHeading10.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_newAmountWithdrawHeading10.setForeground(new java.awt.Color(255, 255, 255));
        lbl_newAmountWithdrawHeading10.setText("Salary:");

        lbl_newAmountWithdrawHeading12.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_newAmountWithdrawHeading12.setForeground(new java.awt.Color(255, 255, 255));
        lbl_newAmountWithdrawHeading12.setText("Designation:");

        lbl_newAmountWithdrawHeading13.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_newAmountWithdrawHeading13.setForeground(new java.awt.Color(255, 255, 255));
        lbl_newAmountWithdrawHeading13.setText("Age:");

        txt_employeeID.setBackground(new java.awt.Color(0, 0, 0));
        txt_employeeID.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        txt_employeeID.setForeground(new java.awt.Color(255, 255, 255));
        txt_employeeID.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(198, 160, 89)));

        txt_firstName.setBackground(new java.awt.Color(0, 0, 0));
        txt_firstName.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        txt_firstName.setForeground(new java.awt.Color(255, 255, 255));
        txt_firstName.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(198, 160, 89)));

        txt_password.setBackground(new java.awt.Color(0, 0, 0));
        txt_password.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        txt_password.setForeground(new java.awt.Color(255, 255, 255));
        txt_password.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(198, 160, 89)));

        txt_age.setBackground(new java.awt.Color(0, 0, 0));
        txt_age.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        txt_age.setForeground(new java.awt.Color(255, 255, 255));
        txt_age.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(198, 160, 89)));

        txt_lastName.setBackground(new java.awt.Color(0, 0, 0));
        txt_lastName.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        txt_lastName.setForeground(new java.awt.Color(255, 255, 255));
        txt_lastName.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(198, 160, 89)));

        txt_email.setBackground(new java.awt.Color(0, 0, 0));
        txt_email.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        txt_email.setForeground(new java.awt.Color(255, 255, 255));
        txt_email.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(198, 160, 89)));

        txt_cnic.setBackground(new java.awt.Color(0, 0, 0));
        txt_cnic.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        txt_cnic.setForeground(new java.awt.Color(255, 255, 255));
        txt_cnic.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(198, 160, 89)));

        txt_address.setBackground(new java.awt.Color(0, 0, 0));
        txt_address.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        txt_address.setForeground(new java.awt.Color(255, 255, 255));
        txt_address.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(198, 160, 89)));

        txt_dateOfBirth.setBackground(new java.awt.Color(0, 0, 0));
        txt_dateOfBirth.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        txt_dateOfBirth.setForeground(new java.awt.Color(255, 255, 255));
        txt_dateOfBirth.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(198, 160, 89)));

        txt_contact.setBackground(new java.awt.Color(0, 0, 0));
        txt_contact.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        txt_contact.setForeground(new java.awt.Color(255, 255, 255));
        txt_contact.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(198, 160, 89)));

        txt_salary.setBackground(new java.awt.Color(0, 0, 0));
        txt_salary.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        txt_salary.setForeground(new java.awt.Color(255, 255, 255));
        txt_salary.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(198, 160, 89)));
        txt_salary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_salaryActionPerformed(evt);
            }
        });

        txt_shiftTimings.setBackground(new java.awt.Color(0, 0, 0));
        txt_shiftTimings.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        txt_shiftTimings.setForeground(new java.awt.Color(255, 255, 255));
        txt_shiftTimings.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(198, 160, 89)));

        txt_designation.setBackground(new java.awt.Color(0, 0, 0));
        txt_designation.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        txt_designation.setForeground(new java.awt.Color(255, 255, 255));
        txt_designation.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(198, 160, 89)));

        lbl_addEmployeePicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Add Employee.png"))); // NOI18N

        javax.swing.GroupLayout pnl_addemployeeLayout = new javax.swing.GroupLayout(pnl_addemployee);
        pnl_addemployee.setLayout(pnl_addemployeeLayout);
        pnl_addemployeeLayout.setHorizontalGroup(
            pnl_addemployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_addemployeeLayout.createSequentialGroup()
                .addGroup(pnl_addemployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_addemployeeLayout.createSequentialGroup()
                        .addGroup(pnl_addemployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnl_addemployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pnl_addemployeeLayout.createSequentialGroup()
                                    .addGap(55, 55, 55)
                                    .addComponent(lbl_currentWithdrawHeading))
                                .addGroup(pnl_addemployeeLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(lbl_newAmountWithdrawHeading)))
                            .addGroup(pnl_addemployeeLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(pnl_addemployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(pnl_addemployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbl_newAmountWithdrawHeading2)
                                        .addGroup(pnl_addemployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lbl_newAmountWithdrawHeading3)
                                            .addComponent(lbl_newAmountWithdrawHeading1)
                                            .addComponent(lbl_newAmountWithdrawHeading5)
                                            .addComponent(lbl_newAmountWithdrawHeading13)))
                                    .addComponent(lbl_withdrawAmountHeading))))
                        .addGap(26, 26, 26)
                        .addGroup(pnl_addemployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_addemployeeLayout.createSequentialGroup()
                                .addGroup(pnl_addemployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_loginID, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmb_gender, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_employeeID, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_firstName, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_age, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_lastName, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(47, 47, 47)
                                .addGroup(pnl_addemployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnl_addemployeeLayout.createSequentialGroup()
                                        .addGroup(pnl_addemployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbl_newAmountWithdrawHeading6)
                                            .addComponent(lbl_newAmountWithdrawHeading8)
                                            .addComponent(lbl_newAmountWithdrawHeading4))
                                        .addGroup(pnl_addemployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(pnl_addemployeeLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addGroup(pnl_addemployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txt_address, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_addemployeeLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txt_contact, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(pnl_addemployeeLayout.createSequentialGroup()
                                        .addComponent(lbl_newAmountWithdrawHeading9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txt_shiftTimings, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnl_addemployeeLayout.createSequentialGroup()
                                        .addComponent(lbl_newAmountWithdrawHeading7)
                                        .addGap(18, 18, 18)
                                        .addComponent(txt_dateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(pnl_addemployeeLayout.createSequentialGroup()
                                        .addComponent(lbl_newAmountWithdrawHeading12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txt_designation, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnl_addemployeeLayout.createSequentialGroup()
                                        .addComponent(lbl_newAmountWithdrawHeading10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txt_salary, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(txt_cnic, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnl_addemployeeLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(lbl_headingWithdraw)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_addEmployeePicture, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_addemployeeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spr_seperatorWithdraw1)
                .addContainerGap())
            .addGroup(pnl_addemployeeLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(spr_seperatorWithdraw2)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_addemployeeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_addEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86))
        );
        pnl_addemployeeLayout.setVerticalGroup(
            pnl_addemployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_addemployeeLayout.createSequentialGroup()
                .addGroup(pnl_addemployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_headingWithdraw)
                    .addComponent(lbl_addEmployeePicture, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_addemployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_addemployeeLayout.createSequentialGroup()
                        .addComponent(spr_seperatorWithdraw1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(pnl_addemployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_currentWithdrawHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_loginID, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnl_addemployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_withdrawAmountHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_addemployeeLayout.createSequentialGroup()
                        .addGroup(pnl_addemployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_newAmountWithdrawHeading4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_contact, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnl_addemployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_newAmountWithdrawHeading8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addGroup(pnl_addemployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_addemployeeLayout.createSequentialGroup()
                        .addGroup(pnl_addemployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_newAmountWithdrawHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_employeeID, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(pnl_addemployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnl_addemployeeLayout.createSequentialGroup()
                                .addGroup(pnl_addemployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbl_newAmountWithdrawHeading2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_firstName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnl_addemployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbl_newAmountWithdrawHeading1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_lastName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnl_addemployeeLayout.createSequentialGroup()
                                .addGroup(pnl_addemployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbl_newAmountWithdrawHeading7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_dateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnl_addemployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbl_newAmountWithdrawHeading12, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_designation, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnl_addemployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_newAmountWithdrawHeading3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmb_gender, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_newAmountWithdrawHeading9, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_shiftTimings, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnl_addemployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_newAmountWithdrawHeading13, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_newAmountWithdrawHeading10, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_age, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_salary, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnl_addemployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_newAmountWithdrawHeading5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_cnic, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addComponent(spr_seperatorWithdraw2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl_addemployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_newAmountWithdrawHeading6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_address, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(btn_addEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(107, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnl_addEmployeeLayout = new javax.swing.GroupLayout(pnl_addEmployee);
        pnl_addEmployee.setLayout(pnl_addEmployeeLayout);
        pnl_addEmployeeLayout.setHorizontalGroup(
            pnl_addEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_addEmployeeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_addemployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_addEmployeeLayout.setVerticalGroup(
            pnl_addEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_addEmployeeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_addemployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl_applyIncrement.setBackground(new java.awt.Color(102, 102, 102));
        pnl_applyIncrement.setForeground(new java.awt.Color(255, 255, 255));

        pnl_applyIncrement2.setBackground(new java.awt.Color(102, 102, 102));

        lbl_headingWithdraw1.setBackground(new java.awt.Color(102, 102, 102));
        lbl_headingWithdraw1.setFont(new java.awt.Font("Sitka Heading", 1, 40)); // NOI18N
        lbl_headingWithdraw1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_headingWithdraw1.setText("Apply Increment");

        spr_seperatorWithdraw3.setBackground(new java.awt.Color(198, 160, 89));
        spr_seperatorWithdraw3.setOpaque(true);

        lbl_withdrawAmountHeading1.setBackground(new java.awt.Color(102, 102, 102));
        lbl_withdrawAmountHeading1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_withdrawAmountHeading1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_withdrawAmountHeading1.setText("Salary:");

        lbl_currentWithdrawHeading1.setBackground(new java.awt.Color(102, 102, 102));
        lbl_currentWithdrawHeading1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_currentWithdrawHeading1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_currentWithdrawHeading1.setText("EmployeeID:");

        lbl_currentSalary.setBackground(new java.awt.Color(0, 0, 0));
        lbl_currentSalary.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        lbl_currentSalary.setForeground(new java.awt.Color(255, 255, 255));
        lbl_currentSalary.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(198, 160, 89)));
        lbl_currentSalary.setOpaque(true);

        lbl_newAmountWithdrawHeading11.setBackground(new java.awt.Color(102, 102, 102));
        lbl_newAmountWithdrawHeading11.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_newAmountWithdrawHeading11.setForeground(new java.awt.Color(255, 255, 255));
        lbl_newAmountWithdrawHeading11.setText("New Salary:");

        spr_seperatorWithdraw4.setBackground(new java.awt.Color(198, 160, 89));
        spr_seperatorWithdraw4.setOpaque(true);

        btn_applyIncrement.setBackground(new java.awt.Color(102, 102, 102));
        btn_applyIncrement.setForeground(new java.awt.Color(255, 255, 255));
        btn_applyIncrement.setText("Apply");
        btn_applyIncrement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_applyIncrementActionPerformed(evt);
            }
        });

        txt_enteredEmployeeID.setBackground(new java.awt.Color(0, 0, 0));
        txt_enteredEmployeeID.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        txt_enteredEmployeeID.setForeground(new java.awt.Color(255, 255, 255));
        txt_enteredEmployeeID.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(198, 160, 89)));

        lbl_newSalary.setBackground(new java.awt.Color(0, 0, 0));
        lbl_newSalary.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        lbl_newSalary.setForeground(new java.awt.Color(255, 255, 255));
        lbl_newSalary.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(198, 160, 89)));
        lbl_newSalary.setOpaque(true);

        lbl_applyIncrementPicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Apply Increment.png"))); // NOI18N

        javax.swing.GroupLayout pnl_applyIncrement2Layout = new javax.swing.GroupLayout(pnl_applyIncrement2);
        pnl_applyIncrement2.setLayout(pnl_applyIncrement2Layout);
        pnl_applyIncrement2Layout.setHorizontalGroup(
            pnl_applyIncrement2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_applyIncrement2Layout.createSequentialGroup()
                .addGroup(pnl_applyIncrement2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_applyIncrement2Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addGroup(pnl_applyIncrement2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_applyIncrement2Layout.createSequentialGroup()
                                .addComponent(lbl_newAmountWithdrawHeading11)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_newSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbl_withdrawAmountHeading1)))
                    .addGroup(pnl_applyIncrement2Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(pnl_applyIncrement2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spr_seperatorWithdraw4, javax.swing.GroupLayout.PREFERRED_SIZE, 695, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spr_seperatorWithdraw3, javax.swing.GroupLayout.PREFERRED_SIZE, 695, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_applyIncrement2Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(pnl_applyIncrement2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnl_applyIncrement2Layout.createSequentialGroup()
                                .addComponent(lbl_currentWithdrawHeading1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_enteredEmployeeID, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbl_currentSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(293, 293, 293)))
                .addContainerGap(61, Short.MAX_VALUE))
            .addGroup(pnl_applyIncrement2Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(lbl_headingWithdraw1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_applyIncrementPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(203, 203, 203))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_applyIncrement2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_applyIncrement, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(241, 241, 241))
        );
        pnl_applyIncrement2Layout.setVerticalGroup(
            pnl_applyIncrement2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_applyIncrement2Layout.createSequentialGroup()
                .addGroup(pnl_applyIncrement2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_applyIncrement2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(lbl_headingWithdraw1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_applyIncrement2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbl_applyIncrementPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(spr_seperatorWithdraw3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnl_applyIncrement2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_enteredEmployeeID, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_currentWithdrawHeading1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(pnl_applyIncrement2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_withdrawAmountHeading1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_currentSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(pnl_applyIncrement2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_newAmountWithdrawHeading11, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_newSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(spr_seperatorWithdraw4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_applyIncrement, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnl_applyIncrementLayout = new javax.swing.GroupLayout(pnl_applyIncrement);
        pnl_applyIncrement.setLayout(pnl_applyIncrementLayout);
        pnl_applyIncrementLayout.setHorizontalGroup(
            pnl_applyIncrementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_applyIncrementLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(pnl_applyIncrement2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        pnl_applyIncrementLayout.setVerticalGroup(
            pnl_applyIncrementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_applyIncrementLayout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(pnl_applyIncrement2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
        );

        pnl_changeShiftTimings.setBackground(new java.awt.Color(207, 206, 206));

        pnl_changeShiftTimings2.setBackground(new java.awt.Color(102, 102, 102));
        pnl_changeShiftTimings2.setForeground(new java.awt.Color(255, 255, 255));

        lbl_headingWithdraw2.setFont(new java.awt.Font("Sitka Heading", 1, 40)); // NOI18N
        lbl_headingWithdraw2.setForeground(new java.awt.Color(255, 255, 255));
        lbl_headingWithdraw2.setText("Change Shift Timings");

        spr_seperatorWithdraw5.setBackground(new java.awt.Color(198, 160, 89));
        spr_seperatorWithdraw5.setOpaque(true);

        lbl_withdrawAmountHeading2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_withdrawAmountHeading2.setForeground(new java.awt.Color(255, 255, 255));
        lbl_withdrawAmountHeading2.setText("Current Timings:");

        lbl_currentWithdrawHeading2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_currentWithdrawHeading2.setForeground(new java.awt.Color(255, 255, 255));
        lbl_currentWithdrawHeading2.setText("EmployeeID:");

        lbl_currentTimings.setBackground(new java.awt.Color(0, 0, 0));
        lbl_currentTimings.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        lbl_currentTimings.setForeground(new java.awt.Color(255, 255, 255));
        lbl_currentTimings.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(198, 160, 89)));
        lbl_currentTimings.setOpaque(true);

        lbl_newAmountWithdrawHeading14.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_newAmountWithdrawHeading14.setForeground(new java.awt.Color(255, 255, 255));
        lbl_newAmountWithdrawHeading14.setText("New Timings:");

        spr_seperatorWithdraw6.setBackground(new java.awt.Color(198, 160, 89));
        spr_seperatorWithdraw6.setOpaque(true);

        btn_changeTimings.setBackground(new java.awt.Color(65, 67, 77));
        btn_changeTimings.setForeground(new java.awt.Color(255, 255, 255));
        btn_changeTimings.setText("Change Timings");
        btn_changeTimings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_changeTimingsActionPerformed(evt);
            }
        });

        txt_timingEmployeeID.setBackground(new java.awt.Color(0, 0, 0));
        txt_timingEmployeeID.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        txt_timingEmployeeID.setForeground(new java.awt.Color(255, 255, 255));
        txt_timingEmployeeID.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(198, 160, 89)));

        txt_newTimings.setBackground(new java.awt.Color(0, 0, 0));
        txt_newTimings.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        txt_newTimings.setForeground(new java.awt.Color(255, 255, 255));
        txt_newTimings.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(198, 160, 89)));

        btn_showCurrentTimings.setBackground(new java.awt.Color(65, 67, 77));
        btn_showCurrentTimings.setForeground(new java.awt.Color(255, 255, 255));
        btn_showCurrentTimings.setText("Show Current Timings");
        btn_showCurrentTimings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_showCurrentTimingsActionPerformed(evt);
            }
        });

        lbl_changeShiftTimingsPicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Shift Timings.png"))); // NOI18N

        javax.swing.GroupLayout pnl_changeShiftTimings2Layout = new javax.swing.GroupLayout(pnl_changeShiftTimings2);
        pnl_changeShiftTimings2.setLayout(pnl_changeShiftTimings2Layout);
        pnl_changeShiftTimings2Layout.setHorizontalGroup(
            pnl_changeShiftTimings2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_changeShiftTimings2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btn_showCurrentTimings)
                .addGap(18, 18, 18)
                .addComponent(btn_changeTimings, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
            .addGroup(pnl_changeShiftTimings2Layout.createSequentialGroup()
                .addGroup(pnl_changeShiftTimings2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_changeShiftTimings2Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(pnl_changeShiftTimings2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spr_seperatorWithdraw6, javax.swing.GroupLayout.PREFERRED_SIZE, 695, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spr_seperatorWithdraw5, javax.swing.GroupLayout.PREFERRED_SIZE, 695, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnl_changeShiftTimings2Layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addGroup(pnl_changeShiftTimings2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_currentWithdrawHeading2)
                            .addComponent(lbl_withdrawAmountHeading2)
                            .addComponent(lbl_newAmountWithdrawHeading14))
                        .addGap(29, 29, 29)
                        .addGroup(pnl_changeShiftTimings2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_newTimings, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnl_changeShiftTimings2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txt_timingEmployeeID, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbl_currentTimings, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(36, Short.MAX_VALUE))
            .addGroup(pnl_changeShiftTimings2Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(lbl_headingWithdraw2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_changeShiftTimingsPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97))
        );
        pnl_changeShiftTimings2Layout.setVerticalGroup(
            pnl_changeShiftTimings2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_changeShiftTimings2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_changeShiftTimings2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_headingWithdraw2)
                    .addComponent(lbl_changeShiftTimingsPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(spr_seperatorWithdraw5, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(pnl_changeShiftTimings2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_currentWithdrawHeading2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_timingEmployeeID, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnl_changeShiftTimings2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_withdrawAmountHeading2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_currentTimings, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnl_changeShiftTimings2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_newAmountWithdrawHeading14, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_newTimings, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(spr_seperatorWithdraw6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(pnl_changeShiftTimings2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_showCurrentTimings, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_changeTimings, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(137, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnl_changeShiftTimingsLayout = new javax.swing.GroupLayout(pnl_changeShiftTimings);
        pnl_changeShiftTimings.setLayout(pnl_changeShiftTimingsLayout);
        pnl_changeShiftTimingsLayout.setHorizontalGroup(
            pnl_changeShiftTimingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_changeShiftTimingsLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(pnl_changeShiftTimings2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );
        pnl_changeShiftTimingsLayout.setVerticalGroup(
            pnl_changeShiftTimingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_changeShiftTimingsLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(pnl_changeShiftTimings2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(103, Short.MAX_VALUE))
        );

        pnl_changePassword.setBackground(new java.awt.Color(207, 206, 206));

        pnl_changePassword2.setBackground(new java.awt.Color(102, 102, 102));

        lbl_headingWithdraw3.setBackground(new java.awt.Color(102, 102, 102));
        lbl_headingWithdraw3.setFont(new java.awt.Font("Sitka Heading", 1, 40)); // NOI18N
        lbl_headingWithdraw3.setForeground(new java.awt.Color(255, 255, 255));
        lbl_headingWithdraw3.setText("Change Password");

        spr_seperatorWithdraw7.setBackground(new java.awt.Color(198, 160, 89));
        spr_seperatorWithdraw7.setOpaque(true);

        lbl_currentWithdrawHeading3.setBackground(new java.awt.Color(102, 102, 102));
        lbl_currentWithdrawHeading3.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_currentWithdrawHeading3.setForeground(new java.awt.Color(255, 255, 255));
        lbl_currentWithdrawHeading3.setText("Admin ID:");

        lbl_newAmountWithdrawHeading15.setBackground(new java.awt.Color(102, 102, 102));
        lbl_newAmountWithdrawHeading15.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_newAmountWithdrawHeading15.setForeground(new java.awt.Color(255, 255, 255));
        lbl_newAmountWithdrawHeading15.setText("New Password:");

        spr_seperatorWithdraw8.setBackground(new java.awt.Color(198, 160, 89));
        spr_seperatorWithdraw8.setOpaque(true);

        btn_changePassword.setBackground(new java.awt.Color(102, 102, 102));
        btn_changePassword.setForeground(new java.awt.Color(255, 255, 255));
        btn_changePassword.setText("Change Password");
        btn_changePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_changePasswordActionPerformed(evt);
            }
        });

        txt_adminID.setBackground(new java.awt.Color(0, 0, 0));
        txt_adminID.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        txt_adminID.setForeground(new java.awt.Color(255, 255, 255));
        txt_adminID.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(198, 160, 89)));

        txt_newPassword.setBackground(new java.awt.Color(0, 0, 0));
        txt_newPassword.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        txt_newPassword.setForeground(new java.awt.Color(255, 255, 255));
        txt_newPassword.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(198, 160, 89)));

        lbl_passwordPicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Password.png"))); // NOI18N

        javax.swing.GroupLayout pnl_changePassword2Layout = new javax.swing.GroupLayout(pnl_changePassword2);
        pnl_changePassword2.setLayout(pnl_changePassword2Layout);
        pnl_changePassword2Layout.setHorizontalGroup(
            pnl_changePassword2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_changePassword2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btn_changePassword)
                .addGap(84, 84, 84))
            .addGroup(pnl_changePassword2Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(lbl_headingWithdraw3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_passwordPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(119, 119, 119))
            .addGroup(pnl_changePassword2Layout.createSequentialGroup()
                .addGroup(pnl_changePassword2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_changePassword2Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(pnl_changePassword2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spr_seperatorWithdraw8, javax.swing.GroupLayout.PREFERRED_SIZE, 695, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spr_seperatorWithdraw7, javax.swing.GroupLayout.PREFERRED_SIZE, 695, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnl_changePassword2Layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addGroup(pnl_changePassword2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_currentWithdrawHeading3)
                            .addComponent(lbl_newAmountWithdrawHeading15))
                        .addGap(29, 29, 29)
                        .addGroup(pnl_changePassword2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_newPassword)
                            .addComponent(txt_adminID, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        pnl_changePassword2Layout.setVerticalGroup(
            pnl_changePassword2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_changePassword2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_changePassword2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_passwordPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_headingWithdraw3))
                .addGap(18, 18, 18)
                .addComponent(spr_seperatorWithdraw7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(pnl_changePassword2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_currentWithdrawHeading3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_adminID, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(pnl_changePassword2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_newAmountWithdrawHeading15, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_newPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(spr_seperatorWithdraw8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_changePassword, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(146, 146, 146))
        );

        javax.swing.GroupLayout pnl_changePasswordLayout = new javax.swing.GroupLayout(pnl_changePassword);
        pnl_changePassword.setLayout(pnl_changePasswordLayout);
        pnl_changePasswordLayout.setHorizontalGroup(
            pnl_changePasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_changePasswordLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(pnl_changePassword2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );
        pnl_changePasswordLayout.setVerticalGroup(
            pnl_changePasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_changePasswordLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(pnl_changePassword2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnl_panel1Layout = new javax.swing.GroupLayout(pnl_panel1);
        pnl_panel1.setLayout(pnl_panel1Layout);
        pnl_panel1Layout.setHorizontalGroup(
            pnl_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_panel1Layout.createSequentialGroup()
                .addComponent(pnl_menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnl_header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnl_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_panel1Layout.createSequentialGroup()
                    .addGap(0, 200, Short.MAX_VALUE)
                    .addComponent(pnl_dashboard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(pnl_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_panel1Layout.createSequentialGroup()
                    .addGap(0, 210, Short.MAX_VALUE)
                    .addComponent(pnl_openAccount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(pnl_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_panel1Layout.createSequentialGroup()
                    .addGap(0, 233, Short.MAX_VALUE)
                    .addComponent(pnl_addAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(pnl_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_panel1Layout.createSequentialGroup()
                    .addGap(0, 224, Short.MAX_VALUE)
                    .addComponent(pnl_addEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(pnl_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_panel1Layout.createSequentialGroup()
                    .addGap(0, 223, Short.MAX_VALUE)
                    .addComponent(pnl_applyIncrement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(pnl_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_panel1Layout.createSequentialGroup()
                    .addGap(0, 239, Short.MAX_VALUE)
                    .addComponent(pnl_changeShiftTimings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(pnl_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_panel1Layout.createSequentialGroup()
                    .addGap(0, 235, Short.MAX_VALUE)
                    .addComponent(pnl_changePassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        pnl_panel1Layout.setVerticalGroup(
            pnl_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(pnl_menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnl_panel1Layout.createSequentialGroup()
                .addComponent(pnl_header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnl_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_panel1Layout.createSequentialGroup()
                    .addGap(0, 35, Short.MAX_VALUE)
                    .addComponent(pnl_dashboard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(pnl_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_panel1Layout.createSequentialGroup()
                    .addGap(0, 34, Short.MAX_VALUE)
                    .addComponent(pnl_openAccount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(pnl_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_panel1Layout.createSequentialGroup()
                    .addGap(0, 87, Short.MAX_VALUE)
                    .addComponent(pnl_addAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(pnl_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_panel1Layout.createSequentialGroup()
                    .addGap(0, 25, Short.MAX_VALUE)
                    .addComponent(pnl_addEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(pnl_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_panel1Layout.createSequentialGroup()
                    .addGap(0, 68, Short.MAX_VALUE)
                    .addComponent(pnl_applyIncrement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(pnl_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_panel1Layout.createSequentialGroup()
                    .addGap(0, 92, Short.MAX_VALUE)
                    .addComponent(pnl_changeShiftTimings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(pnl_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_panel1Layout.createSequentialGroup()
                    .addGap(0, 92, Short.MAX_VALUE)
                    .addComponent(pnl_changePassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_panel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1110, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_panel1, javax.swing.GroupLayout.DEFAULT_SIZE, 711, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_adminPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_adminPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_adminPasswordActionPerformed

    private void btn_addAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addAdminActionPerformed
        // TODO add your handling code here:
        Admin a = new Admin();
        String loginID = txt_adminLoginID.getText();
        String pass = txt_adminPassword.getText();

        boolean b = a.addAdmin(loginID, pass);
        if (b) {
            JOptionPane.showMessageDialog(null, "Admin Added");

        } else {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }//GEN-LAST:event_btn_addAdminActionPerformed

    private void btn_signOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_signOutActionPerformed
        Login log = new Login();
        log.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_signOutActionPerformed

    private void cmb_accountTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_accountTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_accountTypeActionPerformed

    private void cmb_accountHolderTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_accountHolderTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_accountHolderTypeActionPerformed

    private void txt_accountBalanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_accountBalanceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_accountBalanceActionPerformed

    private void cmb_martialStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_martialStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_martialStatusActionPerformed

    private void txt_occupationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_occupationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_occupationActionPerformed

    private void cmb_gender_oaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_gender_oaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_gender_oaActionPerformed

    private void btn_openAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_openAccountActionPerformed
        // TODO add your handling code here:
        Admin a = new Admin();
        String loginID = txt_loginID_oa.getText();
        String pass = txt_password_oa.getText();
        String firstName = txt_firstName_oa.getText();
        String lastName = txt_lastName_oa.getText();
        String gender = (String) cmb_gender_oa.getSelectedItem();
        String age = txt_age_oa.getText();
        String cnic = txt_cnic_oa.getText();
        String contact = txt_contact_oa.getText();
        String email = txt_email_oa.getText();
        String address = txt_address_oa.getText();
        String dateOfBirth = txt_dateOfBirth_oa.getText();
        String martialStatus = (String) cmb_martialStatus.getSelectedItem();
        String qualification = txt_qualification.getText();
        String occupation = txt_occupation.getText();
        String accountBalance = txt_accountBalance.getText();
        String accountType = (String) cmb_accountType.getSelectedItem();
        String accountHolderType = (String) cmb_accountHolderType.getSelectedItem();
        boolean b = a.openAccount(loginID, pass, firstName, lastName, gender, age, cnic, contact, email, address, dateOfBirth, martialStatus, qualification, occupation, accountBalance, accountType, accountHolderType);
        if (b) {
            JOptionPane.showMessageDialog(null, "Account Opened");
            a.add_customer_into_login();
        } else {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }//GEN-LAST:event_btn_openAccountActionPerformed

    private void txt_salaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_salaryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_salaryActionPerformed

    private void cmb_genderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_genderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_genderActionPerformed

    private void btn_addEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addEmployeeActionPerformed
        // TODO add your handling code here:
        Admin a = new Admin();
        String loginID = txt_loginID.getText();
        String pass = txt_password.getText();
        String employeeID = txt_employeeID.getText();
        String firstName = txt_firstName.getText();
        String lastName = txt_lastName.getText();
        String gender = (String) cmb_gender.getSelectedItem();
        String age = txt_age.getText();
        String cnic = txt_cnic.getText();
        String contact = txt_contact.getText();
        String email = txt_email.getText();
        String address = txt_address.getText();
        String dateOfBirth = txt_dateOfBirth.getText();
        String designation = txt_designation.getText();
        String shiftTimings = txt_shiftTimings.getText();
        String salary = txt_salary.getText();
        boolean b = a.addEmployee(loginID, pass, employeeID, firstName, lastName, gender, age, cnic, contact, email, address, dateOfBirth, designation, shiftTimings, salary);
        if (b) {
            JOptionPane.showMessageDialog(null, "Employee Added");
            a.add_employee_into_login();
        } else {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }//GEN-LAST:event_btn_addEmployeeActionPerformed

    private void btn_changePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_changePasswordActionPerformed
        // TODO add your handling code here:
        Admin ap = new Admin();
        String ID = txt_adminID.getText();
        String newPassword = txt_newPassword.getText();
        boolean b = ap.changePassword(ID, newPassword);

        if (b) {
            JOptionPane.showMessageDialog(null, "Password Changed");

        } else {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }//GEN-LAST:event_btn_changePasswordActionPerformed

    private void btn_showCurrentTimingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_showCurrentTimingsActionPerformed
        // TODO add your handling code here:
        Admin ap = new Admin();
        String BI = txt_timingEmployeeID.getText();
        boolean b = ap.changeShiftTimings(BI, "");

        if (b) {

            lbl_currentTimings.setText(ap.getCurrentTimings());
            //            lbl_newSalary.setText(ap.getI_newSalary());
            //            JOptionPane.showMessageDialog(null, "Increment Applied");

        } else {
            JOptionPane.showMessageDialog(null, "Not Found");
        }
    }//GEN-LAST:event_btn_showCurrentTimingsActionPerformed

    private void btn_changeTimingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_changeTimingsActionPerformed
        // TODO add your handling code here:
        Admin ap = new Admin();
        String ID = txt_timingEmployeeID.getText();
        String newTimings = txt_newTimings.getText();
        boolean b = ap.changeShiftTimings(ID, newTimings);

        if (b) {

            lbl_currentTimings.setText(ap.getCurrentTimings());

            JOptionPane.showMessageDialog(null, "Timings Updated");

        } else {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }//GEN-LAST:event_btn_changeTimingsActionPerformed

    private void btn_applyIncrementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_applyIncrementActionPerformed
        // TODO add your handling code here:
        Admin ap = new Admin();
        String BI = txt_enteredEmployeeID.getText();
        boolean b = ap.applyIncrement(BI);

        if (b) {

            lbl_currentSalary.setText("Rs. " + ap.getI_salary());
            lbl_newSalary.setText("Rs. " + ap.getI_newSalary());
            JOptionPane.showMessageDialog(null, "Increment Applied");

        } else {
            JOptionPane.showMessageDialog(null, "Not Found");
        }
    }//GEN-LAST:event_btn_applyIncrementActionPerformed




    //Refresh Functions
    public void RefreshIncrement() {
        lbl_currentSalary.setText("");
        lbl_newSalary.setText("");
        txt_enteredEmployeeID.setText("");
    }

    public void RefreshShiftTimings() {

        txt_timingEmployeeID.setText("");
        txt_newTimings.setText("");
        lbl_currentTimings.setText("");

    }

    public void RefreshChangePassword() {
        txt_adminID.setText("");
        txt_newPassword.setText("");

    }

    public void RefreshOpenAccount() {

        txt_loginID_oa.setText("");
        txt_password_oa.setText("");
        txt_firstName_oa.setText("");
        txt_lastName_oa.setText("");
        txt_age_oa.setText("");
        txt_cnic_oa.setText("");
        txt_contact_oa.setText("");
        txt_email_oa.setText("");
        txt_address_oa.setText("");
        txt_dateOfBirth_oa.setText("");
        txt_qualification.setText("");
        txt_occupation.setText("");
        txt_accountBalance.setText("");

    }
    
    public void RefreshAddAmin(){
        
        txt_adminLoginID.setText("");
        txt_adminPassword.setText("");
        
    }
    
    public void RefreshAddEmployee(){
        
        txt_loginID.setText("");
        txt_password.setText("");
        txt_employeeID.setText("");
        txt_firstName.setText("");
        txt_lastName.setText("");
        txt_age.setText("");
        txt_cnic.setText("");
        txt_contact.setText("");
        txt_email.setText("");
        txt_address.setText("");
        txt_dateOfBirth.setText("");
        txt_designation.setText("");
        txt_shiftTimings.setText("");
        txt_salary.setText("");
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {

            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_addAdmin;
    private javax.swing.JButton btn_addEmployee;
    private javax.swing.JButton btn_applyIncrement;
    private javax.swing.JButton btn_changePassword;
    private javax.swing.JButton btn_changeTimings;
    private javax.swing.JButton btn_openAccount;
    private javax.swing.JButton btn_showCurrentTimings;
    private javax.swing.JButton btn_signOut;
    private javax.swing.JComboBox cmb_accountHolderType;
    private javax.swing.JComboBox cmb_accountType;
    private javax.swing.JComboBox cmb_gender;
    private javax.swing.JComboBox cmb_gender_oa;
    private javax.swing.JComboBox cmb_martialStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbl_addAdmin;
    private javax.swing.JLabel lbl_addAdminPicture;
    private javax.swing.JLabel lbl_addEmployee;
    private javax.swing.JLabel lbl_addEmployeePicture;
    private javax.swing.JLabel lbl_applyIncrement;
    private javax.swing.JLabel lbl_applyIncrementPicture;
    private javax.swing.JLabel lbl_bankLogo;
    private javax.swing.JLabel lbl_changePassword;
    private javax.swing.JLabel lbl_changeShiftTimings;
    private javax.swing.JLabel lbl_changeShiftTimingsPicture;
    private javax.swing.JLabel lbl_currentSalary;
    private javax.swing.JLabel lbl_currentTimings;
    private javax.swing.JLabel lbl_currentWithdrawHeading;
    private javax.swing.JLabel lbl_currentWithdrawHeading1;
    private javax.swing.JLabel lbl_currentWithdrawHeading2;
    private javax.swing.JLabel lbl_currentWithdrawHeading3;
    private javax.swing.JLabel lbl_currentWithdrawHeading4;
    private javax.swing.JLabel lbl_currentWithdrawHeading5;
    private javax.swing.JLabel lbl_dashboard;
    private javax.swing.JLabel lbl_heading;
    private javax.swing.JLabel lbl_headingWithdraw;
    private javax.swing.JLabel lbl_headingWithdraw1;
    private javax.swing.JLabel lbl_headingWithdraw2;
    private javax.swing.JLabel lbl_headingWithdraw3;
    private javax.swing.JLabel lbl_headingWithdraw4;
    private javax.swing.JLabel lbl_headingWithdraw5;
    private javax.swing.JLabel lbl_logoHeading;
    private javax.swing.JLabel lbl_newAmountWithdrawHeading;
    private javax.swing.JLabel lbl_newAmountWithdrawHeading1;
    private javax.swing.JLabel lbl_newAmountWithdrawHeading10;
    private javax.swing.JLabel lbl_newAmountWithdrawHeading11;
    private javax.swing.JLabel lbl_newAmountWithdrawHeading12;
    private javax.swing.JLabel lbl_newAmountWithdrawHeading13;
    private javax.swing.JLabel lbl_newAmountWithdrawHeading14;
    private javax.swing.JLabel lbl_newAmountWithdrawHeading15;
    private javax.swing.JLabel lbl_newAmountWithdrawHeading16;
    private javax.swing.JLabel lbl_newAmountWithdrawHeading17;
    private javax.swing.JLabel lbl_newAmountWithdrawHeading18;
    private javax.swing.JLabel lbl_newAmountWithdrawHeading19;
    private javax.swing.JLabel lbl_newAmountWithdrawHeading2;
    private javax.swing.JLabel lbl_newAmountWithdrawHeading20;
    private javax.swing.JLabel lbl_newAmountWithdrawHeading21;
    private javax.swing.JLabel lbl_newAmountWithdrawHeading22;
    private javax.swing.JLabel lbl_newAmountWithdrawHeading23;
    private javax.swing.JLabel lbl_newAmountWithdrawHeading24;
    private javax.swing.JLabel lbl_newAmountWithdrawHeading25;
    private javax.swing.JLabel lbl_newAmountWithdrawHeading26;
    private javax.swing.JLabel lbl_newAmountWithdrawHeading27;
    private javax.swing.JLabel lbl_newAmountWithdrawHeading28;
    private javax.swing.JLabel lbl_newAmountWithdrawHeading29;
    private javax.swing.JLabel lbl_newAmountWithdrawHeading3;
    private javax.swing.JLabel lbl_newAmountWithdrawHeading30;
    private javax.swing.JLabel lbl_newAmountWithdrawHeading31;
    private javax.swing.JLabel lbl_newAmountWithdrawHeading4;
    private javax.swing.JLabel lbl_newAmountWithdrawHeading5;
    private javax.swing.JLabel lbl_newAmountWithdrawHeading6;
    private javax.swing.JLabel lbl_newAmountWithdrawHeading7;
    private javax.swing.JLabel lbl_newAmountWithdrawHeading8;
    private javax.swing.JLabel lbl_newAmountWithdrawHeading9;
    private javax.swing.JLabel lbl_newSalary;
    private javax.swing.JLabel lbl_openAccount;
    private javax.swing.JLabel lbl_openAccountPicture;
    private javax.swing.JLabel lbl_passwordPicture;
    private javax.swing.JLabel lbl_withdrawAmountHeading;
    private javax.swing.JLabel lbl_withdrawAmountHeading1;
    private javax.swing.JLabel lbl_withdrawAmountHeading2;
    private javax.swing.JLabel lbl_withdrawAmountHeading4;
    private javax.swing.JPanel pnl_addAdmin;
    private javax.swing.JPanel pnl_addAdmin2;
    private javax.swing.JPanel pnl_addEmployee;
    private javax.swing.JPanel pnl_addemployee;
    private javax.swing.JPanel pnl_applyIncrement;
    private javax.swing.JPanel pnl_applyIncrement2;
    private javax.swing.JPanel pnl_changePassword;
    private javax.swing.JPanel pnl_changePassword2;
    private javax.swing.JPanel pnl_changeShiftTimings;
    private javax.swing.JPanel pnl_changeShiftTimings2;
    private javax.swing.JPanel pnl_dashboard;
    private javax.swing.JPanel pnl_header;
    private javax.swing.JPanel pnl_menu;
    private javax.swing.JPanel pnl_openAccount;
    private javax.swing.JPanel pnl_openAccount2;
    private javax.swing.JPanel pnl_panel1;
    private javax.swing.JPanel pnl_titleAndLogo;
    private javax.swing.JSeparator spr_seperatorWithdraw1;
    private javax.swing.JSeparator spr_seperatorWithdraw10;
    private javax.swing.JSeparator spr_seperatorWithdraw11;
    private javax.swing.JSeparator spr_seperatorWithdraw12;
    private javax.swing.JSeparator spr_seperatorWithdraw2;
    private javax.swing.JSeparator spr_seperatorWithdraw3;
    private javax.swing.JSeparator spr_seperatorWithdraw4;
    private javax.swing.JSeparator spr_seperatorWithdraw5;
    private javax.swing.JSeparator spr_seperatorWithdraw6;
    private javax.swing.JSeparator spr_seperatorWithdraw7;
    private javax.swing.JSeparator spr_seperatorWithdraw8;
    private javax.swing.JSeparator spr_seperatorWithdraw9;
    private javax.swing.JTextField txt_accountBalance;
    private javax.swing.JTextField txt_address;
    private javax.swing.JTextField txt_address_oa;
    private javax.swing.JTextField txt_adminID;
    private javax.swing.JTextField txt_adminLoginID;
    private javax.swing.JTextField txt_adminPassword;
    private javax.swing.JTextField txt_age;
    private javax.swing.JTextField txt_age_oa;
    private javax.swing.JTextField txt_cnic;
    private javax.swing.JTextField txt_cnic_oa;
    private javax.swing.JTextField txt_contact;
    private javax.swing.JTextField txt_contact_oa;
    private javax.swing.JTextField txt_dateOfBirth;
    private javax.swing.JTextField txt_dateOfBirth_oa;
    private javax.swing.JTextField txt_designation;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_email_oa;
    private javax.swing.JTextField txt_employeeID;
    private javax.swing.JTextField txt_enteredEmployeeID;
    private javax.swing.JTextField txt_firstName;
    private javax.swing.JTextField txt_firstName_oa;
    private javax.swing.JTextField txt_lastName;
    private javax.swing.JTextField txt_lastName_oa;
    private javax.swing.JTextField txt_loginID;
    private javax.swing.JTextField txt_loginID_oa;
    private javax.swing.JTextField txt_newPassword;
    private javax.swing.JTextField txt_newTimings;
    private javax.swing.JTextField txt_occupation;
    private javax.swing.JTextField txt_password;
    private javax.swing.JTextField txt_password_oa;
    private javax.swing.JTextField txt_qualification;
    private javax.swing.JTextField txt_salary;
    private javax.swing.JTextField txt_shiftTimings;
    private javax.swing.JTextField txt_timingEmployeeID;
    // End of variables declaration//GEN-END:variables
}
