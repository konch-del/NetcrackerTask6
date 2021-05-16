package netcracker;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class FindSymbol {
    public static void main(String[] args) throws IOException, URISyntaxException {
        //получение директории *.jar-файла и поиск считываемого файла
        Path path = Paths.get(CodeToFile.class.getProtectionDomain().getCodeSource().getLocation().toURI());
        path = path.getParent().getParent().getParent();
        Path filePath = Paths.get(path.toString()  + "\\Symbol.txt");
        //ожидания символа для поиска
        Scanner scan = new Scanner(System.in);
        String st = scan.nextLine();
        char find = st.charAt(0);
        //подсчет количества вхождений
        if (Files.exists(filePath)) {
            List<String> lines = Files.readAllLines(filePath, StandardCharsets.UTF_8);
            long i = 0;
            for (String line : lines) {
                long occurrencesCount = line.codePoints().filter(ch -> ch == find).count();
                i += occurrencesCount;
            }
            System.out.println(i);

        }

    }
}
