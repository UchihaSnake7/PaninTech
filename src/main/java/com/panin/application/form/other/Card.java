/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.panin.application.form.other;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.Timer;
import com.panin.application.Application;
import com.panin.application.form.other.Model_Card;
import com.panin.application.form.productos.PanelIngresarProducto;
import com.panin.application.form.insumos.PanelIngresarInsumo;
import com.panin.application.form.productos.PanelIngresarCompra;
import com.panin.application.form.productos.PanelVerDatosProducto;
import com.panin.entidades.Insumo;
import com.panin.entidades.Producto;

/**
 *
 * @author USUARIO
 */
public class Card extends javax.swing.JPanel {

    Card() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Color getColorBack() {
        return colorBack;
    }

    public void setColorBack(Color colorBack) {
        this.colorBack = colorBack;
    }

    public Color getColorFont() {
        return colorFont;
    }

    /**
     * Creates new form Card
     */
    public void setColorFont(Color colorFont) {
        this.colorFont = colorFont;
    }
    private final Model_Card data;
    private Color colorBack = Color.BLACK;
    private Color colorFont = Color.WHITE;
    private final Timer timer;
    private final Timer timerStop;
    private final CardDescription cardDescription;
    private int y = 50;
    private int speed = 3;
    private boolean showing = false;
    private Insumo insumo;
    private Producto producto;

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Insumo getInsumo() {
        return insumo;
    }

    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }

    public Card(Model_Card data, Color color, String formClass) {
        this.data = data;
        colorBack = getBackground();

        initComponents();
        lblIcon.setIcon(data.getIcon());
        setOpaque(false);
        cardDescription = new CardDescription(data.getTitle(), data.getDescription());
        cardDescription.setLocation(0, y);
        setPreferredSize(new Dimension(140, 100));
        cardDescription.setSize(new Dimension(140, 100));
        add(cardDescription);
        timer = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (showing) {
                    y -= speed;
                    if (y <= 30) {
                        y = 30;
                        cardDescription.setLocation(0, y);
                        timer.stop();
                    } else {
                        cardDescription.setLocation(0, y);
                    }
                } else {
                    y += speed;
                    if (y >= 50) {
                        y = 50;
                        cardDescription.setLocation(0, y);
                        timer.stop();
                    } else {
                        cardDescription.setLocation(0, y);
                    }
                }
            }
        });
        //  500 for delay hide description
        timerStop = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                showing = false;
                timerStop.stop();
                timer.start();
            }
        });
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                showing = true;
                timerStop.stop();
                timer.start();
            }

            @Override
            public void mouseExited(MouseEvent me) {
                timerStop.start();
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(formClass);
                switch (formClass) {
                    case ("PanelIngresarProducto"): {

                        Application.showForm(new PanelIngresarProducto(data));
                        break;
                    }

                    case ("PanelVerDatosProducto"): {

                        Application.showForm(new PanelVerDatosProducto(data));
                        break;
                    }

                    case ("PanelIngresarInsumo"): {

                        Application.showForm(new PanelIngresarInsumo(data, insumo));
                        break;
                    }
                    case ("FormCompraProductos"): {
                        Application.showForm(new PanelIngresarCompra(data, producto));
                        break;
                    }
                    default:
                        throw new IllegalArgumentException("Valor no esperado: " + formClass);
                }
//                Application.showForm(new PanelIngresarProducto(data));

            }
        });
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//        System.out.println(getBackground().getRGB());
        GradientPaint g = new GradientPaint(0, 0, getBackground(), 0, getHeight(), getBackground());
        g2.setPaint(g);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
//        g2.fillOval(getWidth() - (getHeight() / 2), 10, getHeight(), getHeight());
//        g2.fillOval(getWidth() - (getHeight() / 2) - 20, getHeight() / 2 + 20, getHeight(), getHeight());
        super.paintComponent(grphcs);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblIcon = new javax.swing.JLabel();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(lblIcon)
                                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblIcon)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblIcon;
    // End of variables declaration//GEN-END:variables
}
