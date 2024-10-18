/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panin.controladores;

import com.panin.application.Application;
import com.panin.entidades.ConversionDivisa;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class ControladorConversionDivisa {

    public ControladorConversionDivisa() {

    }

    public List<ConversionDivisa> obtenerTodos() {
        Application.session.beginTransaction();
        List<ConversionDivisa> lista;

        TypedQuery query =  Application.session.getNamedQuery("ConverionDivisa.findAll");

        lista = query.getResultList();

        Application.session.getTransaction().commit();
   
        return lista;

    }

    public void cerrarSesion() {
//         Application.session.close();

    }
}
