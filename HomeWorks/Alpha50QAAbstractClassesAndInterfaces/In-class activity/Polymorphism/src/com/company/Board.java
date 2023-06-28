package com.company;

import com.company.contracts.Logger;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private final List<BoardItem> items;

    public Board() {
        items = new ArrayList<>();
    }

    public void addItem(BoardItem item) {
        if (items.contains(item)) {
            throw new IllegalArgumentException("Item already in the list");
        }

        items.add(item);
    }

    public int totalItems() {
        return items.size();
    }

    public void displayHistory(Logger logger) {
        for (BoardItem item : items) {
            logger.log(item.getHistory());
        }
    }
}
