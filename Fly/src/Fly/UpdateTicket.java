package Fly;

import Connection.TicketUpdate;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class UpdateTicket extends javax.swing.JFrame {

    String query = "SELECT TICKET_BUYING.TicketID,PASSENGER.Name,TICKET_BUYING.Class,TICKET_BUYING.FlightFinalID AS 'Flight ID',BILL.BillMethod,BILL.ClassRate,BILL.SeatAmount,BILL.TotalBill FROM TICKET_BUYING INNER JOIN PASSENGER ON TICKET_BUYING.CustomerID=PASSENGER.CustomerId FULL JOIN BILL ON TICKET_BUYING.TicketID=BILL.TicketID;";
    public String query1;
    public String billSystem;
    public UpdateTicket() {
        initComponents();
        BillCmb.setBackground(new Color(0, 0, 0, 0));
        TicketIDTxt.setBackground(new Color(0, 0, 0, 0));
        ClassTxt.setBackground(new Color(0, 0, 0, 0));
        ClassRate.setBackground(new Color(0, 0, 0, 0));
        Seat.setBackground(new Color(0, 0, 0, 0));
        TotalBill.setBackground(new Color(0, 0, 0, 0));
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

    public ArrayList<TicketUpdate> ListUsers(String query) {
        ArrayList<TicketUpdate> usersList = new ArrayList<TicketUpdate>();
        Connection con = getConnection();
        Statement st;
        ResultSet rs;
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            TicketUpdate user;
            while (rs.next()) {
                user = new TicketUpdate(rs.getInt("TicketID"), rs.getString("Name"), rs.getString("Class"), rs.getInt("Flight ID"), rs.getString("BillMethod"), rs.getString("ClassRate"), rs.getString("SeatAmount"), rs.getString("TotalBill"));
                usersList.add(user);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return usersList;
    }

    public ArrayList<TicketUpdate> ListUsers2(String valToSearch) {
        ArrayList<TicketUpdate> usersList = new ArrayList<TicketUpdate>();
        Connection con = getConnection();
        Statement st;
        ResultSet rs;
        try {
            st = con.createStatement();
            String searchquery = "SELECT TICKET_BUYING.TicketID,PASSENGER.Name,TICKET_BUYING.Class,TICKET_BUYING.FlightFinalID AS 'Flight ID',BILL.BillMethod,BILL.ClassRate,BILL.SeatAmount,BILL.TotalBill FROM TICKET_BUYING INNER JOIN PASSENGER ON TICKET_BUYING.CustomerID=PASSENGER.CustomerId FULL JOIN BILL ON TICKET_BUYING.TicketID=BILL.TicketID WHERE CONCAT(TICKET_BUYING.TicketID,PASSENGER.Name,TICKET_BUYING.Class,TICKET_BUYING.FlightFinalID,BILL.BillMethod,BILL.ClassRate,BILL.SeatAmount,BILL.TotalBill) LIKE '%" + valToSearch + "%'";
            rs = st.executeQuery(searchquery);
            TicketUpdate user;
            while (rs.next()) {
                user = new TicketUpdate(
                        rs.getInt("TicketID"), rs.getString("Name"), rs.getString("Class"), rs.getInt("Flight ID"), rs.getString("BillMethod"), rs.getString("ClassRate"), rs.getString("SeatAmount"), rs.getString("TotalBill"));
                usersList.add(user);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return usersList;
    }

    public void filter() {
        ArrayList<TicketUpdate> users = ListUsers2(SearchTxt.getText());
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"TicketID", "Name", "Class", "Flight ID", "Bill Method", "Class Rate", "Seat Amount", "Total Bill"});
        Object[] row = new Object[8];

        for (int i = 0; i < users.size(); i++) {
            row[0] = users.get(i).getTicket();
            row[1] = users.get(i).getName();
            row[2] = users.get(i).getclas();
            row[3] = users.get(i).getFlight();
            row[4] = users.get(i).getBill();
            row[5] = users.get(i).getClassRate();
            row[6] = users.get(i).getSeat();
            row[7] = users.get(i).getTotal();
            model.addRow(row);
        }
        TicketTableFinal.setModel(model);
    }

    public void showUserTable(String OrderQuery) {
        ArrayList<TicketUpdate> users = ListUsers(OrderQuery);
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"TicketID", "Name", "Class", "Flight ID", "Bill Method", "Class Rate", "Seat Amount", "Total Bill"});
        Object[] row = new Object[8];

        for (int i = 0; i < users.size(); i++) {
            row[0] = users.get(i).getTicket();
            row[1] = users.get(i).getName();
            row[2] = users.get(i).getclas();
            row[3] = users.get(i).getFlight();
            row[4] = users.get(i).getBill();
            row[5] = users.get(i).getClassRate();
            row[6] = users.get(i).getSeat();
            row[7] = users.get(i).getTotal();
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
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        SearchTxt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        Back = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        TicketIDTxt = new javax.swing.JTextField();
        BillCmb = new javax.swing.JComboBox<>();
        jSeparator8 = new javax.swing.JSeparator();
        Seat = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        ClassRate = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        TotalBill = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        TotalBtn = new javax.swing.JButton();
        PayBtn = new javax.swing.JButton();
        jSeparator10 = new javax.swing.JSeparator();
        ClassTxt = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 121, 107));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TicketTableFinal.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        TicketTableFinal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "null", "null", "null", "null", "null", "null", "null", "null"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TicketTableFinal.setRowHeight(32);
        TicketTableFinal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TicketTableFinalMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TicketTableFinal);
        if (TicketTableFinal.getColumnModel().getColumnCount() > 0) {
            TicketTableFinal.getColumnModel().getColumn(0).setResizable(false);
            TicketTableFinal.getColumnModel().getColumn(1).setResizable(false);
            TicketTableFinal.getColumnModel().getColumn(2).setResizable(false);
            TicketTableFinal.getColumnModel().getColumn(3).setResizable(false);
            TicketTableFinal.getColumnModel().getColumn(4).setResizable(false);
            TicketTableFinal.getColumnModel().getColumn(5).setResizable(false);
            TicketTableFinal.getColumnModel().getColumn(6).setResizable(false);
            TicketTableFinal.getColumnModel().getColumn(7).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 1410, 410));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 80, 370, 10));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search_25px.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 20, 50, 60));

        SearchTxt.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        SearchTxt.setForeground(new java.awt.Color(255, 255, 255));
        SearchTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        SearchTxt.setBorder(null);
        SearchTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchTxtKeyReleased(evt);
            }
        });
        jPanel1.add(SearchTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 20, 370, 60));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close_window_48px.png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 0, -1, -1));

        Back.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Back.setIcon(new javax.swing.ImageIcon("D:\\Fly Sky-Air Ticket Management\\Fly Sky-Air Ticket Management\\src\\images\\circled_left_48px.png")); // NOI18N
        Back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackMouseClicked(evt);
            }
        });
        jPanel1.add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jSeparator9.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 370, 20));

        jLabel12.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Ticket ID");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 150, 60));

        TicketIDTxt.setEditable(false);
        TicketIDTxt.setBackground(new java.awt.Color(255, 255, 255));
        TicketIDTxt.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        TicketIDTxt.setForeground(new java.awt.Color(255, 255, 255));
        TicketIDTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TicketIDTxt.setBorder(null);
        TicketIDTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TicketIDTxtMouseClicked(evt);
            }
        });
        jPanel1.add(TicketIDTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 370, 50));

        BillCmb.setBackground(new java.awt.Color(0, 121, 107));
        BillCmb.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        BillCmb.setForeground(new java.awt.Color(255, 255, 255));
        BillCmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Your Bill System", "Cash", "Credit Card", "Bkash", "Rocket" }));
        BillCmb.setBorder(null);
        jPanel1.add(BillCmb, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 170, 370, 60));

        jSeparator8.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 340, 370, 20));

        Seat.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        Seat.setForeground(new java.awt.Color(255, 255, 255));
        Seat.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Seat.setBorder(null);
        Seat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SeatMouseClicked(evt);
            }
        });
        Seat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SeatKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SeatKeyTyped(evt);
            }
        });
        jPanel1.add(Seat, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 290, 370, 50));

        jSeparator6.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 230, 370, 20));

        jLabel9.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Class Rate");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 120, 150, 60));

        ClassRate.setEditable(false);
        ClassRate.setBackground(new java.awt.Color(255, 255, 255));
        ClassRate.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        ClassRate.setForeground(new java.awt.Color(255, 255, 255));
        ClassRate.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ClassRate.setBorder(null);
        ClassRate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClassRateMouseClicked(evt);
            }
        });
        jPanel1.add(ClassRate, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 180, 370, 50));

        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 330, 370, 20));

        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Total Bill");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 220, 150, 60));

        TotalBill.setEditable(false);
        TotalBill.setBackground(new java.awt.Color(255, 255, 255));
        TotalBill.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        TotalBill.setForeground(new java.awt.Color(255, 255, 255));
        TotalBill.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TotalBill.setBorder(null);
        TotalBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TotalBillMouseClicked(evt);
            }
        });
        jPanel1.add(TotalBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 280, 370, 50));

        jLabel11.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Total Needed Seat");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 230, 230, 60));

        TotalBtn.setBackground(new java.awt.Color(153, 255, 255));
        TotalBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bill_25px.png"))); // NOI18N
        TotalBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TotalBtnMouseClicked(evt);
            }
        });
        jPanel1.add(TotalBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 290, 50, 50));

        PayBtn.setBackground(new java.awt.Color(102, 255, 102));
        PayBtn.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        PayBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cash_in_hand_48px.png"))); // NOI18N
        PayBtn.setText("UPDATE");
        PayBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PayBtnMouseClicked(evt);
            }
        });
        jPanel1.add(PayBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 360, 180, 70));

        jSeparator10.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 370, 20));

        ClassTxt.setEditable(false);
        ClassTxt.setBackground(new java.awt.Color(255, 255, 255));
        ClassTxt.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        ClassTxt.setForeground(new java.awt.Color(255, 255, 255));
        ClassTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ClassTxt.setBorder(null);
        ClassTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClassTxtMouseClicked(evt);
            }
        });
        jPanel1.add(ClassTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 370, 50));

        jLabel13.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Class");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 150, 60));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Bill Method");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 120, 190, 60));

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

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel6MouseClicked

    private void BackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new UpdateEmployee().setVisible(true);
    }//GEN-LAST:event_BackMouseClicked

    private void TicketIDTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TicketIDTxtMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TicketIDTxtMouseClicked

    private void SeatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SeatMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_SeatMouseClicked

    private void SeatKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SeatKeyReleased

    }//GEN-LAST:event_SeatKeyReleased

    private void SeatKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SeatKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_SeatKeyTyped

    private void ClassRateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClassRateMouseClicked

    }//GEN-LAST:event_ClassRateMouseClicked

    private void TotalBillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TotalBillMouseClicked

    }//GEN-LAST:event_TotalBillMouseClicked

    private void TotalBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TotalBtnMouseClicked
        // TODO add your handling code here:
        double classrate = Double.parseDouble(ClassRate.getText());
        double seat = Double.parseDouble(Seat.getText());
        double result = (classrate * seat);
        String Total = String.format("%.2f", result);
        TotalBill.setText(Total);
    }//GEN-LAST:event_TotalBtnMouseClicked

    private void PayBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PayBtnMouseClicked
        // TODO add your handling code here:
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager
            .getConnection(
                "jdbc:sqlserver://localhost:1433;databaseName=FLY_SKY;selectMethod=cursor", "sa", "123456");
            query1 ="UPDATE BILL SET Class=?, BillMethod=?, ClassRate=?, SeatAmount=?, TotalBill=? where TicketID="+TicketIDTxt.getText();
            PreparedStatement pst = conn.prepareStatement(query1);
            if (BillCmb.getSelectedItem().equals("Select Your Bill System")) {
                billSystem="";
            } else {
                billSystem=BillCmb.getSelectedItem().toString();
            }
            pst.setString(1, ClassTxt.getText());
            pst.setString(2, billSystem);
            pst.setString(3, ClassRate.getText());
            pst.setString(4, Seat.getText());
            pst.setString(5, TotalBill.getText());
            pst.executeUpdate();
            ClassTxt.setText(" ");
            TicketIDTxt.setText(" ");
            BillCmb.setSelectedIndex(0);
            ClassRate.setText(" ");
            Seat.setText(" ");
            TotalBill.setText(" ");
            ImageIcon icon = new ImageIcon("src/images/ok_48px.png");
            JOptionPane.showMessageDialog(null, "Updated Successfully", "Successfull", JOptionPane.INFORMATION_MESSAGE, icon);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please Insert Correctly");
        }
    }//GEN-LAST:event_PayBtnMouseClicked

    private void TicketTableFinalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TicketTableFinalMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)TicketTableFinal.getModel();
        int selectedRowIndex=TicketTableFinal.getSelectedRow();
        
        TicketIDTxt.setText(model.getValueAt(selectedRowIndex, 0).toString());
        ClassTxt.setText(model.getValueAt(selectedRowIndex, 2).toString());
        ClassRate.setText(model.getValueAt(selectedRowIndex, 5).toString());
    }//GEN-LAST:event_TicketTableFinalMouseClicked

    private void ClassTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClassTxtMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ClassTxtMouseClicked

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
            java.util.logging.Logger.getLogger(UpdateTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateTicket().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Back;
    public javax.swing.JComboBox<String> BillCmb;
    private javax.swing.JTextField ClassRate;
    private javax.swing.JTextField ClassTxt;
    private javax.swing.JButton PayBtn;
    private javax.swing.JTextField SearchTxt;
    private javax.swing.JTextField Seat;
    private javax.swing.JTextField TicketIDTxt;
    private javax.swing.JTable TicketTableFinal;
    private javax.swing.JTextField TotalBill;
    private javax.swing.JButton TotalBtn;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    // End of variables declaration//GEN-END:variables
}
