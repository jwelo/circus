package circus;

import java.util.ArrayList;
import java.util.Arrays;

import circus.stuff.Equipment;
import circus.stuff.Cannon;
import circus.stuff.Ladder;

import circus.animal.Animal;
import circus.animal.Duck;
import circus.animal.Parrot;
import circus.animal.Tiger;
import circus.animal.Elephant;


public class Circus {
    private static Animal[] animals = {
            new Duck("Drake"),
            new Parrot("Polly"),
            new Tiger("Tai Lung")
    };
    private static Equipment[] equipments = {
            new Ladder(50),
            new Cannon(5),
            new Cannon(100)
    };

    private static void makeAnimalsTalk() {
        for (Animal a : animals) {
            System.out.println(a);
            System.out.println(a.speak());
        }
    }

    private static int calculateAssetValue(Asset[] assets) {
        int total = 0;
        for (Asset a : assets) {
            if (a.getValue() <= 5) {
                System.out.println("Ignoring low value item: " + a.getValue());
                continue;
            }
            total += a.getValue();
            System.out.println("Adding item value: " + a.getValue());
        }
        return total;
    }

    public static void main(String[] args) {
//        makeAnimalsTalk();
//        System.out.println("Total value of animals " + calculateAssetValue(animals));
//        System.out.println("Total value of equipments " + calculateAssetValue(equipments));
//        System.out.println("Numbers of animals in circus: " + animals.length);
//        for (Animal a: animals) {
//            System.out.println(a);
//        }
        //animals[3] = new Elephant("Strong one");
//        System.out.println("Numbers of animals in circus: " + animals.length);
//        for (Animal a: animals) {
//            System.out.println(a);
//        }
        ArrayList<Animal> animalArrayList = new ArrayList<>(Arrays.asList(animals));
        printNumberOfAnimals(animalArrayList);
        animalArrayList.add(new Elephant("strong one"));
        printNumberOfAnimals(animalArrayList);
        printAllAnimals(animalArrayList);
        animalArrayList.add(new Duck( "Andy"));
        Tiger sherKhan = new Tiger("Sher Khan");
        animalArrayList.add(sherKhan);
        Parrot bobby = new Parrot("Bobby");
        animalArrayList.add(bobby);

        System.out.println("Position of sher khan in array list is: " + animalArrayList.indexOf(sherKhan));

        System.out.println("before sorting");
        printAllAnimals(animalArrayList);
        animalArrayList.sort(Animal.AnimalNameComparator);
        System.out.println("after sorting:");
        printAllAnimals(animalArrayList);

        Animal candidate = findAnimal(animalArrayList,"Polly");
        System.out.println("Polly is at index: " + animalArrayList.indexOf(candidate));
    }

    private static void printNumberOfAnimals(ArrayList<Animal> animalArrayList) {
        System.out.println("numbers of aniamls in circus (AL)" + animalArrayList.size());
    }

    private static Animal findAnimal(ArrayList<Animal> animalArrayList, String name) {
        for (Animal a: animalArrayList) {
            if (a.name == name) {
                return a;
            }
        }
        return null;
    }

    private static void printAllAnimals(ArrayList<Animal> animalArrayList) {
        for (Animal a : animalArrayList) {
            System.out.println(a);
        }
    }
}