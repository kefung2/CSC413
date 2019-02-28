package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;
import java.util.Scanner;

public class ReadCode extends ByteCode {
    private int val;

    @Override
    public void init(ArrayList args) {

    }

    @Override
    public void execute(VirtualMachine VM) {
        System.out.println("Enter value for READ: ");
        Scanner scanner = new Scanner(System.in);
        val = scanner.nextInt();
        VM.getRunStack().push(val);
    }
}
