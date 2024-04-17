package org.example;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.LinkedHashMap;

public class StatisticsCalculator {
    public Map<String, Long> calculateStatistics(List<Book> books, String attribute) {
        return books.stream()
                .filter(Objects::nonNull)
                .map(book -> book.getAttribute(attribute))
                .flatMap(List::stream)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                ))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new
                ));
    }
}