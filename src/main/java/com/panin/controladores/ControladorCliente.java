/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panin.controladores;

import com.panin.application.Application;
import com.panin.entidades.Cliente;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class ControladorCliente {

    public ControladorCliente() {
    }

    public List<Cliente> obtenerClientes() {
        Application.session.beginTransaction();
        List<Cliente> clientes;
        TypedQuery query = Application.session.getNamedQuery("Cliente.findAll");
        clientes = query.getResultList();

        Application.session.getTransaction().commit();
        return clientes;
    }

    public void crearCliente(Cliente cliente) {
        Application.session.beginTransaction();

        Application.session.save(cliente);
        Application.session.getTransaction().commit();
    }
}
