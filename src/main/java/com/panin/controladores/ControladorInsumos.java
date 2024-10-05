/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panin.controladores;

import com.panin.HibernateUtil;
import com.panin.entidades.Insumo;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author USUARIO
 */
public class ControladorInsumos {

    Session session = HibernateUtil.getSessionFactory().openSession();

    public ControladorInsumos() {
//		 conexionDB = new ConexionDB("jdbc:mysql://localhost:3306/panin","root","root");

    }

    //Ejemplo de metodo para obtener todos los productos de la db
    public List<Insumo> obtenerInsumos() {
        session.beginTransaction();
        List<Insumo> insumos;

        TypedQuery query = session.getNamedQuery("Insumo.findAll");
        insumos = query.getResultList();

        session.getTransaction().commit();
        //No cerrar la session mientras se piense utilizar mas metodos con query o generara una excepcion
//                session.close();
        session.close();
        return insumos;
    }

    public boolean save(Insumo insumo) {
        try {
            session.beginTransaction();
            session.save(insumo);
            System.out.println(session.getTransaction().getStatus());
            session.close();
            return true;

        } catch (Exception e) {
            return false;
        }

    }

    public void cerrarSesion() {
        session.close();

    }

}
