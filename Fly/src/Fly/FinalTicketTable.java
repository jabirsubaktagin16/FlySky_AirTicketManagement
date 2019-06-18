package Fly;

import Connection.FinalTicket;
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
public class FinalTicketTable extends javax.swing.JFrame {

    String query = "SELECT TICKET_BUYING.TicketID,PASSENGER.Name,TICKET_BUYING.FlightFinalID AS 'Flight ID',BILL.BillMethod,BILL.ClassRate,BILL.SeatAmount,BILL.TotalBill FROM TICKET_BUYING INNER JOIN PASSENGER ON TICKET_BUYING.CustomerID=PASSENGER.CustomerId FULL JOIN BILL ON TICKET_BUYING.TicketID=BILL.TicketID";

    public FinalTicketTable() {
        initComponents();
        SearchTxt.setBackground(new Color(0, 0, 0, 0));
        showUserTable(query);
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

    public ArrayList<FinalTicket> ListUsers(String query) {
        ArrayList<FinalTicket> usersList = new ArrayList<FinalTicket>();
        Connection con = getConnection();
        Statement st;
        ResultSet rs;
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            FinalTicket user;
            while (rs.next()) {
                user = new FinalTicket(rs.getInt("TicketID"), rs.getString("Name"), rs.getInt("Flight ID"), rs.getString("BillMethod"), rs.getString("ClassRate"), rs.getString("SeatAmount"), rs.getString("TotalBill"));
                usersList.add(user);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return usersList;
    }

    public ArrayList<FinalTicket> ListUsers2(String valToSearch) {
        ArrayList<FinalTicket> usersList = new ArrayList<FinalTicket>();
        Connection con = getConnection();
        Statement st;
        ResultSet rs;
        try {
            st = con.createStatement();
            String searchquery = "SELECT TICKET_BUYING.TicketID,PASSENGER.Name,TICKET_BUYING.FlightFinalID AS 'Flight ID',BILL.BillMethod,BILL.ClassRate,BILL.SeatAmount,BILL.TotalBill FROM TICKET_BUYING INNER JOIN PASSENGER ON TICKET_BUYING.CustomerID=PASSENGER.CustomerId FULL JOIN BILL ON TICKET_BUYING.TicketID=BILL.TicketID WHERE CONCAT(TICKET_BUYING.TicketID,PASSENGER.Name,TICKET_BUYING.FlightFinalID,BILL.BillMethod,BILL.ClassRate,BILL.SeatAmount,BILL.TotalBill) LIKE '%" + valToSearch + "%'";
            rs = st.executeQuery(searchquery);
            FinalTicket user;
            while (rs.next()) {
                user = new FinalTicket(
                        rs.getInt("TicketID"), rs.getString("Name"), rs.getInt("Flight ID"), rs.getString("BillMethod"), rs.getString("ClassRate"), rs.getString("SeatAmount"), rs.getString("TotalBill"));
                usersList.add(user);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return usersList;
    }

    public void filter() {
        ArrayList<FinalTicket> users = ListUsers2(SearchTxt.getText());
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"TicketID", "Name", "Flight ID", "Bill Method", "Class Rate", "Seat Amount", "Total Bill"});
        Object[] row = new Object[7];

        for (int i = 0; i < users.size(); i++) {
            row[0] = users.get(i).getTicket();
            row[1] = users.get(i).getName();
            row[2] = users.get(i).getFlight();
            row[3] = users.get(i).getBill();
            row[4] = users.get(i).getClassRate();
            row[5] = users.get(i).getSeat();
            row[6] = users.get(i).getTotal();
            model.addRow(row);
        }
        TicketTableFinal.setModel(model);
    }

    public void showUserTable(String OrderQuery) {
        ArrayList<FinalTicket> users = ListUsers(OrderQuery);
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"TicketID", "Name", "Flight ID", "Bill Method", "Class Rate", "Seat Amount", "Total Bill"});
        Object[] row = new Object[7];

        for (int i = 0; i < users.size(); i++) {
            row[0] = users.get(i).getTicket();
            row[1] = users.get(i).getName();
            row[2] = users.get(i).getFlight();
            row[3] = users.get(i).getBill();
            row[4] = users.get(i).getClassRate();
            row[5] = users.get(i).getSeat();
            row[6] = users.get(i).getTotal();
            model.addRow(row);
        }
        TicketTableFinal.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TicketTableFinal = new javax.swing.JTable();
        SortCmb = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        SearchTxt = new javax.swing.JTextField();
        BackBtn = new javax.swing.JButton();
        ExitBtn1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TicketTableFinal.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        TicketTableFinal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "", "", "", "", "", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TicketTableFinal.setRowHeight(32);
        jScrollPane1.setViewportView(TicketTableFinal);
        if (TicketTableFinal.getColumnModel().getColumnCount() > 0) {
            TicketTableFinal.getColumnModel().getColumn(0).setResizable(false);
            TicketTableFinal.getColumnModel().getColumn(1).setResizable(false);
            TicketTableFinal.getColumnModel().getColumn(2).setResizable(false);
            TicketTableFinal.getColumnModel().getColumn(3).setResizable(false);
            TicketTableFinal.getColumnModel().getColumn(4).setResizable(false);
            TicketTableFinal.getColumnModel().getColumn(5).setResizable(false);
            TicketTableFinal.getColumnModel().getColumn(6).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 1400, 490));

