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
