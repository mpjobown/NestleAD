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

    public static JSONArray sku() {

        String sql = "select ProductoInv As Codigo, DescripcionInv As Nombre, '' As TipoReferencia, 'UN' As TipoDeUnidad, CodBarInv As CodBarras, GruInv As Compañia from ODBC_TABLA_MAESTRO_INVENTARIOS where GruInv in (9,41)";
        return ConnectionDB.consult(new HostData(), sql);
    }

    public static JSONArray billList(String month) {

        String sql = "select M.NitMov As CodigoCliente, M.VendedorMov As CodigoVendedor, MID(M.FechaDctoMov,7,2)+MID(M.FechaDctoMov,5,2)+MID(M.FechaDctoMov,1,4) As Fecha, M.NroMov As NroDocumento, F.SumaDeValorMov As TotFactura,  Sum(IIF (M.DcMov='C', M.ValorMov, M.ValorMov*-1)) As TotCasa from ODBC_TABLA_MOVIMIENTO_POR_COMPROBANTE AS M left join ODBC_TABLA_FACTURAS As F ON M.NroMov=F.NroMov  where MesDctoMov=" + month + " AND GrpMov in (9,41) AND M.GruMov='41' AND TipMov='F' Group by M.NitMov, M.VendedorMov, M.FechaDctoMov, M.NroMov, F.SumaDeValorMov";
        return ConnectionDB.consult(new HostData(), sql);
    }

    public static JSONArray sales(String month) {

        String sql = "select M.NitMov As CodCliente, M.VendedorMov As CodVendedor, M.ProductoMov As CodProducto, MID(M.FechaDctoMov,7,2)+MID(M.FechaDctoMov,5,2)+MID(M.FechaDctoMov,1,4) As Fecha, M.NroMov As NumDoc, M.CantidadMov As Cantidad, M.ValorMov As Valor, IIF(M.DcMov='C', '0', '1') As Tipo, I.CompraInv As Compra, 'UN' As TipoDeUnidad from ODBC_TABLA_MOVIMIENTO_POR_COMPROBANTE As M left join TABLA_INVENTARIOS As I ON M.ProductoMov=I.ProductoInv where GruMov='41' AND MesDctoMov=" + month + " AND GrpMov in (9,41)";
        return ConnectionDB.consult(new HostData(), sql);
    }

    public static JSONArray inventory() {

        String sql = "select FechaInv As Fecha, ProductoInv As CodProducto, SaldoInv As Cantidad, 'UN' As UnidadMedida from TABLA_INVENTARIOS where ActivoInv='S'";
        return ConnectionDB.consult(new HostData(), sql);
    }

    public static JSONArray supervisor() {
    
        String sql = "select CodSup As Codigo, NombreSup As Nombre from TABLA_SUPERVISORES";
        return ConnectionDB.consult(new HostData(), sql);
    }
    
    public static JSONArray totalSales(String month) {
    
        String sql = "select 'TotalValorVenta' As TotalValorVenta, Format(Sum(IIF (DcMov='C', ValorMov, ValorMov*-1)),  'Fixed') As Valor from ODBC_TABLA_MOVIMIENTO_POR_COMPROBANTE where MesDctoMov=" + month + " AND GrpMov in (9,41) AND GruMov='41'";
        return ConnectionDB.consult(new HostData(), sql);
    }
    
     public static JSONArray customers(String month) {

        String sql = "select M.NitMov As Codigo, C.NombreNit As Nombre, MID(C.FechaAperturaNit,7,2)+MID(C.FechaAperturaNit,5,2)+MID(C.FechaAperturaNit,1,4) As FechaIngreso, NitMov As Nit, DireccionNit As Direccion, Telefono1Nit As Telefono, ContactoNit As RepLegal, CiudadNit As CodMunicipio, CalifNit As TipNegocio, ZonaVen As CodZona from (ODBC_TABLA_CLIENTES As C left join ODBC_TABLA_MOVIMIENTO_POR_COMPROBANTE As M ON ((C.NitNit=M.NitMov) AND( C.SucNit=M.SucMov))) left join ODBC_TABLA_DESCRIPCION_VENDEDORES As V ON (C.VendedorNit=V.VenVen) where GruMov='41' AND MesDctoMov=" + month + " AND GrpMov in (9,41) group by NitMov, NombreNit, FechaAperturaNit, DireccionNit, Telefono1Nit, ContactoNit, CiudadNit, CalifNit, ZonaVen";
        return ConnectionDB.consult(new HostData(), sql);
    }
}
