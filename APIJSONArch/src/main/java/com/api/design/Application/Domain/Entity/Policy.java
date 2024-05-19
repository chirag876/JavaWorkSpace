package com.api.design.Application.Domain.Entity;

import java.math.BigInteger;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "myPOLICYS")
public class Policy {
	
	 @javax.persistence.Id
	    @Column(name = "ID")
	    private UUID Id;
	    private int pId;
	    private int premiumAmount;
	    private BigInteger coverageLimit;
	    
	    public Policy() {}
		public Policy(UUID id, int pId, int premiumAmount, BigInteger coverageLimit) {
			super();
			Id = id;
			this.pId = pId;
			this.premiumAmount = premiumAmount;
			this.coverageLimit = coverageLimit;
		}
		public UUID getId() {
			return Id;
		}
		public void setId(UUID id) {
			Id = id;
		}
		public int getpId() {
			return pId;
		}
		public void setpId(int pId) {
			this.pId = pId;
		}
		public int getPremiumAmount() {
			return premiumAmount;
		}
		public void setPremiumAmount(int premiumAmount) {
			this.premiumAmount = premiumAmount;
		}
		public BigInteger getCoverageLimit() {
			return coverageLimit;
		}
		public void setCoverageLimit(BigInteger coverageLimit) {
			this.coverageLimit = coverageLimit;
		}
	    
}
