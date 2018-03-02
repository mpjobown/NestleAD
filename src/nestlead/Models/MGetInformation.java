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
    
    public static JSONArray business () {
        
        String sql = "select TipoCalif As Codigo, NombreCalif As Nombre from tabla_descripcion_calificacion";
        return ConnectionDB.consult(new HostData(), sql);
    }
    
    public static JSONArray customers () {
        
        String sql = "select M.NitMov As Codigo, C.NombreNit As Nombre from tabla_identificacion_clientes As C left join tabla_movimiento_por_comprobante As M ON C.NitNit=M.NitMov where MesDctoMov=9 AND GrpMov in (9,41) group by NitMov, NombreNit ";
        return ConnectionDB.consult(new HostData(), sql);
    }
    
     public static JSONArray sku () {
        
        String sql = "select ProductoInv As Codigo, DescripcionInv As Nombre, CodBarInv As CodBarras, GruInv As Compañia from tabla_maestro_inventarios where GruInv in (9,41)";
        return ConnectionDB.consult(new HostData(), sql);
    }
     
     public static JSONArray billList () {
        
        String sql = "select NitMov As CodigoCliente, VendedorMov As CodigoVendedor, FechaDctoMov As Fecha, NroMov As NroDocumento from tabla_movimiento_por_comprobante where MesDctoMov=9 AND GrpMov in (9,41)";
        return ConnectionDB.consult(new HostData(), sql);
    } 
     
     
    
    public static JSONArray sales () {
        
        String sql = "select TipMov As Tipo, NroMov As Numero, ValorMov As Valor from tabla_movimiento_por_comprobante where MesDctoMov=9 AND GrpMov in (9,41)";
        return ConnectionDB.consult(new HostData(), sql);
    
    }
}
