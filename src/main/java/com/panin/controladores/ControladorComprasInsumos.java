/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panin.controladores;

import com.panin.HibernateUtil;
import com.panin.entidades.ComprasInsumo;
import com.panin.entidades.Insumo;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author USUARIO
 */
public class ControladorComprasInsumos {

    Session session = HibernateUtil.getSessionFactory().openSession();

    public ControladorComprasInsumos() {
    }

    public List<ComprasInsumo> obtenerInsumos() {
        session.beginTransaction();
        List<ComprasInsumo> comprasInsumos;

        TypedQuery query = session.getNamedQuery("ComprasInsumo.findAll");
        comprasInsumos = query.getResultList();

        session.getTransaction().commit();
        //No cerrar la session mientras se piense utilizar mas metodos con query o generara una excepcion
//                session.close();
        session.close();
        return comprasInsumos;
    }

    public boolean save(ComprasInsumo compra) {
        try {
            session.beginTransaction();
            session.save(compra);
            System.out.println(session.getTransaction().getStatus());
            session.close();
            return true;

        } catch (Exception e) {
            return false;
        }

    }
}

//Ejemplo de metodo para obtener todos los productos de la db

