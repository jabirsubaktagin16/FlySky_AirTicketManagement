package Fly;

import Connection.Flight;
import Connection.FlightInfoFinal;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

public class UpdateSchedule extends javax.swing.JFrame {

    String query = "SELECT * FROM FLIGHT_INFO_FINAL INNER JOIN FLIGHT_INFO ON FLIGHT_INFO_FINAL.FlightID=FLIGHT_INFO.FlightID";
    public String query1;
    public UpdateSchedule() {
        
        initComponents();
        showDate();
        showTime();
        showUserTable(query);
        filter();
        FlightFinalIDTxt.setBackground(new Color(0, 0, 0, 0));
        FlightIDTxt.setBackground(new Color(0, 0, 0, 0));
        SearchTxt.setBackground(new Color(0, 0, 0, 0));
        DateTxt1.setBackground(new Color(0, 0, 0, 0));
        ClockTxt.setBackground(new Color(0, 0, 0, 0));
    }

    void showDate() {
        Date date = new Date();
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        DateTxt1.setText(sd.format(date));
    }

    void showTime() {
        new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Date time = new Date();
                SimpleDateFormat sd = new SimpleDateFormat("HH:mm:ss");
                ClockTxt.setText(sd.format(time));
            }
        }) {

        }.start();

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

    public ArrayList<FlightInfoFinal> ListUsers(String query) {
        ArrayList<FlightInfoFinal> usersList = new ArrayList<FlightInfoFinal>();
        Connection con = getConnection();
        Statement st;
        ResultSet rs;
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            FlightInfoFinal user;
            while (rs.next()) {
                user = new FlightInfoFinal(rs.getInt("FlightFinalID"), rs.getInt("FlightID"), rs.getString("FlightDate"), rs.getString("StartingPlace"), rs.getString("TrangitPoint"), rs.getString("Destination"), rs.getString("AirlineName"), rs.getString("DepartureTime"), rs.getString("ArrivalTime"), rs.getInt("SeatCapacity"), rs.getString("EconomicClass"), rs.getString("BusinessClass"));
                usersList.add(user);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return usersList;
    }

    public void showUserTable(String OrderQuery) {
        ArrayList<FlightInfoFinal> users = ListUsers(OrderQuery);
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"FlightFinalID", "FlightID", "FlightDate", "StartingPlace", "TrangitPoint", "Destination", "AirLineName", "DepartureTime", "ArrivalTime", "SeatCapacity", "EconomicClass", "BusinessClass"});
        Object[] row = new Object[12];

        for (int i = 0; i < users.size(); i++) {
            row[0] = users.get(i).getID();
            row[1] = users.get(i).getID2();
            row[2] = users.get(i).getDate();
            row[3] = users.get(i).getArrival();
            row[4] = users.get(i).getTrangit();
            row[5] = users.get(i).getDeparture();
            row[6] = users.get(i).getAirline();
            row[7] = users.get(i).getArrivalTime();
            row[8] = users.get(i).getDepartureTime();
            row[9] = users.get(i).getSeat();
            row[10] = users.get(i).getEconomic();
            row[11] = users.get(i).getBusiness();
            model.addRow(row);
        }
        FlightInfoFinalTable.setModel(model);
    }

    public ArrayList<FlightInfoFinal> ListUsers2(String valToSearch) {
        ArrayList<FlightInfoFinal> usersList = new ArrayList<FlightInfoFinal>();
        Connection con = getConnection();
        Statement st;
        ResultSet rs;
        try {
            st = con.createStatement();
            String searchquery = "SELECT FLIGHT_INFO_FINAL.FlightFinalID,FLIGHT_INFO_FINAL.FlightID,FLIGHT_INFO_FINAL.FlightDate,FLIGHT_INFO.StartingPlace,FLIGHT_INFO.TrangitPoint,FLIGHT_INFO.Destination,FLIGHT_INFO.AirLineName,FLIGHT_INFO.DepartureTime,FLIGHT_INFO.ArrivalTime,FLIGHT_INFO.SeatCapacity,FLIGHT_INFO.EconomicClass,FLIGHT_INFO.BusinessClass\n"
                    + "FROM FLIGHT_INFO_FINAL INNER JOIN FLIGHT_INFO\n"
                    + "ON FLIGHT_INFO_FINAL.FlightID=FLIGHT_INFO.FlightID WHERE CONCAT(FLIGHT_INFO_FINAL.FlightFinalID, FLIGHT_INFO_FINAL.FlightID, FLIGHT_INFO_FINAL.FlightDate, FLIGHT_INFO.StartingPlace, FLIGHT_INFO.TrangitPoint, FLIGHT_INFO.Destination, FLIGHT_INFO.AirLineName, FLIGHT_INFO.DepartureTime, FLIGHT_INFO.ArrivalTime, FLIGHT_INFO.SeatCapacity, FLIGHT_INFO.EconomicClass, FLIGHT_INFO.BusinessClass) LIKE '%" + valToSearch + "%'";
            rs = st.executeQuery(searchquery);
            FlightInfoFinal user;
            while (rs.next()) {
                user = new FlightInfoFinal(rs.getInt("FlightFinalID"), rs.getInt("FlightID"), rs.getString("FlightDate"), rs.getString("StartingPlace"), rs.getString("TrangitPoint"), rs.getString("Destination"), rs.getString("AirlineName"), rs.getString("DepartureTime"), rs.getString("ArrivalTime"), rs.getInt("SeatCapacity"), rs.getString("EconomicClass"), rs.getString("BusinessClass"));
                usersList.add(user);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return usersList;
    }

    public void filter() {
        ArrayList<FlightInfoFinal> users = ListUsers2(SearchTxt.getText());
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"FlightFinalID", "FlightID", "FlightDate", "StartingPlace", "TrangitPoint", "Destination", "AirLineName", "DepartureTime", "ArrivalTime", "SeatCapacity", "EconomicClass", "BusinessClass"});
        Object[] row = new Object[12];

        for (int i = 0; i < users.size(); i++) {
            row[0] = users.get(i).getID();
            row[1] = users.get(i).getID2();
            row[2] = users.get(i).getDate();
            row[3] = users.get(i).getArrival();
            row[4] = users.get(i).getTrangit();
            row[5] = users.get(i).getDeparture();
            row[6] = users.get(i).getAirline();
            row[7] = users.get(i).getArrivalTime();
            row[8] = users.get(i).getDepartureTime();
            row[9] = users.get(i).getSeat();
            row[10] = users.get(i).getEconomic();
            row[11] = users.get(i).getBusiness();
            model.addRow(row);
        }
        FlightInfoFinalTable.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        FlightInfoFinalTable = new javax.swing.JTable();
        SearchTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        ClockTxt = new javax.swing.JLabel();
        DateTxt1 = new javax.swing.JLabel();
        FlightFinalIDTxt = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        ConfirmBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        FlightDateTxt = new com.toedter.calendar.JDateChooser();
        jSeparator4 = new javax.swing.JSeparator();
        FlightIDTxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Back = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 121, 107));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        FlightInfoFinalTable.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        FlightInfoFinalTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        FlightInfoFinalTable.setRowHeight(30);
        FlightInfoFinalTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FlightInfoFinalTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(FlightInfoFinalTable);
        if (FlightInfoFinalTable.getColumnModel().getColumnCount() > 0) {
            FlightInfoFinalTable.getColumnModel().getColumn(0).setResizable(false);
            FlightInfoFinalTable.getColumnModel().getColumn(1).setResizable(false);
            FlightInfoFinalTable.getColumnModel().getColumn(2).setResizable(false);
            FlightInfoFinalTable.getColumnModel().getColumn(3).setResizable(false);
            FlightInfoFinalTable.getColumnModel().getColumn(4).setResizable(false);
            FlightInfoFinalTable.getColumnModel().getColumn(5).setResizable(false);
            FlightInfoFinalTable.getColumnModel().getColumn(6).setResizable(false);
            FlightInfoFinalTable.getColumnModel().getColumn(7).setResizable(false);
            FlightInfoFinalTable.getColumnModel().getColumn(8).setResizable(false);
            FlightInfoFinalTable.getColumnModel().getColumn(9).setResizable(false);
            FlightInfoFinalTable.getColumnModel().getColumn(10).setResizable(false);
            FlightInfoFinalTable.getColumnModel().getColumn(11).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 1600, -1));

        SearchTxt.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        SearchTxt.setForeground(new java.awt.Color(255, 255, 255));
        SearchTxt.setBorder(null);
        SearchTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchTxtKeyReleased(evt);
            }
        });
        jPanel1.add(SearchTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 190, 430, 70));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search_25px.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 190, -1, 70));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 260, 460, 20));

        ClockTxt.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        ClockTxt.setForeground(new java.awt.Color(255, 255, 255));
        ClockTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(ClockTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 90, 280, 70));

        DateTxt1.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        DateTxt1.setForeground(new java.awt.Color(255, 255, 255));
        DateTxt1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(DateTxt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 20, 280, 70));

        FlightFinalIDTxt.setEditable(false);
        FlightFinalIDTxt.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        FlightFinalIDTxt.setForeground(new java.awt.Color(255, 255, 255));
        FlightFinalIDTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        FlightFinalIDTxt.setBorder(null);
        jPanel1.add(FlightFinalIDTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 170, 60));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 170, 10));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Final Flight ID");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 170, 60));

        ConfirmBtn.setBackground(new java.awt.Color(102, 255, 153));
        ConfirmBtn.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        ConfirmBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/checked_50px.png"))); // NOI18N
        ConfirmBtn.setText("UPDATE");
        ConfirmBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ConfirmBtnMouseClicked(evt);
            }
        });
        jPanel1.add(ConfirmBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 190, 180, 60));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Select Date");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 140, 60));

        FlightDateTxt.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jPanel1.add(FlightDateTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 310, 60));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, 170, 10));

        FlightIDTxt.setEditable(false);
        FlightIDTxt.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        FlightIDTxt.setForeground(new java.awt.Color(255, 255, 255));
        FlightIDTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        FlightIDTxt.setBorder(null);
        jPanel1.add(FlightIDTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 170, 60));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Flight ID");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, 170, 60));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close_window_48px.png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1550, 0, -1, -1));

        Back.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Back.setIcon(new javax.swing.ImageIcon("D:\\Fly Sky-Air Ticket Management\\Fly Sky-Air Ticket Management\\src\\images\\circled_left_48px.png")); // NOI18N
        Back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackMouseClicked(evt);
            }
        });
        jPanel1.add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 850, -1, -1));

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

        setSize(new java.awt.Dimension(1600, 897));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void SearchTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchTxtKeyReleased
        // TODO add your handling code here:
        filter();
    }//GEN-LAST:event_SearchTxtKeyReleased

    private void FlightInfoFinalTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FlightInfoFinalTableMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) FlightInfoFinalTable.getModel();
        int selectedRowIndex = FlightInfoFinalTable.getSelectedRow();
        FlightFinalIDTxt.setText(model.getValueAt(selectedRowIndex, 0).toString());
        FlightIDTxt.setText(model.getValueAt(selectedRowIndex, 1).toString());
    }//GEN-LAST:event_FlightInfoFinalTableMouseClicked

    private void ConfirmBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConfirmBtnMouseClicked
        // TODO add your handling code here:
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager
            .getConnection(
                "jdbc:sqlserver://localhost:1433;databaseName=FLY_SKY;selectMethod=cursor", "sa", "123456");
            query1 = "UPDATE FLIGHT_INFO_FINAL SET FlightID=?, FlightDate=? where FlightFinalID="+FlightFinalIDTxt.getText();
            PreparedStatement pst = conn.prepareStatement(query1);
            pst.setString(1, FlightIDTxt.getText());
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            String date=sdf.format(FlightDateTxt.getDate());
            pst.setString(2, date);
            pst.executeUpdate();
            FlightIDTxt.setText("Enter Flight ID Here...");
            FlightDateTxt.setDate(null);
            ImageIcon icon = new ImageIcon("src/images/ok_48px.png");
            JOptionPane.showMessageDialog(null, "Updated Successfully", "Successfull", JOptionPane.INFORMATION_MESSAGE, icon);
        }
        catch(Exception e)
        {

        }
    }//GEN-LAST:event_ConfirmBtnMouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel6MouseClicked

    private void BackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new UpdateEmployee().setVisible(true);
    }//GEN-LAST:event_BackMouseClicked
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
            java.util.logging.Logger.getLogger(UpdateSchedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateSchedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateSchedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateSchedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateSchedule().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Back;
    private javax.swing.JLabel ClockTxt;
    private javax.swing.JButton ConfirmBtn;
    private javax.swing.JLabel DateTxt1;
    private com.toedter.calendar.JDateChooser FlightDateTxt;
    private javax.swing.JTextField FlightFinalIDTxt;
    private javax.swing.JTextField FlightIDTxt;
    private javax.swing.JTable FlightInfoFinalTable;
    private javax.swing.JTextField SearchTxt;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    // End of variables declaration//GEN-END:variables
}
