/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import orm.Clientes;

/**
 *
 * @author Tano
 */
@Stateless
public class ClientesDao {
    @PersistenceContext
    EntityManager em;
    
    //Métodos de consulta a la bd:
    public List<Clientes> listarClientes(){
        Query q;
        q = em.createQuery("SELECT c FROM Clientes c");
        return q.getResultList();
    }
    
    public List<Clientes> listarClientes(String nombre){
        Query q;
        q = em.createQuery("SELECT c FROM Mascotas c WHERE m.nombre LIKE :nombre");
        q.setParameter("nombre", "%" + nombre + "%");
        return q.getResultList();
    }
}

    

