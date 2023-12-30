package Customer;

import Connection.ConnectionToDB;
import Login.Login;
import Transactions.Transactions;
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

public class CustomerDashboard extends javax.swing.JFrame {

    Border default_border = BorderFactory.createMatteBorder(1, 0, 1, 0, new Color(36, 37, 42));
    Border golden_border = BorderFactory.createMatteBorder(1, 0, 1, 0, new Color(198, 160, 89));

    JLabel[] menuLabels = new JLabel[6];
    JPanel[] panels = new JPanel[6];

    Customer cus_obj = new Customer();
    
    private static String loginId;
    private static String loginPassword;
    private static final String ROLE = "Customer";
    private static String firstName;
    private static String lastName;
    private static String gender;
    private static String cnic;
    private static String contact;
    private static String emailAddress;
    private static String dateOfBirth;
    private static String maritalStatus;
    private static String educationQualification;
    private static String occupation;
    private static String age;
    
    
    public static String getLoginId() {
        return loginId;
    }

    public static String getLoginPassword() {
        return loginPassword;
    }

    public static String getROLE() {
        return ROLE;
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

    public static String getDateOfBirth() {
        return dateOfBirth;
    }

    public static String getMaritalStatus() {
        return maritalStatus;
    }

    public static String getEducationQualification() {
        return educationQualification;
    }

    public static String getOccupation() {
        return occupation;
    }

    public static String getAge() {
        return age;
    }

    
    public static void setLoginId(String loginId) {
        CustomerDashboard.loginId = loginId;
    }

    public static void setLoginPassword(String loginPassword) {
        CustomerDashboard.loginPassword = loginPassword;
    }

    public static void setFirstName(String firstName) {
        CustomerDashboard.firstName = firstName;
    }

    public static void setLastName(String lastName) {
        CustomerDashboard.lastName = lastName;
    }

    public static void setGender(String gender) {
        CustomerDashboard.gender = gender;
    }

    public static void setCnic(String cnic) {
        CustomerDashboard.cnic = cnic;
    }

    public static void setContact(String contact) {
        CustomerDashboard.contact = contact;
    }

    public static void setEmailAddress(String emailAddress) {
        CustomerDashboard.emailAddress = emailAddress;
    }

    public static void setDateOfBirth(String dateOfBirth) {
        CustomerDashboard.dateOfBirth = dateOfBirth;
    }

    public static void setMaritalStatus(String maritalStatus) {
        CustomerDashboard.maritalStatus = maritalStatus;
    }

    public static void setEducationQualification(String educationQualification) {
        CustomerDashboard.educationQualification = educationQualification;
    }

    public static void setOccupation(String occupation) {
        CustomerDashboard.occupation = occupation;
    }

    public static void setAge(String age) {
        CustomerDashboard.age = age;
    }


    public CustomerDashboard() {
        initComponents();

        menuLabels[0] = lbl_dashboard;
        menuLabels[1] = lbl_depositAmount;
        menuLabels[2] = lbl_withdrawAmount;
        menuLabels[3] = lbl_transferFunds;
        menuLabels[4] = lbl_viewBalance;
        menuLabels[5] = lbl_updateInformation;

        panels[0] = pnl_dashboard;
        panels[1] = pnl_depositAmount;
        panels[2] = pnl_withdrawAmount1;
        panels[3] = pnl_transferFunds;
        panels[4] = pnl_viewBalance;
        panels[5] = pnl_updateInformation;

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

                            case "Deposit Amount":
                                cus_obj.getDetails(loginId);
                                RefreshDepositPage();
                                showPanel(pnl_depositAmount);

                                break;

                            case "Withdraw Amount":
                                cus_obj.getDetails(loginId);
                                RefreshWithdrawPage();
                                showPanel(pnl_withdrawAmount1);
                                break;

                            case "Transfer Funds":
                                cus_obj.getDetails(loginId);
                                RefreshTransferPage();
                                showPanel(pnl_transferFunds);

                                break;

                            case "View Balance":
                                cus_obj.getDetails(loginId);
                                ViewBalance();
                                showPanel(pnl_viewBalance);
                                break;

                            case "Update Information":
                                cus_obj.getDetails(loginId);
                                setInfo();
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
        lbl_depositAmount = new javax.swing.JLabel();
        lbl_withdrawAmount = new javax.swing.JLabel();
        lbl_transferFunds = new javax.swing.JLabel();
        lbl_viewBalance = new javax.swing.JLabel();
        lbl_updateInformation = new javax.swing.JLabel();
        pnl_header = new javax.swing.JPanel();
        btn_signOut = new javax.swing.JButton();
        lbl_heading = new javax.swing.JLabel();
        pnl_dashboard = new javax.swing.JPanel();
        lbl_dashboardImage = new javax.swing.JLabel();
        pnl_depositAmount = new javax.swing.JPanel();
        lbl_headingDeposit = new javax.swing.JLabel();
        spr_seperatorDeposit1 = new javax.swing.JSeparator();
        lbl_depositAmountHeading = new javax.swing.JLabel();
        lbl_currentDepositHeading = new javax.swing.JLabel();
        lbl_currentResult1 = new javax.swing.JLabel();
        lbl_newAmountDepositHeading = new javax.swing.JLabel();
        spr_seperatorDeposit2 = new javax.swing.JSeparator();
        btn_deposit = new javax.swing.JButton();
        txt_enteredDepositAmount = new javax.swing.JTextField();
        lbl_newAmountDeposit = new javax.swing.JLabel();
        lbl_depositDateHeading1 = new javax.swing.JLabel();
        txt_enteredDepositDate1 = new javax.swing.JTextField();
        lbl_depositAmountPicture = new javax.swing.JLabel();
        pnl_withdrawAmount1 = new javax.swing.JPanel();
        pnl_withdrawAmount2 = new javax.swing.JPanel();
        lbl_headingWithdraw = new javax.swing.JLabel();
        spr_seperatorWithdraw1 = new javax.swing.JSeparator();
        lbl_withdrawAmountHeading = new javax.swing.JLabel();
        lbl_currentWithdrawHeading = new javax.swing.JLabel();
        lbl_currentWithdrawResult = new javax.swing.JLabel();
        lbl_newAmountWithdrawHeading = new javax.swing.JLabel();
        spr_seperatorWithdraw2 = new javax.swing.JSeparator();
        btn_withdraw = new javax.swing.JButton();
        txt_enteredWithdrawAmount = new javax.swing.JTextField();
        lbl_newAmountWithdraw = new javax.swing.JLabel();
        lbl_withdrawDateHeading1 = new javax.swing.JLabel();
        txt_enteredWithdrawDate1 = new javax.swing.JTextField();
        lbl_withdrawAmountPicture = new javax.swing.JLabel();
        pnl_transferFunds = new javax.swing.JPanel();
        pnl_transferFunds2 = new javax.swing.JPanel();
        lbl_headingTransfer = new javax.swing.JLabel();
        spr_seperatorTransfer1 = new javax.swing.JSeparator();
        lbl_beneficiaryAccountHeading = new javax.swing.JLabel();
        lbl_currentTransferHeading = new javax.swing.JLabel();
        lbl_currentTransferResult = new javax.swing.JLabel();
        lbl_transferAmountHeading = new javax.swing.JLabel();
        spr_seperatorTransfer2 = new javax.swing.JSeparator();
        btn_transfer = new javax.swing.JButton();
        txt_beneficiaryAccountNumber = new javax.swing.JTextField();
        txt_enteredTransferAmount = new javax.swing.JTextField();
        lbl_transferFundsPicture = new javax.swing.JLabel();
        pnl_viewBalance = new javax.swing.JPanel();
        pnl_viewBalance2 = new javax.swing.JPanel();
        lbl_headingTransfer1 = new javax.swing.JLabel();
        spr_seperatorViewBalance1 = new javax.swing.JSeparator();
        lbl_currentViewBalanceHeading = new javax.swing.JLabel();
        lbl_currentViewBalanceResult = new javax.swing.JLabel();
        lbl_accountViewBalanceHeading = new javax.swing.JLabel();
        lbl_accountNumber = new javax.swing.JLabel();
        spr_seperatorViewBalance2 = new javax.swing.JSeparator();
        lbl_accountTypeResult = new javax.swing.JLabel();
        lbl_accountTypeHeading = new javax.swing.JLabel();
        lbl_branchCodeResult = new javax.swing.JLabel();
        lbl_branchCodeHeading = new javax.swing.JLabel();
        lbl_balancePicture = new javax.swing.JLabel();
        pnl_updateInformation = new javax.swing.JPanel();
        pnl_updateInformation1 = new javax.swing.JPanel();
        lbl_headingUpdateInformation = new javax.swing.JLabel();
        spr_seperatorDeposit3 = new javax.swing.JSeparator();
        lbl_updatePasswordtHeading = new javax.swing.JLabel();
        spr_seperatorDeposit4 = new javax.swing.JSeparator();
        btn_updateInformation = new javax.swing.JButton();
        txt_enteredPassword = new javax.swing.JTextField();
        lbl_updateFirstNametHeading = new javax.swing.JLabel();
        txt_enteredFirstName = new javax.swing.JTextField();
        lbl_updateLastNametHeading = new javax.swing.JLabel();
        txt_enteredLastName = new javax.swing.JTextField();
        lbl_updateContacttHeading = new javax.swing.JLabel();
        txt_enteredContact = new javax.swing.JTextField();
        lbl_updateOccupationHeading = new javax.swing.JLabel();
        txt_enteredOccupation = new javax.swing.JTextField();
        lbl_updateEmailtHeading = new javax.swing.JLabel();
        txt_enteredEmail = new javax.swing.JTextField();
        lbl_updateQualificationHeading = new javax.swing.JLabel();
        txt_enteredQualification = new javax.swing.JTextField();
        lbl_updateInformationPicture = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Customer Dashboard");
        setSize(new java.awt.Dimension(1100, 700));

        pnl_panel1.setBackground(new java.awt.Color(207, 206, 206));
        pnl_panel1.setPreferredSize(new java.awt.Dimension(1100, 700));

        pnl_menu.setBackground(new java.awt.Color(153, 153, 153));
        pnl_menu.setBorder(new javax.swing.border.MatteBorder(null));

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
        lbl_dashboard.setText("                 Dashboard");
        lbl_dashboard.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_dashboard.setOpaque(true);

        lbl_depositAmount.setBackground(new java.awt.Color(36, 37, 42));
        lbl_depositAmount.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lbl_depositAmount.setForeground(new java.awt.Color(255, 255, 255));
        lbl_depositAmount.setText("              Deposit Amount");
        lbl_depositAmount.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_depositAmount.setOpaque(true);

        lbl_withdrawAmount.setBackground(new java.awt.Color(36, 37, 42));
        lbl_withdrawAmount.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lbl_withdrawAmount.setForeground(new java.awt.Color(255, 255, 255));
        lbl_withdrawAmount.setText("             Withdraw Amount");
        lbl_withdrawAmount.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_withdrawAmount.setOpaque(true);

        lbl_transferFunds.setBackground(new java.awt.Color(36, 37, 42));
        lbl_transferFunds.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lbl_transferFunds.setForeground(new java.awt.Color(255, 255, 255));
        lbl_transferFunds.setText("              Transfer Funds");
        lbl_transferFunds.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_transferFunds.setOpaque(true);

        lbl_viewBalance.setBackground(new java.awt.Color(36, 37, 42));
        lbl_viewBalance.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lbl_viewBalance.setForeground(new java.awt.Color(255, 255, 255));
        lbl_viewBalance.setText("               View Balance");
        lbl_viewBalance.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_viewBalance.setOpaque(true);

        lbl_updateInformation.setBackground(new java.awt.Color(36, 37, 42));
        lbl_updateInformation.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lbl_updateInformation.setForeground(new java.awt.Color(255, 255, 255));
        lbl_updateInformation.setText("             Update Information");
        lbl_updateInformation.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_updateInformation.setOpaque(true);

        javax.swing.GroupLayout pnl_menuLayout = new javax.swing.GroupLayout(pnl_menu);
        pnl_menu.setLayout(pnl_menuLayout);
        pnl_menuLayout.setHorizontalGroup(
            pnl_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_titleAndLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbl_dashboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbl_depositAmount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbl_withdrawAmount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbl_transferFunds, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbl_viewBalance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbl_updateInformation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnl_menuLayout.setVerticalGroup(
            pnl_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_menuLayout.createSequentialGroup()
                .addComponent(pnl_titleAndLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(lbl_dashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_depositAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_withdrawAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_transferFunds, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_viewBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_updateInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 250, Short.MAX_VALUE))
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
        lbl_heading.setText("Customer Dashboard");

        javax.swing.GroupLayout pnl_headerLayout = new javax.swing.GroupLayout(pnl_header);
        pnl_header.setLayout(pnl_headerLayout);
        pnl_headerLayout.setHorizontalGroup(
            pnl_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_headerLayout.createSequentialGroup()
                .addContainerGap(133, Short.MAX_VALUE)
                .addComponent(lbl_heading, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79)
                .addComponent(btn_signOut)
                .addContainerGap())
        );
        pnl_headerLayout.setVerticalGroup(
            pnl_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_headerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_signOut)
                    .addComponent(lbl_heading))
                .addContainerGap())
        );

