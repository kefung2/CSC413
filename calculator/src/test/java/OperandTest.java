import edu.csc413.calculator.evaluator.Operand;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Operand Test")
public class OperandTest {

    @Test
    public void getValueTest(){
        Operand op = new Operand(6);
        assertEquals(6,op.getValue());
    }

    @Test
    public void getValueTypeTest(){
        Operand op = new Operand(6);

        assertTrue(isInt(op.getValue()));
    }

    @Test
    public void checkValue01Test(){
        assertTrue(Operand.check("13"));
    }

    @Test
    public void checkValue02Test(){
        assertTrue(Operand.check("19"));
    }

    @Test
    public void checkValue03Test(){
        assertTrue(Operand.check("465465"));
    }

    @Test
    public void checkValue04Test(){
        assertFalse(Operand.check("c"));
    }

    @Test
    public void checkValue05Test(){
        assertFalse(Operand.check("3.0"));

    }

    @Test
    public void checkValue06Test(){
        assertFalse(Operand.check("3."));

    }

    @Test
    public void checkValue07Test(){
        assertFalse(Operand.check("343324fd"));
    }

    private boolean isInt(Object o){
        return o instanceof Integer;
    }


}
