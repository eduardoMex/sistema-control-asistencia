/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

/**
 *
 * @author ESCOBAR
 */
public class vcargo {
     private int idcargo;
    private String cargodescripcion;

    public vcargo() {
    }

    public vcargo(int idcargo, String cargodescripcion) {
        this.idcargo = idcargo;
        this.cargodescripcion = cargodescripcion;
    }

    public int getIdcargo() {
        return idcargo;
    }

    public void setIdcargo(int idcargo) {
        this.idcargo = idcargo;
    }

    public String getCargodescripcion() {
        return cargodescripcion;
    }

    public void setCargodescripcion(String cargodescripcion) {
        this.cargodescripcion = cargodescripcion;
    }

   
}
