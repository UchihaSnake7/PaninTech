/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panin.controladores;

import com.panin.HibernateUtil;
import com.panin.application.Application;
import com.panin.entidades.InsumoRecetas;
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
public class ControladorReceta {

    public ControladorReceta() {
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

    public int crearReceta(Recetas receta) {

        Application.session.beginTransaction();

        int id = (int) Application.session.save(receta);
        Application.session.getTransaction().commit();
        return id;

    }

    public void agregarInsumoReceta(InsumoRecetas ir) {

        Application.session.beginTransaction();
        Application.session.save(ir);
        Application.session.getTransaction().commit();

//             Application.session.close();
    }

    public void borrarReceta(Recetas r) {

        Application.session.beginTransaction();

        Application.session.delete(r);

        Application.session.getTransaction().commit();

    }

    public void abrirSesion() {

//             Application.session.beginTransaction();
    }

    public void cerrarSesion() {

//             Application.session.close();
    }

}
