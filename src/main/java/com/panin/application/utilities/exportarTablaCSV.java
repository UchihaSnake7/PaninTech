/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panin.application.utilities;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.table.TableModel;

/**
 *
 * @author ricke
 */
public class exportarTablaCSV {
    
    public static boolean exportaraCSV(JTable tabla,
        String ruta) {

    try {

        TableModel model = tabla.getModel();
        File file = new File(ruta);
        file.getParentFile().mkdirs();
        file.createNewFile();
        FileWriter csv = new FileWriter(file);

        for (int i = 0; i < model.getColumnCount(); i++) {
            csv.write(model.getColumnName(i) + ",");
        }

        csv.write("\n");

        for (int i = 0; i < model.getRowCount(); i++) {
            for (int j = 0; j < model.getColumnCount(); j++) {
                csv.write(model.getValueAt(i, j).toString() + ",");
            }
            csv.write("\n");
        }

        csv.close();
        return true;
    } catch (IOException e) {
        e.printStackTrace();
    }
    return false;
}
    
}
