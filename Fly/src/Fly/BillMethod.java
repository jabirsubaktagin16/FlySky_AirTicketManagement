package Fly;

import Connection.TicketJoinFlight;
import static com.sun.corba.se.impl.util.Utility.printStackTrace;
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

public class BillMethod extends javax.swing.JFrame {
    public String query1;
    public String billSystem;
    String query = "SELECT TICKET_BUYING.TicketID,TICKET_BUYING.CustomerId,PASSENGER.Name,TICKET_BUYING.Class,TICKET_BUYING.FlightFinalID AS 'Flight ID',FLIGHT_INFO_FINAL.FlightDate AS 'Flight Date',FLIGHT_INFO.StartingPlace AS 'Starting Place',FLIGHT_INFO.Destination,FLIGHT_INFO.AirLineName AS 'Airline Name',FLIGHT_INFO.DepartureTime AS 'Departure Time',FLIGHT_INFO.ArrivalTime AS 'Arrival Time'\n"
            + "FROM TICKET_BUYING INNER JOIN PASSENGER ON TICKET_BUYING.CustomerId=PASSENGER.CustomerId INNER JOIN\n"
            + "FLIGHT_INFO_FINAL ON TICKET_BUYING.FlightFinalID=FLIGHT_INFO_FINAL.FlightFinalID INNER JOIN FLIGHT_INFO\n"
            + "ON FLIGHT_INFO_FINAL.FlightID=FLIGHT_INFO.FlightID";

    public BillMethod() {
        initComponents();
        TotalBill.setBackground(new Color(0, 0, 0, 0));
        ClassTxt.setBackground(new Color(0, 0, 0, 0));
        ClassRate.setBackground(new Color(0, 0, 0, 0));
        Seat.setBackground(new Color(0, 0, 0, 0));
        SearchTxt.setBackground(new Color(0, 0, 0, 0));
        TicketIDTxt.setBackground(new Color(0, 0, 0, 0));
        FlightIDTxt.setBackground(new Color(0, 0, 0, 0));
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

    public ArrayList<TicketJoinFlight> ListUsers(String query) {
        ArrayList<TicketJoinFlight> usersList = new ArrayList<TicketJoinFlight>();
        Connection con = getConnection();
        Statement st;
        ResultSet rs;
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            TicketJoinFlight user;
            while (rs.next()) {
                user = new TicketJoinFlight(rs.getInt("TicketID"), rs.getInt("CustomerID"), rs.getString("Name"), rs.getString("Class"), rs.getInt("Flight ID"), rs.getString("Flight Date"), rs.getString("Starting Place"), rs.getString("Destination"), rs.getString("Airline Name"), rs.getString("Departure Time"), rs.getString("Arrival Time"));
                usersList.add(user);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return usersList;
    }

    public void showUserTable(String OrderQuery) {
        ArrayList<TicketJoinFlight> users = ListUsers(OrderQuery);
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"Ticket ID", "Customer ID", "Name", "Class", "Flight ID", "Flight Date", "Starting Place", "Destination", "Airline Name", "Departure Time", "Arrival Time"});
        Object[] row = new Object[11];

        for (int i = 0; i < users.size(); i++) {
            row[0] = users.get(i).getTicketID();
            row[1] = users.get(i).getCustomerID();
            row[2] = users.get(i).getName();
            row[3] = users.get(i).getFlightClass();
            row[4] = users.get(i).getFlightID();
            row[5] = users.get(i).getFlightDate();
            row[6] = users.get(i).getStartingPoint();
            row[7] = users.get(i).getDestination();
            row[8] = users.get(i).getAirline();
            row[9] = users.get(i).getDepartureTime();
            row[10] = users.get(i).getArrivalTime();
            model.addRow(row);
        }
        TicketTable.setModel(model);
    }

