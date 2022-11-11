package org.etalonnoeReshenie;

import static org.etalonnoeReshenie.CityUtils.*;  // статический импорт для более читабельного кода
import static org.etalonnoeReshenie.CitiesSorting.*;

public class Main {

    public static void main(String[] args) {

//        printer(citiesCollector());

        printSortingCity(citiesCollector(), new nameComparator()); // по имени города

        printSortingCity(citiesCollector(), new districtAndNameComparator());  // по округам и именам внутри округов

//        lambdaSortedByName(citiesCollector());  // реализация lambda выражения

//        lambdaSortedByDistricts(citiesCollector());  // реализация lambda выражения
    }
}
