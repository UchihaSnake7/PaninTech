/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.panin.application.form.insumos;

import com.panin.application.form.productos.*;
import com.formdev.flatlaf.FlatClientProperties;
import com.panin.controladores.ControladorComprasInsumos;
import com.panin.controladores.ControladorConversion;
import com.panin.controladores.ControladorInsumos;
import com.panin.controladores.ControladorUnidadMedida;
import com.panin.dto.formAgregarInsumoProductoDTO;
import com.panin.entidades.ComprasInsumo;
import com.panin.entidades.Conversion;
import com.panin.entidades.Insumo;
import com.panin.entidades.UnidadMedida;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JTable;
import javax.swing.SortOrder;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
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
    private Insumo insumoc;

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
        ControladorUnidadMedida controladorUnidadMedida = new ControladorUnidadMedida();
        ControladorConversion controladorConversion = new ControladorConversion();

        listaInsumos.add(nuevaCompra);
        this.listaInsumos.sort(Collections.reverseOrder());
        modelTable.setRowCount(0);
        actualizarLista();

        modelTable.fireTableDataChanged();
        System.out.println(modelTable.getRowCount());
    }

    public void iniciar(Insumo insumo) {

        ControladorComprasInsumos controladorComprasInsumos = new ControladorComprasInsumos();

        this.insumoc = insumo;
        this.listaInsumos = controladorComprasInsumos.obtenerComprasdeUnInsumo(insumo);
        this.listaInsumos.sort(Collections.reverseOrder());
        table.setEnabled(false);

        // Crear un renderizador para centrar el contenido
        DefaultTableCellRenderer rendererCentrado = new DefaultTableCellRenderer();
        rendererCentrado.setHorizontalAlignment(SwingConstants.CENTER);
        DefaultTableCellRenderer rendererDerecha = new DefaultTableCellRenderer();
        rendererDerecha.setHorizontalAlignment(SwingConstants.RIGHT);

        // Para alinear a la derecha o centrar
        table.getColumnModel().getColumn(0).setCellRenderer(rendererCentrado);
        table.getColumnModel().getColumn(1).setCellRenderer(rendererCentrado);
        table.getColumnModel().getColumn(3).setCellRenderer(rendererCentrado);
        table.getColumnModel().getColumn(2).setCellRenderer(rendererDerecha);
        table.getColumnModel().getColumn(4).setCellRenderer(rendererDerecha);
//        renderer.setHorizontalAlignment(SwingConstants.CENTER);

        // Aplicar el renderizador a todas las columnas (puedes especificarlo por columna)
        for (UnidadMedida item : insumo.getIdTipoMedida().getUnidadMedidaCollection()) {
            jComboxUnidades.addItem(item);
        }

        actualizarLista();
        actualizarUnidadMedida();
        busquedaPorFecha();
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
        jDateDesde = new com.toedter.calendar.JDateChooser();
        jDateHasta = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

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
        table.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(table);

        jLabel1.setText("Desde:");

        jLabel3.setText("Hasta:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(separador, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
                .addGap(86, 86, 86))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jComboxUnidades, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonAbrirFrameFormularioInsumo)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1)
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(botonAbrirFrameFormularioInsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboxUnidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel3))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel1)
                                .addComponent(jDateDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jDateHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(separador, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
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
    private com.toedter.calendar.JDateChooser jDateDesde;
    private com.toedter.calendar.JDateChooser jDateHasta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator separador;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables

    private void actualizarLista() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        // Redondear a un decimal
        UnidadMedida medidaSeleccionada = (UnidadMedida) jComboxUnidades.getSelectedItem();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

        SimpleDateFormat formatterh = new SimpleDateFormat("HH:mm:ss:");
        String hora;

        for (ComprasInsumo fila : listaInsumos) {
            ControladorUnidadMedida controladorUnidadMedida = new ControladorUnidadMedida();
            ControladorConversion controladorConversion = new ControladorConversion();
            BigDecimal precioCalculado = fila.getPrecio();
            BigDecimal cantidadCalculada = fila.getCantidad();
            String unidadAbreviatura = fila.getUnidadMedidaId().toString();
            hora = fila.getHora().toString();
            if (fila.getUnidadMedidaId().isUnidadBase()) {
                precioCalculado = precioCalculado.multiply(fila.getCantidad());
            } else {
                UnidadMedida umb = controladorUnidadMedida.obtenerUnidadBase(fila.getUnidadMedidaId());
                Conversion conversion = controladorConversion.obtenerFactorConversion(umb, fila.getUnidadMedidaId());
                cantidadCalculada = fila.getCantidad().multiply(conversion.getFactorConversion());
                precioCalculado = precioCalculado.multiply(cantidadCalculada);
            }
//            System.out.println(medidaSeleccionada.isUnidadBase());
            if (!medidaSeleccionada.isUnidadBase()) {
                cantidadCalculada = cantidadCalculada.multiply(controladorConversion.obtenerFactorConversion(controladorUnidadMedida.obtenerUnidadBase(medidaSeleccionada), medidaSeleccionada).getFactorConversion());
                unidadAbreviatura = medidaSeleccionada.toString();
//                System.out.println("Medida seleccionada " + unidadAbreviatura);
            }

            String strDate = formatter.format(fila.getFecha());
            String strHora = formatter.format(fila.getHora());
            BigDecimal redondeado = precioCalculado.setScale(1, RoundingMode.HALF_UP);
            double valorDouble = redondeado.doubleValue();
            modelTable.addRow(new Object[]{strDate, hora, cantidadCalculada.toString(), unidadAbreviatura, valorDouble});
        }

        // Convertir a double
    }

    private void actualizarUnidadMedida() {
        jComboxUnidades.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                System.out.println("Cambio de medida");
                modelTable.setRowCount(0);
                actualizarLista();
            }
        });
    }

    private void busquedaPorFecha() {

        jDateDesde.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent e) {

                if ("date".equals(e.getPropertyName())) {
                    jDateHasta.setMinSelectableDate(jDateDesde.getDate());
                    ControladorComprasInsumos controladorComprasInsumos = new ControladorComprasInsumos();
                    if (jDateHasta.getDate() == null) {
                        listaInsumos = controladorComprasInsumos.obtenerComprasDesde(insumoc, jDateDesde.getDate());
                    } else {
                        listaInsumos = controladorComprasInsumos.obtenerComprasDesdeHasta(insumoc, jDateDesde.getDate(), jDateHasta.getDate());
                    }
                    listaInsumos.sort(Collections.reverseOrder());
                    modelTable.setRowCount(0);
                    actualizarLista();
                }

            }
        });
        jDateHasta.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent e) {

                if ("date".equals(e.getPropertyName())) {
                    jDateDesde.setMaxSelectableDate(jDateHasta.getDate());
                    ControladorComprasInsumos controladorComprasInsumos = new ControladorComprasInsumos();
                    if (jDateDesde.getDate() == null) {
                        listaInsumos = controladorComprasInsumos.obtenerComprasHasta(insumoc, jDateHasta.getDate());
                    } else {
                        listaInsumos = controladorComprasInsumos.obtenerComprasDesdeHasta(insumoc, jDateDesde.getDate(), jDateHasta.getDate());
                    }
                    listaInsumos.sort(Collections.reverseOrder());
                    modelTable.setRowCount(0);
                    actualizarLista();
                }

            }
        });

    }
}
