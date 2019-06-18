package Fly;

import Connection.User;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class PassengerInfoTable extends javax.swing.JFrame {

    String query = "SELECT * FROM PASSENGER";

    public PassengerInfoTable() {
        initComponents();
        showUserTable(query);
        SearchTxt.setBackground(new Color(0,0,0,0));
        filter();
    }

    public Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager
                    .getConnection(
                            "jdbc:sqlserver://localhost:1433;databaseName=FLY_SKY;selectMethod=cursor", "sa", "123456");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return con;
    }

    public ArrayList<User> ListUsers(String query) {
        ArrayList<User> usersList = new ArrayList<User>();
        Connection con = getConnection();
        Statement st;
        ResultSet rs;
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            User user;
            while (rs.next()) {
                user = new User(
                        rs.getInt("CustomerID"), rs.getString("Name"), rs.getString("Email"), rs.getString("ContactNo"));
                usersList.add(user);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return usersList;
    }

    public ArrayList<User> ListUsers2(String valToSearch) {
        ArrayList<User> usersList = new ArrayList<User>();
        Connection con = getConnection();
        Statement st;
        ResultSet rs;
        try {
            st = con.createStatement();
            String searchquery = "SELECT * FROM PASSENGER WHERE CONCAT(CustomerID, Name, Email, ContactNo) LIKE '%" + valToSearch + "%'";
            rs = st.executeQuery(searchquery);
            User user;
            while (rs.next()) {
                user = new User(
                        rs.getInt("CustomerID"), rs.getString("Name"), rs.getString("Email"), rs.getString("ContactNo"));
                usersList.add(user);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return usersList;
    }

    public void filter() {
        ArrayList<User> users = ListUsers2(SearchTxt.getText());
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"CustomerID", "Name", "Email", "ContactNo"});
        Object[] row = new Object[4];

        for (int i = 0; i < users.size(); i++) {
            row[0] = users.get(i).getID();
            row[1] = users.get(i).getName();
            row[2] = users.get(i).getEmail();
            row[3] = users.get(i).getPhone();
            model.addRow(row);
        }
        PassengerTable.setModel(model);
    }

    public void showUserTable(String OrderQuery) {
        ArrayList<User> users = ListUsers(OrderQuery);
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"CustomerID", "Name", "Email", "ContactNo"});
        Object[] row = new Object[4];

        for (int i = 0; i < users.size(); i++) {
            row[0] = users.get(i).getID();
            row[1] = users.get(i).getName();
            row[2] = users.get(i).getEmail();
            row[3] = users.get(i).getPhone();
            model.addRow(row);
        }
        PassengerTable.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        PassengerTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        SearchTxt = new javax.swing.JTextField();
        SortCmb = new javax.swing.JComboBox<>();
        BackBtn = new javax.swing.JButton();
        UpdateCustomer = new javax.swing.JButton();
        UpdateCustomer1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(63, 81, 181));
        jPanel1.setLayout(null);

        PassengerTable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        PassengerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CustomerID", "Name", "Email", "ContactNo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        PassengerTable.setCellSelectionEnabled(true);
        PassengerTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        PassengerTable.setEnabled(false);
        PassengerTable.setRowHeight(26);
        jScrollPane1.setViewportView(PassengerTable);
        if (PassengerTable.getColumnModel().getColumnCount() > 0) {
            PassengerTable.getColumnModel().getColumn(0).setResizable(false);
            PassengerTable.getColumnModel().getColumn(0).setPreferredWidth(100);
            PassengerTable.getColumnModel().getColumn(1).setResizable(false);
            PassengerTable.getColumnModel().getColumn(2).setResizable(false);
            PassengerTable.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(0, 202, 1440, 540);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search_25px.png"))); // NOI18N
        jPanel1.add(jLabel3);
        jLabel3.setBounds(1350, 130, 40, 50);

        SearchTxt.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        SearchTxt.setForeground(new java.awt.Color(255, 255, 255));
        SearchTxt.setBorder(null);
        SearchTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchTxtKeyReleased(evt);
            }
        });
        jPanel1.add(SearchTxt);
        SearchTxt.setBounds(1000, 120, 390, 70);

        SortCmb.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        SortCmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sort By", "Customer ID (Descending)", "Name (Ascending)", "Name (Descending)", "Email (Ascending)", "Email (Descending)", "Contact No (Ascending)", "Contact No (Descending)" }));
        SortCmb.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        SortCmb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SortCmbMouseClicked(evt);
            }
        });
        SortCmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SortCmbActionPerformed(evt);
            }
        });
        jPanel1.add(SortCmb);
        SortCmb.setBounds(20, 110, 370, 70);

        BackBtn.setBackground(new java.awt.Color(255, 102, 0));
        BackBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BackBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-home-page-30.png"))); // NOI18N
        BackBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackBtnMouseClicked(evt);
            }
        });
        jPanel1.add(BackBtn);
        BackBtn.setBounds(1360, 0, 40, 40);

        UpdateCustomer.setBackground(new java.awt.Color(0, 204, 204));
        UpdateCustomer.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        UpdateCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-plus-26.png"))); // NOI18N
        UpdateCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UpdateCustomerMouseClicked(evt);
            }
        });
        jPanel1.add(UpdateCustomer);
        UpdateCustomer.setBounds(1280, 0, 40, 40);

        UpdateCustomer1.setBackground(new java.awt.Color(51, 255, 102));
        UpdateCustomer1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        UpdateCustomer1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UpdateCustomer1MouseClicked(evt);
            }
        });
        jPanel1.add(UpdateCustomer1);
        UpdateCustomer1.setBounds(1320, 0, 40, 40);
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(1000, 190, 390, 10);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close_window_48px.png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel6);
        jLabel6.setBounds(1390, -10, 60, 60);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1440, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 810, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1440, 810));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void SortCmbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SortCmbMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_SortCmbMouseClicked

    private void SortCmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SortCmbActionPerformed
        // TODO add your handling code here:
        if (SortCmb.getSelectedItem().equals("Customer ID (Descending)")) {
            query = "SELECT * FROM PASSENGER ORDER BY CustomerID DESC";
            showUserTable(query);
        } else if (SortCmb.getSelectedItem().equals("Name (Ascending)")) {
            query = "SELECT * FROM PASSENGER ORDER BY Name ASC";
            showUserTable(query);
        } else if (SortCmb.getSelectedItem().equals("Name (Descending)")) {
            query = "SELECT * FROM PASSENGER ORDER BY Name DESC";
            showUserTable(query);
        } else if (SortCmb.getSelectedItem().equals("Email (Ascending)")) {
            query = "SELECT * FROM PASSENGER ORDER BY Email ASC";
            showUserTable(query);
        } else if (SortCmb.getSelectedItem().equals("Email (Descending)")) {
            query = "SELECT * FROM PASSENGER ORDER BY Email DESC";
            showUserTable(query);
        } else if (SortCmb.getSelectedItem().equals("Contact No (Ascending)")) {
            query = "SELECT * FROM PASSENGER ORDER BY ContactNo ASC";
            showUserTable(query);
        } else if (SortCmb.getSelectedItem().equals("Contact No (Descending)")) {
            query = "SELECT * FROM PASSENGER ORDER BY ContactNo DESC";
            showUserTable(query);
        }

    }//GEN-LAST:event_SortCmbActionPerformed

    private void BackBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackBtnMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        CustomerFirstPage cfp = new CustomerFirstPage();
        cfp.setVisible(true);
    }//GEN-LAST:event_BackBtnMouseClicked

    private void UpdateCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateCustomerMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        NewCustomer pit = new NewCustomer();
        pit.setVisible(true);
    }//GEN-LAST:event_UpdateCustomerMouseClicked

    private void UpdateCustomer1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateCustomer1MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        UpdateCustomer pit = new UpdateCustomer();
        pit.setVisible(true);
    }//GEN-LAST:event_UpdateCustomer1MouseClicked

    private void SearchTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchTxtKeyReleased
        // TODO add your handling code here:
        filter();
    }//GEN-LAST:event_SearchTxtKeyReleased

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel6MouseClicked

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
            java.util.logging.Logger.getLogger(PassengerInfoTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PassengerInfoTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PassengerInfoTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PassengerInfoTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PassengerInfoTable().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackBtn;
    private javax.swing.JTable PassengerTable;
    private javax.swing.JTextField SearchTxt;
    private javax.swing.JComboBox<String> SortCmb;
    private javax.swing.JButton UpdateCustomer;
    private javax.swing.JButton UpdateCustomer1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
