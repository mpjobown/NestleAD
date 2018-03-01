/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nestlead.Controllers;

import libs.CreateFile;
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

        if (!createFileCities()) {
            System.out.println("Error, no se pudo crear el archivo ciudades..");
       }
        if (!createFileSellers()){
            System.out.println("Error, no se pudo crear el archivo vendedores..");
        }
        return null;
    }

    private static boolean createFileCities() {
        JSONArray jsonArray = new JSONArray();
        jsonArray = MGetInformation.city();
        
        return CreateFile.create("cities", "Z_CIUDADES", jsonArray);
    }
    
    private static boolean createFileSellers(){    
        JSONArray jsonArray = new JSONArray();
        jsonArray = MGetInformation.seller();

        return CreateFile.create("sellers", "Z_VENDEDORES", jsonArray);
    }    
}
