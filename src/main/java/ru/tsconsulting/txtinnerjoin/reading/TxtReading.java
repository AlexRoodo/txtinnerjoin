package ru.tsconsulting.txtinnerjoin.reading;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;

public class TxtReading {
    public ArrayList<String[]> readFromTxt(String file, ArrayList<String[]> arrayList){
        try {
            List<String> linesList = Files.readAllLines(Paths.get(file), StandardCharsets.UTF_8);

            for (String s : linesList) {
                arrayList.add(s.split("\t"));
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла.");
        }
        return arrayList;
    }
}
