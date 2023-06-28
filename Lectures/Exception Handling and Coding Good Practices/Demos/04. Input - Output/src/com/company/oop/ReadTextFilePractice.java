package com.company.oop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadTextFilePractice {
    public static void main(String[] args) throws IOException {
        try (FileWriter writer = new FileWriter("file.txt")) {
            writer.write("Hello world!\n");
            writer.write("I am writing to a text file :)\n");
            writer.flush();
        }

        try (
                FileReader reader = new FileReader("file.txt");
                BufferedReader bufferedReader = new BufferedReader(reader);
        ) {
            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                System.out.println(line);
            }
        }
    }
}
