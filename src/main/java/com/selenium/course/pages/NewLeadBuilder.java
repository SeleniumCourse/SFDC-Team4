package com.selenium.course.pages;

import java.util.LinkedList;
import java.util.List;

import com.selenium.course.pages.EnumsList.Steps;

public class NewLeadBuilder {
	String salutation;
	String lastName;
	String companyName;
	String campaign;
	
	List<Steps> strategies;
	
	public NewLeadBuilder(String lastName, String companyName) {
        this.lastName = lastName;
        this.companyName = companyName;
        this.strategies = new LinkedList();
		strategies.add(Steps.LAST_NAME);
		strategies.add(Steps.COMPANY_NAME);
    }
	
	public String getLastName() {
        return lastName;
    }
	
	public String getCompanyName() {
        return companyName;
    }
	
	public NewLeadBuilder setSalutation (String salutation) {
		strategies.add(Steps.SALUTATION);
		this.salutation = salutation;
		return this;
	}
	
	public NewLeadBuilder setLastName (String lastName) {
		strategies.add(Steps.LAST_NAME);
		this.lastName = lastName;
		return this;
	}
	
	public NewLeadBuilder setCompanyName (String companyName) {
		strategies.add(Steps.COMPANY_NAME);
		this.companyName = companyName;
		return this;
	}
	
	public NewLeadBuilder setCampaign (String campaign) {
		strategies.add(Steps.CAMPAIGN);
		this.campaign = campaign;
		return this;
	}
	
	public NewLeadForm build() {
        return new NewLeadForm(this);
    }
}
