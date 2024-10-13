/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panin.controladores;

import com.panin.HibernateUtil;
import com.panin.entidades.ComprasProducto;
import com.panin.entidades.Producto;
import jakarta.persistence.TypedQuery;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author ricke
 */
public class ControladorComprasProducto {
    
    Session session = HibernateUtil.getSessionFactory().openSession();

    public ControladorComprasProducto() {
//         session.beginTransaction();
    }

    public List<ComprasProducto> obtenerComprasInsumos() {
        session.beginTransaction();
        List<ComprasProducto> comprasProductos;

        TypedQuery query = session.getNamedQuery("ComprasProducto.findAll");
        comprasProductos = query.getResultList();

        session.getTransaction().commit();
        //No cerrar la session mientras se piense utilizar mas metodos con query o generara una excepcion
//                session.close();
        session.close();
        return comprasProductos;
    }

    public List<ComprasProducto> obtenerComprasdeUnInsumo(Producto producto) {
        session.beginTransaction();
        List<ComprasProducto> comprasProductos;

        TypedQuery query = session.getNamedQuery("ComprasProducto.findByProducto");
        query.setParameter("producto", producto);
        comprasProductos = query.getResultList();

        session.getTransaction().commit();
        //No cerrar la session mientras se piense utilizar mas metodos con query o generara una excepcion
//                session.close();
        session.close();
        return comprasProductos;
    }
    
        public void cerrarSesion(){
            session.close();
        }
    
      public ComprasProducto obtenerComprasdeUnInsumoUnico(Producto producto) {
//        session.beginTransaction();
        ComprasProducto comprasProductos;

        TypedQuery query = session.getNamedQuery("ComprasProducto.findByProductoUnico");
        query.setParameter("producto", producto);
        query.setMaxResults(1);
        comprasProductos = (ComprasProducto) query.getSingleResult();

//        session.getTransaction().commit();
        //No cerrar la session mientras se piense utilizar mas metodos con query o generara una excepcion
//                session.close();
//        session.close();
        return comprasProductos;
    }

    public boolean save(ComprasProducto compra) {
        try {
            session.beginTransaction();
            session.save(compra);
            System.out.println(session.getTransaction().getStatus());
            session.close();
            return true;

        } catch (Exception e) {
            return false;
        }

    }

    public List<ComprasProducto> obtenerComprasDesde(Producto producto, Date date) {
        session.beginTransaction();
        List<ComprasProducto> comprasProductos;

        TypedQuery query = session.getNamedQuery("ComprasProducto.findByProductoDesde");
        query.setParameter("producto", producto);
        query.setParameter("desde", date);
        comprasProductos = query.getResultList();

        session.getTransaction().commit();
        //No cerrar la session mientras se piense utilizar mas metodos con query o generara una excepcion
//                session.close();
        session.close();
        return comprasProductos;
    }

    public List<ComprasProducto> obtenerComprasDesdeHasta(Producto producto, Date date, Date hasta) {
        session.beginTransaction();
        List<ComprasProducto> comprasProductos;

        TypedQuery query = session.getNamedQuery("ComprasProducto.findByProductoFechas");
        query.setParameter("producto", producto);
        query.setParameter("desde", date);
        query.setParameter("hasta", hasta);
        comprasProductos = query.getResultList();

        session.getTransaction().commit();
        //No cerrar la session mientras se piense utilizar mas metodos con query o generara una excepcion
//                session.close();
        session.close();
        return comprasProductos;
    }

    public List<ComprasProducto> obtenerComprasHasta(Producto producto, Date hasta) {
        session.beginTransaction();
        List<ComprasProducto> comprasProductos;

        TypedQuery query = session.getNamedQuery("ComprasProducto.findByProductoHasta");
        query.setParameter("producto", producto);
        query.setParameter("hasta", hasta);
        comprasProductos = query.getResultList();

        session.getTransaction().commit();
        //No cerrar la session mientras se piense utilizar mas metodos con query o generara una excepcion
//                session.close();
        session.close();
        return comprasProductos;
    }

    public List<ComprasProducto> obtenerComprasInsumosFecha(Date desde, Date hasta) {
        session.beginTransaction();
        List<ComprasProducto> comprasProductos;

        TypedQuery query = session.getNamedQuery("ComprasProducto.findByFechas");
        query.setParameter("desde", desde);
        query.setParameter("hasta", hasta);
        comprasProductos = query.getResultList();

        session.getTransaction().commit();
        //No cerrar la session mientras se piense utilizar mas metodos con query o generara una excepcion
//                session.close();
        session.close();
        return comprasProductos;
    }

    public List<ComprasProducto> obtenerComprasInsumosHasta(Date hasta) {
        session.beginTransaction();
        List<ComprasProducto> comprasProductos;

        TypedQuery query = session.getNamedQuery("ComprasProducto.findByHasta");

        query.setParameter("hasta", hasta);
        comprasProductos = query.getResultList();

        session.getTransaction().commit();
        //No cerrar la session mientras se piense utilizar mas metodos con query o generara una excepcion
//                session.close();
        session.close();
        return comprasProductos;

    }

    public List<ComprasProducto> obtenerComprasInsumosDesde(Date desde) {
        session.beginTransaction();
        List<ComprasProducto> comprasProductos;

        TypedQuery query = session.getNamedQuery("ComprasProducto.findByDesde");

        query.setParameter("desde", desde);
        comprasProductos = query.getResultList();

        session.getTransaction().commit();
        //No cerrar la session mientras se piense utilizar mas metodos con query o generara una excepcion
//                session.close();
        session.close();
        return comprasProductos;

    }
    
}
