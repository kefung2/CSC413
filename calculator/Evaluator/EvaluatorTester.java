package Evaluator;

public class EvaluatorTester {

    public static void main(String[] args) {
        Evaluator evaluator = new Evaluator();
        String[] test = {
            "1+2",
            "1/2",
            "1+2*3",
            "(1+2)*3",
            "2-(3/10)+2-5",
            "(6-12*2)/3",
            "3^2",
            "3^2/2",
            "2+3-5*((2-3)*2-5*2+3*(2-3-5-5*6)+4/2)*2-9"
        };
        int[] res = {
            3,
            0,
            7,
            9,
            -1,
            -6,
            9,
            4,
            1176
        };

        for (int i = 0; i < test.length; i++) {
            try {
                System.out.format("%42s = %5s : %-5d\n", test[i], evaluator.eval(test[i]), res[i]);
            } catch (Exception ex) {
                System.out.format("%42s = %5s : %-5s\n", test[i], "error", res[i]);
            }

        }
    }
}
