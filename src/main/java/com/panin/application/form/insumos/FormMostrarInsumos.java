/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.panin.application.form.insumos;

import java.awt.Scrollbar;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import com.panin.application.utilities.ScrollBar;
import com.panin.application.utilities.WrapLayout;
import com.panin.controladores.ControladorInsumos;
import com.panin.entidades.Insumo;
import com.panin.application.form.other.Card;
import com.panin.application.form.other.Model_Card;
import com.panin.application.utilities.SearchHeader2.BuscadorListener;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author USUARIO
 */
public class FormMostrarInsumos extends javax.swing.JPanel {

    /**
     * Creates new form FormMostrarInsumos
     */
    public FormMostrarInsumos() {
        initComponents();
        init();
    }

    private void init() {
        panel.setLayout(new WrapLayout(WrapLayout.LEADING));
        jScrollPane1.setVerticalScrollBar(new ScrollBar());

        ControladorInsumos ci = new ControladorInsumos();
        insumos = new ArrayList<Insumo>();
        insumos = ci.obtenerInsumos();
//        ci.cerrarSesion();

        for (Insumo insumo : insumos) {
            Card card = new Card(new Model_Card(new javax.swing.ImageIcon(getClass().getResource(insumo.getRutaImagen())), insumo.getDescripcion(), "", "Descripcion"), getBackground(), formClass);
            card.setInsumo(insumo);
            panel.add(card);

        }

        panel.revalidate();
        panel.repaint();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();

        jScrollPane1.setBorder(null);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 685, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 430, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(panel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables

    private List<Insumo> insumos;
    private String formClass = "PanelIngresarInsumo";

    public void filtrarLista(String texto) {
        panel.removeAll();
        List<Insumo> insumosFiltradas = (List<Insumo>) insumos.stream()
                .filter(insumo -> insumo.getDescripcion().toLowerCase().contains(texto.toLowerCase()))
                .collect(Collectors.toList());

        for (Insumo insumo : insumosFiltradas) {
            Card card = new Card(new Model_Card(new javax.swing.ImageIcon(getClass().getResource(insumo.getRutaImagen())), insumo.getDescripcion(), "", "Descripcion"), getBackground(), formClass);
            card.setInsumo(insumo);
            panel.add(card);

        }
        panel.revalidate();
        panel.repaint();
    }
}
