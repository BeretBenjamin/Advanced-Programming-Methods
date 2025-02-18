package model;

import model.adt.*;
import model.stmt.IStmt;
import model.value.Value;

public class PrgState {
    MyIStack<IStmt> exeStack;
    MyIDictionary<String, Value> symTable;
    MyIList<Value> out;
    IStmt originalProgram; //optional field, but good to have
    public PrgState(MyIStack<IStmt> stk, MyIDictionary<String, Value> symtbl, MyIList<Value> ot, IStmt prg){
        exeStack=stk;
        symTable=symtbl;
        out = ot;
        originalProgram=prg;
        stk.push(prg);
    }

    @Override
    public String toString() {
        return "PrgState{" +
                "exeStack=" + exeStack +
                ", symTable=" + symTable +
                ", out=" + out +
                '}';
    }

    public MyIStack<IStmt> getExeStack() {
        return exeStack;
    }
    public MyIDictionary<String, Value> getSymTable() {
        return symTable;
    }
    public MyIList<Value> getOut() {
        return out;
    }

    public void setExeStack(MyIStack<IStmt> exeStack) {
        this.exeStack = exeStack;
    }

    public void setSymTable(MyIDictionary<String, Value> symTable) {
        this.symTable = symTable;
    }
    public void setOut(MyIList<Value> out) {
        this.out = out;
    }
    public boolean isNotCompleted(){
        return !exeStack.isEmpty();
    }
    public PrgState oneStep() throws Exception {
        if(exeStack.isEmpty()) throw new Exception("Program state stack is empty");
        IStmt crtStmt = exeStack.pop();
        return crtStmt.execute(this);
    }
    public IStmt getOriginalProgram() {
        return originalProgram;
    }
}