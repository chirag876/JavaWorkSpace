package com.AcordApi.API.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;
import com.AcordApi.Application.Domain.Entity.PolicyDataExtration;
import com.AcordApi.Infrastructure.DataAccess.PolicyDataExtrationDataAccess;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.FileWriter;
import java.io.IOException;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin("*")
public class CSVController {
	@Autowired
	public PolicyDataExtrationDataAccess policydata;

	@GetMapping("/Get-csv-data")
	public List<PolicyDataExtration> GetAllDetails() {
		return policydata.getData();

	}

	@GetMapping("/Download/csv")
	public void exportToCSV(HttpServletResponse response) throws IOException {
		response.setContentType("text/csv");

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=data" + ".csv";
		response.setHeader(headerKey, headerValue);

		List<PolicyDataExtration> data = policydata.getData();

		ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
		String[] csvHeader = { "customerId", "customerName", "id", "lineOfBusinessCode", "totalPremium",
				"effectiveDate", "cancellationDate", "expirationDate", "RenewalDate", "renewalPremium",
				"numberOfEmployees", "businessIndustry", "annualRevenue", "paymentMethod", "claimsCount", "claimAmount",
				"durationInMonths", "RenewalStatus" };
		String[] nameMapping = { "customerId", "customerName", "id", "lineOfBusinessCode", "totalPremium",
				"effectiveDate", "cancellationDate", "expirationDate", "RenewalDate", "renewalPremium",
				"numberOfEmployees", "businessIndustry", "annualRevenue", "paymentMethod", "claimsCount", "claimAmount",
				"durationInMonths", "RenewalStatus" };

		csvWriter.writeHeader(csvHeader);

		for (PolicyDataExtration user : data) {
			csvWriter.write(user, nameMapping);
		}

		csvWriter.close();

	}

	@GetMapping("/Download/Json")
	public void exportToJSON(HttpServletResponse response) throws IOException {
		response.setContentType("text/json");

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=JsonFile" + ".json";
		response.setHeader(headerKey, headerValue);
		List<PolicyDataExtration> data = policydata.getData();

		ObjectMapper objectMapper = new ObjectMapper();
		ArrayNode jsonArray = objectMapper.createArrayNode();

		// Convert result set to JSON

		String[] nameMapping = { "customerId", "customerName", "id", "lineOfBusinessCode", "totalPremium",
				"effectiveDate", "cancellationDate", "expirationDate", "RenewalDate", "renewalPremium",
				"numberOfEmployees", "businessIndustry", "annualRevenue", "paymentMethod", "claimsCount", "claimAmount",
				"durationInMonths", "RenewalStatus" };

		for (PolicyDataExtration user : data) {

			// Create JSON object for each row
			ObjectNode jsonObject = objectMapper.createObjectNode();
			jsonObject.put("id", user.getId());
			jsonObject.put("customerId", user.getCustomerId());
			jsonObject.put("customerName", user.getCustomerName());
			jsonObject.put("lineOfBusinessCode", user.getLineOfBusinessCode());
			jsonObject.put("totalPremium", user.getTotalPremium());
			jsonObject.put("effectiveDate", user.getEffectiveDate());
			jsonObject.put("cancellationDate", user.getCancellationDate());
			jsonObject.put("expirationDate", user.getExpirationDate());
			jsonObject.put("RenewalDate", user.getRenewalDate());
			jsonObject.put("renewalPremium", user.getRenewalPremium());
			jsonObject.put("numberOfEmployees", user.getNumberOfEmployees());
			jsonObject.put("businessIndustry", user.getBusinessIndustry());
			jsonObject.put("annualRevenue", user.getAnnualRevenue());
			jsonObject.put("paymentMethod", user.getPaymentMethod());
			jsonObject.put("claimsCount", user.getClaimsCount());
			jsonObject.put("claimAmount", user.getClaimAmount());
			jsonObject.put("durationInMonths", user.getDurationInMonths());
			jsonObject.put("RenewalStatus", user.getRenewalStatus());
			// Add more fields as needed

			// Add JSON object to array
			jsonArray.add(jsonObject);
		}

		// Write JSON to a file
		FileWriter fileWriter = new FileWriter("data/output.json");
		objectMapper.writeValue(fileWriter, jsonArray);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.TEXT_PLAIN);
		headers.setContentDisposition(ContentDisposition.builder("attachment")
				.filename("output.json" + LocalDateTime.now().toString() + ".json").build());

		// Close resources

		System.out.println("Data exported successfully to output.json");

	}

}
