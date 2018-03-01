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

    public static JSONArray city() {// cambiar tipo a json

        String sql = "select NroCiudadCiu As Codigo, NombreCiu As Nombre from tabla_descripcion_ciudad order by NroCiudadCiu";
        return ConnectionDB.consult(new HostData(), sql);
    }
    
    public static JSONArray seller(){
    
        String sql = "select VenVen As Codigo, NombreVen As Nombre, ZonaVen As Ubicacion, CedulaVen As Cedula from tabla_descripcion_vendedores";
        return ConnectionDB.consult(new HostData(), sql);
    }
}
