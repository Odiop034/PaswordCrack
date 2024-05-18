public class FabriqueLocalCraker extends FabriqueCraker {

    @Override
    public Dictionnary createDictionnaryCracker(){
        
        return new DictionnaryLocal();
    }

    @Override
    public BruteForce createBruteForceCracker(){

        return new BruteForceLocal() ;
    }

    
}
