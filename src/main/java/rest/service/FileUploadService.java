package rest.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileUploadService {
    private static FileUploadService INSTANCE;

    private FileUploadService() {}

    public static FileUploadService getInstance() {
        if (INSTANCE == null) {
            return new FileUploadService();
        }
        return INSTANCE;
    }

    public static void saveFile(MultipartFile file, String fileName) throws IOException {
        try (InputStream inputStream =  file.getInputStream()) {
            Path path = Paths.get("src\\main\\resources\\static\\videos").resolve(fileName);
            Files.copy(inputStream, path, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public File getFile(String path) {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(path).getFile());
        return file;
    }

}
