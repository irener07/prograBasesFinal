/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prograbases1;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Ronaldo
 */
public class Password {

    private static final String numbers = "1234567890";
    private static final String capitalLetters = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
    private static final String lowersLetters = "abcdefghijklmnñopqrstuvwxxyz";
    private static final String specialLetters = "!#$?@^~";
    private static int size;

    public static String getPassword() {
        size = ThreadLocalRandom.current().nextInt(8, 13);
        String password = "";
        String resultado = "";
        int x, y;
        password += (numbers.charAt((int) (Math.random() * numbers.length())));
        password += (capitalLetters.charAt((int) (Math.random() * capitalLetters.length())));
        password += (lowersLetters.charAt((int) (Math.random() * lowersLetters.length())));
        password += (specialLetters.charAt((int) (Math.random() * specialLetters.length())));
        String key = numbers + capitalLetters + lowersLetters + specialLetters;
        for (int i = 0; i < size - 4; i++) {
            password += (key.charAt((int) (Math.random() * key.length())));
        }
        for (x = password.length(); x >= 2; x--) {
            y = (int) (Math.random() * x + 1);
            resultado = resultado + password.substring(y - 1, y);
            password = password.substring(0, y - 1) + password.substring(y, x);
        }
        password += resultado;
        System.out.println("{&}" + password);
        password = intercalarPassword(password);
        return password;
    }

    public static String intercalarPassword(String p) {
        for (int i = 0; i < p.length(); i++) {
            if (i != 0) {
                if (Character.isLetter(p.charAt(i)) && Character.isLetter(p.charAt(i - 1))) {
                    if (p.charAt(i) == p.charAt(i - 1)){
                        p = p.replace(p.charAt(i), '0');
                    }
                    else if (Character.isUpperCase(p.charAt(i)) && Character.isUpperCase(p.charAt(i - 1))) {
                        p = p.replace(p.charAt(i), p.toLowerCase().charAt(i));
                    } else if (Character.isLowerCase(p.charAt(i)) && Character.isLowerCase(p.charAt(i - 1))) {
                        p = p.replace(p.charAt(i), p.toUpperCase().charAt(i));
                    }
                }
            }
        }
        return p;
    }
}