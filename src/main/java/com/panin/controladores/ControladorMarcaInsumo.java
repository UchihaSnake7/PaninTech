/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panin.controladores;

import com.panin.HibernateUtil;
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

    Session session = HibernateUtil.getSessionFactory().openSession();

    public ControladorMarcaInsumo() {
    }

    public List<MarcaInsumo> obtenerMarcasInsumos() {
        session.beginTransaction();
        List<MarcaInsumo> marcas;

        TypedQuery query = session.getNamedQuery("MarcaInsumo.findAll");
        marcas = query.getResultList();

        session.getTransaction().commit();
        //No cerrar la session mientras se piense utilizar mas metodos con query o generara una excepcion
//                session.close();
        session.close();
        return marcas;
    }

    public boolean save(MarcaInsumo marca) {

        try {
            session.beginTransaction();
            session.save(marca);
            session.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
