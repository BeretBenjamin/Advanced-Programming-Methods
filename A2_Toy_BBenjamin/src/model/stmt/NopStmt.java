package model.stmt;

import model.adt.*;
import model.MyException;
import model.PrgState;
public class NopStmt implements IStmt{
    public NopStmt(){}
    @Override
    public PrgState execute(PrgState state) throws MyException {
        return null;
    }

}
