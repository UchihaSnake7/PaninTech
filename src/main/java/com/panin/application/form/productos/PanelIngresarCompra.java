/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.panin.application.form.productos;

import com.formdev.flatlaf.FlatClientProperties;
import com.panin.application.Application;
import com.panin.application.form.other.Model_Card;
import com.panin.application.utilities.VerificarIngresoNumero;
import com.panin.controladores.ControladorComprasProductos;
import com.panin.controladores.ControladorConversion;
import com.panin.controladores.ControladorMarcaInsumo;
import com.panin.controladores.ControladorUnidadMedida;
import com.panin.entidades.ComprasProducto;
import com.panin.entidades.Conversion;
import com.panin.entidades.Insumo;
import com.panin.entidades.MarcaInsumo;
import com.panin.entidades.Producto;
import com.panin.entidades.UnidadMedida;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.SwingConstants;
import raven.toast.Notifications;

/**
 *
 * @author USUARIO
 */
public class PanelIngresarCompra extends javax.swing.JPanel {

    private Producto producto;

    /**
     * Creates new form PanelIngresarCompra
     */
    public PanelIngresarCompra(Model_Card data, Producto producto) {
        this.producto = producto;
        initComponents();
        init();
        jTitle.setText(data.getTitle());
        jIcon.setIcon(data.getIcon());
        VerificarIngresoNumero.verificar(textoHint1);
        VerificarIngresoNumero.verificar(textoCantidad);
        jDateChooser2.setDate(new Date());
        jDateChooser2.setMaxSelectableDate(new Date());
        panelRegistrosCompraProducto2.iniciar(producto);

    }

    private void init() {
        for (UnidadMedida item : producto.getIdTipoMedida().getUnidadMedidaCollection()) {
            jUnidad.addItem(item);
        }

        UnidadMedida medidaSeleccionada = (UnidadMedida) jUnidad.getSelectedItem();
        if (medidaSeleccionada != null) {
            lblUnidad.setText(medidaSeleccionada.getNombre());
        }

        ControladorMarcaInsumo controladorMarcaInsumo = new ControladorMarcaInsumo();
        List<MarcaInsumo> marcas = controladorMarcaInsumo.obtenerMarcasInsumos();

        for (MarcaInsumo marca : marcas) {
            jComboBoxMarca.addItem(marca);
            if (marca.getNombre().equals("NA")) {
                jComboBoxMarca.setSelectedItem(marca);
            }
        }
        jTitle.putClientProperty(FlatClientProperties.STYLE, ""
                + "foreground:$Menu.foreground;");
        jLabel2.putClientProperty(FlatClientProperties.STYLE, ""
                + "foreground:$Menu.foreground;");
        jLabel1.putClientProperty(FlatClientProperties.STYLE, ""
                + "foreground:$Menu.foreground;");
        lblUnidad.putClientProperty(FlatClientProperties.STYLE, ""
                + "foreground:$Menu.foreground;");

        textoCantidad.setHint("Ingrese Cantidad...");

        textoCantidad.setHorizontalAlignment(SwingConstants.RIGHT);
        textoCantidad.putClientProperty(FlatClientProperties.STYLE, ""
                + "foreground:$Menu.foreground;");

        textoHint1.setHint("Ingrese Precio...");
        textoHint1.setHorizontalAlignment(SwingConstants.RIGHT);
        textoHint1.putClientProperty(FlatClientProperties.STYLE, ""
                + "foreground:$Menu.foreground;");

        jLabel2.putClientProperty(FlatClientProperties.STYLE, ""
                + "foreground:$Menu.foreground;");
        jLabel3.putClientProperty(FlatClientProperties.STYLE, ""
                + "foreground:$Menu.foreground;");

        jUnidad.putClientProperty(FlatClientProperties.STYLE, ""
                + "foreground:$Menu.foreground;");
        jBtnAtras.putClientProperty(FlatClientProperties.STYLE, ""
                + "foreground:$Menu.foreground;");
        jBtnOk.putClientProperty(FlatClientProperties.STYLE, ""
                + "foreground:$Menu.foreground;");
        jDateChooser2.putClientProperty(FlatClientProperties.STYLE, ""
                + "foreground:$Menu.foreground;");
        panel.putClientProperty(FlatClientProperties.STYLE, ""
                + "background:$Login.background;"
                + "arc:50;");
        actualizarUnidadMedida();
//        validarCalendario();
    }

