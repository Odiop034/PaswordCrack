import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Dictionnary  {

    private List<String> dictionary;
     private Map<String, String> hashedDictionary ;

    public List<String> getDictionary(){
        return dictionary;
    }

    public Map<String, String> getHashedDictionary(){
        return hashedDictionary;
    }


    public  void setDictionnary(List<String> dictionary){
        this.dictionary = dictionary;
        this.hashedDictionary = new HashMap<>();
    }
    abstract void crackPassword(String motDepassehache);

   

}