    public ArrayList<TicketJoinFlight> ListUsers2(String valToSearch) {
        ArrayList<TicketJoinFlight> usersList = new ArrayList<TicketJoinFlight>();
        Connection con = getConnection();
        Statement st;
        ResultSet rs;
        try {
            st = con.createStatement();
            String searchquery = "SELECT TICKET_BUYING.TicketID,TICKET_BUYING.CustomerId,PASSENGER.Name,TICKET_BUYING.Class,TICKET_BUYING.FlightFinalID AS 'Flight ID',FLIGHT_INFO_FINAL.FlightDate AS 'Flight Date',FLIGHT_INFO.StartingPlace AS 'Starting Place',FLIGHT_INFO.Destination,FLIGHT_INFO.AirLineName AS 'Airline Name',FLIGHT_INFO.DepartureTime AS 'Departure Time',FLIGHT_INFO.ArrivalTime AS 'Arrival Time'\n"
                    + "FROM TICKET_BUYING INNER JOIN PASSENGER ON TICKET_BUYING.CustomerId=PASSENGER.CustomerId INNER JOIN\n"
                    + "FLIGHT_INFO_FINAL ON TICKET_BUYING.FlightFinalID=FLIGHT_INFO_FINAL.FlightFinalID INNER JOIN FLIGHT_INFO\n"
                    + "ON FLIGHT_INFO_FINAL.FlightID=FLIGHT_INFO.FlightID WHERE CONCAT(TICKET_BUYING.TicketID,TICKET_BUYING.CustomerId,PASSENGER.Name,TICKET_BUYING.Class,TICKET_BUYING.FlightFinalID,FLIGHT_INFO_FINAL.FlightDate,FLIGHT_INFO.StartingPlace,FLIGHT_INFO.Destination,FLIGHT_INFO.AirLineName,FLIGHT_INFO.DepartureTime,FLIGHT_INFO.ArrivalTime) LIKE '%" + valToSearch + "%'";
            rs = st.executeQuery(searchquery);
            TicketJoinFlight user;
            while (rs.next()) {
                user = new TicketJoinFlight(rs.getInt("TicketID"), rs.getInt("CustomerID"), rs.getString("Name"), rs.getString("Class"), rs.getInt("Flight ID"), rs.getString("Flight Date"), rs.getString("Starting Place"), rs.getString("Destination"), rs.getString("Airline Name"), rs.getString("Departure Time"), rs.getString("Arrival Time"));
                usersList.add(user);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return usersList;
    }

    public void filter() {
        ArrayList<TicketJoinFlight> users = ListUsers2(SearchTxt.getText());
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"Ticket ID", "Customer ID", "Name", "Class", "Flight ID", "Flight Date", "Starting Place", "Destination", "Airline Name", "Departure Time", "Arrival Time"});
        Object[] row = new Object[11];

        for (int i = 0; i < users.size(); i++) {
            row[0] = users.get(i).getTicketID();
            row[1] = users.get(i).getCustomerID();
            row[2] = users.get(i).getName();
            row[3] = users.get(i).getFlightClass();
            row[4] = users.get(i).getFlightID();
            row[5] = users.get(i).getFlightDate();
            row[6] = users.get(i).getStartingPoint();
            row[7] = users.get(i).getDestination();
            row[8] = users.get(i).getAirline();
            row[9] = users.get(i).getDepartureTime();
            row[10] = users.get(i).getArrivalTime();
            model.addRow(row);
        }
        TicketTable.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        BillCmb = new javax.swing.JComboBox<>();
        TotalBill = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TicketTable = new javax.swing.JTable();
        jSeparator6 = new javax.swing.JSeparator();
        ClassRate = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        ClassTxt = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        Seat = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        SearchTxt = new javax.swing.JTextField();
        TotalBtn = new javax.swing.JButton();
        jSeparator9 = new javax.swing.JSeparator();
        TicketIDTxt = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        PayBtn = new javax.swing.JButton();
        jSeparator10 = new javax.swing.JSeparator();
        FlightIDTxt = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Back = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Bill Method");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 190, 60));

        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 240, 370, 20));

        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel8.setText("Total Bill");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 130, 150, 60));

        BillCmb.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        BillCmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Your Bill System", "Cash", "Credit Card", "Bkash", "Rocket" }));
        BillCmb.setBorder(null);
        jPanel1.add(BillCmb, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 370, 50));

        TotalBill.setEditable(false);
        TotalBill.setBackground(new java.awt.Color(255, 255, 255));
        TotalBill.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        TotalBill.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TotalBill.setBorder(null);
        TotalBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TotalBillMouseClicked(evt);
            }
        });
        jPanel1.add(TotalBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 190, 370, 50));

        TicketTable.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        TicketTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "", "", "", "", "", "", "", "", "", ""
            }
        ));
        TicketTable.setRowHeight(30);
        TicketTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TicketTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TicketTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 475, 1500, 460));

        jSeparator6.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 350, 370, 20));

        ClassRate.setEditable(false);
        ClassRate.setBackground(new java.awt.Color(255, 255, 255));
        ClassRate.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        ClassRate.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ClassRate.setBorder(null);
        ClassRate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClassRateMouseClicked(evt);
            }
        });
        jPanel1.add(ClassRate, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 300, 370, 50));

        jLabel9.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel9.setText("Class Rate");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 240, 150, 60));

        ClassTxt.setEditable(false);
        ClassTxt.setBackground(new java.awt.Color(255, 255, 255));
        ClassTxt.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        ClassTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ClassTxt.setBorder(null);
        ClassTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClassTxtMouseClicked(evt);
            }
        });
        jPanel1.add(ClassTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 190, 370, 50));

        jLabel10.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel10.setText("Class");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 130, 150, 60));

        jSeparator7.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 240, 370, 20));

        jSeparator8.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 460, 370, 20));

        Seat.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
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
        jPanel1.add(Seat, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 410, 370, 50));

        jLabel11.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel11.setText("Total Needed Seat");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 350, 230, 60));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 120, 460, 20));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search_25px.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 50, 30, 70));

        SearchTxt.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        SearchTxt.setBorder(null);
        SearchTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchTxtKeyReleased(evt);
            }
        });
        jPanel1.add(SearchTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 50, 430, 70));

        TotalBtn.setBackground(new java.awt.Color(153, 255, 255));
        TotalBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bill_25px.png"))); // NOI18N
        TotalBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TotalBtnMouseClicked(evt);
            }
        });
        jPanel1.add(TotalBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 410, 50, 50));

        jSeparator9.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 370, 20));

        TicketIDTxt.setEditable(false);
        TicketIDTxt.setBackground(new java.awt.Color(255, 255, 255));
        TicketIDTxt.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        TicketIDTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TicketIDTxt.setBorder(null);
        TicketIDTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TicketIDTxtMouseClicked(evt);
            }
        });
        jPanel1.add(TicketIDTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 370, 50));

        jLabel12.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Ticket ID");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 150, 60));

        PayBtn.setBackground(new java.awt.Color(102, 255, 102));
        PayBtn.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        PayBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cash_in_hand_48px.png"))); // NOI18N
        PayBtn.setText("PAY");
        PayBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PayBtnMouseClicked(evt);
            }
        });
        jPanel1.add(PayBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 270, 160, 70));

        jSeparator10.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 370, 20));

        FlightIDTxt.setEditable(false);
        FlightIDTxt.setBackground(new java.awt.Color(255, 255, 255));
        FlightIDTxt.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        FlightIDTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        FlightIDTxt.setBorder(null);
        FlightIDTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FlightIDTxtMouseClicked(evt);
            }
        });
        jPanel1.add(FlightIDTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 370, 50));

        jLabel13.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Flight ID");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 150, 60));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close_window_48px.png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1460, 0, 40, 40));

        Back.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Back.setIcon(new javax.swing.ImageIcon("D:\\Fly Sky-Air Ticket Management\\Fly Sky-Air Ticket Management\\src\\images\\circled_left_48px.png")); // NOI18N
        Back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackMouseClicked(evt);
            }
        });
        jPanel1.add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/thumb2-business-money-transfer-euro-bundle-of-money-payment.jpg.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 938, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1500, 938));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void TotalBillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TotalBillMouseClicked

    }//GEN-LAST:event_TotalBillMouseClicked

    private void ClassRateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClassRateMouseClicked

    }//GEN-LAST:event_ClassRateMouseClicked

    private void ClassTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClassTxtMouseClicked

    }//GEN-LAST:event_ClassTxtMouseClicked

    private void SeatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SeatMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_SeatMouseClicked

    private void SearchTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchTxtKeyReleased
        // TODO add your handling code here:
        filter();
    }//GEN-LAST:event_SearchTxtKeyReleased

    private void TicketTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TicketTableMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) TicketTable.getModel();
        int selectedRowIndex = TicketTable.getSelectedRow();
        TicketIDTxt.setText(model.getValueAt(selectedRowIndex, 0).toString());
        FlightIDTxt.setText(model.getValueAt(selectedRowIndex, 4).toString());
        ClassTxt.setText(model.getValueAt(selectedRowIndex, 3).toString());
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager
                    .getConnection(
                            "jdbc:sqlserver://localhost:1433;databaseName=FLY_SKY;selectMethod=cursor", "sa", "123456");
            if (ClassTxt.getText().equals("Economic")) {
                query = "SELECT FLIGHT_INFO.EconomicClass FROM FLIGHT_INFO_FINAL INNER JOIN FLIGHT_INFO ON FLIGHT_INFO_FINAL.FlightID=FLIGHT_INFO.FlightID WHERE FLIGHT_INFO_FINAL.FlightFinalID="+FlightIDTxt.getText();
                PreparedStatement pst = conn.prepareStatement(query);
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    ClassRate.setText(rs.getString("EconomicClass"));
                }
            } else if (ClassTxt.getText().equals("Business")) {
                query = "SELECT FLIGHT_INFO.BusinessClass FROM FLIGHT_INFO_FINAL INNER JOIN FLIGHT_INFO ON FLIGHT_INFO_FINAL.FlightID=FLIGHT_INFO.FlightID WHERE FLIGHT_INFO_FINAL.FlightFinalID="+FlightIDTxt.getText();
                PreparedStatement pst = conn.prepareStatement(query);
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    ClassRate.setText(rs.getString("BusinessClass"));
                }
            }
        } catch (Exception e) {
            printStackTrace();
        }
    }//GEN-LAST:event_TicketTableMouseClicked

    private void SeatKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SeatKeyReleased

    }//GEN-LAST:event_SeatKeyReleased

    private void SeatKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SeatKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_SeatKeyTyped

    private void TotalBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TotalBtnMouseClicked
        // TODO add your handling code here:
        double classrate = Double.parseDouble(ClassRate.getText());
        double seat = Double.parseDouble(Seat.getText());
        double result = (classrate * seat);
        String Total = String.format("%.2f", result);
        TotalBill.setText(Total);
    }//GEN-LAST:event_TotalBtnMouseClicked

    private void TicketIDTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TicketIDTxtMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TicketIDTxtMouseClicked

    private void PayBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PayBtnMouseClicked
        // TODO add your handling code here:
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager
                    .getConnection(
                            "jdbc:sqlserver://localhost:1433;databaseName=FLY_SKY;selectMethod=cursor", "sa", "123456");
            query1 = "insert into BILL(TicketID, Class, BillMethod, ClassRate, SeatAmount, TotalBill)values(?,?,?,?,?,?)";
            PreparedStatement pst = conn.prepareStatement(query1);
            pst.setString(1, TicketIDTxt.getText());
            pst.setString(2, ClassTxt.getText());
            if (BillCmb.getSelectedItem().equals("Select Your Bill System")) {
                billSystem="";
            } else {
                billSystem=BillCmb.getSelectedItem().toString();
            }
            pst.setString(3, billSystem);
            pst.setString(4, ClassRate.getText());
            pst.setString(5, Seat.getText());
            pst.setString(6, TotalBill.getText());
            pst.executeUpdate();
            TicketIDTxt.setText(" ");
            ClassTxt.setText(" ");
            BillCmb.setSelectedIndex(0);
            ClassRate.setText(" ");
            Seat.setText(" ");
            TotalBill.setText(" ");
            ImageIcon icon = new ImageIcon("src/images/ok_48px.png");
            JOptionPane.showMessageDialog(null, "Ticket Confirmed", "Successfull", JOptionPane.INFORMATION_MESSAGE, icon);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please Insert Correctly");
        }
    }//GEN-LAST:event_PayBtnMouseClicked

    private void FlightIDTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FlightIDTxtMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_FlightIDTxtMouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel6MouseClicked

    private void BackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new Employee().setVisible(true);
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
            java.util.logging.Logger.getLogger(BillMethod.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BillMethod.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BillMethod.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BillMethod.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BillMethod().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Back;
    public javax.swing.JComboBox<String> BillCmb;
    private javax.swing.JTextField ClassRate;
    private javax.swing.JTextField ClassTxt;
    private javax.swing.JTextField FlightIDTxt;
    private javax.swing.JButton PayBtn;
    private javax.swing.JTextField SearchTxt;
    private javax.swing.JTextField Seat;
    private javax.swing.JTextField TicketIDTxt;
    private javax.swing.JTable TicketTable;
    private javax.swing.JTextField TotalBill;
    private javax.swing.JButton TotalBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    // End of variables declaration//GEN-END:variables
}
