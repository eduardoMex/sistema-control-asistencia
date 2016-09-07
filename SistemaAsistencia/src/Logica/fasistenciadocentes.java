/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.vadministrativo;
import Datos.vasistencia_alumnos;
import Datos.vasistenciadocentes;
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
public class fasistenciadocentes {
     private conexion mysql=new conexion();
    private Connection cn=mysql.conectar();
    private String sSQL="";
    public  Integer totalregistros;
    
    
    public DefaultTableModel mostrar(String buscar){
        DefaultTableModel modelo;
        
        String [] titulos={"ID","Idadministrativo","Nombres","Apellidos","Fecha","Hora Ingreso","Hora Salida"};
        String [] registros=new String [7];
        totalregistros=0;
        modelo=new DefaultTableModel(null,titulos);
        sSQL="select  asd.idasistencia_docentes,asd.idadministrativo,ad.nombres,ad.apellidos,asd.fecha,asd.hora_ingreso,asd.hora_salida from asistencia_docentes asd inner join administrativo ad on asd.idadministrativo=ad.idadministrativo  where ad.nombres like '%"+ buscar +"%' order by idasistencia_docentes desc ";
       
      
        
        try {
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sSQL);
            while(rs.next()){
                registros [0]=rs.getString("idasistencia_docentes");
                registros [1]=rs.getString("idadministrativo");
                registros [2]=rs.getString("nombres");
                registros [3]=rs.getString("apellidos");
                registros [4]=rs.getString("fecha");
                registros [5]=rs.getString("hora_ingreso");
                registros [6]=rs.getString("hora_salida");
               
               
               
               
                totalregistros=totalregistros+1;
                modelo.addRow(registros);
            }
                return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }
    
    public DefaultTableModel mostrarasisdocentes(String buscar){
        DefaultTableModel modelo;
        
        String [] titulos={"ID","Idadministrativo","Nombres","Apellidos","Fecha","Hora Ingreso","Hora Salida"};
        String [] registros=new String [7];
        totalregistros=0;
        modelo=new DefaultTableModel(null,titulos);
        sSQL="select  asd.idasistencia_docentes,asd.idadministrativo,ad.nombres,ad.apellidos,asd.fecha,asd.hora_ingreso,asd.hora_salida from asistencia_docentes asd inner join administrativo ad on asd.idadministrativo=ad.idadministrativo  where ad.nombres like '%"+ buscar +"%' order by idasistencia_docentes desc ";
       
      
        
        try {
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sSQL);
            while(rs.next()){
                registros [0]=rs.getString("idasistencia_docentes");
                registros [1]=rs.getString("idadministrativo");
                registros [2]=rs.getString("nombres");
                registros [3]=rs.getString("apellidos");
                registros [4]=rs.getString("fecha");
                registros [5]=rs.getString("hora_ingreso");
                registros [6]=rs.getString("hora_salida");
               
               
               
               
                totalregistros=totalregistros+1;
                modelo.addRow(registros);
            }
                return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }
    
    
    
    
    
     public  boolean insertar(vasistenciadocentes dts){
        sSQL= "insert into asistencia_docentes (idadministrativo,fecha,hora_ingreso,hora_salida)" +
        "values (?,?,?,?)";
        try {
            PreparedStatement pst=cn.prepareStatement(sSQL);
            
            
            pst.setInt(1,dts.getIdadministrativo());
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
     
     
     
      public  boolean editar(vasistenciadocentes dts){
        sSQL= "update  asistencia_docentes  set  idadministrativo=?,fecha=?,hora_ingreso=?,hora_salida=?" +
        "where idasistencia_docentes=?";
        try {           
            
       
            PreparedStatement pst=cn.prepareStatement(sSQL);
            pst.setInt(1,dts.getIdadministrativo());
            pst.setString(2,dts.getFecha());
            pst.setString(3,dts.getHora_ingreso());
            pst.setString(4,dts.getHora_salida());
           
          
            pst.setInt(5,dts.getIdasistencia_docentes());
            
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
      
      
      
        public  boolean eliminar(vasistenciadocentes dts){
        sSQL="delete from asistencia_docentes where idasistencia_docentes=?";
        try {
            
            PreparedStatement pst=cn.prepareStatement(sSQL);
            
            pst.setInt(1,dts.getIdasistencia_docentes());
            
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
