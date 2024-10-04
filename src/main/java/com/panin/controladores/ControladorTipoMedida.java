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
public class ControladorTipoMedida {

    Session session = HibernateUtil.getSessionFactory().openSession();

    public ControladorTipoMedida() {
//		 conexionDB = new ConexionDB("jdbc:mysql://localhost:3306/panin","root","root");
        session.beginTransaction();

    }

    //Ejemplo de metodo para obtener todos los productos de la db
//    public List<Insumo> obtenerInsumos() {
//        List<Insumo> insumos;
//
//        TypedQuery query = session.getNamedQuery("Insumo.findAll");
//        insumos = query.getResultList();
//
//        session.getTransaction().commit();
//        //No cerrar la session mientras se piense utilizar mas metodos con query o generara una excepcion
////                session.close();
//
//        return query.getResultList();
//    }

    public void cerrarSesion() {
        session.close();

    }

}
