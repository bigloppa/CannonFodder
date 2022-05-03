import java.security.SecureRandom;

public class Tank extends Character{
    public Tank(){
    SecureRandom secureRandom = new SecureRandom();
    setStrength(secureRandom.nextInt(5)+1);
    setVitality(secureRandom.nextInt(5)+6);
    setIntelligence(secureRandom.nextInt(5)+3);


    }
}
