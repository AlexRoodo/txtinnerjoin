package ru.tsconsulting.txtinnerjoin.writing;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class TxtWriting {
    public void writeToTxt(String file, ArrayList<String[]> resultArrayList) {
        ArrayList<String> arrayList = new ArrayList<>();

        for (String[] strings : resultArrayList) {
            String s = String.format("%-4s %-20s%-20s", strings[0], strings[1], strings[2]);
            arrayList.add(s);
        }
        try {
            Files.write(Paths.get(file), arrayList, StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл.");
        }
    }
}
