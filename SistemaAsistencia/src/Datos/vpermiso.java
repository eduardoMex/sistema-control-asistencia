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
public class vpermiso extends valumno {
    private int idpermiso;
    private int idalumno;
    private Date fecha;
    private String tiempo;
    private String descripcion;

    public vpermiso() {
    }

    public vpermiso(int idpermiso, int idalumno, Date fecha, String tiempo, String descripcion) {
        this.idpermiso = idpermiso;
        this.idalumno = idalumno;
        this.fecha = fecha;
        this.tiempo = tiempo;
        this.descripcion = descripcion;
    }

    public int getIdpermiso() {
        return idpermiso;
    }

    public void setIdpermiso(int idpermiso) {
        this.idpermiso = idpermiso;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
    
}
