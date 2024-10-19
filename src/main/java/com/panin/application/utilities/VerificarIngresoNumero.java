/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panin.application.utilities;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author ricke
 */
public class VerificarIngresoNumero {
    
    public static void verificar(com.panin.application.utilities.TextoHint textfield){
       
        textfield.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent ke) {
                char c = ke.getKeyChar();
                String text = textfield.getText();

                // Permitir números, coma y signo negativo al inicio
                if (!(Character.isDigit(c) || c == ',')) {
                    ke.consume();
                    return;
                }
                    if (text.length() >= 12) {
                    ke.consume();
                    return;
                }

                // Permitir solo una coma
                if (c == ',' && text.contains(",")) {
                    ke.consume();
                }

                // Limitar a cuatro decimales
                int index = text.indexOf(',');
                if (index >= 0 && text.length() - index - 1 > 3) {
                    ke.consume();
                }
            }
        });

        
    }
    
}