    private void actualizarUnidadMedida() {
        jUnidad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UnidadMedida medidaSeleccionada = (UnidadMedida) jUnidad.getSelectedItem();
                lblUnidad.setText(medidaSeleccionada.getNombre());

            }
        });
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
        jBtnOk = new javax.swing.JButton();
        jIcon = new javax.swing.JLabel();
        jTitle = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jUnidad = new javax.swing.JComboBox<>();
        jBtnAtras = new javax.swing.JButton();
        lblUnidad = new javax.swing.JLabel();
        textoCantidad = new com.panin.application.utilities.TextoHint();
        textoHint1 = new com.panin.application.utilities.TextoHint();
        jLabel3 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxMarca = new javax.swing.JComboBox<>();
        panelRegistrosCompraProducto2 = new com.panin.application.form.productos.panelRegistrosCompraProducto();

        setPreferredSize(new java.awt.Dimension(613, 700));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Cantidad:");

        jBtnOk.setText("Ingresar");
        jBtnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnOkActionPerformed(evt);
            }
        });

        jIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/insumos/default.png"))); // NOI18N

        jTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jTitle.setText("jLabel1");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Unidad de Medida:");

        jUnidad.setPreferredSize(new java.awt.Dimension(64, 24));
        jUnidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jUnidadActionPerformed(evt);
            }
        });

        jBtnAtras.setText("Atrás");
        jBtnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAtrasActionPerformed(evt);
            }
        });

        lblUnidad.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        lblUnidad.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        textoCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoCantidadActionPerformed(evt);
            }
        });

        textoHint1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoHint1ActionPerformed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Precio:");

        jDateChooser2.setMaxSelectableDate(new java.util.Date(4102462862000L));
        jDateChooser2.setMinSelectableDate(new java.util.Date(1704085262000L));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Fecha de compra:");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Marca:");

        jComboBoxMarca.setPreferredSize(new java.awt.Dimension(64, 24));

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jIcon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTitle)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(jBtnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(100, 100, 100)
                                        .addComponent(jBtnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(textoHint1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(43, 43, 43)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)
                                        .addComponent(jComboBoxMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addGap(288, 288, 288)
                                        .addComponent(lblUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(textoCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(jUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jIcon))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jTitle)))
                .addGap(40, 40, 40)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel3))
                    .addComponent(textoHint1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jComboBoxMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(textoCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(lblUnidad)
                .addGap(20, 20, 20)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelRegistrosCompraProducto2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(panelRegistrosCompraProducto2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnOkActionPerformed

        String precio = textoHint1.getText();
        String cantidad = textoCantidad.getText();
        precio = precio.replace(",", ".");
        cantidad = cantidad.replace(",", ".");
        BigDecimal cantidadCalculada;
        BigDecimal precioCalculado;
        ComprasProducto cp = new ComprasProducto();

        UnidadMedida um = (UnidadMedida) jUnidad.getSelectedItem();
        UnidadMedida unidadMedida;

        cantidadCalculada = new BigDecimal(cantidad);
        precioCalculado = new BigDecimal(precio);

        if (um.isUnidadBase()) {
            unidadMedida = um;

        } else {
            ControladorConversion controladorConversion = new ControladorConversion();
            ControladorUnidadMedida controladorUnidadMedida = new ControladorUnidadMedida();
            UnidadMedida unidadMedidaBase = controladorUnidadMedida.obtenerUnidadBase(um);
            unidadMedida = unidadMedidaBase;
            Conversion conversion = controladorConversion.obtenerFactorConversion(um, unidadMedidaBase);
            cantidadCalculada = cantidadCalculada.multiply(conversion.getFactorConversion());
        }

        System.out.println(precioCalculado + " " + cantidadCalculada);
        precioCalculado = precioCalculado.divide(cantidadCalculada, 6, RoundingMode.HALF_UP);
        System.out.println("PrecioCalculado " + precioCalculado);
        cp.setCantidad(cantidadCalculada);
        cp.setPrecio(precioCalculado);
        cp.setMarcaInsumo((MarcaInsumo) jComboBoxMarca.getSelectedItem());
        cp.setUnidadMedida(unidadMedida);
        cp.setProducto(producto);
        cp.setFecha(jDateChooser2.getDate());
        cp.setHora(new Time(new Date().getTime()));

        ControladorComprasProductos ccp = new ControladorComprasProductos();

        ccp.save(cp);

        Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER, "Compra registrada con exito");
        panelRegistrosCompraProducto2.agregarCompra(cp);
    }//GEN-LAST:event_jBtnOkActionPerformed

    private void jBtnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAtrasActionPerformed
        Application.showForm(new FormCompraProductos());
    }//GEN-LAST:event_jBtnAtrasActionPerformed

    private void textoCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoCantidadActionPerformed

    private void textoHint1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoHint1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoHint1ActionPerformed

    private void jUnidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jUnidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jUnidadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAtras;
    private javax.swing.JButton jBtnOk;
    private javax.swing.JComboBox<MarcaInsumo
    > jComboBoxMarca;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jIcon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jTitle;
    private javax.swing.JComboBox<UnidadMedida> jUnidad;
    private javax.swing.JLabel lblUnidad;
    private javax.swing.JPanel panel;
    private com.panin.application.form.productos.panelRegistrosCompraProducto panelRegistrosCompraProducto2;
    private com.panin.application.utilities.TextoHint textoCantidad;
    private com.panin.application.utilities.TextoHint textoHint1;
    // End of variables declaration//GEN-END:variables
}
