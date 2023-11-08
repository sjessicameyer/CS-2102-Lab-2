import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

public class Examples{
    /* ASSIGNMENT
    * Implement and submit an Examples.java that tests:
    *
    * SuperPetRescue's methods
    * BirdZone, CatZone, and ChinchillaZone's methods (defined by Zoneable)
    * Bird, Cat, and Chinchilla's methods (defined by Petable)
    * */

    private CatZone catZone = makeExampleCatZone();
    private BirdZone birdZone = makeExampleBirdZone();
    private ChinchillaZone chinchillaZone = makeExampleChinchillaZone();
    private SuperPetRescue superPetRescue = makeExampleSPR();

    public Examples(){

    }

    //helper methods
    private CatZone makeExampleCatZone(){
        //create CatZone
        LinkedList<Cat> cats = new LinkedList<Cat>();
        Cat c1 = new Cat("Socks",3,6,new Coord2D(2,3),false);
        Cat c2 = new Cat("Mittens",4,8,new Coord2D(4,5),true);
        cats.add(c1);
        cats.add(c2);
        return new CatZone(cats);
    }

    private BirdZone makeExampleBirdZone(){
        //create BirdZone
        LinkedList<Bird> birds = new LinkedList<Bird>();
        Bird b1 = new Bird("Blue",1,3,new Coord2D(2,2),true);
        Bird b2 = new Bird("Yellow",2,4,new Coord2D(4,6),false);
        birds.add(b1);
        birds.add(b2);
        return new BirdZone(birds);
    }

    private ChinchillaZone makeExampleChinchillaZone(){
        //create ChinchillaZone
        LinkedList<Chinchilla> chinchilla = new LinkedList<Chinchilla>();
        Chinchilla ch1 = new Chinchilla("Torta",10,7,new Coord2D(1,2),3);
        Chinchilla ch2 = new Chinchilla("Tamale",8,9,new Coord2D(3,6),6);
        chinchilla.add(ch1);
        chinchilla.add(ch2);
        return new ChinchillaZone(chinchilla);
    }

    private SuperPetRescue makeExampleSPR(){
        LinkedList<Zoneable> zones = new LinkedList<Zoneable>();
        zones.add(birdZone);
        zones.add(chinchillaZone);
        zones.add(catZone);
        return new SuperPetRescue(zones);
    }

    /* ANIMAL TESTS */

    @Test
    public void testBirdEats(){
        Bird b = new Bird("Blue",4,12,new Coord2D(2,2),false);
        assertEquals(1, b.eats("seeds"));
    }

    @Test
    public void testBirdNotEats(){
        Bird b = new Bird("Blue",4,12,new Coord2D(2,2),false);
        assertEquals(0, b.eats("lemons"));
    }

    @Test

    public void testCatEatsYesPet(){
        Cat c = new Cat("Aria",4,12,new Coord2D(2,2),true);
        assertEquals(2, c.eats("cans"));
    }

    @Test
    public void testCatEatsNoPet(){
        Cat c = new Cat("Aria",4,12,new Coord2D(2,2),false);
        assertEquals(1, c.eats("cans"));
    }

    @Test
    public void testCatEatsTreatsBaby(){
        Cat c = new Cat("Kitten",4,6,new Coord2D(2,2),true);
        assertEquals(1, c.eats("treats"));
    }

    @Test
    public void testCatEatsTreatsAdult(){
        Cat c = new Cat("Adult",4,19,new Coord2D(2,2),true);
        assertEquals(3, c.eats("treats"));
    }

    @Test
    public void testCatNotEats(){
        Cat c = new Cat("Adult",4,19,new Coord2D(2,2),true);
        assertEquals(0, c.eats("lemons"));
    }

    @Test
    public void testChinchillaWeightInOz(){
        Chinchilla ch = new Chinchilla("Dusty",4,20,new Coord2D(0,0), 4);
        assertEquals(24, ch.getWeightInOz());
    }

    @Test
    public void testChinchillaEatsPellets(){
        Chinchilla ch = new Chinchilla("Dusty",4,20,new Coord2D(0,0), 4);
        assertEquals(3, ch.eats("pellets"));
    }

    @Test
    public void testChinchillaEatsHay(){
        Chinchilla ch = new Chinchilla("Dusty",4,20,new Coord2D(0,0), 4);
        assertEquals(1, ch.eats("hay"));
    }

    @Test
    public void testChinchillaNotEats(){
        Chinchilla ch = new Chinchilla("Dusty",4,20,new Coord2D(0,0), 4);
        assertEquals(0, ch.eats("lemons"));
    }

    @Test
    public void animalGetName(){
        Bird b = new Bird("Blue",4,3,new Coord2D(0,0), true);
        Cat c = new Cat("Aria",4,20,new Coord2D(0,0), true);
        Chinchilla ch = new Chinchilla("Dusty",4,20,new Coord2D(0,0), 4);
        assertEquals("Blue", b.getName());
        assertEquals("Aria", c.getName());
        assertEquals("Dusty", ch.getName());
    }

