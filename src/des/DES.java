/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package des;

/**
 *
 * @author Ingeneo
 */
import java.io.*;
import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import java.security.*;
import java.util.*;

public class DES {

    public static void main(String[] args) {

        try {
            //Crea una llave DES
            KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
            SecretKey myDesKey = keygenerator.generateKey();

            Cipher desCipher; //instancia de la clase cifrado

            // Create the cipher
            desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            //DES = Data Encryption Standard.
            //ECB = Electronic Codebook mode.
            //PKCS5Padding = PKCS #5-style padding.

            // Initialize the cipher for encryption
            desCipher.init(Cipher.ENCRYPT_MODE, myDesKey);

            //sensitive information
            byte[] text = "No body can see me".getBytes(); // Convert String into Byte[] array format.

            System.out.println("Text [Byte Format] : " + text);
            System.out.println("Text : " + new String(text));

            // Encrypt the text
            byte[] textEncrypted = desCipher.doFinal(text);

            System.out.println("Text Encryted : " + textEncrypted);

            // Initialize the same cipher for decryption
            desCipher.init(Cipher.DECRYPT_MODE, myDesKey);

            // Decrypt the text
            byte[] textDecrypted = desCipher.doFinal(textEncrypted);

            System.out.println("Text Decryted : " + new String(textDecrypted));

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
    }
}
