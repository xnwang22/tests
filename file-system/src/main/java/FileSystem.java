import java.io.Closeable;
import java.nio.file.attribute.FileAttribute;

/**
 * Created by robinwang on 11/2/16.
 */
public abstract class FileSystem implements Closeable, AutoCloseable{
    private FileAttribute fileAttribute;// creation time, type, modification time, readonly
    private String filePath;// use URL

    public abstract String read(int start, int end);
    public abstract String readLine();
    public abstract String write(String s);

    public FileSystem() {
    }
    public abstract void open();


}
