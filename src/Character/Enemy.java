package Character;

import java.security.SecureRandom;

public class Enemy extends Character {
    public Enemy(){
        SecureRandom secureRandom = new SecureRandom();
        setStrength(secureRandom.nextInt(5)+1);
        setVitality(secureRandom.nextInt(5)+1);
        setIntelligence(secureRandom.nextInt(5)+1);
    }
}
