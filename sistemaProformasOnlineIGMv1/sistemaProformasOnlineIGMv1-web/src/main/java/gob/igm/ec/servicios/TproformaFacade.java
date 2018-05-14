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

    public void upload(FileUploadEvent e) throws Exception {
        if (e.getFile() != null) {
            //if (this.getFile() != null) {
            //ENVIO MAIL-INICIO
            File destFile = new File(e.getFile().getFileName()); 
            FileUtils.copyInputStreamToFile(e.getFile().getInputstream(), destFile);
            
            Properties props = new Properties();
            props.put("mail.smtp.host", "192.168.3.242"); //igm.gob.ec192.168.3.242
            props.setProperty("mail.smtp.port", "25");

            Session session = Session.getDefaultInstance(props, null);
            
            Class.forName("oracle.jdbc.OracleDriver");
            
            Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.35.88:1521:GEO", "PTV", "PPTVIGM2009");
            PreparedStatement st = cn.prepareStatement("UPDATE TPROFORMA SET COMPROBANTE_PAGO=? WHERE ID_PROFORMA=999");
            st.setBinaryStream(1, e.getFile().getInputstream());// file.getInputstream());
            st.executeUpdate();
            cn.close();
            mensaje.setSeverity(FacesMessage.SEVERITY_ERROR);
            mensaje.setSummary("Archivo subido con éxito");
            
            //ENVIO ARCHIVO
            // Se compone la parte del texto
            BodyPart texto = new MimeBodyPart();
            texto.setText("VERIFIQUE COMPROBANTE DE PAGO");

            // Se compone el adjunto con la imagen
            BodyPart adjunto = new MimeBodyPart();
            FileDataSource ds=new FileDataSource(e.getFile().getFileName());
            adjunto.setDataHandler(
                new DataHandler(ds));    
                /*new DataHandler(new FileDataSource("/home/prueba.txt")));*/
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
            //ENVIO MAIL-FIN
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
