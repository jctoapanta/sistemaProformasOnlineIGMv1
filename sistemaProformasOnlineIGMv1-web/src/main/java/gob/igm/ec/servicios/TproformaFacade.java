/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.igm.ec.servicios;

import gob.igm.ec.Tproforma;
import gob.igm.ec.controladores.util.JasperReportUtil;
import gob.igm.ec.controladores.util.JsfUtil;
import java.io.File;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author TOAPANTA_JUAN
 */
@Stateless
public class TproformaFacade extends AbstractFacade<Tproforma> {

    /**
     * La variable logger.
     */
    private static Logger localLogger;
    @PersistenceContext(unitName = "gob.igm.ec_sistemaProformasOnlineIGMv1-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TproformaFacade() {
        super(Tproforma.class);
    }

    FacesMessage mensaje = new FacesMessage();

    /**
     * Función para generar PDF de la Proforma
     *
     * @param parameters
     */
    public void generaPDF(Map<String, Object> parameters) {
        try {
            Connection cn = em.unwrap(Connection.class);
            JasperReportUtil jasper = new JasperReportUtil();
            jasper.jasperReport(cn, JasperReportUtil.PATH_REPORTE_PROFORMA, JasperReportUtil.TIPO_PDF, parameters);
        } catch (ClassNotFoundException ex) {
            JsfUtil.addErrorMessage("Archivo no se generó correctamente.");
        }
    }

    /**
     * Para actualizar la consulta
     *
     * @param parameters
     */
     public void grabarRecargo (BigDecimal valorenvio,Long idproforma, String direccion_local){
            try{
            Query queryRecargo = em.createQuery("update Tproforma set valorEnvio=?1, dirEnvioEf = ?2 where tproformaPK.idProforma=?3 ");
            queryRecargo.setParameter(1, valorenvio);
            queryRecargo.setParameter(2, direccion_local);
            queryRecargo.setParameter(3, idproforma);
            queryRecargo.executeUpdate();

        } catch (Exception e) {
            localLogger.error(e);
        }
    }

    
    public void upload(UploadedFile e, Long id_proforma) throws Exception {

        if (e != null) {
            //ENVIO MAIL-carga
            File destFile = new File(e.getFileName());
            FileUtils.copyInputStreamToFile(e.getInputstream(), destFile);

            //CARGA  de archivo en Base de Datos
            try (Connection cn = em.unwrap(Connection.class)) {
                PreparedStatement st = cn.prepareStatement("UPDATE TPROFORMA SET COMPROBANTE_PAGO=?, ESTADO='V' WHERE ID_PROFORMA=?");
                st.setBinaryStream(1, e.getInputstream());// file.getInputstream());
                st.setLong(2, id_proforma);
                st.executeUpdate();
            }
            JsfUtil.addSuccessMessage("Archivo subido con éxito");
            
            //ENVIO DE CORREO
            
            Properties props = new Properties();
            props.put("mail.smtp.host", "mail.igm.gob.ec");
            props.setProperty("mail.smtp.port", "25");
            //ENVIO de correo con adjunto
            BodyPart texto = new MimeBodyPart();
            texto.setText("VERIFIQUE COMPROBANTE DE PAGO DEL PEDIDO (PROFORMA) No. " + id_proforma);
            // Se compone el adjunto con la imagen
            BodyPart adjunto = new MimeBodyPart();
            FileDataSource ds = new FileDataSource(e.getFileName());
            adjunto.setDataHandler(
                    new DataHandler(ds));
            adjunto.setFileName(destFile.toString());
            // Una MultiParte para agrupar texto e imagen.
            MimeMultipart multiParte = new MimeMultipart();
            multiParte.addBodyPart(texto);
            multiParte.addBodyPart(adjunto);

            Session session = Session.getDefaultInstance(props, null);
            MimeMessage message = new MimeMessage(session);
            String dirEmailFinanciero="juancarlos.toapanta@mail.igm.gob.ec";
            message.addRecipient(
                    Message.RecipientType.TO,
                    new InternetAddress(dirEmailFinanciero));
            message.setSubject("Validar Comprobante de pago");
            //Se envía correo
            envioCorreo(multiParte, message, session);

        } else {
            JsfUtil.addErrorMessage("No se encuentra el archivo");
        }
    }

