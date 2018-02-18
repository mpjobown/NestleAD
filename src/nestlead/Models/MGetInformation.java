/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nestlead.Models;

import java.sql.*;
import libs.ConnectionDB;
import libs.HostData;

/**
 *
 * @author trabajo
 */
public class MGetInformation {

    public static ResultSet ejemplo() {

        String sql = "SELECT * FROM TABLA_DESCRIPCION_CIUDAD";

        return ConnectionDB.consult(new HostData(), sql);
    }
}