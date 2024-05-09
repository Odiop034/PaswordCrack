import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.List;
public class Projet{

    
public abstract class PasswordCrackerFactory {
  public abstract PasswordCracker createPasswordCracker();
    
}

// Interface pour les différents types de craquage de mots de passe
interface PasswordCracker {
    void crackPassword(String hashedPassword);
}

public static String md5(String input) {
    try {
        // Créer un objet MessageDigest pour l'algorithme MD5
        MessageDigest md = MessageDigest.getInstance("MD5");
        // Calculer le hash du message
        byte[] messageDigest = md.digest(input.getBytes());
        // Convertir le tableau de bytes en représentation hexadécimale
        BigInteger no = new BigInteger(1, messageDigest);
        String hashtext = no.toString(16);
        // Ajouter des zéros initiaux pour garantir une longueur de 32 caractères
        while (hashtext.length() < 32) {
            hashtext = "0" + hashtext;
        }
        return hashtext;
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}


public abstract class LocalCracker extends PasswordCrackerFactory {
    
    public PasswordCracker createPasswordCracker(){
        return (PasswordCracker) this;
    };
}


public class BruteforceLocalCracker extends LocalCracker {

   
      public void  crackPassword(String hashedpassword){
            bruteForceCrack(hashedpassword);  
        };
      
    

    public static void bruteForceCrack(String hashedPassword) {
        System.out.println("Cracking password by brute force...");
        // Longueur maximale du mot de passe à générer pour le craquage par force brute
        int maxLength = 5;

        for (int length = 1; length <= maxLength; length++) {
            bruteForceHelper(hashedPassword, "", length);
        }
    }

    private static void bruteForceHelper(String hashedPassword, String attempt, int length) {
        // Caractères possibles pour le craquage par force brute
        char[] charset = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();

        if (length == 0) {
            // Calculer le hash MD5 de la tentative
            String hashedAttempt = md5(attempt);
            if (hashedAttempt.equals(hashedPassword)) {
                System.out.println("Password cracked by brute force: " + attempt);
                return;
            }
        } else {
            for (char c : charset) {
                bruteForceHelper(hashedPassword, attempt + c, length - 1);
            }
        }
    }
    
}


public class DictionaryLocalCracker extends LocalCracker {

    public void crackPassword(String hashedpassword){
        dictionaryAttack(hashedpassword);
        
    }

    public DictionaryLocalCracker(List<String> dictionary) {
    }

                                                     
    

    public static void dictionaryAttack(String hashedPassword) {
        System.out.println("Cracking password using dictionary...");
        // Vous pouvez fournir ici une liste de mots de passe à partir d'un fichier ou d'une source externe
        List<String> dictionary = List.of("password", "qwerty", "123456", "letmein", "admin");

        for (String word : dictionary) {
            // Calculer le hash MD5 du mot de passe du dictionnaire
            String hashedWord = md5(word);
            if (hashedWord.equals(hashedPassword)) {
                System.out.println("Password cracked using dictionary: " + word);
                return;
            }
        }
        System.out.println("Password not found in dictionary.");
    }

}




}