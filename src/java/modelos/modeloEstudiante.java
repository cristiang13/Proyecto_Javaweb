/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import entidades.Estudiante;
import entidades.Estudiantes;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Casa
 */
public class modeloEstudiante {

    public modeloEstudiante() {
    }
    
    public boolean registar(Estudiantes estudiante){
      boolean resultado=false;
      
       try {
            Connection con = Conexion.obtener();
            String sql = "INSERT INTO `estudiante`(`id`,`nombres`, `apellidos`, `foto`, `fecha_nacimiento`, `email`, `fijo`, `movil`, `direccion`, `grupo`) VALUES (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement p = con.prepareStatement(sql);
            java.sql.Date sqlDate = new java.sql.Date(estudiante.getFecha_nac().getTime());
            p.setInt(1, estudiante.getId());
            p.setString(2, estudiante.getNombres());
            p.setString(3, estudiante.getApellidos());
            p.setString(4, estudiante.getFotos());
            p.setDate(5, sqlDate);
            p.setString(6, estudiante.getEmail());        
            p.setInt(7, estudiante.getFijo());
            p.setInt(8, estudiante.getMovil());
            p.setString(9, estudiante.getDireccion());              
            p.setString(10, estudiante.getGrupo());
            resultado = p.executeUpdate()>0;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.toString());
        }
        return resultado;
    
    
    }
    
    public boolean eliminar(int id){
    boolean resultado = false;
    
    
        try {
            Connection con = Conexion.obtener();
            String sql = "DELETE FROM USUARIO WHERE ID = ?";
            PreparedStatement p = con.prepareStatement(sql);
            p.setInt(1, id);
            resultado = p.executeUpdate()>0;
        } catch (SQLException ex) {
            Logger.getLogger(modeloEstudiante.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(modeloEstudiante.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return resultado;
    }
    
    public boolean actualizar(Estudiante estudiante){
        boolean resultado = false;
      
        
        try {
            Connection con = Conexion.obtener();
            String sql = "UPDATE `estudiante` SET `id`= ?,`nombres`= ?,`apellidos`=?,`foto`=?,`fecha_nacimiento`=?,`email`=?,`fijo`=?,`movil`=?,`direccion`=?,`grupo`=? WHERE id = ?";
            PreparedStatement p = con.prepareStatement(sql);
            java.sql.Date sqlDate = new java.sql.Date(estudiante.getFecha_nac().getTime());
             p.setInt(1,estudiante.getId());
            p.setString(2, estudiante.getNombres());
            p.setString(3, estudiante.getApellidos());
            p.setString(4, estudiante.getFoto());
            p.setDate(5, sqlDate);
            p.setString(6, estudiante.getEmail());
            p.setInt(7, estudiante.getFijo());
            p.setInt(8, estudiante.getMovil());
            p.setString(9, estudiante.getDireccion());
            p.setString(10, estudiante.getGrupo());
            p.setInt(11, estudiante.getId());
            resultado = p.executeUpdate()>0;
       } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.toString());
        }
     
        return resultado;   
    }
    
    public List<Estudiantes> obtenerLista(){
         List<Estudiantes> lista = new ArrayList<>();
        try {
            Connection con = Conexion.obtener();
            String sql = "SELECT * FROM estudiante";
            PreparedStatement p = con.prepareStatement(sql);
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                Estudiantes aux = new Estudiantes();
                aux.setId(rs.getInt("id"));
                aux.setNombres(rs.getString("nombres"));
                aux.setApellidos(rs.getString("apellidos"));
                aux.setFecha_nac(rs.getDate("fecha_nacimiento"));
                aux.setEmail(rs.getString("email"));
                aux.setDireccion(rs.getString("direccion"));
                aux.setFijo(rs.getInt("fijo"));
                aux.setMovil(rs.getInt("movil"));
                aux.setGrupo(rs.getString("grupo"));
                lista.add(aux);
            }
        } catch (SQLException ex) {
            Logger.getLogger(modeloEstudiante.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(modeloEstudiante.class.getName()).log(Level.SEVERE, null, ex);
        }
       return lista;
    }
    
}
