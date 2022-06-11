import java.util.ArrayList;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileManager.CreatingFile();

        while (true) {
            Level level = new Level();
            level.addItems();
            System.out.println("CANNON FODDER");
            Character fighter = new Fighter(level.getAllItems());
            Character healer = new Healer(level.getAllItems());
            Character tank = new Tank(level.getAllItems());


            level.addCharacter(fighter);
            level.addCharacter(healer);
            level.addCharacter(tank);


            boolean doesGameContinue = true;


            while (doesGameContinue) {

                level.generateEnemy();
                level.display();


                while (true) {
                    level.checkDeath();
                    level.updateTurn();
                    String[] userInput;
                    try {
                        userInput = scanner.nextLine().split(" ");
                    }catch (Exception exception){
                        continue;
                    }



                    if ("NEXT".equals(userInput[0])) {
                        boolean doesRoundEnd = true;
                        for (Character character : level.getCharacters()) {
                            if (character instanceof Enemy) {
                                doesRoundEnd = false;

                            }
                        }

                        if (doesRoundEnd) {
                            level.setScore(level.getScore()+50);
                            break;
                        } else {
                            System.out.println("There are enemies you can't go to the next level.");
                            continue;

                        }

                    }

                    try {

                        for (int i = 0; i < 2; i++) {
                            String arrayCheck = userInput[i];
                        }

                    } catch (ArrayIndexOutOfBoundsException exception) {
                        System.out.println("Action entered incorrectly.");
                        continue;
                    }


                    if (userInput[1].equals("attack")) {
                        try {

                            Character selectedTarget = level.selectTarget(userInput);
                            Character selectedCharacter = level.selectChar(userInput);
                            selectedCharacter.attack(selectedTarget);
                        } catch (NullPointerException exception) {
                            System.out.println("Character cannot be found.");
                            continue;
                        }

                    } else if (userInput[1].equals("examine")) {
                        try {


                            Character selectedCharacter = level.selectChar(userInput);
                            Item selectedItem = level.selectItem(userInput, selectedCharacter);
                            selectedItem.display();
                        } catch (NullPointerException exception) {
                            System.out.println("The Item or the Character cannot be found");
                            continue;
                        }

                    } else if (userInput[1].equals("listinventory")) {
                        try {

                            Character selectedCharacter = level.selectChar(userInput);
                            selectedCharacter.listInventory();

                        } catch (NullPointerException exception) {
                            System.out.println("Character cannot be found");
                            continue;
                        }

                    } else if (userInput[1].equals("pick")) {
                        try {


                            Character selectedCharacter = level.selectChar(userInput);
                            Item selectedItem = level.selectItem(userInput, selectedCharacter);
                            if (selectedCharacter.pick(selectedItem)) {
                                level.groundRemove(selectedItem);
                            }
                        } catch (NullPointerException exception) {
                            System.out.println("Item or Character cannot be found");
                            continue;
                        }

                    } else if (userInput[1].equals("wield")) {
                        try {
                            Character selectedCharacter = level.selectChar(userInput);
                            Item item = level.searchGroundForWeapon(userInput[2]);

                            if (selectedCharacter.wield(level.getGround(), userInput)) {
                                level.groundRemove(item);

                            }

                        } catch (NullPointerException exception) {
                            System.out.println("Item or character cannot be found.");
                            continue;
                        }

                    } else if (userInput[1].equals("wear")) {
                        try {
                            Character selectedCharacter = level.selectChar(userInput);
                            Item item = level.searchGroundForClothing(userInput[2]);
                            if (selectedCharacter.wear(level.getGround(), userInput)) {
                                level.groundRemove(item);
                            }
                            System.out.println(selectedCharacter.getName() + " worn " + item.getName() + " successfully.");
                        } catch (NullPointerException exception) {
                            System.out.println("Item or character cannot be found.");
                            continue;
                        }
                    } else if (userInput[1].equals("specialattack")) {
                        try {
                            Character selectedCharacter = level.selectChar(userInput);
                            Character selectedTarget = null;
                            ArrayList<Character> characterArrayList = new ArrayList<>();
                            if (!selectedCharacter.isSpecialAttackUsed()) {
                                if (selectedCharacter.getWeapon() instanceof Wand) {
                                    selectedTarget = level.selectHealingTarget(userInput);
                                    characterArrayList.add(selectedCharacter);
                                    characterArrayList.add(selectedTarget);
                                    selectedCharacter.getWeapon().specialAttack(characterArrayList);
                                } else if (selectedCharacter.getWeapon() instanceof Sword) {
                                    if (userInput.length<=2) {

                                        characterArrayList.add(selectedCharacter);
                                        selectedCharacter.getWeapon().specialAttack(characterArrayList);
                                    }else{
                                        System.out.println("This character's special attack cannot target anything.");
                                        continue;
                                    }


                                } else {
                                    if (userInput.length<=2) {

                                        selectedCharacter.getWeapon().specialAttack(level.getCharacters());
                                    }else{
                                        System.out.println("This character's special attack cannot target anything.");
                                        continue;
                                    }

                                    selectedCharacter.setSpecialAttackUsed(true);
                                }
                            }else {
                                System.out.println("This character used its special attack already.");
                                continue;
                            }


                        } catch (NullPointerException exception) {
                            System.out.println("Character or target cannot be found.");
                            continue;
                        }
                    } else {
                        System.out.println("Action entered incorrectly.");
                        continue;
                    }

                    level.checkDeath();

                    try {
                        level.enemyAttacks();
                    } catch (Exception ignored) {

                    }

                    level.checkDeath();


                    doesGameContinue = false;
                    for (Character character : level.getCharacters()) {
                        if (!(character instanceof Enemy)) {
                            doesGameContinue = true;
                        }
                    }

                    if (!doesGameContinue) {
                        break;
                    }


                }
                level.setLevelNum(level.getLevelNum() + 1);
                level.getGround().clear();
                for (Character character : level.getCharacters()){
                    character.setSpecialAttackUsed(false);
                    character.levelUp();

                }

            }

            level.gameOver();

        }

    }



}
