package org.etalonnoeReshenie;

import java.util.List;

public class IndexCityFinder {

    /**
     * Этот метод конвертирует список городов в
     * массив объектов класса City;
     * Итерация по элементам массива в поисках города с наибольшим
     * количеством жителей;
     * Вывод на экран по принципу:  [index] = population city_name
     *
     * @param cities список городов
     */
    public static void converter(List<City> cities){

        City[] citiesArray = cities.toArray(City[]::new);

        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < citiesArray.length; i++) {
            if (citiesArray[i].getPopulation() > max) {
                max = citiesArray[i].getPopulation();
                maxIndex = i;
            }
        }
        System.out.println("[" + maxIndex + "]" + " = " +  citiesArray[maxIndex].getPopulation()
        + " " + citiesArray[maxIndex].getName() );
    }

}
