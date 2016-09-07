/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.Date;
import javax.swing.Timer;

/**
 *
 * @author ESCOBAR
 */
public class vasistenciadocentes  extends vadministrativo{
    private int idasistencia_docentes;
    private int idadministrativo;
    private String fecha;
    private String hora_ingreso;
    private String hora_salida;

    public vasistenciadocentes() {
    }

    public vasistenciadocentes(int idasistencia_docentes, int idadministrativo, String fecha, String hora_ingreso, String hora_salida) {
        this.idasistencia_docentes = idasistencia_docentes;
        this.idadministrativo = idadministrativo;
        this.fecha = fecha;
        this.hora_ingreso = hora_ingreso;
        this.hora_salida = hora_salida;
    }

    public int getIdasistencia_docentes() {
        return idasistencia_docentes;
    }

    public void setIdasistencia_docentes(int idasistencia_docentes) {
        this.idasistencia_docentes = idasistencia_docentes;
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
