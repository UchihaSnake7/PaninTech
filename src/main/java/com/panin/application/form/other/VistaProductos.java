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
//            ControladorProductos cp = new ControladorProductos();
//            productos = new ArrayList<Producto>();
//            productos = cp.obtenerProductos();
            
            listaFinal.addAll(productos);
            
//            ControladorReceta cr = new ControladorReceta();

        }
        
//        cp.cerrarSesion();

        String formClass = clase;

        ControladorReceta cr = new ControladorReceta();

        List<formAgregarInsumoProductoDTO> listaInsumosReceta = new ArrayList<formAgregarInsumoProductoDTO>();

        for (Producto producto : listaFinal) {

//                 String receta = "";
            Recetas r = new Recetas();
            String tipoProducto = "NA";
            if (producto.getTipo() != null) {
                tipoProducto = producto.getTipo().name();
                if (producto.getTipo().toString().equalsIgnoreCase(ipoProducto)) {

                 
                    r = cr.obtenerRecetaPorId(producto.getIdReceta());
                    listaInsumosReceta = new ArrayList<formAgregarInsumoProductoDTO>();

                    for (InsumoRecetas ir : r.getInsumoRecetasCollection()) {

                        formAgregarInsumoProductoDTO dto = new formAgregarInsumoProductoDTO();

                        dto.setCantidad(ir.getCantidad().doubleValue());
                        dto.setInsumo(ir.getIdInsumo());
                        dto.setUnidadMedidad(ir.getUnidadMedida());

                        listaInsumosReceta.add(dto);

                    }
                }
            }
            panel.add(new Card(new Model_Card(new javax.swing.ImageIcon(getClass().getResource(producto.getRutaImagen())), producto.getDescripcion(), "", tipoProducto, listaInsumosReceta, producto), panel.getBackground(), formClass));

        }
//        cr.cerrarSesion();

        panel.revalidate();
        panel.repaint();
        
    }
    
}
