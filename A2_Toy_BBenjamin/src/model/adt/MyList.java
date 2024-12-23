package model.adt;

import java.util.ArrayList;
import java.util.List;
public class MyList<V> implements MyIList<V>{
    private List<V> list;
    public MyList(){
        list = new ArrayList<V>();
    }
    public MyList(List<V> list){
        this.list = list;
    }
    public List<V> getList(){
        return list;
    }
    public void setList(List<V> list){
        this.list = list;
    }
    public String toString(){
        return
                "MyList{" +
                "list=" + list +
                '}';
    }
    @Override
    public void add(V value){
        list.add(value);
    }
    @Override
    public void clear(){
        list.clear();
    }
}
