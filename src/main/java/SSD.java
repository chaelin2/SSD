import java.util.Scanner;
import java.io.*;

public class SSD {
    static String[] ssdArr= new String[100];
    Scanner sc = new Scanner(System.in);
//    File fileOrigin = File(src/main/java/nand.txt, "nand.txt");
    RandomAccessFile file = new RandomAccessFile("C:\\SSD\\untitled\\src\\main\\java\\nand.txt", "rw");
    public void Print(){
        try {
            file.readInt();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public SSD() throws FileNotFoundException {
        System.out.println("no file here");
    }

    public static void main(String[] args) throws FileNotFoundException {
        SSD ssd = new SSD();
        ssd.Print();
    }
}
