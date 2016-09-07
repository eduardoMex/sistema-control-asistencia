/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;


import Datos.valumno;
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
public class falumno {
    private conexion mysql=new conexion();
   private Connection cn=mysql.conectar();
    private String sSQL="";
    public  Integer totalregistros;
    
    
    public DefaultTableModel mostrar(String buscar){
        DefaultTableModel modelo;
        
        String [] titulos={"idAlumno","Nombres","Apellidos","Dni","Direccion","Sexo","Fecha Nacimiento","Fecha Registro","Grado","Seccion"};
        String [] registros=new String [10];
        totalregistros=0;
        modelo=new DefaultTableModel(null,titulos);
        sSQL="select * from alumno where dni like '%"+ buscar +"%' order by idalumno";
       
      
        
        try {
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sSQL);
            while(rs.next()){
                registros [0]=rs.getString("idalumno");
                registros [1]=rs.getString("nombres");
                registros [2]=rs.getString("apellidos");
                registros [3]=rs.getString("dni");
                registros [4]=rs.getString("direccion");
                registros [5]=rs.getString("sexo");
                registros [6]=rs.getString("fecha_nacimiento");
                registros [7]=rs.getString("fecha_registro");
                registros [8]=rs.getString("grado");
                registros [9]=rs.getString("seccion");
                
               
               
                totalregistros=totalregistros+1;
                modelo.addRow(registros);
            }
                return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }
    
    public DefaultTableModel mostrarvista_ingresoalumno(String buscar){
        DefaultTableModel modelo;
        
        String [] titulos={"idAlumno","Nombres","Apellidos","Dni","Direccion","Sexo","Fecha Nacimiento","Fecha Registro","Grado","Seccion"};
        String [] registros=new String [10];
        totalregistros=0;
        modelo=new DefaultTableModel(null,titulos);
        sSQL="select * from alumno where dni like '%"+ buscar +"%' order by idalumno";
       
      
        
        try {
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sSQL);
            while(rs.next()){
                registros [0]=rs.getString("idalumno");
                registros [1]=rs.getString("nombres");
                registros [2]=rs.getString("apellidos");
                registros [3]=rs.getString("dni");
                registros [4]=rs.getString("direccion");
                registros [5]=rs.getString("sexo");
                registros [6]=rs.getString("fecha_nacimiento");
                registros [7]=rs.getString("fecha_registro");
                registros [8]=rs.getString("grado");
                registros [9]=rs.getString("seccion");
                
               
               
                totalregistros=totalregistros+1;
                modelo.addRow(registros);
            }
                return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }
    
    public DefaultTableModel mostrarvista_salidaalumno(String buscar){
        DefaultTableModel modelo;
        
        String [] titulos={"idAlumno","Nombres","Apellidos","Dni","Direccion","Sexo","Fecha Nacimiento","Fecha Registro","Grado","Seccion"};
        String [] registros=new String [10];
        totalregistros=0;
        modelo=new DefaultTableModel(null,titulos);
        sSQL="select * from alumno where dni like '%"+ buscar +"%' order by idalumno";
       
              
        try {
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sSQL);
            while(rs.next()){
                registros [0]=rs.getString("idalumno");
                registros [1]=rs.getString("nombres");
                registros [2]=rs.getString("apellidos");
                registros [3]=rs.getString("dni");
                registros [4]=rs.getString("direccion");
                registros [5]=rs.getString("sexo");
                registros [6]=rs.getString("fecha_nacimiento");
                registros [7]=rs.getString("fecha_registro");
                registros [8]=rs.getString("grado");
                registros [9]=rs.getString("seccion");
                
               
               
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
        
        String [] titulos={"idAlumno","Nombres","Apellidos","Dni","Direccion","Sexo","Fecha Nacimiento","Fecha Registro","Grado","Seccion"};
        String [] registros=new String [10];
        totalregistros=0;
        modelo=new DefaultTableModel(null,titulos);
        sSQL="select * from alumno where dni like '%"+ buscar +"%' order by idalumno";
       
      
        
        try {
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sSQL);
            while(rs.next()){
                registros [0]=rs.getString("idalumno");
                registros [1]=rs.getString("nombres");
                registros [2]=rs.getString("apellidos");
                registros [3]=rs.getString("dni");
                registros [4]=rs.getString("direccion");
                registros [5]=rs.getString("sexo");
                registros [6]=rs.getString("fecha_nacimiento");
                registros [7]=rs.getString("fecha_registro");
                registros [8]=rs.getString("grado");
                registros [9]=rs.getString("seccion");
                
               
               
                totalregistros=totalregistros+1;
                modelo.addRow(registros);
            }
                return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }
    
    
     public  boolean insertar(valumno dts){
        sSQL= "insert into alumno (nombres,apellidos,dni,direccion,sexo,fecha_nacimiento,fecha_registro,grado,seccion)" +
        "values (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst=cn.prepareStatement(sSQL);
            
            
            pst.setString(1,dts.getNombres());
            pst.setString(2,dts.getApellidos());
            pst.setString(3,dts.getDni());           
            pst.setString(4,dts.getDireccion());          
            pst.setString(5,dts.getSexo());
            pst.setDate(6,dts.getFecha_nacimiento());
            pst.setDate(7,dts.getFecha_registro());
            pst.setString(8,dts.getGrado());
            pst.setString(9,dts.getSeccion());
           
            
            
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
     
     
     
      public  boolean editar(valumno dts){
        sSQL= "update  alumno set  nombres=?,apellidos=?,dni=?,direccion=?,sexo=?,fecha_nacimiento=?,fecha_registro=?,grado=?,seccion=?" +
        "where idalumno=?";
        try {           
            
       
            PreparedStatement pst=cn.prepareStatement(sSQL);
            pst.setString(1,dts.getNombres());
            pst.setString(2,dts.getApellidos());
            pst.setString(3,dts.getDni());           
            pst.setString(4,dts.getDireccion());          
            pst.setString(5,dts.getSexo());
            pst.setDate(6,dts.getFecha_nacimiento());
            pst.setDate(7,dts.getFecha_registro());
            pst.setString(8,dts.getGrado());
            pst.setString(9,dts.getSeccion());
          
            pst.setInt(10,dts.getIdalumno());
            
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
      
      
      
        public  boolean eliminar(valumno dts){
        sSQL="delete from alumno where idalumno=?";
        try {
            
            PreparedStatement pst=cn.prepareStatement(sSQL);
            
            pst.setInt(1,dts.getIdalumno());
            
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
