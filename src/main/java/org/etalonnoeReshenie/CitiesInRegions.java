package org.etalonnoeReshenie;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


public class CitiesInRegions {

    /**
     * статический метод, проходится по списку объектов, и добавляет в
     * карту "regionsMap" информацию по принципу:
     * Челябинская область - 30;
     * Чечня - 5;
     * где  название области - key,
     * а количество городов в этой области - value;
     *
     * @param cities список объектов класса City
     */
    public static void mapper(List<City> cities) {

        // чтобы иметь удобство выводить на экран информацию из карты в лексикографическом порядке, используем TreeMap
        Map<String, Integer> regionsMap = new TreeMap<>();

        // конвертируем List в Array (учитывая прошлое задание), технической необходимости в этом нет;
        City[] citiesArray = cities.toArray(City[]::new);

        for (City city : citiesArray) {
            if (regionsMap.containsKey(city.getRegion())) {
                regionsMap.put(city.getRegion(), regionsMap.get(city.getRegion()) + 1);
            } else {
                regionsMap.put(city.getRegion(), 1);
            }
        }
        regionsMap.forEach((a, b) -> System.out.println(a + " - " + b));
    }

}
