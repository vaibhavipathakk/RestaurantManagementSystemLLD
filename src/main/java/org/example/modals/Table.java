package org.example.modals;

public class Table {
    private final int id;
    private boolean isAvailable;

    public Table(int id, boolean isAvailable) {
        this.id = id;
        this.isAvailable = true;
    }

    public int getId() {
        return id;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

}
