/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libs;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author trabajo
 */
public class ConvertFormats {

    public static JSONArray parseResultSetToJson(ResultSet resultSet) throws SQLException {
        JSONArray jsonArray = new JSONArray();
        JSONArray array = new JSONArray();
        while (resultSet.next()) {
            int columns = resultSet.getMetaData().getColumnCount(); // extrae el numero de columnas

            for (int i = 0; i < columns; i++) {
                JSONObject obj = new JSONObject();
                obj.put(resultSet.getMetaData().getColumnLabel(i + 1).toLowerCase(), resultSet.getObject(i + 1));
                jsonArray.put(obj);
            }
        }
        return array;
    }
}
