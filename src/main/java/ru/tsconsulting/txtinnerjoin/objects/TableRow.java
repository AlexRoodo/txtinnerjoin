package ru.tsconsulting.txtinnerjoin.objects;

public class TableRow implements Comparable<TableRow> {
    private String initValue = null;
    private String secondValue = null;
    private int id = 0;

    public String getInitValue() {
        return initValue;
    }

    public void setInitValue(String initValue) {
        this.initValue = initValue;
    }

    public String getSecondValue() {
        return secondValue;
    }

    public void setSecondValue(String secondValue) {
        this.secondValue = secondValue;
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
        return String.format("%-4d%-20s%-20s", this.getId(), this.getInitValue(), this.getSecondValue());
    }
}
