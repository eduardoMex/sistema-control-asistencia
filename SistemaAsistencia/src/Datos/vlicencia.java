/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.Date;

/**
 *
 * @author ESCOBAR
 */
public class vlicencia extends vadministrativo{
    private int idlicencia;
    private int idadministrativo;
    private Date fecha;
    private String tiempo;
    private String tipo_licencia;
    private String descripcion;

    public vlicencia() {
    }

    public vlicencia(int idlicencia, int idadministrativo, Date fecha, String tiempo, String tipo_licencia, String descripcion) {
        this.idlicencia = idlicencia;
        this.idadministrativo = idadministrativo;
        this.fecha = fecha;
        this.tiempo = tiempo;
        this.tipo_licencia = tipo_licencia;
        this.descripcion = descripcion;
    }

    public int getIdlicencia() {
        return idlicencia;
    }

    public void setIdlicencia(int idlicencia) {
        this.idlicencia = idlicencia;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public String getTipo_licencia() {
        return tipo_licencia;
    }

    public void setTipo_licencia(String tipo_licencia) {
        this.tipo_licencia = tipo_licencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

   
}
