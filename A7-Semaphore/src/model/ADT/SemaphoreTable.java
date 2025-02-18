package model.utils;

import model.ADT.ISemaphoreTable;
import model.MyException;
import model.ADT.Tuple;

import java.util.HashMap;
import java.util.List;

public class SemaphoreTable implements ISemaphoreTable {
    private HashMap<Integer, Tuple<Integer, List<Integer>, Integer>> toySemaphoreTable;
    private int freeLocation = 0;

    public SemaphoreTable() {
        this.toySemaphoreTable = new HashMap<>();
    }

    @Override
    public void put(int key, Tuple<Integer, List<Integer>, Integer> value) throws MyException {
        synchronized (this) {
            if (!toySemaphoreTable.containsKey(key)) {
                toySemaphoreTable.put(key, value);
            } else {
                throw new MyException(String.format("Toy semaphore table already contains the key %d!", key));
            }
        }
    }

    @Override
    public Tuple<Integer, List<Integer>, Integer> get(int key) throws MyException {
        synchronized (this) {
            if (toySemaphoreTable.containsKey(key)) {
                return toySemaphoreTable.get(key);
            } else {
                throw new MyException(String.format("Toy semaphore table doesn't contain the key %d!", key));
            }
        }
    }

    @Override
    public boolean containsKey(int key) {
        synchronized (this) {
            return toySemaphoreTable.containsKey(key);
        }
    }

    @Override
    public int getFreeAddress() {
        synchronized (this) {
            freeLocation++;
            return freeLocation;
        }
    }

    @Override
    public void setFreeAddress(int freeAddress) {
        synchronized (this) {
            this.freeLocation = freeAddress;
        }
    }

    @Override
    public void update(int key, Tuple<Integer, List<Integer>, Integer> value) throws MyException {
        synchronized (this) {
            if (toySemaphoreTable.containsKey(key)) {
                toySemaphoreTable.replace(key, value);
            } else {
                throw new MyException(String.format("Toy semaphore table doesn't contain key %d!", key));
            }
        }
    }

    @Override
    public HashMap<Integer, Tuple<Integer, List<Integer>, Integer>> getToySemaphoreTable() {
        synchronized (this) {
            return toySemaphoreTable;
        }
    }

    @Override
    public void setToySemaphoreTable(HashMap<Integer, Tuple<Integer, List<Integer>, Integer>> newToySemaphoreTable) {
        synchronized (this) {
            this.toySemaphoreTable = newToySemaphoreTable;
        }
    }

    @Override
    public String toString() {
        return toySemaphoreTable.toString();
    }
}