package ru.tsconsulting.txtinnerjoin;

import ru.tsconsulting.txtinnerjoin.logic.JoinTables;
import ru.tsconsulting.txtinnerjoin.objects.TableRow;
import ru.tsconsulting.txtinnerjoin.reading.TxtReading;
import ru.tsconsulting.txtinnerjoin.writing.TxtWriting;

import java.nio.file.*;
import java.util.ArrayList;

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
            ArrayList<TableRow> firstArrayList = new ArrayList<>();
            txtReading.readFromTxt(firstFilePath.toString(), firstArrayList);
            ArrayList<TableRow> secondArrayList = new ArrayList<>();
            txtReading.readFromTxt(secondFilePath.toString(), secondArrayList);

            JoinTables joinTables = new JoinTables();
            ArrayList<TableRow> arrayList = joinTables.joinTables(firstArrayList, secondArrayList);

            TxtWriting txtWriting = new TxtWriting();
            Path resultPath = Paths.get(firstFilePath.getParent().toString(), "Result.txt");
            txtWriting.writeToTxt(resultPath.toString(), arrayList);

        } else {
            System.out.println("Программе переданы неверные аргументы.");
            System.exit(1);
        }
    }
}
