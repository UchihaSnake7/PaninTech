/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.panin.application.form.insumos.crear;

import com.formdev.flatlaf.FlatClientProperties;
import com.panin.application.Application;
import com.panin.application.form.insumos.reportecompra.FormReporteMarcasInsumo;
import com.panin.controladores.ControladorMarcaInsumo;
import com.panin.entidades.MarcaInsumo;
import net.miginfocom.swing.MigLayout;
import raven.toast.Notifications;
import javax.swing.JFrame;

/**
 *
 * @author USUARIO
 */
public class FormCrearMarcaInsumoN extends javax.swing.JPanel {

    /**
     * Creates new form FormCrearMarcaInsumoN
     */
    public FormCrearMarcaInsumoN() {
        initComponents();

        textoHint1.putClientProperty(FlatClientProperties.STYLE, ""
                + "foreground:$Menu.foreground;");
        jAtras.putClientProperty(FlatClientProperties.STYLE, ""
                + "foreground:$Menu.foreground;");

        jCrear.putClientProperty(FlatClientProperties.STYLE, ""
                + "foreground:$Menu.foreground;");
        jLabel1.putClientProperty(FlatClientProperties.STYLE, ""
                + "foreground:$Menu.foreground;");
        jLabel2.putClientProperty(FlatClientProperties.STYLE, ""
                + "foreground:$Menu.foreground;");

        jNombre.putClientProperty(FlatClientProperties.STYLE, ""
                + "foreground:$Menu.foreground;");

        textoHint1.putClientProperty(FlatClientProperties.STYLE, ""
                + "foreground:$Menu.foreground;");

        textoHint1.setHint("Ingrese Descripción");
        panel.putClientProperty(FlatClientProperties.STYLE, ""
                + "background:$Login.background;"
                + "arc:50;");

        setLayout(new MigLayout("al center center"));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jNombre = new javax.swing.JLabel();
        textoHint1 = new com.panin.application.utilities.TextoHint();
        jLabel2 = new javax.swing.JLabel();
        jAtras = new javax.swing.JButton();
        jCrear = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Crear Marca de Insumos");

        jNombre.setText("Nombre");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/utilidad/marca.png"))); // NOI18N

        jAtras.setText("Atrás");
        jAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAtrasActionPerformed(evt);
            }
        });

        jCrear.setText("Crear");
        jCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCrearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addGap(99, 99, 99))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(jNombre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(textoHint1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(jAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel2))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel1)))
                .addGap(51, 51, 51)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jNombre)
                    .addComponent(textoHint1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jAtras)
                    .addComponent(jCrear))
                .addGap(50, 50, 50))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCrearActionPerformed
        // TODO add your handling code here:
        String nombre = textoHint1.getText();
        if (textoHint1.getText() == null || nombre.length() == 0 || textoHint1.getText().equals(" ")) {
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_CENTER, "Por Favor Ingrese Nombre de la Marca");
        } else {

            MarcaInsumo marcaInsumo = new MarcaInsumo();
            marcaInsumo.setNombre(nombre);
            marcaInsumo.setActivo(true);

            ControladorMarcaInsumo controladorMarcaInsumo = new ControladorMarcaInsumo();
            if (controladorMarcaInsumo.save(marcaInsumo)) {
                Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.TOP_CENTER, "Marca Creado con Exito!!");
                textoHint1.setText("");
                textoHint1.setHint("Ingrese descripción...");
            } else {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "Error al crear Marca Insumo");
            }

        }
    }//GEN-LAST:event_jCrearActionPerformed

    private void jAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAtrasActionPerformed
//         this.setVisible(false);
    }//GEN-LAST:event_jAtrasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jAtras;
    private javax.swing.JButton jCrear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jNombre;
    private javax.swing.JPanel panel;
    private com.panin.application.utilities.TextoHint textoHint1;
    // End of variables declaration//GEN-END:variables
private String formRetorno;

    public String getFormRetorno() {
        return formRetorno;
    }

    public void setFormRetorno(String formRetorno) {
        this.formRetorno = formRetorno;
    }

}