/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;


import Datos.vpermiso;
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
public class fpermiso {
    private conexion mysql=new conexion();
    private Connection cn=mysql.conectar();
    private String sSQL="";
    public  Integer totalregistros;
    
     public DefaultTableModel mostrar(String buscar){
        DefaultTableModel modelo;
        
        String [] titulos={"ID","Idalumno","Nombres","Apellidos","Grado","Seccion","Fecha","Tiempo","Descripcion"};
        String [] registros=new String [9];
        totalregistros=0;
        modelo=new DefaultTableModel(null,titulos);
        sSQL="select pe.idpermiso,pe.idalumno,al.nombres,al.apellidos,al.grado,al.seccion,pe.fecha,pe.tiempo,pe.descripcion from permiso pe inner join alumno al on pe.idalumno=al.idalumno where al.nombres like '%"+ buscar +"%' order by idpermiso desc ";
            
        
        try {
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sSQL);
            while(rs.next()){
                registros [0]=rs.getString("idpermiso");
                registros [1]=rs.getString("idalumno");
                registros [2]=rs.getString("nombres");
                registros [3]=rs.getString("apellidos");
                registros [4]=rs.getString("grado");
                registros [5]=rs.getString("seccion");
                registros [6]=rs.getString("fecha");
                registros [7]=rs.getString("tiempo");
                registros [8]=rs.getString("descripcion");
               
               
               
                totalregistros=totalregistros+1;
                modelo.addRow(registros);
            }
                return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }
    
     
     
     
     public DefaultTableModel mostrarvistaalumno(String buscar){
        DefaultTableModel modelo;
        
        String [] titulos={"ID","Idalumno","Nombres","Apellidos","Grado","Seccion","Fecha","Tiempo","Descripcion"};
        String [] registros=new String [9];
        totalregistros=0;
        modelo=new DefaultTableModel(null,titulos);
        sSQL="select pe.idpermiso,pe.idalumno,al.nombres,al.apellidos,al.grado,al.seccion,pe.fecha,pe.tiempo,pe.descripcion from permiso pe inner join alumno al on pe.idalumno=al.idalumno where al.nombres like '%"+ buscar +"%' order by idpermiso desc ";
            
        
        try {
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sSQL);
            while(rs.next()){
                registros [0]=rs.getString("idpermiso");
                registros [1]=rs.getString("idalumno");
                registros [2]=rs.getString("nombres");
                registros [3]=rs.getString("apellidos");
                registros [4]=rs.getString("grado");
                registros [5]=rs.getString("seccion");
                registros [6]=rs.getString("fecha");
                registros [7]=rs.getString("tiempo");
                registros [8]=rs.getString("descripcion");
               
               
               
                totalregistros=totalregistros+1;
                modelo.addRow(registros);
            }
                return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }
    
    
     public  boolean insertar(vpermiso dts){
        sSQL= "insert into permiso (idalumno,fecha,tiempo,descripcion)" +
        "values (?,?,?,?)";
        try {
            PreparedStatement pst=cn.prepareStatement(sSQL);
            
            
            pst.setInt(1,dts.getIdalumno());           
            pst.setDate(2,dts.getFecha());
            pst.setString(3,dts.getTiempo());
            pst.setString(4,dts.getDescripcion());        
            
                     
            
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
     
     
     
      public  boolean editar(vpermiso dts){
        sSQL= "update  permiso set  idalumno=?,fecha=?,tiempo=?,descripcion=?" +
        "where idpermiso=?";
        try {           
            
       
            PreparedStatement pst=cn.prepareStatement(sSQL);
            
            pst.setInt(1,dts.getIdalumno());
            pst.setDate(2,dts.getFecha());
            pst.setString(3,dts.getTiempo());            
            pst.setString(4,dts.getDescripcion());
            
            pst.setInt(5,dts.getIdpermiso());
            
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
      
      
      
        public  boolean eliminar(vpermiso dts){
        sSQL="delete from permiso where idpermiso=?";
        try {
            
            PreparedStatement pst=cn.prepareStatement(sSQL);
            
            pst.setInt(1,dts.getIdpermiso());
            
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
