/**
 * A chinchilla, a type of pet
 */
public class Chinchilla extends Pet{
    /**
     * The amount of dust bath residue on the chinchilla
     */
    public int dustBathResidueInOz;

    /**
     * Constructs a chinchilla
     * @param name the name of the bird
     * @param age the age of the bird
     * @param weightInOz the weight of the bird
     * @param location the location of the bird
     * @param dustBathResidueInOz the amount of dust bath residue on the chinchilla
     */
    public Chinchilla(String name, int age, int weightInOz, Coord2D location,  int dustBathResidueInOz){
        super(name, age, weightInOz, location);
        this.dustBathResidueInOz = dustBathResidueInOz;

    }

    /**
     * The amount a chinchilla would eat of a certain food.
     * eats 3 units of food when eats() is called with "pellets"
     * eats 1 unit of food when eats() is called with "hay"
     * @param foodLabel the type of food being asked
     * @return the amount of that food a bird would eat
     */
    @Override
    public int eats(String foodLabel) {
        if (foodLabel.equals("pellets")){
            return 3;
        } else if (foodLabel.equals("hay")){
            return 1;
        }
        return 0;
    }

    /**
     * the weight of the chinchilla, plus the dust bath residue in Oz
     * @return the total weight rounded to the nearest oz
     */
    @Override
    public int getWeightInOz() {
        return weightInOz + dustBathResidueInOz;
    }
}
