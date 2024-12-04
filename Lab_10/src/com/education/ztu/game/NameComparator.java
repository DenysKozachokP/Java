package com.education.ztu.game;

import java.util.Comparator;

public class NameComparator implements Comparator<Participant> {
    @Override
    public int compare(Participant p1, Participant p2) {
        int nameComparison = p1.getName().compareTo(p2.getName());
        if (nameComparison != 0) {
            return nameComparison;
        }
        return Integer.compare(p1.getAge(), p2.getAge());
    }
}