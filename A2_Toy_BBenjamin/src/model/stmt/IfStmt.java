package model.stmt;

import model.adt.*;
import model.MyException;
import model.PrgState;
import model.exp.Exp;
import model.type.BoolType;
import model.value.BoolValue;
import model.value.Value;
public class IfStmt implements IStmt{
    private Exp exp;
    IStmt thenS;
    IStmt elseS;

    public IfStmt(Exp exp,IStmt t, IStmt e)
    {
        this.exp = exp;
        this.thenS = t;
        this.elseS = e;
    }
    public Exp getExp() {
        return exp;
    }

    public void setExp(Exp exp) {
        this.exp = exp;
    }

    public IStmt getThenS() {
        return thenS;
    }

    public void setThenS(IStmt thenS) {
        this.thenS = thenS;
    }

    public IStmt getElseS() {
        return elseS;
    }

    public void setElseS(IStmt elseS) {
        this.elseS = elseS;
    }
    public String toString(){
        return "(IF("+ exp.toString()+") THEN(" +thenS.toString()
                +")ELSE("+elseS.toString()+"))";}

    @Override
    public PrgState execute(PrgState state) throws MyException {
        MyIStack<IStmt> stk = state.getExeStack();
        MyIDictionary<String, Value> symTable = state.getSymTable();
        Value val = exp.eval(symTable);
        if(!val.getType().equals(new BoolType()))
            throw new MyException("Conditional expression is not a boolean");
        else{
            BoolValue boolVal = (BoolValue) val;
            if(boolVal.getValue())
                stk.push(thenS);
            else
                stk.push(elseS);
        }
        return state;
    }


}

