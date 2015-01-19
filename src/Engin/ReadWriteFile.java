package Engin;

import java.io.*;

/**
 * Created by Dethsanius on 12.01.2015.
 */
public class ReadWriteFile implements IReadWriteFile{
    private boolean method = false, firstRound = false;

    public boolean printIfContains(String line, String contains, String start, String end){
        if (line.contains(contains) || method || firstRound){
            if (line.contains(contains)){
                firstRound = true;
            }
            else if (line.contains(start)){
                firstRound = false;
                method = true;
            }
            else if (line.contains(end)){
                method = false;
            }
            else if (method){
                return true;
            }
        }
        return false;
    }

    public boolean printIfContainjs(String line, String start, String end){
        if (line.contains(start) || method){
            if (line.contains(start)){
                method = true;
            }
            else if (line.contains(end)){
                method = false;
            }
            else if (method){
                return true;
            }
        }
        return false;
    }

    public int getIntLine(int Line, String Path) {
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(Path));
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                i++;
                if (i == Line) {
                    return Integer.parseInt(line);
                }
                //System.out.println(br.readLine().codePointAt(2));
                //System.out.println(br.read());
                // process the line.
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public FileWriter getFile(String filePathName){
        try {
            File file = new File(filePathName);
            return new FileWriter(file);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
    public PrintWriter StartWrite(FileWriter fileWriter){
        return new PrintWriter(fileWriter);
    }

    public void Write(PrintWriter printWriter, String string){
        printWriter.write(string);
        printWriter.println();
    }

    public void Write(PrintWriter printWriter){
        printWriter.println();
    }

    public void EndWrite(FileWriter fileWriter){
        try {
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
