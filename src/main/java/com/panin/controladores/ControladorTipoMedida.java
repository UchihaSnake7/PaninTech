/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panin.controladores;

import com.panin.HibernateUtil;
import com.panin.application.Application;
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


    public ControladorTipoMedida() {

    }

    //Ejemplo de metodo para obtener todos los productos de la db
    public List<TipoMedida> obtenerTipoMedida() {
         
        Application.session.beginTransaction();
        List<TipoMedida> tiposMedida;

        TypedQuery query =  Application.session.getNamedQuery("TipoMedida.findAll");
        tiposMedida = query.getResultList();

         Application.session.getTransaction().commit();
     
         Application.session.close();
         
        return tiposMedida;

    }

    public void cerrarSesion() {
//         Application.session.close();

    }

}
