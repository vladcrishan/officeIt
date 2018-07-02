package com.vlad.officeIt.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileHelper {
    public static final String COMMA_DELIMITER = ",";

    private FileHelper() throws IllegalAccessException {
        throw new IllegalAccessException("You cannot instantiate");
    }

    public static List<String> read(String filePath) throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        }
        return lines;
    }

    public static void write(String filePath, String value) throws IOException {
        try (FileWriter fileWriter = new FileWriter(filePath, true)) {
            fileWriter.append(value);
        }
    }
}