        SortCmb.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        SortCmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sort By", "Ticket ID (Ascending)", "Ticket ID (Descending)", "Name (Ascending)", "Name (Descending)", "Flight ID (Ascending)", "Flight ID (Descending)", "Bill Method (Ascending)", "Bill Method (Descending)", "Class Rate (Ascending)", "Class Rate (Descending)", "Seat Amount (Ascending)", "Seat Amount (Descending)", "Total Bill (Ascending)", "Total Bill (Descending)" }));
        SortCmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SortCmbActionPerformed(evt);
            }
        });
        jPanel1.add(SortCmb, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 280, 340, 60));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 332, 310, 10));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search_25px.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 270, 50, 60));

        SearchTxt.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        SearchTxt.setForeground(new java.awt.Color(255, 255, 255));
        SearchTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        SearchTxt.setBorder(null);
        SearchTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchTxtKeyReleased(evt);
            }
        });
        jPanel1.add(SearchTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 270, 310, 60));

        BackBtn.setBackground(new java.awt.Color(255, 102, 51));
        BackBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back_26px.png"))); // NOI18N
        BackBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackBtnMouseClicked(evt);
            }
        });
        BackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackBtnActionPerformed(evt);
            }
        });
        jPanel1.add(BackBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 0, 40, 40));

        ExitBtn1.setBackground(new java.awt.Color(255, 0, 0));
        ExitBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-shutdown-32.png"))); // NOI18N
        ExitBtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExitBtn1MouseClicked(evt);
            }
        });
        jPanel1.add(ExitBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1350, 0, 50, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/airplane-wallpaper-1680x1050-4.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1405, 875));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void SearchTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchTxtKeyReleased
        // TODO add your handling code here:
        filter();
    }//GEN-LAST:event_SearchTxtKeyReleased

    private void SortCmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SortCmbActionPerformed
        // TODO add your handling code here:
        
