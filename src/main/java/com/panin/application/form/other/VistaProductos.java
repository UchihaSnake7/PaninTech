/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panin.application.form.other;

import com.panin.controladores.ControladorProductos;
import com.panin.controladores.ControladorReceta;
import com.panin.dto.formAgregarInsumoProductoDTO;
import com.panin.entidades.InsumoRecetas;
import com.panin.entidades.Producto;
import com.panin.entidades.Recetas;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JPanel;

/**
 *
 * @author ricke
 */
public class VistaProductos {
    
    
    
     public void mostrarProductos(JPanel panel, List<Producto> productos, String clase, String ipoProducto, boolean filtrar, String... texto){
        
         List<Producto> listaFinal = new ArrayList<Producto>();
         
        if( filtrar ){
            
             panel.removeAll();
             List<Producto> productosFiltradas = (List<Producto>) productos.stream()
                .filter(producto -> producto.getDescripcion().toLowerCase().contains(texto[0].toLowerCase()))
                .collect(Collectors.toList());
             
             listaFinal.addAll(productosFiltradas);
            
        }
        else if( !filtrar )
        {
            
            listaFinal.addAll(productos);

        }
        

        String formClass = clase;

        ControladorReceta cr = new ControladorReceta();

        List<formAgregarInsumoProductoDTO> listaInsumosReceta = new ArrayList<formAgregarInsumoProductoDTO>();

        for (Producto producto : listaFinal) {

            panel.add(new Card(new Model_Card(new javax.swing.ImageIcon(getClass().getResource(producto.getRutaImagen())), producto.getDescripcion(), "", producto.getTipo().toString(), producto), panel.getBackground(), formClass));

        }

        panel.revalidate();
        panel.repaint();
        
    }
    
}
