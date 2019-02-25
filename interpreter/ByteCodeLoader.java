
package interpreter;

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
        StringTokenizer tokenizer;
        Program program = new Program();
        ArrayList <String> argumentList = new ArrayList<>();

        try {
            //codeLine = byteSource.readLine();
            tokenizer = new StringTokenizer(byteSource.readLine());
        } catch (IOException e) {
            System.out.println("No line find");
            System.exit(-1);
        }

        while (tokenizer != null) {

            String codeName = CodeTable.getClassName(tokenizer.nextToken());

            while (tokenizer.hasMoreTokens()) {


            }


            return program;
        }
    }
}
