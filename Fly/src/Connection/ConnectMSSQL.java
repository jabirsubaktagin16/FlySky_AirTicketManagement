package Connection;
import java.sql.Connection;  
 import java.sql.DriverManager;  
 import java.sql.ResultSet;  
 import java.sql.Statement;  

public class ConnectMSSQL {  
 
     public void connectDB(){  
         try {  
             Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
             Connection connection = DriverManager  
                     .getConnection(  
                             "jdbc:sqlserver://localhost:1433;databaseName=FLY_SKY;selectMethod=cursor",   "sa", "123456");  
     
             Statement statement = connection.createStatement();  
             ResultSet resultSet = statement  
                     .executeQuery("SELECT FirstName FROM Customer");    
         } catch (Exception e) {  
             e.printStackTrace();  
         }  
     } 

 }  