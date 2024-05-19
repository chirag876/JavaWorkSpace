package com.springrest.springrest.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.springrest.springrest.Dao.QuoteDAO;

import com.springrest.springrest.Entity.Quote;


@Service
public class quoteServiceImp implements QuoteService {

	@Autowired
	private QuoteDAO quotedao;

	@Override
	public Quote AddQuote(Quote quote1) {
		String folderPath = "C:\\WorkSpaces\\CodeSpaces\\AcordJSON\\Quote";

		// Create a File object for the folder
		File folder = new File(folderPath);

		// Get the list of files in the folder
		File[] files = folder.listFiles();

		// Iterate over the files and print their names
		for (File file : files) {
			if (file.isFile()) {
				System.out.print(file.getName());
				String jsonFilePath = file.getPath();

				try {
					// Read the JSON file as a String
					String jsonString = Files.readString(Paths.get(jsonFilePath));

					// Convert the JSON string to an entity object using Gson

					ObjectMapper objectMapper = new ObjectMapper();
					JsonNode jsonNode = objectMapper.readTree(jsonString);

					Quote entity = new Quote();
					entity.setQuoteJsonB(jsonNode);

					//quotedao.save(entity);
					
					System.out.print(file.getName());

				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		// policydao.save(policy1);
		return null;
	}



}