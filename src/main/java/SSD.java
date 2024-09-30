import java.io.*;

public class SSD {
    static File fileWrite = new File("result.txt");

    // write면 lineNum = 1, fullwrite면 lineNum = 100
    static void writeResult(String line, int lineNum){
        try{
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileWrite));
            if(fileWrite.canWrite()){
                for(int i = 0; i < lineNum; i++) {
                    bufferedWriter.write(line);
                    bufferedWriter.newLine();
                }
                bufferedWriter.close();
            }
        }catch (IOException e){
            System.out.println("cannot write result.txt");
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("nand.txt"));
        while(true) {
            String line = br.readLine();
            if(line==null) break;
            writeResult(line, 100);
            System.out.println(line);
        }
        br.close();
    }
}
