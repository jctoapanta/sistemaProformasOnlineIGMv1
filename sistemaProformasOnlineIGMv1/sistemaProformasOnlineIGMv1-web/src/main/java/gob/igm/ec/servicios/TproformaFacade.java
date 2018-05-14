/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.igm.ec.servicios;

import gob.igm.ec.Tproforma;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author TOAPANTA_JUAN
 */
@Stateless
public class TproformaFacade extends AbstractFacade<Tproforma> {
    /** La variable logger. */
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

    public void upload(UploadedFile e, Long id_proforma) throws Exception {
        
        if (e != null) {
            //ENVIO MAIL-carga
            File destFile = new File(e.getFileName()); 
            FileUtils.copyInputStreamToFile(e.getInputstream(), destFile);
            
            Properties props = new Properties();
            props.put("mail.smtp.host", "mail.igm.gob.ec");
            props.setProperty("mail.smtp.port", "25");

            Session session = Session.getDefaultInstance(props, null);
            
            //CARGA  de archivo en Base de Datos
            try (Connection cn = em.unwrap(Connection.class)) {
                PreparedStatement st = cn.prepareStatement("UPDATE TPROFORMA SET COMPROBANTE_PAGO=? WHERE ID_PROFORMA=?");
                st.setBinaryStream(1, e.getInputstream());// file.getInputstream());
                st.setLong(2, id_proforma);
                st.executeUpdate();
            }
            mensaje.setSeverity(FacesMessage.SEVERITY_ERROR);
            mensaje.setSummary("Archivo subido con éxito");
            
            //ENVIO de correo con adjunto
            // Se compone la parte del texto
            BodyPart texto = new MimeBodyPart();
            texto.setText("VERIFIQUE COMPROBANTE DE PAGO");

            // Se compone el adjunto con la imagen
            BodyPart adjunto = new MimeBodyPart();
            FileDataSource ds=new FileDataSource(e.getFileName());
            adjunto.setDataHandler(
                new DataHandler(ds));    
            adjunto.setFileName(destFile.toString());

            // Una MultiParte para agrupar texto e imagen.
            MimeMultipart multiParte = new MimeMultipart();
            multiParte.addBodyPart(texto);
            multiParte.addBodyPart(adjunto);

            // Se compone el correo, dando to, from, subject y el
            // contenido.
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("igm@mail.igm.gob.ec"));
            message.addRecipient(
                Message.RecipientType.TO,
                new InternetAddress("juancarlos.toapanta@mail.igm.gob.ec"));
            message.setSubject("Validar Comprobante de pago");
            message.setContent(multiParte);

            // Se envia el correo.
            Transport t = session.getTransport("smtp");
            t.connect();
            t.sendMessage(message, message.getAllRecipients());
            t.close();            
        } else {
            mensaje.setSeverity(FacesMessage.SEVERITY_ERROR);
            mensaje.setSummary("No se encuentra el archivo");
        }
    }    
    
        /**
     * Realiza la b?squeda de usuarios por su nombre. Si recibe % como par?metro
     * realiza una b?squeda con like.
     * @param pCiu identificación del cliente
     * @param pIdPeriodo identificación del periodo
     * @return Lista de proformas
     */
    public List<Tproforma> buscarProformsXCliente(final String pCiu, final Short pIdPeriodo) {
        List<Tproforma> proforma = new ArrayList<>();
        try {
            TypedQuery<Tproforma> query= em.createNamedQuery("Tproforma.findByIdPeriodoAndCiu",Tproforma.class);
                    query.setParameter("idPeriodo",  pIdPeriodo);
                    query.setParameter("ciu", pCiu);
                    
            proforma=query.getResultList();
        } catch (Exception e) {
            localLogger.error(e);
        }
        return proforma;
    }
}