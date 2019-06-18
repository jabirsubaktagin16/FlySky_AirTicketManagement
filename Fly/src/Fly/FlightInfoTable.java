package Fly;

import Connection.Flight;
import Connection.FlightInfoFinal;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

public class FlightInfoTable extends javax.swing.JFrame {

    String query = "SELECT * FROM FLIGHT_INFO_FINAL INNER JOIN FLIGHT_INFO ON FLIGHT_INFO_FINAL.FlightID=FLIGHT_INFO.FlightID";
    public FlightInfoTable() {
        
        initComponents();
        showDate();
        showTime();
        showUserTable(query);
        filter();
        FlightFinalIDTxt.setBackground(new Color(0, 0, 0, 0));
        SearchTxt.setBackground(new Color(0, 0, 0, 0));
        DateTxt1.setBackground(new Color(0, 0, 0, 0));
        ClockTxt.setBackground(new Color(0, 0, 0, 0));
        AvailablityTxt.setBackground(new Color(0, 0, 0, 0));
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
        ExitBtn1 = new javax.swing.JButton();
        BackBtn = new javax.swing.JButton();
        SearchTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        ClockTxt = new javax.swing.JLabel();
        DateTxt1 = new javax.swing.JLabel();
        FlightFinalIDTxt = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        AvailablityTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        BackBtn1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

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

        ExitBtn1.setBackground(new java.awt.Color(255, 0, 0));
        ExitBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-shutdown-32.png"))); // NOI18N
        ExitBtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExitBtn1MouseClicked(evt);
            }
        });
        jPanel1.add(ExitBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1550, 0, 50, 50));

        BackBtn.setBackground(new java.awt.Color(0, 204, 204));
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
        jPanel1.add(BackBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1500, 0, 50, 50));

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
        jPanel1.add(FlightFinalIDTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 170, 60));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 170, 10));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 840, 420, 10));

        AvailablityTxt.setEditable(false);
        AvailablityTxt.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        AvailablityTxt.setForeground(new java.awt.Color(255, 255, 255));
        AvailablityTxt.setBorder(null);
        jPanel1.add(AvailablityTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 780, 420, 60));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Final Flight ID");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 151, 170, 60));

        BackBtn1.setBackground(new java.awt.Color(255, 102, 51));
        BackBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back_26px.png"))); // NOI18N
        BackBtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackBtn1MouseClicked(evt);
            }
        });
        BackBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackBtn1ActionPerformed(evt);
            }
        });
        jPanel1.add(BackBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1450, 0, 50, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Airplane wallpaper HD 2.jpg"))); // NOI18N
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

        setSize(new java.awt.Dimension(1600, 897));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ExitBtn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitBtn1MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_ExitBtn1MouseClicked

    private void BackBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackBtnMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new Employee().setVisible(true);
    }//GEN-LAST:event_BackBtnMouseClicked

    private void BackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BackBtnActionPerformed

    private void SearchTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchTxtKeyReleased
        // TODO add your handling code here:
        filter();
    }//GEN-LAST:event_SearchTxtKeyReleased

    private void FlightInfoFinalTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FlightInfoFinalTableMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) FlightInfoFinalTable.getModel();
        int selectedRowIndex = FlightInfoFinalTable.getSelectedRow();
        FlightFinalIDTxt.setText(model.getValueAt(selectedRowIndex, 0).toString());
    }//GEN-LAST:event_FlightInfoFinalTableMouseClicked

    private void BackBtn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackBtn1MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new TicketBuying().setVisible(true);
    }//GEN-LAST:event_BackBtn1MouseClicked

    private void BackBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BackBtn1ActionPerformed
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
            java.util.logging.Logger.getLogger(FlightInfoTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FlightInfoTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FlightInfoTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FlightInfoTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FlightInfoTable().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AvailablityTxt;
    private javax.swing.JButton BackBtn;
    private javax.swing.JButton BackBtn1;
    private javax.swing.JLabel ClockTxt;
    private javax.swing.JLabel DateTxt1;
    private javax.swing.JButton ExitBtn1;
    private javax.swing.JTextField FlightFinalIDTxt;
    private javax.swing.JTable FlightInfoFinalTable;
    private javax.swing.JTextField SearchTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    // End of variables declaration//GEN-END:variables
}
