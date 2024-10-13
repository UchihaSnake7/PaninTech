/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panin.controladores;

import com.panin.HibernateUtil;
import com.panin.entidades.Conversion;
import com.panin.entidades.Insumo;
import com.panin.entidades.InsumoRecetas;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author USUARIO
 */
public class ControladorInsumoReceta {

    Session session = HibernateUtil.getSessionFactory().openSession();

    public ControladorInsumoReceta() {

    }

    public List<InsumoRecetas> obtenerRecetasInsumos(Insumo insumo) {
        session.beginTransaction();
        List<InsumoRecetas> InsumosRecetas;

        TypedQuery query = session.getNamedQuery("InsumoRecetas.findByInsumo");
        query.setParameter("insumo", insumo);
        InsumosRecetas = query.getResultList();

        session.getTransaction().commit();

        session.close();
        return InsumosRecetas;

    }

}
