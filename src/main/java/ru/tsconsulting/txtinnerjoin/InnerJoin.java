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
            /*ArrayList<TableRow> firstArrayList = new ArrayList<>();
            txtReading.readFromTxt(firstFilePath.toString(), firstArrayList);
            ArrayList<TableRow> secondArrayList = new ArrayList<>();
            txtReading.readFromTxt(secondFilePath.toString(), secondArrayList);*/
            /*LinkedList<TableRow> firstLinkedList = new LinkedList<>();
            txtReading.readFromTxt(firstFilePath.toString(), firstLinkedList);
            LinkedList<TableRow> secondLinkedList = new LinkedList<>();
            txtReading.readFromTxt(secondFilePath.toString(), secondLinkedList);

            firstLinkedList.sort(TableRow::compareTo);
            secondLinkedList.sort(TableRow::compareTo);*/
            HashMap<Integer, TableRow> firstHashMap = new HashMap<>();
            txtReading.readFromTxt(firstFilePath.toString(), firstHashMap);
            HashMap<Integer, TableRow> secondHashMap = new HashMap<>();
            txtReading.readFromTxt(secondFilePath.toString(), secondHashMap);

            JoinTables joinTables = new JoinTables();
            /*ArrayList<TableRow> resultArrayList = joinTables.joinTables(firstArrayList,
            secondArrayList);*/
            /*LinkedList<TableRow> resultLinkedList = joinTables.joinTables(firstLinkedList,
            secondLinkedList);
            resultLinkedList.forEach(System.out::println);*/
            HashMap<Integer, TableRow> resultHashMap = joinTables.joinTables(firstHashMap,
            secondHashMap);


            TxtWriting txtWriting = new TxtWriting();
            Path resultPath = Paths.get(firstFilePath.getParent().toString(), "Result.txt");
            /*txtWriting.writeToTxt(resultPath.toString(), resultArrayList);*/
            LinkedList<TableRow> resultLinkedList = new LinkedList<>(resultHashMap.values());
            txtWriting.writeToTxt(resultPath.toString(), resultLinkedList);


        } else {
            System.out.println("Программе переданы неверные аргументы.");
            System.exit(1);
        }
    }
}
