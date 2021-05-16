package netcracker;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ReadDoc {
    public static void main(String[] args) throws IOException, URISyntaxException {
        //получение директории *.jar-файла и поиск считываемого файла
        Path path = Paths.get(CodeToFile.class.getProtectionDomain().getCodeSource().getLocation().toURI());
        path = path.getParent().getParent().getParent();
        Path filePath = Paths.get(path.toString()  + "\\document.txt");
        //считывание пока слово java не встретиться третий раз
        if (Files.exists(filePath)) {
            List<String> lines = Files.readAllLines(filePath, StandardCharsets.UTF_8);
            int i = 0;
            for (String line : lines) {
                if(i > 3){
                    break;
                }
                if(line.toLowerCase().contains("java")){
                    i++;
                }
                System.out.println(line);
            }


        }

    }
}