    /**
     * Realiza la b?squeda de usuarios por su nombre. Si recibe % como par?metro
     * realiza una b?squeda con like.
     *
     * @param pCiu identificación del cliente
     * @param pIdPeriodo identificación del periodo
     * @return Lista de proformas
     */
    public List<Tproforma> buscarProformsXCliente(final String pCiu, final Short pIdPeriodo) {
        List<Tproforma> proforma = new ArrayList<>();
        try {
            em.getEntityManagerFactory().getCache().evictAll();
            TypedQuery<Tproforma> query = em.createNamedQuery("Tproforma.findByIdPeriodoAndCiu", Tproforma.class);
            query.setParameter("idPeriodo", pIdPeriodo);
            query.setParameter("ciu", pCiu);

            proforma = query.getResultList();
        } catch (Exception e) {
            localLogger.error(e);
        }
        return proforma;
    }
        
        public List<Tproforma> buscarProformsXEstado(String estado) {
        List<Tproforma> proforma = new ArrayList<>();
        try {
            em.getEntityManagerFactory().getCache().evictAll();
            TypedQuery<Tproforma> query = em.createNamedQuery("Tproforma.findByEstado", Tproforma.class);
            query.setParameter("estado", estado);
            proforma = query.getResultList();
          
        } catch (Exception e) {
            localLogger.error(e);
        }
        return proforma;
    }
        /**
        * Cambia de estado a aprobado_facturacion
        * @param proforma 
        */
        public void aprobarFinanciero(Long idProforma,String estado){
            try{
            Query queryAprobacion = em.createQuery("update Tproforma set estado=?1 where tproformaPK.idProforma=?2 ");
            queryAprobacion.setParameter(1,estado );
            queryAprobacion.setParameter(2,idProforma );
            queryAprobacion.executeUpdate();
            Properties props = new Properties();
            props.put("mail.smtp.host", "mail.igm.gob.ec");
            props.setProperty("mail.smtp.port", "25");
            //ENVIO de correo con adjunto
            BodyPart texto = new MimeBodyPart();
            texto.setText("PAGO VERIFICADO POR FAVOR PROCEDA CON LA FACTURACION (PROFORMA) No."+idProforma);
            MimeMultipart multiParte = new MimeMultipart();
            multiParte.addBodyPart(texto);
          
            Session session = Session.getDefaultInstance(props, null);
            MimeMessage message = new MimeMessage(session);
            String dirEmailFinanciero="diego.pule@mail.igm.gob.ec";
            message.addRecipient(
                    Message.RecipientType.TO,
                    new InternetAddress(dirEmailFinanciero));
            message.setSubject("Validar Comprobante de pago");
            //Se envía correo
            envioCorreo(multiParte, message, session);


        } catch (Exception e) {
            localLogger.error(e);
        }
    }
        
        
    public List<Tproforma> buscarProformsXClienteTotal(final String pCiu, final Short pIdPeriodo) {
        List<Tproforma> proforma = new ArrayList<>();
        Query query;
        try {
            query = em.createQuery("SELECT t FROM Tproforma t WHERE t.tproformaPK.idPeriodo = :idPeriodo and t.ciu.ciu = :ciu");
            query.setParameter("idPeriodo", pIdPeriodo);
            query.setParameter("ciu", pCiu);

            proforma = query.getResultList();
        } catch (Exception e) {
            localLogger.error(e);
        }
        return proforma;
    }
    
    public Long maxId() {
        try {
            Query query = em.createQuery("select max(o.tproformaPK.idProforma) "
                    + "from Tproforma as o "
            );
            return (Long) query.getSingleResult();
        } catch (Exception e) {
            localLogger.error(e.getMessage(), e);
            return 0L;
        }
    }
}
