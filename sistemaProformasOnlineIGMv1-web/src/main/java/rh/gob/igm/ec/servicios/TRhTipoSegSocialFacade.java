/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rh.gob.igm.ec.servicios;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import rh.gob.igm.ec.TRhTipoSegSocial;

/**
 *
 * @author TOAPANTA_JUAN
 */
@Stateless
public class TRhTipoSegSocialFacade extends AbstractFacade<TRhTipoSegSocial> {

    @PersistenceContext(unitName = "gob.igm.ec_rh_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TRhTipoSegSocialFacade() {
        super(TRhTipoSegSocial.class);
    }
    
}
