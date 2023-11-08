import java.util.LinkedList;

/**
 * A zone
 */
public abstract class Zone implements Zoneable{

    /**
     * The factor to multiply age by to get 'human years'
     */
    public int factorToHumanYears;

    /**
     * Constructor for Zone
     * @param factorToHumanYears The factor to multiply age by to get 'human years'
     */
    public Zone(int factorToHumanYears){
        this.factorToHumanYears = factorToHumanYears;
    }

    /**
     * Looks up a pet in the zone and computers its age relative to human years
     * @param petName the name of the pet.
     * @return the age of the pet converted into human years using the per-pet calculation
     *         or -1 if that pet name is not in this zone
     */
    public int inHumanYears(String petName){
        Petable p = getPet(petName);
        if (p == null){
            return -1;
        }
        return getPet(petName).getAge() * factorToHumanYears;
    }

    /**
     * Produces the number of pets in the zone
     * @return the number of total pets in the zone
     */
    public int petsInZone(){
       return getPets().size();
    }

    /**
     * finds and produces the fattest animal available
     * @return the heaviest pet (the one with the greatest weight according to its getWeightInOz() method)
     * @return null if there are no pets
     */
    public Petable heaviestPet(){
        if (getPets().isEmpty()){
            return null;
        }
        Petable fattest = getPets().get(0);
        for (Petable p: getPets()){
            if (p.getWeightInOz() > fattest.getWeightInOz()){
                fattest = p;
            }
        }
        return fattest;
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
        return this;
    }

    /**
     * Fetch me that pet!
     * @param petName the pet to look up in the zone, you may assume the pet is in the zone
     * @return the pet with that name or null if pet is not in the zone
     */
    @Override
    public Pet getPet(String petName){
        for (Pet p : getPets()){
            if (p.getName().equals(petName)){
                return p;
            }
        }
        return null;
    }

    /**
     * Gets the name of the pet that is closest to the given 2D coord
     *
     * @param x The 2d coord
     * @param y
     * @return the name of the pet closest to that coord
     * In the result of a tie, you may return any one
     * (we won't test ties)
     * return "No Pets Found" if there are no pets in the zone.
     */
    @Override
    public String closestPet(int x, int y){
        LinkedList<? extends Pet> pets = getPets();

        Coord2D compareTo = new Coord2D(x, y);
        if (pets.isEmpty()){
            return "No Pets Found";
        }
        double min = getCoordDistance(pets.get(0).location, compareTo);
        String pet = pets.get(0).name;

        for (Pet p : pets){
            double currentLength = getCoordDistance(p.location, compareTo);
            if (currentLength < min){
                min = currentLength;
                pet = p.name;
            }
        }
        return pet;
    }

    /**
     * Gets the distance between two coordinates
     *
     * @param a the first coordinate
     * @param b the second coordinate
     * @return the distance between the two coordinates
     */
    public double getCoordDistance(Coord2D a, Coord2D b){
        double x1 = a.x;
        double x2 = b.x;
        double y1 = a.y;
        double y2 = b.y;

        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow(y1 - y2, 2));
    }

    /** retrieve the list of petable objects from the subclass
     * @return a linked list of objects that implement Petable
     */
    public abstract LinkedList<? extends Pet> getPets();
}
