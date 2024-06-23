package com.AcordApi.Application.Domain.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

public class PolicyDataExtration {
	


    // attributes
	@Id
    private String id;
//    private String quoteId;
//    private String claimId;
    private String customerId;
    private String customerName;
//    private String givenName;
//    private String surname;
//    private String cancelReasonDescription;
//    private String controllingStateOrProvinceCode;
    
//    private String statusCode;
//    private String parentEntityId;
//    private String parentEntityTypeName;
    private String lineOfBusinessCode;
//    private String number;
    private double totalPremium;
    private String effectiveDate;
//    private String originalEffectiveDate;
    private String cancellationDate;
    private String expirationDate;
    private String renewalDate;
    private double renewalPremium;
    private String numberOfEmployees;
    private String businessIndustry;
    private double annualRevenue;
    private String paymentMethod;
    private String claimsCount;
    private double claimAmount;
    private String durationInMonths;
    private String renewalStatus;

    // constructors

    public PolicyDataExtration() {
    }
    
    

    public PolicyDataExtration(String id, String customerId, String customerName, String lineOfBusinessCode,
			double totalPremium, String effectiveDate, String cancellationDate, String expirationDate,
			String renewalDate, double renewalPremium, String numberOfEmployees, String businessIndustry,
			double annualRevenue, String paymentMethod, String claimsCount, double claimAmount, String durationInMonths,
			String renewalStatus) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.customerName = customerName;
		this.lineOfBusinessCode = lineOfBusinessCode;
		this.totalPremium = totalPremium;
		this.effectiveDate = effectiveDate;
		this.cancellationDate = cancellationDate;
		this.expirationDate = expirationDate;
		this.renewalDate = renewalDate;
		this.renewalPremium = renewalPremium;
		this.numberOfEmployees = numberOfEmployees;
		this.businessIndustry = businessIndustry;
		this.annualRevenue = annualRevenue;
		this.paymentMethod = paymentMethod;
		this.claimsCount = claimsCount;
		this.claimAmount = claimAmount;
		this.durationInMonths = durationInMonths;
		this.renewalStatus = renewalStatus;
	}



	// getters and setters

//    public String getQuoteId() {
//        return quoteId;
//    }
//
//    public void setQuoteId(String quoteId) {
//        this.quoteId = quoteId;
//    }
//
//    public String getClaimId() {
//        return claimId;
//    }
//
//    public void setClaimId(String claimId) {
//        this.claimId = claimId;
//    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

//    public String getGivenName() {
//        return givenName;
//    }
//
//    public void setGivenName(String givenName) {
//        this.givenName = givenName;
//    }
//
//    public String getSurname() {
//        return surname;
//    }
//
//    public void setSurname(String surname) {
//        this.surname = surname;
//    }
//
//    public String getCancelReasonDescription() {
//        return cancelReasonDescription;
//    }
//
//    public void setCancelReasonDescription(String cancelReasonDescription) {
//        this.cancelReasonDescription = cancelReasonDescription;
//    }
//
//    public String getControllingStateOrProvinceCode() {
//        return controllingStateOrProvinceCode;
//    }
//
//    public void setControllingStateOrProvinceCode(String controllingStateOrProvinceCode) {
//        this.controllingStateOrProvinceCode = controllingStateOrProvinceCode;
//    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

//    public String getStatusCode() {
//        return statusCode;
//    }
//
//    public void setStatusCode(String statusCode) {
//        this.statusCode = statusCode;
//    }
//
//    public String getParentEntityId() {
//        return parentEntityId;
//    }
//
//    public void setParentEntityId(String parentEntityId) {
//        this.parentEntityId = parentEntityId;
//    }
//
//    public String getParentEntityTypeName() {
//        return parentEntityTypeName;
//    }
//
//    public void setParentEntityTypeName(String parentEntityTypeName) {
//        this.parentEntityTypeName = parentEntityTypeName;
//    }

    public String getLineOfBusinessCode() {
        return lineOfBusinessCode;
    }

    public void setLineOfBusinessCode(String lineOfBusinessCode) {
        this.lineOfBusinessCode = lineOfBusinessCode;
    }

//    public String getNumber() {
//        return number;
//    }
//
//    public void setNumber(String number) {
//        this.number = number;
//    }

    public double getTotalPremium() {
        return totalPremium;
    }

    public void setTotalPremium(double totalPremium) {
        this.totalPremium = totalPremium;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

//    public String getOriginalEffectiveDate() {
//        return originalEffectiveDate;
//    }
//
//    public void setOriginalEffectiveDate(String originalEffectiveDate) {
//        this.originalEffectiveDate = originalEffectiveDate;
//    }

    public String getCancellationDate() {
        return cancellationDate;
    }

    public void setCancellationDate(String cancellationDate) {
        this.cancellationDate = cancellationDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getRenewalDate() {
        return renewalDate;
    }

    public void setRenewalDate(String renewalDate) {
        this.renewalDate = renewalDate;
    }

    public double getRenewalPremium() {
        return renewalPremium;
    }

    public void setRenewalPremium(double renewalPremium) {
        this.renewalPremium = renewalPremium;
    }

    public String getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(String numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    public String getBusinessIndustry() {
        return businessIndustry;
    }

    public void setBusinessIndustry(String businessIndustry) {
        this.businessIndustry = businessIndustry;
    }

    public double getAnnualRevenue() {
        return annualRevenue;
    }

    public void setAnnualRevenue(double annualRevenue) {
        this.annualRevenue = annualRevenue;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getClaimsCount() {
        return claimsCount;
    }

    public void setClaimsCount(String claimsCount) {
        this.claimsCount = claimsCount;
    }

    public double getClaimAmount() {
        return claimAmount;
    }

    public void setClaimAmount(double claimAmount) {
        this.claimAmount = claimAmount;
    }

    public String getDurationInMonths() {
        return durationInMonths;
    }

    public void setDurationInMonths(String durationInMonths) {
        this.durationInMonths = durationInMonths;
    }

    public String getRenewalStatus() {
        return renewalStatus;
    }

    public void setRenewalStatus(String renewalStatus) {
        this.renewalStatus = renewalStatus;
    }
	
}
