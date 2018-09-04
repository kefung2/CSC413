import edu.csc413.calculator.evaluator.Operand;
import edu.csc413.calculator.operators.DivideOperator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


@DisplayName("Division Test")
public class DivideOperatorTest {

    @Test
    public void DivisionTest01(){
        Operand op1 =  new Operand(6);
        Operand op2 =  new Operand(11);
        DivideOperator dp =  new DivideOperator();
        Operand res = new Operand(dp.execute(op1,op2).getValue());
        assertEquals(0, res.getValue());
    }

    @Test
    public void DivisionTest02(){
        Operand op1 =  new Operand(11);
        Operand op2 =  new Operand(6);
        DivideOperator dp =  new DivideOperator();
        Operand res = new Operand(dp.execute(op1,op2).getValue());
        assertEquals(1, res.getValue());
    }

    @Test
    public void DivisionTest03(){
        Operand op1 =  new Operand(25);
        Operand op2 =  new Operand(5);
        DivideOperator dp =  new DivideOperator();
        Operand res = new Operand(dp.execute(op1,op2).getValue());
        assertEquals(5, res.getValue());
    }

    @Test
    public void DivisionTest04(){
        Operand op1 =  new Operand(25);
        Operand op2 =  new Operand(-5);
        DivideOperator dp =  new DivideOperator();
        Operand res = new Operand(dp.execute(op1,op2).getValue());
        assertEquals(-5, res.getValue());
    }

    @Test
    public void divisionPriorityTest(){
        assertEquals(2, (new DivideOperator().priority()));
    }
}
