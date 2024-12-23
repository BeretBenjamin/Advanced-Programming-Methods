package model.ADT;

import model.ADT.Tuple;
import model.MyException;

import java.util.HashMap;
import java.util.List;

public interface ISemaphoreTable {
    void put(int key, Tuple<Integer, List<Integer>, Integer> value) throws MyException;
    model.ADT.Tuple<Integer, List<Integer>, Integer> get(int key) throws MyException;
    boolean containsKey(int key);
    int getFreeAddress();
    void setFreeAddress(int freeAddress);
    void update(int key, Tuple<Integer, List<Integer>, Integer> value) throws MyException;
    HashMap<Integer, Tuple<Integer, List<Integer>, Integer>> getToySemaphoreTable();
    void setToySemaphoreTable(HashMap<Integer, Tuple<Integer, List<Integer>, Integer>> newToySemaphoreTable);
}