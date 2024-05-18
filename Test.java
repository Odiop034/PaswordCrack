import java.util.List;

public class Test {
    
    public static void main(String[] args) {
        // Exemple de mots de passe à tester
        String password1 = "omar";
        String password2 = "hello";
        String password3 = "123456";

        // Créer des hash MD5 de ces mots de passe
        String hash1 = Hachage.md5(password1);
        String hash2 = Hachage.md5(password2);
        String hash3 = Hachage.md5(password3);

        // Afficher les hash pour vérification
        System.out.println("Hash 1: " + hash1);
        System.out.println("Hash 2: " + hash2);
        System.out.println("Hash 3: " + hash3);

        // Créer une fabrique localcraker et tester
        FabriqueCraker fabrique = new FabriqueLocalCraker();

        //Creer une insance de bruteforce et tester
        BruteForce bruteforcer =fabrique.createBruteForceCracker();
        System.out.println("Test Bruteforce Cracker:");
        bruteforcer.crackPassword(hash1);  // Devrait réussir pour des mots courts avec force brute

        // Créer une instance de Dictionary avec un petit dictionnaire

        List<String> dictionary = List.of("hello", "world", "password", "123456", "admin");
        Dictionnary dictionaryCracker = fabrique.createDictionnaryCracker();
        dictionaryCracker.setDictionnary(dictionary);
        System.out.println("Test Dictionary Cracker:");
        dictionaryCracker.crackPassword(hash2);  // Devrait réussir avec une attaque de dictionnaire
        dictionaryCracker.crackPassword(hash3);  // Devrait aussi réussir
    }

}
