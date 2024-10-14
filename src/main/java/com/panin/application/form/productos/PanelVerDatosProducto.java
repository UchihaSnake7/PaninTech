/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.panin.application.form.productos;

import com.formdev.flatlaf.FlatClientProperties;
import com.panin.application.Application;
import com.panin.application.form.other.Model_Card;
import com.panin.controladores.ControladorProductos;
import com.panin.controladores.ControladorReceta;
import com.panin.dto.formAgregarInsumoProductoDTO;
import com.panin.entidades.InsumoRecetas;
import com.panin.entidades.Producto;
import com.panin.entidades.Recetas;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;
import net.miginfocom.swing.MigLayout;
import raven.toast.Notifications;

/**
 *
 * @author ricke
 */
public class PanelVerDatosProducto extends javax.swing.JPanel {

    /**
     * Creates new form PanelVerDatosProducto
     */
    private DefaultTableModel modelTable;
    private Producto producto = new Producto();
    private ControladorProductos cp = new ControladorProductos();

    public PanelVerDatosProducto() {

    }

    public PanelVerDatosProducto(Model_Card data) {

        producto = data.getProducto();
        initComponents();

        String[] columnas = new String[]{
            "Ingrediente", "Medida", "Cantidad"
        };

        modelTable = new DefaultTableModel(columnas, 0);
        tablaIngredientes.setModel(modelTable);

        nombreProducto.setText(data.getTitle());
        tipoProducto.setText("Tipo: " + data.getDescription());
        iconoProducto.setIcon(data.getIcon());
//              System.out.print("idReceta: " + data.getValues());

        obtenerInsumos(data.getDescription());

//        for (formAgregarInsumoProductoDTO dto : data.getListaInsumo()) {
//
//            modelTable.addRow(new Object[]{dto.getInsumo(), dto.getUnidadMedidad(), dto.getCantidad()});
//
//        }

        init();

    }

    
    public void obtenerInsumos(String tipo){
        
         ControladorReceta cr = new ControladorReceta();
         List<formAgregarInsumoProductoDTO> listaInsumosReceta = new ArrayList<formAgregarInsumoProductoDTO>();
         
            Recetas r = new Recetas();
            String tipoProducto = "NA";
            if (producto.getTipo() != null) {
                tipoProducto = producto.getTipo().name();
                if (producto.getTipo().toString().equalsIgnoreCase(tipo)) {

                 
                    r = cr.obtenerRecetaPorId(producto.getIdReceta());
                    listaInsumosReceta = new ArrayList<formAgregarInsumoProductoDTO>();

                    for (InsumoRecetas ir : r.getInsumoRecetasCollection()) {

//                        formAgregarInsumoProductoDTO dto = new formAgregarInsumoProductoDTO();
//
//                        dto.setCantidad(ir.getCantidad().doubleValue());
//                        dto.setInsumo(ir.getIdInsumo());
//                        dto.setUnidadMedidad(ir.getUnidadMedida());
//
//                        listaInsumosReceta.add(dto);

                         modelTable.addRow(new Object[]{ir.getIdInsumo(), ir.getUnidadMedida(), ir.getCantidad()});

                    }
                }
            }

    }
    
    public void init() {

        nombreProducto.putClientProperty(FlatClientProperties.STYLE, ""
                + "foreground:$Menu.foreground;");
        botonAtras.putClientProperty(FlatClientProperties.STYLE, ""
                + "foreground:$Menu.foreground;");

        panelContenidoProducto.putClientProperty(FlatClientProperties.STYLE, ""
                + "background:$Login.background;"
                + "arc:50;");

//              this.putClientProperty(FlatClientProperties.STYLE, ""
//                + "arc:25;"
//                + "background:$Table.background"
//        );
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

//              setLayout(new MigLayout("fillx,wrap,insets 30 40 50 40, width 220", "[fill]", "[]20[][]100[][]130[]"));
//               modelTable.addRow(new Object[]{frame.getDtoAgregarInsumo().getInsumo(), frame.getDtoAgregarInsumo().getUnidadMedidad(), frame.getDtoAgregarInsumo().getCantidad()});
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTabla = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaIngredientes = new javax.swing.JTable();
        botonAtras = new javax.swing.JButton();
        panelContenidoProducto = new javax.swing.JPanel();
        nombreProducto = new javax.swing.JLabel();
        iconoProducto = new javax.swing.JLabel();
        tipoProducto = new javax.swing.JLabel();
        botonEliminarProducto = new javax.swing.JButton();

        tablaIngredientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Ingrediente", "Medida", "Cantidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaIngredientes);

        javax.swing.GroupLayout panelTablaLayout = new javax.swing.GroupLayout(panelTabla);
        panelTabla.setLayout(panelTablaLayout);
        panelTablaLayout.setHorizontalGroup(
            panelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        panelTablaLayout.setVerticalGroup(
            panelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTablaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        botonAtras.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        botonAtras.setText("Atras");
        botonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAtrasActionPerformed(evt);
            }
        });

        nombreProducto.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N

        tipoProducto.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N

        javax.swing.GroupLayout panelContenidoProductoLayout = new javax.swing.GroupLayout(panelContenidoProducto);
        panelContenidoProducto.setLayout(panelContenidoProductoLayout);
        panelContenidoProductoLayout.setHorizontalGroup(
            panelContenidoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenidoProductoLayout.createSequentialGroup()
                .addGap(454, 454, 454)
                .addComponent(tipoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(231, 231, 231))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelContenidoProductoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelContenidoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelContenidoProductoLayout.createSequentialGroup()
                        .addComponent(iconoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(219, 219, 219))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelContenidoProductoLayout.createSequentialGroup()
                        .addComponent(nombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(197, 197, 197))))
        );
        panelContenidoProductoLayout.setVerticalGroup(
            panelContenidoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenidoProductoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iconoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(nombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tipoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        botonEliminarProducto.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        botonEliminarProducto.setText("Eliminar producto");
        botonEliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarProductoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(panelTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botonAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))))
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelContenidoProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(botonEliminarProducto)
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(panelContenidoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(botonEliminarProducto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAtrasActionPerformed
        // TODO add your handling code here:
        Application.showForm(new FormMostrarProductos());
    }//GEN-LAST:event_botonAtrasActionPerformed

    private void botonEliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarProductoActionPerformed
        // TODO add your handling code here:

        cp.borrarProducto(producto);
        cp.cerrarSesion();
        Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER, "Producto borrado con exito");
        Application.showForm(new FormMostrarProductos());


    }//GEN-LAST:event_botonEliminarProductoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAtras;
    private javax.swing.JButton botonEliminarProducto;
    private javax.swing.JLabel iconoProducto;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nombreProducto;
    private javax.swing.JPanel panelContenidoProducto;
    private javax.swing.JPanel panelTabla;
    private javax.swing.JTable tablaIngredientes;
    private javax.swing.JLabel tipoProducto;
    // End of variables declaration//GEN-END:variables
}
