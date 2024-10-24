/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.panin.application.ventas;

import com.formdev.flatlaf.FlatClientProperties;
import com.panin.application.utilities.SearchHeader2;
import com.panin.application.utilities.TableActionCellEditor;
import com.panin.application.utilities.TableActionCellRender;
import com.panin.application.utilities.TableActionEvent;
import com.panin.controladores.ControladorCliente;
import com.panin.controladores.ControladorMetodoPago;
import com.panin.entidades.Cliente;
import com.panin.entidades.MetodoPago;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import raven.toast.Notifications;

/**
 *
 * @author USUARIO
 */
public class PanelVerMetodosDePago extends javax.swing.JPanel implements SearchHeader2.BuscadorListener {

    /**
     * Creates new form PanelVerMetodosDePago
     */
    public PanelVerMetodosDePago() {
        initComponents();
        init();
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

//        table.setEnabled(false);
        searchHeader21.setBackground(getBackground());
        searchHeader21.setListener(this);
        table.setRowHeight(60);
        actualizarLista();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        searchHeader21 = new com.panin.application.utilities.SearchHeader2();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table.setRowHeight(40);
        jScrollPane1.setViewportView(table);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator1)
                        .addGap(8, 8, 8))
                    .addComponent(jScrollPane1)
                    .addComponent(searchHeader21, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE))
                .addGap(1, 1, 1))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(searchHeader21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(2, 2, 2)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 823, Short.MAX_VALUE)
                .addGap(54, 54, 54))
        );

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 614, Short.MAX_VALUE)
            .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelPrincipalLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 963, Short.MAX_VALUE)
            .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelPrincipalLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(31, 31, 31))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel panelPrincipal;
    private com.panin.application.utilities.SearchHeader2 searchHeader21;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
    private DefaultTableModel modelTable;
    private List<MetodoPago> metodos;

    private void init() {
        String[] columnas = new String[]{
            "Codigo", "Tipo", "Banco", "Detalles", "Opciones"};
//        panelEditarCliente = new PanelEditarCliente();
//        panelEditarCliente.setBackground(this.getBackground());

//        panelEditarCliente.setListener(this);
        modelTable = new DefaultTableModel(columnas, 0) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };

        this.table.setModel(modelTable);
        table.getColumnModel().getColumn(4).setCellRenderer(new TableActionCellRender());
        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                PanelEditarFormularioMetodoDePago panelEditarFormularioMetodoDePago = new PanelEditarFormularioMetodoDePago();
                ControladorMetodoPago controladorMetodoPago = new ControladorMetodoPago();
                String id = (String) modelTable.getValueAt(row, 0);
                MetodoPago metodoPago = controladorMetodoPago.obtenerMetodoById(Integer.parseInt(id));

////                panelEditarCliente.setVisible(true);
                jPanel1.setVisible(false);
                //                panelEditarCliente2.setVisible(true);
                remove(jPanel1);
                cambioDePanel(panelEditarFormularioMetodoDePago);
                panelEditarFormularioMetodoDePago.iniciar(metodoPago, true);
            }

            @Override

            public void onDelete(int row) {
                ControladorMetodoPago controladorMetodoPago = new ControladorMetodoPago();
                String id = (String) modelTable.getValueAt(row, 0);
                MetodoPago metodoPago = controladorMetodoPago.obtenerMetodoById(Integer.parseInt(id));

                int respuesta = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea borrar el Metodo de Pago "
                        + metodoPago.getId() + "-" + metodoPago.getTipo() + "-" + metodoPago.getBanco()
                        + "? ", "Confirmación",
                        JOptionPane.YES_NO_OPTION);
                if (respuesta == JOptionPane.YES_OPTION) {

                    if (controladorMetodoPago.delete(metodoPago)) {
                        Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER, "El Método de Pago se borró con Éxito!");
                        modelTable.removeRow(row);
                    } else {
                        metodoPago.setActivo(false);

                        if (controladorMetodoPago.update(metodoPago)) {
                            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_CENTER, "El Método de Pago no se puede borrar, se desactivó");
                            actualizarLista();
                        } else {
                            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "Error interno");
                        }
                    }
                } else {
                    Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.TOP_CENTER, "Ok");
                }

//                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void onView(int row) {
                PanelEditarFormularioMetodoDePago panelEditarFormularioMetodoDePago = new PanelEditarFormularioMetodoDePago();
                ControladorMetodoPago controladorMetodoPago = new ControladorMetodoPago();
                String id = (String) modelTable.getValueAt(row, 0);
                MetodoPago metodoPago = controladorMetodoPago.obtenerMetodoById(Integer.parseInt(id));

////                panelEditarCliente.setVisible(true);
                jPanel1.setVisible(false);
                //                panelEditarCliente2.setVisible(true);
                remove(jPanel1);
                cambioDePanel(panelEditarFormularioMetodoDePago);
                panelEditarFormularioMetodoDePago.iniciar(metodoPago, false);
            }
        };

        table.getColumnModel().getColumn(4).setCellEditor(new TableActionCellEditor(event));

    }

    private void actualizarLista() {

        modelTable.setRowCount(0);
        ControladorMetodoPago controladorMetodoPago = new ControladorMetodoPago();
        this.metodos = controladorMetodoPago.obtenerActivos();

        for (MetodoPago fila : metodos) {
            String convertido = saltosDeLinea(fila.getReferencia());
            System.out.println(convertido);
            modelTable.addRow(new Object[]{fila.getId().toString(), fila.getTipo().getDescripcion(), fila.getBanco().getDescripcion(), convertido});
        }

    }

    @Override
    public void onTextoIngresado(String texto) {
        filtarLista(texto);
    }

    private void filtarLista(String texto) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        modelTable.setRowCount(0);
        ControladorCliente controladorCliente = new ControladorCliente();

        List<MetodoPago> metodosFilttados = (List<MetodoPago>) metodos.stream()
                .filter(metodo -> metodo.getId().toString().contains(texto.toLowerCase())
                || metodo.getTipo().getDescripcion().toString().contains(texto.toLowerCase())
                || metodo.getBanco().getDescripcion().contains(texto.toLowerCase())
                //                || metodo.getReferencia().toLowerCase().contains(texto.toLowerCase())
                )
                .collect(Collectors.toList());

        for (MetodoPago fila : metodosFilttados) {

            String convertido = saltosDeLinea(fila.getReferencia());
            System.out.println(convertido);
            modelTable.addRow(new Object[]{fila.getId().toString(), fila.getTipo().getDescripcion(), fila.getBanco().getDescripcion(), convertido});
        }

    }

    public String saltosDeLinea(String descripción) {
        String convertido = null;
        String sinSaltos = descripción.replaceAll("\n", "<br> ");
        convertido = "<HTML> " + sinSaltos + " </HTML>";
        return convertido;
    }

    private void cambioDePanel(javax.swing.JPanel panel) {
        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
                panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 854, Short.MAX_VALUE)
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelPrincipalLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        panelPrincipalLayout.setVerticalGroup(
                panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 963, Short.MAX_VALUE)
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelPrincipalLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

    }

}
