import java.io.*;

public class SSD {
    static String[] LBAarr = new String[100];
    public SSD(){
        int[] memory = new int[100];
        try (FileWriter writer = new FileWriter("nand.txt")){
            for(int i=0;i<memory.length;i++) {
                writer.write(String.format("0x%08X\n", memory[i]));
            }
            System.out.println("성공");
        } catch(IOException e) {
            System.out.println("오류 발생: " + e.getMessage());
        }
    }
    //result.txt 초기화
    static void initResult(){
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

    // ssd read LBA -> result.txt 출력
    static void readNand(int index){
        File fileWrite = new File("result.txt");
        File fileRead = new File("nand.txt");
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
            BufferedReader br = new BufferedReader(new FileReader("nand.txt"));
        }

    }
