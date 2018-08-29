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
import rh.gob.igm.ec.TDatEmpleado;

/**
 *
 * @author TOAPANTA_JUAN
 */
@Stateless
public class TDatEmpleadoFacade extends AbstractFacade<TDatEmpleado> {

    @PersistenceContext(unitName = "gob.igm.ec_rh_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TDatEmpleadoFacade() {
        super(TDatEmpleado.class);
    }

    public String logNombre(final String nombreFuncionario) {
        String retorno = null;
        try {
            Query query = em.createQuery("SELECT t.nombreC FROM TDatEmpleado t WHERE t.noCedula=?1");
            query.setParameter(1, nombreFuncionario);
            retorno = (String) query.getSingleResult();
        } catch (Exception e) {
            e.getMessage();
        }
        return retorno;
    }

    public String email(final String cedulaMail) {
        String mail = null;
        try {
            Query query = em.createQuery("SELECT t.emailInstitucional FROM TDatEmpleado t WHERE t.noCedula=?1");
            query.setParameter(1, cedulaMail);
            mail = (String) query.getSingleResult();
        } catch (Exception e) {
            e.getMessage();
        }
        return mail;
    }

    public int logFinanciero(final String cedula) {
        int retorno = 0;
        try {
            Query query = em.createQuery("SELECT t.noPersona FROM TDatEmpleado t WHERE t.noCedula=?1");
            query.setParameter(1, cedula);
            retorno = (int) query.getSingleResult();
        } catch (Exception e) {
            e.getMessage();
            //return .ZERO;
        }
        return retorno;
    }
}
