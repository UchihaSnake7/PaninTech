/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panin.controladores;

import com.panin.HibernateUtil;
import com.panin.application.Application;
import com.panin.entidades.Insumo;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author USUARIO
 */
public class ControladorInsumos {

//    Session session = HibernateUtil.getSessionFactory().openSession();

    public ControladorInsumos() {

    }

    public Insumo obtenerInsumobyId(Integer id) {
         
        Application.session.beginTransaction();
        Insumo insumo;

        TypedQuery query =  Application.session.getNamedQuery("Insumo.findById");
        query.setParameter("id", id);
        insumo = (Insumo) query.getSingleResult();

         Application.session.getTransaction().commit();
     
        return insumo;
    }

    public List<Insumo> obtenerInsumos() {
         
        Application.session.beginTransaction();
        List<Insumo> insumos;

        TypedQuery query =  Application.session.getNamedQuery("Insumo.findAll");
        insumos = query.getResultList();

         Application.session.getTransaction().commit();
      
        return insumos;
    }

    public boolean save(Insumo insumo) {
        try {
             Application.session.beginTransaction();
             Application.session.save(insumo);
             Application.session.getTransaction().commit();
            return true;

        } catch (Exception e) {
            return false;
        }

    }

    public boolean update(Insumo insumo) {
        try {
             Application.session.beginTransaction();
             Application.session.merge(insumo);
            System.out.println("Sesion "
                    +  Application.session.getTransaction().getStatus());
             Application.session.getTransaction().commit();
            return true;

        } catch (Exception e) {
            System.out.println(e);
            return false;
        }

    }

    public boolean delete(Insumo insumo) {
        try {
             Application.session.beginTransaction();
             Application.session.delete(insumo);

             Application.session.getTransaction().commit();
            return true;

        } catch (Exception e) {
            System.out.println(e);
            return false;
        }

    }

    public void abrirSesion() {

//   Application.session. = HibernateUtil.getSessionFactory().openSession();

    }

    public void cerrarSesion() {
         Application.session.close();

    }

}
