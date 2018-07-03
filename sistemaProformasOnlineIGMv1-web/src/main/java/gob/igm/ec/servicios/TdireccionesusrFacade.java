/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.igm.ec.servicios;

import gob.igm.ec.Tdireccionesusr;
import gob.igm.ec.controladores.util.JsfUtil;
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
    
    /**
     * Realiza conteo de direccion domiciliaria del usuario actual, para ver si existe.
     * @param pCiu identificación del cliente
     * @return direccionExiste
     */
    public Long buscarExisteDireccionDomicilioCliente(final String pCiu) {
        Long direccionExiste = 0L;
        Integer pIdTipoDir=1;
        Query query = null;
        try {
            query = em.createQuery("SELECT COUNT(o) FROM Tdireccionesusr o WHERE o.ciu.ciu = ?1 AND o.idTipoDireccion.idTipoDireccion = ?2");
            query.setParameter(1, pCiu);
            query.setParameter(2, pIdTipoDir);
            direccionExiste=(Long) query.getSingleResult();
        } catch (Exception e) {
            localLogger.error(e);
        }
        return direccionExiste;
    }    

    /**
     * Realiza conteo de direccion domiciliaria del usuario actual, para ver si existe.
     * @param pCiu identificación del cliente
     * @return direccionExiste
     */
    public Long cuentaDireccionesCliente(final String pCiu) {
        Long direccionExiste = 0L;
        Query query = null;
        try {
            query = em.createQuery("SELECT COUNT(o) FROM Tdireccionesusr o WHERE o.ciu.ciu = ?1");
            query.setParameter(1, pCiu);
            direccionExiste=(Long) query.getSingleResult();
        } catch (Exception e) {
            localLogger.error(e);
        }
        return direccionExiste;
    }
   
    /**
     * Realiza conteo de direccion domiciliaria del usuario actual, para ver si existe.
     * @param pCiu identificación del cliente
     * @return direccionExiste
     */
    public Long buscarExisteDireccionEnvioCliente(final String pCiu) {
        Long direccionExiste = 0L;
        Integer pIdTipoDir=1;
        Query query = null;
        try {
            query = em.createQuery("SELECT COUNT(o) FROM Tdireccionesusr o WHERE o.ciu.ciu = ?1 AND o.idTipoDireccion.idTipoDireccion IN (2,3)");
            query.setParameter(1, pCiu);
            //query.setParameter(2, pIdTipoDir);
            direccionExiste=(Long) query.getSingleResult();
        } catch (Exception e) {
            localLogger.error(e);
        }
        return direccionExiste;
    }    
    
    /**
     * Realiza la b?squeda de ID de la direccion domiciliaria del usuario actual.
     * @param pCiu identificación del cliente
     * @return Id de Direccion
     */
    public Tdireccionesusr buscarDireccionDomicilioCliente(final String pCiu) {
        Tdireccionesusr idDireccionC = new Tdireccionesusr();
        Integer pIdTipoDir=1;
        Query query = null;
        try {
            query = em.createQuery("SELECT o FROM Tdireccionesusr o WHERE o.ciu.ciu = ?1 AND o.idTipoDireccion.idTipoDireccion = ?2");
            query.setParameter(1, pCiu);
            query.setParameter(2, pIdTipoDir);
            idDireccionC=(Tdireccionesusr) query.getSingleResult();
            if (idDireccionC.equals(null)) {
                JsfUtil.addErrorMessage("Usted aún no ha registrado una dirección domiciliaria, por favor agréguela.");
            }
        } catch (Exception e) {
            localLogger.error(e);
        }
        return idDireccionC;
    }
    
    public Long obtenerSiguienteValor(){
        Long siguienteValor=0L;
        Query query= em.createQuery("SELECT MAX(t.idDireccion)+1 FROM Tdireccionesusr t");
        siguienteValor=(Long) query.getSingleResult();
        
        return siguienteValor;
    }
    
    public Tdireccionesusr actualizaDirecciones (Tdireccionesusr direcciones){
        Tdireccionesusr resultadoActualiza=em.merge(direcciones);
        return resultadoActualiza;        
    }
}
