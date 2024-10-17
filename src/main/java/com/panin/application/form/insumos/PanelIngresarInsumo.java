/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.panin.application.form.insumos;

import com.formdev.flatlaf.FlatClientProperties;
import net.miginfocom.swing.MigLayout;
import com.panin.application.Application;
import com.panin.application.form.other.FormIngresarInsumo;
import com.panin.application.form.other.Model_Card;
import com.panin.application.utilities.VerificarIngresoNumero;
import com.panin.controladores.ControladorComprasInsumos;
import com.panin.controladores.ControladorConversion;
import com.panin.controladores.ControladorInsumos;
import com.panin.controladores.ControladorMarcaInsumo;
import com.panin.controladores.ControladorUnidadMedida;
import com.panin.entidades.ComprasInsumo;
import com.panin.entidades.Insumo;
import com.panin.entidades.MarcaInsumo;
import com.panin.entidades.UnidadMedida;
import com.toedter.calendar.JTextFieldDateEditor;
import com.toedter.calendar.MinMaxDateEvaluator;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import org.hibernate.Hibernate;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Time;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;
import raven.toast.Notifications;

/**
 *
 * @author USUARIO
 */
public class PanelIngresarInsumo extends javax.swing.JPanel {

    /**
     * Creates new form PanelIngresarProducto
     */
    public PanelIngresarInsumo() {
//        jIcon.setIcon(data.getIcon());
//        System.out.println(data.getTitle());
//        initComponents();
//        jTitle.setText(data.getTitle());
//        jIcon.setIcon(data.getIcon());
        setLayout(new MigLayout("al center center"));
    }
    
