/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.igm.ec.servicios;

import gob.igm.ec.TcontrolIva;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.apache.log4j.Logger;

/**
 *
 * @author TOAPANTA_JUAN
 */
@Stateless
public class TcontrolIvaFacade extends AbstractFacade<TcontrolIva> {
 private static Logger localLogger;
    @PersistenceContext(unitName = "gob.igm.ec_sistemaProformasOnlineIGMv1-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public BigDecimal recuperaIva(){
        BigDecimal iva = null;
        try{
    
    Query query=em.createQuery("select o.valor from TcontrolIva o where o.control='A'");
    iva=(BigDecimal)query.getSingleResult();
        }catch(Exception ex){
        localLogger.error(ex);
        }
    return iva;
    }

    public TcontrolIvaFacade() {
        super(TcontrolIva.class);
    }
    
}
