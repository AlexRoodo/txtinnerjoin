package ru.tsconsulting.txtinnerjoin.logic;

import ru.tsconsulting.txtinnerjoin.objects.TableRow;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class JoinTables {
    public ArrayList<TableRow> joinTables(ArrayList<TableRow> firstArrayList,
                                          ArrayList<TableRow> secondArrayList) {
        ArrayList<TableRow> resultArrayList = new ArrayList<>();

        for (TableRow tr1 : firstArrayList) {
            for (TableRow tr2: secondArrayList) {
                if (tr1.compareTo(tr2) == 0) {
                    TableRow tableRow = new TableRow();
                    tableRow.setId(tr1.getId());
                    tableRow.setInitValue(tr1.getInitValue());
                    tableRow.setAddedValue(tr2.getInitValue());
                    resultArrayList.add(tableRow);
                }
            }
        }

        return resultArrayList;
    }

    public LinkedList<TableRow> joinTables(LinkedList<TableRow> firstLinkedList,
                                                LinkedList<TableRow> secondLinkedList) {

        LinkedList<TableRow> resultLinkedList = new LinkedList<>();
        Iterator<TableRow> firstIterrator = firstLinkedList.listIterator();
        Iterator<TableRow> secondIterrator = secondLinkedList.listIterator();
        TableRow firstRow = firstIterrator.next();
        TableRow secondRow = secondIterrator.next();

        while (true) {
            if (firstRow.compareTo(secondRow) < 0) {
                if (firstIterrator.hasNext()) {
                    firstRow = firstIterrator.next();
                } else {
                    break;
                }
            } else if (firstRow.compareTo(secondRow) > 0) {
                if (secondIterrator.hasNext()) {
                    secondRow = secondIterrator.next();
                } else {
                    break;
                }
            } else {
                TableRow tableRow = new TableRow();
                tableRow.setId(firstRow.getId());
                tableRow.setInitValue(firstRow.getInitValue());
                tableRow.setAddedValue(secondRow.getInitValue());
                resultLinkedList.add(tableRow);
                if (firstIterrator.hasNext() && secondIterrator.hasNext()) {
                    firstRow = firstIterrator.next();
                    secondRow = secondIterrator.next();
                } else {
                    break;
                }
            }
        }
        return resultLinkedList;
    }


}
