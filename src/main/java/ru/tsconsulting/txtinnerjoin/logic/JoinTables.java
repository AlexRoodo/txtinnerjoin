package ru.tsconsulting.txtinnerjoin.logic;

import ru.tsconsulting.txtinnerjoin.objects.TableRow;

import java.util.ArrayList;

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
}
