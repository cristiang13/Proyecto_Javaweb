/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author casa
 */
public class Estudiantes extends Usuario{
    private String fotos,grupo,direccion;
    private int fijo;

    public Estudiantes() {
              
    }

    public String getFotos() {
        return fotos;
    }

    public void setFotos(String fotos) {
        this.fotos = fotos;
    }

    


    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getFijo() {
        return fijo;
    }

    public void setFijo(int fijo) {
        this.fijo = fijo;
    }
    
    
    
}
