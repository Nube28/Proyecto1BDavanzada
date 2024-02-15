/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.bdavanzadas.dtos;

import java.util.Objects;

/**
 *
 * @author Berry
 */
public class DireccionNuevaDTO {
    private String calle;
    private int numero_exterior;
    private int numero_interior;
    private String codigo_postal;
    private String colonia;

    public DireccionNuevaDTO() {
    }

    public DireccionNuevaDTO(String calle, int numero_exterior, int numero_interioro, String codigo_postal, String colonia) {
        this.calle = calle;
        this.numero_exterior = numero_exterior;
        this.numero_interior = numero_interioro;
        this.codigo_postal = codigo_postal;
        this.colonia = colonia;
    }
    
    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero_exterior() {
        return numero_exterior;
    }

    public void setNumero_exterior(int numero_exterior) {
        this.numero_exterior = numero_exterior;
    }

    public int getNumero_interior() {
        return numero_interior;
    }

    public void setNumero_interior(int numero_interioro) {
        this.numero_interior = numero_interioro;
    }

    public String getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    
}
