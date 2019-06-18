package Fly;

import static com.sun.corba.se.impl.util.Utility.printStackTrace;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

public class UpdateFlightInfo extends javax.swing.JFrame {

    public String query1;
    public String trangit;
    public UpdateFlightInfo() {
        initComponents();
        updateCombo();
    }

    private void updateCombo() {
        String sql = "SELECT * FROM AIRLINE";
        String query = "SELECT * FROM PLACE";
        try {
            Connection con = DriverManager
                    .getConnection(
                            "jdbc:sqlserver://localhost:1433;databaseName=FLY_SKY;selectMethod=cursor", "sa", "123456");
            PreparedStatement pst = con.prepareStatement(sql);
            PreparedStatement pst2 = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            ResultSet rs2 = pst2.executeQuery();
            while (rs.next()) {
                AirlineNameCmb.addItem(rs.getString("AirlineName"));
            }
            while (rs2.next()) {
                FromCmb.addItem(rs2.getString("PlaceName"));
                TranCmb.addItem(rs2.getString("PlaceName"));
                ToCmb.addItem(rs2.getString("PlaceName"));
            }
        } catch (Exception e) {
            printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTimeChooserDemo1 = new lu.tudor.santec.jtimechooser.demo.JTimeChooserDemo();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        TranCmb = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        Economic = new javax.swing.JTextField();
        ToCmb = new javax.swing.JComboBox<>();
        FromCmb = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        ExitBtn1 = new javax.swing.JButton();
        BackBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        AirlineNameCmb = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        ArrivalTime = new lu.tudor.santec.jtimechooser.JTimeChooser();
        DepartureTime = new lu.tudor.santec.jtimechooser.JTimeChooser();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Business = new javax.swing.JTextField();
        UpdateBtn = new javax.swing.JButton();
        SeatCapacity = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        FlightIDTxt = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        ReadView3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("SEAT CAPACITY");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(460, 410, 180, 31);

        TranCmb.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        TranCmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT TRANGIT POINT" }));
        jPanel1.add(TranCmb);
        TranCmb.setBounds(460, 210, 350, 50);

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ECONOMIC CLASS RATE");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(50, 540, 350, 31);

        Economic.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        Economic.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Economic.setText("0.00");
        Economic.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EconomicMouseClicked(evt);
            }
        });
        jPanel1.add(Economic);
        Economic.setBounds(50, 590, 350, 50);

        ToCmb.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        ToCmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT DESTINATION" }));
        jPanel1.add(ToCmb);
        ToCmb.setBounds(860, 210, 350, 50);

        FromCmb.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        FromCmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT DEPARTURE PLACE" }));
        jPanel1.add(FromCmb);
        FromCmb.setBounds(50, 210, 350, 50);

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("EXPECTED ARRIVAL TIME");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(460, 280, 420, 31);

        ExitBtn1.setBackground(new java.awt.Color(255, 0, 0));
        ExitBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-shutdown-32.png"))); // NOI18N
        ExitBtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExitBtn1MouseClicked(evt);
            }
        });
        jPanel1.add(ExitBtn1);
        ExitBtn1.setBounds(1240, 0, 40, 40);

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
        jPanel1.add(BackBtn);
        BackBtn.setBounds(1200, 0, 40, 40);

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("FROM");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(50, 160, 68, 31);

        AirlineNameCmb.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        AirlineNameCmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT YOUR AIRLINE" }));
        AirlineNameCmb.setOpaque(false);
        jPanel1.add(AirlineNameCmb);
        AirlineNameCmb.setBounds(50, 460, 360, 50);

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("TRANGIT POINT");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(460, 150, 260, 31);

        ArrivalTime.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jPanel1.add(ArrivalTime);
        ArrivalTime.setBounds(460, 340, 350, 50);

        DepartureTime.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jPanel1.add(DepartureTime);
        DepartureTime.setBounds(50, 340, 350, 50);

        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("DEPARTURE TIME");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(50, 280, 280, 31);

        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("TO");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(860, 160, 30, 31);

        jLabel9.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("BUSINESS CLASS RATE");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(460, 540, 350, 31);

        Business.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        Business.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Business.setText("0.00");
        Business.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BusinessMouseClicked(evt);
            }
        });
        jPanel1.add(Business);
        Business.setBounds(460, 590, 350, 50);

        UpdateBtn.setBackground(new java.awt.Color(102, 255, 102));
        UpdateBtn.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        UpdateBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/approve_and_update_50px.png"))); // NOI18N
        UpdateBtn.setText("UPDATE");
        UpdateBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UpdateBtnMouseClicked(evt);
            }
        });
        jPanel1.add(UpdateBtn);
        UpdateBtn.setBounds(600, 690, 180, 80);

        SeatCapacity.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        SeatCapacity.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        SeatCapacity.setText("0");
        SeatCapacity.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SeatCapacityMouseClicked(evt);
            }
        });
        jPanel1.add(SeatCapacity);
        SeatCapacity.setBounds(460, 460, 220, 50);

        jLabel10.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("AIRLINE NAME");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(50, 410, 250, 31);

        FlightIDTxt.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        FlightIDTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        FlightIDTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FlightIDTxtMouseClicked(evt);
            }
        });
        FlightIDTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                FlightIDTxtKeyReleased(evt);
            }
        });
        jPanel1.add(FlightIDTxt);
        FlightIDTxt.setBounds(50, 90, 350, 50);

        jLabel11.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("FLIGHT ID");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(50, 40, 350, 31);

        ReadView3.setBackground(new java.awt.Color(51, 255, 102));
        ReadView3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ReadView3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-day-view-32.png"))); // NOI18N
        ReadView3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ReadView3MouseClicked(evt);
            }
        });
        jPanel1.add(ReadView3);
        ReadView3.setBounds(410, 90, 65, 50);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/airplane-wallpaper-42-610x381.jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 1280, 800);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1281, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1281, 800));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ExitBtn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitBtn1MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_ExitBtn1MouseClicked

    private void BackBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackBtnMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new UpdateEmployee().setVisible(true);
    }//GEN-LAST:event_BackBtnMouseClicked

    private void BackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BackBtnActionPerformed

    private void UpdateBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateBtnMouseClicked
        // TODO add your handling code here:
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager
                    .getConnection(
                            "jdbc:sqlserver://localhost:1433;databaseName=FLY_SKY;selectMethod=cursor", "sa", "123456");
            query1 = "UPDATE FLIGHT_INFO SET StartingPlace=?, TrangitPoint=?, Destination=?, AirLineName=?, DepartureTime=?, ArrivalTime=?, SeatCapacity=?, EconomicClass=?, BusinessClass=? where FlightID="+FlightIDTxt.getText();
            PreparedStatement pst = conn.prepareStatement(query1);
            pst.setString(1, FromCmb.getSelectedItem().toString());
            if (TranCmb.getSelectedItem().equals("SELECT TRANGIT POINT")) {
                trangit="";
            } else {
                trangit=TranCmb.getSelectedItem().toString();
            }
            pst.setString(2, trangit);
            pst.setString(3, ToCmb.getSelectedItem().toString());
            pst.setString(4, AirlineNameCmb.getSelectedItem().toString());
            pst.setString(5, DepartureTime.getFormatedTime());
            pst.setString(6, ArrivalTime.getFormatedTime());
            pst.setString(7, SeatCapacity.getText());
            pst.setString(8, Economic.getText());
            pst.setString(9, Business.getText());
            pst.executeUpdate();
            FromCmb.setSelectedIndex(0);
            TranCmb.setSelectedIndex(0);
            ToCmb.setSelectedIndex(0);
            AirlineNameCmb.setSelectedIndex(0);
            SeatCapacity.setText("0");
            Economic.setText("0.00");
            Business.setText("0.00");
            ImageIcon icon = new ImageIcon("src/images/ok_48px.png");
            JOptionPane.showMessageDialog(null, "Updated Successfully", "Successfull", JOptionPane.INFORMATION_MESSAGE, icon);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please Update Correctly");
        }
    }//GEN-LAST:event_UpdateBtnMouseClicked

    private void EconomicMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EconomicMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_EconomicMouseClicked

    private void BusinessMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BusinessMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_BusinessMouseClicked

    private void SeatCapacityMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SeatCapacityMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_SeatCapacityMouseClicked

    private void FlightIDTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FlightIDTxtMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_FlightIDTxtMouseClicked

    private void FlightIDTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FlightIDTxtKeyReleased
        // TODO add your handling code here:
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager
            .getConnection(
                "jdbc:sqlserver://localhost:1433;databaseName=FLY_SKY;selectMethod=cursor","sa", "123456");
            query1="SELECT * FROM FLIGHT_INFO WHERE FlightID=?";
            PreparedStatement pst=conn.prepareStatement(query1);
            pst.setString(1, (String)FlightIDTxt.getText());
            ResultSet rs = pst.executeQuery();
            while(rs.next())
            {
                FromCmb.setSelectedItem(rs.getString("StartingPlace"));
                TranCmb.setSelectedItem(rs.getString("TrangitPoint"));
                ToCmb.setSelectedItem(rs.getString("Destination"));
                AirlineNameCmb.setSelectedItem(rs.getString("AirLineName"));
                SeatCapacity.setText(rs.getString("SeatCapacity"));
                Economic.setText(rs.getString("EconomicClass"));
                Business.setText(rs.getString("BusinessClass"));
            }
        }
        catch(Exception e)
        {
            printStackTrace();
        }
    }//GEN-LAST:event_FlightIDTxtKeyReleased

    private void ReadView3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReadView3MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new AddDatePage().setVisible(true);
    }//GEN-LAST:event_ReadView3MouseClicked

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
            java.util.logging.Logger.getLogger(UpdateFlightInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateFlightInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateFlightInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateFlightInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateFlightInfo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> AirlineNameCmb;
    private lu.tudor.santec.jtimechooser.JTimeChooser ArrivalTime;
    private javax.swing.JButton BackBtn;
    private javax.swing.JTextField Business;
    private lu.tudor.santec.jtimechooser.JTimeChooser DepartureTime;
    private javax.swing.JTextField Economic;
    private javax.swing.JButton ExitBtn1;
    private javax.swing.JTextField FlightIDTxt;
    private javax.swing.JComboBox<String> FromCmb;
    private javax.swing.JButton ReadView;
    private javax.swing.JButton ReadView1;
    private javax.swing.JButton ReadView2;
    private javax.swing.JButton ReadView3;
    private javax.swing.JTextField SeatCapacity;
    private javax.swing.JComboBox<String> ToCmb;
    private javax.swing.JComboBox<String> TranCmb;
    private javax.swing.JButton UpdateBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private lu.tudor.santec.jtimechooser.demo.JTimeChooserDemo jTimeChooserDemo1;
    // End of variables declaration//GEN-END:variables
}
