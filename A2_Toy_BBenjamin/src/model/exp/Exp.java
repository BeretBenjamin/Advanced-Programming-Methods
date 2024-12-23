package model.exp;
import model.adt.MyIDictionary;
import model.MyException;
import model.type.Type;
import model.value.Value;

public interface Exp {
    Value eval(MyIDictionary<String,Value> tbl) throws MyException;
}