package com.panin.application.form;

import com.formdev.flatlaf.FlatClientProperties;
import net.miginfocom.swing.MigLayout;
import com.panin.application.Application;
import com.panin.application.frameConfiguracion;
import com.panin.controladores.ControladorUsuario;
import com.panin.entidades.Usuarios;
import java.util.List;
import org.apache.commons.codec.digest.DigestUtils;
import raven.toast.Notifications;

/**
 *
 * @author Raven
 */
public class LoginForm extends javax.swing.JPanel {

    public LoginForm() {
        initComponents();
        init();
    }

    private void init() {
        setLayout(new MigLayout("al center center"));

        lbTitle.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h1.font");

        txtPass.putClientProperty(FlatClientProperties.STYLE, ""
                + "showRevealButton:true;"
                + "showCapsLock:true");
        cmdLogin.putClientProperty(FlatClientProperties.STYLE, ""
                + "borderWidth:0;"
                + "focusWidth:0");
        txtUser.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "User Name");
        txtPass.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Password");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelLogin1 = new com.panin.application.form.PanelLogin();
        lbTitle = new javax.swing.JLabel();
        lbUser = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        lbPass = new javax.swing.JLabel();
        txtPass = new javax.swing.JPasswordField();
        cmdLogin = new javax.swing.JButton();

        lbTitle.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitle.setText("Iniciar sesión");
        panelLogin1.add(lbTitle);

        lbUser.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbUser.setText("Usuario");
        panelLogin1.add(lbUser);
        panelLogin1.add(txtUser);

        lbPass.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbPass.setText("Contraseña");
        panelLogin1.add(lbPass);
        panelLogin1.add(txtPass);

        cmdLogin.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cmdLogin.setText("Identificarse");
        cmdLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdLoginActionPerformed(evt);
            }
        });
        panelLogin1.add(cmdLogin);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(220, Short.MAX_VALUE)
                .addComponent(panelLogin1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(198, 198, 198))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(panelLogin1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmdLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdLoginActionPerformed
            evaluarDatosUsuario();

    }//GEN-LAST:event_cmdLoginActionPerformed

    private String encriptarclave(String clave) {
        String hash = DigestUtils.md5Hex(clave);
        return hash;
    }
    
    
    private void evaluarDatosUsuario(){
         
        String user = txtUser.getText();

        String claveE = encriptarclave(String.valueOf(txtPass.getPassword()));

        // String hashedPassword = hash.getResult();
        ControladorUsuario cr = new ControladorUsuario();
        Usuarios usuario;

        usuario = cr.obtenerUsuario(user);
        boolean usuarioEncontrado = false;
        if (usuario != null) {
            if (usuario.getContrasena().equals(claveE)) {
                Application.setUser(usuario);
                usuarioEncontrado = true;
            }
        }

        if (usuarioEncontrado) {
            // El usuario y la contraseña son válidos, iniciar sesión
            Application.login();

        } else {
            // Mostrar un mensaje de error indicando que las credenciales son incorrectas
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "Usuario o Clave equivocada");
        }
        txtUser.setText("");
        txtPass.setText("");
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdLogin;
    private javax.swing.JLabel lbPass;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lbUser;
    private com.panin.application.form.PanelLogin panelLogin1;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
