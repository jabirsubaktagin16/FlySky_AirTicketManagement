package Fly;

import Connection.Flight;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class AddDatePage extends javax.swing.JFrame {

    String query="SELECT * FROM FLIGHT_INFO";
    String query1;
    public AddDatePage() {
        initComponents();
        showUserTable(query);
        filter();
        FlightIDTxt.setBackground(new Color(0,0,0,10));
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
public ArrayList<Flight> ListUsers(String query)
{
    ArrayList<Flight> usersList = new ArrayList<Flight>();
    Connection con = getConnection();
    Statement st;
    ResultSet rs;
    try
    {
        st=con.createStatement();
        rs=st.executeQuery(query);
        Flight user;
        while(rs.next())
        {
            user=new Flight(
                    rs.getInt("FlightID"), rs.getString("StartingPlace"), rs.getString("TrangitPoint"), rs.getString("Destination"), rs.getString("AirLineName"),rs.getString("DepartureTime"), rs.getString("ArrivalTime"), rs.getInt("SeatCapacity"),rs.getString("EconomicClass"), rs.getString("BusinessClass"));
            usersList.add(user);
        }
        
    }catch(Exception ex)
    {
        ex.printStackTrace();
    }
    return usersList;
}

public ArrayList<Flight> ListUsers2(String valToSearch)
{
    ArrayList<Flight> usersList = new ArrayList<Flight>();
    Connection con = getConnection();
    Statement st;
    ResultSet rs;
    try
    {
        st=con.createStatement();
        String searchquery="SELECT * FROM FLIGHT_INFO WHERE CONCAT(FlightID, StartingPlace, TrangitPoint, Destination, AirLineName, DepartureTime, ArrivalTime, SeatCapacity, EconomicClass, BusinessClass) LIKE '%"+valToSearch+"%'";
        rs=st.executeQuery(searchquery);
        Flight user;
        while(rs.next())
        {
            user=new Flight(
                    rs.getInt("FlightID"), rs.getString("StartingPlace"), rs.getString("TrangitPoint"), rs.getString("Destination"), rs.getString("AirLineName"),rs.getString("DepartureTime"), rs.getString("ArrivalTime"), rs.getInt("SeatCapacity"),rs.getString("EconomicClass"), rs.getString("BusinessClass"));
            usersList.add(user);
        }
        
    }catch(Exception ex)
    {
        ex.printStackTrace();
    }
    return usersList;
}
public void filter()
{
    ArrayList<Flight> users= ListUsers2(SearchTxt.getText());
    DefaultTableModel model=new DefaultTableModel();
    model.setColumnIdentifiers(new Object[]{"FlightID", "StartingPlace", "TrangitPoint", "Destination", "AirLineName", "DepartureTime", "ArrivalTime", "SeatCapacity", "EconomicClass", "BusinessClass"});
    Object[] row = new Object[10];
    
    for(int i=0;i<users.size();i++)
    {
        row[0]=users.get(i).getID();
        row[1]=users.get(i).getArrival();
        row[2]=users.get(i).getTrangit();
        row[3]=users.get(i).getDeparture();
        row[4]=users.get(i).getAirline();
        row[5]=users.get(i).getArrivalTime();
        row[6]=users.get(i).getDepartureTime();
        row[7]=users.get(i).getSeat();
        row[8]=users.get(i).getEconomic();
        row[9]=users.get(i).getBusiness();
        model.addRow(row);
    }
    FlightTable.setModel(model);
}

public void showUserTable(String OrderQuery)
{
    ArrayList<Flight> users = ListUsers(OrderQuery);
    DefaultTableModel model = new DefaultTableModel();
    model.setColumnIdentifiers(new Object[]{"FlightID", "StartingPlace", "TrangitPoint", "Destination", "AirLineName", "DepartureTime", "ArrivalTime", "SeatCapacity", "EconomicClass", "BusinessClass"});
    Object[] row = new Object[10];
    
    for(int i=0;i<users.size();i++)
    {
        row[0]=users.get(i).getID();
        row[1]=users.get(i).getArrival();
        row[2]=users.get(i).getTrangit();
        row[3]=users.get(i).getDeparture();
        row[4]=users.get(i).getAirline();
        row[5]=users.get(i).getArrivalTime();
        row[6]=users.get(i).getDepartureTime();
        row[7]=users.get(i).getSeat();
        row[8]=users.get(i).getEconomic();
        row[9]=users.get(i).getBusiness();
        model.addRow(row);
    }
    FlightTable.setModel(model);
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        ConfirmBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        FlightTable = new javax.swing.JTable();
        SearchTxt = new javax.swing.JTextField();
        BackBtn = new javax.swing.JButton();
        ExitBtn1 = new javax.swing.JButton();
        FlightIDTxt = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        FlightDateTxt = new com.toedter.calendar.JDateChooser();
        ReadView = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ConfirmBtn.setBackground(new java.awt.Color(102, 255, 153));
        ConfirmBtn.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        ConfirmBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/checked_50px.png"))); // NOI18N
        ConfirmBtn.setText("CONFIRM");
        ConfirmBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ConfirmBtnMouseClicked(evt);
            }
        });
        jPanel1.add(ConfirmBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 170, 180, 60));

        FlightTable.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        FlightTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Flight ID", "From", "Trangit Point", "To", "Airline Name", "Arrival Time", "Departure Time", "Seat Capacity", "Economic Class Rate", "Business Class Rate"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        FlightTable.setRowHeight(30);
        FlightTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FlightTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(FlightTable);
        if (FlightTable.getColumnModel().getColumnCount() > 0) {
            FlightTable.getColumnModel().getColumn(0).setResizable(false);
            FlightTable.getColumnModel().getColumn(1).setResizable(false);
            FlightTable.getColumnModel().getColumn(2).setResizable(false);
            FlightTable.getColumnModel().getColumn(3).setResizable(false);
            FlightTable.getColumnModel().getColumn(4).setResizable(false);
            FlightTable.getColumnModel().getColumn(5).setResizable(false);
            FlightTable.getColumnModel().getColumn(6).setResizable(false);
            FlightTable.getColumnModel().getColumn(7).setResizable(false);
            FlightTable.getColumnModel().getColumn(8).setResizable(false);
            FlightTable.getColumnModel().getColumn(9).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 1770, 560));

        SearchTxt.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        SearchTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        SearchTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SearchTxtMouseClicked(evt);
            }
        });
        SearchTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchTxtKeyReleased(evt);
            }
        });
        jPanel1.add(SearchTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 860, 460, 70));

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
        jPanel1.add(BackBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1670, 0, 50, 50));

        ExitBtn1.setBackground(new java.awt.Color(255, 0, 0));
        ExitBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-shutdown-32.png"))); // NOI18N
        ExitBtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExitBtn1MouseClicked(evt);
            }
        });
        jPanel1.add(ExitBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1720, 0, 50, 50));

        FlightIDTxt.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        FlightIDTxt.setForeground(new java.awt.Color(255, 255, 255));
        FlightIDTxt.setText("Enter Flight ID Here...");
        FlightIDTxt.setBorder(null);
        FlightIDTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FlightIDTxtMouseClicked(evt);
            }
        });
        jPanel1.add(FlightIDTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 320, 60));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 320, 20));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Select Date");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 110, 140, 60));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Flight ID");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 140, 60));

        FlightDateTxt.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jPanel1.add(FlightDateTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 170, 310, 60));

        ReadView.setBackground(new java.awt.Color(51, 255, 102));
        ReadView.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ReadView.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ReadViewMouseClicked(evt);
            }
        });
        jPanel1.add(ReadView, new org.netbeans.lib.awtextra.AbsoluteConstraints(1620, 0, 50, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/airplane-wallpapers-31768-5071001.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 1100));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1848, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setSize(new java.awt.Dimension(1767, 1007));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void SearchTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchTxtMouseClicked
        // TODO add your handling code here:
        SearchTxt.setText(null);
    }//GEN-LAST:event_SearchTxtMouseClicked

    private void SearchTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchTxtKeyReleased
        // TODO add your handling code here:
        filter();
    }//GEN-LAST:event_SearchTxtKeyReleased

    private void BackBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackBtnMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        AddItem add=new AddItem();
        add.setVisible(true);
    }//GEN-LAST:event_BackBtnMouseClicked

    private void BackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BackBtnActionPerformed

    private void ExitBtn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitBtn1MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_ExitBtn1MouseClicked

    private void FlightIDTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FlightIDTxtMouseClicked
        // TODO add your handling code here:
        FlightIDTxt.setText(" ");
    }//GEN-LAST:event_FlightIDTxtMouseClicked

    private void FlightTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FlightTableMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)FlightTable.getModel();
        int selectedRowIndex=FlightTable.getSelectedRow();
        FlightIDTxt.setText(model.getValueAt(selectedRowIndex, 0).toString());
    }//GEN-LAST:event_FlightTableMouseClicked

    private void ConfirmBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConfirmBtnMouseClicked
        // TODO add your handling code here:
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager
                    .getConnection(
                            "jdbc:sqlserver://localhost:1433;databaseName=FLY_SKY;selectMethod=cursor", "sa", "123456");
            query1 = "insert into FLIGHT_INFO_FINAL(FlightID, FlightDate)values(?,?)";
            PreparedStatement pst = conn.prepareStatement(query1);
            pst.setString(1, FlightIDTxt.getText());
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            String date=sdf.format(FlightDateTxt.getDate());
            pst.setString(2, date);
            pst.executeUpdate();
            FlightIDTxt.setText("Enter Flight ID Here...");
            FlightDateTxt.setDate(null);
            ImageIcon icon = new ImageIcon("src/images/ok_48px.png");
            JOptionPane.showMessageDialog(null, "Inserted Successfully", "Successfull", JOptionPane.INFORMATION_MESSAGE, icon);
        }
        catch(Exception e)
        {
            
        }
    }//GEN-LAST:event_ConfirmBtnMouseClicked

    private void ReadViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReadViewMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new UpdateEmployee().setVisible(true);
    }//GEN-LAST:event_ReadViewMouseClicked

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
            java.util.logging.Logger.getLogger(AddDatePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddDatePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddDatePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddDatePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddDatePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackBtn;
    private javax.swing.JButton ConfirmBtn;
    private javax.swing.JButton ExitBtn1;
    private com.toedter.calendar.JDateChooser FlightDateTxt;
    private javax.swing.JTextField FlightIDTxt;
    private javax.swing.JTable FlightTable;
    private javax.swing.JButton ReadView;
    private javax.swing.JTextField SearchTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
