package com.panin.application.form;

import com.panin.application.form.other.*;
import com.formdev.flatlaf.FlatClientProperties;
import com.panin.application.Application;
import com.panin.application.utilities.ValidadorFormulario;
import java.awt.Component;
import java.awt.Container;
import com.panin.controladores.ControladorUsuario;
import com.panin.entidades.Usuarios;
import java.awt.Dimension;
import net.miginfocom.swing.MigLayout;
import java.awt.LayoutManager;
import org.apache.commons.codec.digest.DigestUtils;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static java.util.Objects.hash;
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
        panelFormCrearUsuario.putClientProperty(FlatClientProperties.STYLE, "" + "background:$Login.background;" + "arc:20");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelFormCrearUsuario = new javax.swing.JPanel();
        lb = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Correo = new com.panin.application.utilities.TextoHint();
        lb1 = new javax.swing.JLabel();
        Usuario = new com.panin.application.utilities.TextoHint();
        Clave = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();

        panelFormCrearUsuario.setBackground(new java.awt.Color(60, 78, 102));
        panelFormCrearUsuario.setName("cambio"); // NOI18N

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

        Correo.setName("Correo"); // NOI18N

        lb1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb1.setText("Clave");

        Usuario.setName("Usuario"); // NOI18N

        Clave.setName("Clave"); // NOI18N

        javax.swing.GroupLayout panelFormCrearUsuarioLayout = new javax.swing.GroupLayout(panelFormCrearUsuario);
        panelFormCrearUsuario.setLayout(panelFormCrearUsuarioLayout);
        panelFormCrearUsuarioLayout.setHorizontalGroup(
            panelFormCrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormCrearUsuarioLayout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addGroup(panelFormCrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFormCrearUsuarioLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(38, 38, 38))
                    .addGroup(panelFormCrearUsuarioLayout.createSequentialGroup()
                        .addGroup(panelFormCrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(42, 42, 42)))
                .addGroup(panelFormCrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Usuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Correo, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                    .addComponent(Clave))
                .addGap(140, 140, 140))
            .addGroup(panelFormCrearUsuarioLayout.createSequentialGroup()
                .addGroup(panelFormCrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFormCrearUsuarioLayout.createSequentialGroup()
                        .addGap(248, 248, 248)
                        .addComponent(jButton1))
                    .addGroup(panelFormCrearUsuarioLayout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelFormCrearUsuarioLayout.setVerticalGroup(
            panelFormCrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormCrearUsuarioLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel3)
                .addGap(38, 38, 38)
                .addGroup(panelFormCrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(panelFormCrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(panelFormCrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb1)
                    .addComponent(Clave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
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
                        .addComponent(panelFormCrearUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(200, 200, 200))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addComponent(panelFormCrearUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(200, 200, 200))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            
            ValidadorFormulario vf = new ValidadorFormulario(this.panelFormCrearUsuario);
            if(vf.validarFormulario()){
        
            Usuarios cr = new Usuarios();
            cr.setUsername(Usuario.getText());
            cr.setCorreoElectronico(Correo.getText());
            String claveE= encriptarclave(Clave.getText());
            
           // String hashedPassword = hash.getResult();
            cr.setContrasena(claveE);  
            cr.setActivo(true);
            ControladorUsuario ct = new ControladorUsuario();
            ct.crearUsuario(cr);
//            ct.cerrarSesion();
            Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER, "Usuario creado con éxito");
            Application.showForm(new FormDashboard());
    }//GEN-LAST:event_jButton1ActionPerformed
    }
    private String encriptarclave(String clave) {
      String hash = DigestUtils.md5Hex(clave);
        return hash;  
    }
 
    
     
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
                int CambioHeigth = panelFormCrearUsuario.getPreferredSize().height;
                int x = (width - CambioWidth) / 2;
                int y = (heigth - CambioHeigth) / 2;
                panelFormCrearUsuario.setBounds(x, y, CambioWidth, CambioHeigth);

            }
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField Clave;
    private com.panin.application.utilities.TextoHint Correo;
    private com.panin.application.utilities.TextoHint Usuario;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lb;
    private javax.swing.JLabel lb1;
    private javax.swing.JPanel panelFormCrearUsuario;
    // End of variables declaration//GEN-END:variables
}
