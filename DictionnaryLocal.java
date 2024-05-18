
import java.util.List;

public class DictionnaryLocal extends Dictionnary {
    
    
    

     @Override
     public void crackPassword(String motDePasseHache){
        dictionaryAttack(motDePasseHache);
        
    }

     public  void dictionaryAttack(String motDePasseHache) {
        if (getDictionary() == null) {
            System.out.println("Default dictionary is not set.");
            return;
        }

        dictionaryAttack(motDePasseHache,getDictionary());
    }

      public void dictionaryAttack(String motDePasseHache, List<String> customDictionary) {
        System.out.println("Crackage de mot de passe par dictionnaire.");

        // Précalculez les hachages du dictionnaire dans une map
       if (getHashedDictionary().isEmpty()) {

        
        for (String word : customDictionary) {
            String hashedWord = Hachage.md5(word);
            getHashedDictionary().put(hashedWord, word);
        }
        
       }

        // Recherche dans le dictionnaire
        if (getHashedDictionary().containsKey(motDePasseHache)) {
            System.out.println("Password cracké : " + getHashedDictionary().get(motDePasseHache));
        } else {
            System.out.println("Password non disponible dans le dictionnaire.");
        }

}
}
