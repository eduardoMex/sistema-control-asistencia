/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.vadministrativo;


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
public class fadministrativo {
    
    private conexion mysql=new conexion();
    private Connection cn=mysql.conectar();
    private String sSQL="";
    public  Integer totalregistros;
    
    
    public DefaultTableModel mostrar(String buscar){
        DefaultTableModel modelo;
        
        String [] titulos={"ID","Idcargo","Cargo","Nombres","Apellidos","Dni","Telefono","Direccion","Email","Sexo","Fecha_Ingreso"};
        String [] registros=new String [11];
        totalregistros=0;
        modelo=new DefaultTableModel(null,titulos);
        sSQL="select  ad.idadministrativo,ad.idcargo, ca.cargodescripcion, ad.nombres, ad.apellidos,ad.dni,ad.telefono,ad.direccion,ad.email,ad.sexo,ad.fecha_ingreso from administrativo ad inner join cargo ca on ad.idcargo=ca.idcargo  where ad.dni like '%"+ buscar +"%' order by idadministrativo desc ";
       
      
        
        try {
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sSQL);
            while(rs.next()){
                registros [0]=rs.getString("idadministrativo");
                registros [1]=rs.getString("idcargo");
                registros [2]=rs.getString("cargodescripcion");
                registros [3]=rs.getString("nombres");
                registros [4]=rs.getString("apellidos");
                registros [5]=rs.getString("dni");
                registros [6]=rs.getString("telefono");
                registros [7]=rs.getString("direccion");
                registros [8]=rs.getString("email");
                registros [9]=rs.getString("sexo");              
                registros [10]=rs.getString("fecha_ingreso");
               
               
                totalregistros=totalregistros+1;
                modelo.addRow(registros);
            }
                return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }
    
    
     public DefaultTableModel mostrarvista_ingresodocentes(String buscar){
        DefaultTableModel modelo;
        
        String [] titulos={"ID","Idcargo","Cargo","Nombres","Apellidos","Dni","Telefono","Direccion","Email","Sexo","Fecha_Ingreso"};
        String [] registros=new String [11];
        totalregistros=0;
        modelo=new DefaultTableModel(null,titulos);
        sSQL="select  ad.idadministrativo,ad.idcargo, ca.cargodescripcion, ad.nombres, ad.apellidos,ad.dni,ad.telefono,ad.direccion,ad.email,ad.sexo,ad.fecha_ingreso from administrativo ad inner join cargo ca on ad.idcargo=ca.idcargo  where ad.dni like '%"+ buscar +"%' order by idadministrativo desc ";
       
      
        
        try {
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sSQL);
            while(rs.next()){
                registros [0]=rs.getString("idadministrativo");
                registros [1]=rs.getString("idcargo");
                registros [2]=rs.getString("cargodescripcion");
                registros [3]=rs.getString("nombres");
                registros [4]=rs.getString("apellidos");
                registros [5]=rs.getString("dni");
                registros [6]=rs.getString("telefono");
                registros [7]=rs.getString("direccion");
                registros [8]=rs.getString("email");
                registros [9]=rs.getString("sexo");              
                registros [10]=rs.getString("fecha_ingreso");
               
               
                totalregistros=totalregistros+1;
                modelo.addRow(registros);
            }
                return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }
    
    
      public DefaultTableModel mostrarvista_salidadocentes(String buscar){
        DefaultTableModel modelo;
        
        String [] titulos={"ID","Idcargo","Cargo","Nombres","Apellidos","Dni","Telefono","Direccion","Email","Sexo","Fecha_Ingreso"};
        String [] registros=new String [11];
        totalregistros=0;
        modelo=new DefaultTableModel(null,titulos);
        sSQL="select  ad.idadministrativo,ad.idcargo, ca.cargodescripcion, ad.nombres, ad.apellidos,ad.dni,ad.telefono,ad.direccion,ad.email,ad.sexo,ad.fecha_ingreso from administrativo ad inner join cargo ca on ad.idcargo=ca.idcargo  where ad.dni like '%"+ buscar +"%' order by idadministrativo desc ";
       
      
        
        try {
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sSQL);
            while(rs.next()){
                registros [0]=rs.getString("idadministrativo");
                registros [1]=rs.getString("idcargo");
                registros [2]=rs.getString("cargodescripcion");
                registros [3]=rs.getString("nombres");
                registros [4]=rs.getString("apellidos");
                registros [5]=rs.getString("dni");
                registros [6]=rs.getString("telefono");
                registros [7]=rs.getString("direccion");
                registros [8]=rs.getString("email");
                registros [9]=rs.getString("sexo");              
                registros [10]=rs.getString("fecha_ingreso");
               
               
                totalregistros=totalregistros+1;
                modelo.addRow(registros);
            }
                return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }
    
    
    
