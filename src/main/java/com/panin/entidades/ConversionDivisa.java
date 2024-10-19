/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panin.entidades;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

/**
 *
 * @author ricke
 */
@Entity
@Table(name = "conversion_divisa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConversionDivisa.findAll", query = "SELECT c FROM ConversionDivisa c"),
    @NamedQuery(name = "ConversionDivisa.findByDivisa", query = "SELECT c FROM ConversionDivisa c WHERE c.divisa = :divisa")
})

public class ConversionDivisa {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @JoinColumn(name = "tasa", referencedColumnName = "id")
    @ManyToOne
    private Tasa tasa;
    @JoinColumn(name = "divisa", referencedColumnName = "id")
    @ManyToOne
    private Divisa divisa;

    public ConversionDivisa() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Tasa getTasa() {
        return tasa;
    }

    public void setTasa(Tasa tasa) {
        this.tasa = tasa;
    }

    public Divisa getDivisa() {
        return divisa;
    }

    public void setDivisa(Divisa divisa) {
        this.divisa = divisa;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ConversionDivisa other = (ConversionDivisa) obj;
        return Objects.equals(this.id, other.id);
    }

}
