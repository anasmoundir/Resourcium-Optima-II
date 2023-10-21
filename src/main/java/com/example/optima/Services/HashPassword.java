package com.example.optima.Services;

import jakarta.annotation.Resource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.security.enterprise.identitystore.PasswordHash;
import jakarta.security.enterprise.identitystore.Pbkdf2PasswordHash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@ApplicationScoped
public class HashPassword {

    public static String hashPassword(String pw){
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(pw.getBytes());
            byte[] bytes = md.digest();
            StringBuilder hashedPassword = new StringBuilder();
            for(byte b : bytes){
                hashedPassword.append(String.format("%02x",b));
            }
            return hashedPassword.toString();

        }catch (NoSuchAlgorithmException e){
            throw new RuntimeException("No such algorithm exists : "+e);
        }
    }

    public static String extractUsernameFromEmail(String email) {
        String regex = "^(.+)@(.+)$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        if (matcher.matches()) {
            return matcher.group(1);
        } else {
            return null;
        }
    }

}