    public PanelIngresarInsumo(Model_Card data, Insumo insumo) {
        
        NumberFormat format = NumberFormat.getNumberInstance();
        this.insumoC = insumo;
//        MaskFormatter maskFormatter = new MaskFormatter("####.###,##");
//        jIcon.setIcon(data.getIcon());
//        Hibernate.initialize(insumo.getIdTipoMedida().getUnidadMedidaCollection());
        ControladorInsumos ci = new ControladorInsumos();
        System.out.println(insumo.getIdTipoMedida().getUnidadMedidaCollection());

//         modeloComboBoxUnidadMedida = new ModeloComboBoxUnidadMedida((List<UnidadMedida>) insumo.getIdTipoMedida().getUnidadMedidaCollection());
        initComponents();
        jTitle.setText(data.getTitle());
        jIcon.setIcon(data.getIcon());

//        jUnidad.setModel(modeloComboBoxUnidadMedida);
        for (UnidadMedida item : insumo.getIdTipoMedida().getUnidadMedidaCollection()) {
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
        
        textFieldPrecio.setHint("Ingrese Precio...");
        textFieldPrecio.setHorizontalAlignment(SwingConstants.RIGHT);
        textFieldPrecio.putClientProperty(FlatClientProperties.STYLE, ""
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

//        int x = (getWidth() + 50 - panel.getWidth()) / 2;
//        int y = (getHeight() - panel.getHeight()) / 2;
//        
//        panel.setLocation(x, y);
//        setLayout(new MigLayout("al center center"));
//        setLayout(new MigLayout("fillx,wrap,insets 30 40 50 40, width 220", "[fill]", "[]20[][]100[][]130[]"));
        validarCalendario();
        VerificarIngresoNumero.verificar(textoCantidad);
        VerificarIngresoNumero.verificar(textFieldPrecio);

        actualizarUnidadMedida(insumo);
        panelRegistrosInsumos1.iniciar(insumo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDateChooser1 = new com.toedter.calendar.JDateChooser();
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
        textFieldPrecio = new com.panin.application.utilities.TextoHint();
        jLabel3 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxMarca = new javax.swing.JComboBox<>();
        panelRegistrosInsumos1 = new com.panin.application.form.insumos.panelRegistrosInsumos();

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

        textFieldPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldPrecioActionPerformed(evt);
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
                .addContainerGap(15, Short.MAX_VALUE)
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
                                        .addComponent(textFieldPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addContainerGap(21, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jIcon))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jTitle)))
                .addGap(40, 40, 40)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel3))
                    .addComponent(textFieldPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRegistrosInsumos1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(12, 12, 12)))
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(panelRegistrosInsumos1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAtrasActionPerformed
        Application.showForm(new FormIngresarInsumo());
    }//GEN-LAST:event_jBtnAtrasActionPerformed

    private void jBtnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnOkActionPerformed
        String precio = textFieldPrecio.getText();
        String cantidad = textoCantidad.getText();
        precio = precio.replace(",", ".");
        cantidad = cantidad.replace(",", ".");
        
        try {
            
            if (textFieldPrecio.getText() == null || precio.length() == 0 || textFieldPrecio.getText().equals(" ")) {
                Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_CENTER, "Por Favor Ingrese el Precio del Insumo...");
            } else if (textoCantidad.getText() == null || cantidad.length() == 0 || textoCantidad.getText().equals(" ")) {
                Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_CENTER, "Por Favor Ingrese la cantidad commprada...");
            } else if (jDateChooser2.getDate() == null) {
                Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_CENTER, "Por Favor Ingrese la fecha de compra...");
            } else {
                
                ControladorUnidadMedida cmd = new ControladorUnidadMedida();
                UnidadMedida um = (UnidadMedida) jUnidad.getSelectedItem();
                UnidadMedida umb;
                BigDecimal cantidadCalculada = new BigDecimal(cantidad);
                BigDecimal precioCalculado = new BigDecimal(precio);
                
                if (!um.isUnidadBase()) {
                    ControladorConversion cc = new ControladorConversion();
                    umb = cmd.obtenerUnidadBase(um);
                    
                    BigDecimal factorConversion = cc.obtenerFactorConversion(um, umb).getFactorConversion();
                    
                    cantidadCalculada = cantidadCalculada.multiply(factorConversion);
                    
                } else {
                    umb = um;
                }
                precioCalculado = precioCalculado.divide(cantidadCalculada, 6, RoundingMode.HALF_UP);
                ComprasInsumo compraInsumo = new ComprasInsumo();
                compraInsumo.setInsumo(insumoC);
                compraInsumo.setPrecio(precioCalculado);
                compraInsumo.setCantidad(cantidadCalculada);
                compraInsumo.setFecha(jDateChooser2.getDate());
                compraInsumo.setUnidadMedidaId(umb);
                compraInsumo.setHora(new Time(new Date().getTime()));
                compraInsumo.setMarcaInsumo((MarcaInsumo)jComboBoxMarca.getSelectedItem());
                
                ControladorComprasInsumos controladorComprasInsumos = new ControladorComprasInsumos();
                if (controladorComprasInsumos.save(compraInsumo)) {
                    Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.TOP_CENTER, "Compra Registrada con Exito!");
                    textFieldPrecio.setText("");
                    textFieldPrecio.setHint("Ingrese Precio...");
                    textoCantidad.setText("");
                    textoCantidad.setHint("Ingrese Cantidad...");
                    panelRegistrosInsumos1.agregarCompra(compraInsumo);
                } else {
                    Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "Error al crear compra");
                }
                
            }
        } catch (Exception e) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "Error interno del sistema");
            System.err.println(e);
        }

    }//GEN-LAST:event_jBtnOkActionPerformed

    private void textFieldPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldPrecioActionPerformed

    private void textoCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoCantidadActionPerformed

    private void jUnidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jUnidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jUnidadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAtras;
    private javax.swing.JButton jBtnOk;
    private javax.swing.JComboBox<MarcaInsumo
    > jComboBoxMarca;
    private com.toedter.calendar.JDateChooser jDateChooser1;
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
    private com.panin.application.form.insumos.panelRegistrosInsumos panelRegistrosInsumos1;
    private com.panin.application.utilities.TextoHint textFieldPrecio;
    private com.panin.application.utilities.TextoHint textoCantidad;
    // End of variables declaration//GEN-END:variables
    private Insumo insumoC;
    
    public Insumo getInsumoC() {
        return insumoC;
    }
    
    public void setInsumoC(Insumo insumoC) {
        this.insumoC = insumoC;
    }
    
    
    private void actualizarUnidadMedida(Insumo insumo) {
        jUnidad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UnidadMedida medidaSeleccionada = (UnidadMedida) jUnidad.getSelectedItem();
                lblUnidad.setText(medidaSeleccionada.getNombre());
                
            }
        });
    }
    
    private void validarCalendario() {

        jDateChooser2.setDate(new Date());
        jDateChooser2.setMaxSelectableDate(new Date());
        
    }
    
}

class RangeEvaluator extends MinMaxDateEvaluator {
    
    @Override
    public boolean isInvalid(Date date) {
        return !super.isInvalid(date);
    }
}
