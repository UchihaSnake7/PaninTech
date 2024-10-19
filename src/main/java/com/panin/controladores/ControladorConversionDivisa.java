/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panin.controladores;

import com.panin.application.Application;
import com.panin.entidades.ConversionDivisa;
import com.panin.entidades.Divisa;
import com.panin.entidades.Tasa;
import jakarta.persistence.TypedQuery;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class ControladorConversionDivisa {

    public ControladorConversionDivisa() {

    }

    public List<ConversionDivisa> obtenerTodos() {
        Application.session.beginTransaction();
        List<ConversionDivisa> lista;

        TypedQuery query = Application.session.getNamedQuery("ConverionDivisa.findAll");

        lista = query.getResultList();

        Application.session.getTransaction().commit();

        return lista;

    }

    public Tasa obtenerUlimoPorDivisa(Divisa divisa) {
        Application.session.beginTransaction();
        List<ConversionDivisa> lista;

        TypedQuery query = Application.session.getNamedQuery("ConversionDivisa.findByDivisa");
        query.setParameter("divisa", divisa);

        lista = query.getResultList();
        List<Tasa> tasas = new ArrayList<>();
        Tasa tasa = null;
        for (ConversionDivisa fila : lista) {
            tasas.add(fila.getTasa());
        }
        Collections.sort(tasas);
        if (tasas.size() > 0) {
            tasa = tasas.get(tasas.size() - 1);
        }

        Application.session.getTransaction().commit();

        return tasa;

    }

    public void cerrarSesion() {
//         Application.session.close();

    }

    public void crearConversionDivisa(ConversionDivisa conversionDivisa) {

        Application.session.beginTransaction();

        Application.session.save(conversionDivisa);

        Application.session.getTransaction().commit();

    }
}
