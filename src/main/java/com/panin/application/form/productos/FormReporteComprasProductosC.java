/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.panin.application.form.productos;

import com.formdev.flatlaf.FlatClientProperties;
import static com.panin.application.utilities.UtilitarioExportarTabla.exportar;
import com.panin.controladores.ControladorComprasProductos;
import com.panin.controladores.ControladorConversion;
import com.panin.controladores.ControladorProductos;
import com.panin.controladores.ControladorUnidadMedida;
import com.panin.entidades.ComprasProducto;
import com.panin.entidades.Conversion;
import com.panin.entidades.Producto;
import com.panin.entidades.UnidadMedida;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import raven.toast.Notifications;

/**
 *
 * @author USUARIO
 */
public class FormReporteComprasProductosC extends javax.swing.JPanel {

    /**
     * Creates new form FormReporteComprasProductosC
     */
    public FormReporteComprasProductosC() {
        initComponents();
        init();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jDateDesde1 = new com.toedter.calendar.JDateChooser();
        jComboBoxUnidad = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jDateHasta = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxProductos = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        botonExportar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        jLabel4.setText("Unidad Medida");

        jLabel1.setText("Desde");

        jLabel2.setText("Hasta");

        jLabel3.setText("Productos - Comprados");

        jButton1.setText("Consultar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        botonExportar.setText("Exportar");
        botonExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonExportarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateDesde1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jComboBoxUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(botonExportar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDateDesde1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBoxProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBoxUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1)
                        .addComponent(botonExportar)))
                .addGap(1, 1, 1))
        );

        table.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(table);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1)
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Date desde = jDateDesde1.getDate() == null ? null : jDateDesde1.getDate();
        Date hasta = jDateHasta.getDate() == null ? null : jDateHasta.getDate();

        if (desde != null || hasta != null) {
            Producto producto = (Producto) jComboBoxProductos.getSelectedItem();
            ControladorComprasProductos controladorComprasProductos = new ControladorComprasProductos();
            System.out.println(producto.getDescripcion());
            if (producto.getDescripcion().equals("Todos")) {
                //Buscar todos los insumos
                if (desde != null && hasta != null) {

                    listaCompras = controladorComprasProductos.obtenerComprasProductosFecha(desde, hasta);
                } else if (desde != null) {
                    System.out.println(desde);
                    listaCompras = controladorComprasProductos.obtenerComprasProductosDesde(desde);
                } else if (hasta != null) {
                    listaCompras = controladorComprasProductos.obtenerComprasProductosHasta(hasta);
                }

                actualizarLista();

            } else {
                //Buscar por un insumo especifico

                if (desde != null && hasta != null) {
                    listaCompras = controladorComprasProductos.obtenerComprasDesdeHastaProducto(producto, desde, hasta);
                } else if (desde != null) {
                    listaCompras = controladorComprasProductos.obtenerComprasDesdeProducto(producto, desde);
                } else if (hasta != null) {
                    listaCompras = controladorComprasProductos.obtenerComprasHastaProducto(producto, hasta);
                }
                actualizarLista();
            }

        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void botonExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonExportarActionPerformed
        // TODO add your handling code here:
        if (table.getModel().getRowCount() > 0) {
            DateTimeFormatter timeStampPattern = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
            String ruta = "archivos/productos/Reporte_Compras_Insumos_" + timeStampPattern.format(java.time.LocalDateTime.now()) + ".xls";
            exportar(table, ruta);
            Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER, "Reporte generado en : " + ruta);
        } else {
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_CENTER, "La tabla esta vacía, nada que exportar ");
        }

    }//GEN-LAST:event_botonExportarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonExportar;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<Producto> jComboBoxProductos;
    private javax.swing.JComboBox<UnidadMedida> jComboBoxUnidad;
    private com.toedter.calendar.JDateChooser jDateDesde1;
    private com.toedter.calendar.JDateChooser jDateHasta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
  private DefaultTableModel modelTable;
    private List<ComprasProducto> listaCompras;

    private void init() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

