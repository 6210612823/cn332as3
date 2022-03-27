import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 extends FileDecorator {

    public MD5(String source)
    {
        super(source);
    }

    public byte[] checksum() throws NoSuchAlgorithmException, IOException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        try (InputStream is = new FileInputStream(super.getSourceFile());
             DigestInputStream dis = new DigestInputStream(is, md)) {
        }

        byte[] digest = md.digest();
        return digest;

    }
}