    @Test
    public void animalGetWeight(){
        Bird b = new Bird("Blue",4,3,new Coord2D(0,0), true);
        Cat c = new Cat("Aria",4,20,new Coord2D(0,0), true);
        assertEquals(3, b.getWeightInOz());
        assertEquals(20, c.getWeightInOz());
    }

    @Test
    public void animalGetAge(){
        Bird b = new Bird("Blue",4,3,new Coord2D(0,0), true);
        Cat c = new Cat("Aria",4,20,new Coord2D(0,0), true);
        Chinchilla ch = new Chinchilla("Dusty",4,20,new Coord2D(0,0), 4);
        assertEquals(4, b.getAge());
        assertEquals(4, c.getAge());
        assertEquals(4, ch.getAge());
    }

    /** ZONE Tests */
    //TODO: implement empty zone version
    @Test
    public void catZoneTestPetsInZoneEmpty(){
        CatZone zone = new CatZone(new LinkedList<Cat>());
        assertEquals(zone.petsInZone(), 0);
    }

    @Test
    public void chinchillaZoneTestPetsInZoneEmpty(){
        ChinchillaZone zone = new ChinchillaZone(new LinkedList<Chinchilla>());
        assertEquals(zone.petsInZone(), 0);
    }

    @Test
    public void birdZoneTestPetsInZoneEmpty(){
        BirdZone zone = new BirdZone(new LinkedList<Bird>());
        assertEquals(zone.petsInZone(), 0);
    }

    @Test
    public void catZoneTestPetsInZone(){
        assertEquals(catZone.petsInZone(), 2);
    }

    @Test
    public void chinchillaZoneTestPetsInZone(){
        assertEquals(chinchillaZone.petsInZone(), 2);
    }

    @Test
    public void birdZoneTestPetsInZone(){
        assertEquals(birdZone.petsInZone(), 2);
    }

    //TODO: implement 1 pet version
    @Test
    public void catZoneTestHeaviestPet(){
        assertEquals(catZone.heaviestPet().getName(), "Mittens");
    }

    //TODO: implement 1 pet version
    @Test
    public void chinchillaZoneTestHeaviestPet(){
        assertEquals(chinchillaZone.heaviestPet().getName(), "Tamale");
    }

    @Test
    public void birdZoneTestHeaviestPet(){
        assertEquals(birdZone.heaviestPet().getName(), "Yellow");
    }

    @Test
    public void birdZoneTestHeaviest1Bird(){
        LinkedList<Bird> birds = new LinkedList<Bird>();
        birds.add(new Bird("Blue",1,3,new Coord2D(2,2),true));
        BirdZone bz = new BirdZone(birds);
        assertEquals("Blue", bz.heaviestPet().getName());
    }

    @Test
    public void birdZoneTestHumanYearsExists(){
       assertEquals(birdZone.inHumanYears("Yellow"), 18);
    }

    @Test
    public void birdZoneTestHumanYearsNonexistent(){
        assertEquals(birdZone.inHumanYears("Green"), -1);
    }

    @Test
    public void catZoneTestHumanYearsExists(){
        assertEquals(catZone.inHumanYears("Mittens"), 24);
    }

    @Test
    public void catZoneTestHumanYearsNonexistent(){
        assertEquals(catZone.inHumanYears("Green"), -1);
    }

    @Test
    public void chinchillaZoneTestHumanYearsExists(){
        assertEquals(chinchillaZone.inHumanYears("Torta"), 100);
    }

    @Test
    public void chinchillaZoneTestHumanYearsNonexistent(){
        assertEquals(chinchillaZone.inHumanYears("Green"), -1);
    }

    @Test
    public void birdZoneTestRestock(){
        BirdZone zone = new BirdZone(new LinkedList<Bird>());
        assertEquals(zone.restockPetFood("seeds", 1).getPantryLabel(), "Bird: 1 seeds");
    }

    @Test
    public void catZoneTestRestockCans(){
        CatZone zone = new CatZone(new LinkedList<Cat>());
        assertEquals(zone.restockPetFood("cans", 5).getPantryLabel(), "Cat: 5 cans, 0 treats");
    }

    @Test
    public void catZoneTestRestockTreats(){
        CatZone zone = new CatZone(new LinkedList<Cat>());
        assertEquals(zone.restockPetFood("treats", 5).getPantryLabel(), "Cat: 0 cans, 5 treats");
    }

    @Test
    public void catZoneTestRestockBoth(){
        CatZone zone = new CatZone(new LinkedList<Cat>());
        assertEquals(zone.restockPetFood("treats", 5).restockPetFood("cans", 5).getPantryLabel(), "Cat: 5 cans, 5 treats");
    }