if (SortCmb.getSelectedItem().equals("Ticket ID (Ascending)")) {
            query = "SELECT TICKET_BUYING.TicketID,PASSENGER.Name,TICKET_BUYING.FlightFinalID AS 'Flight ID',BILL.BillMethod,BILL.ClassRate,BILL.SeatAmount,BILL.TotalBill FROM TICKET_BUYING INNER JOIN PASSENGER ON TICKET_BUYING.CustomerID=PASSENGER.CustomerId FULL JOIN BILL ON TICKET_BUYING.TicketID=BILL.TicketID ORDER BY TICKET_BUYING.TicketID ASC";
            showUserTable(query);
        } else if (SortCmb.getSelectedItem().equals("Ticket ID (Descending)")) {
            query = "SELECT TICKET_BUYING.TicketID,PASSENGER.Name,TICKET_BUYING.FlightFinalID AS 'Flight ID',BILL.BillMethod,BILL.ClassRate,BILL.SeatAmount,BILL.TotalBill FROM TICKET_BUYING INNER JOIN PASSENGER ON TICKET_BUYING.CustomerID=PASSENGER.CustomerId FULL JOIN BILL ON TICKET_BUYING.TicketID=BILL.TicketID ORDER BY TICKET_BUYING.TicketID DESC";
            showUserTable(query);
        } else if (SortCmb.getSelectedItem().equals("Name (Ascending)")) {
            query = "SELECT TICKET_BUYING.TicketID,PASSENGER.Name,TICKET_BUYING.FlightFinalID AS 'Flight ID',BILL.BillMethod,BILL.ClassRate,BILL.SeatAmount,BILL.TotalBill FROM TICKET_BUYING INNER JOIN PASSENGER ON TICKET_BUYING.CustomerID=PASSENGER.CustomerId FULL JOIN BILL ON TICKET_BUYING.TicketID=BILL.TicketID ORDER BY PASSENGER.Name ASC";
            showUserTable(query);
        } else if (SortCmb.getSelectedItem().equals("Name (Descending)")) {
            query = "SELECT TICKET_BUYING.TicketID,PASSENGER.Name,TICKET_BUYING.FlightFinalID AS 'Flight ID',BILL.BillMethod,BILL.ClassRate,BILL.SeatAmount,BILL.TotalBill FROM TICKET_BUYING INNER JOIN PASSENGER ON TICKET_BUYING.CustomerID=PASSENGER.CustomerId FULL JOIN BILL ON TICKET_BUYING.TicketID=BILL.TicketID ORDER BY PASSENGER.Name DESC";
            showUserTable(query);
        } else if (SortCmb.getSelectedItem().equals("Flight ID (Ascending)")) {
            query = "SELECT TICKET_BUYING.TicketID,PASSENGER.Name,TICKET_BUYING.FlightFinalID AS 'Flight ID',BILL.BillMethod,BILL.ClassRate,BILL.SeatAmount,BILL.TotalBill FROM TICKET_BUYING INNER JOIN PASSENGER ON TICKET_BUYING.CustomerID=PASSENGER.CustomerId FULL JOIN BILL ON TICKET_BUYING.TicketID=BILL.TicketID ORDER BY TICKET_BUYING.FlightFinalID ASC";
            showUserTable(query);
        } else if (SortCmb.getSelectedItem().equals("Flight ID (Descending)")) {
            query = "SELECT TICKET_BUYING.TicketID,PASSENGER.Name,TICKET_BUYING.FlightFinalID AS 'Flight ID',BILL.BillMethod,BILL.ClassRate,BILL.SeatAmount,BILL.TotalBill FROM TICKET_BUYING INNER JOIN PASSENGER ON TICKET_BUYING.CustomerID=PASSENGER.CustomerId FULL JOIN BILL ON TICKET_BUYING.TicketID=BILL.TicketID ORDER BY TICKET_BUYING.FlightFinalID DESC";
            showUserTable(query);
        } else if (SortCmb.getSelectedItem().equals("Bill Method (Ascending)")) {
            query = "SELECT TICKET_BUYING.TicketID,PASSENGER.Name,TICKET_BUYING.FlightFinalID AS 'Flight ID',BILL.BillMethod,BILL.ClassRate,BILL.SeatAmount,BILL.TotalBill FROM TICKET_BUYING INNER JOIN PASSENGER ON TICKET_BUYING.CustomerID=PASSENGER.CustomerId FULL JOIN BILL ON TICKET_BUYING.TicketID=BILL.TicketID ORDER BY BILL.BillMethod ASC";
            showUserTable(query);
        } else if (SortCmb.getSelectedItem().equals("Bill Method (Descending)")) {
            query = "SELECT TICKET_BUYING.TicketID,PASSENGER.Name,TICKET_BUYING.FlightFinalID AS 'Flight ID',BILL.BillMethod,BILL.ClassRate,BILL.SeatAmount,BILL.TotalBill FROM TICKET_BUYING INNER JOIN PASSENGER ON TICKET_BUYING.CustomerID=PASSENGER.CustomerId FULL JOIN BILL ON TICKET_BUYING.TicketID=BILL.TicketID ORDER BY BILL.BillMethod DESC";
            showUserTable(query);
        } else if (SortCmb.getSelectedItem().equals("Class Rate (Ascending)")) {
            query = "SELECT TICKET_BUYING.TicketID,PASSENGER.Name,TICKET_BUYING.FlightFinalID AS 'Flight ID',BILL.BillMethod,BILL.ClassRate,BILL.SeatAmount,BILL.TotalBill FROM TICKET_BUYING INNER JOIN PASSENGER ON TICKET_BUYING.CustomerID=PASSENGER.CustomerId FULL JOIN BILL ON TICKET_BUYING.TicketID=BILL.TicketID ORDER BY BILL.ClassRate ASC";
            showUserTable(query);
        } else if (SortCmb.getSelectedItem().equals("Class Rate (Descending)")) {
            query = "SELECT TICKET_BUYING.TicketID,PASSENGER.Name,TICKET_BUYING.FlightFinalID AS 'Flight ID',BILL.BillMethod,BILL.ClassRate,BILL.SeatAmount,BILL.TotalBill FROM TICKET_BUYING INNER JOIN PASSENGER ON TICKET_BUYING.CustomerID=PASSENGER.CustomerId FULL JOIN BILL ON TICKET_BUYING.TicketID=BILL.TicketID ORDER BY BILL.ClassRate DESC";
            showUserTable(query);
        } else if (SortCmb.getSelectedItem().equals("Seat Amount (Ascending)")) {
            query = "SELECT TICKET_BUYING.TicketID,PASSENGER.Name,TICKET_BUYING.FlightFinalID AS 'Flight ID',BILL.BillMethod,BILL.ClassRate,BILL.SeatAmount,BILL.TotalBill FROM TICKET_BUYING INNER JOIN PASSENGER ON TICKET_BUYING.CustomerID=PASSENGER.CustomerId FULL JOIN BILL ON TICKET_BUYING.TicketID=BILL.TicketID ORDER BY BILL.SeatAmount ASC";
            showUserTable(query);
        } else if (SortCmb.getSelectedItem().equals("Seat Amount (Descending)")) {
            query = "SELECT TICKET_BUYING.TicketID,PASSENGER.Name,TICKET_BUYING.FlightFinalID AS 'Flight ID',BILL.BillMethod,BILL.ClassRate,BILL.SeatAmount,BILL.TotalBill FROM TICKET_BUYING INNER JOIN PASSENGER ON TICKET_BUYING.CustomerID=PASSENGER.CustomerId FULL JOIN BILL ON TICKET_BUYING.TicketID=BILL.TicketID ORDER BY BILL.SeatAmount DESC";
            showUserTable(query);
        } else if (SortCmb.getSelectedItem().equals("Total Bill (Ascending)")) {
            query = "SELECT TICKET_BUYING.TicketID,PASSENGER.Name,TICKET_BUYING.FlightFinalID AS 'Flight ID',BILL.BillMethod,BILL.ClassRate,BILL.SeatAmount,BILL.TotalBill FROM TICKET_BUYING INNER JOIN PASSENGER ON TICKET_BUYING.CustomerID=PASSENGER.CustomerId FULL JOIN BILL ON TICKET_BUYING.TicketID=BILL.TicketID ORDER BY BILL.TotalBill ASC";
            showUserTable(query);
        } else if (SortCmb.getSelectedItem().equals("Total Bill (Descending)")) {
            query = "SELECT TICKET_BUYING.TicketID,PASSENGER.Name,TICKET_BUYING.FlightFinalID AS 'Flight ID',BILL.BillMethod,BILL.ClassRate,BILL.SeatAmount,BILL.TotalBill FROM TICKET_BUYING INNER JOIN PASSENGER ON TICKET_BUYING.CustomerID=PASSENGER.CustomerId FULL JOIN BILL ON TICKET_BUYING.TicketID=BILL.TicketID ORDER BY BILL.TotalBill DESC";
            showUserTable(query);
        } else {
            query = "SELECT TICKET_BUYING.TicketID,PASSENGER.Name,TICKET_BUYING.FlightFinalID AS 'Flight ID',BILL.BillMethod,BILL.ClassRate,BILL.SeatAmount,BILL.TotalBill FROM TICKET_BUYING INNER JOIN PASSENGER ON TICKET_BUYING.CustomerID=PASSENGER.CustomerId FULL JOIN BILL ON TICKET_BUYING.TicketID=BILL.TicketID ORDER BY TICKET_BUYING.TicketID ASC";
            showUserTable(query);
        }
    }//GEN-LAST:event_SortCmbActionPerformed

    private void ExitBtn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitBtn1MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_ExitBtn1MouseClicked

    private void BackBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackBtnMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        Employee add=new Employee();
        add.setVisible(true);
    }//GEN-LAST:event_BackBtnMouseClicked

    private void BackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BackBtnActionPerformed

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
            java.util.logging.Logger.getLogger(FinalTicketTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FinalTicketTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FinalTicketTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FinalTicketTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FinalTicketTable().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackBtn;
    private javax.swing.JButton ExitBtn1;
    private javax.swing.JTextField SearchTxt;
    private javax.swing.JComboBox<String> SortCmb;
    private javax.swing.JTable TicketTableFinal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