        pnl_dashboard.setBackground(new java.awt.Color(207, 206, 206));

        lbl_dashboardImage.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_dashboardImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dashboard bg.jpg"))); // NOI18N

        javax.swing.GroupLayout pnl_dashboardLayout = new javax.swing.GroupLayout(pnl_dashboard);
        pnl_dashboard.setLayout(pnl_dashboardLayout);
        pnl_dashboardLayout.setHorizontalGroup(
            pnl_dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_dashboardLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lbl_dashboardImage, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnl_dashboardLayout.setVerticalGroup(
            pnl_dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_dashboardImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnl_depositAmount.setBackground(new java.awt.Color(102, 102, 102));
        pnl_depositAmount.setForeground(java.awt.Color.white);

        lbl_headingDeposit.setFont(new java.awt.Font("Sitka Heading", 1, 40)); // NOI18N
        lbl_headingDeposit.setForeground(java.awt.Color.white);
        lbl_headingDeposit.setText("Deposit Amount");

        spr_seperatorDeposit1.setBackground(new java.awt.Color(198, 160, 89));
        spr_seperatorDeposit1.setOpaque(true);

        lbl_depositAmountHeading.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_depositAmountHeading.setForeground(java.awt.Color.white);
        lbl_depositAmountHeading.setText("Deposited Amount:");

        lbl_currentDepositHeading.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_currentDepositHeading.setForeground(java.awt.Color.white);
        lbl_currentDepositHeading.setText("Current Balance:");

        lbl_currentResult1.setBackground(new java.awt.Color(0, 0, 0));
        lbl_currentResult1.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        lbl_currentResult1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_currentResult1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(198, 160, 89)));
        lbl_currentResult1.setOpaque(true);

        lbl_newAmountDepositHeading.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_newAmountDepositHeading.setForeground(java.awt.Color.white);
        lbl_newAmountDepositHeading.setText("New Amount:");

        spr_seperatorDeposit2.setBackground(new java.awt.Color(198, 160, 89));
        spr_seperatorDeposit2.setOpaque(true);

