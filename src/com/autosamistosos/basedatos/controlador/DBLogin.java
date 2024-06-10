package com.autosamistosos.basedatos.controlador;

import com.autosamistosos.basedatos.conexionBD;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBLogin {
    public void registroUsuario(String usuario, String password){
        String sql = "INSERT INTO login VALUES(?,?)";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = conexionBD.getInstancia().getConexion().prepareStatement(sql);
            preparedStatement.setString(1, usuario);
            preparedStatement.setString(2, password);
            if (preparedStatement.executeUpdate() >= 1){
                JOptionPane.showMessageDialog(null, "Registro agregado.","Mensaje",JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al insertar registro","Mensaje",JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (preparedStatement != null ) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error SQL","Mensaje",JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public boolean encontrarUsuario(String usuario, String password){
        String sql = "SELECT * FROM login WHERE correo = ?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = conexionBD.getInstancia().getConexion().prepareStatement(sql);
            preparedStatement.setString(1, usuario);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                if(usuarioPassword(usuario, password)){
                    JOptionPane.showMessageDialog(null, "Entrando a sistema...","Mensaje",JOptionPane.INFORMATION_MESSAGE);
                    return true;
                }
            }else{
                JOptionPane.showMessageDialog(null, "No se encontro usuario","Error",JOptionPane.WARNING_MESSAGE);
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error SQL","Error",JOptionPane.ERROR_MESSAGE);
        }finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error SQL","Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        return false;
    }

    private boolean usuarioPassword(String correo, String password){
        String sql = "SELECT * FROM login WHERE correo = ? AND password = ?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = conexionBD.getInstancia().getConexion().prepareStatement(sql);
            preparedStatement.setString(1, correo);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "Contraseña incorrecta.","Error",JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error SQL","Error",JOptionPane.ERROR_MESSAGE);
        }finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error SQL","Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        return false;
    }
}//class
