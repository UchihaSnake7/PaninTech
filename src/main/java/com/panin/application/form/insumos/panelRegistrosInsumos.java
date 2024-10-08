/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.panin.application.form.insumos;

import com.panin.application.form.productos.*;
import com.formdev.flatlaf.FlatClientProperties;
import com.panin.controladores.ControladorComprasInsumos;
import com.panin.controladores.ControladorInsumos;
import com.panin.dto.formAgregarInsumoProductoDTO;
import com.panin.entidades.ComprasInsumo;
import com.panin.entidades.Insumo;
import com.panin.entidades.UnidadMedida;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JTable;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author ricke
 */
public class panelRegistrosInsumos extends javax.swing.JPanel {

    /**
     * Creates new form panelContenidoReceta
     */
    private List<ComprasInsumo> listaInsumos;
    private DefaultTableModel modelTable;

    public List<ComprasInsumo> getListaInsumos() {
        return listaInsumos;
    }

    public void setListaInsumos(List<ComprasInsumo> listaInsumos) {
        this.listaInsumos = listaInsumos;
        this.listaInsumos.sort(Collections.reverseOrder());

    }

    public void agregarCompra(ComprasInsumo nuevaCompra) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

        SimpleDateFormat formatterh = new SimpleDateFormat("HH:mm:ss:");

        listaInsumos.add(nuevaCompra);
        this.listaInsumos.sort(Collections.reverseOrder());
        modelTable.setRowCount(0);
        for (ComprasInsumo fila : listaInsumos) {
            String strDate = formatter.format(fila.getFecha());
            String strHora = formatter.format(fila.getHora());
            System.out.println(strHora);
            modelTable.addRow(new Object[]{strDate, strHora, fila.getCantidad().toString(), fila.getUnidadMedidaId().getAbreviatura(), fila.getPrecio().toString()});
        }

        modelTable.fireTableDataChanged();
        System.out.println(modelTable.getRowCount());
    }

    public void iniciar(Insumo insumo) {

        ControladorComprasInsumos controladorComprasInsumos = new ControladorComprasInsumos();

        this.listaInsumos = controladorComprasInsumos.obtenerComprasdeUnInsumo(insumo);
        this.listaInsumos.sort(Collections.reverseOrder());
        System.out.println(listaInsumos.size());
        for (ComprasInsumo ci : listaInsumos) {
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            String strDate = formatter.format(ci.getFecha());
            System.out.println(strDate);
            SimpleDateFormat formatterh = new SimpleDateFormat("HH:mm:ss:");
            String strHora = formatter.format(ci.getHora());
            System.out.println(strHora);

            modelTable.addRow(new Object[]{strDate, strHora, ci.getCantidad().toString(), ci.getUnidadMedidaId().getAbreviatura(), ci.getPrecio().toString()});
            modelTable.fireTableDataChanged();
            System.out.println(modelTable.getRowCount());
        }

        for (UnidadMedida item : insumo.getIdTipoMedida().getUnidadMedidaCollection()) {
            jComboxUnidades.addItem(item);
        }
    }

    public panelRegistrosInsumos() {
        String[] columnas = new String[]{
            "Fecha", "Hora", "Cantidad", "Unidad Medida", "Precio"
        };
        modelTable = new DefaultTableModel(columnas, 0);
        initComponents();
        init();

    }

    public panelRegistrosInsumos obtenerPanel() {
        return this;
    }

    public void init() {
        this.table.setModel(modelTable);
        this.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:25;"
                + "background:$background"
        );

        table.getTableHeader().putClientProperty(FlatClientProperties.STYLE, ""
                + "height:30;"
                + "hoverBackground:null;"
                + "pressedBackground:null;"
                //                + "dropLineShortColor:$Menu.background;"
                + "font:bold;"
                + "background:$Menu.background;"
        );

        table.putClientProperty(FlatClientProperties.STYLE, ""
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

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        separador = new javax.swing.JSeparator();
        botonAbrirFrameFormularioInsumo = new javax.swing.JButton();
        jComboxUnidades = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        botonAbrirFrameFormularioInsumo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/utilidad/agregar.png"))); // NOI18N
        botonAbrirFrameFormularioInsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAbrirFrameFormularioInsumoActionPerformed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Fecha", "Hora", "Cantidad", "Unidad", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setColumnSelectionAllowed(true);
        table.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(table);
        table.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(separador, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                .addGap(86, 86, 86))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jComboxUnidades, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonAbrirFrameFormularioInsumo)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(botonAbrirFrameFormularioInsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboxUnidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separador, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botonAbrirFrameFormularioInsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAbrirFrameFormularioInsumoActionPerformed
        // TODO add your handling code here:}
//        frameIngresarInsumoReceta frame = new frameIngresarInsumoReceta(this);
//        frame.addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosed(WindowEvent e) {
//                String dato1 = frame.getName();
//                System.out.println(".windowClosed()");
//                System.out.println("Desde panel receta recibo " + frame.getDtoAgregarInsumo().getInsumo());
//                modelTable.addRow(new Object[]{frame.getDtoAgregarInsumo().getInsumo(), frame.getDtoAgregarInsumo().getUnidadMedidad(), frame.getDtoAgregarInsumo().getCantidad()});
//                
//                listaDTO.add(frame.getDtoAgregarInsumo());
//            }
//        });
    }//GEN-LAST:event_botonAbrirFrameFormularioInsumoActionPerformed

    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAbrirFrameFormularioInsumo;
    private javax.swing.JComboBox<UnidadMedida> jComboxUnidades;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator separador;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
