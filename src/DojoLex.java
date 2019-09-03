import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class DojoLex {

    public static void main(String[] args) throws IOException {

        File file = new File(System.getProperty("user.dir") + "/src/jquery-3.4.1.js");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        String full = "";

        while ((st = br.readLine()) != null) {
            if(st.trim().startsWith("//")) continue;
            full += st.trim();
        }

        full = full.replaceAll("\\/\\*[\\s\\S]*?\\*\\/|([^\\\\:]|^)\\/\\/.*|<!--[\\s\\S]*?-->$", "");

        List<String> lines =  Arrays.asList(full);
        Path fullFile = Paths.get(System.getProperty("user.dir") + "/src/minifiedJquery.js");
        Files.write(fullFile, lines, StandardCharsets.UTF_8);
    }
}