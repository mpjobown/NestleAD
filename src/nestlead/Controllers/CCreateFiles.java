/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nestlead.Controllers;

import nestlead.Models.MGetInformation;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author trabajo
 */
// clase que recibe el jsonArray y lo recorre para armar los archivos.
public class CCreateFiles {

    public static String createFiles() {

        JSONArray jsonArray = new JSONArray();
        jsonArray = MGetInformation.ejemplo();

        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject o = (JSONObject) jsonArray.get(i);
            System.out.println(o.get("NombreCiu"));
        }
        return null;
    }
}
