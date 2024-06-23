package com.AcordApi;

import com.AcordApi.API.Controller.PolicyController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
public class AcordApiApplication {

	public static void main(String[] args) {


		SpringApplication.run(AcordApiApplication.class, args);
	}

}



//public class AcordApiApplication {
//	public static void main(String[] args) {
//		// Specify the path to the folder
//		String folderPath = "C:\\Users\\HP\\Downloads\\Policys\\Policy";
//
//		// Create a File object for the folder
//		File folder = new File(folderPath);
//
//		// Get the list of files in the folder
//		File[] files = folder.listFiles();
//
//		// Iterate over the files and print their names
//		for (File file : files) {
//			if (file.isFile()) {
//				System.out.println(file.getPath());
//			}
//		}
//	}
//}

//}
