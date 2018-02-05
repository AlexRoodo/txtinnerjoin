package ru.tsconsulting.txtinnerjoin.writing;

import ru.tsconsulting.txtinnerjoin.objects.TableRow;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

public class TxtWriting {
    public void writeToTxt(String file, List<TableRow> resultArrayList) {
        LinkedList<String> linkedList = new LinkedList<>();


        for (TableRow tr : resultArrayList) {
            linkedList.add(tr.toString());
        }
        linkedList.addFirst(String.format("%-5s%-15s%-15s", "ID", "A.Table", "B.Table"));
        try {
            Files.write(Paths.get(file), linkedList, StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл.");
        }
    }
}
