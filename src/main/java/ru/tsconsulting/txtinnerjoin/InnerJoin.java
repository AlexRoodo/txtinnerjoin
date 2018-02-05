package ru.tsconsulting.txtinnerjoin;

import ru.tsconsulting.txtinnerjoin.logic.JoinTables;
import ru.tsconsulting.txtinnerjoin.objects.TableRow;
import ru.tsconsulting.txtinnerjoin.reading.TxtReading;
import ru.tsconsulting.txtinnerjoin.writing.TxtWriting;

import java.nio.file.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class InnerJoin {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Необходимо передать программе 2 аргумента - путь к исходному " +
                    "файлу и имя второго файла");
            System.exit(1);
        }

        Path firstFilePath = Paths.get(args[0]);
        Path secondFilePath = Paths.get(firstFilePath.getParent() + "\\" + args[1]);

        if (firstFilePath.toFile().exists() && secondFilePath.toFile().exists()) {

            TxtReading txtReading = new TxtReading();
            LinkedList<TableRow> firstLinkedList = new LinkedList<>();
            txtReading.readFromTxt(firstFilePath.toString(), firstLinkedList);
            LinkedList<TableRow> secondLinkedList = new LinkedList<>();
            txtReading.readFromTxt(secondFilePath.toString(), secondLinkedList);

            ArrayList<TableRow> firstArrayList = new ArrayList<>();
            txtReading.readFromTxt(firstFilePath.toString(), firstArrayList);
            ArrayList<TableRow> secondArrayList = new ArrayList<>();
            txtReading.readFromTxt(secondFilePath.toString(), secondArrayList);

            firstLinkedList.sort(TableRow::compareTo);
            secondLinkedList.sort(TableRow::compareTo);

            JoinTables joinTables = new JoinTables();
            LinkedList<TableRow> resultJoinList = joinTables.joinTables(firstArrayList,
                    secondArrayList);
            LinkedList<TableRow> resultMergeJoin = joinTables.mergeJoinTables(firstLinkedList,
            secondLinkedList);

            firstLinkedList = new LinkedList<>();
            txtReading.readFromTxt(firstFilePath.toString(), firstLinkedList);
            secondLinkedList = new LinkedList<>();
            txtReading.readFromTxt(secondFilePath.toString(), secondLinkedList);

            LinkedList<TableRow> resultHashJoinTables = joinTables.hashJoinTables(firstLinkedList,
                    secondLinkedList);

            TxtWriting txtWriting = new TxtWriting();
            Path resultJoinPath = Paths.get(firstFilePath.getParent().toString(),
                    "ResultJoin.txt");
            txtWriting.writeToTxt(resultJoinPath.toString(), resultJoinList);

            Path resultMergeJoinPath = Paths.get(firstFilePath.getParent().toString(),
                    "ResultMergeJoin.txt");
            txtWriting.writeToTxt(resultMergeJoinPath.toString(), resultMergeJoin);
            Path resultHashJoinPath = Paths.get(firstFilePath.getParent().toString(),
                    "ResultHashJoin.txt");
            txtWriting.writeToTxt(resultHashJoinPath.toString(), resultHashJoinTables);
        } else {
            System.out.println("Программе переданы неверные аргументы.");
            System.exit(1);
        }
    }
}
