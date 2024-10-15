/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.panin.application.form.insumos;

import com.panin.application.form.productos.*;
import com.formdev.flatlaf.FlatClientProperties;
import com.panin.controladores.ControladorComprasInsumos;
import com.panin.controladores.ControladorConversion;
import com.panin.controladores.ControladorInsumoReceta;
import com.panin.controladores.ControladorInsumos;
import com.panin.controladores.ControladorProductos;
import com.panin.controladores.ControladorReceta;
import com.panin.controladores.ControladorUnidadMedida;
import com.panin.dto.formAgregarInsumoProductoDTO;
import com.panin.entidades.ComprasInsumo;
import com.panin.entidades.Conversion;
import com.panin.entidades.Insumo;
import com.panin.entidades.InsumoRecetas;
import com.panin.entidades.Producto;
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
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JTable;
import javax.swing.SortOrder;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
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
    private DefaultTableModel modelTableProductos;
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
        table.getColumnModel().getColumn(2).setCellRenderer(rendererCentrado);
        table.getColumnModel().getColumn(4).setCellRenderer(rendererCentrado);
        table.getColumnModel().getColumn(3).setCellRenderer(rendererDerecha);
        table.getColumnModel().getColumn(5).setCellRenderer(rendererDerecha);
//        renderer.setHorizontalAlignment(SwingConstants.CENTER);

        // Aplicar el renderizador a todas las columnas (puedes especificarlo por columna)
        for (UnidadMedida item : insumo.getIdTipoMedida().getUnidadMedidaCollection()) {
            jComboxUnidades.addItem(item);
        }
        
        actualizarLista();
        actualizarUnidadMedida();
        busquedaPorFecha();
        listaProductos();
        tableProductos.setEnabled(false);
        
    }
    
    public panelRegistrosInsumos() {
        
        String[] columnas = new String[]{
            "Id", "Fecha", "Hora", "Marca", "Cantidad", "Unidad Medida", "Precio"
        };
        modelTable = new DefaultTableModel(columnas, 0);
        
        columnas = new String[]{
            "Id", "Producto", "Cantidad", "Unidad Medida", "Cantidad por receta", "Costo de Producción"
        };
        
        modelTableProductos = new DefaultTableModel(columnas, 0);
        initComponents();
        init();
        
    }
    
    public panelRegistrosInsumos obtenerPanel() {
        return this;
    }
    
    public void init() {
        this.table.setModel(modelTable);
        this.tableProductos.setModel(modelTableProductos);

//        tabbedPane.putClientProperty(FlatClientProperties.STYLE, ""
//                //                + "dropLineShortColor:$Menu.background;"
//                + "selectedBackground: $Login.background;"
//                + "hoverColor: $Login.background;"
//                //                + "tabSeparatorColor: $Menu.background;"
//                + "selectedForeground: $Table.foreground;"
//                + "foreground:$Table.foreground;"
//                + "background:$Login.background;"
//        );
        this.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:25;"
                + "background:$background"
        );
        
        table.getTableHeader().putClientProperty(FlatClientProperties.STYLE, ""
                + "height:30;"
                + "hoverBackground:null;"
                + "pressedBackground:null;"
                //                                + "dropLineShortColor:$Menu.background;"
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
        
        tableProductos.getTableHeader().putClientProperty(FlatClientProperties.STYLE, ""
                + "height:30;"
                + "hoverBackground:null;"
                + "pressedBackground:null;"
                //                                + "dropLineShortColor:$Menu.background;"
                + "font:bold;"
                + "background:$Menu.background;"
        );
        
        tableProductos.putClientProperty(FlatClientProperties.STYLE, ""
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
        
        TableColumnModel columnModel = tableProductos.getColumnModel();
        TableColumn columnaCantidad = columnModel.getColumn(0);
        columnaCantidad.setPreferredWidth(12);
        columnaCantidad = columnModel.getColumn(1);
        columnaCantidad.setPreferredWidth(350);
        columnaCantidad = columnModel.getColumn(2);
        columnaCantidad.setPreferredWidth(40);
        columnaCantidad = columnModel.getColumn(3);
        columnaCantidad.setPreferredWidth(20);
        columnaCantidad = columnModel.getColumn(4);
        columnaCantidad.setPreferredWidth(60);
        
        columnModel = table.getColumnModel();
        columnaCantidad = columnModel.getColumn(0);
        columnaCantidad.setPreferredWidth(10);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        shadowRenderer1 = new com.panin.application.utilities.ShadowsRenderer();
        tabbedPane = new com.panin.application.utilities.TabbedPaneCustom();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jDateDesde = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jDateHasta = new com.toedter.calendar.JDateChooser();
        jSeparator1 = new javax.swing.JSeparator();
        jComboxUnidades = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableProductos = new javax.swing.JTable();

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

        jDateHasta.setMinimumSize(new java.awt.Dimension(85, 22));

        jComboxUnidades.setPreferredSize(new java.awt.Dimension(85, 22));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addComponent(jDateDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jLabel3)
                .addGap(29, 29, 29)
                .addComponent(jDateHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(jComboxUnidades, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 870, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 840, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboxUnidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jDateDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jDateHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tabbedPane.addTab("Compras", jPanel1);

        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        tableProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tableProductos);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 842, Short.MAX_VALUE)
                .addGap(23, 23, 23))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        tabbedPane.addTab("Productos", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(tabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public JTable getTable() {
        return table;
    }
    
    public void setTable(JTable table) {
        this.table = table;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<UnidadMedida> jComboxUnidades;
    private com.toedter.calendar.JDateChooser jDateDesde;
    private com.toedter.calendar.JDateChooser jDateHasta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private com.panin.application.utilities.ShadowsRenderer shadowRenderer1;
    private com.panin.application.utilities.TabbedPaneCustom tabbedPane;
    private javax.swing.JTable table;
    private javax.swing.JTable tableProductos;
    // End of variables declaration//GEN-END:variables

    private void actualizarLista() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        // Redondear a un decimal
        UnidadMedida medidaSeleccionada = (UnidadMedida) jComboxUnidades.getSelectedItem();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        
        SimpleDateFormat formatterh = new SimpleDateFormat("HH:mm:ss:");
        String hora;
        
        for (ComprasInsumo fila : listaInsumos) {
            String marca = "NA";
            DecimalFormat df = new DecimalFormat("#,##0.00");
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
            
            if (fila.getMarcaInsumo() != null) {
                marca = fila.getMarcaInsumo().getNombre();
            }
            
            String strDate = formatter.format(fila.getFecha());
            String strHora = formatter.format(fila.getHora());
            BigDecimal redondeado = precioCalculado.setScale(1, RoundingMode.HALF_UP);
            double valorDouble = redondeado.doubleValue();
            String cantidadFormat = df.format(cantidadCalculada.doubleValue());
            String precioFormat = df.format(valorDouble);
            modelTable.addRow(new Object[]{fila.getId().toString(), strDate, hora, marca, cantidadFormat, unidadAbreviatura, precioFormat});
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
    
    private void listaProductos() {
        ControladorInsumoReceta controladorInsumoReceta = new ControladorInsumoReceta();
        List<InsumoRecetas> listRecetas = controladorInsumoReceta.obtenerRecetasInsumos(insumoc);
        
        for (InsumoRecetas fila : listRecetas) {
            DecimalFormat df = new DecimalFormat("#,##0.00");
            String marca = "NA";
            ControladorUnidadMedida controladorUnidadMedida = new ControladorUnidadMedida();
            ControladorConversion controladorConversion = new ControladorConversion();
            ControladorProductos controladorProducto = new ControladorProductos();
            System.out.println(fila);
            Producto producto = controladorProducto.obtenerProductoByReceta(fila.getIdReceta());
            System.out.println(producto);
            if (producto != null) {
                
                String precioFormateada = df.format(producto.getPrecioProduccion());
                String cantidadFormateada = df.format(fila.getIdReceta().getCantidad().doubleValue());
                modelTableProductos.addRow(new Object[]{producto.getId().toString(), producto.getDescripcion(), fila.getCantidad().toString(), fila.getUnidadMedida(), cantidadFormateada, precioFormateada});
                
            }
            
        }
    }
}
