package clientes;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

/**
 * CifradoUtil
 * -----------
 * Clase de utilidad para cifrar/descifrar la cédula.
 * Usamos AES con una clave fija (solo para demo).
 * 
 * NOTA: En un sistema real, la clave debe almacenarse de forma segura.
 */
public class CifradoUtil {
    private static final String CLAVE_SECRETA = "1234567890123456"; // 16 caracteres = 128 bits

    public static String cifrar(String dato) {
        try {
            SecretKeySpec secretKey = new SecretKeySpec(CLAVE_SECRETA.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] cifrado = cipher.doFinal(dato.getBytes());
            return Base64.getEncoder().encodeToString(cifrado);
        } catch (Exception e) {
            throw new RuntimeException("Error al cifrar: " + e.getMessage());
        }
    }

    public static String descifrar(String datoCifrado) {
        try {
            SecretKeySpec secretKey = new SecretKeySpec(CLAVE_SECRETA.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] descifrado = cipher.doFinal(Base64.getDecoder().decode(datoCifrado));
            return new String(descifrado);
        } catch (Exception e) {
            throw new RuntimeException("Error al descifrar: " + e.getMessage());
        }
    }
}
