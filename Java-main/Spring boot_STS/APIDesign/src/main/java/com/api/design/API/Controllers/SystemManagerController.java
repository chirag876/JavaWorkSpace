package com.api.design.API.Controllers;

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
	@GetMapping("/GetAppInformationLogFile")
	public ResponseEntity<byte[]> getAppInformation() throws IOException, URISyntaxException {
		String dllPath = getClass().getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
		String dllParentPath = new File(dllPath).getParent();
		String dllGrandParentPath = new File(dllParentPath).getParent();
		String logFilePath = Paths.get(dllParentPath, "Log", "myapp.log").toString();

		byte[] fileContents = Files.readAllBytes(Paths.get(logFilePath));
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(fileContents.length);
		outputStream.write(fileContents, 0, fileContents.length);

		try {
			String fileName = "App-Information "
					+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")) + ".txt";
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.TEXT_PLAIN);
			headers.setContentDisposition(ContentDisposition.builder("attachment").filename(fileName).build());
			return ResponseEntity.ok().headers(headers).body(outputStream.toByteArray());
		} catch (Exception e) {
			throw new RuntimeException("Failed to get app information", e);
		}
	}

	@GetMapping("/GetLogFile")
	public ResponseEntity<byte[]> getNlog() throws IOException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate today = LocalDate.now();
		String date = today.format(formatter);
		String filename = "myapp" + date + ".log";
		String path = "APIDesign\\logs" + filename;
		byte[] fileContents = Files.readAllBytes(Paths.get(path));
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		outputStream.write(fileContents);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.TEXT_PLAIN);
		headers.setContentDisposition(ContentDisposition.builder("attachment")
				.filename("nlog.txt " + LocalDateTime.now().toString() + ".txt").build());
		return new ResponseEntity<>(outputStream.toByteArray(), headers, HttpStatus.OK);
	}

	@GetMapping("/GetAppErrorLogFile")
	public ResponseEntity<byte[]> getAppErrorLogFile() throws IOException {
		String path = "logs/myapp.log";
		byte[] fileContents = Files.readAllBytes(Paths.get(path));
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		outputStream.write(fileContents);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.TEXT_PLAIN);
		headers.setContentDisposition(ContentDisposition.builder("attachment")
				.filename("App-Error.txt " + LocalDateTime.now().toString() + ".txt").build());
		return new ResponseEntity<>(outputStream.toByteArray(), headers, HttpStatus.OK);
	}

}
