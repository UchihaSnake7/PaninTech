package com.panin.controladores;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.apache.commons.codec.digest.DigestUtils;
import com.panin.HibernateUtil;
import com.panin.application.Application;
import com.panin.db.ConexionDB;
import com.panin.entidades.Usuarios;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

public class ControladorUsuario {
	
//	ConexionDB conexionDB;
//       @PersistenceContext(unitName = "com.panin_PaninTech")
//       private EntityManager em;
//       Session session = HibernateUtil.getSessionFactory().openSession();

	
	public ControladorUsuario(){
//		 conexionDB = new ConexionDB("jdbc:mysql://localhost:3306/panin","root","root");
//		 Application.session.beginTransaction();

	}
	
	
	//Ejemplo de metodo para obtener todos los productos de la db
	public List<Usuarios> obtenerUsuarios() {
		List<Usuarios> Usuario;
                
                Application.session.beginTransaction();
			
                     TypedQuery query =  Application.session.getNamedQuery("Usuarios.findAll");   
		        Usuario = query.getResultList();
	       
                  Application.session.getTransaction().commit();
                //No cerrar la session mientras se piense utilizar mas metodos con query o generara una excepcion
//                 Application.session.close();
                 
                return query.getResultList();
	}
        
         public void crearUsuario(Usuarios usuario){
            
              Application.session.save(usuario);
            
        }
	
	
	public void cerrarSesion() {
            
//             Application.session.getTransaction().commit();
             Application.session.close();
		
	}
      
        
      
       
   
	

}
