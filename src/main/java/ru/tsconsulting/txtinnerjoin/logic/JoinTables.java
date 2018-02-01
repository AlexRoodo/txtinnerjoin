package ru.tsconsulting.txtinnerjoin.logic;

import java.util.ArrayList;

public class JoinTables {
    public ArrayList<String[]> joinTables(ArrayList<String[]> firstArrayList,
                                        ArrayList<String[]> secondArrayList) {
        ArrayList<String[]> resultArrayList = new ArrayList<>();

        for (String[] s1 : firstArrayList) {
            for (String[] s2: secondArrayList) {
                if (s1[0].equalsIgnoreCase(s2[0])) {
                    String[] array = {s1[0], s1[1], s2[1]};
                    resultArrayList.add(array);
                }
            }
        }

        return resultArrayList;
    }
}
