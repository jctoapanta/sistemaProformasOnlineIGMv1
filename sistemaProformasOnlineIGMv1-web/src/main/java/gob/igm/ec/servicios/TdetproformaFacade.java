/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.igm.ec.servicios;

import gob.igm.ec.Tdetproforma;
import static gob.igm.ec.controladores.util.JasperReportUtil.localLogger;
import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author TOAPANTA_JUAN
 */
@Stateless
public class TdetproformaFacade extends AbstractFacade<Tdetproforma> {
    @PersistenceContext(unitName = "gob.igm.ec_sistemaProformasOnlineIGMv1-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TdetproformaFacade() {
        super(Tdetproforma.class);
    }
    public BigDecimal totalProforma(final Long pNoProforma, final Short pIdPeriodo) {
        try {
            Query query = em.createQuery("SELECT SUM(t.pvpTotal) FROM Tdetproforma t WHERE t.tdetproformaPK.idPeriodo = :idPeriodo AND t.tdetproformaPK.idProforma=:idProforma");
            query.setParameter("idPeriodo",pIdPeriodo);
            query.setParameter("idProforma", pNoProforma);
            return (BigDecimal) query.getSingleResult();
        } catch (Exception e) {
            localLogger.error(e.getMessage(), e);
            return BigDecimal.ZERO;
        }
    }

    
    public BigDecimal cantidad_peso(Long idProforma){
        BigDecimal cantidad_p = null;
        try {
            Query query = em.createQuery("select sum(t.cantidad) "
                    + "from Tdetproforma as t where t.tdetproformaPK.idProforma=?1"
            );
          
            query.setParameter(1, idProforma);
            cantidad_p= (BigDecimal) query.getSingleResult();
        } catch (Exception e) {
            localLogger.error(e.getMessage(), e);
            //return 0;
        }
        return cantidad_p;
    }
    
    
}
