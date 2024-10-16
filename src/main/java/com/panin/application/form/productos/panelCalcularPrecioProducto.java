/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.panin.application.form.productos;

import com.formdev.flatlaf.FlatClientProperties;
import com.panin.application.Application;
import com.panin.application.utilities.ValidadorFormulario;
import com.panin.application.utilities.VerificarIngresoNumero;
import com.panin.controladores.ControladorComprasInsumos;
import com.panin.controladores.ControladorConfiguracion;
import com.panin.controladores.ControladorProductos;
import com.panin.controladores.ControladorReceta;
import com.panin.dto.formAgregarInsumoProductoDTO;
import com.panin.entidades.ComprasInsumo;
import com.panin.entidades.Configuracion;
import com.panin.entidades.InsumoRecetas;
import com.panin.entidades.Producto;
import com.panin.entidades.Recetas;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ricke
 */
public class panelCalcularPrecioProducto extends javax.swing.JPanel {

    /**
     * Creates new form panelCalcularPrecioProducto
     */
    
    private DefaultTableModel modelTable;
    private  List<formAgregarInsumoProductoDTO> listaInsumosReceta;
     String[] columnas = new String[]{
                      "Ingrediente", "Medida", "Cantidad"
                      };

    public panelCalcularPrecioProducto() {
        initComponents();
        
              
        modelTable = new DefaultTableModel(columnas, 0);
        tablaIngredientes.setModel(modelTable);
        listaInsumosReceta = new ArrayList<formAgregarInsumoProductoDTO>() ;
        
        init();
    }

    
    
    
    public void init(){
        
         botonCalcular.putClientProperty(FlatClientProperties.STYLE, ""
                + "foreground:$Menu.foreground;");
         
         panelDatosProducto.putClientProperty(FlatClientProperties.STYLE, ""
                + "background:$Login.background;"
                + "arc:50;");
         
          tablaIngredientes.getTableHeader().putClientProperty(FlatClientProperties.STYLE, ""
                + "height:30;"
                + "hoverBackground:null;"
                + "pressedBackground:null;"
                //                + "dropLineShortColor:$Menu.background;"
                + "font:bold;"
                + "background:$Menu.background;"
            );

            tablaIngredientes.putClientProperty(FlatClientProperties.STYLE, ""
                + "rowHeight:30;"
                + "showHorizontalLines:true;"
                + "showVerticalLines:true;"
                + "intercellSpacing:0,1;"
                //                + "dropLineShortColor:$Menu.background;"
                + "cellFocusColor:$TableHeader.hoverBackground;"
                + "selectionBackground:$TableHeader.hoverBackground;"
                + "selectionForeground:$Table.foreground;"
                + "background:$Login.background;"
            );
              
            ControladorProductos cp = new ControladorProductos();
            List<Producto> listaProductos =  cp.obtenerProductosElaborados();
            
            for(Producto p : listaProductos){
                
//                System.out.print("\nProducto: " + p);
                combobocProductos.addItem(p);
                
            }
            
           VerificarIngresoNumero.verificar(textFieldCantidad);
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaIngredientes = new javax.swing.JTable();
        panelDatosProducto = new javax.swing.JPanel();
        labelTitulo = new javax.swing.JLabel();
        combobocProductos = new javax.swing.JComboBox<>();
        labelProducto = new javax.swing.JLabel();
        textFieldCantidad = new com.panin.application.utilities.TextoHint();
        labelPrecio = new javax.swing.JLabel();
        labelPrecioTotal = new javax.swing.JLabel();
        botonCalcular = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        porcentajeGanancia = new javax.swing.JLabel();
        precioVenta = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        tablaIngredientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ingrediente", "Medida", "Cantidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaIngredientes);

        labelTitulo.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        labelTitulo.setText("Ingrese los datos del producto");

        labelProducto.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        labelProducto.setText("Producto:");

        textFieldCantidad.setName("Cantidad"); // NOI18N

        labelPrecio.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        labelPrecio.setText("Precio Neto");

        labelPrecioTotal.setText("precio");

        botonCalcular.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        botonCalcular.setText("Calcular");
        botonCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCalcularActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Cantidad:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Ganancia (%)");

        porcentajeGanancia.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        porcentajeGanancia.setText("%");

        precioVenta.setText("venta");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Venta");

        javax.swing.GroupLayout panelDatosProductoLayout = new javax.swing.GroupLayout(panelDatosProducto);
        panelDatosProducto.setLayout(panelDatosProductoLayout);
        panelDatosProductoLayout.setHorizontalGroup(
            panelDatosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosProductoLayout.createSequentialGroup()
                .addGroup(panelDatosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDatosProductoLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(panelDatosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(combobocProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelDatosProductoLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(labelProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(panelDatosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelDatosProductoLayout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelDatosProductoLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(textFieldCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(botonCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(24, 24, 24)
                        .addGroup(panelDatosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelPrecioTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelDatosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelDatosProductoLayout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelDatosProductoLayout.createSequentialGroup()
                                .addComponent(porcentajeGanancia, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(precioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelDatosProductoLayout.createSequentialGroup()
                        .addGap(236, 236, 236)
                        .addComponent(labelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelDatosProductoLayout.setVerticalGroup(
            panelDatosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosProductoLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(labelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(panelDatosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDatosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combobocProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonCalcular, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelPrecioTotal)
                    .addComponent(porcentajeGanancia)
                    .addComponent(precioVenta))
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelDatosProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(panelDatosProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botonCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCalcularActionPerformed
        // TODO add your handling code here:
        
        ValidadorFormulario vf = new ValidadorFormulario(this.panelDatosProducto);
        if(vf.validarFormulario()){
        
            Producto producto = (Producto) combobocProductos.getSelectedItem();
            double cantidad = Double.valueOf(textFieldCantidad.getText());

            ControladorProductos cp = new ControladorProductos();
            BigDecimal precio = cp.calcularPrecioProduccion(producto, cantidad, modelTable);

            BigDecimal valorGanancia = new BigDecimal(Application.configuracion.getPorcentajeGanancia());
            BigDecimal gananciaProducto = valorGanancia.multiply(precio);
            BigDecimal venta = precio.add(gananciaProducto);

            labelPrecioTotal.setText(String.valueOf(precio.doubleValue()));
            porcentajeGanancia.setText(String.valueOf(valorGanancia.doubleValue()));
            precioVenta.setText(String.valueOf(venta.doubleValue()));
       }   
    }//GEN-LAST:event_botonCalcularActionPerformed
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCalcular;
    private javax.swing.JComboBox<Producto> combobocProductos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelPrecio;
    private javax.swing.JLabel labelPrecioTotal;
    private javax.swing.JLabel labelProducto;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JPanel panelDatosProducto;
    private javax.swing.JLabel porcentajeGanancia;
    private javax.swing.JLabel precioVenta;
    private javax.swing.JTable tablaIngredientes;
    private com.panin.application.utilities.TextoHint textFieldCantidad;
    // End of variables declaration//GEN-END:variables
}
