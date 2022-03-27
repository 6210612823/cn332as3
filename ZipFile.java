import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFile extends FileDecorator {

    public ZipFile(String source){
        super(source);
    }

    private FileOutputStream fos;

    public FileOutputStream zip() throws IOException {
        FileOutputStream fos = new FileOutputStream("compressed.zip");

        ZipOutputStream zipOut = new ZipOutputStream(fos);
        FileInputStream fis = new FileInputStream(super.getSourceFile());
        ZipEntry zipEntry = new ZipEntry(super.getSourceFile().getName());

        zipOut.putNextEntry(zipEntry);
        byte[] bytes = new byte[1024];
        int length;

        while ((length = fis.read(bytes)) >= 0) {
            zipOut.write(bytes, 0, length);
        }

        zipOut.close();
        fis.close();
        fos.close();
        return fos;
    }
}