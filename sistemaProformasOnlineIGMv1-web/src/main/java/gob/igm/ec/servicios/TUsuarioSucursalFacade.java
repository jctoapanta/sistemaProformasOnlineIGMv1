/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.igm.ec.servicios;

import static gob.igm.ec.controladores.util.JasperReportUtil.localLogger;
import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author PULE_DIEGO
 */
@Stateless
public class TUsuarioSucursalFacade{
     @PersistenceContext(unitName = "gob.igm.ec_sistemaProformasOnlineIGMv1-ejb_ejb_1.0-SNAPSHOTPU")
     private EntityManager em;
     
     
     public String pwd (int no_persona,String clave){
        String personal = null;
         try {
            Query query = em.createNativeQuery("select PWD from TUSUARIOSUCURSAL WHERE ID_PERSONA =?1 and PWD=?2");          
            query.setParameter(1, no_persona);
            query.setParameter(2, clave);
            personal= (String) query.getSingleResult();
            
        } catch (Exception e) {
            localLogger.error(e.getMessage(), e);
        }
         return personal;
    }
    
     
    
    
}
