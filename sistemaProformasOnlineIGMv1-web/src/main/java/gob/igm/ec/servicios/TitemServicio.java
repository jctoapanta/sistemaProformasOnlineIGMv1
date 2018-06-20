/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.igm.ec.servicios;

import gob.igm.ec.Titem;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author PULE_DIEGO
 */
@Stateless
@LocalBean
public class TitemServicio {
    @PersistenceContext(unitName = "gob.igm.ec_sistemaProformasOnlineIGMv1-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

  
    protected EntityManager getEntityManager() {
        return em;
    }
  
        public List<Titem> findAll(){
        List<Titem> lista = new ArrayList<Titem>();
        Query query = em.createQuery("SELECT t FROM Titem t WHERE t.lVentaOnline = 1");
        lista.addAll(query.getResultList());
          return lista; 
     
          
       
    }
    
    public Titem getDatos(int iditem)
    {
        Titem item = new Titem();
        try{
        Query query = em.createQuery("SELECT t FROM Titem t where t.idItem=?1");
        query.setParameter(1, iditem);
        item=(Titem)query.getSingleResult();
        } catch (Exception e) {
            
            
            
            
        }
        return item;
    }
    
    
   
}
