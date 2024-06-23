package com.ApiDesign.Arch.API.Controller;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.http.ContentDisposition;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.ByteArrayOutputStream;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

@RestController
public class SystemManagerController {

	

	@GetMapping("/get-app-error-log-file")
	public ResponseEntity<byte[]> getAppErrorLogFile() throws IOException {
    String path = "logs/spring-boot-logger.log";
    byte[] fileContents = Files.readAllBytes(Paths.get(path));
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    outputStream.write(fileContents);

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.TEXT_PLAIN);
    headers.setContentDisposition(ContentDisposition.builder("attachment").filename("App-Error.txt " + LocalDateTime.now().toString() + ".txt").build());
    return new ResponseEntity<>(outputStream.toByteArray(), headers, HttpStatus.OK);
	}

}