        btn_deposit.setBackground(new java.awt.Color(65, 67, 77));
        btn_deposit.setForeground(java.awt.Color.white);
        btn_deposit.setText("Deposit");
        btn_deposit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_depositActionPerformed(evt);
            }
        });

        txt_enteredDepositAmount.setBackground(new java.awt.Color(0, 0, 0));
        txt_enteredDepositAmount.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        txt_enteredDepositAmount.setForeground(new java.awt.Color(255, 255, 255));
        txt_enteredDepositAmount.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(198, 160, 89)));
        txt_enteredDepositAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_enteredDepositAmountActionPerformed(evt);
            }
        });

        lbl_newAmountDeposit.setBackground(new java.awt.Color(0, 0, 0));
        lbl_newAmountDeposit.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        lbl_newAmountDeposit.setForeground(new java.awt.Color(255, 255, 255));
        lbl_newAmountDeposit.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(198, 160, 89)));
        lbl_newAmountDeposit.setOpaque(true);

        lbl_depositDateHeading1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_depositDateHeading1.setForeground(java.awt.Color.white);
        lbl_depositDateHeading1.setText("Deposit Date:");

        txt_enteredDepositDate1.setBackground(new java.awt.Color(0, 0, 0));
        txt_enteredDepositDate1.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        txt_enteredDepositDate1.setForeground(new java.awt.Color(255, 255, 255));
        txt_enteredDepositDate1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(198, 160, 89)));
        txt_enteredDepositDate1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_enteredDepositDate1FocusGained(evt);
            }
        });
        txt_enteredDepositDate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_enteredDepositDate1ActionPerformed(evt);
            }
        });

        lbl_depositAmountPicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Deposit Amount.png"))); // NOI18N

        javax.swing.GroupLayout pnl_depositAmountLayout = new javax.swing.GroupLayout(pnl_depositAmount);
        pnl_depositAmount.setLayout(pnl_depositAmountLayout);
        pnl_depositAmountLayout.setHorizontalGroup(
            pnl_depositAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_depositAmountLayout.createSequentialGroup()
                .addGroup(pnl_depositAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_depositAmountLayout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addGroup(pnl_depositAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_depositAmountHeading)
                            .addComponent(lbl_newAmountDepositHeading)
                            .addComponent(lbl_depositDateHeading1)
                            .addComponent(lbl_currentDepositHeading))
                        .addGap(18, 18, 18)
                        .addGroup(pnl_depositAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbl_currentResult1, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                            .addComponent(txt_enteredDepositAmount, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                            .addComponent(lbl_newAmountDeposit, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                            .addComponent(txt_enteredDepositDate1, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)))
                    .addGroup(pnl_depositAmountLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(pnl_depositAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnl_depositAmountLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(lbl_headingDeposit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbl_depositAmountPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(97, 97, 97))
                            .addGroup(pnl_depositAmountLayout.createSequentialGroup()
                                .addGroup(pnl_depositAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(spr_seperatorDeposit2, javax.swing.GroupLayout.PREFERRED_SIZE, 695, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(spr_seperatorDeposit1, javax.swing.GroupLayout.PREFERRED_SIZE, 695, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(44, 44, 44)))))
                .addContainerGap(95, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_depositAmountLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btn_deposit, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(184, 184, 184))
        );
        pnl_depositAmountLayout.setVerticalGroup(
            pnl_depositAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_depositAmountLayout.createSequentialGroup()
                .addGroup(pnl_depositAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_depositAmountLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(lbl_headingDeposit)
                        .addGap(31, 31, 31))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_depositAmountLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbl_depositAmountPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(spr_seperatorDeposit1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(pnl_depositAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_currentDepositHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_currentResult1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnl_depositAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_depositAmountHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_enteredDepositAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(pnl_depositAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_depositDateHeading1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_enteredDepositDate1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70)
                .addGroup(pnl_depositAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_newAmountDepositHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_newAmountDeposit, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addComponent(spr_seperatorDeposit2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_deposit, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(108, Short.MAX_VALUE))
        );

        pnl_withdrawAmount1.setBackground(new java.awt.Color(207, 206, 206));

        pnl_withdrawAmount2.setBackground(new java.awt.Color(102, 102, 102));

        lbl_headingWithdraw.setFont(new java.awt.Font("Sitka Heading", 1, 40)); // NOI18N
        lbl_headingWithdraw.setForeground(new java.awt.Color(255, 255, 255));
        lbl_headingWithdraw.setText("Withdraw Amount");

        spr_seperatorWithdraw1.setBackground(new java.awt.Color(198, 160, 89));
        spr_seperatorWithdraw1.setOpaque(true);

        lbl_withdrawAmountHeading.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_withdrawAmountHeading.setForeground(new java.awt.Color(255, 255, 255));
        lbl_withdrawAmountHeading.setText("Withdrawal Amount:");

        lbl_currentWithdrawHeading.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_currentWithdrawHeading.setForeground(new java.awt.Color(255, 255, 255));
        lbl_currentWithdrawHeading.setText("Current Balance:");

        lbl_currentWithdrawResult.setBackground(new java.awt.Color(0, 0, 0));
        lbl_currentWithdrawResult.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        lbl_currentWithdrawResult.setForeground(new java.awt.Color(255, 255, 255));
        lbl_currentWithdrawResult.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(198, 160, 89)));
        lbl_currentWithdrawResult.setOpaque(true);

        lbl_newAmountWithdrawHeading.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_newAmountWithdrawHeading.setForeground(new java.awt.Color(255, 255, 255));
        lbl_newAmountWithdrawHeading.setText("New Amount:");

        spr_seperatorWithdraw2.setBackground(new java.awt.Color(198, 160, 89));
        spr_seperatorWithdraw2.setOpaque(true);

        btn_withdraw.setBackground(new java.awt.Color(65, 67, 77));
        btn_withdraw.setForeground(new java.awt.Color(255, 255, 255));
        btn_withdraw.setText("Withdraw");
        btn_withdraw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_withdrawActionPerformed(evt);
            }
        });

        txt_enteredWithdrawAmount.setBackground(new java.awt.Color(0, 0, 0));
        txt_enteredWithdrawAmount.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        txt_enteredWithdrawAmount.setForeground(new java.awt.Color(255, 255, 255));
        txt_enteredWithdrawAmount.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(198, 160, 89)));
        txt_enteredWithdrawAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_enteredWithdrawAmountActionPerformed(evt);
            }
        });

        lbl_newAmountWithdraw.setBackground(new java.awt.Color(0, 0, 0));
        lbl_newAmountWithdraw.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        lbl_newAmountWithdraw.setForeground(new java.awt.Color(255, 255, 255));
        lbl_newAmountWithdraw.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(198, 160, 89)));
        lbl_newAmountWithdraw.setOpaque(true);

        lbl_withdrawDateHeading1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_withdrawDateHeading1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_withdrawDateHeading1.setText("Withdraw Date:");

        txt_enteredWithdrawDate1.setBackground(new java.awt.Color(0, 0, 0));
        txt_enteredWithdrawDate1.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        txt_enteredWithdrawDate1.setForeground(new java.awt.Color(255, 255, 255));
        txt_enteredWithdrawDate1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(198, 160, 89)));
        txt_enteredWithdrawDate1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_enteredWithdrawDate1FocusGained(evt);
            }
        });
        txt_enteredWithdrawDate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_enteredWithdrawDate1ActionPerformed(evt);
            }
        });

        lbl_withdrawAmountPicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Withdraw Amount.png"))); // NOI18N

        javax.swing.GroupLayout pnl_withdrawAmount2Layout = new javax.swing.GroupLayout(pnl_withdrawAmount2);
        pnl_withdrawAmount2.setLayout(pnl_withdrawAmount2Layout);
        pnl_withdrawAmount2Layout.setHorizontalGroup(
            pnl_withdrawAmount2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_withdrawAmount2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btn_withdraw, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(184, 184, 184))
            .addGroup(pnl_withdrawAmount2Layout.createSequentialGroup()
                .addGroup(pnl_withdrawAmount2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_withdrawAmount2Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addGroup(pnl_withdrawAmount2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_withdrawAmountHeading)
                            .addComponent(lbl_newAmountWithdrawHeading)
                            .addComponent(lbl_currentWithdrawHeading)
                            .addComponent(lbl_withdrawDateHeading1))
                        .addGap(18, 18, 18)
                        .addGroup(pnl_withdrawAmount2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbl_currentWithdrawResult, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                            .addComponent(txt_enteredWithdrawAmount)
                            .addComponent(lbl_newAmountWithdraw, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                            .addComponent(txt_enteredWithdrawDate1)))
                    .addGroup(pnl_withdrawAmount2Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(pnl_withdrawAmount2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spr_seperatorWithdraw2, javax.swing.GroupLayout.PREFERRED_SIZE, 695, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spr_seperatorWithdraw1, javax.swing.GroupLayout.PREFERRED_SIZE, 695, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnl_withdrawAmount2Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(lbl_headingWithdraw)
                        .addGap(192, 192, 192)
                        .addComponent(lbl_withdrawAmountPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(134, Short.MAX_VALUE))
        );
        pnl_withdrawAmount2Layout.setVerticalGroup(
            pnl_withdrawAmount2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_withdrawAmount2Layout.createSequentialGroup()
                .addGroup(pnl_withdrawAmount2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_withdrawAmount2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(lbl_headingWithdraw))
                    .addGroup(pnl_withdrawAmount2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbl_withdrawAmountPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(spr_seperatorWithdraw1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(pnl_withdrawAmount2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_currentWithdrawHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_currentWithdrawResult, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnl_withdrawAmount2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_withdrawAmountHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_enteredWithdrawAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(pnl_withdrawAmount2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_withdrawDateHeading1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_enteredWithdrawDate1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64)
                .addGroup(pnl_withdrawAmount2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_newAmountWithdrawHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_newAmountWithdraw, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addComponent(spr_seperatorWithdraw2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_withdraw, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(121, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnl_withdrawAmount1Layout = new javax.swing.GroupLayout(pnl_withdrawAmount1);
        pnl_withdrawAmount1.setLayout(pnl_withdrawAmount1Layout);
        pnl_withdrawAmount1Layout.setHorizontalGroup(
            pnl_withdrawAmount1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_withdrawAmount1Layout.createSequentialGroup()
                .addGap(0, 20, Short.MAX_VALUE)
                .addComponent(pnl_withdrawAmount2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnl_withdrawAmount1Layout.setVerticalGroup(
            pnl_withdrawAmount1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_withdrawAmount1Layout.createSequentialGroup()
                .addGap(0, 22, Short.MAX_VALUE)
                .addComponent(pnl_withdrawAmount2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnl_transferFunds.setBackground(new java.awt.Color(207, 206, 206));
        pnl_transferFunds.setForeground(java.awt.Color.white);

        pnl_transferFunds2.setBackground(new java.awt.Color(102, 102, 102));

        lbl_headingTransfer.setFont(new java.awt.Font("Sitka Heading", 1, 40)); // NOI18N
        lbl_headingTransfer.setForeground(java.awt.Color.white);
        lbl_headingTransfer.setText("Transfer Funds");

        spr_seperatorTransfer1.setBackground(new java.awt.Color(198, 160, 89));
        spr_seperatorTransfer1.setOpaque(true);

        lbl_beneficiaryAccountHeading.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_beneficiaryAccountHeading.setForeground(java.awt.Color.white);
        lbl_beneficiaryAccountHeading.setText("Beneficiary Account #:");

        lbl_currentTransferHeading.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_currentTransferHeading.setForeground(java.awt.Color.white);
        lbl_currentTransferHeading.setText("Current Balance:");

        lbl_currentTransferResult.setBackground(new java.awt.Color(0, 0, 0));
        lbl_currentTransferResult.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        lbl_currentTransferResult.setForeground(new java.awt.Color(255, 255, 255));
        lbl_currentTransferResult.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(198, 160, 89)));
        lbl_currentTransferResult.setOpaque(true);

        lbl_transferAmountHeading.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_transferAmountHeading.setForeground(java.awt.Color.white);
        lbl_transferAmountHeading.setText("Transfer Amount:");

        spr_seperatorTransfer2.setBackground(new java.awt.Color(198, 160, 89));
        spr_seperatorTransfer2.setOpaque(true);

        btn_transfer.setBackground(new java.awt.Color(65, 67, 77));
        btn_transfer.setForeground(java.awt.Color.white);
        btn_transfer.setText("Transfer");
        btn_transfer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_transferActionPerformed(evt);
            }
        });

        txt_beneficiaryAccountNumber.setBackground(new java.awt.Color(0, 0, 0));
        txt_beneficiaryAccountNumber.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        txt_beneficiaryAccountNumber.setForeground(new java.awt.Color(255, 255, 255));
        txt_beneficiaryAccountNumber.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(198, 160, 89)));

        txt_enteredTransferAmount.setBackground(new java.awt.Color(0, 0, 0));
        txt_enteredTransferAmount.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        txt_enteredTransferAmount.setForeground(new java.awt.Color(255, 255, 255));
        txt_enteredTransferAmount.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(198, 160, 89)));

        lbl_transferFundsPicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Transfer Funds.png"))); // NOI18N

        javax.swing.GroupLayout pnl_transferFunds2Layout = new javax.swing.GroupLayout(pnl_transferFunds2);
        pnl_transferFunds2.setLayout(pnl_transferFunds2Layout);
        pnl_transferFunds2Layout.setHorizontalGroup(
            pnl_transferFunds2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_transferFunds2Layout.createSequentialGroup()
                .addGroup(pnl_transferFunds2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_transferFunds2Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addGroup(pnl_transferFunds2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_beneficiaryAccountHeading)
                            .addComponent(lbl_transferAmountHeading))
                        .addGap(18, 18, 18)
                        .addGroup(pnl_transferFunds2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbl_currentTransferResult, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                            .addComponent(txt_beneficiaryAccountNumber)
                            .addComponent(txt_enteredTransferAmount)))
                    .addGroup(pnl_transferFunds2Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(pnl_transferFunds2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spr_seperatorTransfer2, javax.swing.GroupLayout.PREFERRED_SIZE, 695, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spr_seperatorTransfer1, javax.swing.GroupLayout.PREFERRED_SIZE, 695, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(134, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_transferFunds2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btn_transfer, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(184, 184, 184))
            .addGroup(pnl_transferFunds2Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(lbl_headingTransfer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_transferFundsPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(211, 211, 211))
            .addGroup(pnl_transferFunds2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnl_transferFunds2Layout.createSequentialGroup()
                    .addGap(86, 86, 86)
                    .addComponent(lbl_currentTransferHeading)
                    .addContainerGap(631, Short.MAX_VALUE)))
        );
        pnl_transferFunds2Layout.setVerticalGroup(
            pnl_transferFunds2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_transferFunds2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_transferFunds2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_transferFunds2Layout.createSequentialGroup()
                        .addComponent(lbl_transferFundsPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_transferFunds2Layout.createSequentialGroup()
                        .addComponent(lbl_headingTransfer)
                        .addGap(26, 26, 26)))
                .addComponent(spr_seperatorTransfer1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(lbl_currentTransferResult, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(pnl_transferFunds2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_beneficiaryAccountHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_beneficiaryAccountNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(86, 86, 86)
                .addGroup(pnl_transferFunds2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_transferAmountHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_enteredTransferAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addComponent(spr_seperatorTransfer2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_transfer, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(120, Short.MAX_VALUE))
            .addGroup(pnl_transferFunds2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnl_transferFunds2Layout.createSequentialGroup()
                    .addGap(173, 173, 173)
                    .addComponent(lbl_currentTransferHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(408, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout pnl_transferFundsLayout = new javax.swing.GroupLayout(pnl_transferFunds);
        pnl_transferFunds.setLayout(pnl_transferFundsLayout);
        pnl_transferFundsLayout.setHorizontalGroup(
            pnl_transferFundsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_transferFundsLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pnl_transferFunds2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnl_transferFundsLayout.setVerticalGroup(
            pnl_transferFundsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_transferFundsLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pnl_transferFunds2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnl_viewBalance.setBackground(new java.awt.Color(207, 206, 206));
        pnl_viewBalance.setForeground(java.awt.Color.white);

        pnl_viewBalance2.setBackground(new java.awt.Color(102, 102, 102));

        lbl_headingTransfer1.setFont(new java.awt.Font("Sitka Heading", 1, 40)); // NOI18N
        lbl_headingTransfer1.setForeground(java.awt.Color.white);
        lbl_headingTransfer1.setText("View Balance");

        spr_seperatorViewBalance1.setBackground(new java.awt.Color(198, 160, 89));
        spr_seperatorViewBalance1.setOpaque(true);

        lbl_currentViewBalanceHeading.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_currentViewBalanceHeading.setForeground(java.awt.Color.white);
        lbl_currentViewBalanceHeading.setText("Current Balance:");

        lbl_currentViewBalanceResult.setBackground(new java.awt.Color(0, 0, 0));
        lbl_currentViewBalanceResult.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        lbl_currentViewBalanceResult.setForeground(new java.awt.Color(255, 255, 255));
        lbl_currentViewBalanceResult.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(198, 160, 89)));
        lbl_currentViewBalanceResult.setOpaque(true);

        lbl_accountViewBalanceHeading.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_accountViewBalanceHeading.setForeground(java.awt.Color.white);
        lbl_accountViewBalanceHeading.setText("Account Number:");

        lbl_accountNumber.setBackground(new java.awt.Color(0, 0, 0));
        lbl_accountNumber.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        lbl_accountNumber.setForeground(new java.awt.Color(255, 255, 255));
        lbl_accountNumber.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(198, 160, 89)));
        lbl_accountNumber.setOpaque(true);

        spr_seperatorViewBalance2.setBackground(new java.awt.Color(198, 160, 89));
        spr_seperatorViewBalance2.setOpaque(true);

        lbl_accountTypeResult.setBackground(new java.awt.Color(0, 0, 0));
        lbl_accountTypeResult.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        lbl_accountTypeResult.setForeground(new java.awt.Color(255, 255, 255));
        lbl_accountTypeResult.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(198, 160, 89)));
        lbl_accountTypeResult.setOpaque(true);

        lbl_accountTypeHeading.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_accountTypeHeading.setForeground(java.awt.Color.white);
        lbl_accountTypeHeading.setText("Account Type:");

        lbl_branchCodeResult.setBackground(new java.awt.Color(0, 0, 0));
        lbl_branchCodeResult.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        lbl_branchCodeResult.setForeground(new java.awt.Color(255, 255, 255));
        lbl_branchCodeResult.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(198, 160, 89)));
        lbl_branchCodeResult.setOpaque(true);

        lbl_branchCodeHeading.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_branchCodeHeading.setForeground(java.awt.Color.white);
        lbl_branchCodeHeading.setText("Branch Code:");

        lbl_balancePicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Balance.png"))); // NOI18N

        javax.swing.GroupLayout pnl_viewBalance2Layout = new javax.swing.GroupLayout(pnl_viewBalance2);
        pnl_viewBalance2.setLayout(pnl_viewBalance2Layout);
        pnl_viewBalance2Layout.setHorizontalGroup(
            pnl_viewBalance2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_viewBalance2Layout.createSequentialGroup()
                .addGroup(pnl_viewBalance2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_viewBalance2Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(pnl_viewBalance2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spr_seperatorViewBalance2, javax.swing.GroupLayout.PREFERRED_SIZE, 695, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spr_seperatorViewBalance1, javax.swing.GroupLayout.PREFERRED_SIZE, 695, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnl_viewBalance2Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(pnl_viewBalance2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(pnl_viewBalance2Layout.createSequentialGroup()
                                .addComponent(lbl_accountTypeHeading)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbl_accountTypeResult, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnl_viewBalance2Layout.createSequentialGroup()
                                .addGroup(pnl_viewBalance2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_currentViewBalanceHeading)
                                    .addComponent(lbl_accountViewBalanceHeading))
                                .addGap(18, 18, 18)
                                .addGroup(pnl_viewBalance2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_accountNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_currentViewBalanceResult, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnl_viewBalance2Layout.createSequentialGroup()
                                .addComponent(lbl_branchCodeHeading)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbl_branchCodeResult, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(140, Short.MAX_VALUE))
            .addGroup(pnl_viewBalance2Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(lbl_headingTransfer1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_balancePicture, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(216, 216, 216))
        );
        pnl_viewBalance2Layout.setVerticalGroup(
            pnl_viewBalance2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_viewBalance2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(pnl_viewBalance2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_headingTransfer1)
                    .addComponent(lbl_balancePicture, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(spr_seperatorViewBalance1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(pnl_viewBalance2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_branchCodeHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_branchCodeResult, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnl_viewBalance2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_accountNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_accountViewBalanceHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(pnl_viewBalance2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_accountTypeHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_accountTypeResult, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72)
                .addGroup(pnl_viewBalance2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_currentViewBalanceHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_currentViewBalanceResult, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(spr_seperatorViewBalance2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(207, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnl_viewBalanceLayout = new javax.swing.GroupLayout(pnl_viewBalance);
        pnl_viewBalance.setLayout(pnl_viewBalanceLayout);
        pnl_viewBalanceLayout.setHorizontalGroup(
            pnl_viewBalanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_viewBalanceLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pnl_viewBalance2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnl_viewBalanceLayout.setVerticalGroup(
            pnl_viewBalanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_viewBalanceLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pnl_viewBalance2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnl_updateInformation.setBackground(new java.awt.Color(207, 206, 206));
        pnl_updateInformation.setForeground(java.awt.Color.white);

        pnl_updateInformation1.setBackground(new java.awt.Color(102, 102, 102));

        lbl_headingUpdateInformation.setFont(new java.awt.Font("Sitka Heading", 1, 40)); // NOI18N
        lbl_headingUpdateInformation.setForeground(java.awt.Color.white);
        lbl_headingUpdateInformation.setText("Update Information");

        spr_seperatorDeposit3.setBackground(new java.awt.Color(198, 160, 89));
        spr_seperatorDeposit3.setOpaque(true);

        lbl_updatePasswordtHeading.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_updatePasswordtHeading.setForeground(java.awt.Color.white);
        lbl_updatePasswordtHeading.setText("Password:");

        spr_seperatorDeposit4.setBackground(new java.awt.Color(198, 160, 89));
        spr_seperatorDeposit4.setOpaque(true);

        btn_updateInformation.setBackground(new java.awt.Color(65, 67, 77));
        btn_updateInformation.setForeground(java.awt.Color.white);
        btn_updateInformation.setText("Update");
        btn_updateInformation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateInformationActionPerformed(evt);
            }
        });

        txt_enteredPassword.setBackground(new java.awt.Color(0, 0, 0));
        txt_enteredPassword.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        txt_enteredPassword.setForeground(new java.awt.Color(255, 255, 255));
        txt_enteredPassword.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(198, 160, 89)));
        txt_enteredPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_enteredPasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_enteredPasswordFocusLost(evt);
            }
        });
        txt_enteredPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_enteredPasswordActionPerformed(evt);
            }
        });

        lbl_updateFirstNametHeading.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_updateFirstNametHeading.setForeground(java.awt.Color.white);
        lbl_updateFirstNametHeading.setText("First Name:");

        txt_enteredFirstName.setBackground(new java.awt.Color(0, 0, 0));
        txt_enteredFirstName.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        txt_enteredFirstName.setForeground(new java.awt.Color(255, 255, 255));
        txt_enteredFirstName.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(198, 160, 89)));
        txt_enteredFirstName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_enteredFirstNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_enteredFirstNameFocusLost(evt);
            }
        });
        txt_enteredFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_enteredFirstNameActionPerformed(evt);
            }
        });

        lbl_updateLastNametHeading.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_updateLastNametHeading.setForeground(java.awt.Color.white);
        lbl_updateLastNametHeading.setText("Last Name:");

        txt_enteredLastName.setBackground(new java.awt.Color(0, 0, 0));
        txt_enteredLastName.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        txt_enteredLastName.setForeground(new java.awt.Color(255, 255, 255));
        txt_enteredLastName.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(198, 160, 89)));
        txt_enteredLastName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_enteredLastNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_enteredLastNameFocusLost(evt);
            }
        });
        txt_enteredLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_enteredLastNameActionPerformed(evt);
            }
        });

        lbl_updateContacttHeading.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_updateContacttHeading.setForeground(java.awt.Color.white);
        lbl_updateContacttHeading.setText("Contact:");

        txt_enteredContact.setBackground(new java.awt.Color(0, 0, 0));
        txt_enteredContact.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        txt_enteredContact.setForeground(new java.awt.Color(255, 255, 255));
        txt_enteredContact.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(198, 160, 89)));
        txt_enteredContact.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_enteredContactFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_enteredContactFocusLost(evt);
            }
        });
        txt_enteredContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_enteredContactActionPerformed(evt);
            }
        });

        lbl_updateOccupationHeading.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_updateOccupationHeading.setForeground(java.awt.Color.white);
        lbl_updateOccupationHeading.setText("Occupation:");

        txt_enteredOccupation.setBackground(new java.awt.Color(0, 0, 0));
        txt_enteredOccupation.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        txt_enteredOccupation.setForeground(new java.awt.Color(255, 255, 255));
        txt_enteredOccupation.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(198, 160, 89)));
        txt_enteredOccupation.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_enteredOccupationFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_enteredOccupationFocusLost(evt);
            }
        });
        txt_enteredOccupation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_enteredOccupationActionPerformed(evt);
            }
        });

        lbl_updateEmailtHeading.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_updateEmailtHeading.setForeground(java.awt.Color.white);
        lbl_updateEmailtHeading.setText("Email:");

        txt_enteredEmail.setBackground(new java.awt.Color(0, 0, 0));
        txt_enteredEmail.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        txt_enteredEmail.setForeground(new java.awt.Color(255, 255, 255));
        txt_enteredEmail.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(198, 160, 89)));
        txt_enteredEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_enteredEmailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_enteredEmailFocusLost(evt);
            }
        });
        txt_enteredEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_enteredEmailActionPerformed(evt);
            }
        });

        lbl_updateQualificationHeading.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lbl_updateQualificationHeading.setForeground(java.awt.Color.white);
        lbl_updateQualificationHeading.setText("Qualification:");

        txt_enteredQualification.setBackground(new java.awt.Color(0, 0, 0));
        txt_enteredQualification.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        txt_enteredQualification.setForeground(new java.awt.Color(255, 255, 255));
        txt_enteredQualification.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(198, 160, 89)));
        txt_enteredQualification.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_enteredQualificationFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_enteredQualificationFocusLost(evt);
            }
        });
        txt_enteredQualification.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_enteredQualificationActionPerformed(evt);
            }
        });

        lbl_updateInformationPicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Information.png"))); // NOI18N

        javax.swing.GroupLayout pnl_updateInformation1Layout = new javax.swing.GroupLayout(pnl_updateInformation1);
        pnl_updateInformation1.setLayout(pnl_updateInformation1Layout);
        pnl_updateInformation1Layout.setHorizontalGroup(
            pnl_updateInformation1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_updateInformation1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_updateInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(111, 111, 111))
            .addGroup(pnl_updateInformation1Layout.createSequentialGroup()
                .addGroup(pnl_updateInformation1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(pnl_updateInformation1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnl_updateInformation1Layout.createSequentialGroup()
                            .addGap(42, 42, 42)
                            .addGroup(pnl_updateInformation1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pnl_updateInformation1Layout.createSequentialGroup()
                                    .addComponent(lbl_updateFirstNametHeading)
                                    .addGap(18, 18, 18)
                                    .addComponent(txt_enteredFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(pnl_updateInformation1Layout.createSequentialGroup()
                                    .addGroup(pnl_updateInformation1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbl_updatePasswordtHeading)
                                        .addComponent(lbl_updateLastNametHeading)
                                        .addComponent(lbl_updateContacttHeading))
                                    .addGap(21, 21, 21)
                                    .addGroup(pnl_updateInformation1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txt_enteredContact, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txt_enteredLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txt_enteredPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGap(18, 18, 18)
                            .addGroup(pnl_updateInformation1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(pnl_updateInformation1Layout.createSequentialGroup()
                                    .addComponent(lbl_updateOccupationHeading)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_enteredOccupation, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(pnl_updateInformation1Layout.createSequentialGroup()
                                    .addGroup(pnl_updateInformation1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(pnl_updateInformation1Layout.createSequentialGroup()
                                            .addComponent(lbl_updateQualificationHeading)
                                            .addGap(18, 18, Short.MAX_VALUE))
                                        .addGroup(pnl_updateInformation1Layout.createSequentialGroup()
                                            .addGap(0, 0, Short.MAX_VALUE)
                                            .addComponent(lbl_updateEmailtHeading)
                                            .addGap(73, 73, 73)))
                                    .addGroup(pnl_updateInformation1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txt_enteredEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txt_enteredQualification, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(pnl_updateInformation1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(pnl_updateInformation1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(spr_seperatorDeposit3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 836, Short.MAX_VALUE)
                                .addComponent(spr_seperatorDeposit4, javax.swing.GroupLayout.Alignment.LEADING))))
                    .addGroup(pnl_updateInformation1Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(lbl_headingUpdateInformation)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_updateInformationPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        pnl_updateInformation1Layout.setVerticalGroup(
            pnl_updateInformation1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_updateInformation1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_updateInformation1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_updateInformationPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_updateInformation1Layout.createSequentialGroup()
                        .addComponent(lbl_headingUpdateInformation)
                        .addGap(17, 17, 17)))
                .addGroup(pnl_updateInformation1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(pnl_updateInformation1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(txt_enteredEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(pnl_updateInformation1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_updateQualificationHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_enteredQualification, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnl_updateInformation1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_updateOccupationHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_enteredOccupation, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnl_updateInformation1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(spr_seperatorDeposit3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnl_updateInformation1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_updatePasswordtHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_enteredPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_updateEmailtHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnl_updateInformation1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_updateFirstNametHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_enteredFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnl_updateInformation1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_updateLastNametHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_enteredLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnl_updateInformation1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_updateContacttHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_enteredContact, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addComponent(spr_seperatorDeposit4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_updateInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(213, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnl_updateInformationLayout = new javax.swing.GroupLayout(pnl_updateInformation);
        pnl_updateInformation.setLayout(pnl_updateInformationLayout);
        pnl_updateInformationLayout.setHorizontalGroup(
            pnl_updateInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_updateInformationLayout.createSequentialGroup()
                .addComponent(pnl_updateInformation1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );
        pnl_updateInformationLayout.setVerticalGroup(
            pnl_updateInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_updateInformationLayout.createSequentialGroup()
                .addComponent(pnl_updateInformation1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 15, Short.MAX_VALUE))
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
                    .addGap(0, 214, Short.MAX_VALUE)
                    .addComponent(pnl_dashboard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(pnl_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_panel1Layout.createSequentialGroup()
                    .addGap(0, 235, Short.MAX_VALUE)
                    .addComponent(pnl_depositAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(pnl_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_panel1Layout.createSequentialGroup()
                    .addGap(0, 235, Short.MAX_VALUE)
                    .addComponent(pnl_withdrawAmount1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(pnl_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_panel1Layout.createSequentialGroup()
                    .addGap(0, 235, Short.MAX_VALUE)
                    .addComponent(pnl_transferFunds, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(pnl_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_panel1Layout.createSequentialGroup()
                    .addGap(0, 235, Short.MAX_VALUE)
                    .addComponent(pnl_viewBalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                    .addGap(0, 35, Short.MAX_VALUE)
                    .addComponent(pnl_dashboard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(pnl_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_panel1Layout.createSequentialGroup()
                    .addGap(0, 95, Short.MAX_VALUE)
                    .addComponent(pnl_depositAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(pnl_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_panel1Layout.createSequentialGroup()
                    .addGap(0, 95, Short.MAX_VALUE)
                    .addComponent(pnl_withdrawAmount1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(pnl_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_panel1Layout.createSequentialGroup()
                    .addGap(0, 95, Short.MAX_VALUE)
                    .addComponent(pnl_transferFunds, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(pnl_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_panel1Layout.createSequentialGroup()
                    .addGap(0, 93, Short.MAX_VALUE)
                    .addComponent(pnl_viewBalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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

    private void txt_enteredDepositAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_enteredDepositAmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_enteredDepositAmountActionPerformed

    private void btn_depositActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_depositActionPerformed
        // TODO add your handling code here:

        Double balance = Account.getAccountBalance();
        Double deposit = Double.parseDouble(txt_enteredDepositAmount.getText());
        Double postBalance = balance + deposit;
        String transactionDate = txt_enteredDepositDate1.getText();

        
        boolean B = cus_obj.DepositAmount(postBalance, deposit, transactionDate, loginId);
        if (B) {
            cus_obj.getDetails(loginId);
            lbl_newAmountDeposit.setText("Rs. " + String.valueOf(Account.getAccountBalance()));

            JOptionPane.showMessageDialog(null, "Amount Deposited");
        } else {
            JOptionPane.showMessageDialog(null, "Error");
        }


    }//GEN-LAST:event_btn_depositActionPerformed

    private void txt_enteredDepositDate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_enteredDepositDate1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_enteredDepositDate1ActionPerformed

    private void txt_enteredWithdrawAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_enteredWithdrawAmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_enteredWithdrawAmountActionPerformed

    private void txt_enteredWithdrawDate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_enteredWithdrawDate1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_enteredWithdrawDate1ActionPerformed

    private void btn_withdrawActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_withdrawActionPerformed
        // TODO add your handling code here:

        Double balance = Account.getAccountBalance();
        Double withdraw = Double.parseDouble(txt_enteredWithdrawAmount.getText());
        Double postBalance = balance - withdraw;
        String transactionDate = txt_enteredWithdrawDate1.getText();

        if(withdraw>balance){
            JOptionPane.showMessageDialog(null,"Insufficient Balance.");
        }
        else{
        boolean B = cus_obj.WithdrawAmount(postBalance, withdraw, transactionDate, loginId);
        if (B) {
            cus_obj.getDetails(loginId);
            lbl_newAmountWithdraw.setText("Rs. " + String.valueOf(Account.getAccountBalance()));

            JOptionPane.showMessageDialog(null, "Amount Withdrawn");
        } else {
            JOptionPane.showMessageDialog(null, "Error");
        }

        }
    }//GEN-LAST:event_btn_withdrawActionPerformed

    private void txt_enteredDepositDate1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_enteredDepositDate1FocusGained

        if (txt_enteredDepositDate1.getText().equals("DD-MM-YYYY")) {
            txt_enteredDepositDate1.setText(null);

        }
    }//GEN-LAST:event_txt_enteredDepositDate1FocusGained

    private void txt_enteredWithdrawDate1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_enteredWithdrawDate1FocusGained
        if (txt_enteredWithdrawDate1.getText().equals("DD-MM-YYYY")) {
            txt_enteredWithdrawDate1.setText(null);
        }
    }//GEN-LAST:event_txt_enteredWithdrawDate1FocusGained

    private void btn_transferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_transferActionPerformed
         String beneficiaryAccountNumber = txt_beneficiaryAccountNumber.getText();
    Double balance = Account.getAccountBalance();
    Double transferAmount = Double.parseDouble(txt_enteredTransferAmount.getText());
    Double postBalance = balance - transferAmount;

    cus_obj.setBeneficiaryAmount(beneficiaryAccountNumber);

    Double beneficiaryBalance = Transactions.getBeneficiaryAmount();
    Double beneficiaryPostBalance = beneficiaryBalance + transferAmount;

//    boolean A = false;
    boolean B = false;

    if (transferAmount > balance) 
    {
        JOptionPane.showMessageDialog(null, "Insufficient Balance.");
    }
    else 
    {
    boolean A = cus_obj.FundReciever(beneficiaryPostBalance, beneficiaryAccountNumber);
        if (!A) 
        {
            JOptionPane.showMessageDialog(null, "Beneficiary Account not found.");
        } else 
        {
            B = cus_obj.FundSender(postBalance, loginId);
            if (B)
            {
                cus_obj.getDetails(loginId);
                JOptionPane.showMessageDialog(null, "Amount Transferred");
            } 
//            else {
//                JOptionPane.showMessageDialog(null, "Error");
//            }
        }
    }


        
        
    }//GEN-LAST:event_btn_transferActionPerformed

    public void setInfo(){
      
       txt_enteredPassword.setText(loginPassword);
       txt_enteredFirstName.setText(firstName); 
       txt_enteredLastName.setText(lastName); 
       txt_enteredContact.setText(contact); 
       txt_enteredEmail.setText(emailAddress);
       txt_enteredQualification.setText(educationQualification);
       txt_enteredOccupation.setText(occupation);
        
        
    }
    
    private void btn_updateInformationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateInformationActionPerformed

       String updatedPassword = txt_enteredPassword.getText();
       String updatedFirstName = txt_enteredFirstName.getText(); 
       String updatedLastName = txt_enteredLastName.getText(); 
       String updatedContact = txt_enteredContact.getText(); 
       String updatedEmail = txt_enteredEmail.getText();
       String updatedQualification = txt_enteredQualification.getText();
       String updatedOccupation = txt_enteredOccupation.getText();
       
       boolean b = cus_obj.UpdateInformation(updatedPassword, updatedFirstName, updatedLastName, updatedContact, updatedEmail, updatedQualification, updatedOccupation, loginId);
       
       if (b) {
            cus_obj.getDetails(loginId);
            JOptionPane.showMessageDialog(null, "Updated");
        } else {
            JOptionPane.showMessageDialog(null, "Error");
        } 
       
    }//GEN-LAST:event_btn_updateInformationActionPerformed

    private void txt_enteredPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_enteredPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_enteredPasswordActionPerformed

    private void txt_enteredFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_enteredFirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_enteredFirstNameActionPerformed

    private void txt_enteredLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_enteredLastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_enteredLastNameActionPerformed

    private void txt_enteredContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_enteredContactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_enteredContactActionPerformed

    private void txt_enteredOccupationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_enteredOccupationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_enteredOccupationActionPerformed

    private void txt_enteredEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_enteredEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_enteredEmailActionPerformed

    private void txt_enteredQualificationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_enteredQualificationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_enteredQualificationActionPerformed

    private void txt_enteredPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_enteredPasswordFocusGained
        // TODO add your handling code here:
        if (txt_enteredPassword.getText().equals(loginPassword)){
            txt_enteredPassword.setText(null);
        } 
    }//GEN-LAST:event_txt_enteredPasswordFocusGained

    private void txt_enteredPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_enteredPasswordFocusLost
        // TODO add your handling code here:
         if(txt_enteredPassword.getText().equals("")){
             txt_enteredPassword.setText(loginPassword);
         }
    }//GEN-LAST:event_txt_enteredPasswordFocusLost

    private void txt_enteredFirstNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_enteredFirstNameFocusGained
        // TODO add your handling code here:
        if (txt_enteredFirstName.getText().equals(firstName)){
            txt_enteredFirstName.setText(null);
        }
    }//GEN-LAST:event_txt_enteredFirstNameFocusGained

    private void txt_enteredFirstNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_enteredFirstNameFocusLost
        // TODO add your handling code here:
        if (txt_enteredFirstName.getText().equals("")){
            txt_enteredFirstName.setText(firstName);
        }
    }//GEN-LAST:event_txt_enteredFirstNameFocusLost

    private void txt_enteredLastNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_enteredLastNameFocusGained
        // TODO add your handling code here:
        if (txt_enteredLastName.getText().equals(lastName)){
            txt_enteredLastName.setText(null);
        }
    }//GEN-LAST:event_txt_enteredLastNameFocusGained

    private void txt_enteredLastNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_enteredLastNameFocusLost
        // TODO add your handling code here:
        if (txt_enteredLastName.getText().equals("")){
            txt_enteredLastName.setText(lastName);
        }
    }//GEN-LAST:event_txt_enteredLastNameFocusLost

    private void txt_enteredContactFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_enteredContactFocusGained
        // TODO add your handling code here:
        if (txt_enteredContact.getText().equals(contact)){
            txt_enteredContact.setText(null);
        }
    }//GEN-LAST:event_txt_enteredContactFocusGained

    private void txt_enteredContactFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_enteredContactFocusLost
        // TODO add your handling code here:
        if (txt_enteredContact.getText().equals("")){
            txt_enteredContact.setText(contact);
        }
    }//GEN-LAST:event_txt_enteredContactFocusLost

    private void txt_enteredEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_enteredEmailFocusGained
        // TODO add your handling code here:
        if (txt_enteredEmail.getText().equals(emailAddress)){
            txt_enteredEmail.setText(null);
        }
    }//GEN-LAST:event_txt_enteredEmailFocusGained

    private void txt_enteredEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_enteredEmailFocusLost
        // TODO add your handling code here:
        if (txt_enteredEmail.getText().equals("")){
            txt_enteredEmail.setText(emailAddress);
        }
    }//GEN-LAST:event_txt_enteredEmailFocusLost

    private void txt_enteredQualificationFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_enteredQualificationFocusGained
        // TODO add your handling code here:
        
        if (txt_enteredQualification.getText().equals(educationQualification)){
            txt_enteredQualification.setText(null);
        }
    }//GEN-LAST:event_txt_enteredQualificationFocusGained

    private void txt_enteredQualificationFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_enteredQualificationFocusLost
        // TODO add your handling code here:
        
        if (txt_enteredQualification.getText().equals("")){
            txt_enteredQualification.setText(educationQualification);
        }
    }//GEN-LAST:event_txt_enteredQualificationFocusLost

    private void txt_enteredOccupationFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_enteredOccupationFocusGained
        // TODO add your handling code here:
        
        if (txt_enteredOccupation.getText().equals(occupation)){
            txt_enteredQualification.setText(null);
        }
    }//GEN-LAST:event_txt_enteredOccupationFocusGained

    private void txt_enteredOccupationFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_enteredOccupationFocusLost
        // TODO add your handling code here:
        if (txt_enteredOccupation.getText().equals("")){
            txt_enteredOccupation.setText(occupation);
        }
    }//GEN-LAST:event_txt_enteredOccupationFocusLost
        
    
    public void RefreshWithdrawPage() {

        lbl_newAmountWithdraw.setText("");
        txt_enteredWithdrawAmount.setText("");
        txt_enteredWithdrawDate1.setText("DD-MM-YYYY");
        lbl_currentWithdrawResult.setText("Rs. " + String.valueOf(Account.getAccountBalance()));

    }

    public void RefreshDepositPage() {
        lbl_newAmountDeposit.setText("");
        txt_enteredDepositAmount.setText("");
        txt_enteredDepositDate1.setText("DD-MM-YYYY");
        lbl_currentResult1.setText("Rs. " + String.valueOf(Account.getAccountBalance()));

    }

    public void RefreshTransferPage() {
        txt_beneficiaryAccountNumber.setText("");
        txt_enteredTransferAmount.setText("");
        lbl_currentTransferResult.setText("Rs. " + String.valueOf(Account.getAccountBalance()));

    }

    
    
    
    public void ViewBalance(){
        
           boolean b = cus_obj.ViewAmount(loginId);
           
        if (b) {
            
            lbl_accountNumber.setText(Account.getAccountNumber());
            lbl_branchCodeResult.setText(Account.getAccountBranchCode());
            lbl_accountTypeResult.setText(Account.getAccountType());
            lbl_currentViewBalanceResult.setText("Rs. " + String.valueOf(Account.getAccountBalance()));
        } else {
            JOptionPane.showMessageDialog(null, "Error");
        }
        
        
        
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
            java.util.logging.Logger.getLogger(CustomerDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_deposit;
    private javax.swing.JButton btn_signOut;
    private javax.swing.JButton btn_transfer;
    private javax.swing.JButton btn_updateInformation;
    private javax.swing.JButton btn_withdraw;
    private javax.swing.JLabel lbl_accountNumber;
    private javax.swing.JLabel lbl_accountTypeHeading;
    private javax.swing.JLabel lbl_accountTypeResult;
    private javax.swing.JLabel lbl_accountViewBalanceHeading;
    private javax.swing.JLabel lbl_balancePicture;
    private javax.swing.JLabel lbl_bankLogo;
    private javax.swing.JLabel lbl_beneficiaryAccountHeading;
    private javax.swing.JLabel lbl_branchCodeHeading;
    private javax.swing.JLabel lbl_branchCodeResult;
    private javax.swing.JLabel lbl_currentDepositHeading;
    private javax.swing.JLabel lbl_currentResult1;
    private javax.swing.JLabel lbl_currentTransferHeading;
    private javax.swing.JLabel lbl_currentTransferResult;
    private javax.swing.JLabel lbl_currentViewBalanceHeading;
    private javax.swing.JLabel lbl_currentViewBalanceResult;
    private javax.swing.JLabel lbl_currentWithdrawHeading;
    private javax.swing.JLabel lbl_currentWithdrawResult;
    private javax.swing.JLabel lbl_dashboard;
    private javax.swing.JLabel lbl_dashboardImage;
    private javax.swing.JLabel lbl_depositAmount;
    private javax.swing.JLabel lbl_depositAmountHeading;
    private javax.swing.JLabel lbl_depositAmountPicture;
    private javax.swing.JLabel lbl_depositDateHeading1;
    private javax.swing.JLabel lbl_heading;
    private javax.swing.JLabel lbl_headingDeposit;
    private javax.swing.JLabel lbl_headingTransfer;
    private javax.swing.JLabel lbl_headingTransfer1;
    private javax.swing.JLabel lbl_headingUpdateInformation;
    private javax.swing.JLabel lbl_headingWithdraw;
    private javax.swing.JLabel lbl_logoHeading;
    private javax.swing.JLabel lbl_newAmountDeposit;
    private javax.swing.JLabel lbl_newAmountDepositHeading;
    private javax.swing.JLabel lbl_newAmountWithdraw;
    private javax.swing.JLabel lbl_newAmountWithdrawHeading;
    private javax.swing.JLabel lbl_transferAmountHeading;
    private javax.swing.JLabel lbl_transferFunds;
    private javax.swing.JLabel lbl_transferFundsPicture;
    private javax.swing.JLabel lbl_updateContacttHeading;
    private javax.swing.JLabel lbl_updateEmailtHeading;
    private javax.swing.JLabel lbl_updateFirstNametHeading;
    private javax.swing.JLabel lbl_updateInformation;
    private javax.swing.JLabel lbl_updateInformationPicture;
    private javax.swing.JLabel lbl_updateLastNametHeading;
    private javax.swing.JLabel lbl_updateOccupationHeading;
    private javax.swing.JLabel lbl_updatePasswordtHeading;
    private javax.swing.JLabel lbl_updateQualificationHeading;
    private javax.swing.JLabel lbl_viewBalance;
    private javax.swing.JLabel lbl_withdrawAmount;
    private javax.swing.JLabel lbl_withdrawAmountHeading;
    private javax.swing.JLabel lbl_withdrawAmountPicture;
    private javax.swing.JLabel lbl_withdrawDateHeading1;
    private javax.swing.JPanel pnl_dashboard;
    private javax.swing.JPanel pnl_depositAmount;
    private javax.swing.JPanel pnl_header;
    private javax.swing.JPanel pnl_menu;
    private javax.swing.JPanel pnl_panel1;
    private javax.swing.JPanel pnl_titleAndLogo;
    private javax.swing.JPanel pnl_transferFunds;
    private javax.swing.JPanel pnl_transferFunds2;
    private javax.swing.JPanel pnl_updateInformation;
    private javax.swing.JPanel pnl_updateInformation1;
    private javax.swing.JPanel pnl_viewBalance;
    private javax.swing.JPanel pnl_viewBalance2;
    private javax.swing.JPanel pnl_withdrawAmount1;
    private javax.swing.JPanel pnl_withdrawAmount2;
    private javax.swing.JSeparator spr_seperatorDeposit1;
    private javax.swing.JSeparator spr_seperatorDeposit2;
    private javax.swing.JSeparator spr_seperatorDeposit3;
    private javax.swing.JSeparator spr_seperatorDeposit4;
    private javax.swing.JSeparator spr_seperatorTransfer1;
    private javax.swing.JSeparator spr_seperatorTransfer2;
    private javax.swing.JSeparator spr_seperatorViewBalance1;
    private javax.swing.JSeparator spr_seperatorViewBalance2;
    private javax.swing.JSeparator spr_seperatorWithdraw1;
    private javax.swing.JSeparator spr_seperatorWithdraw2;
    private javax.swing.JTextField txt_beneficiaryAccountNumber;
    private javax.swing.JTextField txt_enteredContact;
    private javax.swing.JTextField txt_enteredDepositAmount;
    private javax.swing.JTextField txt_enteredDepositDate1;
    private javax.swing.JTextField txt_enteredEmail;
    private javax.swing.JTextField txt_enteredFirstName;
    private javax.swing.JTextField txt_enteredLastName;
    private javax.swing.JTextField txt_enteredOccupation;
    private javax.swing.JTextField txt_enteredPassword;
    private javax.swing.JTextField txt_enteredQualification;
    private javax.swing.JTextField txt_enteredTransferAmount;
    private javax.swing.JTextField txt_enteredWithdrawAmount;
    private javax.swing.JTextField txt_enteredWithdrawDate1;
    // End of variables declaration//GEN-END:variables
}
