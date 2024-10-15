/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panin.controladores;

import com.panin.HibernateUtil;
import com.panin.application.Application;
import com.panin.entidades.Conversion;
import com.panin.entidades.UnidadMedida;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author USUARIO
 */
public class ControladorConversion {

    public ControladorConversion() {
//		 conexionDB = new ConexionDB("jdbc:mysql://localhost:3306/panin","root","root");

    }

    public List<Conversion> obtenerTipoMedida() {
         Application.session.beginTransaction();
        List<Conversion> Conversion;

        TypedQuery query =  Application.session.getNamedQuery("Conversion.findAll");

        Conversion = query.getResultList();

         Application.session.getTransaction().commit();
        //No cerrar la session mientras se piense utilizar mas metodos con query o generara una excepcion
//                 Application.session.close();
         Application.session.close();
        return Conversion;

    }

    public Conversion obtenerFactorConversion(UnidadMedida base, UnidadMedida derivada) {
         Application.session.beginTransaction();
        List<Conversion> Conversion;

        TypedQuery query =  Application.session.getNamedQuery("Conversion.findByConversionUnidadBase");
      
        query.setParameter("unidadBase", base);
        query.setParameter("unidadDerivada", derivada);

        Conversion = query.getResultList();

//        if (Conversion.size() == 0) {
//            Conversion.add(unidadMedida);
//        }
         Application.session.getTransaction().commit();

         Application.session.close();
        return Conversion.get(0);

    }

    public void cerrarSesion() {
         Application.session.close();

    }
}
