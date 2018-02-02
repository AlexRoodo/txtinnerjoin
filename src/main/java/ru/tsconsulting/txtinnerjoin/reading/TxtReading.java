package ru.tsconsulting.txtinnerjoin.reading;

import ru.tsconsulting.txtinnerjoin.objects.TableRow;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;

public class TxtReading {
    public void readFromTxt(String file, List<TableRow> list){
        try {
            List<String> linesList = Files.readAllLines(Paths.get(file), StandardCharsets.UTF_8);

            for (String s : linesList) {
                String[] strings = s.split("\t");
                TableRow tableRow = new TableRow();
                if (strings[0].matches(".*ID$")) {
                    continue;
                }
                tableRow.setId(Integer.parseInt(strings[0]));
                tableRow.getValues().add(strings[1]);
                list.add(tableRow);
            }

        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла.");
        }
    }
}
