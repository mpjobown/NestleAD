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

    public static boolean create(String item, String nameFile, JSONArray jsonArray) {
        //Elementos que crean el txt
        File archive;
        FileWriter wrArchive;
        BufferedWriter bwArchive;
        PrintWriter pwArchive;

        try {
            //inicializa elementos del txt
            archive = new File(nameFile + ".txt");
            wrArchive = new FileWriter(archive);
            bwArchive = new BufferedWriter(wrArchive);
            pwArchive = new PrintWriter(bwArchive);

            JSONObject A = new JSONObject();
            String writeColumns = "";
            ArrayList arrayColumns = new ArrayList();
            for (int i = 0; i < jsonArray.size() - 1; i++) {
                JSONArray jsonColumns = (JSONArray) jsonArray.get(i);
                for (int j = 0; j < jsonColumns.size(); j++) {
                    A = (JSONObject) jsonColumns.get(j);
                    arrayColumns.add(A.get("Field"));
                    if (j  < arrayColumns.size()) {
                        writeColumns = writeColumns + A.get("Field").toString() + "{";
                    } else {
                        writeColumns = writeColumns + "\r\n";
                    }
                }
            }
            wrArchive.write(writeColumns); //coloca el nombre a las columnas

            JSONObject B = new JSONObject();
            String auxData = "";
            for (int m = 1; m < jsonArray.size(); m++) {
                JSONArray e = (JSONArray) jsonArray.get(m);
                for (int marian = 0; marian < e.size(); marian++) {
                    JSONObject C = (JSONObject) e.get(marian);
                    for (int n = 0; n < arrayColumns.size(); n++) {
                        String prueba = (String) C.get(arrayColumns.get(n));
                        String aux2 = prueba;
                        if (n + 1 < arrayColumns.size()) {
                            auxData = auxData + aux2 + "{";
                        } else {
                            auxData = auxData + aux2 + "\r\n";
                        }
                    }
                }
            }
            wrArchive.append(auxData);
            wrArchive.close();
            bwArchive.close();
            return true;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }
}
