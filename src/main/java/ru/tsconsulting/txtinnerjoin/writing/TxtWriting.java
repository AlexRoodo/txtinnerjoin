package ru.tsconsulting.txtinnerjoin.writing;

import ru.tsconsulting.txtinnerjoin.objects.TableRow;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class TxtWriting {
    public void writeToTxt(String file, ArrayList<TableRow> resultArrayList) {
        ArrayList<String> arrayList = new ArrayList<>();

        for (TableRow tr : resultArrayList) {
            String s = String.format("%-4d%-20s%-20s", tr.getId(), tr.getInitValue(), tr.getAddedValue());
            arrayList.add(s);
        }
        try {
            Files.write(Paths.get(file), arrayList, StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл.");
        }
    }
}
