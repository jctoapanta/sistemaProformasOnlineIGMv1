/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rh.gob.igm.ec.servicios;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import rh.gob.igm.ec.TContrataciones;

/**
 *
 * @author TOAPANTA_JUAN
 */
@Stateless
public class TContratacionesFacade extends AbstractFacade<TContrataciones> {

    @PersistenceContext(unitName = "gob.igm.ec_rh_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TContratacionesFacade() {
        super(TContrataciones.class);
    }
        public String Estados(final String cedula) {
        String retorno = "";
        try {
            Query query = em.createQuery("SELECT t.estado FROM TContrataciones t WHERE t.tDatEmpleado.noCedula=?1 and t.estado='V' and t.tAreas.tAreasPK.noCd=14 ");         
            query.setParameter(1, cedula);
            retorno = (String) query.getSingleResult();
        } catch (Exception e) {
            e.getMessage();
            //return .ZERO;
        }
        return retorno;
    }
    
    
    
}
