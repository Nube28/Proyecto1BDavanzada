package org.itson.bdavanzadas.dominio;

import java.util.Objects;

public class Domicilio {
    private int id_domicilio;
    private String calle;
    private int numero_exterior;
    private int numero_interioro;
    private int contrasenia;
    private String codigo_postal;
    private String colonia;

    public Domicilio() {
    }

    public Domicilio(int id_domicilio, String calle, int numero_exterior, int numero_interioro, int contrasenia, String codigo_postal, String colonia) {
        this.id_domicilio = id_domicilio;
        this.calle = calle;
        this.numero_exterior = numero_exterior;
        this.numero_interioro = numero_interioro;
        this.contrasenia = contrasenia;
        this.codigo_postal = codigo_postal;
        this.colonia = colonia;
    }

    public Domicilio(String calle, int numero_exterior, int numero_interioro, int contrasenia, String codigo_postal, String colonia) {
        this.calle = calle;
        this.numero_exterior = numero_exterior;
        this.numero_interioro = numero_interioro;
        this.contrasenia = contrasenia;
        this.codigo_postal = codigo_postal;
        this.colonia = colonia;
    }

    public int getId_domicilio() {
        return id_domicilio;
    }

    public void setId_domicilio(int id_domicilio) {
        this.id_domicilio = id_domicilio;
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

    public int getNumero_interioro() {
        return numero_interioro;
    }

    public void setNumero_interioro(int numero_interioro) {
        this.numero_interioro = numero_interioro;
    }

    public int getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(int contrasenia) {
        this.contrasenia = contrasenia;
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.id_domicilio;
        hash = 29 * hash + Objects.hashCode(this.calle);
        hash = 29 * hash + this.numero_exterior;
        hash = 29 * hash + this.numero_interioro;
        hash = 29 * hash + this.contrasenia;
        hash = 29 * hash + Objects.hashCode(this.codigo_postal);
        hash = 29 * hash + Objects.hashCode(this.colonia);
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
        final Domicilio other = (Domicilio) obj;
        if (this.id_domicilio != other.id_domicilio) {
            return false;
        }
        if (this.numero_exterior != other.numero_exterior) {
            return false;
        }
        if (this.numero_interioro != other.numero_interioro) {
            return false;
        }
        if (this.contrasenia != other.contrasenia) {
            return false;
        }
        if (!Objects.equals(this.calle, other.calle)) {
            return false;
        }
        if (!Objects.equals(this.codigo_postal, other.codigo_postal)) {
            return false;
        }
        return Objects.equals(this.colonia, other.colonia);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Domicilio{");
        sb.append("id_domicilio=").append(id_domicilio);
        sb.append(", calle=").append(calle);
        sb.append(", numero_exterior=").append(numero_exterior);
        sb.append(", numero_interioro=").append(numero_interioro);
        sb.append(", contrasenia=").append(contrasenia);
        sb.append(", codigo_postal=").append(codigo_postal);
        sb.append(", colonia=").append(colonia);
        sb.append('}');
        return sb.toString();
    }
    
    
}
