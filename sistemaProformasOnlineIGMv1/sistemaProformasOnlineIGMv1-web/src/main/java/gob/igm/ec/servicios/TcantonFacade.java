/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.igm.ec.servicios;

import gob.igm.ec.Tcanton;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author TOAPANTA_JUAN
 */
@Stateless
public class TcantonFacade extends AbstractFacade<Tcanton> {

    @PersistenceContext(unitName = "gob.igm.ec_sistemaProformasOnlineIGMv1-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TcantonFacade() {
        super(Tcanton.class);
    }
    
     /**
     * Realiza la búsqueda de cantones por provincia.
     * @param idProvincia
     * @return Object de tipo Object
     * @throws java.lang.Exception
     */
    public List<SelectItem> buscarCantonesXProvincia(String idProvincia) throws Exception {
        List<SelectItem> resultado = new ArrayList<>();
        Query query;
        try {
            
            query = em.createQuery("select o from Tcanton as o where o.tprovincia.provincia = ?1");
            query.setParameter(1, idProvincia);
            
            resultado=query.getResultList();
            return resultado;
            
        } catch (NoResultException e) {
            throw new Exception(e.getMessage(), e);
        } catch (NonUniqueResultException e) {
            throw new Exception(e.getMessage(), e);
        } catch (Exception e) {
            throw new Exception(e.getMessage(), e);
        }
    }    
}
