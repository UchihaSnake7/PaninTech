package com.panin.application.form.other;

import com.formdev.flatlaf.FlatClientProperties;
import java.awt.Component;
import java.awt.Container;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.Dimension;
import net.miginfocom.swing.MigLayout;
import java.awt.LayoutManager;
import com.panin.controladores.ControladorTasa;
import com.panin.entidades.Tasa;
import com.panin.controladores.ControladorProductos;
import java.sql.Time;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
/**
 *
 * @author Raven
 */
public class FormCambio extends javax.swing.JPanel {

    public FormCambio() {
        initComponents();
        init();
        lb.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h1.font");
         jLabel1.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h1.font");
            jLabel2.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h1.font");
    }
    
    private void init() {
        ControladorTasa cr = new ControladorTasa();
        List<Tasa> Tasas = new ArrayList<Tasa>();
       Tasas =  cr.obtenerTasas();
       cr.cerrarSesion();
       Tasa R = Tasas.get(Tasas.size() - 1);
      
       cambio.setText(String.valueOf(R.getTasa()));
       System.out.println("Fecha: " + R.getFecha());
  
       jLabel3.setText( R.getFecha().toString());
      
       
        setLayout(new CambioLayout());
    Cambio.putClientProperty(FlatClientProperties.STYLE, ""  +"background:$Login.background;" + "arc:20");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Cambio = new javax.swing.JPanel();
        lb = new javax.swing.JLabel();
        actulizacionC = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cambio = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        Cambio.setBackground(new java.awt.Color(60, 78, 102));
        Cambio.setName("cambio"); // NOI18N

        lb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb.setText("Cambio");

        jButton1.setText("Actualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("$");

        jLabel3.setText("jLabel3");

        javax.swing.GroupLayout CambioLayout = new javax.swing.GroupLayout(Cambio);
        Cambio.setLayout(CambioLayout);
        CambioLayout.setHorizontalGroup(
            CambioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CambioLayout.createSequentialGroup()
                .addGroup(CambioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(CambioLayout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cambio, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CambioLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lb, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(actulizacionC, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(226, 226, 226))
            .addGroup(CambioLayout.createSequentialGroup()
                .addGap(238, 238, 238)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CambioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(340, 340, 340))
        );
        CambioLayout.setVerticalGroup(
            CambioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CambioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CambioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cambio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(CambioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(actulizacionC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(jButton1)
                .addGap(24, 24, 24))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("PaninTech");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(277, 277, 277))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Cambio, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(162, 162, 162))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Cambio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(156, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       Tasa r = new Tasa();
       float valor = Float.parseFloat(actulizacionC.getText());
       r.setTasa(valor);
    //   String fechaString = "2024-10-07 02:22:05.000000";
    //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");
    //LocalDateTime fechaLocalDateTime = LocalDateTime.parse(fechaString, formatter);
    //Date fecha = Date.from(fechaLocalDateTime.atZone(ZoneId.systemDefault()).toInstant());
       Date fecha = new Date();
       
         r.setFecha(fecha);
         ControladorTasa cr = new ControladorTasa();
         cr.crearTasa(r);
         cr.cerrarSesion();
     
        
     
       
       
       
    }//GEN-LAST:event_jButton1ActionPerformed

    
    
    private class CambioLayout implements LayoutManager {

        @Override
        public void addLayoutComponent(String name, Component comp) {
         
        }

        @Override
        public void removeLayoutComponent(Component comp) {
           
        }

        @Override
        public Dimension preferredLayoutSize(Container parent) {
                synchronized (parent.getTreeLock()) {
                return new Dimension(5, 5);
            }
        }

        @Override
        public Dimension minimumLayoutSize(Container parent) {
                synchronized (parent.getTreeLock()) {
                return new Dimension(5, 5);
            }
       
        }

        @Override
        public void layoutContainer(Container parent) {
           synchronized (parent.getTreeLock()) {
               int width = parent.getWidth();
               int heigth = parent.getHeight();
               int CambioWidth=560;
               int CambioHeigth= Cambio.getPreferredSize().height;
               int x = (width-CambioWidth)/2;
               int y = (heigth-CambioHeigth)/2;
               Cambio.setBounds(x, y, CambioWidth, CambioHeigth);
                       
              
            }
        }
        
        
      }  
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Cambio;
    private javax.swing.JTextField actulizacionC;
    private javax.swing.JTextField cambio;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lb;
    // End of variables declaration//GEN-END:variables
}
