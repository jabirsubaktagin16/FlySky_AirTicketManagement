package Fly;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class TicketBuying extends javax.swing.JFrame {

    public String query;
    public TicketBuying() {
        initComponents();
        IDTxt.setBackground(new Color(0,0,0,0));
        FlightNo.setBackground(new Color(0,0,0,0));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooserDialog1 = new datechooser.beans.DateChooserDialog();
        jPanel2 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        IDTxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        BackBtn = new javax.swing.JButton();
        ExitBtn = new javax.swing.JButton();
        FlightNo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ClassCmb = new javax.swing.JComboBox<>();
        FlightInfoBtn = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        ConfirmBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 340, 370, 20));

        IDTxt.setBackground(new java.awt.Color(0, 0, 0));
        IDTxt.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        IDTxt.setForeground(new java.awt.Color(255, 255, 255));
        IDTxt.setText("Enter Your Passenger ID Here..");
        IDTxt.setBorder(null);
        IDTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                IDTxtMouseClicked(evt);
            }
        });
        jPanel2.add(IDTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 290, 370, 50));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Pasenger ID");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 230, 150, 60));

        BackBtn.setBackground(new java.awt.Color(255, 102, 0));
        BackBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BackBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-home-page-30.png"))); // NOI18N
        BackBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackBtnMouseClicked(evt);
            }
        });
        jPanel2.add(BackBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 0, 40, 40));

        ExitBtn.setBackground(new java.awt.Color(255, 0, 0));
        ExitBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ExitBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-shutdown-32.png"))); // NOI18N
        ExitBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExitBtnMouseClicked(evt);
            }
        });
        jPanel2.add(ExitBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 0, 40, 40));

        FlightNo.setBackground(new java.awt.Color(0, 0, 0));
        FlightNo.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        FlightNo.setForeground(new java.awt.Color(255, 255, 255));
        FlightNo.setText("Enter Your Flight No. Here..");
        FlightNo.setBorder(null);
        FlightNo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FlightNoMouseClicked(evt);
            }
        });
        jPanel2.add(FlightNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 400, 370, 50));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Flight No.");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 340, 150, 60));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Class");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 450, 150, 60));

        ClassCmb.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        ClassCmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---------Select Your Class--------", "Economic", "Business" }));
        ClassCmb.setBorder(null);
        jPanel2.add(ClassCmb, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 510, 370, 50));

        FlightInfoBtn.setBackground(new java.awt.Color(51, 255, 102));
        FlightInfoBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        FlightInfoBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/airport_filled_25px.png"))); // NOI18N
        FlightInfoBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FlightInfoBtnMouseClicked(evt);
            }
        });
        jPanel2.add(FlightInfoBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 400, 50, 50));
        jPanel2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 450, 370, 20));

        ConfirmBtn.setBackground(new java.awt.Color(102, 255, 153));
        ConfirmBtn.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        ConfirmBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/checked_50px.png"))); // NOI18N
        ConfirmBtn.setText("CONFIRM");
        ConfirmBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ConfirmBtnMouseClicked(evt);
            }
        });
        jPanel2.add(ConfirmBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 610, 180, 60));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Webp.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1440, 930));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1440, 934));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void IDTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IDTxtMouseClicked
        IDTxt.setText("");
    }//GEN-LAST:event_IDTxtMouseClicked

    private void BackBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackBtnMouseClicked
        this.setVisible(false);
        CustomerFirstPage cfp=new CustomerFirstPage();
        cfp.setVisible(true);
    }//GEN-LAST:event_BackBtnMouseClicked

    private void ExitBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitBtnMouseClicked
        System.exit(0);
    }//GEN-LAST:event_ExitBtnMouseClicked

    private void FlightNoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FlightNoMouseClicked
        FlightNo.setText("");
    }//GEN-LAST:event_FlightNoMouseClicked

    private void FlightInfoBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FlightInfoBtnMouseClicked
        this.setVisible(false);
        new FlightInfoTable().setVisible(true);
    }//GEN-LAST:event_FlightInfoBtnMouseClicked

    private void ConfirmBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConfirmBtnMouseClicked
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager
            .getConnection(
                "jdbc:sqlserver://localhost:1433;databaseName=FLY_SKY;selectMethod=cursor","sa", "123456");
            query="insert into TICKET_BUYING(CustomerId, FlightFinalID, Class)values(?,?,?)";
            PreparedStatement pst=conn.prepareStatement(query);
            
            pst.setString(1,IDTxt.getText() );
            pst.setString(2, FlightNo.getText());
            pst.setString(3, ClassCmb.getSelectedItem().toString());
            pst.executeUpdate();
            IDTxt.setText("Enter Your Passenger ID Here..");
            FlightNo.setText("Enter Your Flight No. Here..");
            ClassCmb.setSelectedIndex(0);
            ImageIcon icon = new ImageIcon("src/images/ok_48px.png");
                JOptionPane.showMessageDialog(null, "Inserted Successfully","Successfull",JOptionPane.INFORMATION_MESSAGE,icon);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Please Insert Correctly");
        }
    }//GEN-LAST:event_ConfirmBtnMouseClicked

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
            java.util.logging.Logger.getLogger(TicketBuying.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TicketBuying.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TicketBuying.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TicketBuying.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TicketBuying().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackBtn;
    public javax.swing.JComboBox<String> ClassCmb;
    private javax.swing.JButton ConfirmBtn;
    private javax.swing.JButton ExitBtn;
    private javax.swing.JButton FlightInfoBtn;
    private javax.swing.JTextField FlightNo;
    private javax.swing.JTextField IDTxt;
    private datechooser.beans.DateChooserDialog dateChooserDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    // End of variables declaration//GEN-END:variables
}
