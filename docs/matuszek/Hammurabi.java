package hammurabi.docs.matuszek;

import java.util.Random;
import java.util.Scanner;

import static hammurabi.docs.HAMURABI.epicFail;

public class Hammurabi {
    Random rand = new Random();  // this is an instance variable
    Scanner scanner = new Scanner(System.in);

//    private int people = 100;
//    private int grainBushels = 2800;
//    private int acresOfLand = 1000;
//    private int landValue = 19;

    public int totalDeaths = 0, percentDied = 0, year = 0, population = 100, stores = 2800, immigrants = 5, deaths,
            harvest = 3000, yeild = 3, acres = harvest / yeild, eaten = harvest - stores, landPrice, fullPeople, temp;

    public static void main(String[] args) { // required in every Java program
        new Hammurabi().playGame();
    }

    public Hammurabi(){//default constructor/nullary

    }

    public void playGame() {
        // declare local variables here: grain, population, etc.
        // statements go after the declations
        do {
            newYear();
            acres += askHowManyAcresToBuy(landPrice, stores);
            acres -= askHowManyAcresToSell(acres);
        }while(this.year < 10);
    }

    public void newYear() {
        year += 1;
        //population += immigrants;
        landPrice = (int) (10 * Math.random() + 17);
        System.out.println(printSummary());
    }


    //Asks the player how many acres of land to buy, and returns that number. You must have enough grain to pay for your purchase
    public int askHowManyAcresToBuy(int landPrice, int bushels){
        System.out.println("How many acres would you like to buy? ");
        int buy = scanner.nextInt();
        if (buy < 0) {
            System.out.println("Not an actual choice.");
        }if(buy * landPrice > bushels){
            System.out.println("Not enough stores");
        }if(buy * landPrice < bushels){
            this.acres += buy;
            this.stores -= buy * landPrice;
        }

        return acres += buy;
    }


    //Asks the player how many acres of land to sell, and returns that number. You can't sell more than you have.
    //Do not ask this question if the player is buying land; it doesn't make sense to do both in one turn.
    public int askHowManyAcresToSell(int acresOwned){
        System.out.println("How many acres do you want to sell?");
        int sell = scanner.nextInt();
        if(sell < 0){
            System.out.println("Not an actual number");
        }if(sell > acresOwned){
            System.out.println("You don't have enough to sell");
        }if(sell < acres){
            this.acres -= sell;
            this.stores += sell * landPrice;
        }
        return this.acres -= sell;
    }



    //Ask the player how much grain to feed people, and returns that number.
    // You can't feed them more grain than you have. You can feed them more than they need to survive.
    public int askHowMuchGrainToFeedPeople(int bushels){
        System.out.println("How many bushels do you wish to feed the people?");
        int feed = scanner.nextInt();
        if(feed < 0){
            System.out.println("Not a real number.");
        }if(feed > bushels){
            System.out.println("There is not enough food.");
        }if(feed < bushels){
            
        }
        return 0;
    }



    //Ask the player how many acres to plant with grain, and returns that number.
    // You must have enough acres, enough grain, and enough people to do the planting. Any grain left over goes into storage for next year.
    public int askHowManyAcresToPlant(int acresOwned, int population, int bushels){
        return 0;
    }

    public int starvationDeaths(int i, int i1) {
        return 0;
    }

    public boolean uprising(int i, int i1) {
        return false;
    }

    public int harvest(int i) {
        return 0;
    }

    public int newCostOfLand() {
        return 0;
    }
    //Needs many parameters passed through method
    public String printSummary(){
        String answer = "\nHAMURABI:  I BEG TO REPORT TO YOU,\n" +
                "IN YEAR " + year + ", " + deaths + " PEOPLE STARVED.\n";
        answer += "POPULATION IS NOW " + population + ".\n" +
                "THE CITY NOW OWNS " + acres + " ACRES.\n" +
                "YOU HARVESTED " + yeild + " BUSHELS PER ACRE.\n" +
                //"RATS ATE " + eaten + " BUSHELS.\n" +
                "YOU NOW HAVE " + stores + " BUSHELS IN STORE\n\n" +
                "LAND IS TRADING AT " + landPrice + " BUSHELS PER ACRE.\n" +
                "Each person needs at least 20 bushels of grain per year to survive\n" +
                "Each person can farm at most 10 acres of land\n" +
                "It takes 2 bushels of grain to farm an acre of land\n" +
                "The market price for land fluctuates yearly";
        return answer;
    }
    //Needs many parameters passed through method
    public String finalSummary(){
        return null;
    }

    public int grainEatenByRats(int i) {
        return 0;
    }

    public int immigrants(int i, int i1, int i2) {
        return 0;
    }

    public int plagueDeaths(int i) {
        return 0;
    }
}
