import java.util.LinkedList;

/**
 * A zone where cats are kept
 */
public class CatZone extends Zone{

    /**
     * Number of treats
     */
    private int treats;

    /**
     * Number of cans
     */
    private int cans;

    /**
     * A list of cats kept in the zone
     */
    public LinkedList<Cat> cats;

    /**
     * Constructs a cat zone
     * @param cats A list of cats kept in the zone
     */
    public CatZone(LinkedList<Cat> cats){
        super(6);
        this.cats = cats;
        treats = 0;
        cans = 0;
    }

    /**
     * Provides the pets in this zone
     * @return A list of pets in this zone
     */
    @Override
    public LinkedList<Cat> getPets() {
        return cats;
    }

    /**
     * Gives the pantry label in the form "Cat: # cans, # treats"
     * @return The pantry label
     */
    @Override
    public String getPantryLabel() {
        return "Cat: " + cans + " cans, " + treats + " treats";
    }
    /**
     * TODO
     * @param foodName The name of a food item expected to be stocked in this zone's pantry
     * @param foodAmt A non-negative number (>= 0) representing how much of that food is going into the pantry
     * @return `this` zone for the purpose of method chaining
     */
    //Going back and forth on whether this should be in Zone, or each individual zone.
    //Probably depends on how we actually want to store the food
    public Zoneable restockPetFood(String foodName, int foodAmt){
        switch(foodName){
            case "cans":
                this.cans += foodAmt;
                break;
            case "treats":
                this.treats += foodAmt;
                break;
            default:
                break;
        }
        return this;
    }

    /** TODO
     * For each animal in the zone, brings them in to eat
     * Use their eats() method on each type of food in the pantry for them
     * @return `this` zone for the purpose of method chaining
     * If a food item in the zone goes negative, set it to 0. (No need for "unknown" logic).
     */

    //Also going back and forth on whether this should be in Zone, or each individual zone.
    //Also depends on how we actually want to store the food
    public Zoneable feedZone(){
        for (Cat c : cats){
            cans -= c.eats("cans");
            treats -= c.eats("treats");

            if (treats <= 0){
                treats = 0;
            }
            if (cans <= 0){
                cans = 0;
            }
        }
        return this;
    }

}