/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panin.application.form.other;

import com.panin.dto.formAgregarInsumoProductoDTO;
import com.panin.entidades.Insumo;
import com.panin.entidades.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Icon;

/**
 *
 * @author Eliannis
 */
public class Model_Card {

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String descripcion) {
        this.description = descripcion;
    }
    public List<formAgregarInsumoProductoDTO> getListaInsumo() {
		return listaInsumo;
	}

	public void setListaInsumo(List<formAgregarInsumoProductoDTO> listaInsumo) {
		this.listaInsumo = listaInsumo;
	}

	public Model_Card() {
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

        
        
        
    public Model_Card(Icon icon, String title, String values, String descripcion) {
        this.icon = icon;
        this.title = title;
        this.values = values;
        this.description = descripcion;
    }
    
    /*
    Este model card fue creado para desplegar la vista de productos
    */
    public Model_Card(Icon icon, String title, String values, String descripcion, List<formAgregarInsumoProductoDTO> listaInsumo, Producto producto) {
        this.icon = icon;
        this.title = title;
        this.values = values;
        this.description = descripcion;
        this.listaInsumo = listaInsumo;
        this.producto = producto;
    }
    
    
    Icon icon ;
    String title;
    String values;
    String description;
    
    List<formAgregarInsumoProductoDTO> listaInsumo = new ArrayList<formAgregarInsumoProductoDTO>();
    Producto producto;
    
}
