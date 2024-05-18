public class BruteForceLocal extends BruteForce{

    @Override
    public void crackPassword(String motDepasseHache){
        bruteForceCrack(motDepasseHache);
    }
    
    public static void bruteForceCrack(String motDepasseHache) {
        System.out.println("Crackage par brute force...");
        // Longueur maximale du mot de passe à générer pour le craquage par force brute
        int maxLength = 5;

        for (int length = 1; length <= maxLength; length++) {
            bruteForceHelper(motDepasseHache, "", length);
        }
    }

    private static void bruteForceHelper(String motDepasseHache, String attempt, int length) {
        // Caractères possibles pour le craquage par force brute
        char[] charset = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();

        if (length == 0) {
            // Calculer le hash MD5 de la tentative
            String hashedAttempt = Hachage.md5(attempt);
            if (hashedAttempt.equals(motDepasseHache)) {
                System.out.println("Mot de passe cracké par brute force: " + attempt);
            }
        } else {
            for (char c : charset) {
                bruteForceHelper(motDepasseHache, attempt + c, length - 1);
            }
        }
    }

}
