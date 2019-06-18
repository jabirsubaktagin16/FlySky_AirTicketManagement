/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fly;

import Connection.User;
import Connection.User2;
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
public class EmployeeTable extends javax.swing.JFrame {

    /**
     * Creates new form CompanyFirstPage
     */
    public EmployeeTable() {
        initComponents();
        show_user();
    }
public ArrayList<User2> userList() {
        ArrayList<User2> usersList = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager
                    .getConnection(
                            "jdbc:sqlserver://localhost:1433;databaseName=FLY_SKY;selectMethod=cursor", "sa", "123456");

            String query1 = "SELECT EmployeeId,Name,EmployeeType,Email,ContactNo FROM EMPLOYEE";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query1);
            User2 user;
            while (rs.next()) {
                user = new User2(rs.getInt("EmployeeId"), rs.getString("Name"), rs.getString("EmployeeType"), rs.getString("Email"), rs.getString("ContactNo"));
                usersList.add(user);
            }
        } catch (Exception E) {
            E.printStackTrace();
        }
        return usersList;
    }
    public void show_user()
    {
        ArrayList<User2> list= userList();
        DefaultTableModel model=(DefaultTableModel)EmployeeTable.getModel();
        Object[] row = new Object[5];
        for(int i=0;i<list.size();i++){
            row[0]=list.get(i).getID();
            row[1]=list.get(i).getName();
            row[2]=list.get(i).getEmployeeType();
            row[3]=list.get(i).getEmail();
            row[4]=list.get(i).getPhone();
            model.addRow(row);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        EmployeeTable = new javax.swing.JTable();
        BackBtn1 = new javax.swing.JButton();
        ExitBtn1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(null);

        EmployeeTable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        EmployeeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Employee ID", "Name", "Employee Type", "Email", "Contact No"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        EmployeeTable.setRowHeight(26);
        jScrollPane1.setViewportView(EmployeeTable);
        if (EmployeeTable.getColumnModel().getColumnCount() > 0) {
            EmployeeTable.getColumnModel().getColumn(0).setResizable(false);
            EmployeeTable.getColumnModel().getColumn(1).setResizable(false);
            EmployeeTable.getColumnModel().getColumn(2).setResizable(false);
            EmployeeTable.getColumnModel().getColumn(3).setResizable(false);
            EmployeeTable.getColumnModel().getColumn(4).setResizable(false);
        }

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(0, 110, 1440, 402);

        BackBtn1.setBackground(new java.awt.Color(255, 102, 0));
        BackBtn1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BackBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-home-page-30.png"))); // NOI18N
        BackBtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackBtn1MouseClicked(evt);
            }
        });
        jPanel1.add(BackBtn1);
        BackBtn1.setBounds(1360, 0, 40, 40);

        ExitBtn1.setBackground(new java.awt.Color(255, 0, 0));
        ExitBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-shutdown-32.png"))); // NOI18N
        ExitBtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExitBtn1MouseClicked(evt);
            }
        });
        jPanel1.add(ExitBtn1);
        ExitBtn1.setBounds(1400, 0, 40, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/CompanyFirstPage.jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 1440, 810);

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

    private void BackBtn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackBtn1MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        CompanyFirstPage cfp=new CompanyFirstPage();
        cfp.setVisible(true);
    }//GEN-LAST:event_BackBtn1MouseClicked

    private void ExitBtn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitBtn1MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_ExitBtn1MouseClicked

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
            java.util.logging.Logger.getLogger(EmployeeTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeTable().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackBtn1;
    private javax.swing.JTable EmployeeTable;
    private javax.swing.JButton ExitBtn1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
