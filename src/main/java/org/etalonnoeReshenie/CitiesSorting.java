package org.etalonnoeReshenie;

import java.util.Comparator;
import java.util.List;

public class CitiesSorting {

    /**
     * Выводит на экран сортированный список в соответствии
     * с реализацией выбранного компаратора;
     * @param cities        список городов
     * @param anyComparator любой реализованный Comparator
     */
    public static void printSortingCity(List<City> cities, Comparator<City> anyComparator) {
        cities.sort(anyComparator);
        cities.forEach(System.out::println);
    }

    /**
     * Сортировка списка городов по наименованию в алфавитном порядке
     * @param cities список городов
     */
    public static void lambdaSortedByName(List<City> cities) {
        cities.sort(Comparator.comparing(City::getName));
        cities.forEach(System.out::println);
    }

    /**
     * Сортировка списка городов по федеральному округу
     * @param cities список городов
     */
    public static void lambdaSortedByDistricts(List<City> cities) {
        cities.sort(Comparator.comparing(City::getDistrict).thenComparing(City::getName));
        cities.forEach(System.out::println);
    }
}

/**
 * Сортировка списка городов по наименованию в алфавитном порядке
 * по убыванию без учета регистра;
 */
class nameComparator implements Comparator<City> {
    @Override
    public int compare(City city1, City city2) {
        return city1.getName().compareToIgnoreCase(city2.getName());
    }
}

/**
 * Сортировка списка городов по федеральному округу и наименованию
 * города внутри каждого федерального округа в алфавитном порядке
 * по убыванию с учетом регистра;
 */
class districtAndNameComparator implements Comparator<City> {
    @Override
    public int compare(City city1, City city2) {
        int result = city1.getDistrict().compareTo(city2.getDistrict());
        if (result == 0) {
            return city1.getName().compareToIgnoreCase(city2.getName());
        } else
            return result;
    }
}
