/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.panin.application.form.productos;

import com.panin.application.form.other.Card;
import com.panin.application.form.other.Model_Card;
import com.panin.application.form.other.VistaProductos;
import com.panin.application.utilities.ScrollBar;
import com.panin.application.utilities.SearchHeader2;
import com.panin.application.utilities.WrapLayout;
import com.panin.application.utilities.tipoProducto;
import com.panin.controladores.ControladorInsumos;
import com.panin.controladores.ControladorProductos;
import com.panin.entidades.Insumo;
import com.panin.entidades.Producto;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author USUARIO
 */
public class FormCompraProductos extends javax.swing.JPanel implements SearchHeader2.BuscadorListener {

    private List<Producto> productosComprados;

    /**
     * Creates new form FormCompraProductos
     */
    public FormCompraProductos() {
        initComponents();
        init();
    }

    private void init() {

        searchHeader21.setBackground(getBackground());
        searchHeader21.setListener(this);
        panel.setLayout(new WrapLayout(WrapLayout.LEADING));
        jScrollPane1.setVerticalScrollBar(new ScrollBar());

        ControladorProductos controladorProductos = new ControladorProductos();
        productosComprados = controladorProductos.obtenerProductosComprados();
//        ci.cerrarSesion();

        String formClass = "FormCompraProductos";
        for (Producto producto : productosComprados) {
            Card card = new Card(new Model_Card(new javax.swing.ImageIcon(getClass().getResource(producto.getRutaImagen())), producto.getDescripcion(), "", "Descripcion"), getBackground(), formClass);
            card.setProducto(producto);
            panel.add(card);

        }

        panel.revalidate();
        panel.repaint();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        searchHeader21 = new com.panin.application.utilities.SearchHeader2();
        jScrollPane1 = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Ingresar Compra de Productos");

        jScrollPane1.setBorder(null);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 704, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 589, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(panel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchHeader21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchHeader21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel;
    private com.panin.application.utilities.SearchHeader2 searchHeader21;
    // End of variables declaration//GEN-END:variables

    @Override
    public void onTextoIngresado(String texto) {
        panel.removeAll();
        VistaProductos vistaProductos = new VistaProductos();
        vistaProductos.mostrarProductos(panel, productosComprados, "FormCompraProductos", tipoProducto.Comprado.toString(), true, texto);

    }
}