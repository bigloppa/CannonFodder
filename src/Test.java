public class Test {
    public static void main(String[] args) {
        Weapon weapon = new Weapon();
        weapon.setAttackDmg(2);
        Tank tank = new Tank();
        Enemy enemy = new Enemy();
        enemy.setWeapon(weapon);
        enemy.attack(tank);



    }
}
