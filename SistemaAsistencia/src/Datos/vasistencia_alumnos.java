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
public class vasistencia_alumnos extends valumno{
    private int idasistencia_alumnos;
    private int idalumno;
    private String fecha;
    private String hora_ingreso;
    private String hora_salida;

    public vasistencia_alumnos() {
    }

    public vasistencia_alumnos(int idasistencia_alumnos, int idalumno, String fecha, String hora_ingreso, String hora_salida) {
        this.idasistencia_alumnos = idasistencia_alumnos;
        this.idalumno = idalumno;
        this.fecha = fecha;
        this.hora_ingreso = hora_ingreso;
        this.hora_salida = hora_salida;
    }

    public int getIdasistencia_alumnos() {
        return idasistencia_alumnos;
    }

    public void setIdasistencia_alumnos(int idasistencia_alumnos) {
        this.idasistencia_alumnos = idasistencia_alumnos;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora_ingreso() {
        return hora_ingreso;
    }

    public void setHora_ingreso(String hora_ingreso) {
        this.hora_ingreso = hora_ingreso;
    }

    public String getHora_salida() {
        return hora_salida;
    }

    public void setHora_salida(String hora_salida) {
        this.hora_salida = hora_salida;
    }
    
    
}
