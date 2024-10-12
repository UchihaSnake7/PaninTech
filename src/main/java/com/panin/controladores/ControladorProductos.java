package com.panin.controladores;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.panin.HibernateUtil;
import com.panin.application.utilities.tipoProducto;
import com.panin.db.ConexionDB;
import com.panin.entidades.Producto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

public class ControladorProductos {
	
//	ConexionDB conexionDB;
//       @PersistenceContext(unitName = "com.panin_PaninTech")
//       private EntityManager em;
       Session session = HibernateUtil.getSessionFactory().openSession();

	
	public ControladorProductos(){
//		 conexionDB = new ConexionDB("jdbc:mysql://localhost:3306/panin","root","root");
		session.beginTransaction();

	}
	
	
	//Ejemplo de metodo para obtener todos los productos de la db
	public List<Producto> obtenerProductos() {
		List<Producto> productos;
			
                TypedQuery query = session.getNamedQuery("Producto.findAll");   
		productos = query.getResultList();
	       
                session.getTransaction().commit();
                //No cerrar la session mientras se piense utilizar mas metodos con query o generara una excepcion
//                session.close();
                
                return query.getResultList();
	}
        
        public List<Producto> obtenerProductosElaborados() {
		List<Producto> productos;
			
                TypedQuery query = session.getNamedQuery("Producto.findByTipo"); 
                query.setParameter("tipo", tipoProducto.Elaborado);

		productos = query.getResultList();
	       
                session.getTransaction().commit();
                //No cerrar la session mientras se piense utilizar mas metodos con query o generara una excepcion
//                session.close();
                
                return query.getResultList();
	}
        
         public void crearProducto(Producto producto){
            
            session.save(producto);
            
        }
	
	
	public void cerrarSesion() {
            
//            session.getTransaction().commit();
            session.close();
		
	}
	

}