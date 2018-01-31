import org.junit.Test;
import static org.junit.Assert.*;

public class HardTest {

  @Test
  public void testHardThing() {
    Evaluator instance = new Evaluator();

    final String expression = "2+3-5*((2-3)*2-5*2+3*(2-3-5-5*6)+4/2)*2-9";
    final int result = 1176;

    assertEquals( instance.eval( expression ), result );
  }

}
