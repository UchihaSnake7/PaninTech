/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panin.application.utilities;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author ricke
 */
public class ValidadorFormulario {
    
    private JPanel panel;
    private List<JTextField> camposTexto = new ArrayList<>();
    private List<JTextArea> camposTextArea = new ArrayList<>();

    // Agrega más listas para otros tipos de componentes si es necesario

    public ValidadorFormulario(JPanel panel) {
        this.panel = panel;
        buscarCampos();
    }

    public void buscarCampos() {
        // Recorre todos los componentes del panel
        Component[] componentes = panel.getComponents();
        for (Component componente : componentes) {
            if (componente instanceof JTextField){
                camposTexto.add((JTextField) componente);
            } 
            else if (componente instanceof JTextArea) {
                camposTextArea.add((JTextArea) componente);
            }
            
            // Agrega más condiciones para otros tipos de componentes
        }
    }

    public boolean validarFormulario() {
        boolean valido = true;
        for (JTextField campo : camposTexto) {
            if (campo.getText().trim().isEmpty()) {
                // Mostrar un mensaje de error para el campo específico
                JOptionPane.showMessageDialog(null, "El campo " + campo.getName() + " no puede estar vacío.");
                valido = false;
            }
        }
        
        for (JTextArea campo : camposTextArea) {
            if (campo.getText().trim().isEmpty()) {
                // Mostrar un mensaje de error para el campo específico
                JOptionPane.showMessageDialog(null, "El campo " + campo.getName() + " no puede estar vacío.");
                valido = false;
            }
        }
        
       
        // Agregar validaciones para otros tipos de componentes y condiciones
        return valido;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public List<JTextField> getCamposTexto() {
        return camposTexto;
    }

    public void setCamposTexto(List<JTextField> camposTexto) {
        this.camposTexto = camposTexto;
    }

    public List<JTextArea> getCamposPassword() {
        return camposTextArea;
    }

    public void setCamposPassword(List<JTextArea> camposTextArea) {
        this.camposTextArea = camposTextArea;
    }

    
    
}
