/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import dao.ClientesDao;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import orm.Clientes;

/**
 *
 * @author Tano
 */
@ManagedBean
@RequestScoped
public class ClientesController {
    //Atributos:
    private List<Clientes> listaClientes;
    private Clientes cliente;
    
    //Variables de pagna:
    private String titulo;
    private String nomBuscar;

    @EJB
    ClientesDao cDao;

    public ClientesController() {
        cliente = new Clientes();
    }

    public List<Clientes> getListaClientes() {
        if (listaClientes == null) {
            listaClientes = cDao.listarClientes();
        }
        return listaClientes;
    }

    public void setListaClientes(List<Clientes> Clientes) {
        this.listaClientes = listaClientes;
    }

    public Clientes getClientes() {
        return cliente;
    }

    public void setClientes(Clientes cliente) {
        this.cliente = cliente;
    }

    /**
     * MÉTODOS DE NAVEGACIÓN***
     */
    
    public String doIndex(){
        return "index";
    }
    
    public String doNuevo(){
        setTitulo("Nuevo Cliente");
        cliente = new Clientes();
        return "nuevo";
    }
    
    public String doEditar(Clientes c){
        cliente = c;
        setTitulo("Editar Cliente");
        return "nuevo";
    }
    
    public void doBuscar(AjaxBehaviorEvent e){
        listaClientes = cDao.listarClientes(getNomBuscar());
    }
    
    public void doVerNuevo(ActionEvent actionEvent) {
        cliente = new Clientes();
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the nomBuscar
     */
    public String getNomBuscar() {
        return nomBuscar;
    }

    /**
     * @param nomBuscar the nomBuscar to set
     */
    public void setNomBuscar(String nomBuscar) {
        this.nomBuscar = nomBuscar;
    }
    
    
    
}
