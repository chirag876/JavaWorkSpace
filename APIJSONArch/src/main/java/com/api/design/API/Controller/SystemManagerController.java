package com.api.design.API.Controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;

import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SystemManagerController {

	// This method maps the HTTP GET request to "/get-app-error-log-file" endpoint
	@GetMapping("/get-app-error-log-file")
	public ResponseEntity<byte[]> getAppErrorLogFile() throws IOException {
		String path = "logs/spring-boot-logger.log";  // specifies the path of the log file
		byte[] fileContents = Files.readAllBytes(Paths.get(path));  // reads the entire contents of the log file
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		outputStream.write(fileContents);  // writes the contents of the file to the output stream

		// builds the HTTP headers with metadata for the response
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.TEXT_PLAIN);
		headers.setContentDisposition(ContentDisposition.builder("attachment")
				.filename("App-Error.txt " + LocalDateTime.now().toString() + ".txt").build());
		
		// constructs the HTTP response entity with the file contents and headers
		return new ResponseEntity<>(outputStream.toByteArray(), headers, HttpStatus.OK);
	}

}
