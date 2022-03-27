
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class JAVAcompress {

    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        String file = input[0];
        OutputStream file_des;
        FileOutputStream zip;
        DES testing = null;
        byte[] checksum = null;
        for (int i = 0; i < input.length; i++) {
            if (input[i].equalsIgnoreCase("-MD5")) {
                checksum = new MD5(file).checksum();
            }
            if (input[i].equalsIgnoreCase("-DES")) {
                testing = new DES(file);
                testing.encrypt_decrypt("encrypt", null);
            }
            if (input[i].equalsIgnoreCase("-ZIP")) {
                zip = new ZipFile(file).zip();
            }
        }
    }

}
