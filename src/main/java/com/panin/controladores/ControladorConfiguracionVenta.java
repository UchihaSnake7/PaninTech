/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panin.controladores;

import com.panin.HibernateUtil;
import com.panin.application.Application;
import com.panin.entidades.ConfiguracionVenta;
import com.panin.entidades.InsumoRecetas;
import com.panin.entidades.Producto;
import com.panin.entidades.ProductoConfiguracionVenta;
import com.panin.entidades.Recetas;
import jakarta.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author ricke
 */
public class ControladorConfiguracionVenta {

    public ControladorConfiguracionVenta() {
//		 

    }

    public Recetas obtenerRecetaPorId(int idReceta) {

        Application.session.beginTransaction();

        Recetas r = new Recetas();

        Query query = Application.session.getNamedQuery("Recetas.findByIdReceta");
        query.setParameter("idReceta", idReceta);
        r = (Recetas) query.getSingleResult();

        Application.session.getTransaction().commit();

        return r;

    }
    
    public List<InsumoRecetas> obtenerInsumosPorReceta(Recetas r) {

        Application.session.beginTransaction();

        List<InsumoRecetas> lista = new ArrayList<InsumoRecetas>();

        Query query = Application.session.getNamedQuery("InsumoRecetas.findByReceta");
        query.setParameter("receta", r);
        lista = query.getResultList();

        Application.session.getTransaction().commit();

        return lista;

    }

    public int crearConfiguracionVenta(ConfiguracionVenta configuracionVenta) {

        Application.session.beginTransaction();

        int id = (int) Application.session.save(configuracionVenta);
        Application.session.getTransaction().commit();
        return id;

    }

    public ProductoConfiguracionVenta crearConfiguracionVentaProducto(ConfiguracionVenta cv, Producto p) {

        ProductoConfiguracionVenta pcv = new ProductoConfiguracionVenta();
        pcv.setConfiguracionVenta(cv);
        pcv.setProducto(p);
        
        Application.session.beginTransaction();
        int id = (int) Application.session.save(pcv);
        Application.session.getTransaction().commit();
        pcv.setId(id);
        return pcv;

    }


}
