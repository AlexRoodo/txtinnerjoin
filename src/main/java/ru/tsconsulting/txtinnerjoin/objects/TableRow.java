package ru.tsconsulting.txtinnerjoin.objects;

public class TableRow implements Comparable<TableRow> {
    private String initValue = "";
    private String addedValue = "";
    private int id = 0;

    public String getAddedValue() {
        return addedValue;
    }

    public void setAddedValue(String addedValue) {
        this.addedValue = addedValue;
    }

    public String getInitValue() {
        return initValue;
    }

    public void setInitValue(String initValue) {
        this.initValue = initValue;
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
}
