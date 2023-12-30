/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Employee;

import Connection.ConnectionToDB;
import Customer.*;
import Login.Login;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 *
 * @author Ahmed
 */
public class EmployeeDashboard extends javax.swing.JFrame {

    Employee employ = new Employee();
    ConnectionToDB con = new ConnectionToDB();
    Connection con_obj = con.EstablishConnection();

    Statement stmt = null;
    PreparedStatement pstmt = null;
    ResultSet res = null;
    /**
     * Creates new form Customer
     */
    Border default_border = BorderFactory.createMatteBorder(1, 0, 1, 0, new Color(36, 37, 42));
    Border golden_border = BorderFactory.createMatteBorder(1, 0, 1, 0, new Color(198, 160, 89));

    JLabel[] menuLabels = new JLabel[5];

    JPanel[] panels = new JPanel[5];
    private JPanel pnl_updateEmail;

    public EmployeeDashboard() {
        initComponents();

        menuLabels[0] = lbl_dashboard;
        menuLabels[1] = lbl_shiftTimings;
        menuLabels[2] = lbl_salaryPackage;
        menuLabels[3] = lbl_changePassword;
        menuLabels[4] = lbl_updateInformation;

        panels[0] = pnl_dashboard;
        panels[1] = pnl_shiftTimings;
        panels[2] = pnl_salaryPackage;
        panels[3] = pnl_changePassword;
        panels[4] = pnl_updateInformation;

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

                            case "View Shift Timings":
                                RefreshViewTimings();
                                showPanel(pnl_shiftTimings);
                                break;

                            case "View Salary Package":
                                RefreshViewSalary();
                                showPanel(pnl_salaryPackage);
                                break;

                            case "Change Password":
                                RefreshChangePassword();
                                showPanel(pnl_changePassword);

                                break;

                            case "Update Information":
                                RefreshUpdateInformation();
                                showPanel(pnl_updateInformation);

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
        lbl_shiftTimings = new javax.swing.JLabel();
        lbl_salaryPackage = new javax.swing.JLabel();
        lbl_changePassword = new javax.swing.JLabel();
        lbl_updateInformation = new javax.swing.JLabel();
        pnl_header = new javax.swing.JPanel();
        btn_signOut = new javax.swing.JButton();
        lbl_heading = new javax.swing.JLabel();
        pnl_dashboard = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pnl_shiftTimings = new javax.swing.JPanel();
        lbl_headingshiftTimings = new javax.swing.JLabel();
        lbl_IdSalary = new javax.swing.JLabel();
        txt_viewidloginTimings = new javax.swing.JTextField();
        lbl_shiftTimingsView = new javax.swing.JLabel();
        btn_viewTimings = new javax.swing.JButton();
        spr_seperatorWithdraw1 = new javax.swing.JSeparator();
        spr_seperatorWithdraw2 = new javax.swing.JSeparator();
        lbl_viewshifttimings = new javax.swing.JLabel();
        lbl_shiftTimingsPicture = new javax.swing.JLabel();
        pnl_salaryPackage = new javax.swing.JPanel();
        lbl_headingsalary = new javax.swing.JLabel();
        lbl_salary = new javax.swing.JLabel();
        btn_viewSalary = new javax.swing.JButton();
        lbl_salary1 = new javax.swing.JLabel();
        txt_viewidlogin = new javax.swing.JTextField();
        spr_seperatorWithdraw3 = new javax.swing.JSeparator();
        spr_seperatorWithdraw4 = new javax.swing.JSeparator();
        lbl_viewSalary = new javax.swing.JLabel();
        lbl_salarytPicture = new javax.swing.JLabel();
        pnl_changePassword = new javax.swing.JPanel();
        lbl_loginID = new javax.swing.JLabel();
        lbl_confirmnewpassword = new javax.swing.JLabel();
        lbl_newpassword1 = new javax.swing.JLabel();
        lbl_headingTransfer = new javax.swing.JLabel();
        btn_changepassword = new javax.swing.JButton();
        txt_loginID = new javax.swing.JTextField();
        txt_newpass = new javax.swing.JTextField();
        txt_confirmnewPass = new javax.swing.JTextField();
        spr_seperatorWithdraw5 = new javax.swing.JSeparator();
        spr_seperatorWithdraw6 = new javax.swing.JSeparator();
        lbl_passwordPicture = new javax.swing.JLabel();
        pnl_updateInformation = new javax.swing.JPanel();
        lbl_headingUpdateInformation = new javax.swing.JLabel();
        lbl_IdSalary1 = new javax.swing.JLabel();
        txt_updatelogin = new javax.swing.JTextField();
        lbl_updateEmail = new javax.swing.JLabel();
        lbl_UpdateAddress = new javax.swing.JLabel();
        lbl_UpdateContactNumber = new javax.swing.JLabel();
        txt_updateContactNumber = new javax.swing.JTextField();
        txt_UpdateEmail = new javax.swing.JTextField();
        txt_UpdateAddress = new javax.swing.JTextField();
        lbl_UpdateContactNumber1 = new javax.swing.JLabel();
        btn_updateInformation = new javax.swing.JButton();
        spr_seperatorWithdraw7 = new javax.swing.JSeparator();
        spr_seperatorWithdraw8 = new javax.swing.JSeparator();
        spr_seperatorWithdraw9 = new javax.swing.JSeparator();
        lbl_updateInformationPicture = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Employee Dashboard");
        setSize(new java.awt.Dimension(1100, 700));

        pnl_panel1.setBackground(new java.awt.Color(207, 206, 206));
        pnl_panel1.setPreferredSize(new java.awt.Dimension(1100, 700));

        pnl_menu.setBackground(new java.awt.Color(36, 37, 42));
        pnl_menu.setForeground(java.awt.Color.white);

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
        lbl_dashboard.setText("               Dashboard");
        lbl_dashboard.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_dashboard.setOpaque(true);

        lbl_shiftTimings.setBackground(new java.awt.Color(36, 37, 42));
        lbl_shiftTimings.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lbl_shiftTimings.setForeground(new java.awt.Color(255, 255, 255));
        lbl_shiftTimings.setText("         View Shift Timings");
        lbl_shiftTimings.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_shiftTimings.setOpaque(true);

        lbl_salaryPackage.setBackground(new java.awt.Color(36, 37, 42));
        lbl_salaryPackage.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lbl_salaryPackage.setForeground(new java.awt.Color(255, 255, 255));
        lbl_salaryPackage.setText("       View Salary Package");
        lbl_salaryPackage.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_salaryPackage.setOpaque(true);

        lbl_changePassword.setBackground(new java.awt.Color(36, 37, 42));
        lbl_changePassword.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lbl_changePassword.setForeground(new java.awt.Color(255, 255, 255));
        lbl_changePassword.setText("         Change Password");
        lbl_changePassword.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_changePassword.setOpaque(true);

        lbl_updateInformation.setBackground(new java.awt.Color(36, 37, 42));
        lbl_updateInformation.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lbl_updateInformation.setForeground(new java.awt.Color(255, 255, 255));
        lbl_updateInformation.setText("         Update Information");
        lbl_updateInformation.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_updateInformation.setOpaque(true);

        javax.swing.GroupLayout pnl_menuLayout = new javax.swing.GroupLayout(pnl_menu);
        pnl_menu.setLayout(pnl_menuLayout);
        pnl_menuLayout.setHorizontalGroup(
            pnl_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_titleAndLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbl_dashboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbl_shiftTimings, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbl_salaryPackage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbl_changePassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbl_updateInformation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnl_menuLayout.setVerticalGroup(
            pnl_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_menuLayout.createSequentialGroup()
                .addComponent(pnl_titleAndLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(lbl_dashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_shiftTimings, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_salaryPackage, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_changePassword, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_updateInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 314, Short.MAX_VALUE))
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
        lbl_heading.setText("Employee Dashboard");

        javax.swing.GroupLayout pnl_headerLayout = new javax.swing.GroupLayout(pnl_header);
        pnl_header.setLayout(pnl_headerLayout);
        pnl_headerLayout.setHorizontalGroup(
            pnl_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_headerLayout.createSequentialGroup()
                .addContainerGap(138, Short.MAX_VALUE)
                .addComponent(lbl_heading, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addComponent(btn_signOut)
                .addContainerGap())
        );
        pnl_headerLayout.setVerticalGroup(
            pnl_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_headerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_signOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_heading))
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

        pnl_shiftTimings.setBackground(new java.awt.Color(102, 102, 102));
        pnl_shiftTimings.setForeground(java.awt.Color.white);

        lbl_headingshiftTimings.setFont(new java.awt.Font("Sitka Heading", 1, 40)); // NOI18N
        lbl_headingshiftTimings.setForeground(java.awt.Color.white);
        lbl_headingshiftTimings.setText("View Shift Timings");

        lbl_IdSalary.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_IdSalary.setForeground(java.awt.Color.white);
        lbl_IdSalary.setText("Login ID:");
        lbl_IdSalary.setToolTipText("");

        txt_viewidloginTimings.setBackground(new java.awt.Color(0, 0, 0));
        txt_viewidloginTimings.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        txt_viewidloginTimings.setForeground(new java.awt.Color(255, 255, 255));
        txt_viewidloginTimings.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(198, 160, 89)));
        txt_viewidloginTimings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_viewidloginTimingsActionPerformed(evt);
            }
        });

        lbl_shiftTimingsView.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_shiftTimingsView.setForeground(java.awt.Color.white);
        lbl_shiftTimingsView.setText("Shift Timings:");
        lbl_shiftTimingsView.setToolTipText("");

        btn_viewTimings.setBackground(new java.awt.Color(65, 67, 77));
        btn_viewTimings.setForeground(java.awt.Color.white);
        btn_viewTimings.setText("View");
        btn_viewTimings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_viewTimingsActionPerformed(evt);
            }
        });

        spr_seperatorWithdraw1.setBackground(new java.awt.Color(198, 160, 89));
        spr_seperatorWithdraw1.setOpaque(true);

        spr_seperatorWithdraw2.setBackground(new java.awt.Color(198, 160, 89));
        spr_seperatorWithdraw2.setOpaque(true);

        lbl_viewshifttimings.setBackground(new java.awt.Color(0, 0, 0));
        lbl_viewshifttimings.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        lbl_viewshifttimings.setForeground(new java.awt.Color(255, 255, 255));
        lbl_viewshifttimings.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(198, 160, 89)));
        lbl_viewshifttimings.setOpaque(true);

        lbl_shiftTimingsPicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Shift Timings.png"))); // NOI18N

        javax.swing.GroupLayout pnl_shiftTimingsLayout = new javax.swing.GroupLayout(pnl_shiftTimings);
        pnl_shiftTimings.setLayout(pnl_shiftTimingsLayout);
        pnl_shiftTimingsLayout.setHorizontalGroup(
            pnl_shiftTimingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_shiftTimingsLayout.createSequentialGroup()
                .addGroup(pnl_shiftTimingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spr_seperatorWithdraw1, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spr_seperatorWithdraw2, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnl_shiftTimingsLayout.createSequentialGroup()
                        .addGroup(pnl_shiftTimingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_IdSalary)
                            .addComponent(lbl_shiftTimingsView))
                        .addGap(25, 25, 25)
                        .addGroup(pnl_shiftTimingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_viewidloginTimings, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                            .addComponent(lbl_viewshifttimings, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(0, 135, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_shiftTimingsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_viewTimings, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(206, 206, 206))
            .addGroup(pnl_shiftTimingsLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(lbl_headingshiftTimings)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_shiftTimingsPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(189, 189, 189))
        );
        pnl_shiftTimingsLayout.setVerticalGroup(
            pnl_shiftTimingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_shiftTimingsLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(pnl_shiftTimingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_headingshiftTimings)
                    .addComponent(lbl_shiftTimingsPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(spr_seperatorWithdraw1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(pnl_shiftTimingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_IdSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_viewidloginTimings, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnl_shiftTimingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_shiftTimingsView, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_viewshifttimings, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(spr_seperatorWithdraw2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_viewTimings, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(305, Short.MAX_VALUE))
        );

        pnl_salaryPackage.setBackground(new java.awt.Color(102, 102, 102));
        pnl_salaryPackage.setForeground(java.awt.Color.white);

        lbl_headingsalary.setFont(new java.awt.Font("Sitka Heading", 1, 40)); // NOI18N
        lbl_headingsalary.setForeground(java.awt.Color.white);
        lbl_headingsalary.setText("View Salary Package");

        lbl_salary.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_salary.setForeground(java.awt.Color.white);
        lbl_salary.setText("Salary Package:");
        lbl_salary.setToolTipText("");

        btn_viewSalary.setBackground(new java.awt.Color(65, 67, 77));
        btn_viewSalary.setForeground(java.awt.Color.white);
        btn_viewSalary.setText("View");
        btn_viewSalary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_viewSalaryActionPerformed(evt);
            }
        });

        lbl_salary1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_salary1.setForeground(java.awt.Color.white);
        lbl_salary1.setText("Login ID:");
        lbl_salary1.setToolTipText("");

        txt_viewidlogin.setBackground(new java.awt.Color(0, 0, 0));
        txt_viewidlogin.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        txt_viewidlogin.setForeground(new java.awt.Color(255, 255, 255));
        txt_viewidlogin.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(198, 160, 89)));
        txt_viewidlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_viewidloginActionPerformed(evt);
            }
        });

        spr_seperatorWithdraw3.setBackground(new java.awt.Color(198, 160, 89));
        spr_seperatorWithdraw3.setOpaque(true);

        spr_seperatorWithdraw4.setBackground(new java.awt.Color(198, 160, 89));
        spr_seperatorWithdraw4.setOpaque(true);

        lbl_viewSalary.setBackground(new java.awt.Color(0, 0, 0));
        lbl_viewSalary.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        lbl_viewSalary.setForeground(new java.awt.Color(255, 255, 255));
        lbl_viewSalary.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(198, 160, 89)));
        lbl_viewSalary.setOpaque(true);

        lbl_salarytPicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Apply Increment.png"))); // NOI18N

        javax.swing.GroupLayout pnl_salaryPackageLayout = new javax.swing.GroupLayout(pnl_salaryPackage);
        pnl_salaryPackage.setLayout(pnl_salaryPackageLayout);
        pnl_salaryPackageLayout.setHorizontalGroup(
            pnl_salaryPackageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_salaryPackageLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(pnl_salaryPackageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_salaryPackageLayout.createSequentialGroup()
                        .addGroup(pnl_salaryPackageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_salary)
                            .addComponent(lbl_salary1))
                        .addGap(44, 44, 44)
                        .addGroup(pnl_salaryPackageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_viewidlogin)
                            .addComponent(lbl_viewSalary, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(250, 250, 250))
                    .addGroup(pnl_salaryPackageLayout.createSequentialGroup()
                        .addComponent(lbl_headingsalary, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(167, 167, 167)
                        .addComponent(lbl_salarytPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(pnl_salaryPackageLayout.createSequentialGroup()
                .addComponent(spr_seperatorWithdraw3, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 135, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_salaryPackageLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_viewSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(182, 182, 182))
            .addGroup(pnl_salaryPackageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnl_salaryPackageLayout.createSequentialGroup()
                    .addComponent(spr_seperatorWithdraw4, javax.swing.GroupLayout.PREFERRED_SIZE, 732, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 133, Short.MAX_VALUE)))
        );
        pnl_salaryPackageLayout.setVerticalGroup(
            pnl_salaryPackageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_salaryPackageLayout.createSequentialGroup()
                .addGroup(pnl_salaryPackageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_salaryPackageLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(lbl_salarytPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_salaryPackageLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbl_headingsalary)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(spr_seperatorWithdraw3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(pnl_salaryPackageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_salary1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_viewidlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnl_salaryPackageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_salaryPackageLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl_salary, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_salaryPackageLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(lbl_viewSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(btn_viewSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(266, 266, 266))
            .addGroup(pnl_salaryPackageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnl_salaryPackageLayout.createSequentialGroup()
                    .addGap(286, 286, 286)
                    .addComponent(spr_seperatorWithdraw4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(317, Short.MAX_VALUE)))
        );

        pnl_changePassword.setBackground(new java.awt.Color(102, 102, 102));
        pnl_changePassword.setForeground(java.awt.Color.white);

        lbl_loginID.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_loginID.setForeground(java.awt.Color.white);
        lbl_loginID.setText("Login ID:");
        lbl_loginID.setToolTipText("");

        lbl_confirmnewpassword.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_confirmnewpassword.setForeground(java.awt.Color.white);
        lbl_confirmnewpassword.setText("Confirm New Password:");

        lbl_newpassword1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_newpassword1.setForeground(java.awt.Color.white);
        lbl_newpassword1.setText("New Password:");

        lbl_headingTransfer.setFont(new java.awt.Font("Sitka Heading", 1, 40)); // NOI18N
        lbl_headingTransfer.setForeground(java.awt.Color.white);
        lbl_headingTransfer.setText("Change Password");

        btn_changepassword.setBackground(new java.awt.Color(65, 67, 77));
        btn_changepassword.setForeground(java.awt.Color.white);
        btn_changepassword.setText("Submit");
        btn_changepassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_changepasswordActionPerformed(evt);
            }
        });

        txt_loginID.setBackground(new java.awt.Color(0, 0, 0));
        txt_loginID.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        txt_loginID.setForeground(new java.awt.Color(255, 255, 255));
        txt_loginID.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(198, 160, 89)));
        txt_loginID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_loginIDActionPerformed(evt);
            }
        });

        txt_newpass.setBackground(new java.awt.Color(0, 0, 0));
        txt_newpass.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        txt_newpass.setForeground(new java.awt.Color(255, 255, 255));
        txt_newpass.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(198, 160, 89)));

        txt_confirmnewPass.setBackground(new java.awt.Color(0, 0, 0));
        txt_confirmnewPass.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        txt_confirmnewPass.setForeground(new java.awt.Color(255, 255, 255));
        txt_confirmnewPass.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(198, 160, 89)));

        spr_seperatorWithdraw5.setBackground(new java.awt.Color(198, 160, 89));
        spr_seperatorWithdraw5.setOpaque(true);

        spr_seperatorWithdraw6.setBackground(new java.awt.Color(198, 160, 89));
        spr_seperatorWithdraw6.setOpaque(true);

        lbl_passwordPicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Password.png"))); // NOI18N

        javax.swing.GroupLayout pnl_changePasswordLayout = new javax.swing.GroupLayout(pnl_changePassword);
        pnl_changePassword.setLayout(pnl_changePasswordLayout);
        pnl_changePasswordLayout.setHorizontalGroup(
            pnl_changePasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_changePasswordLayout.createSequentialGroup()
                .addGroup(pnl_changePasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnl_changePasswordLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_changepassword, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl_changePasswordLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(pnl_changePasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_changePasswordLayout.createSequentialGroup()
                                .addComponent(lbl_headingTransfer)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbl_passwordPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13))
                            .addGroup(pnl_changePasswordLayout.createSequentialGroup()
                                .addGroup(pnl_changePasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbl_loginID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbl_confirmnewpassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbl_newpassword1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(52, 52, 52)
                                .addGroup(pnl_changePasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_loginID, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                                    .addComponent(txt_newpass)
                                    .addComponent(txt_confirmnewPass))))))
                .addGap(172, 172, 172))
            .addGroup(pnl_changePasswordLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spr_seperatorWithdraw5, javax.swing.GroupLayout.PREFERRED_SIZE, 736, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnl_changePasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnl_changePasswordLayout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(spr_seperatorWithdraw6, javax.swing.GroupLayout.PREFERRED_SIZE, 736, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(109, Short.MAX_VALUE)))
        );
        pnl_changePasswordLayout.setVerticalGroup(
            pnl_changePasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_changePasswordLayout.createSequentialGroup()
                .addGroup(pnl_changePasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_changePasswordLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(lbl_headingTransfer)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_changePasswordLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbl_passwordPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)))
                .addComponent(spr_seperatorWithdraw5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(pnl_changePasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_loginID, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_loginID, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(pnl_changePasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_newpassword1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_newpass, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnl_changePasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_confirmnewpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_confirmnewPass, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addComponent(btn_changepassword, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(207, 207, 207))
            .addGroup(pnl_changePasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnl_changePasswordLayout.createSequentialGroup()
                    .addGap(348, 348, 348)
                    .addComponent(spr_seperatorWithdraw6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(255, Short.MAX_VALUE)))
        );

        pnl_updateInformation.setBackground(new java.awt.Color(102, 102, 102));
        pnl_updateInformation.setForeground(java.awt.Color.white);

        lbl_headingUpdateInformation.setFont(new java.awt.Font("Sitka Heading", 1, 40)); // NOI18N
        lbl_headingUpdateInformation.setForeground(java.awt.Color.white);
        lbl_headingUpdateInformation.setText("Update Information");

        lbl_IdSalary1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_IdSalary1.setForeground(java.awt.Color.white);
        lbl_IdSalary1.setText("Login ID:");
        lbl_IdSalary1.setToolTipText("");

        txt_updatelogin.setBackground(new java.awt.Color(0, 0, 0));
        txt_updatelogin.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        txt_updatelogin.setForeground(new java.awt.Color(255, 255, 255));
        txt_updatelogin.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(198, 160, 89)));
        txt_updatelogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_updateloginActionPerformed(evt);
            }
        });

        lbl_updateEmail.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_updateEmail.setForeground(java.awt.Color.white);
        lbl_updateEmail.setText("Update Email:");
        lbl_updateEmail.setToolTipText("");

        lbl_UpdateAddress.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_UpdateAddress.setForeground(java.awt.Color.white);
        lbl_UpdateAddress.setText("Update Address:");
        lbl_UpdateAddress.setToolTipText("");

        lbl_UpdateContactNumber.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_UpdateContactNumber.setForeground(java.awt.Color.white);
        lbl_UpdateContactNumber.setText("Instructions: Fill the blank of only the field/fields you are willing to update.");
        lbl_UpdateContactNumber.setToolTipText("");

        txt_updateContactNumber.setBackground(new java.awt.Color(0, 0, 0));
        txt_updateContactNumber.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        txt_updateContactNumber.setForeground(new java.awt.Color(255, 255, 255));
        txt_updateContactNumber.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(198, 160, 89)));
        txt_updateContactNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_updateContactNumberActionPerformed(evt);
            }
        });

        txt_UpdateEmail.setBackground(new java.awt.Color(0, 0, 0));
        txt_UpdateEmail.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        txt_UpdateEmail.setForeground(new java.awt.Color(255, 255, 255));
        txt_UpdateEmail.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(198, 160, 89)));
        txt_UpdateEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_UpdateEmailActionPerformed(evt);
            }
        });

        txt_UpdateAddress.setBackground(new java.awt.Color(0, 0, 0));
        txt_UpdateAddress.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        txt_UpdateAddress.setForeground(new java.awt.Color(255, 255, 255));
        txt_UpdateAddress.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(198, 160, 89)));
        txt_UpdateAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_UpdateAddressActionPerformed(evt);
            }
        });

        lbl_UpdateContactNumber1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_UpdateContactNumber1.setForeground(java.awt.Color.white);
        lbl_UpdateContactNumber1.setText("Update Contact Number:");
        lbl_UpdateContactNumber1.setToolTipText("");

        btn_updateInformation.setBackground(new java.awt.Color(65, 67, 77));
        btn_updateInformation.setForeground(java.awt.Color.white);
        btn_updateInformation.setText("Update");
        btn_updateInformation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateInformationActionPerformed(evt);
            }
        });

        spr_seperatorWithdraw7.setBackground(new java.awt.Color(198, 160, 89));
        spr_seperatorWithdraw7.setOpaque(true);

        spr_seperatorWithdraw8.setBackground(new java.awt.Color(198, 160, 89));
        spr_seperatorWithdraw8.setOpaque(true);

        spr_seperatorWithdraw9.setBackground(new java.awt.Color(198, 160, 89));
        spr_seperatorWithdraw9.setOpaque(true);

        lbl_updateInformationPicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Information.png"))); // NOI18N

        javax.swing.GroupLayout pnl_updateInformationLayout = new javax.swing.GroupLayout(pnl_updateInformation);
        pnl_updateInformation.setLayout(pnl_updateInformationLayout);
        pnl_updateInformationLayout.setHorizontalGroup(
            pnl_updateInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_updateInformationLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_updateInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(151, 151, 151))
            .addGroup(pnl_updateInformationLayout.createSequentialGroup()
                .addGroup(pnl_updateInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnl_updateInformationLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txt_updatelogin, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnl_updateInformationLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(pnl_updateInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbl_IdSalary1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnl_updateInformationLayout.createSequentialGroup()
                                .addGroup(pnl_updateInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_UpdateAddress)
                                    .addGroup(pnl_updateInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbl_UpdateContactNumber1, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lbl_updateEmail)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnl_updateInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_UpdateAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                                    .addComponent(txt_UpdateEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                                    .addComponent(txt_updateContactNumber)))
                            .addGroup(pnl_updateInformationLayout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(lbl_UpdateContactNumber))
                            .addGroup(pnl_updateInformationLayout.createSequentialGroup()
                                .addComponent(lbl_headingUpdateInformation)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 255, Short.MAX_VALUE)
                                .addComponent(lbl_updateInformationPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)))))
                .addContainerGap(121, Short.MAX_VALUE))
            .addGroup(pnl_updateInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnl_updateInformationLayout.createSequentialGroup()
                    .addComponent(spr_seperatorWithdraw7, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 65, Short.MAX_VALUE)))
            .addGroup(pnl_updateInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnl_updateInformationLayout.createSequentialGroup()
                    .addComponent(spr_seperatorWithdraw8, javax.swing.GroupLayout.PREFERRED_SIZE, 798, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 67, Short.MAX_VALUE)))
            .addGroup(pnl_updateInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnl_updateInformationLayout.createSequentialGroup()
                    .addComponent(spr_seperatorWithdraw9, javax.swing.GroupLayout.PREFERRED_SIZE, 797, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 68, Short.MAX_VALUE)))
        );
        pnl_updateInformationLayout.setVerticalGroup(
            pnl_updateInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_updateInformationLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_updateInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_updateInformationLayout.createSequentialGroup()
                        .addComponent(lbl_updateInformationPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_updateInformationLayout.createSequentialGroup()
                        .addComponent(lbl_headingUpdateInformation)
                        .addGap(31, 31, 31)))
                .addGroup(pnl_updateInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_updatelogin, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_IdSalary1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(lbl_UpdateContactNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnl_updateInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_UpdateEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_updateEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnl_updateInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_updateContactNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_UpdateContactNumber1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnl_updateInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_UpdateAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_UpdateAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addComponent(btn_updateInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(129, Short.MAX_VALUE))
            .addGroup(pnl_updateInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnl_updateInformationLayout.createSequentialGroup()
                    .addGap(438, 438, 438)
                    .addComponent(spr_seperatorWithdraw7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(183, Short.MAX_VALUE)))
            .addGroup(pnl_updateInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_updateInformationLayout.createSequentialGroup()
                    .addContainerGap(182, Short.MAX_VALUE)
                    .addComponent(spr_seperatorWithdraw8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(439, 439, 439)))
            .addGroup(pnl_updateInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnl_updateInformationLayout.createSequentialGroup()
                    .addGap(105, 105, 105)
                    .addComponent(spr_seperatorWithdraw9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(516, Short.MAX_VALUE)))
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
                    .addGap(0, 235, Short.MAX_VALUE)
                    .addComponent(pnl_dashboard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(pnl_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_panel1Layout.createSequentialGroup()
                    .addGap(0, 235, Short.MAX_VALUE)
                    .addComponent(pnl_shiftTimings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(pnl_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_panel1Layout.createSequentialGroup()
                    .addGap(0, 235, Short.MAX_VALUE)
                    .addComponent(pnl_salaryPackage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(pnl_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_panel1Layout.createSequentialGroup()
                    .addGap(0, 235, Short.MAX_VALUE)
                    .addComponent(pnl_changePassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(pnl_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_panel1Layout.createSequentialGroup()
                    .addGap(0, 235, Short.MAX_VALUE)
                    .addComponent(pnl_updateInformation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        pnl_panel1Layout.setVerticalGroup(
            pnl_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(pnl_menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnl_panel1Layout.createSequentialGroup()
                .addComponent(pnl_header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnl_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_panel1Layout.createSequentialGroup()
                    .addGap(0, 95, Short.MAX_VALUE)
                    .addComponent(pnl_dashboard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(pnl_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_panel1Layout.createSequentialGroup()
                    .addGap(0, 95, Short.MAX_VALUE)
                    .addComponent(pnl_shiftTimings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(pnl_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_panel1Layout.createSequentialGroup()
                    .addGap(0, 95, Short.MAX_VALUE)
                    .addComponent(pnl_salaryPackage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(pnl_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_panel1Layout.createSequentialGroup()
                    .addGap(0, 95, Short.MAX_VALUE)
                    .addComponent(pnl_changePassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(pnl_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_panel1Layout.createSequentialGroup()
                    .addGap(0, 95, Short.MAX_VALUE)
                    .addComponent(pnl_updateInformation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_signOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_signOutActionPerformed

        Login log = new Login();
        log.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_signOutActionPerformed

    private void btn_changepasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_changepasswordActionPerformed

        String loginId = txt_loginID.getText();
        String new_Password = txt_newpass.getText();
        String confirm_pass = txt_confirmnewPass.getText();
        if (new_Password.equals(confirm_pass)) {
            boolean b = employ.ChangePassword(loginId, new_Password);
            if (b) {
                txt_loginID.setText(loginId);
                txt_newpass.setText(new_Password);
                JOptionPane.showMessageDialog(null, "Password Changed!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Failed Attempt.");
        }


    }//GEN-LAST:event_btn_changepasswordActionPerformed

    private void txt_loginIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_loginIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_loginIDActionPerformed

    private void btn_viewSalaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_viewSalaryActionPerformed
        // TODO add your handling code here:
        String id = txt_viewidlogin.getText();
        int salary = employ.ViewSalary(id);
        if (salary > 0) {
            String sal = String.valueOf(salary);
            lbl_viewSalary.setText("Rs. " + sal);
        } else {
            JOptionPane.showMessageDialog(null, "Failed Attempt.");
        }


    }//GEN-LAST:event_btn_viewSalaryActionPerformed

    private void txt_viewidloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_viewidloginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_viewidloginActionPerformed

    private void txt_viewidloginTimingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_viewidloginTimingsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_viewidloginTimingsActionPerformed

    private void btn_viewTimingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_viewTimingsActionPerformed
        // TODO add your handling code here:
        String id = txt_viewidloginTimings.getText();
        String shiftTimings = employ.ViewShiftTimings(id);

        lbl_viewshifttimings.setText(shiftTimings);


    }//GEN-LAST:event_btn_viewTimingsActionPerformed

    private void txt_updateloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_updateloginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_updateloginActionPerformed

    private void txt_updateContactNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_updateContactNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_updateContactNumberActionPerformed

    private void txt_UpdateEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_UpdateEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_UpdateEmailActionPerformed

    private void txt_UpdateAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_UpdateAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_UpdateAddressActionPerformed

    private void btn_updateInformationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateInformationActionPerformed
        // TODO add your handling code here:
        String loginId = txt_updatelogin.getText();
        String Email = txt_UpdateEmail.getText();
        String Contact = txt_updateContactNumber.getText();
        String Address = txt_UpdateAddress.getText();
        int t = Email.length();
        int c = Contact.length();
        int a = Address.length();
        if (t > 0) {
            boolean b = employ.UpdateEmail(loginId, Email);
            if (b) {
                txt_UpdateEmail.setText(Email);
                JOptionPane.showMessageDialog(null, "Updated!");
            }
        }
        if (c > 0) {
            boolean b = employ.UpdateContact(loginId, Contact);
            if (b) {
                txt_updateContactNumber.setText(Contact);
                JOptionPane.showMessageDialog(null, "Updated!");
            }
        }
        if (a > 0) {
            boolean b = employ.UpdateAddress(loginId, Address);
            if (b) {
                txt_UpdateAddress.setText(Address);
                JOptionPane.showMessageDialog(null, "Updated!");
            }
        }
    }//GEN-LAST:event_btn_updateInformationActionPerformed

    private void btn_viewSalary1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_viewSalary1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_viewSalary1ActionPerformed

    private void txt_viewidlogin1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_viewidlogin1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_viewidlogin1ActionPerformed

    //Refresh Functions
    public void RefreshViewSalary() {

        txt_viewidlogin.setText("");
        lbl_viewSalary.setText("");
    }

    public void RefreshViewTimings() {

        txt_viewidloginTimings.setText("");
        lbl_viewshifttimings.setText("");

    }

    public void RefreshChangePassword() {

        txt_loginID.setText("");
        txt_newpass.setText("");
        txt_confirmnewPass.setText("");

    }

    public void RefreshUpdateInformation() {

        txt_updatelogin.setText("");
        txt_UpdateEmail.setText("");
        txt_updateContactNumber.setText("");
        txt_UpdateAddress.setText("");

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
            java.util.logging.Logger.getLogger(EmployeeDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_changepassword;
    private javax.swing.JButton btn_signOut;
    private javax.swing.JButton btn_updateInformation;
    private javax.swing.JButton btn_viewSalary;
    private javax.swing.JButton btn_viewTimings;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbl_IdSalary;
    private javax.swing.JLabel lbl_IdSalary1;
    private javax.swing.JLabel lbl_UpdateAddress;
    private javax.swing.JLabel lbl_UpdateContactNumber;
    private javax.swing.JLabel lbl_UpdateContactNumber1;
    private javax.swing.JLabel lbl_bankLogo;
    private javax.swing.JLabel lbl_changePassword;
    private javax.swing.JLabel lbl_confirmnewpassword;
    private javax.swing.JLabel lbl_dashboard;
    private javax.swing.JLabel lbl_heading;
    private javax.swing.JLabel lbl_headingTransfer;
    private javax.swing.JLabel lbl_headingUpdateInformation;
    private javax.swing.JLabel lbl_headingsalary;
    private javax.swing.JLabel lbl_headingshiftTimings;
    private javax.swing.JLabel lbl_loginID;
    private javax.swing.JLabel lbl_logoHeading;
    private javax.swing.JLabel lbl_newpassword1;
    private javax.swing.JLabel lbl_passwordPicture;
    private javax.swing.JLabel lbl_salary;
    private javax.swing.JLabel lbl_salary1;
    private javax.swing.JLabel lbl_salaryPackage;
    private javax.swing.JLabel lbl_salarytPicture;
    private javax.swing.JLabel lbl_shiftTimings;
    private javax.swing.JLabel lbl_shiftTimingsPicture;
    private javax.swing.JLabel lbl_shiftTimingsView;
    private javax.swing.JLabel lbl_updateEmail;
    private javax.swing.JLabel lbl_updateInformation;
    private javax.swing.JLabel lbl_updateInformationPicture;
    private javax.swing.JLabel lbl_viewSalary;
    private javax.swing.JLabel lbl_viewshifttimings;
    private javax.swing.JPanel pnl_changePassword;
    private javax.swing.JPanel pnl_dashboard;
    private javax.swing.JPanel pnl_header;
    private javax.swing.JPanel pnl_menu;
    private javax.swing.JPanel pnl_panel1;
    private javax.swing.JPanel pnl_salaryPackage;
    private javax.swing.JPanel pnl_shiftTimings;
    private javax.swing.JPanel pnl_titleAndLogo;
    private javax.swing.JPanel pnl_updateInformation;
    private javax.swing.JSeparator spr_seperatorWithdraw1;
    private javax.swing.JSeparator spr_seperatorWithdraw2;
    private javax.swing.JSeparator spr_seperatorWithdraw3;
    private javax.swing.JSeparator spr_seperatorWithdraw4;
    private javax.swing.JSeparator spr_seperatorWithdraw5;
    private javax.swing.JSeparator spr_seperatorWithdraw6;
    private javax.swing.JSeparator spr_seperatorWithdraw7;
    private javax.swing.JSeparator spr_seperatorWithdraw8;
    private javax.swing.JSeparator spr_seperatorWithdraw9;
    private javax.swing.JTextField txt_UpdateAddress;
    private javax.swing.JTextField txt_UpdateEmail;
    private javax.swing.JTextField txt_confirmnewPass;
    private javax.swing.JTextField txt_loginID;
    private javax.swing.JTextField txt_newpass;
    private javax.swing.JTextField txt_updateContactNumber;
    private javax.swing.JTextField txt_updatelogin;
    private javax.swing.JTextField txt_viewidlogin;
    private javax.swing.JTextField txt_viewidloginTimings;
    // End of variables declaration//GEN-END:variables
}
