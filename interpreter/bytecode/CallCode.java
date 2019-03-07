package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class CallCode extends ByteCode {

    private String functionName;
    private int addrs;
    private  int value;

    @Override
    public void init(ArrayList args) {
        functionName = (String) args.get(0);
    }

    @Override
    public void execute(VirtualMachine VM) {
        //value = VM.getReturnAddrs();

    }
}
