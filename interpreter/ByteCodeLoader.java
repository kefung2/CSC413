
package interpreter;

import interpreter.bytecode.ByteCode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class ByteCodeLoader extends Object {

    private BufferedReader byteSource;
    
    /**
     * Constructor Simply creates a buffered reader.
     * YOU ARE NOT ALLOWED TO READ FILE CONTENTS HERE
     * THIS NEEDS TO HAPPEN IN LOADCODES.
     */
    public ByteCodeLoader(String file) throws IOException {
        this.byteSource = new BufferedReader(new FileReader(file));
    }
    /**
     * This function should read one line of source code at a time.
     * For each line it should:
     *      Tokenize string to break it into parts.
     *      Grab THE correct class name for the given ByteCode from CodeTable
     *      Create an instance of the ByteCode class name returned from code table.
     *      Parse any additional arguments for the given ByteCode and send them to
     *      the newly created ByteCode instance via the init function.
     */
    public Program loadCodes() {
        //String codeLine;
        //System.out.println("Im in and loading boyz!");

        StringTokenizer tokenizer = null;
        Program program = new Program();
        ArrayList<String> argumentList = new ArrayList<>();

        try {
            // read file
            tokenizer = new StringTokenizer(byteSource.readLine());
        } catch (IOException e) {
            System.out.println("No line find");
            //System.exit(-1);
        }
        //while the file is not empty
        while (tokenizer != null) {
            //getting the code part of the string
            String codeName = CodeTable.getClassName(tokenizer.nextToken());

            try {
                //building instance of bytecode
                ByteCode byteCode = (ByteCode) (Class.forName("interpreter.bytecode." + codeName).newInstance());

                while (tokenizer.hasMoreTokens()) {
                    // read any additional argument from the given bytecode if any
                    argumentList.add(tokenizer.nextToken());
                }
                //pass argument into bytecode's init function
                byteCode.init(argumentList);
                //Store initialized bytecode instance into program
                program.setByte(byteCode);

            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
                e.printStackTrace();
            }

            try {
                //get more line from file
                tokenizer = new StringTokenizer(byteSource.readLine());
            } catch (IOException e) {
                System.out.println("No line find");
                //System.exit(-1);
            } catch (NullPointerException n){
                //if file is empty, set token to null to end loop
                tokenizer = null;
            }
        }
        //resolve all symbolic addresses
        program.resolveAddrs(program);
        return program;

    }
}
