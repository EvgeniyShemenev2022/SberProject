package org.etalonnoeReshenie;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CityUtils {

    static String path = "src/main/resources/city_ru.csv";

    /**
     * Выводит на экран отображение всех объектов класса City в списке;
     *
     * @param citiesList список городов
     */
    public static void printer(List<City> citiesList){
        citiesList.forEach(System.out::println);
    }

    /**
     * Читает файл построчно;
     * Вызывает метод parse() и заполняет список объектами класса City;
     *
     * @return список объектов City
     */
    public static List<City> citiesCollector() {
        List<City> citiesList = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(path), StandardCharsets.UTF_8); // читаем файл, уточняем кодировку
            while (scanner.hasNextLine()) {
                citiesList.add(parse(scanner.nextLine())); // заполняем список объектами, пока есть след строка
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {           // т.к. в параметрах присутствует .UTF_8
            throw new RuntimeException(e);
        }
        return citiesList;
    }

    /**
     * Разделяет входящую строку по заданному шаблону,
     * пропускает числовое значение (оно не нужно по задание),
     * поочереди считывает каждый элемент и присваивает это
     * значение полям класса City;
     *
     * @param line очередная строка
     * @return объект типа City
     */
    public static City parse(String line) {
        Scanner scanner = new Scanner(line);
        scanner.useDelimiter(";");
        scanner.skip("\\d*");
        String name = scanner.next();
        String region = scanner.next();
        String district = scanner.next();
        int population = scanner.nextInt();
        String foundation = null; // в исходном файле есть города без этого значения;

        if (scanner.hasNext()) {
            foundation = scanner.next();
        }
        scanner.close();

        return new City(name, region, district, population, foundation == null ? "нет данных" : foundation);
    }
}
