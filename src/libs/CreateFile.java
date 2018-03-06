/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libs;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author trabajo
 */
public class CreateFile {

    public static boolean create(String nameFile, JSONArray jsonArray) {
        //Elementos que crean el txt
        File archive;
        FileWriter wrArchive;
        BufferedWriter bwArchive;

        try {
            //inicializa elementos del txt
            archive = new File("docs\\" + nameFile + ".txt");
            wrArchive = new FileWriter(archive);
            bwArchive = new BufferedWriter(wrArchive);

            JSONObject A = new JSONObject();
            String writeColumns = "";
            ArrayList arrayColumns = new ArrayList();
            for (int i = 0; i < jsonArray.size() - 1; i++) {
                JSONArray jsonColumns = (JSONArray) jsonArray.get(i);
                for (int j = 0; j < jsonColumns.size(); j++) {
                    A = (JSONObject) jsonColumns.get(j);
                    arrayColumns.add(A.get("Field"));

                    if (j < jsonColumns.size() - 1) {
                        writeColumns = writeColumns + A.get("Field").toString() + "{";
                    } else {
                        writeColumns = writeColumns + A.get("Field").toString();
                    }
                }
            }
            wrArchive.write(writeColumns + "\r\n"); //coloca el nombre a las columnas

            JSONArray B = (JSONArray) jsonArray.get(1);
            for (int j = 0; j < B.size(); j++) {
                String auxData = "";
                JSONObject C = (JSONObject) B.get(j);
                for (int k = 0; k < arrayColumns.size(); k++) {
                    String aux1 = (String) C.get(arrayColumns.get(k));
                    String aux2 = aux1;
                    if (k < arrayColumns.size() - 1) {
                        auxData = auxData + aux2 + "{";
                    } else {
                        auxData = auxData + aux2 + "\r\n";
                    }
                }
                wrArchive.append(auxData);
            }

            wrArchive.close();
            bwArchive.close();
            return true;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }
}
