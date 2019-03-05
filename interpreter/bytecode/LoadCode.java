package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class LoadCode extends ByteCode {

    private int n;
    private String id="";

    @Override
    public void init(ArrayList args) {
        n = Integer.parseInt((String) args.get(0));
        id = (String) args.get(1);

    }

    @Override
    public void execute(VirtualMachine VM) {
        System.out.println("LoadCode " + n + " " + id);
        VM.getRunStack().load(n);
    }
}
