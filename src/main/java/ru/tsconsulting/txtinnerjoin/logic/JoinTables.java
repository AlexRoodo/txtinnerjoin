package ru.tsconsulting.txtinnerjoin.logic;

import ru.tsconsulting.txtinnerjoin.objects.TableRow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class JoinTables {
    public LinkedList<TableRow> joinTables (ArrayList<TableRow> leftArrayList,
                                          ArrayList<TableRow> rightArrayList) {
        LinkedList<TableRow> resultArrayList = new LinkedList<>();

        for (TableRow tr1 : leftArrayList) {
            for (TableRow tr2: rightArrayList) {
                if (tr1.compareTo(tr2) == 0) {
                    TableRow tableRow = new TableRow();
                    tableRow.setId(tr1.getId());
                    tableRow.setInitValue(tr1.getInitValue());
                    tableRow.setSecondValue(tr2.getInitValue());
                    resultArrayList.add(tableRow);
                }
            }
        }

        return resultArrayList;
    }

    public LinkedList<TableRow> mergeJoinTables (LinkedList<TableRow> leftLinkedList,
                                                LinkedList<TableRow> rightLinkedList) {

        LinkedList<TableRow> resultLinkedList = new LinkedList<>();
        LinkedList<TableRow> tempLinkedList = new LinkedList<>();
        Iterator<TableRow> leftIterator = leftLinkedList.listIterator();
        Iterator<TableRow> rightIterator = rightLinkedList.listIterator();
        TableRow leftCurrentRow = leftIterator.next();
        TableRow rightCurrentRow = rightIterator.next();
        TableRow leftNextRow;
        TableRow rightNextRow;


        while (true) {
            if (leftCurrentRow.compareTo(rightCurrentRow) < 0) {
                if (leftIterator.hasNext()) {
                    leftCurrentRow = leftIterator.next();
                } else {
                    break;
                }
            } else if (leftCurrentRow.compareTo(rightCurrentRow) > 0) {
                if (rightIterator.hasNext()) {
                    rightCurrentRow = rightIterator.next();
                } else {
                    break;
                }
            } else {
                tempLinkedList.add(rightCurrentRow);
                if (!rightIterator.hasNext() || !leftIterator.hasNext()) {
                    addToResList(resultLinkedList, tempLinkedList, leftCurrentRow);
                    return resultLinkedList;
                }
                rightNextRow = rightIterator.next();
                while (rightNextRow.getId() == rightCurrentRow.getId() && rightIterator.hasNext()) {
                    tempLinkedList.add(rightNextRow);
                    rightNextRow = rightIterator.next();
                }
                addToResList(resultLinkedList, tempLinkedList, leftCurrentRow);
                leftNextRow = leftIterator.next();
                while (leftNextRow.getId() == rightCurrentRow.getId() && leftIterator.hasNext()) {
                    addToResList(resultLinkedList, tempLinkedList, leftNextRow);
                    leftNextRow = leftIterator.next();
                }
                rightCurrentRow = rightNextRow;
                leftCurrentRow = leftNextRow;
                tempLinkedList.clear();
            }
        }
        return resultLinkedList;
    }

    private void addToResList (LinkedList<TableRow> resultLinkedList,
                               LinkedList<TableRow> tempLinkedList, TableRow leftCurrentRow) {
        TableRow tableRow;
        for (TableRow tr : tempLinkedList) {
            tableRow = new TableRow();
            tableRow.setId(leftCurrentRow.getId());
            tableRow.setInitValue(leftCurrentRow.getInitValue());
            tableRow.setSecondValue(tr.getInitValue());
            resultLinkedList.add(tableRow);
        }
    }

    public LinkedList<TableRow> hashJoinTables (LinkedList<TableRow> leftLinkedList,
                                           LinkedList<TableRow> rightLinkedList) {

        HashMap<Integer, LinkedList<String>> resultHashMap = new HashMap<>();
        LinkedList<TableRow> initialList;
        LinkedList<TableRow> verifiableList;
        LinkedList<TableRow> resultLinkedList = new LinkedList<>();

        if (leftLinkedList.size() < rightLinkedList.size()) {
            initialList = leftLinkedList;
            verifiableList = rightLinkedList;
        } else {
            initialList = rightLinkedList;
            verifiableList = leftLinkedList;
        }

        for (TableRow currentTableRow : initialList) {
            if (resultHashMap.containsKey(currentTableRow.getId())) {
                resultHashMap.get(currentTableRow.getId()).add(currentTableRow.getInitValue());
            } else {
                resultHashMap.put(currentTableRow.getId(), new LinkedList<>());
                resultHashMap.get(currentTableRow.getId()).add(currentTableRow.getInitValue());
            }
        }

        for (TableRow actualTableRow : verifiableList) {
            if (resultHashMap.containsKey(actualTableRow.getId())) {
                for (String s : resultHashMap.get(actualTableRow.getId())) {
                    TableRow tableRow = new TableRow();
                    tableRow.setId(actualTableRow.getId());
                    tableRow.setInitValue(actualTableRow.getInitValue());
                    tableRow.setSecondValue(s);
                    resultLinkedList.add(tableRow);
                }
            }
        }

        return resultLinkedList;
    }
}
