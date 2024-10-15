/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panin.controladores;

import com.panin.HibernateUtil;
import com.panin.application.Application;
import com.panin.entidades.UnidadMedida;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author USUARIO
 */
public class ControladorUnidadMedida {


    public ControladorUnidadMedida() {

    }

    public List<UnidadMedida> obtenerTipoMedida() {
         
        Application.session.beginTransaction();
        List<UnidadMedida> UnidadesMedida;

        TypedQuery query =  Application.session.getNamedQuery("UnidadMedida.findAll");

        UnidadesMedida = query.getResultList();

         Application.session.getTransaction().commit();
     
        return UnidadesMedida;

    }

    public UnidadMedida obtenerUnidadBase(UnidadMedida unidadMedida) {
//        try {
//             Application.session.beginTransaction();
//        } catch (Exception e) {
//            session = HibernateUtil.getSessionFactory().openSession();
//             Application.session.beginTransaction();
//        }
        
        Application.session.beginTransaction();

        List<UnidadMedida> UnidadesMedida;

        TypedQuery query =  Application.session.getNamedQuery("UnidadMedida.findByBase");
        query.setParameter("unidadBase", true);
        query.setParameter("idTipo", unidadMedida.getIdTipo());
        UnidadesMedida = query.getResultList();

        if (UnidadesMedida.size() == 0) {
            UnidadesMedida.add(unidadMedida);
        }
         Application.session.getTransaction().commit();

        return UnidadesMedida.get(0);

    }

    public void cerrarSesion() {
//         Application.session.close();

    }
}
