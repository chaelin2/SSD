import java.io.*;

public class SSD {
    static String[] LBAarr = new String[100];

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
            int[] memory = new int[100];

            try (FileWriter writer = new FileWriter("nand.txt")){
                for(int i=0;i<memory.length;i++) {
                    writer.write(String.format("0x%08X\n", memory[i]));
                }
                System.out.println("성공");
            } catch(IOException e) {
                System.out.println("오류 발생: " + e.getMessage());
            }
            try (BufferedReader reader = new BufferedReader(new FileReader("nand.txt"))) {
                String line;
                int currentIndex = 0;
                while ((line = reader.readLine()) != null) {
                    if (currentIndex == 3) {
                        System.out.println("Index " + 3 + ": " + line);
                        break;
                    }
                    currentIndex++;
                }

                if (currentIndex < 3) {
                    System.out.println("파일에 지정된 인덱스에 해당하는 줄이 없습니다.");
                }

            } catch (IOException e) {
                System.err.println("파일을 읽는 동안 오류가 발생했습니다: " + e.getMessage());
            }

        }

    }
