/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nestlead.Models;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import libs.ConnectionDB;
import libs.HostData;

/**
 *
 * @author trabajo
 */
public class MGetInformation {

    public static ArrayList ejemplo() {
        
        String sql = "select NroCiudadCiu, NombreCiu from tabla_descripcion_ciudad order by NombreCiu";
        return ConnectionDB.consult(new HostData(), sql);        
    }
}