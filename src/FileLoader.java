import java.io.*;
import java.util.TreeMap;

public class FileLoader {
    public static TreeMap<String,String> loadDictionary() throws IOException {
        TreeMap<String, String> dictionary = new TreeMap<String, String>();
        BufferedReader br = new BufferedReader(new FileReader("slang.txt"));
        int n = Integer.parseInt(br.readLine());
//        System.out.println(n);

        for (int i = 0; i < n; i++){
            String line = br.readLine();
            int partition = line.indexOf('`');

            String key = line.substring(0, partition);
            String value = line.substring(partition+1);

//            if (dictionary.containsKey(key)){
//                System.out.println(line);
//            }
            dictionary.put(key, value);
//            System.out.println(key + " - " + value);
        }

        br.close();
        return dictionary;
    }
    public static void main(String[] args) throws IOException {
//        TreeMap<String, String> dict = loadDictionary();
//        System.out.println(dict.size());
//        for (String key : dict.keySet()) {
//            System.out.println("Key: " + key + ", Value: " + dict.get(key));
//        }
    }

}
