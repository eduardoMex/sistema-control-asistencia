/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.vadministrativo;
import Datos.vasistencia_alumnos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ESCOBAR
 */
public class fasistencia_alumnos {
      private conexion mysql=new conexion();
    private Connection cn=mysql.conectar();
    private String sSQL="";
    public  Integer totalregistros;
    
    
    public DefaultTableModel mostrar(String buscar){
        DefaultTableModel modelo;
        
        String [] titulos={"ID","Idalumno","Nombres","Apellidos","Grado","Seccion","Fecha","Hora Ingreso","Hora Salida"};
        String [] registros=new String [9];
        totalregistros=0;
        modelo=new DefaultTableModel(null,titulos);
        sSQL="select  asa.idasistencia_alumnos,asa.idalumno,alum.nombres,alum.apellidos,alum.grado,alum.seccion,asa.fecha,asa.hora_ingreso,asa.hora_salida from asistencia_alumnos asa inner join alumno alum on asa.idalumno=alum.idalumno  where alum.nombres like '%"+ buscar +"%' order by idasistencia_alumnos desc ";
       
      
        
        try {
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sSQL);
            while(rs.next()){
                registros [0]=rs.getString("idasistencia_alumnos");
                registros [1]=rs.getString("idalumno");
                registros [2]=rs.getString("nombres");
                registros [3]=rs.getString("apellidos");
                registros [4]=rs.getString("grado");
                registros [5]=rs.getString("seccion");
                registros [6]=rs.getString("fecha");
                registros [7]=rs.getString("hora_ingreso");
                registros [8]=rs.getString("hora_salida");
               
               
               
                totalregistros=totalregistros+1;
                modelo.addRow(registros);
            }
                return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }
    
    
    
     public DefaultTableModel mostrarreportealumnos(String buscar){
        DefaultTableModel modelo;
        
        String [] titulos={"ID","Idalumno","Nombres","Apellidos","Grado","Seccion","Fecha","Hora Ingreso","Hora Salida"};
        String [] registros=new String [9];
        totalregistros=0;
        modelo=new DefaultTableModel(null,titulos);
        sSQL="select  asa.idasistencia_alumnos,asa.idalumno,alum.nombres,alum.apellidos,alum.grado,alum.seccion,asa.fecha,asa.hora_ingreso,asa.hora_salida from asistencia_alumnos asa inner join alumno alum on asa.idalumno=alum.idalumno  where alum.nombres like '%"+ buscar +"%' order by idasistencia_alumnos desc ";
       
      
        
        try {
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sSQL);
            while(rs.next()){
                registros [0]=rs.getString("idasistencia_alumnos");
                registros [1]=rs.getString("idalumno");
                registros [2]=rs.getString("nombres");
                registros [3]=rs.getString("apellidos");
                registros [4]=rs.getString("grado");
                registros [5]=rs.getString("seccion");
                registros [6]=rs.getString("fecha");
                registros [7]=rs.getString("hora_ingreso");
                registros [8]=rs.getString("hora_salida");
               
               
               
                totalregistros=totalregistros+1;
                modelo.addRow(registros);
            }
                return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }
    
    
    
    
    
     public  boolean insertar(vasistencia_alumnos dts){
        sSQL= "insert into asistencia_alumnos (idalumno,fecha,hora_ingreso,hora_salida)" +
        "values (?,?,?,?)";
        try {
            PreparedStatement pst=cn.prepareStatement(sSQL);
            
            
            pst.setInt(1,dts.getIdalumno());
            pst.setString(2,dts.getFecha());
            pst.setString(3,dts.getHora_ingreso());
            pst.setString(4,dts.getHora_salida());
            
           
            
            
            int n=pst.executeUpdate();
            
            if(n!=0){
            
            return true;
            }
            else{
            return false;                              
                
            }
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
     
     
     
      public  boolean editar(vasistencia_alumnos dts){
        sSQL= "update  asistencia_alumnos set  idalumno=?,fecha=?,hora_ingreso=?,hora_salida=?" +
        "where idasistencia_alumnos=?";
        try {           
            
       
            PreparedStatement pst=cn.prepareStatement(sSQL);
            pst.setInt(1,dts.getIdalumno());
            pst.setString(2,dts.getFecha());
            pst.setString(3,dts.getHora_ingreso());
            pst.setString(4,dts.getHora_salida());
           
          
            pst.setInt(5,dts.getIdasistencia_alumnos());
            
            int n=pst.executeUpdate();
            
            if(n!=0){
            
            return true;
            }
            else{
            return false;                              
                
            }
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
      
      
      
        public  boolean eliminar(vasistencia_alumnos dts){
        sSQL="delete from asistencia_alumnos where idasistencia_alumnos=?";
        try {
            
            PreparedStatement pst=cn.prepareStatement(sSQL);
            
            pst.setInt(1,dts.getIdasistencia_alumnos());
            
            int n=pst.executeUpdate();
            
            if(n!=0){
            
            return true;
            }
            else{
            return false;                            
                
            }           
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
    
    
    
}
