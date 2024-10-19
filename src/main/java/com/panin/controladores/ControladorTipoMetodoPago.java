/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panin.controladores;

import com.panin.application.Application;
import com.panin.entidades.TipoMetodoPago;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class ControladorTipoMetodoPago {
    
        public List<TipoMetodoPago> obtenerTodos() {
        Application.session.beginTransaction();
        List<TipoMetodoPago> lista;

        TypedQuery query =  Application.session.getNamedQuery("TipoMetodoPago.findAll");

        lista = query.getResultList();

        Application.session.getTransaction().commit();
   
        return lista;

    }

    
}
