import java.security.SecureRandom;

public class Fighter extends Character {

    public Fighter(){
        SecureRandom secureRandom = new SecureRandom();
        setStrength(secureRandom.nextInt(5)+6);
        setVitality(secureRandom.nextInt(5)+3);
        setIntelligence(secureRandom.nextInt(1,5));
    }

}
