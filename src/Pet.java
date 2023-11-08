    /**
 * A pet
 */
public abstract class Pet implements Petable {

    /**
     * The name of the pet
     */
    public String name;
    /**
     * The weight of the pet in oz
     */
    public int weightInOz;
    /**
     * The age of the pet in years
     */
    public int age;

    /**
     * The location of the pet in 2D
     */
    public Coord2D location;

    /**
     * Constructs a pet
     * @param name the name of the pet
     * @param age the age of the pet
     * @param weightInOz the weight of the pet
     * @param location the location of the pet
     */
    public Pet(String name, int age, int weightInOz, Coord2D location){
        this.name = name;
        this.weightInOz = weightInOz;
        this.age = age;
        this.location = location;
    }

    /**
     * Produces the name of this pet in the rescue
     * @return the pet's name as a string
     */
    public String getName(){
        return name;
    }

    /**
     * the weight of the pet in Oz
     * @return the weight rounded to the nearest oz
     */
    public int getWeightInOz(){
        return weightInOz;
    }

    /**
     * get the age of the pet
     * @return the age of the pet in years
     */
    public int getAge(){
        return age;
    }

}
