package com.pluralsight;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SearchEngineLogger {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            // FileWriter
            FileWriter fileWriter = new FileWriter("logs.txt");
            // BufferedWriter
            BufferedWriter bufWriter = new BufferedWriter(fileWriter);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            log(bufWriter, formatter, "launch");
            while (true) {

                System.out.print("Enter a search term: (X to exit): ");
                String answer = scanner.nextLine().trim();
                if (answer.equalsIgnoreCase("X")) {
                    System.out.println();
                    log(bufWriter, formatter, "exit");
                    break;
                } else {
                    log(bufWriter, formatter, "search : " + answer);
                }
            }
            bufWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Error writing to file");
            e.printStackTrace();
        }
    }
    public static void log(BufferedWriter _bufwriter, DateTimeFormatter _formatter, String _message) throws IOException {
        String timestamp = LocalDateTime.now().format(_formatter);
        _bufwriter.write(timestamp + " " + _message + "\n");
    }
}
