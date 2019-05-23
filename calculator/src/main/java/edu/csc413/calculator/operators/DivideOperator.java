package edu.csc413.calculator.operators;

import edu.csc413.calculator.evaluator.Operand;

public class DivideOperator extends Operator {

    @Override
    public int priority(){
        return 2;
    }

    @Override
    public Operand execute(Operand op1, Operand op2) {

        Operand result = new Operand(op1.getValue() / op2.getValue());
        return result;
    }

}
