/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.igm.ec.servicios;

import gob.igm.ec.Tentidad;
import gob.igm.ec.controladores.util.JsfUtil;
import gob.igm.ec.controladores.util.constantes;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.ejb.Stateless;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author TOAPANTA_JUAN
 */
@Stateless
public class TentidadFacade extends AbstractFacade<Tentidad> {

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

    public TentidadFacade() {
        super(Tentidad.class);
    }

    /**
     * Busca los usuarios por su c?dula de identidad.
     *
     * @param ci C?dula de identidad
     * @return Lista de usuarios
     */
    public List<Tentidad> buscarPorCI(String ci) {
        List<Tentidad> usuario = new ArrayList<Tentidad>();
        try {
            Query query = em.createQuery("select e from Tentidad as e "
                    + this.likeCI(ci) + " order by e.ciu");
            query.setParameter(1, ci);
            usuario.addAll(query.getResultList());
        } catch (Exception e) {
            localLogger.error(e);
        }
        return usuario;
    }

    /**
     * Realiza la b?squeda de usuarios por su nombre. Si recibe % como par?metro
     * realiza una b?squeda con like.
     *
     * @param nombre Nombre del usuario
     * @return Lista de usuarios
     */
    public List<Tentidad> buscarUsuario(final String nombre) {
        List<Tentidad> usuario = new ArrayList<Tentidad>();
        try {
            Query query = em.createQuery("select e from Tentidad as e "
                    + this.likeNombre(nombre) + " order by e.ciu");
            if (StringUtils.contains(nombre, "%")) {
                query.setParameter(1, nombre.toUpperCase());
            } else {
                query.setParameter(1, nombre);
            }
            usuario.addAll(query.getResultList());
        } catch (Exception e) {
            localLogger.error(e);
        }
        return usuario;
    }

    /**
     * Realiza la b?squeda de usuarios mediante su id.
     *
     * @param usuario Nombre de usuario
     * @param clave
     * @return Entidad de tipo Tentidad
     * @throws java.lang.Exception
     */
    public List<Tentidad> buscarUsuarioClave(final String usuario, final String clave) throws Exception {
        List<Tentidad> resultado = null;
        Query query = null;
        try {
            query = em.createQuery("select o from Tentidad as o "
                    + "where o.ciu = ?1 and o.clave = ?2");
            query.setParameter(1, usuario);
            query.setParameter(2, clave);
            resultado = query.getResultList();
            return resultado;
        } catch (NoResultException e) {
            throw new Exception(e.getMessage(), e);
        } catch (NonUniqueResultException e) {
            throw new Exception(e.getMessage(), e);
        } catch (Exception e) {
            throw new Exception(e.getMessage(), e);
        }
    }

    /**
     * Realiza la b?squeda de usuarios mediante su id.
     *
     * @param usuario Nombre de usuario
     * @return Entidad de tipo Tentidad
     * @throws java.lang.Exception
     */
    public List<Object> buscarExisteUsuario(final String usuario) throws Exception {
        List<Object> resultado;
        Query query = null;
        try {

            query = em.createQuery("select o from Tentidad as o "
                    + "where o.ciu = ?1");
            query.setParameter(1, usuario);

            resultado = query.getResultList();
            return resultado;

        } catch (NoResultException e) {
            throw new Exception(e.getMessage(), e);
        } catch (NonUniqueResultException e) {
            throw new Exception(e.getMessage(), e);
        } catch (Exception e) {
            throw new Exception(e.getMessage(), e);
        }
    }

    /**
     * Genera el segmento de la cadena ejbql para la b?squeda de los usuarios
     * por CI.
     *
     * @param ci C?dula de identidad
     * @return Cadena ejbql
     */
    private String likeCI(final String ci) {
        String cadena = "where ";
        if (StringUtils.contains(ci, "%")) {
            cadena += "e.ciu like ?1 ";
        } else {
            cadena += "e.ciu = ?1";
        }
        return cadena;
    }

    /**
     * Genera el segmento de la cadena ejbql para la b?squeda de los usuarios
     * por nombre.
     *
     * @param nombre Nombre del usuario
     * @return Cadena ejbql
     */
    private String likeNombre(final String apellidos) {
        String cadena = "where ";
        if (StringUtils.contains(apellidos, "%")) {
            cadena += "upper(e.apellidos) like ?1 ";
        } else {
            cadena += "e.apellidos = ?1";
        }
        return cadena;
    }

    public void enviarReseteoClave(String email) throws MessagingException {
        try {
            //ENVIO DE CORREO
            Properties props = new Properties();
            props.put("mail.smtp.host", "mail.igm.gob.ec");
            props.setProperty("mail.smtp.port", "25");
            //ENVIO de correo con adjunto
            BodyPart texto = new MimeBodyPart();
            texto.setText("Usted ha solicitado un reseteo de su clave copie el siguiente enlace en su navegador:\n\n"
                    + "http://localhost:15145/sistemaProformasOnlineIGMv1-web/\n\n"
                    + " y utilice la siguiente clave temporal para acceder: \n\n"
                    + constantes.CLAVEXDEFECTO
                    + "\n\nEl sistema le solicitará cambio de clave.");
            // Una MultiParte para agrupar texto e imagen.
            MimeMultipart multiParte = new MimeMultipart();
            multiParte.addBodyPart(texto);

            Session session = Session.getDefaultInstance(props, null);
            MimeMessage message = new MimeMessage(session);
            String dirEmailEnvio = email;
            message.addRecipient(
                    Message.RecipientType.TO,
                    new InternetAddress(dirEmailEnvio));
            message.setSubject("Reseteo de clave");
            //Se envía correo
            envioCorreo(multiParte, message, session);
        } catch (AddressException | IOException ex) {
            JsfUtil.addErrorMessage(ex.getMessage());
        }

    }

    public Tentidad actualizaClave(Tentidad entidad) {
        Tentidad resultadoActualiza = em.merge(entidad);
        return resultadoActualiza;
    }
}
