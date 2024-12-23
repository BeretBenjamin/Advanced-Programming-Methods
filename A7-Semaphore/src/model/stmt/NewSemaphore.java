package model.stmt;

import model.MyException;
import model.exp.Exp;
import model.exp.Exp;
import model.PrgState;
import model.stmt.IStmt;
import model.type.IntType;
import model.type.Type;
import model.ADT.MyIDictionary;
import model.ADT.MyIHeap;
import model.ADT.ISemaphoreTable;
import model.ADT.Tuple;
import model.value.IntValue;
import model.value.Value;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class NewSemaphore implements IStmt {
    private final String var;
    private final Exp expression1;
    private final Exp expression2;
    private static final Lock lock = new ReentrantLock();

    public NewSemaphore(String var, Exp expression1, Exp expression2) {
        this.var = var;
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    @Override
    public PrgState execute(PrgState state) throws MyException {
        lock.lock();
        MyIDictionary<String, Value> symTable = state.getSymTable();
        MyIHeap heap = state.getHeap();
        ISemaphoreTable semaphoreTable = state.getSemaphoreTable();
        IntValue nr1 = (IntValue) (expression1.eval(symTable, heap));
        IntValue nr2 = (IntValue) (expression2.eval(symTable, heap));
        int number1 = nr1.getVal();
        int number2 = nr2.getVal();
        int freeAddress = semaphoreTable.getFreeAddress();
        semaphoreTable.put(freeAddress, new Tuple<>(number1, new ArrayList<>(), number2));
        if (symTable.isDefined(var) && symTable.lookup(var).getType().equals(new IntType()))
            symTable.update(var, new IntValue(freeAddress));
        else
            throw new MyException(String.format("%s in not defined in the symbol table!", var));
        lock.unlock();
        return null;
    }

    @Override
    public MyIDictionary<String, Type> typecheck(MyIDictionary<String, Type> typeEnv) throws MyException {
        return typeEnv;
    }

    @Override
    public String toString() {
        return String.format("newSemaphore(%s, %s, %s)", var, expression1, expression2);
    }
}