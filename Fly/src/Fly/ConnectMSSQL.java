package Fly;
import java.sql.Connection;  
 import java.sql.DriverManager;  
import java.sql.PreparedStatement;
 import java.sql.ResultSet;  
 import java.sql.Statement;  
import javax.swing.JOptionPane;

public class ConnectMSSQL {  
 public Connection conn;
 public Statement state;
     public void connectDB(String Query,PreparedStatement pst){  
         try {
             pst=conn.prepareStatement(Query);
             Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
             Connection connection = DriverManager  
                     .getConnection(  
                             "jdbc:sqlserver://localhost:1433;databaseName=FLY_SKY;selectMethod=cursor",   "sa", "123456");     
         } catch (Exception e) {  
             e.printStackTrace();  
         }  
     } 

 }    