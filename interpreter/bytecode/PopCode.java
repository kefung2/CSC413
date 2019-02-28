package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class PopCode extends ByteCode{

    private int n;

    @Override
    public void init(ArrayList args) {
        n = Integer.parseInt((String) args.get(0));
    }

    @Override
    public void execute(VirtualMachine VM) {

        while(n > 0){
            VM.getRunStack().pop();
        }

    }
}
