/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.vtrabajador;
import java.io.File;
import java.io.FileInputStream;
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
public class ftrabajador {

    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    public Integer totalregistros;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"idtrabajador", "Nombres", "Apellidos", "Dni", "Telefono", "Direccion", "Email", "Sexo", "Login", "Password", "Acceso", "Estado", "Fecha_Ingreso"};
        String[] registros = new String[13];
        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        sSQL = "select * from trabajador where dni like '%" + buscar + "%' order by idtrabajador";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                registros[0] = rs.getString("idtrabajador");
                registros[1] = rs.getString("nombres");
                registros[2] = rs.getString("apellidos");
                registros[3] = rs.getString("dni");
                registros[4] = rs.getString("telefono");
                registros[5] = rs.getString("direccion");
                registros[6] = rs.getString("email");
                registros[7] = rs.getString("sexo");
                registros[8] = rs.getString("login");
                registros[9] = rs.getString("password");
                registros[10] = rs.getString("acceso");
                registros[11] = rs.getString("estado");
                registros[12] = rs.getString("fecha_ingreso");

                totalregistros = totalregistros + 1;
                modelo.addRow(registros);
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    public boolean insertar(vtrabajador dts) {
        sSQL = "insert into trabajador (nombres,apellidos,dni,telefono,direccion,email,sexo,login,password,acceso,estado,fecha_ingreso)"
                + "values (?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setString(1, dts.getNombres());
            pst.setString(2, dts.getApellidos());
            pst.setString(3, dts.getDni());
            pst.setString(4, dts.getTelefono());
            pst.setString(5, dts.getDireccion());
            pst.setString(6, dts.getEmail());
            pst.setString(7, dts.getSexo());
            pst.setString(8, dts.getLogin());
            pst.setString(9, dts.getPassword());
            pst.setString(10, dts.getAcceso());
            pst.setString(11, dts.getEstado());
            pst.setDate(12, dts.getFecha_ingreso());

            int n = pst.executeUpdate();

            if (n != 0) {

                return true;
            } else {
                return false;

            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public boolean editar(vtrabajador dts) {
        sSQL = "update  trabajador set  nombres=?,apellidos=?,dni=?,telefono=?,direccion=?,email=?,sexo=?,login=?,password=?,acceso=?,estado=?,fecha_ingreso=?"
                + "where idtrabajador=?";
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getNombres());
            pst.setString(2, dts.getApellidos());
            pst.setString(3, dts.getDni());
            pst.setString(4, dts.getTelefono());
            pst.setString(5, dts.getDireccion());
            pst.setString(6, dts.getEmail());
            pst.setString(7, dts.getSexo());
            pst.setString(8, dts.getLogin());
            pst.setString(9, dts.getPassword());
            pst.setString(10, dts.getAcceso());
            pst.setString(11, dts.getEstado());
            pst.setDate(12, dts.getFecha_ingreso());

            pst.setInt(13, dts.getIdtrabajador());

            int n = pst.executeUpdate();

            if (n != 0) {

                return true;
            } else {
                return false;

            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public boolean eliminar(vtrabajador dts) {
        sSQL = "delete from trabajador where idtrabajador=?";
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, dts.getIdtrabajador());

            int n = pst.executeUpdate();

            if (n != 0) {

                return true;
            } else {
                return false;

            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public DefaultTableModel login(String login, String password) {
        DefaultTableModel modelo;

        String[] titulos = {"idtrabajador", "Nombres", "Apellidos", "Login", "Password", "Acceso", "Estado"};
        String[] registros = new String[7];
        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        sSQL = "select * from trabajador where login='" + login + "'and password='" + password + "' and estado='A'";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                registros[0] = rs.getString("idtrabajador");
                registros[1] = rs.getString("nombres");
                registros[2] = rs.getString("apellidos");
                registros[3] = rs.getString("login");
                registros[4] = rs.getString("password");
                registros[5] = rs.getString("acceso");
                registros[6] = rs.getString("estado");

                totalregistros = totalregistros + 1;
                modelo.addRow(registros);
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

}
