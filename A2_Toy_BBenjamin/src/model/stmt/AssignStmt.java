package model.stmt;

import model.adt.*;
import model.MyException;
import model.PrgState;
import model.exp.Exp;
import model.type.Type;
import model.value.Value;
public class AssignStmt implements IStmt{
    private Exp exp;
    private String id;
    public AssignStmt(String id, Exp exp){
        this.exp = exp;
        this.id = id;
    }
    public Exp getExp() {
        return exp;
    }
    public String getId() {
        return id;
    }
    public void setExp(Exp exp) {
        this.exp = exp;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String toString(){
        return id + "=" + exp.toString();
    }

    @Override
    public PrgState execute(PrgState state) throws MyException {
        MyIStack<IStmt> stk = state.getExeStack();
        MyIDictionary<String, Value> symTable = state.getSymTable();
        if(symTable.isDefined(id)){
            Value val = exp.eval(symTable);
            Type typId = (symTable.lookup(id)).getType();
            if(val.getType().equals(typId))
                symTable.update(id, val);
            else
                throw new MyException("declared type of variable" + id + " and type of the assigned expression do not match");
        }
        else
            throw new MyException("the used variable" + id + " was not declared before");
        return state;
    }

}
