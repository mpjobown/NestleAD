/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author trabajo
 */
public class ConnectionDB {

    private static Connection connect(HostData hostData) {

        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection con = DriverManager.getConnection("jdbc:odbc:pruebasiigo", "siigo", "123");
            return con;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }

    }

    public static ArrayList consult(HostData hostData, String sql) {

        try {
            Connection con = connect(hostData);
            Statement stm;
            ResultSet data;
            ResultSetMetaData metaData; // analiza la estructura de las tablas a consultar de la DB
            if (con != null) {
                stm = con.createStatement();
                data = stm.executeQuery(sql);
                metaData = data.getMetaData(); // obtiene la estructura de la tabla del query a ejecutar
                int columns = metaData.getColumnCount(); // obtiene el numero de columnas de dicha tabla

                ArrayList results = new ArrayList();

                while (data.next()) {
                    HashMap row = new HashMap();
                    results.add(row);

                    for (int i = 1; i <= columns; i++) {
                        row.put(metaData.getColumnName(i), data.getObject(i));
                    }
                }
                closeConnection(con);
                return results;
            }
            closeConnection(con);
            return null;

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    public static int afect(HostData hostData, String sql) {

        try {

            Connection con = connect(hostData);
            Statement stm;
            int res = 0;

            if (con != null) {
                stm = con.createStatement();
                res = stm.executeUpdate(sql);
            }
            closeConnection(con);
            return res;

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return 0;
        }
    }

    private static void closeConnection(Connection con) {

        try {
            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
