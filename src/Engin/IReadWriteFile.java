package Engin;

import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * Created by Dethsanius on 12.01.2015.
 * Interface of RWF
 */
public interface IReadWriteFile {
	FileWriter getFile(String filePathName);

	PrintWriter StartWrite(FileWriter fileWriter);

	void EndWrite(FileWriter fileWriter);
}
