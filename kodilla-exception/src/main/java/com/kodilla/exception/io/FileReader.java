package com.kodilla.exception.io;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileReader {
    public void readFile() throws FileReaderException{
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("file/names.txt").getFile());
        /*
        // DO not use space in folder names
        //File file = new File(classLoader.getResource("E:/Full_path/names.txt").getFile());
        Path path = Paths.get(file.getPath());

        // Test IOException
        // Path path = Paths.get("file/names.txt");

        try {
            Stream<String> fileLines = Files.lines(path);
            fileLines.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Oh no! Something went wrong! Error: " + e );
        } finally {
            System.out.println("I am gonna be here... always!");
        }

        */

        try (Stream<String> fileLines = Files.lines(Paths.get(file.getPath()))){
            fileLines.forEach(System.out::println);
        } catch (IOException e) {
            throw new FileReaderException();
        } finally {
            System.out.println("I am gonna be here... always!");
        }

        System.out.println(file.getPath());

    }
}
