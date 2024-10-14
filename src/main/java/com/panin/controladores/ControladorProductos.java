package com.panin.controladores;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.panin.HibernateUtil;
import com.panin.application.utilities.tipoProducto;
import com.panin.db.ConexionDB;
import com.panin.dto.formAgregarInsumoProductoDTO;
import com.panin.entidades.ComprasInsumo;
import com.panin.entidades.InsumoRecetas;
import com.panin.entidades.Producto;
import com.panin.entidades.Recetas;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.math.BigDecimal;
import javax.swing.table.DefaultTableModel;

public class ControladorProductos {

//	ConexionDB conexionDB;
//       @PersistenceContext(unitName = "com.panin_PaninTech")
//       private EntityManager em;
    Session session = HibernateUtil.getSessionFactory().openSession();

    public ControladorProductos() {
//		 conexionDB = new ConexionDB("jdbc:mysql://localhost:3306/panin","root","root");
//		session.beginTransaction();

    }

    //Ejemplo de metodo para obtener todos los productos de la db
    public List<Producto> obtenerProductos() {

        session.beginTransaction();

        List<Producto> productos;
        
         TypedQuery query = session.getNamedQuery("Producto.findAll");
        productos = query.getResultList();

        session.getTransaction().commit();
        //No cerrar la session mientras se piense utilizar mas metodos con query o generara una excepcion
        session.close();

        return productos;
          
        }
         
          public void actualizarProducto(Producto producto){
            
            session.beginTransaction();

            session.update(producto);
            
            session.getTransaction().commit();

            
        }
         
         public void borrarProducto(Producto producto){
            		
            session.beginTransaction();
            
            session.delete(producto);
                        
            session.getTransaction().commit();
            
            if(producto.getTipo().toString().equalsIgnoreCase("Elaborado")){
                
                 ControladorReceta cr = new ControladorReceta();
                Recetas r = cr.obtenerRecetaPorId(producto.getIdReceta());
                cr.borrarReceta(r);
            }
            
        }
	
     public BigDecimal calcularPrecioProduccion(Producto producto, double cantidad, DefaultTableModel... modelTable ){

        this.cerrarSesion();
        List<formAgregarInsumoProductoDTO> listaInsumosReceta = new ArrayList<formAgregarInsumoProductoDTO>();
        
        ControladorReceta cr = new ControladorReceta();
        Recetas r = new Recetas();
        r = cr.obtenerRecetaPorId(producto.getIdReceta());
        
        double cantidadReceta = r.getCantidad();
        double cantidadCalculada = 0.0;
        double precioTotal = 0;
        double precio = 0.0;
        
        ControladorComprasInsumos cpi = new ControladorComprasInsumos();
         
        if(cantidadReceta > cantidad){
            cantidadCalculada =  cantidad / cantidadReceta;
        }
        else if(cantidadReceta < cantidad){
            cantidadCalculada = cantidad / cantidadReceta ;

        }
        else if(cantidadReceta == cantidad){
            cantidadCalculada = 1;
        }
        
//         List<InsumoRecetas> lir =  (List<InsumoRecetas>) r.getInsumoRecetasCollection();

           cr.abrirSesion();
           
           if(modelTable.length > 0 ){
              modelTable[0].setRowCount(0);

           }

        for(InsumoRecetas ir : r.getInsumoRecetasCollection()) {
                    	
              formAgregarInsumoProductoDTO dto = new formAgregarInsumoProductoDTO();
                    	
               dto.setCantidad(ir.getCantidad().doubleValue() * cantidadCalculada);
               dto.setInsumo(ir.getIdInsumo());
               dto.setUnidadMedidad(ir.getUnidadMedida());
                    	
               listaInsumosReceta.add(dto);
               
               ComprasInsumo ci = cpi.obtenerComprasdeUnInsumoUnico(ir.getIdInsumo());
               
//               
//               System.out.print("\nci.getPrecio() " + ci.getPrecio().toString());
//               System.out.print("\nir.getCantidad() " + ir.getCantidad().toString());
//               System.out.print("\n ci.getPrecio().multiply(ir.getCantidad()) " + ci.getPrecio().multiply(ir.getCantidad()).toString());
//
//               System.out.print("\ncantidadCalculada " + cantidadCalculada);
//               System.out.print("\n ci.getPrecio().multiply(ir.getCantidad()).multiply(BigDecimal.valueOf(cantidadCalculada)) " + ci.getPrecio().multiply(ir.getCantidad()).multiply(BigDecimal.valueOf(cantidadCalculada)));


               precioTotal = (ci.getPrecio().multiply(ir.getCantidad())).multiply(BigDecimal.valueOf(cantidadCalculada)).doubleValue();
               
//               System.out.print("\nprecioTotal " + precioTotal);

                if(modelTable.length > 0 ){
                                  
                   modelTable[0].addRow(new Object[]{dto.getInsumo(), dto.getUnidadMedidad(), dto.getCantidad()});

               }
                    	
            }
        
        BigDecimal bd = new BigDecimal(precioTotal);

        return bd;
    }
         
         
	public void abrirSesion(){
            
            session = HibernateUtil.getSessionFactory().openSession();

//            session.beginTransaction();
       
    }

    public List<Producto> obtenerProductosElaborados() {

        session.beginTransaction();

        List<Producto> productos;

        TypedQuery query = session.getNamedQuery("Producto.findByTipo");
        query.setParameter("tipo", tipoProducto.Elaborado);

        productos = query.getResultList();

        session.getTransaction().commit();
        //No cerrar la session mientras se piense utilizar mas metodos con query o generara una excepcion
        session.close();

        return productos;
    }

    public Producto obtenerProductoByReceta(Recetas receta) {

        session.beginTransaction();

        Producto producto;

        TypedQuery query = session.getNamedQuery("Producto.findByReceta");
        query.setParameter("receta", receta.getIdReceta());

        producto = (Producto) query.getSingleResult();

        session.getTransaction().commit();
        //No cerrar la session mientras se piense utilizar mas metodos con query o generara una excepcion
        session.close();

        return producto;
    }

    public void crearProducto(Producto producto) {

        session.beginTransaction();

        session.save(producto);

    }

   
    public void cerrarSesion() {

        session.close();

    }

}
