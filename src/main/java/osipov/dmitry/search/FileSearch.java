package osipov.dmitry.search;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileSearch {
    public static void main(String[] args) {
        List<File> files = new ArrayList<>();
        searchFiles(new File("./"), files);
        files.forEach(System.out::println);
    }

    public static void searchFiles(File rootFile, List<File> files) {
        if (rootFile.isDirectory()) {
            File[] filesArray = rootFile.listFiles();
            if (filesArray != null) {
                for (File file : filesArray) {
                    if (file.isDirectory()) {
                        searchFiles(file, files);
                    } else if (file.getName().endsWith(".java")) {
                        files.add(file);
                    }
                }
            }
        }
    }
}
