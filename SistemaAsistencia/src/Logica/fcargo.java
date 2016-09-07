/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.vcargo;
import Datos.vtrabajador;
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
public class fcargo {
    
     private conexion mysql=new conexion();
    private Connection cn=mysql.conectar();
    private String sSQL="";
    public  Integer totalregistros;
    
    
    public DefaultTableModel mostrar(String buscar){
        DefaultTableModel modelo;
        
        String [] titulos={"idcargo","Descripcion"};
        String [] registros=new String [2];
        totalregistros=0;
        modelo=new DefaultTableModel(null,titulos);
        sSQL="select * from cargo where cargodescripcion like '%"+ buscar +"%' order by idcargo";
       
      
        
        try {
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sSQL);
            while(rs.next()){
                registros [0]=rs.getString("idcargo");
                registros [1]=rs.getString("cargodescripcion");
               
               
               
                totalregistros=totalregistros+1;
                modelo.addRow(registros);
            }
                return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }
    
    
    public DefaultTableModel mostrarvista(String buscar){
        DefaultTableModel modelo;
        
        String [] titulos={"idcargo","Descripcion"};
        String [] registros=new String [2];
        totalregistros=0;
        modelo=new DefaultTableModel(null,titulos);
        sSQL="select * from cargo where cargodescripcion like '%"+ buscar +"%' order by idcargo";
       
      
        
        try {
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sSQL);
            while(rs.next()){
                registros [0]=rs.getString("idcargo");
                registros [1]=rs.getString("cargodescripcion");
               
               
               
                totalregistros=totalregistros+1;
                modelo.addRow(registros);
            }
                return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }
    
    
     public  boolean insertar(vcargo dts){
        sSQL= "insert into cargo (cargodescripcion)" +
        "values (?)";
        try {
            PreparedStatement pst=cn.prepareStatement(sSQL);
            
            
            pst.setString(1,dts.getCargodescripcion());
            
           
            
            
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
     
     
     
      public  boolean editar(vcargo dts){
        sSQL= "update  cargo set  cargodescripcion=?" +
        "where idcargo=?";
        try {           
            
       
            PreparedStatement pst=cn.prepareStatement(sSQL);
            pst.setString(1,dts.getCargodescripcion());
           
          
            pst.setInt(2,dts.getIdcargo());
            
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
      
      
      
        public  boolean eliminar(vcargo dts){
        sSQL="delete from cargo where idcargo=?";
        try {
            
            PreparedStatement pst=cn.prepareStatement(sSQL);
            
            pst.setInt(1,dts.getIdcargo());
            
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

    public DefaultTableModel mostrarvista_ingresoalumno(String buscar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
