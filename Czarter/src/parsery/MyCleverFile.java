package parsery;

import java.io.File;

public class MyCleverFile extends File {
    public MyCleverFile(String filePath) {
        super(filePath);

        String fileName = getName().split("[.]")[0];
        System.out.println(fileName);

        if (!exists()) {
            File[] files = getAbsoluteFile().getParentFile().listFiles();

            System.out.println("Plik nie istineje, czy chodzilo ci o:");
            System.out.println(getAbsolutePath());
            System.out.println(System.getProperty("user.dir"));

            if (files != null)
                for (File file : files)
                    if (file.getName().startsWith(fileName)) System.out.println("\t" + fileName);
        }
    }
}
