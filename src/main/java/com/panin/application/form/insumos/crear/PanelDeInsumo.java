/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.panin.application.form.insumos.crear;

import com.formdev.flatlaf.FlatClientProperties;
import com.panin.application.Application;
import com.panin.application.form.insumos.FormVerInsumos;
import com.panin.controladores.ControladorInsumos;
import com.panin.controladores.ControladorTipoMedida;
import com.panin.entidades.Insumo;
import com.panin.entidades.TipoMedida;
import java.util.List;
import net.miginfocom.swing.MigLayout;
import raven.toast.Notifications;

/**
 *
 * @author USUARIOpublic class PanelDeInsumo extends javax.swing.JPanel {
 *
 */
public class PanelDeInsumo extends javax.swing.JPanel {

    /**
     * Creates new form PanelDeInsumo
     */
    private Insumo insumo;
    private String verdadero = "Activo";
    private String falso = "Inactivo";
    private String activo;

    public PanelDeInsumo(Insumo insumo, Boolean editar) {
        initComponents();
        init();

        jLabel1.setText(insumo.toString());
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource(insumo.getRutaImagen())));
        textoHint1.setText(insumo.getDescripcion());
        jActualizar.setEnabled(editar);
        jComboBox1.setEditable(false);
        jComboBox1.setEnabled(false);
        jActivo.setEnabled(editar);
        this.insumo = insumo;
        textoHint1.setEditable(editar);
        ControladorTipoMedida controladorTipoMedida = new ControladorTipoMedida();
        List<TipoMedida> medidas = controladorTipoMedida.obtenerTipoMedida();

        for (TipoMedida tipoMedida : medidas) {
            jComboBox1.addItem(tipoMedida);
            if (tipoMedida.equals(insumo.getIdTipoMedida())) {
                jComboBox1.setSelectedItem(tipoMedida);
            }
        }

        jActivo.addItem(verdadero);
        jActivo.addItem(falso);

        if (insumo.getActivo()) {
            jActivo.setSelectedItem(verdadero);
            activo = verdadero;
        } else {
            jActivo.setSelectedItem(falso);
            activo = falso;
        }
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        textoHint1 = new com.panin.application.utilities.TextoHint();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jActualizar = new javax.swing.JButton();
        jAtras = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jActivo = new javax.swing.JComboBox<>();

        jLabel1.setText("Insumo");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/insumos/default.png"))); // NOI18N
        jLabel2.setText("\n");

        jLabel3.setText("Descripción");

        jLabel4.setText("Tipo Medida");

        jActualizar.setText("Actualizar");
        jActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jActualizarActionPerformed(evt);
            }
        });

        jAtras.setText("Atrás");
        jAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAtrasActionPerformed(evt);
            }
        });

        jLabel5.setText("Activo");

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(jLabel2)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel1))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(31, 31, 31)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textoHint1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jActivo, 0, 206, Short.MAX_VALUE)))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(jAtras)
                        .addGap(57, 57, 57)
                        .addComponent(jActualizar)))
                .addContainerGap(96, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(32, 32, 32)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textoHint1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jActivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jAtras)
                    .addComponent(jActualizar))
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAtrasActionPerformed
        Application.showForm(new FormVerInsumos());
    }//GEN-LAST:event_jAtrasActionPerformed

    private void jActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jActualizarActionPerformed
        ControladorInsumos controladorInsumo = new ControladorInsumos();
        String opcion = (String) jActivo.getSelectedItem();

        if ((!textoHint1.getText().isEmpty() && !textoHint1.equals(insumo.getDescripcion())) || !opcion.equals(activo)) {
            System.out.println("1 " + !textoHint1.getText().isEmpty());
            System.out.println("2 " + !textoHint1.equals(insumo.getDescripcion()));
            System.out.println("3 " + !opcion.equals(activo));
            System.out.println(activo + " " + opcion);
            if (!opcion.equals(activo)) {
                if (opcion.equals(verdadero)) {
                    insumo.setActivo(true);
                } else {
                    insumo.setActivo(false);
                }
            }
            if (!textoHint1.getText().isEmpty() && !textoHint1.equals(insumo.getDescripcion())) {
                insumo.setDescripcion(textoHint1.getText());
                System.out.println(insumo.getDescripcion());
            }

            if (controladorInsumo.update(insumo)) {
                Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.TOP_CENTER, "Insumo Actualizado!");
                jActualizar.setEnabled(false);
                jLabel1.setText(insumo.toString());
            } else {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "Error al actualizar Insumo");
            }
        } else {
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_CENTER, "No se detectaron cambios o no son válidos...");
        }
    }//GEN-LAST:event_jActualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jActivo;
    private javax.swing.JButton jActualizar;
    private javax.swing.JButton jAtras;
    private javax.swing.JComboBox<TipoMedida> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel panel;
    private com.panin.application.utilities.TextoHint textoHint1;
    // End of variables declaration//GEN-END:variables

    private void init() {

        panel.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:25;"
                + "background:$Login.background;"
        );

        textoHint1.putClientProperty(FlatClientProperties.STYLE, ""
                + "foreground:$Menu.foreground;");

        jComboBox1.putClientProperty(FlatClientProperties.STYLE, ""
                + "foreground:$Menu.foreground;");
        jActualizar.putClientProperty(FlatClientProperties.STYLE, ""
                + "foreground:$Menu.foreground;");
        jAtras.putClientProperty(FlatClientProperties.STYLE, ""
                + "foreground:$Menu.foreground;");
        jLabel1.putClientProperty(FlatClientProperties.STYLE, ""
                + "foreground:$Menu.foreground;");
        jLabel2.putClientProperty(FlatClientProperties.STYLE, ""
                + "foreground:$Menu.foreground;");

        textoHint1.putClientProperty(FlatClientProperties.STYLE, ""
                + "foreground:$Menu.foreground;");

        jLabel5.putClientProperty(FlatClientProperties.STYLE, ""
                + "foreground:$Menu.foreground;");
        jActualizar.putClientProperty(FlatClientProperties.STYLE, ""
                + "foreground:$Menu.foreground;");
        setLayout(new MigLayout("al center center"));

    }
}
