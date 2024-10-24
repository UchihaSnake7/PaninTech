/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panin.controladores;

import com.panin.application.Application;
import com.panin.entidades.MetodoPago;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class ControladorMetodoPago {

    public List<MetodoPago> obtenerTodos() {
        Application.session.beginTransaction();
        List<MetodoPago> lista;

        TypedQuery query = Application.session.getNamedQuery("MetodoPago.findAll");

        lista = query.getResultList();

        Application.session.getTransaction().commit();

        return lista;

    }

    public List<MetodoPago> obtenerActivos() {
        Application.session.beginTransaction();
        List<MetodoPago> lista;

        TypedQuery query = Application.session.getNamedQuery("MetodoPago.findByActivo");
        query.setParameter("activo", true);
        lista = query.getResultList();

        Application.session.getTransaction().commit();

        return lista;

    }

    public void crearMetodoPago(MetodoPago mp) {

        Application.session.beginTransaction();

        Application.session.save(mp);

        Application.session.getTransaction().commit();
    }

    public boolean update(MetodoPago mp) {
        try {
            Application.session.beginTransaction();
            Application.session.merge(mp);

            Application.session.getTransaction().commit();
            return true;

        } catch (Exception e) {
            System.out.println(e);
            return false;
        }

    }

    public MetodoPago obtenerMetodoById(int id) {
        Application.session.beginTransaction();
        MetodoPago mp;
        TypedQuery query = Application.session.getNamedQuery("MetodoPago.findById");
        query.setParameter("id", id);
        mp = (MetodoPago) query.getSingleResult();

        Application.session.getTransaction().commit();
        return mp;
    }

    public boolean delete(MetodoPago mp) {
        try {
            Application.session.beginTransaction();
            Application.session.delete(mp);

            Application.session.getTransaction().commit();
            return true;

        } catch (Exception e) {
            System.out.println(e);
            return false;
        }

    }

}
