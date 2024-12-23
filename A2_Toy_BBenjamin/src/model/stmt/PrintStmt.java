package model.stmt;

import model.adt.*;
import model.MyException;
import model.PrgState;
import model.exp.Exp;
import model.value.Value;
public class PrintStmt implements IStmt{
    Exp exp;
    public PrintStmt(Exp v){exp=v;}
    public Exp getExp() {return exp;}
    public void setExp(Exp exp) {this.exp = exp;}
    public String toString(){ return "print(" + exp.toString() + ")";}

    @Override
    public PrgState execute(PrgState state) throws MyException {
        MyIStack<IStmt> stk = state.getExeStack();
        MyIList<Value> out = state.getOut();
        MyIDictionary<String, Value> symTable = state.getSymTable();
        out.add(exp.eval(symTable));
        return state;
    }


}
