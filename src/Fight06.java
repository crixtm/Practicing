import java.util.Random;
import java.util.Scanner;


/**
 * Created by Krisztian_Barabas on 22.02.2017.
 */
public class Fight06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String heroName = getHeroName(sc);
        int[] heroStats = getHeroStats(5);
        showStats(heroStats, heroName);
        int monsterCounter = 0;
        while ( (3 > monsterCounter) && (heroStats[0]>0) ){
            String monster = getMonsterType();
            int[] monsterStats = getHeroStats(0);
            showStats(monsterStats,monster);
            monsterCounter++;
            heroStats = fightWithTheMonster(heroStats, heroName, monsterStats, monster, sc);
        }
        if (0<heroStats[0]) {
            System.out.println("congrats" + heroName + "! you devastated " + monsterCounter + " monster(s)! You rock!");
        } else System.out.println("Hero: " + heroName + " died in the fight with the " + monsterCounter + " monster! RIP! End of the world!");

    }

    private static int[] fightWithTheMonster(int[] heroStats, String heroName, int[] monsterStats, String monster, Scanner sc) {
        Random rnd = new Random();
        sc.nextLine();
        do {
            if (rnd.nextBoolean()){

                System.out.println("You hit the " + monster + ", and  it lost " + heroStats[3] + "hp.");
                monsterStats[0] -= heroStats[3];
            } else {
                System.out.println(monster + " hit you, and  you lost " + monsterStats[3] + "hp.");
                heroStats[0] -= monsterStats[3];
            }
            showStats(heroStats, heroName);
            showStats(monsterStats, monster);
            sc.nextLine();
        } while ((0<heroStats[0])&&(0<monsterStats[0]));
        evaluateFight(heroStats, heroName, monster, sc);
        return heroStats;
    }

    private static void evaluateFight(int[] heroStats, String heroName, String monster, Scanner sc) {
        if (0<heroStats[0]) {
            System.out.println("congrats" + heroName + "! you devastated the scary " + monster + "! You rock!");
        } else System.out.println("Hero: " + heroName + " died in the fight with the " + monster + ". monster! RIP! End of the world!");

    }

    private static String getMonsterType() {
        String[] monsterType = {"Troll","Zombie","Vampire","WereWolf","NPE"};
        Random rnd = new Random();
        return monsterType[rnd.nextInt(4)];
    }

    private static void showStats(int[] heroStats, String heroName) {
        System.out.println(heroName + "'s stats:");
        System.out.println("hp: " + heroStats[0] + " attack: " + heroStats[1] + " defense: " + heroStats[2] + " damage: " + heroStats[3]);
    }

    private static int[] getHeroStats(int modifier) {
        Random rnd = new Random();
        int hp = rnd.nextInt(20) + modifier * 3 + 1 ;
        int attack = rnd.nextInt(6) + modifier;
        int defense = rnd.nextInt(5) + modifier;
        int damage = rnd.nextInt(5)+1;
        return new int[] {hp, attack, defense, damage};
    }

    private static String getHeroName(Scanner sc) {
        System.out.println("What's your name hero?");
        return sc.nextLine();
    }
}
