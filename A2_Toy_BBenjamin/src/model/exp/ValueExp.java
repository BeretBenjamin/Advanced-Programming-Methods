package model.exp;

import model.adt.MyIDictionary;
import model.MyException;
import model.type.Type;
import model.value.Value;

public class ValueExp implements Exp{
    private Value e;
    public ValueExp(Value e){
        this.e = e;
    }
    public Value getE(){
        return this.e;
    }
    public void setE(Value e){
        this.e = e;
    }
    @Override
    public String toString()
    {
        return "ValueExp{"+
                "e="+e+
                '}';
    }

    @Override
    public Value eval(MyIDictionary<String, Value> tbl) throws MyException {
        return e;
    }

}