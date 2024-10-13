package com.panin.controladores;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.panin.HibernateUtil;
import com.panin.application.utilities.tipoProducto;
import com.panin.db.ConexionDB;
import com.panin.entidades.Producto;
import com.panin.entidades.Recetas;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

public class ControladorProductos {

//	ConexionDB conexionDB;
//       @PersistenceContext(unitName = "com.panin_PaninTech")
//       private EntityManager em;
    Session session = HibernateUtil.getSessionFactory().openSession();

    public ControladorProductos() {
//		 conexionDB = new ConexionDB("jdbc:mysql://localhost:3306/panin","root","root");
//		session.beginTransaction();

    }

    //Ejemplo de metodo para obtener todos los productos de la db
    public List<Producto> obtenerProductos() {

        session.beginTransaction();

        List<Producto> productos;

        TypedQuery query = session.getNamedQuery("Producto.findAll");
        productos = query.getResultList();

        session.getTransaction().commit();
        //No cerrar la session mientras se piense utilizar mas metodos con query o generara una excepcion
        session.close();

        return productos;
    }

    public List<Producto> obtenerProductosElaborados() {

        session.beginTransaction();

        List<Producto> productos;

        TypedQuery query = session.getNamedQuery("Producto.findByTipo");
        query.setParameter("tipo", tipoProducto.Elaborado);

        productos = query.getResultList();

        session.getTransaction().commit();
        //No cerrar la session mientras se piense utilizar mas metodos con query o generara una excepcion
        session.close();

        return productos;
    }

    public Producto obtenerProductoByReceta(Recetas receta) {

        session.beginTransaction();

        Producto producto;

        TypedQuery query = session.getNamedQuery("Producto.findByReceta");
        query.setParameter("receta", receta.getIdReceta());

        producto = (Producto) query.getSingleResult();

        session.getTransaction().commit();
        //No cerrar la session mientras se piense utilizar mas metodos con query o generara una excepcion
        session.close();

        return producto;
    }

    public void crearProducto(Producto producto) {

        session.beginTransaction();

        session.save(producto);

    }

    public void borrarProducto(Producto producto) {

        session.beginTransaction();

        session.delete(producto);

        session.getTransaction().commit();

        if (producto.getTipo().toString().equalsIgnoreCase("Elaborado")) {

            ControladorReceta cr = new ControladorReceta();
            Recetas r = cr.obtenerRecetaPorId(producto.getIdReceta());
            cr.borrarReceta(r);
        }

    }

    public void abrirSesion() {

        session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

    }

    public void cerrarSesion() {

        session.close();

    }

}
