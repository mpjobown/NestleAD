/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libs;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author trabajo
 */
public class ConvertFormats {

    public static JSONArray parseResultSetToJson(ResultSet resultSet) throws SQLException {
        JSONArray jsonAll = new JSONArray();
        JSONArray jsonHeaders = new JSONArray();
        JSONArray jsonData = new JSONArray();        

        boolean nameColumn = false;
        
        while (resultSet.next()) {
            int columns = resultSet.getMetaData().getColumnCount(); // extrae el numero de columnas            
            JSONObject obj = new JSONObject();
            for (int i = 0; i < columns; i++) {
                JSONObject objectHeaders = new JSONObject();
                obj.put(resultSet.getMetaData().getColumnLabel(i + 1), resultSet.getObject(i + 1).toString().trim());

                if (!nameColumn && i < columns) {
                    objectHeaders.put("Field", resultSet.getMetaData().getColumnLabel(i + 1));                    
                    jsonHeaders.add(objectHeaders);                    
                    nameColumn = i == columns - 1 ? true : false;
                }                
            }
            jsonData.add(obj);
        }
        jsonAll.add(jsonHeaders);         
        jsonAll.add(jsonData); 
        
        return jsonAll;
    }
}
