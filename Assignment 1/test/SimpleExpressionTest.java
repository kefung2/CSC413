import org.junit.Test;
import static org.junit.Assert.*;

public class SimpleExpressionTest {

  @Test
  public void testSimpleExpression() {
    Evaluator instance = new Evaluator();

    final String expression = "2+3*4";
    final int result = 14;

    assertEquals( instance.eval( expression ), result );
  }

}
