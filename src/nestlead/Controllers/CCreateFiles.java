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
        if (!createFileSellers()) {
            System.out.println("Error, no se pudo crear el archivo vendedores..");
        }
        if (!createFileBussinesType()) {
            System.out.println("Error, no se pudo crear el archivo tipo de negocio..");
        }
        if (!createFileSales()) {
            System.out.println("Error, no se pudo crear el archivo de ventas..");
        }
        if (!createCustomers()) {
            System.out.println("Error, no se pudo crear el archivo de clientes..");
        }
        if (!createSku()) {
            System.out.println("Error, no se pudo crear el archivo de sku..");
        }
//        if (!createFileBillList()) {
//            System.out.println("Error, no se pudo crear el archivo listado de facturas..");
//        }

        return null;
    }

    private static boolean createFileCities() {
        JSONArray jsonArray = new JSONArray();
        jsonArray = MGetInformation.city();

        return CreateFile.create("Z_CIUDADES", jsonArray);
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

    private static boolean createSku() {
        JSONArray jsonArray = new JSONArray();
        jsonArray = MGetInformation.sku();

        return CreateFile.create("Z_SKU", jsonArray);
    }

    private static boolean createCustomers() {
        JSONArray jsonArray = new JSONArray();
        jsonArray = MGetInformation.customers();

        return CreateFile.create("Z_CLIENTES", jsonArray);
    }

    private static boolean createFileSales() {

        String month = getMonth();
        JSONArray jsonArray = new JSONArray();
        jsonArray = MGetInformation.sales(month);
        return CreateFile.create("Z_VENTAS", jsonArray);
    }

    private static boolean createFileBillList() {
        JSONArray jsonArray = new JSONArray();
        jsonArray = MGetInformation.billList();

        return CreateFile.create("Z_LISTFACTURAS", jsonArray);
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
