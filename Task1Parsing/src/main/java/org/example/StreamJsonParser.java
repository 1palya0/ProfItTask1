package org.example;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class StreamJsonParser {
    private final JsonFactory jsonFactory;

    public StreamJsonParser() {
        this.jsonFactory = new JsonFactory();
    }

    public List<Book> parseJsonFiles(String folderPath) throws IOException {
        List<Book> books = new ArrayList<>();
        File folder = new File(folderPath);
        File[] files = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".json"));

        if (files != null) {
            for (File file : files) {
                parseJsonFile(file, books);
            }
        }
        return books;
    }

    private void parseJsonFile(File file, List<Book> books) throws IOException {
        try (JsonParser jsonParser = jsonFactory.createParser(file)) {
            while (jsonParser.nextToken() != null) {
                if (jsonParser.currentToken() == JsonToken.START_OBJECT) {
                    Book book = parseJsonObject(jsonParser);
                    if (book != null) {
                        books.add(book);
                    }
                }
            }
        }
    }

    private Book parseJsonObject(JsonParser jsonParser) throws IOException {
        Book book = null;
        while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
            String fieldName = jsonParser.getCurrentName();
            if ("title".equals(fieldName)) {
                jsonParser.nextToken();
                String title = jsonParser.getValueAsString();
                book = new Book();
                book.setTitle(title);
            } else if ("author".equals(fieldName)) {
                jsonParser.nextToken();
                String author = jsonParser.getValueAsString();
                book.setAuthor(author);
            } else if ("year_published".equals(fieldName)) {
                jsonParser.nextToken();
                int yearPublished = jsonParser.getIntValue();
                book.setYear_published(yearPublished);
            } else if ("genre".equals(fieldName)) {
                jsonParser.nextToken();
                String genre = jsonParser.getValueAsString();
                book.setGenre(genre);
            }
        }
        return book;
    }
}