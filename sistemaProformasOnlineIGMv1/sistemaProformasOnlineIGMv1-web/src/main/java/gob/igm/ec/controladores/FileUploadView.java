package gob.igm.ec.controladores;

import java.io.File;
import javax.faces.application.FacesMessage;
import javax.enterprise.context.RequestScoped;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import org.primefaces.event.FileUploadEvent;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletContext;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import org.primefaces.model.UploadedFile;

@Named ("fileUploadView")
@RequestScoped
public class FileUploadView {
    @Inject
    private TproformaController tproformaController;
    
    private UploadedFile file;
    FacesMessage mensaje = new FacesMessage();

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public void upload(FileUploadEvent e) throws Exception {
        if (e.getFile() != null) {
            //if (this.getFile() != null) {
            //ENVIO MAIL-INICIO
            String fileName  = e.getFile().getFileName();
            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            String newFileName = servletContext.getRealPath(e.getFile().toString()) + File.separator + "upload" +    File.separator+ fileName;
            
            File destFile = new File(e.getFile().getFileName()); 
            FileUtils.copyInputStreamToFile(e.getFile().getInputstream(), destFile);
            
            Properties props = new Properties();
            props.put("mail.smtp.host", "192.168.3.242");
            props.setProperty("mail.smtp.port", "25");
            //props.setProperty("mail.smtp.user", "juancarlos.toapanta@mail.igm.gob.ec");
            //props.setProperty("mail.smtp.auth", "true");

            Session session = Session.getDefaultInstance(props, null);
            // session.setDebug(true);
            
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
            message.setSubject("Prueba");
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
}
