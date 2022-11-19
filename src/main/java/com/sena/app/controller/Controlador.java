package com.sena.app.controller;

import com.sena.app.modelo.Actor;
import com.sena.app.modelo.Conexion;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


public class Controlador {
    
    private final Conexion conexion = new Conexion();

    public Controlador() throws SQLException, IOException {
        conexion.conectar();
    }
    
    public List<Actor> findAllActores( ) throws SQLException {
        if (!conexion.hayConexion()) {
            throw new SQLException(" No existe conexion abierta ");
        }
        
        
        PreparedStatement pst = null;
        ResultSet rst = null;
        LinkedList lista = new LinkedList();
        try {
            String query;
            query = "select * from actor ";                   //Definir la consulta
            pst = conexion.con.prepareStatement(query);       //Prepararla
                  
            rst = pst.executeQuery();                         //Ejecutarla 
            
            
            while (rst.next()) {
                lista.add(Actor.load(rst));                   //Recorre el RS y llena una lista
            }
            System.out.println("El Query " + query );
            
        }  finally {
            if (pst != null) {
                pst.close();
                pst = null;
            }
            if (rst != null) {
                rst.close();
                rst = null;
            }
        }
        return lista;                            //Retorna la lista llena
    }
    
    
    public List<Actor> findLikeNombre(String cadena ) throws SQLException {
        if (!conexion.hayConexion()) {
            throw new SQLException(" No existe conexion abierta ");
        }
        
        
        PreparedStatement pst = null;
        ResultSet rst = null;
        LinkedList lista = new LinkedList();
        try {
            String query;
            query = "SELECT * FROM actor  where first_name like ? ";                   //Definir la consulta
            pst = conexion.con.prepareStatement(query);       //Prepararla
            pst.setString(1, cadena);                         //Asignando parámetros a la consulta
                  
            rst = pst.executeQuery();                         //Ejecutarla 
            
            
            while (rst.next()) {
                lista.add(Actor.load(rst));                   //Recorre el RS y llena una lista
            }
            System.out.println("El Query " + query );
            
        }  finally {
            if (pst != null) {
                pst.close();
                pst = null;
            }
            if (rst != null) {
                rst.close();
                rst = null;
            }
        }
        return lista;                            //Retorna la lista llena
    }
    
    
    
    public List<Actor> findByIdActor(Integer id ) throws SQLException {
        if (!conexion.hayConexion()) {
            throw new SQLException(" No existe conexion abierta ");
        }
        
        
        PreparedStatement pst = null;
        ResultSet rst = null;
        LinkedList lista = new LinkedList();
        try {
            String query;
            query = "SELECT * FROM actor  where actor_id = ? ";     //Definir la consulta
            pst = conexion.con.prepareStatement(query);       //Prepararla
            pst.setInt(1, id);                         //Asignando parámetros a la consulta
                  
            rst = pst.executeQuery();                         //Ejecutarla 
            
            
            while (rst.next()) {
                lista.add(Actor.load(rst));                   //Recorre el RS y llena una lista
            }
            System.out.println("El Query " + query );
            
        }  finally {
            if (pst != null) {
                pst.close();
                pst = null;
            }
            if (rst != null) {
                rst.close();
                rst = null;
            }
        }
        return lista;                            //Retorna la lista llena
    }
    
}
