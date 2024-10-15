package com.panin.controladores;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.apache.commons.codec.digest.DigestUtils;
import com.panin.HibernateUtil;
import com.panin.db.ConexionDB;
import com.panin.entidades.Usuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

public class ControladorUsuario {
	
//	ConexionDB conexionDB;
//       @PersistenceContext(unitName = "com.panin_PaninTech")
//       private EntityManager em;
       Session session = HibernateUtil.getSessionFactory().openSession();

	
	public ControladorUsuario(){
//		 conexionDB = new ConexionDB("jdbc:mysql://localhost:3306/panin","root","root");
		session.beginTransaction();

	}
	
	
	//Ejemplo de metodo para obtener todos los productos de la db
	public List<Usuario> obtenerUsuarios() {
		List<Usuario> Usuario;
			
                     TypedQuery query = session.getNamedQuery("Usuario.findAll");   
		        Usuario = query.getResultList();
	       
                session.getTransaction().commit();
                //No cerrar la session mientras se piense utilizar mas metodos con query o generara una excepcion
//                session.close();
                 
                return query.getResultList();
	}
        
         public void crearUsuario(Usuario usuario){
            
            session.save(usuario);
            
        }
	
	
	public void cerrarSesion() {
            
//            session.getTransaction().commit();
            session.close();
		
	}
      
        
      
       
   
	

}
