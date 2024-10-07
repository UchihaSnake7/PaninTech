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
import com.panin.controladores.ControladorComprasInsumos;
import com.panin.controladores.ControladorConversion;
import com.panin.controladores.ControladorInsumos;
import com.panin.controladores.ControladorUnidadMedida;
import com.panin.entidades.ComprasInsumo;
import com.panin.entidades.Insumo;
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

//        int x = (getWidth() + 50 - panel.getWidth()) / 2;
//        int y = (getHeight() - panel.getHeight()) / 2;
//        
//        panel.setLocation(x, y);
//        setLayout(new MigLayout("al center center"));
        setLayout(new MigLayout("fillx,wrap,insets 30 40 50 40, width 220", "[fill]", "[]20[][]100[][]130[]"));
        
        validarCalendario();
        verificarIngresoNumero();
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
        textoHint1 = new com.panin.application.utilities.TextoHint();
        jLabel3 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
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

        textoHint1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoHint1ActionPerformed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Precio");

        jDateChooser2.setMaxSelectableDate(new java.util.Date(4102462862000L));
        jDateChooser2.setMinSelectableDate(new java.util.Date(1704085262000L));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Fecha de compra");

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
                            .addComponent(jBtnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addComponent(jIcon)
                        .addGap(25, 25, 25)))
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTitle)
                    .addComponent(lblUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jUnidad, javax.swing.GroupLayout.Alignment.LEADING, 0, 115, Short.MAX_VALUE)
                        .addComponent(textoCantidad, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textoHint1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jBtnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addComponent(jIcon)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addComponent(jTitle)
                        .addGap(29, 29, 29)))
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoHint1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(20, 20, 20)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textoCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUnidad)
                .addGap(20, 20, 20)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(20, 20, 20)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelRegistrosInsumos1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(100, 100, 100))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(panelRegistrosInsumos1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAtrasActionPerformed
        Application.showForm(new FormIngresarInsumo());
    }//GEN-LAST:event_jBtnAtrasActionPerformed

    private void jBtnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnOkActionPerformed
        String precio = textoHint1.getText();
        String cantidad = textoCantidad.getText();
        precio = precio.replace(",", ".");
        cantidad = cantidad.replace(",", ".");
        
        try {
            
            if (textoHint1.getText() == null || precio.length() == 0 || textoHint1.getText().equals(" ")) {
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
                System.out.println("Cantidad " + cantidad);
                System.out.println("Cantidad Calculada: " + cantidadCalculada);
                
                if (!um.isUnidadBase()) {
                    ControladorConversion cc = new ControladorConversion();
                    umb = cmd.obtenerUnidadBase(um);
                    System.out.println("Unidad base: " + umb.getNombre());
                    BigDecimal factorConversion = cc.obtenerUnidadBase(um, umb).getFactorConversion();
                    System.out.println(factorConversion);
                    
                    cantidadCalculada = cantidadCalculada.multiply(factorConversion);
                    System.out.println(cantidadCalculada);
                    
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
                System.out.println(compraInsumo);
                
                ControladorComprasInsumos controladorComprasInsumos = new ControladorComprasInsumos();
                if (controladorComprasInsumos.save(compraInsumo)) {
                    Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.TOP_CENTER, "Compra Registrada con Exito!");
                    textoHint1.setText("");
                    textoHint1.setHint("Ingrese Precio...");
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

    private void textoHint1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoHint1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoHint1ActionPerformed

    private void textoCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoCantidadActionPerformed

    private void jUnidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jUnidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jUnidadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAtras;
    private javax.swing.JButton jBtnOk;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jIcon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jTitle;
    private javax.swing.JComboBox<UnidadMedida> jUnidad;
    private javax.swing.JLabel lblUnidad;
    private javax.swing.JPanel panel;
    private com.panin.application.form.insumos.panelRegistrosInsumos panelRegistrosInsumos1;
    private com.panin.application.utilities.TextoHint textoCantidad;
    private com.panin.application.utilities.TextoHint textoHint1;
    // End of variables declaration//GEN-END:variables
    private Insumo insumoC;
    
    public Insumo getInsumoC() {
        return insumoC;
    }
    
    public void setInsumoC(Insumo insumoC) {
        this.insumoC = insumoC;
    }
    
    private void verificarIngresoNumero() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//textoCantidad.addKeyListener(new KeyAdapter() {
        textoCantidad.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent ke) {
                char c = ke.getKeyChar();
                String text = textoCantidad.getText();

                // Permitir números, coma y signo negativo al inicio
                if (!(Character.isDigit(c) || c == ',')) {
                    ke.consume();
                    return;
                }
                if (text.length() >= 12) {
                    ke.consume();
                    return;
                }

                // Permitir solo una coma
                if (c == ',' && text.contains(",")) {
                    ke.consume();
                }

                // Limitar a cuatro decimales
                int index = text.indexOf(',');
                if (index >= 0 && text.length() - index - 1 > 3) {
                    ke.consume();
                }
            }
        });
        
        textoHint1.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent ke) {
                char c = ke.getKeyChar();
                String text = textoHint1.getText();

                // Permitir números, coma y signo negativo al inicio
                if (!(Character.isDigit(c) || c == ',')) {
                    ke.consume();
                    return;
                }
                if (text.length() >= 12) {
                    ke.consume();
                    return;
                }

                // Permitir solo una coma
                if (c == ',' && text.contains(",")) {
                    ke.consume();
                }

                // Limitar a cuatro decimales
                int index = text.indexOf(',');
                if (index >= 0 && text.length() - index - 1 > 3) {
                    ke.consume();
                }
            }
        });
        
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
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//        Calendar min = Calendar.getInstance();
//        min.add(Calendar.DAY_OF_MONTH, 30);
//        Calendar max = Calendar.getInstance();
//        max.add(Calendar.DAY_OF_MONTH, 10);
//        RangeEvaluator re = new RangeEvaluator();
//        re.setMinSelectableDate(min.getTime());
//        re.setMaxSelectableDate(max.getTime());
//        jDateChooser2.getJCalendar().setMinSelectableDate(min.getTime());
//        jDateChooser2.getJCalendar().setMaxSelectableDate(max.getTime());
//        ((JTextFieldDateEditor) jDateChooser2.getDateEditor()).setEditable(false);

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
