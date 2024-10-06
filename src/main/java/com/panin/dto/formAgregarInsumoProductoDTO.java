/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panin.dto;

import com.panin.entidades.Insumo;
import com.panin.entidades.UnidadMedida;

/**
 *
 * @author ricke
 */
public class formAgregarInsumoProductoDTO {
    
    
    private Insumo insumo;
    private UnidadMedida unidadMedidad;
    private Double cantidad;
    
    public formAgregarInsumoProductoDTO(){
        
    }

    public Insumo getInsumo() {
        return insumo;
    }

    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }

    public UnidadMedida getUnidadMedidad() {
        return unidadMedidad;
    }

    public void setUnidadMedidad(UnidadMedida unidadMedidad) {
        this.unidadMedidad = unidadMedidad;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }
    
    
    
    
    
}
