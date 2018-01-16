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

    public static JSONArray city() {

        String sql = "select NroCiudadCiu As Codigo, NombreCiu As Nombre from ODBC_TABLA_DESCRIPCION_CIUDAD group by NroCiudadCiu, NombreCiu order by NroCiudadCiu";
        return ConnectionDB.consult(new HostData(), sql);
    }

    public static JSONArray seller() {

        String sql = "select VenVen As Codigo, NombreVen As Nombre, CiudadVen As Ubicacion, CedulaVen As Cedula, 'S01' As Supervisor from ODBC_TABLA_DESCRIPCION_VENDEDORES";
        return ConnectionDB.consult(new HostData(), sql);
    }

    public static JSONArray business() {

        String sql = "select TipoCalif As Codigo, Replace((NombreCalif),'0', '') As Nombre from ODBC_TABLA_DESCRIPCION_CALIFICACION";
        return ConnectionDB.consult(new HostData(), sql);
    }

    public static JSONArray customers() {

        String sql = "select M.NitMov As Codigo, C.NombreNit As Nombre, MID(C.FechaAperturaNit,7,2)+MID(C.FechaAperturaNit,5,2)+MID(C.FechaAperturaNit,1,4) As FechaIngreso, NitMov As Nit, DireccionNit As Direccion, Telefono1Nit As Telefono, ContactoNit As RepLegal, CiudadNit As CodMunicipio, CalifNit As TipNegocio, ZonaVen As CodZona from (ODBC_TABLA_IDENTIFICACION_CLIENTES As C left join ODBC_TABLA_MOVIMIENTO_POR_COMPROBANTE As M ON ((C.NitNit=M.NitMov) AND( C.SucNit=M.SucMov))) left join ODBC_TABLA_DESCRIPCION_VENDEDORES As V ON (C.VendedorNit=V.VenVen) where MesDctoMov=1 AND GrpMov in (9,41) group by NitMov, NombreNit, FechaAperturaNit, DireccionNit, Telefono1Nit, ContactoNit, CiudadNit, CalifNit, ZonaVen";
        return ConnectionDB.consult(new HostData(), sql);
    }

    public static JSONArray sku() {

        String sql = "select ProductoInv As Codigo, DescripcionInv As Nombre, '' As TipoReferencia, 'UN' As TipoDeUnidad, CodBarInv As CodBarras, GruInv As Compañia from ODBC_TABLA_MAESTRO_INVENTARIOS where GruInv in (9,41)";
        return ConnectionDB.consult(new HostData(), sql);
    }

    public static JSONArray billList() {

        String sql = "select NitMov As CodigoCliente, VendedorMov As CodigoVendedor, FechaDctoMov As Fecha, NroMov As NroDocumento from ODBC_TABLA_MOVIMIENTO_POR_COMPROBANTE where MesDctoMov=1 AND GrpMov in (9,41) Group by NitMov, VendedorMov, FechaDctoMov, NroMov";
        return ConnectionDB.consult(new HostData(), sql);
    }

    public static JSONArray sales(String month) {

        String sql = "select NitMov As CodCliente, ProductoMov As CodProducto, VendedorMov As CodVendedor, MID(FechaDctoMov,7,2)+MID(FechaDctoMov,5,2)+MID(FechaDctoMov,1,4) As Fecha, NroMov As NumDoc, CantidadMov As Cantidad, ValorMov As Valor, SWITCH(TipMov='F', '0', TipMov='J', '1') As Tipo, CompraInv As Compra from ODBC_TABLA_MOVIMIENTO_POR_COMPROBANTE As M left join TABLA_INVENTARIOS As I ON M.ProductoMov=I.ProductoInv where MesDctoMov=" + month + " AND GrpMov in (9,41) AND GruMov='41'";
        return ConnectionDB.consult(new HostData(), sql);

    }
    
    public static JSONArray inventory (){
        
        String sql = "select FechaInv As Fecha, ProductoInv As CodProducto, SaldoInv As Cantidad, 'UN' As UnidadMedida from TABLA_INVENTARIOS";
        return ConnectionDB.consult(new HostData(), sql);
    }
}
