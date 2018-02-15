/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author trabajo
 */
public class ConnectionDB {

    private static Connection connect(HostData hostData) {

        try {
            Class.forName(hostData.getDriver());
            Connection con = DriverManager.getConnection(hostData.getHost(), hostData.getName(), hostData.getPassword());
            return con;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }

    }

    public static ResultSet consult(HostData hostData, String sql) {

        try {
            Connection con = connect(hostData);
            Statement stm;
            ResultSet data;
            
            if(con != null){
                stm = con.createStatement();
                data = stm.executeQuery(sql);
                closeConnection(con);
                return data;
            }
            closeConnection(con);
            return null;
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }

    }
    
    public static int afect(HostData hostData, String sql){
        
        try{
            
            Connection con = connect(hostData);
            Statement stm;
            int res = 0;
            
            if(con != null){
                stm = con.createStatement();
                res = stm.executeUpdate(sql);
            }
            closeConnection(con);
            return res;
            
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
            return 0;
        }
        
    }
    
    private static void closeConnection(Connection con){
        
        try{
            con.close();
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        
    }

}
