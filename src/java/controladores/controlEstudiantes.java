/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Estudiante;
import entidades.Estudiantes;
import entidades.Usuario;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelos.modeloEstudiante;


/**
 *
 * @author Casa
 */
@ManagedBean(name = "controlEstudiantes")
@SessionScoped
public class controlEstudiantes {
    private Estudiantes estudiante;
    private List<Estudiantes> lista;

    public controlEstudiantes() {
         estudiante = new Estudiantes();
    }

    public Estudiantes getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiantes estudiante) {
        this.estudiante = estudiante;
    }

    public List<Estudiantes> getLista() {
        modeloEstudiante modelo = new modeloEstudiante();
        lista = modelo.obtenerLista();
        return lista;
    }

    public void setLista(List<Estudiantes> lista) {
        this.lista = lista;
    }

  
    
    
   
   

    public void registrarUsuario() {
        System.out.println("Llego a la opcion registrar ");
        FacesContext contexto = FacesContext.getCurrentInstance();
        modeloEstudiante modelo = new modeloEstudiante();
        /* if (estudiante.getId() != 0) {
        // editar
        
        System.out.println("getId es dif de cero ");
        if (modelo.actualizar(estudiante)) {
        contexto.addMessage(null, new FacesMessage("Usuario actualizado"));
        } else {
        contexto.addMessage(null, new FacesMessage("No fue posible actualizar sus datos"));
        }
        estudiante = new Estudiante();
        } else {
        //registrar
        System.out.println("getId cero ");*/
        if (modelo.registar(estudiante)) {
            contexto.addMessage(null, new FacesMessage("Usuario registrado con exito"));
        } else {
            contexto.addMessage(null, new FacesMessage("No fue posible registrar sus datos"));
        }
        //}
    }
}
