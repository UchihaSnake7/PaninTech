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

    public static Configuracion obtener() {
        Application.session.beginTransaction();
        Configuracion configuracion;

        TypedQuery query =  Application.session.getNamedQuery("Configuracion.findAll");

        configuracion = (Configuracion) query.getResultList().get(0);

        Application.session.getTransaction().commit();
   
        return configuracion;

    }

    public void cerrarSesion() {
//         Application.session.close();

    }
}
