/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.igm.ec.servicios;

import gob.igm.ec.Ttarifario;
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
public class TtarifarioFacade extends AbstractFacade<Ttarifario> {

    @PersistenceContext(unitName = "gob.igm.ec_sistemaProformasOnlineIGMv1-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TtarifarioFacade() {
        super(Ttarifario.class);
    }

    public BigDecimal valor_tarifario(BigDecimal cantidad) {
        BigDecimal valor_tarifa = null;
        try {
            Query query = em.createNativeQuery("SELECT  max(T.VALOR) "
                    + "FROM TPROFORMA "
                    + "INNER JOIN  TDIRECCIONESUSR DIR ON DIR.CIU = TPROFORMA.CIU "
                    + "AND DIR.L_ENVIO = 1 "
                    + "INNER JOIN TCANTON C1 ON C1.ID_CANTON=DIR.ID_CANTON "
                    + "INNER JOIN TTARIFARIO T ON T.ID_ZONA=C1.ID_ZONA "
                    + "where T.PESO_MIN<=?1 and T.PESO_MAX>=?1"
            );
            query.setParameter(1, cantidad);
            valor_tarifa = (BigDecimal) query.getSingleResult();
        } catch (Exception e) {
            localLogger.error(e.getMessage(), e);
        }
        return valor_tarifa;
    }

}
