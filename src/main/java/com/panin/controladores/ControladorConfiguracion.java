/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panin.controladores;

import com.panin.application.Application;
import com.panin.entidades.Configuracion;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class ControladorConfiguracion {

    public ControladorConfiguracion() {

    }

    public List<Configuracion> obtenerTodos() {
        Application.session.beginTransaction();
        List<Configuracion> configuraciones;

        TypedQuery query =  Application.session.getNamedQuery("Configuracion.findAll");

        configuraciones = query.getResultList();

        Application.session.getTransaction().commit();
   
        return configuraciones;

    }

    public Configuracion obtenerPorClave(String clave) {
         
        Application.session.beginTransaction();
        Configuracion configuracion;

        TypedQuery query =  Application.session.getNamedQuery("Configuracion.findByClave");
      
        query.setParameter("clave", clave);

        configuracion =  (Configuracion) query.getSingleResult();

         Application.session.getTransaction().commit();

        return configuracion;

    }

    public void cerrarSesion() {
//         Application.session.close();

    }
}
