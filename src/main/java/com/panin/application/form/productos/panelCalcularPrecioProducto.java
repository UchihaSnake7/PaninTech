/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.panin.application.form.productos;

import com.formdev.flatlaf.FlatClientProperties;
import com.panin.controladores.ControladorComprasInsumos;
import com.panin.controladores.ControladorProductos;
import com.panin.controladores.ControladorReceta;
import com.panin.dto.formAgregarInsumoProductoDTO;
import com.panin.entidades.ComprasInsumo;
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

        labelPrecio.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        labelPrecio.setText("Precio:");

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

        javax.swing.GroupLayout panelDatosProductoLayout = new javax.swing.GroupLayout(panelDatosProducto);
        panelDatosProducto.setLayout(panelDatosProductoLayout);
        panelDatosProductoLayout.setHorizontalGroup(
            panelDatosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosProductoLayout.createSequentialGroup()
                .addGap(236, 236, 236)
                .addComponent(labelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDatosProductoLayout.createSequentialGroup()
                .addGroup(panelDatosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDatosProductoLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(combobocProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(textFieldCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(botonCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelDatosProductoLayout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(labelProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(50, 50, 50)
                .addGroup(panelDatosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelPrecioTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );
        panelDatosProductoLayout.setVerticalGroup(
            panelDatosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosProductoLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(labelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(panelDatosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelPrecio)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDatosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonCalcular, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelDatosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(combobocProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(textFieldCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelPrecioTotal)))
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
        
        /*
        Calcular precio
        */
        
        ControladorReceta cr = new ControladorReceta();
        Recetas r = new Recetas();
        
        Producto producto = (Producto) combobocProductos.getSelectedItem();
        r = cr.obtenerRecetaPorId(producto.getIdReceta());
        
        int cantidad = Integer.valueOf(textFieldCantidad.getText());
        int cantidadReceta = r.getCantidad();
        double cantidadCalculada = 0.0;
        double precioTotal = 0;
        double precio = 0.0;
        
        ControladorComprasInsumos cpi = new ControladorComprasInsumos();
         
        if(cantidadReceta > cantidad){
            cantidadCalculada = cantidadReceta / cantidad;
        }
        else if(cantidadReceta < cantidad){
            cantidadCalculada = cantidad / cantidadReceta ;

        }
        else if(cantidadReceta == cantidad){
            cantidadCalculada = 1;
        }
        
         r = cr.obtenerRecetaPorId(producto.getIdReceta());
//         List<InsumoRecetas> lir =  (List<InsumoRecetas>) r.getInsumoRecetasCollection();
//         cr.cerrarSesion();
         modelTable.setRowCount(0);

        for(InsumoRecetas ir : r.getInsumoRecetasCollection()) {
                    	
              formAgregarInsumoProductoDTO dto = new formAgregarInsumoProductoDTO();
                    	
               dto.setCantidad(ir.getCantidad().doubleValue() * cantidadCalculada);
               dto.setInsumo(ir.getIdInsumo());
               dto.setUnidadMedidad(ir.getUnidadMedida());
                    	
               listaInsumosReceta.add(dto);
               
               ComprasInsumo ci = cpi.obtenerComprasdeUnInsumoUnico(ir.getIdInsumo());
               
               
//               System.out.print("\nci.getPrecio() " + ci.getPrecio().toString());
//               System.out.print("\nir.getCantidad() " + ir.getCantidad().toString());
//               System.out.print("\n ci.getPrecio().multiply(ir.getCantidad()) " + ci.getPrecio().multiply(ir.getCantidad()).toString());
//
//               System.out.print("\ncantidadCalculada " + cantidadCalculada);
//               System.out.print("\n ci.getPrecio().multiply(ir.getCantidad()).multiply(BigDecimal.valueOf(cantidadCalculada)) " + ci.getPrecio().multiply(ir.getCantidad()).multiply(BigDecimal.valueOf(cantidadCalculada)));


               precioTotal = (ci.getPrecio().multiply(ir.getCantidad())).multiply(BigDecimal.valueOf(cantidadCalculada)).doubleValue();
               
//               System.out.print("\nprecioTotal " + precioTotal);

               
               modelTable.addRow(new Object[]{dto.getInsumo(), dto.getUnidadMedidad(), dto.getCantidad()});

                    	
            }
        cr.cerrarSesion();
        BigDecimal bd = new BigDecimal(precioTotal);
//        System.out.print("Precio Toal: " + bd.doubleValue());
        labelPrecioTotal.setText(String.valueOf(bd.doubleValue()));
         
    }//GEN-LAST:event_botonCalcularActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCalcular;
    private javax.swing.JComboBox<Producto> combobocProductos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelPrecio;
    private javax.swing.JLabel labelPrecioTotal;
    private javax.swing.JLabel labelProducto;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JPanel panelDatosProducto;
    private javax.swing.JTable tablaIngredientes;
    private com.panin.application.utilities.TextoHint textFieldCantidad;
    // End of variables declaration//GEN-END:variables
}