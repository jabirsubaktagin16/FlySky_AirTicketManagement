package Fly;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class Employee extends javax.swing.JFrame {

    public String query;

    public Employee() {
        initComponents();
        NewPassenger.setBackground(new Color(103, 58, 183,0));
        BillBtn.setBackground(new Color(103, 58, 183,0));
        UpdateBtn.setBackground(new Color(103, 58, 183,0));
        TicketInfo.setBackground(new Color(103, 58, 183,0));
        SignOut.setBackground(new Color(103, 58, 183,0));
        DeleteBtn.setBackground(new Color(103, 58, 183,0));
        FlightInfo.setBackground(new Color(103, 58, 183,0));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        BillBtn = new javax.swing.JButton();
        NewPassenger = new javax.swing.JButton();
        TicketInfo = new javax.swing.JButton();
        UpdateBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        SignOut = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        DeleteBtn = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        FlightInfo = new javax.swing.JButton();
        OtherInfo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel3.setBackground(new java.awt.Color(0, 121, 107));
        jPanel3.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Update");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(580, 350, 300, 70);

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Ticket Info");
        jPanel3.add(jLabel3);
        jLabel3.setBounds(580, 590, 300, 70);

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Bill");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(210, 590, 300, 70);

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Add");
        jPanel3.add(jLabel1);
        jLabel1.setBounds(210, 350, 300, 70);

        BillBtn.setBackground(new java.awt.Color(103, 58, 183));
        BillBtn.setIcon(new javax.swing.ImageIcon("D:\\Fly Sky-Air Ticket Management\\Fly Sky-Air Ticket Management\\src\\images\\money_filled_100px.png")); // NOI18N
        BillBtn.setBorder(null);
        BillBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BillBtnMouseClicked(evt);
            }
        });
        jPanel3.add(BillBtn);
        BillBtn.setBounds(210, 450, 300, 210);

        NewPassenger.setBackground(new java.awt.Color(103, 58, 183));
        NewPassenger.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add_filled_100px.png"))); // NOI18N
        NewPassenger.setBorder(null);
        NewPassenger.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NewPassengerMouseClicked(evt);
            }
        });
        jPanel3.add(NewPassenger);
        NewPassenger.setBounds(210, 210, 300, 210);

        TicketInfo.setBackground(new java.awt.Color(103, 58, 183));
        TicketInfo.setIcon(new javax.swing.ImageIcon("D:\\Fly Sky-Air Ticket Management\\Fly Sky-Air Ticket Management\\src\\images\\ticket_filled_100px.png")); // NOI18N
        TicketInfo.setBorder(null);
        TicketInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TicketInfoMouseClicked(evt);
            }
        });
        jPanel3.add(TicketInfo);
        TicketInfo.setBounds(580, 450, 300, 210);

        UpdateBtn.setBackground(new java.awt.Color(103, 58, 183));
        UpdateBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/update_tag_filled_100px.png"))); // NOI18N
        UpdateBtn.setBorder(null);
        UpdateBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UpdateBtnMouseClicked(evt);
            }
        });
        jPanel3.add(UpdateBtn);
        UpdateBtn.setBounds(580, 210, 300, 210);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close_window_48px.png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel6);
        jLabel6.setBounds(1421, -10, 50, 60);

        jLabel5.setFont(new java.awt.Font("Tekton Pro Cond", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("(Airport Employee Page)");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(0, 120, 1460, 40);

        jLabel7.setFont(new java.awt.Font("Tekton Pro Cond", 1, 48)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Welcome to Fly Sky");
        jPanel3.add(jLabel7);
        jLabel7.setBounds(0, 80, 1460, 50);

        SignOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit_filled_50px.png"))); // NOI18N
        SignOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SignOutMouseClicked(evt);
            }
        });
        jPanel3.add(SignOut);
        SignOut.setBounds(1400, 760, 60, 70);

        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Delete");
        jPanel3.add(jLabel8);
        jLabel8.setBounds(950, 350, 300, 70);

        DeleteBtn.setBackground(new java.awt.Color(103, 58, 183));
        DeleteBtn.setIcon(new javax.swing.ImageIcon("D:\\Fly Sky-Air Ticket Management\\Fly Sky-Air Ticket Management\\src\\images\\delete_100px.png")); // NOI18N
        DeleteBtn.setBorder(null);
        DeleteBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DeleteBtnMouseClicked(evt);
            }
        });
        jPanel3.add(DeleteBtn);
        DeleteBtn.setBounds(950, 210, 300, 210);

        jLabel9.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Flight Info");
        jPanel3.add(jLabel9);
        jLabel9.setBounds(950, 590, 300, 70);

        FlightInfo.setBackground(new java.awt.Color(103, 58, 183));
        FlightInfo.setIcon(new javax.swing.ImageIcon("D:\\Fly Sky-Air Ticket Management\\Fly Sky-Air Ticket Management\\src\\images\\airport_filled_100px.png")); // NOI18N
        FlightInfo.setBorder(null);
        FlightInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FlightInfoMouseClicked(evt);
            }
        });
        jPanel3.add(FlightInfo);
        FlightInfo.setBounds(950, 450, 300, 210);

        OtherInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        OtherInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/info_25px.png"))); // NOI18N
        OtherInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OtherInfoMouseClicked(evt);
            }
        });
        jPanel3.add(OtherInfo);
        OtherInfo.setBounds(0, 0, 40, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1464, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 840, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1464, 840));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel6MouseClicked

    private void NewPassengerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NewPassengerMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new AddItem().setVisible(true);
    }//GEN-LAST:event_NewPassengerMouseClicked

    private void UpdateBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateBtnMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new UpdateEmployee().setVisible(true);
    }//GEN-LAST:event_UpdateBtnMouseClicked

    private void BillBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BillBtnMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new BillMethod().setVisible(true);
    }//GEN-LAST:event_BillBtnMouseClicked

    private void TicketInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TicketInfoMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new FinalTicketTable().setVisible(true);
    }//GEN-LAST:event_TicketInfoMouseClicked

    private void SignOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SignOutMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new CompanyFirstPage().setVisible(true);
    }//GEN-LAST:event_SignOutMouseClicked

    private void DeleteBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteBtnMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new DeletePage().setVisible(true);
    }//GEN-LAST:event_DeleteBtnMouseClicked

    private void FlightInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FlightInfoMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new FlightInfoTable().setVisible(true);
    }//GEN-LAST:event_FlightInfoMouseClicked

    private void OtherInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OtherInfoMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new OtherInfo().setVisible(true);
    }//GEN-LAST:event_OtherInfoMouseClicked

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
            java.util.logging.Logger.getLogger(Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Employee().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BillBtn;
    private javax.swing.JButton DeleteBtn;
    private javax.swing.JButton FlightInfo;
    private javax.swing.JButton NewPassenger;
    private javax.swing.JLabel OtherInfo;
    private javax.swing.JButton SignOut;
    private javax.swing.JButton TicketInfo;
    private javax.swing.JButton UpdateBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}