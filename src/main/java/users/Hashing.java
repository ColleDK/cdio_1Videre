package users;

import javax.xml.bind.DatatypeConverter;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import java.security.MessageDigest;

public class Hashing {
    // Converts to MD2, MD5, SHA-1, SHA-256, SHA-384, SHA-512
    public static String getHash(byte[] bytes, String algoritm) throws NoSuchAlgorithmException {
        String hashValue = "";
        MessageDigest md = MessageDigest.getInstance(algoritm);
        md.update(bytes);
        byte[] digestBytes = md.digest();
        hashValue = DatatypeConverter.printHexBinary(digestBytes);

        return hashValue.toLowerCase();
    }
}