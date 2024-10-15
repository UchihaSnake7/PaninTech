/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panin.controladores;

import com.panin.HibernateUtil;
import com.panin.application.Application;
import com.panin.entidades.ComprasInsumo;
import com.panin.entidades.MarcaInsumo;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author USUARIO
 */
public class ControladorMarcaInsumo {


    public ControladorMarcaInsumo() {
    }

    public List<MarcaInsumo> obtenerMarcasInsumos() {
         
        Application.session.beginTransaction();
        List<MarcaInsumo> marcas;

        TypedQuery query =  Application.session.getNamedQuery("MarcaInsumo.findAll");
        marcas = query.getResultList();

         Application.session.getTransaction().commit();
      
        return marcas;
    }

    public boolean save(MarcaInsumo marca) {

        try {
             Application.session.beginTransaction();
             Application.session.save(marca);
             Application.session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
