import java.io.File;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Scanner;


public class Level {
    private ArrayList<Item> ground;
    private int levelNum;
    private int enemyNum;
    private ArrayList<Item> allItems;
    private ArrayList<Character> characters;
    private int score;



    public Level(){
        this.ground = new ArrayList<Item>();
        this.allItems= new ArrayList<>();
        this.characters = new ArrayList<Character>();
        score = 0;

    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLevelNum() {
        return levelNum;
    }

    public void setLevelNum(int levelNum) {
        this.levelNum = levelNum;
    }

    public  int getEnemyNum() {
        return enemyNum;
    }

    public void setEnemyNum(int enemyNum) {
        this.enemyNum = enemyNum;
    }

    public ArrayList<Item> getGround() {
        return ground;
    }

    public void setGround(ArrayList<Item> ground) {
        this.ground = ground;
    }


    public ArrayList<Item> getAllItems() {
        return allItems;
    }

    public void setAllItems(ArrayList<Item> allItem) {
        allItems = allItem;
    }

    public ArrayList<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(ArrayList<Character> characters) {
        this.characters = characters;
    }



    public void addCharacter(Character character){
        characters.add(character);
    }

    public void removeCharacter(Character character){
        characters.remove(character);
    }






    public Character selectChar(String[] userInput) {
        for (Character character : characters) {
            if (character.getName().equals(userInput[0]) && !(character instanceof Enemy)) {
                return character;
            }
        }

        return null;


    }

    public Character selectHealingTarget(String[] userInput){
        try {

            for (Character target : characters) {
                if (target.getName().equals(userInput[2]) && !(target instanceof Enemy)) {
                    return target;
                }
            }
        }catch (ArrayIndexOutOfBoundsException ignored){

        }

        return null;
    }

    public Character selectTarget(String[] userInput){
        for (Character target:characters){
            if (target.getName().equals(userInput[2])&&target instanceof Enemy){
                return target;
            }
        }

        return null;

    }


    public Item selectItem(String[] userInput, Character selectedCharacter){
        ArrayList<Item> tempList = new ArrayList<Item>();
        tempList.addAll(ground);
        tempList.addAll(selectedCharacter.getInventory());
        tempList.add(selectedCharacter.getWeapon());
        tempList.add(selectedCharacter.getClothing());
        for (Item item: tempList){


            try {
                if (item.getName().equals(userInput[2])) {
                    return item;
                }
            }catch (NullPointerException ignored){

            }


        }

        return null;
    }


    public Item selectRandomItem() {
        SecureRandom secureRandom = new SecureRandom();

        int randomNum = secureRandom.nextInt(allItems.size());
        for (Item item : allItems) {
            if(randomNum == allItems.indexOf(item)){
                return item;
            }

        }
        return null;



    }
    public void generateEnemy(){
        enemyNum = (int)Math.pow(2,levelNum);
        for (int i = 1; i <= enemyNum; i++) {
            Character enemy = new Enemy(allItems);
            enemy.setName("Enemy"+i);
            characters.add(enemy);


        }
    }





    public void display(){
        System.out.print("\nCreating Level "+levelNum+", with "+enemyNum+" enemy soldiers.\nEntering level "+enemyNum+ "; ");
        for (Character character: characters){
            if (character.getState() == 2){
                System.out.print(character.getName()+" enters.");
            }
        }
        System.out.println();

    }

    public Item searchGroundForWeapon(String name){
        for (Item item:ground){
            if (item.getName().equals(name)&&item instanceof Weapon){
                return item;
            }
        }

        return null;
    }

    public Item searchGroundForClothing(String name){
        for (Item item:ground){
            if (item.getName().equals(name)&&item instanceof Clothing){
                return item;
            }
        }

        return null;
    }

    public void updateTurn(){

        for (Character character:characters){
            if (!(character instanceof Enemy)&&character.getWeapon() instanceof Sword){
                if (character.getWeapon().turnPassed()){
                    character.setState(2);

                }

                if (checkForOtherHeroes(character)) {
                    character.setState(2);
                }else{
                    System.out.println("Sword user " + character.getName()+ " cannot stay away because there are no allies left.");
                }
            }else if (!(character instanceof Enemy)&&character.getWeapon() instanceof Shield){
                if (character.getWeapon().turnPassed()){


                        for (Character character1 : ((Shield) character.getWeapon()).getStunnedCharacters()) {
                            character1.setState(2);
                        }



                }
            }
        }


    }

    public boolean checkForOtherHeroes(Character character){
        ArrayList<Character> tempCharList = new ArrayList<>();
        tempCharList.addAll(characters);
        tempCharList.remove(character);
        for (Character character1: tempCharList){
            if (!(character1 instanceof Enemy)){
                return true;
            }

        }

        return false;
    }


    public void checkDeath(){
        for (int i = 0; i < characters.size(); i++) {
            if (characters.get(i).getHp() == 0){
                Character character = characters.get(i);
                characters.remove(character);

                if (character instanceof Enemy) {
                    Item randomItem = selectRandomItem();
                    System.out.println(character.getName() + " is dead. " + character.getName() + " drops "+randomItem.getName());
                    ground.add(randomItem);
                    score+=10;
                }


            }
        }
    }

    public void addItems(){
        allItems.add(new Sword("Excalibur",8,10));
        allItems.add(new Sword("Gramr",4,5));
        allItems.add(new Sword("Zulfiqar",5,6));
        allItems.add(new Sword("Durendal",7,6));
        allItems.add(new Sword("Harpe",5,5));
        allItems.add(new Sword("Ame-no-Habakiri",5,6));
        allItems.add(new Sword("Kusanagi-no-Tsurugi",6,5));
        allItems.add(new Shield("Bulwark",3,4));
        allItems.add(new Shield("Buffer",6,6));
        allItems.add(new Shield("Shelter",4,5));
        allItems.add(new Shield("Absorber",5,7));
        allItems.add(new Shield("Safeguard",6,5));
        allItems.add(new Shield("Svalinn",5,6));
        allItems.add(new Wand("Fagus",4,5));
        allItems.add(new Wand("Fraxinus",3,7));
        allItems.add(new Wand("Acacia",2,6));
        allItems.add(new Wand("Castanea",4,5));
        allItems.add(new Wand("Diospyros",4,6));
        allItems.add(new Wand("Cedrus",3,4));
        allItems.add(new Clothing("WoodenArmour",7,8));
        allItems.add(new Clothing("LeatherArmour",6,10));
        allItems.add(new Clothing("IronArmour",8,12));
        allItems.add(new Clothing("DragonArmour",10,15));
        allItems.add(new Clothing("ObsidianArmour",9,14));

    }



    public void groundAdd(Item item){
        ground.add(item);
    }

    public void groundRemove(Item item){
        ground.remove(item);
    }

    public void allItemsAdd(Item item){
        allItems.add(item);
    }

    public void allItemsRemove(Item item){
        allItems.remove(item);
    }

    public Character selectTargetForEnemy(){

        for (Character character:characters){
            if (character instanceof Tank){
                return character;
            }
        }

        for (Character character:characters){
            if ((character instanceof Fighter||character instanceof Healer)&& character.getState() !=0){
                return character;
            }
        }


        return null;

    }

    public void enemyAttacks(){
        SecureRandom secureRandom = new SecureRandom();


        ArrayList<Character>enemyList = new ArrayList<>();

        for (Character character: characters){
            if (character instanceof Enemy&& character.getState() ==2){
                enemyList.add(character);
            }
        }

        int randomNum = secureRandom.nextInt(enemyList.size());

        for (Character character:enemyList){
            if (randomNum == enemyList.indexOf(character)){
                character.attack(selectTargetForEnemy());
            }
        }
    }

    public void displayScore(){
        System.out.println("Your Score: "+ score);
        System.out.println();
        System.out.println("Other Players' scores: ");
        FileManager.ReadingScores();


    }

    public void gameOver(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Username: ");
        String userName = scanner.nextLine();

        displayScore();

        while (true){
            System.out.println("Would You like to play again?(Y/N)");
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("Y")) {
                break;
            }else if (answer.equalsIgnoreCase("N")){
                System.exit(0);
            }else {
                System.out.println("Answer entered incorrectly. Try again.");
            }

        }
        FileManager.AddingScores(userName,score);
    }
    public void gameInstructor(){
        System.out.println(" ");
    }



}
