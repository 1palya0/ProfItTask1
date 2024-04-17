package org.example;


import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        String folderPath = args[0];
        String attribute = args[1];

        StreamJsonParser jsonParser = new StreamJsonParser();
        List<Book> books = null;
        try {
            books = jsonParser.parseJsonFiles(folderPath);
        } catch (IOException e) {
            System.err.println("Помилка при парсингу JSON-файлів: " + e.getMessage());
            System.exit(1);
        }


        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
        Map<String, Long> statistics = statisticsCalculator.calculateStatistics(books, attribute);


        String outputFile = "statistics_by_" + attribute + ".xml";
        try {
            XmlWriter.writeStatisticsToXml(statistics, attribute, outputFile);
            System.out.println("Статистика успішно збережена у файлі " + outputFile);
        } catch (IOException e) {
            System.err.println("Помилка при записі статистики у XML-файл: " + e.getMessage());
            System.exit(1);
        }

    }


}