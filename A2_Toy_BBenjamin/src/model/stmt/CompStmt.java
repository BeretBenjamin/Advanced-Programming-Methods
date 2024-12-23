package model.stmt;

import model.adt.MyIStack;
import model.MyException;
import model.PrgState;

public class CompStmt implements IStmt{
    private IStmt first;
    private IStmt snd;
    public CompStmt(IStmt v, IStmt v2){
        first=v;
        snd=v2;
    }
    public IStmt getFirst() {
        return first;
    }
    public void setFirst(IStmt first) {
        this.first = first;
    }
    public IStmt getSnd() {
        return snd;
    }
    public void setSnd(IStmt snd) {
        this.snd = snd;
    }
    public String toString(){
        return "("+first.toString()+";"+snd.toString()+")";
    }

    @Override
    public PrgState execute(PrgState state) throws MyException {
        MyIStack<IStmt> stk=state.getExeStack();
        stk.push(snd);
        stk.push(first);
        return state;
    }

}
