package com.panin.application.form.other;

import com.formdev.flatlaf.FlatClientProperties;
import com.panin.application.Application;
import com.panin.application.utilities.ValidadorFormulario;
import com.panin.application.utilities.VerificarIngresoNumero;
import com.panin.controladores.ControladorConversionDivisa;
import com.panin.controladores.ControladorDivisa;
import java.awt.Component;
import java.awt.Container;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.Dimension;
import net.miginfocom.swing.MigLayout;
import java.awt.LayoutManager;
import com.panin.controladores.ControladorTasa;
import com.panin.entidades.Tasa;
import com.panin.controladores.ControladorProductos;
import com.panin.entidades.Conversion;
import com.panin.entidades.ConversionDivisa;
import com.panin.entidades.Divisa;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import raven.toast.Notifications;

/**
 *
 * @author Raven
 */
public class FormCambio extends javax.swing.JPanel {

    public FormCambio() {
        initComponents();
        init();
        cambio.setEditable(false);
        VerificarIngresoNumero.verificar(actulizacionC);
//        lb.putClientProperty(FlatClientProperties.STYLE, ""
//                + "font:$h1.font");
//        jLabel1.putClientProperty(FlatClientProperties.STYLE, ""
//                + "font:$h1.font");
//        jLabel2.putClientProperty(FlatClientProperties.STYLE, ""
//                + "font:$h1.font");
    }

    private void init() {
        ControladorDivisa controladorDivisa = new ControladorDivisa();
        ControladorConversionDivisa controladorConversionDivisa = new ControladorConversionDivisa();

        List<Divisa> divisas = controladorDivisa.obtenerTodos();

        for (Divisa divisa : divisas) {
            jComboBoxDivisas.addItem(divisa);
        }
        jComboBoxDivisas.setSelectedIndex(1);
        jComboBoxDivisas.removeItem(Application.configuracion.getDivisa());

        divisaPrincipal1.setText(Application.configuracion.getDivisa().toString());
        divisaPrincipal2.setText(Application.configuracion.getDivisa().toString());
        setLayout(new CambioLayout());
        Cambio.putClientProperty(FlatClientProperties.STYLE, "" + "background:$Login.background;" + "arc:20");

        buscarTasa();
        actualizarTasa();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Cambio = new javax.swing.JPanel();
        lb = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cambio = new com.panin.application.utilities.TextoHint();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxDivisas = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        actulizacionC = new com.panin.application.utilities.TextoHint();
        divisaPrincipal1 = new javax.swing.JLabel();
        divisaPrincipal2 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        Cambio.setName("cambio"); // NOI18N

        lb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb.setText("Ingrese Nuevo:");

        jButton1.setText("Actualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Actual");

        jLabel3.setText("Fecha XX.XX.XXXX");

        jLabel4.setText("Ultima actualización:");

        actulizacionC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actulizacionCActionPerformed(evt);
            }
        });

        divisaPrincipal1.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        divisaPrincipal1.setText("jLabel5");

        divisaPrincipal2.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        divisaPrincipal2.setText("jLabel5");

        javax.swing.GroupLayout CambioLayout = new javax.swing.GroupLayout(Cambio);
        Cambio.setLayout(CambioLayout);
        CambioLayout.setHorizontalGroup(
            CambioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CambioLayout.createSequentialGroup()
                .addGap(0, 60, Short.MAX_VALUE)
                .addGroup(CambioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CambioLayout.createSequentialGroup()
                        .addGroup(CambioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CambioLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(lb)
                                .addGap(18, 18, 18)
                                .addGroup(CambioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(actulizacionC, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(divisaPrincipal2)))
                            .addGroup(CambioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGroup(CambioLayout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jLabel4)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel3)))
                        .addContainerGap(60, Short.MAX_VALUE))
                    .addGroup(CambioLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(CambioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(divisaPrincipal1)
                            .addComponent(cambio, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(CambioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(CambioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxDivisas, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        CambioLayout.setVerticalGroup(
            CambioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CambioLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jComboBoxDivisas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(CambioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cambio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(1, 1, 1)
                .addComponent(divisaPrincipal1)
                .addGap(17, 17, 17)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(CambioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(actulizacionC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(divisaPrincipal2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jButton1)
                .addGap(31, 31, 31)
                .addGroup(CambioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addGap(50, 50, 50))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Actualizar Divisas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cambio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(Cambio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Tasa r = new Tasa();

        ValidadorFormulario validarFormulario = new ValidadorFormulario(Cambio);
        validarFormulario.validarFormulario();

        float valor = Float.parseFloat(actulizacionC.getText().replace(",", "."));
        r.setTasa(valor);
        //   String fechaString = "2024-10-07 02:22:05.000000";
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");
        //LocalDateTime fechaLocalDateTime = LocalDateTime.parse(fechaString, formatter);
        //Date fecha = Date.from(fechaLocalDateTime.atZone(ZoneId.systemDefault()).toInstant());
        Date fecha = new Date();

        r.setFecha(fecha);
        ControladorTasa cr = new ControladorTasa();
        cr.crearTasa(r);
//        cr.cerrarSesion();

        Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER, "Tasa actulizada con exito");
//        Application.showForm(new FormDashboard());

        ConversionDivisa conversionDivisa = new ConversionDivisa();
        conversionDivisa.setTasa(r);
        conversionDivisa.setDivisa((Divisa) jComboBoxDivisas.getSelectedItem());
        ControladorConversionDivisa controladorConversionDivisa = new ControladorConversionDivisa();
        controladorConversionDivisa.crearConversionDivisa(conversionDivisa);
        buscarTasa();

        actulizacionC.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void actulizacionCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actulizacionCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_actulizacionCActionPerformed

    private void buscarTasa() {
        ControladorConversionDivisa controladorConversionDivisa = new ControladorConversionDivisa();
        Tasa tasa = controladorConversionDivisa.obtenerUlimoPorDivisa((Divisa) jComboBoxDivisas.getSelectedItem());
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        DecimalFormat df = new DecimalFormat("#,##0.00");
//        cr.cerrarSesion();
        if (tasa != null) {

            String valor = df.format(tasa.getTasa());
            cambio.setText(valor);
            String strDate = formatter.format(tasa.getFecha());
            System.out.println("Fecha: " + strDate);
            jLabel3.setText(strDate);
        } else {
            cambio.setText("NA");
            jLabel3.setText("NA");
        }

    }

    private void actualizarTasa() {
        jComboBoxDivisas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarTasa();
            }
        });

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
                int CambioHeigth = Cambio.getPreferredSize().height;
                int x = (width - CambioWidth) / 2;
                int y = (heigth - CambioHeigth) / 2;
                Cambio.setBounds(x, y, CambioWidth, CambioHeigth);

            }
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Cambio;
    private com.panin.application.utilities.TextoHint actulizacionC;
    private com.panin.application.utilities.TextoHint cambio;
    private javax.swing.JLabel divisaPrincipal1;
    private javax.swing.JLabel divisaPrincipal2;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<Divisa> jComboBoxDivisas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lb;
    // End of variables declaration//GEN-END:variables
}
