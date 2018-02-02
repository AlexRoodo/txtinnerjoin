package ru.tsconsulting.txtinnerjoin.objects;

import java.util.ArrayList;

public class TableRow implements Comparable<TableRow> {
    private ArrayList<String> values = null;
    private int id = 0;
    private StringBuilder stringBuilder = null;

    public ArrayList<String> getValues() {
        if (values == null) {
            values = new ArrayList<>();
        }
        return values;
    }

    public void setValues(String s) {
        getValues().add(s);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int compareTo(TableRow o) {
        return this.getId() - o.getId();
    }

    @Override
    public String toString() {
        stringBuilder = new StringBuilder("");
        stringBuilder.append(getId()).append("\t");
        for (String s :
                getValues()) {
            stringBuilder.append(s).append("\t");
        }
        return stringBuilder.toString();
    }
}
