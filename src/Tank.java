import java.security.SecureRandom;
import java.util.ArrayList;

public class Tank extends Character{







    public Tank(){
    SecureRandom secureRandom = new SecureRandom();
    setName("Tank");
    setStrength(secureRandom.nextInt(5)+1);
    setVitality(secureRandom.nextInt(5)+6);
    setIntelligence(secureRandom.nextInt(5)+3);
    setHp(calculateHp());


    }
}
