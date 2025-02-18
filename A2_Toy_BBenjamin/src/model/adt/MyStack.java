package model.adt;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
public class MyStack<T> implements MyIStack<T>{
    private Stack<T> stack;
    public MyStack(){
        stack = new Stack<>();
    }
    public MyStack(Stack<T> stack)
    {
        this.stack = stack;
    }
    public Stack<T> getStack()
    {
        return stack;
    }
    public void setStack(Stack<T> stack)
    {
        this.stack = stack;
    }
    public String toString()
    {
        return "MyStack{" + "stack=" + stack + "}";
    }

    @Override
    public T pop() {
        return this.stack.pop();
    }

    @Override
    public void push(T v) {
        this.stack.push(v);
    }

    @Override
    public boolean isEmpty() {
        return this.stack.empty();
    }

    @Override
    public List<T> getReverese() {
        List<T> list = Arrays.asList((T[])this.stack.toArray());
        Collections.reverse(list);
        return list;
    }
}
