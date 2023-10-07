import models.Animal;
import models.Life;
import models.Plant;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class StreamTest {
    //Data to be inserted
    Animal cow = new Animal("Cow", 4, false);
    Animal snake = new Animal("Zig-zag viper", 0, true);
    Animal pigeon = new Animal("Pigeon", 2, false);
    Animal dog = new Animal("Dog", 4, false);
    Animal cat = new Animal("Cat", 2, false);
    Animal spider = new Animal("Spider", 8, true);
    Animal fly = new Animal("Fly", 6, false);

    Plant oak = new Plant("Oak", 5.5, "acorns");
    Plant appleTree = new Plant("Apple tree", 3.0, "apple");
    Plant strawberries = new Plant("Strawberries", 0.3, "Strawberries");
    Plant sunflower = new Plant("Sunflower", 4.0, "Sunflower seeds");
    Plant blueberry = new Plant("Blueberry", 0.5, "Blueberry");
    Plant pearTree = new Plant("Pear Tree", 3.0, "Pear");
    Plant apricotTree = new Plant("Apricot Tree", 3.7, "Apricot");

    List<Animal> animalsPoland = Arrays.asList(cow, snake, pigeon);
    List<Plant> plantsPoland = Arrays.asList(oak, appleTree, strawberries);
    List<Animal> universalAnimals = Arrays.asList(cow, dog, pigeon);
    List<Plant> universalPlants = Arrays.asList(oak, strawberries, sunflower);
    List<Animal> uniqueAnimals = Arrays.asList(cat, spider, fly);
    List<Plant> uniquePlant = Arrays.asList(blueberry, pearTree, apricotTree);

    Life lifePoland = new Life("Poland", animalsPoland, plantsPoland);
    Life lifeUSA = new Life("USA", universalAnimals, universalPlants);
    Life lifeFrance = new Life("France", universalAnimals, universalPlants);
    Life lifeSpain = new Life("Spain", uniqueAnimals, uniquePlant);

    List<Life> lifeElements = Arrays.asList(lifePoland, lifePoland, lifeUSA, lifeFrance, lifeSpain);

    //Ex. 1
    @Test
    public void shouldGetUniqueAnimals() {
        String expectedUniqueAnimals = "[Animal species='Cow', numberOfLegs=4, venomous=false, " +
                "Animal species='Zig-zag viper', numberOfLegs=0, venomous=true, " +
                "Animal species='Pigeon', numberOfLegs=2, venomous=false, " +
                "Animal species='Dog', numberOfLegs=4, venomous=false, " +
                "Animal species='Cat', numberOfLegs=2, venomous=false, " +
                "Animal species='Spider', numberOfLegs=8, venomous=true, " +
                "Animal species='Fly', numberOfLegs=6, venomous=false]";


        String actualUniqueAnimals = lifeElements.stream()
                .map(Life::getAnimals)
                .flatMap(Collection::stream)
                .distinct()
                .map(Animal::toString).toList().toString();

        Assert.assertEquals(expectedUniqueAnimals, actualUniqueAnimals);
        System.out.println(actualUniqueAnimals);
    }

    //Ex. 2
    @Test
    public void shouldGetUniquePlants() {
        String expectedUniquePlants = "[{\"species\":\"Oak\",\"standardHigh\":5.5,\"fruitName\":\"acorns\"}, " +
                "{\"species\":\"Apple tree\",\"standardHigh\":3.0,\"fruitName\":\"apple\"}, " +
                "{\"species\":\"Strawberries\",\"standardHigh\":0.3,\"fruitName\":\"Strawberries\"}, " +
                "{\"species\":\"Sunflower\",\"standardHigh\":4.0,\"fruitName\":\"Sunflower seeds\"}, " +
                "{\"species\":\"Blueberry\",\"standardHigh\":0.5,\"fruitName\":\"Blueberry\"}, " +
                "{\"species\":\"Pear Tree\",\"standardHigh\":3.0,\"fruitName\":\"Pear\"}, " +
                "{\"species\":\"Apricot Tree\",\"standardHigh\":3.7,\"fruitName\":\"Apricot\"}]";

        String actualUniquePlants = lifeElements.stream()
                .map(Life::getPlants)
                .flatMap(Collection::stream)
                .distinct()
                .map(Plant::toString)
                .toList().toString();

        Assert.assertEquals(expectedUniquePlants, actualUniquePlants);
        System.out.println(actualUniquePlants);
    }

    //Ex. 3
    @Test
    public void shouldFindCountryStartingSAndSortPlantsByStandardHigh() {
        String expectedPlantName = "Apricot Tree";

        String actualPlantName = lifeElements.stream()
                .filter(e -> e.getCountry().startsWith("S"))
                .map(Life::getPlants)
                .flatMap(Collection::stream)
                .sorted(Comparator.comparing(Plant::getStandardHigh).reversed())
                .findFirst()
                .get()
                .getSpecies();

        Assert.assertEquals(expectedPlantName, actualPlantName);
    }

    //Ex. 4
    @Test
    public void shouldFindCountryWithFiveLettersNameSortAnimalsByLegsAndGetOneWithEightLegs() {
        String expectedAnimalWithEightLegs = "Spider";

        String actualAnimalWithEightLegs = lifeElements.stream()
                .filter(e -> e.getCountry().length() == 5)
                .map(Life::getAnimals)
                .flatMap(Collection::stream)
                .collect(Collectors.groupingBy(Animal::getNumberOfLegs))
                .get(8)
                .stream().findFirst().map(Animal::getSpecies).toString();

        assertThat(actualAnimalWithEightLegs, containsString(expectedAnimalWithEightLegs));
    }

    //Ex. 5
    @Test
    public void shouldSortCountryByName() {
        List<String> expectedCountriesOrder = new ArrayList<>();
        expectedCountriesOrder.add(0, "France");
        expectedCountriesOrder.add(1, "Poland");
        expectedCountriesOrder.add(2, "Poland");
        expectedCountriesOrder.add(3, "Spain");
        expectedCountriesOrder.add(4, "USA");

        List<String> actualCountriesOrder = lifeElements.stream()
                .map(Life::getCountry)
                .sorted()
                .toList();

        assertThat(expectedCountriesOrder).hasSameElementsAs(actualCountriesOrder);
    }

    //Ex. 6
    @Test
    public void shouldSortCountryByNameSecondLetter() {
        List<String> expectedCountriesOrder = new ArrayList<>();
        expectedCountriesOrder.add(0, "poland");
        expectedCountriesOrder.add(1, "poland");
        expectedCountriesOrder.add(2, "spain");
        expectedCountriesOrder.add(3, "france");
        expectedCountriesOrder.add(4, "usa");

        List<String> actualCountriesOrder = lifeElements.stream()
                .map(Life::getCountry)
                .map(String::toLowerCase)                           //toLowerCase() added to avoid taking upper case letters as first
                .sorted(Comparator.comparing(o -> o.charAt(1)))
                .toList();

        assertThat(expectedCountriesOrder).hasSameElementsAs(actualCountriesOrder);
    }

    @Test
    public void shouldReturnListOfCountriesWithAtLestOneVenomousAnimal() {
        List<String> expectedCountries = new ArrayList<>();
        expectedCountries.add("Poland");
        expectedCountries.add("Poland");
        expectedCountries.add("Spain");

        List<String> actualCountries = lifeElements.stream()
                .filter(e -> e.getAnimals().stream().map(Animal::isVenomous).anyMatch(v -> v))
                .map(Life::getCountry)
                .toList();

        assertThat(expectedCountries).hasSameElementsAs(actualCountries);
    }
}
