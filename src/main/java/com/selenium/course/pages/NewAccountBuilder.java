package com.selenium.course.pages;

import java.util.LinkedList;
import java.util.List;

import com.selenium.course.framework.WebDriverManager;

import org.openqa.selenium.WebDriver;


public class NewAccountBuilder {/*
    String account;
	String parentAccount;
	String accountNumber; 
	String accountSite; 
	String type;
	String Industry; 
	String revenue;
	String rating; 
	String phone; 
	String fax; 
	String webSite; 
	String tickerSymbol; 
	String ownership; 
	String employes; 
	String billCity; 
	String billState; 
	String billZip; 
	String billCountry;
	String shipCity; 
	String shipState; 
	String shipZip; 
	String shipCountry;
	
	List<Steps> strategies;
	
	public NewAccountBuilder(String accountName) {
        this.account = accountName;
        this.strategies = new LinkedList();
		strategies.add(Steps.ACCOUNT);
    }
	
	public String getAccount() {
        return account;
    }
	
	public NewAccountBuilder setParentAccount (String parentAccount) {
		strategies.add(Steps.PARENT_ACCOUNT);
		this.parentAccount = parentAccount;
		return this;
	}
	
	public NewAccountBuilder setAccountNumber (String accountNumber) {
		strategies.add(Steps.NUMBER);
		this.accountNumber = accountNumber;
		return this;
	}
	
	public NewAccountBuilder setAccountSite (String accountSite) {
		strategies.add(Steps.ACCOUNT_SITE);
		this.accountSite = accountSite;
		return this;
	}
	
	public NewAccountBuilder setType (String type) {
		strategies.add(Steps.TYPE);
		this.type = type;
		return this;
	}
	
	public NewAccountBuilder setIndustry (String Industry) {
		strategies.add(Steps.INDUSTRY);
		this.Industry = Industry;
		return this;
	}
	
	public NewAccountBuilder setRevenue (String revenue) {
		strategies.add(Steps.REVENUE);
		this.revenue = revenue;
		return this;
	}
	
	public NewAccountBuilder setRating (String rating) {
		strategies.add(Steps.RATING);
		this.rating = rating;
		return this;
	}
	
	public NewAccountBuilder setPhone (String phone) {
		strategies.add(Steps.PHONE);
		this.phone = phone;
		return this;
	}
	
	public NewAccountBuilder setWebSite (String webSite) {
		strategies.add(Steps.WEBSITE);
		this.webSite = webSite;
		return this;
	}
	
	public NewAccountBuilder setFax (String fax) {
		strategies.add(Steps.FAX);
		this.fax = fax;
		return this;
	}
	
	public NewAccountBuilder setTickerSymbol (String tickerSymbol) {
		strategies.add(Steps.TICKERSYMBOL);
		this.tickerSymbol = tickerSymbol;
		return this;
	}
	
	public NewAccountBuilder setOwnership (String ownership) {
		strategies.add(Steps.OWNERSHIP);
		this.ownership = ownership;
		return this;
	}
	
	public NewAccountBuilder setEmployes (String employes) {
		strategies.add(Steps.EMPLOYES);
		this.employes = employes;
		return this;
	}
	
	public NewAccountBuilder setBillCity (String billCity) {
		strategies.add(Steps.BILLCITY);
		this.billCity = billCity;
		return this;
	}
	
	public NewAccountBuilder setBillState (String billState) {
		strategies.add(Steps.BILLSTATE);
		this.billState = billState;
		return this;
	}
	
	public NewAccountBuilder setBillZip (String billZip) {
		strategies.add(Steps.BILLZIP);
		this.billZip = billZip;
		return this;
	}
	
	public NewAccountBuilder setBillCountry (String billCountry) {
		strategies.add(Steps.BILLCOUNTRY);
		this.billCountry = billCountry;
		return this;
	}
	
	public NewAccountBuilder setShipCity (String shipCity) {
		strategies.add(Steps.SHIPCITY);
		this.shipCity = shipCity;
		return this;
	}
	
	public NewAccountBuilder setShipState (String shipState) {
		strategies.add(Steps.SHIPSTATE);
		this.shipState = shipState;
		return this;
	}
	
	public NewAccountBuilder setShipZip (String shipZip) {
		strategies.add(Steps.SHIPZIP);
		this.shipZip = shipZip;
		return this;
	}
	
	public NewAccountBuilder setShipCountry (String shipCountry) {
		strategies.add(Steps.SHIPCOUNTRY);
		this.shipCountry = shipCountry;
		return this;
	}
	*/

    public AccountForm build() {
        WebDriver driver = driver = WebDriverManager.getInstance().getDriver();
        return new AccountForm(driver);
    }

}
