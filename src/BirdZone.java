import java.util.LinkedList;

/**
 * A zone where birds are kept
 */
public class BirdZone extends Zone{

    /**
     * Number of seeds
     */
    private int seeds;

    /**
     * A list of birds kept in the zone
     */
    public LinkedList<Bird> birds;

    /**
     * Constructs a bird zone
     * @param birds A list of birds kept in the zone
     */
    public BirdZone(LinkedList<Bird> birds){
        super(9);
        this.birds = birds;
        seeds = 0;
    }

    /**
     * Provides the pets in this zone
     * @return A list of pets in this zone
     */
    @Override
    public LinkedList<Bird> getPets() {
        return birds;
    }

    /**
     * Gives the pantry label in the form "Bird: # seeds"
     * @return The pantry label
     */
    @Override
    public String getPantryLabel() {
        return "Bird: " + seeds + " seeds";
    }

    /**
     * Gets the name of the pet that is closest to the given 3D coord
     *
     * @param x the 3D coord that only has the location information
     * @param y
     * @return the name of the Bird closest to that coord
     * In the result of a tie, you may return any one
     * (we won't test ties)
     * assume the "z" coordinate we are using is 0 by default
     * (some pets may be up on perches, which in that case will make the z value 2)
     * return "No Pets Found" if there are no pets in the zone.
     */
    @Override
    public String closestPet(int x, int y){

        LinkedList<Bird> pets = getPets();

        if (pets.isEmpty()){
            return "No Pets Found";
        }

        Bird first = pets.get(0);
        Coord2D compareTo = new Coord2D(x, y);
        double min = getCoordDistance(first.location, compareTo, first.wingsClipped);
        String pet = first.name;

        for (Bird b : pets){
            double currentLength = getCoordDistance(b.location, compareTo, b.wingsClipped);
            if (currentLength < min){
                min = currentLength;
                pet = b.name;
            }
        }
        return pet;
    }

    /**
     * Gets the distance between two coordinates
     *
     * @param a the first coordinate
     * @param b the second coordinate
     * @param wingsClipped if the wings are clipped or not
     * @return the distance between the two coordinates
     */

    public double getCoordDistance(Coord2D a, Coord2D b, boolean wingsClipped){
        double x1 = a.x;
        double x2 = b.x;
        double y1 = a.y;
        double y2 = b.y;
        double z;
        if (wingsClipped){
            z = 0;
        } else z = 2;

        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow(y1 - y2, 2) + Math.pow(z, 2));
    }

    /**
     *
     * @param foodName The name of a food item expected to be stocked in this zone's pantry
     * @param foodAmt A non-negative number (>= 0) representing how much of that food is going into the pantry
     * @return `this` zone for the purpose of method chaining
     */
    //Going back and forth on whether this should be in Zone, or each individual zone.
    //Probably depends on how we actually want to store the food
    public Zoneable restockPetFood(String foodName, int foodAmt){
        if (foodName.equals("seeds")){
            this.seeds += foodAmt;
        }
        return this;
    }

    /**
     * For each animal in the zone, brings them in to eat
     * Use their eats() method on each type of food in the pantry for them
     * @return `this` zone for the purpose of method chaining
     * If a food item in the zone goes negative, set it to 0. (No need for "unknown" logic).
     */

    //Also going back and forth on whether this should be in Zone, or each individual zone.
    //Also depends on how we actually want to store the food
    public Zoneable feedZone(){
        for (Bird b : birds){
            seeds -= b.eats("seeds");
        }
        if (seeds <= 0){
            seeds = 0;
        }
        return this;
    }

}


