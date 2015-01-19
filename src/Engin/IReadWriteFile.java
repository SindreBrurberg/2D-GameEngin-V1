package Engin;

import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * Created by Dethsanius on 12.01.2015.
 */
public interface IReadWriteFile {
    public FileWriter getFile(String filePathName);
    public PrintWriter StartWrite(FileWriter fileWriter);
    public void EndWrite(FileWriter fileWriter);
}
