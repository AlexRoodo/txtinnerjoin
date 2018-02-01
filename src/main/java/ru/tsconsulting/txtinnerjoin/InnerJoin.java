package ru.tsconsulting.txtinnerjoin;

import ru.tsconsulting.txtinnerjoin.logic.JoinTables;
import ru.tsconsulting.txtinnerjoin.reading.TxtReading;
import ru.tsconsulting.txtinnerjoin.writing.TxtWriting;

import java.util.ArrayList;

public class InnerJoin {
    public static void main(String[] args) {
        TxtReading txtReading = new TxtReading();
        ArrayList<String[]> firstArrayList = new ArrayList<>();
        txtReading.readFromTxt("C:\\Users\\aturchenkov\\IdeaProjects\\txtinnerjoin\\src\\main" +
                "\\resources\\SourceTable1.txt", firstArrayList);
        ArrayList<String[]> secondArrayList = new ArrayList<>();
        txtReading.readFromTxt("C:\\Users\\aturchenkov\\IdeaProjects\\txtinnerjoin\\src\\main" +
                "\\resources\\SourceTable2.txt", secondArrayList);

        JoinTables joinTables = new JoinTables();
        ArrayList<String[]> arrayList = joinTables.joinTables(firstArrayList, secondArrayList);

        TxtWriting txtWriting = new TxtWriting();
        txtWriting.writeToTxt("C:\\Users\\aturchenkov\\IdeaProjects\\txtinnerjoin\\src\\main" +
        "\\resources\\result.txt", arrayList);

    }
}
