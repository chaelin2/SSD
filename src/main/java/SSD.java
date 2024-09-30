import java.io.*;

public class SSD {
    static String[] LBAarr = new String[100];

    //result.txt 초기화
    public void initResult(){
        File fileWrite = new File("result.txt");
        try{
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileWrite));
            if(fileWrite.canWrite()){
                bufferedWriter.write("");
                bufferedWriter.close();
            }
        }catch (IOException e){
            System.out.println("cannot write result.txt");
        }
    }
    public void writeValue(int index, String a) throws IOException {
        File fileRead = new File("/Users/iyunju/SSD/nand.txt");
        BufferedReader br = new BufferedReader(new FileReader(fileRead));
        String line = "";
        int lineIndex = 0;
        while((line = br.readLine()) != null){
            LBAarr[lineIndex] = line;
            lineIndex++;
        }
        LBAarr[index] = a;
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileRead));
        if(fileRead.canWrite()){
            for(int i=0;i<100;i++){
                bufferedWriter.write(LBAarr[i]);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
    }

    }
    // ssd read LBA -> result.txt 출력
    public void readNand(int index){
        File fileWrite = new File("result.txt");
        File fileRead = new File("/Users/iyunju/SSD/nand.txt");
        try{
            //nand.txt 읽어서 LBAarr에 저장.
            BufferedReader br = new BufferedReader(new FileReader(fileRead));
            String line = "";
            int lineIndex = 0;
            while((line = br.readLine()) != null){
                LBAarr[lineIndex] = line;
                lineIndex++;
            }

            //LBAarr에서 index 값 result.txt에 출력
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileWrite, true));
            if(fileWrite.canWrite()){
                bufferedWriter.write(LBAarr[index]);
                bufferedWriter.newLine();
                bufferedWriter.close();
            }
        }catch (IOException e){
            System.out.println("cannot read");
        }
    }


    public static void main(String[] args) throws IOException {
        SSD sd = new SSD();
        int index = Integer.parseInt(args[1]);
        if(args.length == 3) {
            sd.writeValue(index, args[2]);
        } else {
            sd.initResult();
            sd.readNand(index);
        }
    }

}