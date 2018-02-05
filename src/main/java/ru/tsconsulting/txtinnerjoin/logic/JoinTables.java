package ru.tsconsulting.txtinnerjoin.logic;

import ru.tsconsulting.txtinnerjoin.objects.TableRow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class JoinTables {
    /*public LinkedList<TableRow> joinTables(ArrayList<TableRow> leftArrayList,
                                          ArrayList<TableRow> rightArrayList) {
        LinkedList<TableRow> resultArrayList = new LinkedList<>();

        for (TableRow tr1 : leftArrayList) {
            for (TableRow tr2: rightArrayList) {
                if (tr1.compareTo(tr2) == 0) {
                    TableRow tableRow = new TableRow();
                    tableRow.setId(tr1.getId());
                    tableRow.setValues(tr1.getValues().get(0));
                    tableRow.setValues(tr2.getValues().get(0));
                    resultArrayList.add(tableRow);
                }
            }
        }

        return resultArrayList;
    }*/

    public LinkedList<TableRow> joinTables(LinkedList<TableRow> leftLinkedList,
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
            tableRow.getValues().add(leftCurrentRow.getValues().get(0));
            tableRow.getValues().add(tr.getValues().get(0));
            resultLinkedList.add(tableRow);
        }
    }

    /*public HashMap<Integer, TableRow> joinTables(HashMap<Integer, TableRow> firstHashMap,
                                                 HashMap<Integer, TableRow> secondHashMap) {

        HashMap<Integer, TableRow> resultHashMap;
        if (firstHashMap.keySet().size() < secondHashMap.keySet().size()) {
            resultHashMap = new HashMap<>(secondHashMap);
        } else {
            resultHashMap = new HashMap<>(firstHashMap);
            firstHashMap = secondHashMap;
        }
        for (Integer i : firstHashMap.keySet()) {
            if (resultHashMap.containsKey(i)) {
                resultHashMap.get(i).setAddedValue(firstHashMap.get(i).getValues());
            }
        }
        for (Integer i : resultHashMap.keySet()) {
            if (resultHashMap.get(i).getAddedValue().equalsIgnoreCase("")) {
                resultHashMap.remove(i);
            }
        }
        resultHashMap.keySet().forEach(System.out::println);
        return resultHashMap;
    }*/
}
