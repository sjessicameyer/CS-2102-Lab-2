/**
 * A bird, a type of pet
 */
public class Bird extends Pet {
    /**
     * Whether the bird's wings have been clipped
     */
    public boolean wingsClipped;

    /**
     * Constructs a bird
     * @param name the name of the bird
     * @param age the age of the bird
     * @param weightInOz the weight of the bird
     * @param location the location of the bird
     * @param wingsClipped whether the bird's wings are clipped
     */
    public Bird(String name, int age, int weightInOz, Coord2D location, boolean wingsClipped){
        super(name, age, weightInOz, location);
        this.wingsClipped = wingsClipped;
    }

    /**
     * The amount a bird would eat of a certain food.
     * Eats 1 unit when called with "seeds", 0 otherwise.
     * @param foodLabel the type of food being asked
     * @return the amount of that food a bird would eat
     */
    @Override
    public int eats(String foodLabel) {
        if (foodLabel.equals("seeds")){
            return 1;
        }
        return 0;
    }
}
