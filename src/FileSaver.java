import java.io.*;
import java.util.TreeMap;

public class FileSaver {
    public static void saveDictionary(TreeMap<String, String> dictionary) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("slang1.txt"));
        bw.write(Integer.toString(dictionary.size()));

        for (String key : dictionary.keySet()) {
            bw.newLine();
            bw.write(key + "`" + dictionary.get(key));
        }

        bw.close();
    }
    public static void main(String[] args) throws IOException {
//        TreeMap<String, String> dict = FileLoader.loadDictionary();
//        saveDictionary(dict);
    }
}