//        jPanel1.setLayout(new MigLayout("al center"));
        ControladorProductos controladorProducto = new ControladorProductos();
        List<Producto> productos = controladorProducto.obtenerProductosComprados();
        Producto all = new Producto();
        all.setDescripcion("Todos");
        jComboBoxProductos.addItem(all);
        for (Producto producto : productos) {
            jComboBoxProductos.addItem(producto);
            actualizarUnidadMedida();
        }

        String[] columnas = new String[]{
            "Id Producto", "Producto", "Id Compra", "Marca", "Cantidad", "Unidad Medida", "Precio", "Fecha", "Hora",};
        modelTable = new DefaultTableModel(columnas, 0);
        this.table.setModel(modelTable);
        TableColumnModel columnModel = table.getColumnModel();
        TableColumn columnaCantidad = columnModel.getColumn(0);
        columnaCantidad.setPreferredWidth(12);
        columnaCantidad = columnModel.getColumn(2);
        columnaCantidad.setPreferredWidth(12);
        columnaCantidad = columnModel.getColumn(5);
        columnaCantidad.setPreferredWidth(20);
        columnaCantidad = columnModel.getColumn(7);
        columnaCantidad.setPreferredWidth(20);
        columnaCantidad = columnModel.getColumn(8);
        columnaCantidad.setPreferredWidth(15);
        columnaCantidad = columnModel.getColumn(4);
        columnaCantidad.setPreferredWidth(30);
        columnaCantidad = columnModel.getColumn(6);
        columnaCantidad.setPreferredWidth(30);
        columnaCantidad = columnModel.getColumn(1);
        columnaCantidad.setPreferredWidth(180);
        columnaCantidad = columnModel.getColumn(3);
        columnaCantidad.setPreferredWidth(140);

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

        table.setEnabled(false);

    }

    private void actualizarUnidadMedida() {
        jComboBoxProductos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jComboBoxUnidad.removeAllItems();
                Producto producto = (Producto) jComboBoxProductos.getSelectedItem();
                if (!producto.getDescripcion().equals("Todos")) {
                    for (UnidadMedida um : producto.getIdTipoMedida().getUnidadMedidaCollection()) {
                        jComboBoxUnidad.addItem(um);
                    }
                }

            }
        });
    }

    private void actualizarLista() {
        modelTable.setRowCount(0);
        listaCompras.sort(Collections.reverseOrder());
        UnidadMedida medidaSeleccionada;

        if (jComboBoxUnidad.getSelectedItem() != null) {
            medidaSeleccionada = (UnidadMedida) jComboBoxUnidad.getSelectedItem();
        } else {
            medidaSeleccionada = new UnidadMedida();
            medidaSeleccionada.setUnidadBase(true);
        }

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

        SimpleDateFormat formatterh = new SimpleDateFormat("HH:mm:ss:");
        String hora;

        for (ComprasProducto fila : listaCompras) {
            DecimalFormat df = new DecimalFormat("#,##0.00");
            String marca = "NA";
            ControladorUnidadMedida controladorUnidadMedida = new ControladorUnidadMedida();
            ControladorConversion controladorConversion = new ControladorConversion();
            BigDecimal precioCalculado = fila.getPrecio();
            BigDecimal cantidadCalculada = fila.getCantidad();
            String unidadAbreviatura = fila.getUnidadMedida().toString();
            String cantidadFormateada;
            String precioFormateado;
            hora = fila.getHora().toString();
            if (fila.getUnidadMedida().isUnidadBase()) {
                precioCalculado = precioCalculado.multiply(fila.getCantidad());
            } else {
                UnidadMedida umb = controladorUnidadMedida.obtenerUnidadBase(fila.getUnidadMedida());
                Conversion conversion = controladorConversion.obtenerFactorConversion(umb, fila.getUnidadMedida());
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
            cantidadFormateada = df.format(cantidadCalculada.doubleValue());
            precioFormateado = df.format(valorDouble);
            modelTable.addRow(new Object[]{fila.getProducto().getId().toString(), fila.getProducto(), fila.getId().toString(), marca, cantidadFormateada, unidadAbreviatura, valorDouble, strDate, hora,});
        }

        // Convertir a double
    }
}