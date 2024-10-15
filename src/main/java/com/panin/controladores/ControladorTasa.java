package com.panin.controladores;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.panin.HibernateUtil;
import com.panin.application.Application;
import com.panin.db.ConexionDB;
import com.panin.entidades.Tasa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

public class ControladorTasa {
	

	
	public ControladorTasa(){

	}
	
	
	//Ejemplo de metodo para obtener todos los productos de la db
	public List<Tasa> obtenerTasas() {
                         
            Application.session.beginTransaction();

		List<Tasa> Tasas;
			
                     TypedQuery query =  Application.session.getNamedQuery("Tasa.findAll");   
		        Tasas = query.getResultList();
	       
                 Application.session.getTransaction().commit();
               
                
                return query.getResultList();
	}
        
         public void crearTasa(Tasa tasa){
             
             Application.session.beginTransaction();
            
             Application.session.save(tasa);
             
             Application.session.getTransaction().commit();

        }
	
	
	public void cerrarSesion() {
            
//             Application.session.close();
		
	}
	

}