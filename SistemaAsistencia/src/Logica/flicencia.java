/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.vadministrativo;
import Datos.vlicencia;
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
public class flicencia {
      private conexion mysql=new conexion();
    private Connection cn=mysql.conectar();
    private String sSQL="";
    public  Integer totalregistros;
    
    
    public DefaultTableModel mostrar(String buscar){
        DefaultTableModel modelo;
        
        String [] titulos={"ID","Idadministrativo","Nombres","Apellidos","Fecha","Tiempo","Tipo_Licencia","Descripcion"};
        String [] registros=new String [8];
        totalregistros=0;
        modelo=new DefaultTableModel(null,titulos);
        sSQL="select li.idlicencia,li.idadministrativo,ad.nombres,ad.apellidos,li.fecha,li.tiempo,li.tipo_licencia,li.descripcion from licencia li inner join administrativo ad on li.idadministrativo=ad.idadministrativo  where ad.nombres like '%"+ buscar +"%' order by idlicencia desc ";
       
      
        
        try {
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sSQL);
            while(rs.next()){
                registros [0]=rs.getString("idlicencia");
                registros [1]=rs.getString("idadministrativo");
                registros [2]=rs.getString("nombres");
                registros [3]=rs.getString("apellidos");
               
                registros [4]=rs.getString("fecha");
                registros [5]=rs.getString("tiempo");
                registros [6]=rs.getString("tipo_licencia");
                registros [7]=rs.getString("descripcion");
               
               
               
                totalregistros=totalregistros+1;
                modelo.addRow(registros);
            }
                return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }
    
    
     public  boolean insertar(vlicencia dts){
        sSQL= "insert into licencia (idadministrativo,fecha,tiempo,tipo_licencia,descripcion)" +
        "values (?,?,?,?,?)";
        try {
            PreparedStatement pst=cn.prepareStatement(sSQL);
            
            
            pst.setInt(1,dts.getIdadministrativo());
            pst.setDate(2,dts.getFecha());
            pst.setString(3,dts.getTiempo());
            pst.setString(4,dts.getTipo_licencia());
            pst.setString(5,dts.getDescripcion());
          
           
            
            
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
     
     
     
      public  boolean editar(vlicencia dts){
        sSQL= "update  licencia set  idadministrativo=?,fecha=?,tiempo=?,tipo_licencia=?,descripcion=?" +
        "where idlicencia=?";
        try {           
            
       
            PreparedStatement pst=cn.prepareStatement(sSQL);
            
            pst.setInt(1,dts.getIdadministrativo());
            pst.setDate(2,dts.getFecha());
            pst.setString(3,dts.getTiempo());
            pst.setString(4,dts.getTipo_licencia());
            pst.setString(5,dts.getDescripcion());
            
            pst.setInt(6,dts.getIdlicencia());
            
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
      
      
      
        public  boolean eliminar(vlicencia dts){
        sSQL="delete from licencia where idlicencia=?";
        try {
            
            PreparedStatement pst=cn.prepareStatement(sSQL);
            
            pst.setInt(1,dts.getIdlicencia());
            
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
