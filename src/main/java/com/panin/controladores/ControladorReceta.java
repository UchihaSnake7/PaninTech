/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panin.controladores;

import com.panin.HibernateUtil;
import com.panin.entidades.InsumoRecetas;
import com.panin.entidades.Recetas;
import org.hibernate.Session;

/**
 *
 * @author ricke
 */
public class ControladorReceta {
    
    
    
     Session session = HibernateUtil.getSessionFactory().openSession();

	
	public ControladorReceta(){
//		 conexionDB = new ConexionDB("jdbc:mysql://localhost:3306/panin","root","root");
		session.beginTransaction();

	}
        
        public int crearReceta(Recetas receta){
            
            return (Integer)session.save(receta);
            
        }
        
        public void agregarInsumoReceta(InsumoRecetas ir){
            
            session.save(ir);
            
        }
        
        
        
        public void cerrarSesion() {
            
//            session.getTransaction().commit();
            session.close();
		
	}
	
    
}
