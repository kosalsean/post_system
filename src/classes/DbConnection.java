/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;

/**
 *
 * @author kosal
 */

public class DbConnection {
    public static String username;
    public static String ID="";
    public static String POS="";
    public static Connection conn;
    public static String Driver="com.mysql.jdbc.Driver";
    public static String url="jdbc:mysql://localhost/pos_db";
    public static String user="root"; 
    public static String pass="";
    public  static void GetConnection(){
          try {
            Class.forName(Driver);
            conn=DriverManager.getConnection(url,user,pass);
            //JOptionPane.showConfirmDialog(null, "Connect successfull","Connect",JOptionPane.YES_OPTION);
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null,e.getMessage());
        }
    }
        public static void ExecuteNoneQuery(String sql){
        GetConnection();
        try {
            Statement stm=conn.createStatement();
            stm.executeUpdate(sql);
        } catch (Exception e) {
        }   
    }
        public static ResultSet ExecuteQuery(String sql){
            GetConnection();
            ResultSet rs;
              try {
                Statement stm=conn.createStatement();
                rs=stm.executeQuery(sql);
            } catch (Exception e) {
                return null;
            }  
            return rs;
        }
    
}
