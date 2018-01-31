import org.junit.Test;
import static org.junit.Assert.*;

public class SimpleParenthesesTest {

  @Test
  public void testSimpleExpressionWithParens() {
    Evaluator instance = new Evaluator();

    final String expression = "(2+3)*4";
    final int result = 20;

    assertEquals( instance.eval( expression ), result );
  }

}
