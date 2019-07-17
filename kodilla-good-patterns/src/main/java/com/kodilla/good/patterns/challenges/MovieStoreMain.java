package com.kodilla.good.patterns.challenges;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MovieStoreMain {
    public static void main(String[] args) {
        MovieStore movieStore = new MovieStore();
        Map<String, List<String>> movieMap = movieStore.getMovies();

        System.out.println("List of movies - few lines:");
        movieMap.entrySet()
                .stream()
                .forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue().stream().collect(Collectors.joining(" ! "))));

        System.out.println("\nList of movies - one line version 1:");
        movieMap.entrySet()
                .stream()
                .forEach(entry -> System.out.print(entry.getValue().stream().collect(Collectors.joining(" ! ")) + " ! "));

        System.out.println("\n\nList of movies - one line version 2:");
        final String moviesAll = movieMap.entrySet()
                .stream()
                .flatMap(movie -> movie.getValue().stream())
                .collect(Collectors.joining(" ! "));
        System.out.println(moviesAll);

        System.out.println("\nList of movies - one line version 3:");
        final String moviesAllKey = movieMap.entrySet()
                .stream()
                .flatMap(all -> {
                    List<String> list = new ArrayList<>();
                    list.add(all.getKey());
                    list.addAll(all.getValue());
                    return list.stream();
                })
                .collect((Collectors.joining(" ! ")));
        System.out.println(moviesAllKey);
    }
}
