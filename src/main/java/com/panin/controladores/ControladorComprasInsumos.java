/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panin.controladores;

import com.panin.HibernateUtil;
import com.panin.application.Application;
import com.panin.entidades.ComprasInsumo;
import com.panin.entidades.Insumo;
import jakarta.persistence.TypedQuery;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author USUARIO
 */
public class ControladorComprasInsumos {

//    Session session = HibernateUtil.getSessionFactory().openSession();
    public ControladorComprasInsumos() {
//          Application.session.beginTransaction();
    }

    public List<ComprasInsumo> obtenerComprasInsumos() {

        Application.session.beginTransaction();
        List<ComprasInsumo> comprasInsumos;

        TypedQuery query = Application.session.getNamedQuery("ComprasInsumo.findAll");
        comprasInsumos = query.getResultList();

        Application.session.getTransaction().commit();

//         Application.session.close();
        return comprasInsumos;
    }

    public List<ComprasInsumo> obtenerComprasdeUnInsumo(Insumo insumo) {

        Application.session.beginTransaction();
        List<ComprasInsumo> comprasInsumos;

        TypedQuery query = Application.session.getNamedQuery("ComprasInsumo.findByInsumo");
        query.setParameter("insumo", insumo);
        comprasInsumos = query.getResultList();

        Application.session.getTransaction().commit();

        return comprasInsumos;
    }

    public void cerrarSesion() {
//             Application.session.close();
    }

    public ComprasInsumo obtenerComprasdeUnInsumoUnico(Insumo insumo) {
        ComprasInsumo comprasInsumos;
       
        Application.session.beginTransaction();
        TypedQuery query = Application.session.getNamedQuery("ComprasInsumo.findByInsumoUnico");
        query.setParameter("insumo", insumo);
        query.setMaxResults(1);
        comprasInsumos = (ComprasInsumo) query.getSingleResult();
        Application.session.getTransaction().commit();

        return comprasInsumos;
    }

    public boolean save(ComprasInsumo compra) {
        try {
            Application.session.beginTransaction();
            Application.session.save(compra);
            System.out.println(Application.session.getTransaction().getStatus());
//             Application.session.close();
            Application.session.getTransaction().commit();
            return true;

        } catch (Exception e) {
            return false;
        }

    }

    public List<ComprasInsumo> obtenerComprasDesde(Insumo insumo, Date date) {

        Application.session.beginTransaction();
        List<ComprasInsumo> comprasInsumos;

        TypedQuery query = Application.session.getNamedQuery("ComprasInsumo.findByInsumoDesde");
        query.setParameter("insumo", insumo);
        query.setParameter("desde", date);
        comprasInsumos = query.getResultList();

        Application.session.getTransaction().commit();

        return comprasInsumos;
    }

    public List<ComprasInsumo> obtenerComprasDesdeHasta(Insumo insumo, Date date, Date hasta) {

        Application.session.beginTransaction();
        List<ComprasInsumo> comprasInsumos;

        TypedQuery query = Application.session.getNamedQuery("ComprasInsumo.findByInsumoFechas");
        query.setParameter("insumo", insumo);
        query.setParameter("desde", date);
        query.setParameter("hasta", hasta);
        comprasInsumos = query.getResultList();

        Application.session.getTransaction().commit();

        return comprasInsumos;
    }

    public List<ComprasInsumo> obtenerComprasHasta(Insumo insumo, Date hasta) {

        Application.session.beginTransaction();
        List<ComprasInsumo> comprasInsumos;

        TypedQuery query = Application.session.getNamedQuery("ComprasInsumo.findByInsumoHasta");
        query.setParameter("insumo", insumo);

        query.setParameter("hasta", hasta);
        comprasInsumos = query.getResultList();

        Application.session.getTransaction().commit();

        return comprasInsumos;
    }

    public List<ComprasInsumo> obtenerComprasInsumosFecha(Date desde, Date hasta) {

        Application.session.beginTransaction();
        List<ComprasInsumo> comprasInsumos;

        TypedQuery query = Application.session.getNamedQuery("ComprasInsumo.findByFechas");
        query.setParameter("desde", desde);

        query.setParameter("hasta", hasta);
        comprasInsumos = query.getResultList();

        Application.session.getTransaction().commit();

        return comprasInsumos;
    }

    public List<ComprasInsumo> obtenerComprasInsumosHasta(Date hasta) {

        Application.session.beginTransaction();
        List<ComprasInsumo> comprasInsumos;

        TypedQuery query = Application.session.getNamedQuery("ComprasInsumo.findByHasta");

        query.setParameter("hasta", hasta);
        comprasInsumos = query.getResultList();

        Application.session.getTransaction().commit();

        return comprasInsumos;

    }

    public List<ComprasInsumo> obtenerComprasInsumosDesde(Date desde) {

        Application.session.beginTransaction();
        List<ComprasInsumo> comprasInsumos;

        TypedQuery query = Application.session.getNamedQuery("ComprasInsumo.findByDesde");

        query.setParameter("desde", desde);
        comprasInsumos = query.getResultList();

        Application.session.getTransaction().commit();

        return comprasInsumos;

    }
}
