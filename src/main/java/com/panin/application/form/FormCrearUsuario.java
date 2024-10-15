package com.panin.application.form;

import com.panin.application.form.other.*;
import com.formdev.flatlaf.FlatClientProperties;
import com.panin.application.Application;
import java.awt.Component;
import java.awt.Container;
import com.panin.controladores.ControladorUsuario;
import com.panin.entidades.Usuarios;
import java.awt.Dimension;
import net.miginfocom.swing.MigLayout;
import java.awt.LayoutManager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import raven.toast.Notifications;

/**
 *
 * @author Raven
 */
public class FormCrearUsuario extends javax.swing.JPanel {

    public FormCrearUsuario() {
        initComponents();
        init();
        lb.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h1.font");
        jLabel1.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h1.font");
        jLabel2.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h1.font");
        jLabel3.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h1.font");
        lb1.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h1.font");
    }

    private void init() {

        setLayout(new CambioLayout());
        Cambio.putClientProperty(FlatClientProperties.STYLE, "" + "background:$Login.background;" + "arc:20");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Cambio = new javax.swing.JPanel();
        lb = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Correo = new com.panin.application.utilities.TextoHint();
        lb1 = new javax.swing.JLabel();
        Usuario = new com.panin.application.utilities.TextoHint();
        Clave = new com.panin.application.utilities.TextoHint();
        jLabel2 = new javax.swing.JLabel();

        Cambio.setBackground(new java.awt.Color(60, 78, 102));
        Cambio.setName("cambio"); // NOI18N

        lb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb.setText("Correo");

        jButton1.setText("Crear Usuario");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Usuario");

        jLabel3.setText("Nuevo Usuario");

        lb1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb1.setText("Clave");

        javax.swing.GroupLayout CambioLayout = new javax.swing.GroupLayout(Cambio);
        Cambio.setLayout(CambioLayout);
        CambioLayout.setHorizontalGroup(
            CambioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CambioLayout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addGroup(CambioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CambioLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(38, 38, 38))
                    .addGroup(CambioLayout.createSequentialGroup()
                        .addGroup(CambioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(42, 42, 42)))
                .addGroup(CambioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Clave, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(CambioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Usuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Correo, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(140, 140, 140))
            .addGroup(CambioLayout.createSequentialGroup()
                .addGroup(CambioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CambioLayout.createSequentialGroup()
                        .addGap(248, 248, 248)
                        .addComponent(jButton1))
                    .addGroup(CambioLayout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        CambioLayout.setVerticalGroup(
            CambioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CambioLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel3)
                .addGap(38, 38, 38)
                .addGroup(CambioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(CambioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(CambioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb1)
                    .addComponent(Clave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(jButton1)
                .addGap(21, 21, 21))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("PaninTech");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(277, 277, 277))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Cambio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(200, 200, 200))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addComponent(Cambio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(200, 200, 200))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            Usuarios cr = new Usuarios();
            cr.setUsername(Usuario.getText());
            cr.setCorreoElectronico(Correo.getText());
            cr.setContrasena(Clave.getText());
            cr.setActivo(true);
            ControladorUsuario ct = new ControladorUsuario();
            ct.crearUsuario(cr);
//            ct.cerrarSesion();
            Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER, "Tasa actulizada con exito");
            Application.showForm(new FormDashboard());
    }//GEN-LAST:event_jButton1ActionPerformed

    private class CambioLayout implements LayoutManager {

        @Override
        public void addLayoutComponent(String name, Component comp) {

        }

        @Override
        public void removeLayoutComponent(Component comp) {

        }

        @Override
        public Dimension preferredLayoutSize(Container parent) {
            synchronized (parent.getTreeLock()) {
                return new Dimension(5, 5);
            }
        }

        @Override
        public Dimension minimumLayoutSize(Container parent) {
            synchronized (parent.getTreeLock()) {
                return new Dimension(5, 5);
            }

        }

        @Override
        public void layoutContainer(Container parent) {
            synchronized (parent.getTreeLock()) {
                int width = parent.getWidth();
                int heigth = parent.getHeight();
                int CambioWidth = 560;
                int CambioHeigth = Cambio.getPreferredSize().height;
                int x = (width - CambioWidth) / 2;
                int y = (heigth - CambioHeigth) / 2;
                Cambio.setBounds(x, y, CambioWidth, CambioHeigth);

            }
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Cambio;
    private com.panin.application.utilities.TextoHint Clave;
    private com.panin.application.utilities.TextoHint Correo;
    private com.panin.application.utilities.TextoHint Usuario;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lb;
    private javax.swing.JLabel lb1;
    // End of variables declaration//GEN-END:variables
}
