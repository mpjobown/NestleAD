/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nestlead.Controllers;

import java.util.Calendar;
import libs.CreateFile;
import nestlead.Models.MGetInformation;
import org.json.simple.JSONArray;

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

        if (!createFileSellers()) {
            System.out.println("Error, no se pudo crear el archivo vendedores..");
        }

        if (!createFileBussinesType()) {
            System.out.println("Error, no se pudo crear el archivo tipo de negocio..");
        }

        if (!createFileSku()) {
            System.out.println("Error, no se pudo crear el archivo de sku..");
        }

        if (!createFileInventory()) {
            System.out.println("Error, no se pudo crear el archivo de inventario..");
        }

        if (!createFileBillList()) {
            System.out.println("Error, no se pudo crear el archivo listado de facturas..");
        }

        if (!createFileSupervisor()) {
            System.out.println("Error, no se pudo crear el archivo de supervisores..");
        }

        if (!createFileTotalSales()) {
            System.out.println("Error, no se pudo crear el archivo totales de control.");
        }
        
        if (!createFileCustomers()) {
            System.out.println("Error, no se pudo crear el archivo de clientes..");
        }

        if (!createFileSales()) {
            System.out.println("Error, no se pudo crear el archivo de ventas..");
        }

        return null;
    }

    private static boolean createFileCities() {
        JSONArray jsonArray = new JSONArray();
        jsonArray = MGetInformation.city();

        return CreateFile.create("Z_MUNICIPIOS", jsonArray);
    }

    private static boolean createFileSellers() {
        JSONArray jsonArray = new JSONArray();
        jsonArray = MGetInformation.seller();

        return CreateFile.create("Z_VENDEDORES", jsonArray);
    }

    private static boolean createFileBussinesType() {
        JSONArray jsonArray = new JSONArray();
        jsonArray = MGetInformation.business();

        return CreateFile.create("Z_TIPNEGOCIO", jsonArray);
    }

    private static boolean createFileSku() {
        JSONArray jsonArray = new JSONArray();
        jsonArray = MGetInformation.sku();

        return CreateFile.create("Z_SKU", jsonArray);
    }

    private static boolean createFileCustomers() {
        String month = getMonth();
        JSONArray jsonArray = new JSONArray();
        jsonArray = MGetInformation.customers(month);

        return CreateFile.create("Z_CLIENTES", jsonArray);
    }

    private static boolean createFileSales() {
        String month = getMonth();
        JSONArray jsonArray = new JSONArray();
        jsonArray = MGetInformation.sales(month);

        return CreateFile.create("Z_VENTAS", jsonArray);
    }

    private static boolean createFileBillList() {
        String month = getMonth();
        JSONArray jsonArray = new JSONArray();
        jsonArray = MGetInformation.billList(month);

        return CreateFile.create("Z_LISTAFACTURAS", jsonArray);
    }

    private static boolean createFileInventory() {
        JSONArray jsonArray = new JSONArray();
        jsonArray = MGetInformation.inventory();

        return CreateFile.create("Z_INVENTARIO", jsonArray);
    }

    private static boolean createFileSupervisor() {
        JSONArray jsonArray = new JSONArray();
        jsonArray = MGetInformation.supervisor();

        return CreateFile.create("Z_SUPERVISORES", jsonArray);
    }

    private static boolean createFileTotalSales() {
        String month = getMonth();
        JSONArray jsonArray = new JSONArray();
        jsonArray = MGetInformation.totalSales(month);

        return CreateFile.create("Z_TOTALESCONTROL", jsonArray);
    }

    private static String getMonth() {

        Calendar c1 = Calendar.getInstance();
        int day = c1.get(Calendar.DAY_OF_MONTH);
        int month = c1.get(Calendar.MONDAY);
        String currentMonth;
        if (day != 5) {
            currentMonth = (month + 1) + "";
        } else {
            currentMonth = month == 0 ? "12" : (month) + "";
        }
        return currentMonth;
    }
}
