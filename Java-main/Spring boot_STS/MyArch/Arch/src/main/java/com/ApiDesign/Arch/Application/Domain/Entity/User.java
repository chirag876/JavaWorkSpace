package com.ApiDesign.Arch.Application.Domain.Entity;

public class User {
	
	public String Id;
    public String UserRoleId;
    public String UserName ;
    public String Mobile ;
    public String Email ;
    public String Position ;
    public String BusinessUnit;  
    public int TotalRecords ;
    public String oid; 
    public String given_name ;
    public String family_name ;
    public String preferred_username ;
    public String FirstName ;
    public String LastName;
    public String SecondaryEmail ;
    public String PhoneNumber ;
    public String Extension ;
    public String display_name ;
    public String ManagerId ;
    public Boolean IsActive ;
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getUserRoleId() {
		return UserRoleId;
	}
	public void setUserRoleId(String userRoleId) {
		UserRoleId = userRoleId;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getMobile() {
		return Mobile;
	}
	public void setMobile(String mobile) {
		Mobile = mobile;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPosition() {
		return Position;
	}
	public void setPosition(String position) {
		Position = position;
	}
	public String getBusinessUnit() {
		return BusinessUnit;
	}
	public void setBusinessUnit(String businessUnit) {
		BusinessUnit = businessUnit;
	}
	public int getTotalRecords() {
		return TotalRecords;
	}
	public void setTotalRecords(int totalRecords) {
		TotalRecords = totalRecords;
	}
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public String getGiven_name() {
		return given_name;
	}
	public void setGiven_name(String given_name) {
		this.given_name = given_name;
	}
	public String getFamily_name() {
		return family_name;
	}
	public void setFamily_name(String family_name) {
		this.family_name = family_name;
	}
	public String getPreferred_username() {
		return preferred_username;
	}
	public void setPreferred_username(String preferred_username) {
		this.preferred_username = preferred_username;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getSecondaryEmail() {
		return SecondaryEmail;
	}
	public void setSecondaryEmail(String secondaryEmail) {
		SecondaryEmail = secondaryEmail;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public String getExtension() {
		return Extension;
	}
	public void setExtension(String extension) {
		Extension = extension;
	}
	public String getDisplay_name() {
		return display_name;
	}
	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}
	public String getManagerId() {
		return ManagerId;
	}
	public void setManagerId(String managerId) {
		ManagerId = managerId;
	}
	public Boolean getIsActive() {
		return IsActive;
	}
	public void setIsActive(Boolean isActive) {
		IsActive = isActive;
	}
    
}
