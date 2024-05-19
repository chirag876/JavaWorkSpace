package com.JasperReport.design.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.JasperReport.design.Entity.Address;
import com.JasperReport.design.Repository.AddressRepository;

import java.util.HashMap;

import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

//This class is a service that generates PDF reports from JasperReports.

//The `@Autowired` annotation tells Spring to inject the `AddressRepository` bean into this class.
@Service
public class JReportService {

	// The `@Autowired` annotation tells Spring to inject the `AddressRepository` bean into this class.
	@Autowired
	private AddressRepository repository;

	// This method generates a PDF report from the JasperReports template.
	public void exportJasperReport(HttpServletResponse response) throws JRException, IOException {
		// Get all the addresses from the database.
		List<Address> address = repository.findAll();

		// Get the JasperReports template file.
		File file = ResourceUtils.getFile("classpath:Address.jrxml");

		// Compile the JasperReports template file.
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());

		// Create a data source for the report.
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(address);

		// Create a map of parameters for the report.
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("createdBy", "Simplifying Tech");

		// Fill the report with data.
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

		// Export the report to PDF.
		JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
	}
}
