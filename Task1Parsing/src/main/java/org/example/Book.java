package org.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Book {
    private String title;
    private String author;
    private int year_published;
    private String genre;

    public Book() {
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year_published='" + year_published + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }

    public Book(String title, String author, int yearOfPublish, String genre) {
        this.title = title;
        this.author = author;
        this.year_published = yearOfPublish;
        this.genre = genre;
    }


    public List<String> getAttribute(String attribute) {
        switch (attribute) {
            case "title":
                return Collections.singletonList(title);
            case "author":
                return Collections.singletonList(author);
            case "year_published":
                return List.of(String.valueOf(year_published));
            case "genre":
                return Arrays.asList(genre.split(", "));
            default:
                throw new IllegalArgumentException("Invalid attribute: " + attribute);
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear_published() {
        return year_published;
    }

    public void setYear_published(int year_published) {
        this.year_published = year_published;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
