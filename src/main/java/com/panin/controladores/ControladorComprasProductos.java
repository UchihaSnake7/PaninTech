/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panin.controladores;

import com.panin.HibernateUtil;
import com.panin.application.Application;
import com.panin.dto.formAgregarInsumoProductoDTO;
import com.panin.entidades.ComprasInsumo;
import com.panin.entidades.ComprasProducto;
import com.panin.entidades.InsumoRecetas;
import com.panin.entidades.Producto;
import com.panin.entidades.Recetas;
import jakarta.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Session;

/**
 *
 * @author ricke
 */
public class ControladorComprasProductos {

    public ControladorComprasProductos() {
    }

    public List<ComprasProducto> obtenerComprasProductos() {

        Application.session.beginTransaction();
        List<ComprasProducto> comprasProductos;

        TypedQuery query = Application.session.getNamedQuery("ComprasProducto.findAll");
        comprasProductos = query.getResultList();

        Application.session.getTransaction().commit();
        //No cerrar la session mientras se piense utilizar mas metodos con query o generara una excepcion
//                 Application.session.close();
//         Application.session.close();
        return comprasProductos;
    }

    public List<ComprasProducto> obtenerComprasdeUnProducto(Producto producto) {
        Application.session.beginTransaction();
        List<ComprasProducto> comprasProductos;

        TypedQuery query = Application.session.getNamedQuery("ComprasProducto.findByProducto");
        query.setParameter("producto", producto);
        comprasProductos = query.getResultList();

        Application.session.getTransaction().commit();
        //No cerrar la session mientras se piense utilizar mas metodos con query o generara una excepcion
//                 Application.session.close();
//         Application.session.close();
        return comprasProductos;
    }

    public void cerrarSesion() {
//         Application.session.close();
    }

    public ComprasProducto obtenerComprasdeUnProductoUnico(Producto producto) {
//         Application.session.beginTransaction();
        ComprasProducto comprasProductos;

        TypedQuery query = Application.session.getNamedQuery("ComprasProducto.findByProductoUnico");
        query.setParameter("producto", producto);
        query.setMaxResults(1);
        comprasProductos = (ComprasProducto) query.getSingleResult();
        Application.session.getTransaction().commit();
//         Application.session.getTransaction().commit();
        //No cerrar la session mientras se piense utilizar mas metodos con query o generara una excepcion
//                 Application.session.close();
//         Application.session.close();
        return comprasProductos;
    }

    public void save(ComprasProducto compra) {
//        try {
//            Application.session.beginTransaction();
//            Application.session.save(compra);
//            Application.session.getTransaction().commit();
//            return true;
//
//        } catch (Exception e) {
//            return false;
//        }

            Application.session.beginTransaction();
            Application.session.save(compra);
            Application.session.getTransaction().commit();

    }

    public List<ComprasProducto> obtenerComprasDesdeProducto(Producto producto, Date date) {
        Application.session.beginTransaction();
        List<ComprasProducto> comprasProductos;

        TypedQuery query = Application.session.getNamedQuery("ComprasProducto.findByProductoDesde");
        query.setParameter("producto", producto);
        query.setParameter("desde", date);
        comprasProductos = query.getResultList();

        Application.session.getTransaction().commit();
        //No cerrar la session mientras se piense utilizar mas metodos con query o generara una excepcion
//                 Application.session.close();
//        Application.session.close();
        return comprasProductos;
    }

    public List<ComprasProducto> obtenerComprasDesdeHastaProducto(Producto producto, Date date, Date hasta) {
        Application.session.beginTransaction();
        List<ComprasProducto> comprasProductos;

        TypedQuery query = Application.session.getNamedQuery("ComprasProducto.findByProductoFechas");
        query.setParameter("producto", producto);
        query.setParameter("desde", date);
        query.setParameter("hasta", hasta);
        comprasProductos = query.getResultList();

        Application.session.getTransaction().commit();
        //No cerrar la session mientras se piense utilizar mas metodos con query o generara una excepcion
//                 Application.session.close();
//        Application.session.close();
        return comprasProductos;
    }

    public List<ComprasProducto> obtenerComprasHastaProducto(Producto producto, Date hasta) {
        Application.session.beginTransaction();
        List<ComprasProducto> comprasProductos;

        TypedQuery query = Application.session.getNamedQuery("ComprasProducto.findByProductoHasta");
        query.setParameter("producto", producto);
        query.setParameter("hasta", hasta);
        comprasProductos = query.getResultList();

        Application.session.getTransaction().commit();
        //No cerrar la session mientras se piense utilizar mas metodos con query o generara una excepcion
//                 Application.session.close();
//        Application.session.close();
        return comprasProductos;
    }

    public List<ComprasProducto> obtenerComprasProductosFecha(Date desde, Date hasta) {
        Application.session.beginTransaction();
        List<ComprasProducto> comprasProductos;

        TypedQuery query = Application.session.getNamedQuery("ComprasProducto.findByFechas");
        query.setParameter("desde", desde);
        query.setParameter("hasta", hasta);
        comprasProductos = query.getResultList();

        Application.session.getTransaction().commit();
        //No cerrar la session mientras se piense utilizar mas metodos con query o generara una excepcion
//                 Application.session.close();
//        Application.session.close();
        return comprasProductos;
    }

    public List<ComprasProducto> obtenerComprasProductosHasta(Date hasta) {
        Application.session.beginTransaction();
        List<ComprasProducto> comprasProductos;

        TypedQuery query = Application.session.getNamedQuery("ComprasProducto.findByHasta");

        query.setParameter("hasta", hasta);
        comprasProductos = query.getResultList();

        Application.session.getTransaction().commit();
        //No cerrar la session mientras se piense utilizar mas metodos con query o generara una excepcion
//                 Application.session.close();
//        Application.session.close();
        return comprasProductos;

    }

    public List<ComprasProducto> obtenerComprasProductosDesde(Date desde) {
        Application.session.beginTransaction();
        List<ComprasProducto> comprasProductos;

        TypedQuery query = Application.session.getNamedQuery("ComprasProducto.findByDesde");

        query.setParameter("desde", desde);
        comprasProductos = query.getResultList();

        Application.session.getTransaction().commit();
        //No cerrar la session mientras se piense utilizar mas metodos con query o generara una excepcion
//                 Application.session.close();
//        Application.session.close();
        return comprasProductos;

    }

}
