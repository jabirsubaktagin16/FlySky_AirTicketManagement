package Fly;

import static com.sun.corba.se.impl.util.Utility.printStackTrace;
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
public class OtherInfo extends javax.swing.JFrame {
    
    public OtherInfo() {
        initComponents();
        info();
    }
    
    public void info() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager
                    .getConnection(
                            "jdbc:sqlserver://localhost:1433;databaseName=FLY_SKY;selectMethod=cursor", "sa", "123456");
            String query = "SELECT SUM(TotalBill) AS 'SUM' FROM BILL";
            PreparedStatement pst = conn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            String query2 = "SELECT BillMethod,SUM(TotalBill) AS 'Cash' FROM BILL GROUP BY BillMethod HAVING BillMethod='Cash'";
            PreparedStatement pst2 = conn.prepareStatement(query2);
            ResultSet rs2 = pst2.executeQuery();
            String query3 = "SELECT BillMethod,SUM(TotalBill) AS 'Bkash' FROM BILL GROUP BY BillMethod HAVING BillMethod='Bkash'";
            PreparedStatement pst3 = conn.prepareStatement(query3);
            ResultSet rs3 = pst3.executeQuery();
            String query4 = "SELECT BillMethod,SUM(TotalBill) AS 'Rocket' FROM BILL GROUP BY BillMethod HAVING BillMethod='Rocket'";
            PreparedStatement pst4 = conn.prepareStatement(query4);
            ResultSet rs4 = pst4.executeQuery();
            String query5 = "SELECT b.[Airline Name], COUNT(b.[Airline Name]) \n"
                    + "FROM (SELECT TICKET_BUYING.TicketID,TICKET_BUYING.CustomerId,PASSENGER.Name,TICKET_BUYING.Class,TICKET_BUYING.FlightFinalID AS 'Flight ID',FLIGHT_INFO_FINAL.FlightDate AS 'Flight Date',FLIGHT_INFO.StartingPlace AS 'Starting Place',FLIGHT_INFO.Destination,FLIGHT_INFO.AirLineName AS 'Airline Name',FLIGHT_INFO.DepartureTime AS 'Departure Time',FLIGHT_INFO.ArrivalTime AS 'Arrival Time'\n"
                    + "FROM TICKET_BUYING INNER JOIN PASSENGER ON TICKET_BUYING.CustomerId=PASSENGER.CustomerId INNER JOIN\n"
                    + "FLIGHT_INFO_FINAL ON TICKET_BUYING.FlightFinalID=FLIGHT_INFO_FINAL.FlightFinalID INNER JOIN FLIGHT_INFO\n"
                    + "ON FLIGHT_INFO_FINAL.FlightID=FLIGHT_INFO.FlightID)b  GROUP BY b.[Airline Name] \n"
                    + "HAVING COUNT (b.[Airline Name])=( \n"
                    + "SELECT MAX(x.mycount) \n"
                    + "FROM ( \n"
                    + "SELECT a.[Airline Name], COUNT(a.[Airline Name]) mycount \n"
                    + "FROM (SELECT TICKET_BUYING.TicketID,TICKET_BUYING.CustomerId,PASSENGER.Name,TICKET_BUYING.Class,TICKET_BUYING.FlightFinalID AS 'Flight ID',FLIGHT_INFO_FINAL.FlightDate AS 'Flight Date',FLIGHT_INFO.StartingPlace AS 'Starting Place',FLIGHT_INFO.Destination,FLIGHT_INFO.AirLineName AS 'Airline Name',FLIGHT_INFO.DepartureTime AS 'Departure Time',FLIGHT_INFO.ArrivalTime AS 'Arrival Time'\n"
                    + "FROM TICKET_BUYING INNER JOIN PASSENGER ON TICKET_BUYING.CustomerId=PASSENGER.CustomerId INNER JOIN\n"
                    + "FLIGHT_INFO_FINAL ON TICKET_BUYING.FlightFinalID=FLIGHT_INFO_FINAL.FlightFinalID INNER JOIN FLIGHT_INFO\n"
                    + "ON FLIGHT_INFO_FINAL.FlightID=FLIGHT_INFO.FlightID)a\n"
                    + "GROUP BY a.[Airline Name])x)";
            PreparedStatement pst5 = conn.prepareStatement(query5);
            ResultSet rs5 = pst5.executeQuery();
            String query6 = "SELECT b.[Starting Place],b.[Destination],COUNT(b.[FlightID])\n"
                    + "FROM\n"
                    + "(SELECT TICKET_BUYING.TicketID,TICKET_BUYING.CustomerId,PASSENGER.Name,TICKET_BUYING.Class,TICKET_BUYING.FlightFinalID AS 'Schedule ID',FLIGHT_INFO_FINAL.FlightID,FLIGHT_INFO_FINAL.FlightDate AS 'Flight Date',FLIGHT_INFO.StartingPlace AS 'Starting Place',FLIGHT_INFO.Destination,FLIGHT_INFO.AirLineName AS 'Airline Name',FLIGHT_INFO.DepartureTime AS 'Departure Time',FLIGHT_INFO.ArrivalTime AS 'Arrival Time'\n"
                    + "FROM TICKET_BUYING INNER JOIN PASSENGER ON TICKET_BUYING.CustomerId=PASSENGER.CustomerId INNER JOIN\n"
                    + "FLIGHT_INFO_FINAL ON TICKET_BUYING.FlightFinalID=FLIGHT_INFO_FINAL.FlightFinalID INNER JOIN FLIGHT_INFO\n"
                    + "ON FLIGHT_INFO_FINAL.FlightID=FLIGHT_INFO.FlightID)b GROUP BY b.[Starting Place],b.Destination\n"
                    + "HAVING COUNT(b.[FlightID])=(\n"
                    + "SELECT MAX(x.mycount)\n"
                    + "FROM(SELECT a.[Starting Place],a.Destination,COUNT(a.FlightID) mycount FROM (SELECT TICKET_BUYING.TicketID,TICKET_BUYING.CustomerId,PASSENGER.Name,TICKET_BUYING.Class,TICKET_BUYING.FlightFinalID AS 'Schedule ID',FLIGHT_INFO_FINAL.FlightID,FLIGHT_INFO_FINAL.FlightDate AS 'Flight Date',FLIGHT_INFO.StartingPlace AS 'Starting Place',FLIGHT_INFO.Destination,FLIGHT_INFO.AirLineName AS 'Airline Name',FLIGHT_INFO.DepartureTime AS 'Departure Time',FLIGHT_INFO.ArrivalTime AS 'Arrival Time'\n"
                    + "FROM TICKET_BUYING INNER JOIN PASSENGER ON TICKET_BUYING.CustomerId=PASSENGER.CustomerId INNER JOIN\n"
                    + "FLIGHT_INFO_FINAL ON TICKET_BUYING.FlightFinalID=FLIGHT_INFO_FINAL.FlightFinalID INNER JOIN FLIGHT_INFO\n"
                    + "ON FLIGHT_INFO_FINAL.FlightID=FLIGHT_INFO.FlightID)a\n"
                    + "GROUP BY a.[Starting Place],a.Destination)x)";
            String query7 = "SELECT BillMethod,SUM(TotalBill) AS 'Credit Card' FROM BILL GROUP BY BillMethod HAVING BillMethod='Credit Card'";
            PreparedStatement pst7 = conn.prepareStatement(query7);
            ResultSet rs7 = pst7.executeQuery();
            PreparedStatement pst6 = conn.prepareStatement(query6);
            ResultSet rs6 = pst6.executeQuery();
            while (rs.next()) {
                Income.setText(rs.getString("SUM") + " BDT");
            }
            while (rs2.next()) {
                Cash.setText(rs2.getString("Cash") + " BDT");
            }
            while (rs3.next()) {
                Bkash.setText(rs3.getString("Bkash") + " BDT");
            }
            while (rs4.next()) {
                Rocket.setText(rs4.getString("Rocket") + " BDT");
            }
            while (rs5.next()) {
                Airline.setText(rs5.getString("Airline Name"));
            }
            while (rs6.next()) {
                Root.setText(rs6.getString("Starting Place") + "-" + rs6.getString("Destination"));
            }
            while (rs7.next()) {
                CreditCard.setText(rs7.getString("Credit Card") + " BDT");
            }
        } catch (Exception e) {
            printStackTrace();
        }
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
        jLabel6 = new javax.swing.JLabel();
        Back = new javax.swing.JLabel();
        CreditCard = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Airline = new javax.swing.JLabel();
        Root = new javax.swing.JLabel();
        Income = new javax.swing.JLabel();
        Cash = new javax.swing.JLabel();
        Bkash = new javax.swing.JLabel();
        Rocket = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel3.setBackground(new java.awt.Color(0, 121, 107));
        jPanel3.setLayout(null);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close_window_48px.png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel6);
        jLabel6.setBounds(1420, 0, 50, 40);

        Back.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Back.setIcon(new javax.swing.ImageIcon("D:\\Fly Sky-Air Ticket Management\\Fly Sky-Air Ticket Management\\src\\images\\circled_left_48px.png")); // NOI18N
        Back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackMouseClicked(evt);
            }
        });
        jPanel3.add(Back);
        Back.setBounds(10, 780, 40, 50);

        CreditCard.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        CreditCard.setForeground(new java.awt.Color(255, 255, 255));
        CreditCard.setText("0.00");
        jPanel3.add(CreditCard);
        CreditCard.setBounds(710, 550, 750, 110);

        jLabel2.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Most Used Airline:");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(150, 130, 340, 110);

        jLabel3.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Most Used Root:");
        jPanel3.add(jLabel3);
        jLabel3.setBounds(150, 200, 340, 110);

        jLabel4.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Total Income:");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(150, 270, 340, 110);

        jLabel5.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Total Income from Cash:");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(150, 340, 420, 110);

        jLabel7.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Total Income from Bkash:");
        jPanel3.add(jLabel7);
        jLabel7.setBounds(150, 410, 450, 110);

        jLabel8.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Total Income from Rocket:");
        jPanel3.add(jLabel8);
        jLabel8.setBounds(150, 480, 460, 110);

        jLabel9.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Total Income from Credit Card:");
        jPanel3.add(jLabel9);
        jLabel9.setBounds(150, 550, 540, 110);

        Airline.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        Airline.setForeground(new java.awt.Color(255, 255, 255));
        Airline.setText("Airline");
        jPanel3.add(Airline);
        Airline.setBounds(710, 130, 750, 110);

        Root.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        Root.setForeground(new java.awt.Color(255, 255, 255));
        Root.setText("Root");
        jPanel3.add(Root);
        Root.setBounds(710, 200, 750, 110);

        Income.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        Income.setForeground(new java.awt.Color(255, 255, 255));
        Income.setText("Income");
        jPanel3.add(Income);
        Income.setBounds(710, 270, 750, 110);

        Cash.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        Cash.setForeground(new java.awt.Color(255, 255, 255));
        Cash.setText("Income Cash");
        jPanel3.add(Cash);
        Cash.setBounds(710, 340, 750, 110);

        Bkash.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        Bkash.setForeground(new java.awt.Color(255, 255, 255));
        Bkash.setText("Income Bkash");
        jPanel3.add(Bkash);
        Bkash.setBounds(710, 410, 750, 110);

        Rocket.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        Rocket.setForeground(new java.awt.Color(255, 255, 255));
        Rocket.setText("0.00");
        jPanel3.add(Rocket);
        Rocket.setBounds(710, 480, 750, 110);

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

    private void BackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new Employee().setVisible(true);
    }//GEN-LAST:event_BackMouseClicked

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
            java.util.logging.Logger.getLogger(OtherInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OtherInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OtherInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OtherInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OtherInfo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Airline;
    private javax.swing.JLabel Back;
    private javax.swing.JLabel Bkash;
    private javax.swing.JLabel Cash;
    private javax.swing.JLabel CreditCard;
    private javax.swing.JLabel Income;
    private javax.swing.JLabel Rocket;
    private javax.swing.JLabel Root;
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
