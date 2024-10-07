/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panin.controladores;

import com.panin.HibernateUtil;
import com.panin.entidades.UnidadMedida;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author USUARIO
 */
public class ControladorUnidadMedida {

    Session session = HibernateUtil.getSessionFactory().openSession();

    public ControladorUnidadMedida() {
//		 conexionDB = new ConexionDB("jdbc:mysql://localhost:3306/panin","root","root");

    }

    public List<UnidadMedida> obtenerTipoMedida() {
        session.beginTransaction();
        List<UnidadMedida> UnidadesMedida;

        TypedQuery query = session.getNamedQuery("UnidadMedida.findAll");

        UnidadesMedida = query.getResultList();

        session.getTransaction().commit();
        //No cerrar la session mientras se piense utilizar mas metodos con query o generara una excepcion
//                session.close();
        session.close();
        return UnidadesMedida;

    }

    public UnidadMedida obtenerUnidadBase(UnidadMedida unidadMedida) {
        session.beginTransaction();
        List<UnidadMedida> UnidadesMedida;

        TypedQuery query = session.getNamedQuery("UnidadMedida.findByBase");
        query.setParameter("unidadBase", true);
        query.setParameter("idTipo", unidadMedida.getIdTipo());
        UnidadesMedida = query.getResultList();

        if (UnidadesMedida.size() == 0) {
            UnidadesMedida.add(unidadMedida);
        }
        session.getTransaction().commit();

        session.close();
        return UnidadesMedida.get(0);

    }

    public void cerrarSesion() {
        session.close();

    }
}