    //TODO: Test restocking twice for other zones as well.
    @Test
    public void catZoneTestRestockTwice(){
        CatZone zone = new CatZone(new LinkedList<Cat>());
        assertEquals(zone.restockPetFood("cans", 5).getPantryLabel(), "Cat: 5 cans, 0 treats");
        //zone.restockPetFood("cans", 5);
        assertEquals(zone.restockPetFood("cans", 5).getPantryLabel(), "Cat: 10 cans, 0 treats");
    }

    @Test
    public void chinchillaZoneTestRestockPellets(){
        ChinchillaZone zone = new ChinchillaZone(new LinkedList<Chinchilla>());
        assertEquals(zone.restockPetFood("pellets", 1).getPantryLabel(), "Chinchilla: 1 pellets, 0 hay");
    }

    @Test
    public void chinchillaZoneTestRestockHay(){
        ChinchillaZone zone = new ChinchillaZone(new LinkedList<Chinchilla>());
        assertEquals(zone.restockPetFood("hay", 1).getPantryLabel(), "Chinchilla: 0 pellets, 1 hay");
    }

    @Test
    public void chinchillaZoneTestRestockBoth(){
        ChinchillaZone zone = new ChinchillaZone(new LinkedList<Chinchilla>());
        assertEquals(zone.restockPetFood("hay", 1).restockPetFood("pellets", 1).getPantryLabel(), "Chinchilla: 1 pellets, 1 hay");
    }

    //test feedZone

    @Test
    public void birdZoneTestFeedZone(){
        BirdZone zone = makeExampleBirdZone();
        zone.restockPetFood("seeds", 3);
        assertEquals(zone.feedZone().getPantryLabel(), "Bird: 1 seeds");
    }

    @Test
    public void birdZoneTestFeedZoneRunOut(){
        BirdZone zone = makeExampleBirdZone();
        zone.restockPetFood("seeds", 1);
        assertEquals(zone.feedZone().getPantryLabel(), "Bird: 0 seeds");
    }

    @Test
    public void catZoneTestFeedZone(){
        CatZone zone = makeExampleCatZone();
        zone.restockPetFood("cans", 100).restockPetFood("treats", 100);
        assertEquals(zone.feedZone().getPantryLabel(), "Cat: 97 cans, 97 treats");
    }

    @Test
    public void catZoneTestFeedZoneRunOut(){
        CatZone zone = makeExampleCatZone();
        zone.restockPetFood("cans", 1).restockPetFood("treats", 1);
        assertEquals(zone.feedZone().getPantryLabel(), "Cat: 0 cans, 0 treats");
    }

    @Test
    public void chinchillaZoneTestFeedZone(){
        ChinchillaZone zone = makeExampleChinchillaZone();
        zone.restockPetFood("hay", 100).restockPetFood("pellets", 100);
        assertEquals(zone.feedZone().getPantryLabel(), "Chinchilla: 94 pellets, 98 hay");
    }

    @Test
    public void chinchillaZoneTestFeedZoneRunOut(){
        ChinchillaZone zone = makeExampleChinchillaZone();
        zone.restockPetFood("hay", 1).restockPetFood("pellets", 1);
        assertEquals(zone.feedZone().getPantryLabel(), "Chinchilla: 0 pellets, 0 hay");
    }

    //test getPet -> skipping testing bc this is a helper function

    //test getPantryLabel -> skipping testing bc this is a helper function

    @Test
    public void catZoneTestClosestPet(){
        assertEquals(catZone.closestPet(0, 0), "Socks");
    }

    @Test
    public void chinchillaZoneTestClosestPet(){
        assertEquals(chinchillaZone.closestPet(0, 0), "Torta");
    }

    @Test
    public void birdZoneTestClosestPet(){
        assertEquals(birdZone.closestPet(0, 0), "Blue");
    }

    @Test
    public void birdZoneTestClosestClipped(){
        LinkedList<Bird> birds = new LinkedList<Bird>();
        birds.add(new Bird("Blue",1,3,new Coord2D(2,2),true));
        BirdZone bz = new BirdZone(birds);
        assertEquals("Blue", bz.closestPet(4,5));
    }


    /** SuperPetRescue Tests */
    @Test
    public void totalPetsTestEmpty(){
        new Examples();
        LinkedList<Zoneable> zones = new LinkedList<Zoneable>();
        SuperPetRescue superPetRescueEmpty = new SuperPetRescue(zones);
        assertEquals("There are no pets", superPetRescueEmpty.totalPets(), 0);
    }

    @Test
    public void totalPetsTestNonEmpty(){
        new Examples();
        assertEquals("There are four pets", superPetRescue.totalPets(), 6);
    }

    @Test
    public void getHeaviestPetsNameEmpty(){
        LinkedList<Zoneable> zones = new LinkedList<Zoneable>();
        SuperPetRescue superPetRescueEmpty = new SuperPetRescue(zones);
        assertEquals("There are no pets", superPetRescueEmpty.getHeaviestPetsName(), null);
    }

    @Test
    public void getHeaviestPetsNameNonEmpty(){
        assertEquals("The heaviest pet is named Tamale", superPetRescue.getHeaviestPetsName(), "Tamale");
    }



}