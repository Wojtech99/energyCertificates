package com.example.energyCertificates.Data.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Objects;

@Service
public class AttachmentService {
    @Value("${staticImageDirectory}")
    private String IMAGES_PATH;

    private final String UPLOAD_DIRECTORY = System.getProperty("user.dir");

    public String saveDataInApp(MultipartFile file) throws IOException {
        byte[] bytes = file.getBytes();

        String fileNameToSave = "/" + preparedStringToSave(Objects
                .requireNonNull(file.getOriginalFilename()));

        Calendar calendar = Calendar.getInstance();
        int week = calendar.get(Calendar.WEEK_OF_MONTH);
        int month = calendar.get(Calendar.MONTH) + 1;
        int year = calendar.get(Calendar.YEAR);

        String datePath = year + "/" + month + "/" + week;

        Path path = Paths.get(UPLOAD_DIRECTORY + IMAGES_PATH + datePath);

        if (!Files.exists(path)) {
            Files.createDirectories(path);
        }

        Path pathToSave = Paths.get(UPLOAD_DIRECTORY + IMAGES_PATH + datePath + fileNameToSave);

        Files.write(pathToSave, bytes);

        return datePath + fileNameToSave;
    }

    public void deleteDataFromApp(String nameOfFile) throws IOException {
        Path path = Paths.get(UPLOAD_DIRECTORY + IMAGES_PATH + nameOfFile);
        Files.delete(path);
    }

    private String preparedStringToSave(String originalFileName) {
        StringBuffer stringBuffer = new StringBuffer();

        Arrays.stream(originalFileName
                        .toLowerCase()
                        .replace(' ', '_')
                        .split(" "))
                .forEach(stringBuffer::append);

        return stringBuffer.toString();
    }

}
