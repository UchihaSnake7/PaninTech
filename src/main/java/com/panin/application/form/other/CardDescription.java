/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.panin.application.form.other;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Path2D;


/**
 *
 * @author USUARIO
 */
public class CardDescription extends javax.swing.JPanel {

    /**
     * Creates new form CardDescription
     */
    
      public CardDescription(String title, String description) {
        initComponents();
        setOpaque(false);
          txt.setBackground(new Color(0, 0, 0, 0));
        lblTitle.setText(title);
        lblTitle.setForeground(Color.BLACK);
//        txt.setText(title);
        txt.setForeground(Color.BLACK);
    }
    public CardDescription() {
        initComponents();
    }

    
        @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(255, 255, 255, 255));
        Path2D.Float f = new Path2D.Float();
        f.moveTo(0, 30);
        f.curveTo(50, 0, 100, 40, 150, 0);
        f.lineTo(150, getHeight());
        f.lineTo(0, getHeight());
        g2.fill(f);
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

        lblTitle = new javax.swing.JLabel();
        txt = new com.panin.application.form.insumos.TextArea();

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTitle.setText("jLabel1");
        lblTitle.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));

        txt.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        txt.setColumns(20);
        txt.setRows(5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblTitle)
                .addContainerGap(71, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(txt, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblTitle;
    private com.panin.application.form.insumos.TextArea txt;
    // End of variables declaration//GEN-END:variables
}