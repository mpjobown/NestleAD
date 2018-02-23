/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nestlead.Models;

import libs.ConnectionDB;
import libs.HostData;
import org.json.simple.JSONArray;

/**
 *
 * @author trabajo
 */
public class MGetInformation {

    public static JSONArray ejemplo() {// cambiar tipo a json

        String sql = "select NroCiudadCiu, NombreCiu from tabla_descripcion_ciudad order by NombreCiu";
        return ConnectionDB.consult(new HostData(), sql);
    }
}
