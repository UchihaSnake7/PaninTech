/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panin.controladores;

import com.panin.HibernateUtil;
import com.panin.entidades.Insumo;
import com.panin.entidades.TipoMedida;
import com.panin.entidades.UnidadMedida;
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

    }

    //Ejemplo de metodo para obtener todos los productos de la db
    public List<TipoMedida> obtenerTipoMedida() {
        session.beginTransaction();
        List<TipoMedida> tiposMedida;

        TypedQuery query = session.getNamedQuery("TipoMedida.findAll");
        tiposMedida = query.getResultList();

        session.getTransaction().commit();
        //No cerrar la session mientras se piense utilizar mas metodos con query o generara una excepcion
//                session.close();
        session.close();
        return tiposMedida;

    }

    public void cerrarSesion() {
        session.close();

    }

}