    public DefaultTableModel mostrarvistaadminnistrativo(String buscar){
        DefaultTableModel modelo;
        
        String [] titulos={"ID","Idcargo","Cargo","Nombres","Apellidos","Dni","Telefono","Direccion","Email","Sexo","Fecha_Ingreso"};
        String [] registros=new String [11];
        totalregistros=0;
        modelo=new DefaultTableModel(null,titulos);
        sSQL="select  ad.idadministrativo,ad.idcargo, ca.cargodescripcion, ad.nombres, ad.apellidos,ad.dni,ad.telefono,ad.direccion,ad.email,ad.sexo,ad.fecha_ingreso from administrativo ad inner join cargo ca on ad.idcargo=ca.idcargo  where ad.dni like '%"+ buscar +"%' order by idadministrativo desc ";
       
      
        
        try {
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sSQL);
            while(rs.next()){
                registros [0]=rs.getString("idadministrativo");
                registros [1]=rs.getString("idcargo");
                registros [2]=rs.getString("cargodescripcion");
                registros [3]=rs.getString("nombres");
                registros [4]=rs.getString("apellidos");
                registros [5]=rs.getString("dni");
                registros [6]=rs.getString("telefono");
                registros [7]=rs.getString("direccion");
                registros [8]=rs.getString("email");
                registros [9]=rs.getString("sexo");              
                registros [10]=rs.getString("fecha_ingreso");
               
               
                totalregistros=totalregistros+1;
                modelo.addRow(registros);
            }
                return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }
    
    
    
    
    
     public  boolean insertar(vadministrativo dts){
        sSQL= "insert into administrativo (idcargo,nombres,apellidos,dni,telefono,direccion,email,sexo,fecha_ingreso)" +
        "values (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst=cn.prepareStatement(sSQL);
            
            
            pst.setInt(1,dts.getIdcargo());
            pst.setString(2,dts.getNombres());
            pst.setString(3,dts.getApellidos());
            pst.setString(4,dts.getDni());
            pst.setString(5,dts.getTelefono());
            pst.setString(6,dts.getDireccion());            
            pst.setString(7,dts.getEmail());
            pst.setString(8,dts.getSexo());
            pst.setDate(9,dts.getFecha_ingreso());
           
            
            
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
     
     
     
      public  boolean editar(vadministrativo dts){
        sSQL= "update  administrativo set  idcargo=?,nombres=?,apellidos=?,dni=?,telefono=?,direccion=?,email=?,sexo=?,fecha_ingreso=?" +
        "where idadministrativo=?";
        try {           
            
       
            PreparedStatement pst=cn.prepareStatement(sSQL);
            pst.setInt(1,dts.getIdcargo());
            pst.setString(2,dts.getNombres());
            pst.setString(3,dts.getApellidos());
            pst.setString(4,dts.getDni());
            pst.setString(5,dts.getTelefono());
            pst.setString(6,dts.getDireccion());            
            pst.setString(7,dts.getEmail());
            pst.setString(8,dts.getSexo());
            pst.setDate(9,dts.getFecha_ingreso());
          
            pst.setInt(10,dts.getIdadministrativo());
            
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
      
      
      
        public  boolean eliminar(vadministrativo dts){
        sSQL="delete from administrativo where idadministrativo=?";
        try {
            
            PreparedStatement pst=cn.prepareStatement(sSQL);
            
            pst.setInt(1,dts.getIdadministrativo());
            
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
