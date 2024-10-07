/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panin.controladores;

import com.panin.HibernateUtil;
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
        Session session = HibernateUtil.getSessionFactory().openSession();

    public ControladorConversion() {
//		 conexionDB = new ConexionDB("jdbc:mysql://localhost:3306/panin","root","root");

    }

    public List<Conversion> obtenerTipoMedida() {
        session.beginTransaction();
        List<Conversion> Conversion;

        TypedQuery query = session.getNamedQuery("Conversion.findAll");

        Conversion = query.getResultList();

        session.getTransaction().commit();
        //No cerrar la session mientras se piense utilizar mas metodos con query o generara una excepcion
//                session.close();
        session.close();
        return Conversion;

    }

    public Conversion obtenerUnidadBase(UnidadMedida base, UnidadMedida derivada) {
        session.beginTransaction();
        List<Conversion> Conversion;

        TypedQuery query = session.getNamedQuery("Conversion.findByConversionUnidadBase");
      
        query.setParameter("unidadBase", base);
        query.setParameter("unidadDerivada", derivada);

        Conversion = query.getResultList();

//        if (Conversion.size() == 0) {
//            Conversion.add(unidadMedida);
//        }
        session.getTransaction().commit();

        session.close();
        return Conversion.get(0);

    }

    public void cerrarSesion() {
        session.close();

    }
}
