package org.etalonnoeReshenie;

import static org.etalonnoeReshenie.CityUtils.*;  // статический импорт для более читабельного кода
import static org.etalonnoeReshenie.CitiesSorting.*;
import static org.etalonnoeReshenie.IndexCityFinder.*;
import static org.etalonnoeReshenie.CitiesInRegions.*;


public class Main {

    public static void main(String[] args) {

       /*//task # 1
        printer(citiesCollector());


        //task # 2
        printSortingCity(citiesCollector(), new nameComparator()); // по имени города
        printSortingCity(citiesCollector(), new districtAndNameComparator());  // по округам и именам внутри округов
        lambdaSortedByName(citiesCollector());  // реализация lambda выражения
        lambdaSortedByDistricts(citiesCollector());  // реализация lambda выражения


        // task # 3
        converter(citiesCollector());*/


        //task # 4
        mapper(citiesCollector());

    }
}
