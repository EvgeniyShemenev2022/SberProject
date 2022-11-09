package org.shemenev;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

//    static String path = "src/main/resources/city_ru.csv";
    static List<City> cityList = new ArrayList<City>();


    public static void readFromFile(String path, List<City> cityList) throws IOException {

        Scanner scanner = new Scanner(new File(path), StandardCharsets.UTF_8);
        String line = "";

        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            String[] obj = line.split(";");

            if (obj.length == 5) {
                cityList.add(new City(obj[1], obj[2], obj[3], obj[4], "нет данных"));
            } else {
                cityList.add(new City(obj[1], obj[2], obj[3], obj[4], obj[5]));
            }
        }
        scanner.close();
    }

    public static void main(String[] args) throws IOException {

        System.out.println("""
                ----
                Пожалуйста, введите путь к фалу  city_ru.csv 
                Убедитесь, что путь не содержит кириллицу!
                ----
                """);
        Scanner inputPath = new Scanner(System.in);
        String path = inputPath.next();
        inputPath.close();

        readFromFile(path, cityList);
        cityList.forEach(System.out::println);
    }
}

          // другой вариант решения:

//        List<City> cityList2 = new ArrayList<>();
//
//        try (Stream<String> stream = Files.lines(Paths.get(path), StandardCharsets.UTF_8)) {
//            cityList2 = stream
//                    .map(a -> a.split(";"))
//                    .map(b -> new City(b[1], b[2], b[3], b[4], b.length < 6 ? "нет данных" : b[5]))
//                    .collect(Collectors.toList());
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//        cityList2.forEach(System.out::println);