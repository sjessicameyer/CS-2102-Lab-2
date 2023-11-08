/**
 * A cat, a type of pet
 */
public class Cat extends Pet{
    /**
     * Whether the cat has been pet today
     */
    public boolean hasBeenPetToday;

    /**
     * Constructs a cat
     * @param name the name of the cat
     * @param age the age of the cat
     * @param weightInOz the weight of the cat in oz
     * @param location the coordinates of the cat
     * @param hasBeenPetToday whether the cat has been pet today
     */
    public Cat(String name, int age, int weightInOz, Coord2D location, boolean hasBeenPetToday){
        super(name, age, weightInOz, location);
        this.hasBeenPetToday = hasBeenPetToday;
    }

    /**
     * The amount a cat would eat of a certain food.
     * eats 1 "cans" when the cat has not been pet today
     * eats 2 "cans" when the cat has been pet today
     * eats 1 "treats" plus 1 extra treat for every 8 oz they weigh
     * eats 0 of anything else
     * @param foodLabel the type of food being asked
     * @return the amount of that food a cat would eat
     */
    @Override
    public int eats(String foodLabel) {
        switch(foodLabel){
            case "cans":
                if (this.hasBeenPetToday){
                    return 2;
                }
                return 1;

            case "treats":
                return 1 + (this.getWeightInOz() / 8);

            default:
                return 0;
        }
    }
}