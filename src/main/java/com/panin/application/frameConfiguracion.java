/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.panin.application;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import raven.toast.Notifications;

/**
 *
 * @author ricke
 */
public class frameConfiguracion extends javax.swing.JFrame {

    /**
     * Creates new form frameConfiguracion
     */
    public frameConfiguracion() {
        initComponents();
        init();
    }

    public void init(){
        
        
        textFieldContrasenaConexion.setHint("Contraseña");
        textFieldURLConexion.setHint("URL");
        textFieldUsuarioConexion.setHint("Usuario");

        
        this.pack();
        this.setLocationRelativeTo(null);
        this.setTitle("Configuracion");
        this.setVisible(true);
        this.setResizable(false);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelConfiguracion = new javax.swing.JPanel();
        iconoConfig = new javax.swing.JLabel();
        textFieldURLConexion = new com.panin.application.utilities.TextoHint();
        textFieldUsuarioConexion = new com.panin.application.utilities.TextoHint();
        textFieldContrasenaConexion = new com.panin.application.utilities.TextoHint();
        jLabel1 = new javax.swing.JLabel();
        botonIngresarDatosConexion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        iconoConfig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/utilidad/config_logo.png"))); // NOI18N
        iconoConfig.setText("jLabel1");

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel1.setText("Ingrese los datos de conexión");

        botonIngresarDatosConexion.setText("Aceptar");
        botonIngresarDatosConexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIngresarDatosConexionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelConfiguracionLayout = new javax.swing.GroupLayout(panelConfiguracion);
        panelConfiguracion.setLayout(panelConfiguracionLayout);
        panelConfiguracionLayout.setHorizontalGroup(
            panelConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelConfiguracionLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelConfiguracionLayout.createSequentialGroup()
                        .addComponent(iconoConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(232, 232, 232))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelConfiguracionLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(115, 115, 115))))
            .addGroup(panelConfiguracionLayout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(textFieldURLConexion, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(panelConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonIngresarDatosConexion, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelConfiguracionLayout.createSequentialGroup()
                        .addComponent(textFieldUsuarioConexion, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(textFieldContrasenaConexion, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        panelConfiguracionLayout.setVerticalGroup(
            panelConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelConfiguracionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iconoConfig)
                .addGap(36, 36, 36)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(panelConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldURLConexion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldUsuarioConexion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldContrasenaConexion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(botonIngresarDatosConexion, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addComponent(panelConfiguracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addComponent(panelConfiguracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonIngresarDatosConexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIngresarDatosConexionActionPerformed
        // TODO add your handling code here:
        
        if(textFieldUsuarioConexion.getText() != "" && 
                textFieldURLConexion.getText() != "" &&
                 textFieldContrasenaConexion.getText() != ""){
        
        try {

            Configuration conf = new Configuration().configure("hibernate.cfg.xml");
            // <!-- Database connection settings -->
            conf.setProperty("hibernate.connection.url", textFieldURLConexion.getText());
            conf.setProperty("hibernate.connection.username", textFieldUsuarioConexion.getText());
            conf.setProperty("hibernate.connection.password", textFieldContrasenaConexion.getText());
            SessionFactory sF = conf.buildSessionFactory();
//            Session session = sF.openSession();

            Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER, "Conexión creada con exito");
            this.dispose();

    } catch (Throwable ex) {
      // Log exception!
      Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "Error al realizar la conexión");

      throw new ExceptionInInitializerError(ex);
    }
        }else{
          Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "Debe ingresar todos los datos de conexión");
        }
    }//GEN-LAST:event_botonIngresarDatosConexionActionPerformed

    /**
     * @param args the command line arguments
     */
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonIngresarDatosConexion;
    private javax.swing.JLabel iconoConfig;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel panelConfiguracion;
    private com.panin.application.utilities.TextoHint textFieldContrasenaConexion;
    private com.panin.application.utilities.TextoHint textFieldURLConexion;
    private com.panin.application.utilities.TextoHint textFieldUsuarioConexion;
    // End of variables declaration//GEN-END:variables
}