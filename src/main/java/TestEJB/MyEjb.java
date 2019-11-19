package TestEJB;

import javax.ejb.Stateless;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ejb который считывает файлы и каталоги вглубь.
 * Далее информация выводится на jsp-странице
 *
 * @version 1.0
 * @autor Айрат Загидуллин
 */
@Stateless
public class MyEjb implements IMyEjb{

    public MyEjb() {
    }

    final String fullPathDir = System.getProperty("user.dir");

    public List<String> readFileDirectory() throws IOException {
        Path path = Paths.get(fullPathDir);
        List<String> collect = Files.walk(path, Integer.MAX_VALUE)
                .map(String::valueOf)
                .sorted()
                .collect(Collectors.toList());
        return collect;
    }
}
