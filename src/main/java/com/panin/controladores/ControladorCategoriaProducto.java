/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panin.controladores;

import com.panin.application.Application;
import com.panin.entidades.CategoriaProducto;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class ControladorCategoriaProducto {
    
    
        public List<CategoriaProducto> obtenerTodos() {
        Application.session.beginTransaction();
        List<CategoriaProducto> lista;

        TypedQuery query =  Application.session.getNamedQuery("CategoriaProducto.findAll");

        lista = query.getResultList();

        Application.session.getTransaction().commit();
   
        return lista;

    }

    
}
