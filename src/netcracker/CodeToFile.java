package netcracker;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class CodeToFile {
    public static void main(String[] args) throws URISyntaxException, IOException {
        //получение директории *.jar-файла и названия класса
        String st = CodeToFile.class.getSimpleName();
        Path path = Paths.get(CodeToFile.class.getProtectionDomain().getCodeSource().getLocation().toURI());
        path = path.getParent().getParent().getParent();
        //получения файла с кодом
        Path origpath = Paths.get(path.toString()  + "\\src\\netcracker\\CodeToFile.java");
        //переход в директорию src и создание файла
        path = Paths.get(path.toString()  + "\\src" + "\\" + st + ".java");
        //копирование кода программы в файл
        Files.copy(origpath, path, StandardCopyOption.REPLACE_EXISTING);
    }
}
