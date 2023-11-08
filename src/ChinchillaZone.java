import java.util.LinkedList;

/**
 * A zone where chinchillas are kept
 */
public class ChinchillaZone extends Zone{

    /**
     * Number of hays
     */
    private int hay;

    /**
     * Number of pellets
     */
    private int pellets;

    /**
     * A list of chinchillas kept in the zone
     */
    public LinkedList<Chinchilla> chinchillas;

    /**
     * Constructs a chinchilla zone
     * @param chinchillas A list of chinchillas kept in the zone
     */
    public ChinchillaZone(LinkedList<Chinchilla> chinchillas){
        super(10);
        this.chinchillas = chinchillas;
        hay = 0;
        pellets = 0;
    }

    /**
     * Provides the pets in this zone
     * @return A list of pets in this zone
     */
    @Override
    public LinkedList<? extends Pet> getPets() {
        return chinchillas;
    }

    /**
     * Gives the pantry label in the form "Chinchilla: # pellets, # hay"
     * @return The pantry label
     */
    @Override
    public String getPantryLabel() {
        return "Chinchilla: " + pellets + " pellets, " + hay + " hay";
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
            case "pellets":
                this.pellets += foodAmt;
                break;
            case "hay":
                this.hay += foodAmt;
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
        for (Chinchilla c : chinchillas){
            hay -= c.eats("hay");
            pellets -= c.eats("pellets");
        }
        if (hay <= 0){
            hay = 0;
        }
        if (pellets <= 0){
            pellets = 0;
        }
        return this;
    }


}
