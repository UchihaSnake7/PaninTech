package com.panin.controladores;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.panin.HibernateUtil;
import com.panin.application.Application;
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
    
    public ControladorProductos() {
        
    }

    //Ejemplo de metodo para obtener todos los productos de la db
    public List<Producto> obtenerProductos() {
        Application.session.beginTransaction();
        
        List<Producto> productos;
        
        TypedQuery query = Application.session.getNamedQuery("Producto.findAll");
        productos = query.getResultList();
        
        Application.session.getTransaction().commit();
        
        return productos;
        
    }
    
    public void actualizarProducto(Producto producto) {
        
        Application.session.beginTransaction();
        
        Application.session.update(producto);
        
        Application.session.getTransaction().commit();
        
    }
    
    public void borrarProducto(Producto producto) {
        
        Application.session.beginTransaction();
        
        Application.session.delete(producto);
        
        Application.session.getTransaction().commit();
        
        if (producto.getTipo().toString().equalsIgnoreCase("Elaborado")) {
            
            ControladorReceta cr = new ControladorReceta();
            Recetas r = cr.obtenerRecetaPorId(producto.getIdReceta());
            cr.borrarReceta(r);
        }
        
    }
    
    public void abrirSesion() {

//         Application.session = HibernateUtil.getSessionFactory().openSession();
//
//         Application.session.beginTransaction();
    }
    
    public BigDecimal calcularPrecioProduccion(Producto producto, double cantidad, DefaultTableModel... modelTable) {

//        this.cerrarSesion();
        List<formAgregarInsumoProductoDTO> listaInsumosReceta = new ArrayList<formAgregarInsumoProductoDTO>();
        
        ControladorReceta cr = new ControladorReceta();
        Recetas r = new Recetas();
        r = cr.obtenerRecetaPorId(producto.getIdReceta());
        List<InsumoRecetas> listaInsumoReceta = cr.obtenerInsumosPorReceta(r);
        double cantidadReceta = r.getCantidad();
        double cantidadCalculada = 0.0;
        double precioTotal = 0;
        double precio = 0.0;
        
        ControladorComprasInsumos cpi = new ControladorComprasInsumos();
        
        if (cantidadReceta > cantidad) {
            cantidadCalculada = cantidad / cantidadReceta;
        } else if (cantidadReceta < cantidad) {
            cantidadCalculada = cantidad / cantidadReceta;
            
        } else if (cantidadReceta == cantidad) {
            cantidadCalculada = 1;
        }

//         List<InsumoRecetas> lir =  (List<InsumoRecetas>) r.getInsumoRecetasCollection();
//           cr.abrirSesion();
        if (modelTable.length > 0) {
            modelTable[0].setRowCount(0);
            
        }
        
        for (InsumoRecetas ir : listaInsumoReceta) {
            
            formAgregarInsumoProductoDTO dto = new formAgregarInsumoProductoDTO();
            
            dto.setCantidad(ir.getCantidad().doubleValue() * cantidadCalculada);
            dto.setInsumo(ir.getIdInsumo());
            dto.setUnidadMedidad(ir.getUnidadMedida());
            
            listaInsumosReceta.add(dto);
            
            ComprasInsumo ci = cpi.obtenerComprasdeUnInsumoUnico(ir.getIdInsumo());
            
            precioTotal = (ci.getPrecio().multiply(ir.getCantidad())).multiply(BigDecimal.valueOf(cantidadCalculada)).doubleValue();
            
            if (modelTable.length > 0) {
                
                modelTable[0].addRow(new Object[]{dto.getInsumo(), dto.getUnidadMedidad(), dto.getCantidad()});
                
            }
            
        }
        
        BigDecimal bd = new BigDecimal(precioTotal);
        
        return bd;
    }
    
    public List<Producto> obtenerProductosElaborados() {
        
        Application.session.beginTransaction();
        List<Producto> productos;
        
        TypedQuery query = Application.session.getNamedQuery("Producto.findByTipo");
        query.setParameter("tipo", tipoProducto.Elaborado);
        
        productos = query.getResultList();
        
        Application.session.getTransaction().commit();
        
        return query.getResultList();
    }
    
    public List<Producto> obtenerProductosComprados() {
        
        Application.session.beginTransaction();
        List<Producto> productos;
        
        TypedQuery query = Application.session.getNamedQuery("Producto.findByTipo");
        query.setParameter("tipo", tipoProducto.Comprado);
        
        productos = query.getResultList();
        
        Application.session.getTransaction().commit();
        
        return query.getResultList();
    }
    
    public void crearProducto(Producto producto) {
        
        Application.session.beginTransaction();
        
        Application.session.save(producto);
        
        Application.session.getTransaction().commit();
        
    }
    
    public void cerrarSesion() {

//             Application.session.getTransaction().commit();
//         Application.session.close();
    }
    
    public Producto obtenerProductoByReceta(Recetas receta) {

//        if (! Application.session.getTransaction().getStatus().equals("ACTIVA")) {
//            session = HibernateUtil.getSessionFactory().openSession();
//        }
        Application.session.beginTransaction();
        
        List<Producto> producto;
        
        TypedQuery query = Application.session.getNamedQuery("Producto.findByReceta");
        query.setParameter("receta", receta.getIdReceta());
        
        producto = query.getResultList();
        
        Application.session.getTransaction().commit();
        if (producto.isEmpty()) {
            return null;
        }
        return producto.get(0);
    }
    
    public Producto obtenerProductoById(Integer id) {

//        if (! Application.session.getTransaction().getStatus().equals("ACTIVA")) {
//            session = HibernateUtil.getSessionFactory().openSession();
//        }
        Application.session.beginTransaction();
        
        Producto producto;
        
        TypedQuery query = Application.session.getNamedQuery("Producto.findById");
        query.setParameter("id", id);
        
        producto = (Producto) query.getSingleResult();
        
        Application.session.getTransaction().commit();
        
        return producto;
    }
    
    public boolean update(Producto producto) {
        try {
            Application.session.beginTransaction();
            Application.session.merge(producto);
            System.out.println("Sesion "
                    + Application.session.getTransaction().getStatus());
            Application.session.getTransaction().commit();
            return true;
            
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        
    }
    
    public boolean delete(Producto producto) {
        try {
            Application.session.beginTransaction();
            Application.session.delete(producto);
            
            Application.session.getTransaction().commit();
            return true;
            
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        
    }
}
