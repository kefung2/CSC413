import edu.csc413.calculator.evaluator.Operand;
import edu.csc413.calculator.operators.MultiplyOperator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


@DisplayName("Multiplication Test")
public class MultiplyOperatorTest {

    @Test
    public void multiplicationTest01(){
        Operand op1 =  new Operand(6);
        Operand op2 =  new Operand(11);
        MultiplyOperator mp =  new MultiplyOperator();
        Operand res = new Operand(mp.execute(op1,op2).getValue());
        assertEquals(66, res.getValue());
    }

    @Test
    public void multiplicationTest02(){
        Operand op1 =  new Operand(11);
        Operand op2 =  new Operand(6);
        MultiplyOperator mp =  new MultiplyOperator();
        Operand res = new Operand(mp.execute(op1,op2).getValue());
        assertEquals(66, res.getValue());
    }

    @Test
    public void multiplicationTest03(){
        Operand op1 =  new Operand(-25);
        Operand op2 =  new Operand(5);
        MultiplyOperator mp =  new MultiplyOperator();
        Operand res = new Operand(mp.execute(op2,op1).getValue());
        assertEquals(-125, res.getValue());
    }

    @Test
    public void multiplicationTest04(){
        Operand op1 =  new Operand(25);
        Operand op2 =  new Operand(-5);
        MultiplyOperator mp =  new MultiplyOperator();
        Operand res = new Operand(mp.execute(op2,op1).getValue());
        assertEquals(-125, res.getValue());
    }

    @Test
    public void multiplicationPriorityTest(){
        assertEquals(2, (new MultiplyOperator().priority()));
    }
}
