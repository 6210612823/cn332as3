import java.io.File;

public  class FileDecorator implements FileInterface {

    private File sourceFile = null;

    FileDecorator(){}

    FileDecorator(String source) {
        sourceFile = new File(source);
    }

    public File getSourceFile() {
        return sourceFile;
    }

    @Override
    public void log() {
        System.out.println("Decorate File" + sourceFile.getName());
    }
}
