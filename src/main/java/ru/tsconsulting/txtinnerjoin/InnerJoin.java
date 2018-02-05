package ru.tsconsulting.txtinnerjoin;

import ru.tsconsulting.txtinnerjoin.logic.JoinTables;
import ru.tsconsulting.txtinnerjoin.objects.TableRow;
import ru.tsconsulting.txtinnerjoin.reading.TxtReading;
import ru.tsconsulting.txtinnerjoin.writing.TxtWriting;

import java.nio.file.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class InnerJoin {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Необходимо передать программе 2 аргумента - путь к исходному " +
                    "файлу и имя второго файла в том же каталоге");
            System.exit(1);
        }

        Path firstFilePath = Paths.get(args[0]);
        Path secondFilePath = Paths.get(firstFilePath.getParent() + "\\" + args[1]);

        if (firstFilePath.toFile().exists() && secondFilePath.toFile().exists()) {

            TxtReading txtReading = new TxtReading();
            LinkedList<TableRow> firstArrayList = new LinkedList<>();
            txtReading.readFromTxt(firstFilePath.toString(), firstArrayList);
            LinkedList<TableRow> secondArrayList = new LinkedList<>();
            txtReading.readFromTxt(secondFilePath.toString(), secondArrayList);

            firstArrayList.sort(TableRow::compareTo);
            secondArrayList.sort(TableRow::compareTo);

            JoinTables joinTables = new JoinTables();
            LinkedList<TableRow> resultArrayList = joinTables.joinTables(firstArrayList,
            secondArrayList);

            TxtWriting txtWriting = new TxtWriting();
            Path resultPath = Paths.get(firstFilePath.getParent().toString(), "Result.txt");
            txtWriting.writeToTxt(resultPath.toString(), resultArrayList);
        } else {
            System.out.println("Программе переданы неверные аргументы.");
            System.exit(1);
        }
    }
}
