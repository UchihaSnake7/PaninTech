/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panin.controladores;

import com.panin.HibernateUtil;
import com.panin.entidades.InsumoRecetas;
import com.panin.entidades.Recetas;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author ricke
 */
public class ControladorReceta {
    
     Session session = HibernateUtil.getSessionFactory().openSession();
	
	public ControladorReceta(){
//		 conexionDB = new ConexionDB("jdbc:mysql://localhost:3306/panin","root","root");
//		session.beginTransaction();

	}
        
        public Recetas obtenerRecetaPorId(int idReceta){
           session = HibernateUtil.getSessionFactory().openSession();
           session.beginTransaction();

           Recetas r = new Recetas();
            
           Query query = session.getNamedQuery("Recetas.findByIdReceta"); 
           query.setParameter("idReceta", idReceta);
           r = (Recetas) query.getSingleResult();
                   
           
           session.getTransaction().commit();
           session.close();

           
           return r;
            
        }
        
        public int crearReceta(Recetas receta){
                       
            session.beginTransaction();

            return (Integer)session.save(receta);
            
        }
        
        public void agregarInsumoReceta(InsumoRecetas ir){
            
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(ir);
            session.getTransaction().commit();
            
            session.close();
            
        }
        
        public void borrarReceta(Recetas r){
                       
            session = HibernateUtil.getSessionFactory().openSession();

            session.beginTransaction();
            
            session.delete(r);
            
            session.getTransaction().commit();


        }
        
         public void abrirSesion() {
            
            session = HibernateUtil.getSessionFactory().openSession();
//            session.beginTransaction();
		
	}
        
        public void cerrarSesion() {
            
            session.close();
		
	}
	
    
}
