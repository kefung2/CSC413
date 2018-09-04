import edu.csc413.calculator.operators.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OperatorTester {

    @Test
    void check01Test(){
        assertTrue(Operator.check("+"));
        
    }

    @Test
    void check02Test(){
        assertTrue(Operator.check("*"));
    }

    @Test
    void check03Test(){
        assertTrue(Operator.check("^"));
        
    }

    @Test
    void check04Test(){
        assertTrue(Operator.check("-"));
    }

    @Test
    void check05Test(){
        assertTrue(Operator.check("/"));
        
    }

    @Test
    void check06Test(){
        assertFalse(Operator.check("156"));
    }

    @Test
    void check07Test(){
        assertFalse(Operator.check("156.0"));
    }

    @Test
    void check08Test(){
        assertFalse(Operator.check("x"));
    }

    @Test
    void Check09Test(){
        assertFalse(Operator.check("**"));
    }
    @Test
    void getOperator01Test(){
        Operator op = Operator.getOperator("+");
        assertTrue(op instanceof AddOperator);
    }

    @Test
    void getOperator02Test(){
        Operator op = Operator.getOperator("-");
        assertTrue(op instanceof SubtractOperator);
        
    }

    @Test
    void getOperator03Test(){
        Operator op = Operator.getOperator("/");
        assertTrue(op instanceof DivideOperator);
        
    }

    @Test
    void getOperator04Test(){
        Operator op  = Operator.getOperator("*");
        assertTrue(op instanceof MultiplyOperator);
        
    }

    @Test
    void getOperator05Test(){
        Operator op = Operator.getOperator("^");
        assertTrue(op instanceof PowerOperator);
    }

    @Test
    void getOperator06Test(){
        Operator op = Operator.getOperator("c");
        assertTrue(op == null);
    }
}
