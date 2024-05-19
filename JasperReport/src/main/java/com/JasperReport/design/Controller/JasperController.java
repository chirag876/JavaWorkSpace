package com.JasperReport.design.Controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.JasperReport.design.Entity.Address;
import com.JasperReport.design.Repository.AddressRepository;
import com.JasperReport.design.Service.JReportService;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import net.sf.jasperreports.engine.JRException;

//This class is a controller that generates PDF reports from JasperReports.

//The `@Autowired` annotation tells Spring to inject the `AddressRepository` and
//`JReportService` beans into this class.
@RestController
public class JasperController {

	// The `@Autowired` annotation tells Spring to inject the `AddressRepository`
	// bean
	// into this class.
	@Autowired
	private AddressRepository repository;

	// The `@Autowired` annotation tells Spring to inject the `JReportService` bean
	// into this class.
	@Autowired
	private JReportService service;

	// This method gets all the addresses from the database.
	@GetMapping("/getAddress")
	public List<Address> getAddress() {
		// Get all the addresses from the database.
		List<Address> address = (List<Address>) repository.findAll();

		// Return the list of addresses.
		return address;
	}

	// This method generates a PDF report from the JasperReports template.
	@GetMapping("/jasperpdf/export")
	public void createPDF(HttpServletResponse response) throws IOException, JRException {
		// Set the response content type to PDF.
		response.setContentType("application/pdf");

		// Create a date formatter.
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");

		// Get the current date and time.
		String currentDateTime = dateFormatter.format(new Date());

		// Set the response header to indicate that the file is an attachment.
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=pdf_" + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);

		// Generate the PDF report.
		service.exportJasperReport(response);
	}
}
