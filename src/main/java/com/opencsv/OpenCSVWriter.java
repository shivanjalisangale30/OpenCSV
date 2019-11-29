package com.opencsv;

import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class OpenCSVWriter {
    private static final String OBJECT_LIST_SAMPLE = "/home/admin1/Desktop/OpenCSV/src/main/resources/user.json";

    public static void main(String[] args) throws IOException {
        try (
                Writer writer = Files.newBufferedWriter(Paths.get(OBJECT_LIST_SAMPLE));

                CSVWriter csvWriter = new CSVWriter(writer,
                        CSVWriter.DEFAULT_SEPARATOR,
                        CSVWriter.NO_QUOTE_CHARACTER,
                        CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                        CSVWriter.DEFAULT_LINE_END);
        ) {
            String[] headerRecord = {"Name", "Email", "Phone", "Country"};
            csvWriter.writeNext(headerRecord);

            csvWriter.writeNext(new String[]{"Sundar Pichai ♥", "sundar.pichai@gmail.com", "+1-1111111111", "India"});
            csvWriter.writeNext(new String[]{"Satya Nadella", "satya.nadella@outlook.com", "+1-1111111112", "India"});
        }
    }
}
