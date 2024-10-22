/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panin.controladores;

import com.panin.application.Application;
import com.panin.entidades.Configuracion;
import com.panin.entidades.Producto;
import com.panin.entidades.Recetas;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class ControladorConfiguracion {

    public ControladorConfiguracion() {

    }

    public static Configuracion obtener() {
        Application.session.beginTransaction();
        Configuracion configuracion;

        TypedQuery query =  Application.session.getNamedQuery("Configuracion.findAll");

        configuracion = (Configuracion) query.getResultList().get(0);

        Application.session.getTransaction().commit();
   
        return configuracion;

    }

     public void save(Configuracion conf) {

        Application.session.beginTransaction();
        Application.session.save(conf);
        Application.session.getTransaction().commit();

    }
     
      public boolean update(Configuracion conf) {
        try {
            Application.session.beginTransaction();
            Application.session.merge(conf);
            Application.session.getTransaction().commit();
            return true;

        } catch (Exception e) {
            System.out.println(e);
            return false;
        }

    }
    
    public void cerrarSesion() {
//         Application.session.close();

    }
}
