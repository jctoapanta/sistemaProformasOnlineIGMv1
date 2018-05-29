/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.igm.ec.servicios;

import gob.igm.ec.Tdireccionesusr;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.apache.log4j.Logger;

/**
 *
 * @author TOAPANTA_JUAN
 */
@Stateless
public class TdireccionesusrFacade extends AbstractFacade<Tdireccionesusr> {
    
    /** La variable logger. */
    private static Logger localLogger;
    
    @PersistenceContext(unitName = "gob.igm.ec_sistemaProformasOnlineIGMv1-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TdireccionesusrFacade() {
        super(Tdireccionesusr.class);
    }
    
        /**
     * Realiza la b?squeda de direcciones por usuario. Si recibe % como par?metro
     * realiza una b?squeda con like.
     * @param pCiu identificación del cliente
     * @return Lista de proformas
     */
    public List<Tdireccionesusr> buscarDireccionesXCliente(final String pCiu) {
        List<Tdireccionesusr> direccion = new ArrayList<>();
        try {
            TypedQuery<Tdireccionesusr> query= em.createNamedQuery("Tdireccionesusr.findByCiu",Tdireccionesusr.class);
                    query.setParameter("ciu", pCiu);
                    
            direccion=query.getResultList();
        } catch (Exception e) {
            localLogger.error(e);
        }
        return direccion;
    }    
    public Long obtenerSiguienteValor(){
        Long siguienteValor=0L;
        List<Tdireccionesusr> id_dir;
        Query query= em.createQuery("SELECT MAX(t.idDireccion)+1 FROM Tdireccionesusr t");
        siguienteValor=(Long) query.getSingleResult();
        
        return siguienteValor;
    }
}
