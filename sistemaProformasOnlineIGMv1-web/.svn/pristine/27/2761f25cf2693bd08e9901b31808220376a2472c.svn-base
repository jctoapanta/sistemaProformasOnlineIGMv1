/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.igm.ec.controladores.util;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 *Clase dedicada a la encriptaci�n y descencriptaci�n de datos.
 * @author CAIZA_CARLOS
 */
public class EncriptUtil extends FacesUtil {

    /**
     * Genera la llave.
     * @return Llave
     * @throws NoSuchAlgorithmException
     */
    public SecretKey getSecretKey() throws NoSuchAlgorithmException {
        String llave = super.getRecursoGeneral().getString("llaveDES");
        SecretKey ks = new SecretKeySpec(llave.getBytes(), "DES");
        return ks;
    }

    /**
     * Desencripta palabras encriptadas con DES.
     *
     * @param code Clave a desencriptar
     * @return Clave desencriptada
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws IOException
     * @throws IllegalBlockSizeException
     * @throws NoSuchPaddingException
     * @throws BadPaddingException
     */
    public String decrypt3DES(String code)
            throws NoSuchAlgorithmException, InvalidKeyException, IOException,
            IllegalBlockSizeException, NoSuchPaddingException,
            BadPaddingException {

        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, this.getSecretKey());

        BASE64Decoder decoder = new BASE64Decoder();
        byte[] raw = decoder.decodeBuffer(code);
        byte[] stringBytes = cipher.doFinal(raw);
        String result = new String(stringBytes, "UTF8");

        return result;
    }

    /**
     * Encripta la clave con DES.
     * @param code Clave a encriptar
     * @return
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws NoSuchPaddingException
     * @throws IOException
     * @throws IllegalStateException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     */
    public String encrypt3DES(String code)
            throws NoSuchAlgorithmException, InvalidKeyException,
            NoSuchPaddingException, IOException, IllegalStateException, IllegalBlockSizeException, BadPaddingException {

        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, this.getSecretKey());

        byte[] stringBytes = code.getBytes("UTF8");
        byte[] raw = cipher.doFinal(stringBytes);
        BASE64Encoder encoder = new BASE64Encoder();
        String base64 = encoder.encode(raw);

        return base64;
    }
}
