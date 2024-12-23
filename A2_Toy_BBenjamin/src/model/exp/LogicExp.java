package model.exp;

import model.adt.MyIDictionary;
import model.MyException;
import model.value.Value;

public class LogicExp implements Exp{
    Exp e1;
    Exp e2;
    int op; // 1-and, 2-or
    public LogicExp(String stringOp, Exp e1, Exp e2){
        this.e1 = e1;
        this.e2 = e2;
        switch(stringOp){
            case "&&" -> this.op = 1;
            case "||" -> this.op = 2;
        }
    }

    public Exp getE1(){
        return this.e1;
    }
    public Exp getE2(){
        return this.e2;
    }
    public int getOp(){
        return this.op;
    }
    public void setE1(Exp e1){
        this.e1 = e1;
    }
    public void setE2(Exp e2){
        this.e2 = e2;
    }
    public void setOp(int op){
        this.op = op;
    }

    @Override
    public Value eval(MyIDictionary<String, Value> tbl) throws MyException {
        Value v1,v2;
        v1= e1.eval(tbl);
        if (v1.getType().equals(new model.type.BoolType())) {
            v2 = e2.eval(tbl);
            if (v2.getType().equals(new model.type.BoolType())) {
                model.value.BoolValue i1 = (model.value.BoolValue)v1;
                model.value.BoolValue i2 = (model.value.BoolValue)v2;
                boolean n1,n2;
                n1 = i1.getVal();
                n2 = i2.getVal();
                if (op == 1) return new model.value.BoolValue(n1 && n2);
                if (op == 2) return new model.value.BoolValue(n1 || n2);
            }
            else throw new MyException("second operand is not an integer");
        }
        else throw new MyException("first operand is not an integer");
        return null;
    }


}