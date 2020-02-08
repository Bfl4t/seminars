package ru.bfl4t.spsuace.serialization;

import org.junit.Test;

import java.io.*;
import java.util.Arrays;

import static org.junit.Assert.*;

public class AnimalTest {

    @Test
    public void serialize() throws IOException, ClassNotFoundException {

        Food blueberries = new Food(FoodName.BLUEBERRIES, 0.4);
        Food apples = new Food(FoodName.APPLES, 1.2);
        Food bacon = new Food(FoodName.BACON, 2.3);

        Animal human = new Animal(
                Arrays.asList(blueberries, apples, bacon),
                AnimalType.MAMMAL, "Jeff", 26);

        File file = new File("./human.ser");
        FileOutputStream fileOut =  new FileOutputStream(file);
        ObjectOutputStream outStream = new ObjectOutputStream(fileOut);
        outStream.writeObject(human);
        outStream.close();
        fileOut.close();

        Animal deserializedHuman = null;
        FileInputStream fileIn = new FileInputStream(file);
        ObjectInputStream inStream = new ObjectInputStream(fileIn);
        deserializedHuman = (Animal) inStream.readObject();
        inStream.close();
        fileIn.close();
        file.delete();

        assertEquals(human, deserializedHuman);
    }

}