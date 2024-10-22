/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panin.controladores;

import com.panin.application.Application;
import com.panin.entidades.MetodoPago;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class ControladorMetodoPago {
    
        public List<MetodoPago> obtenerTodos() {
        Application.session.beginTransaction();
        List<MetodoPago> lista;

        TypedQuery query =  Application.session.getNamedQuery("MetodoPago.findAll");

        lista = query.getResultList();

        Application.session.getTransaction().commit();
   
        return lista;

    }

        public void crearMetodoPago(MetodoPago mp){
            
            Application.session.beginTransaction();

            Application.session.save(mp);

            Application.session.getTransaction().commit();
        }
    
}
