package org.shemenev;

import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MainTest {

    String path = "src/test/resources/city_ru_test.csv";
    List<City> testCityList = new ArrayList<City>();

    @Test
    public void should_collect_to_list() throws FileNotFoundException {
        City city1 = new City("Адыгейск","Адыгея","Южный","12248","1973");
        City city2 = new City("Майкоп","Адыгея","Южный","144246","1857");
        City city3 = new City("Горно-Алтайск","Алтай","Сибирский","56928","19 век");
        City city4 = new City("Алейск","Алтайский край","Сибирский","29512","1913");
        City city5 = new City("Барнаул","Алтайский край","Сибирский","612091","нет данных");

        List<City> expectedCityList = new ArrayList<City>();
        expectedCityList.add(city1);
        expectedCityList.add(city2);
        expectedCityList.add(city3);
        expectedCityList.add(city4);
        expectedCityList.add(city5);

        Main.readFromFile(path, testCityList);

        assertEquals(expectedCityList, testCityList);

    }
}
