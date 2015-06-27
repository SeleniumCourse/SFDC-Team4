package com.selenium.course.pages;


public class NewAccountBuilder {
	String account, parentAccount, accountNumber, accountSite, type, 
			Industry, revenue, rating, phone, fax, webSite, tickerSymbol, 
			ownership, employes, billCity, billState, billZip, billCountry,
			shipCity, shipState, shipZip, shipCountry;
	
	public NewAccountBuilder(String accountName) {
        this.account = accountName;
    }
	
	public String getAccount() {
        return account;
    }
	
	public NewAccountBuilder setAccount(String account) {
		this.account = account;
		return this;
	}
	
	public NewAccountBuilder setParentAccount (String parentAccount) {
		this.parentAccount = parentAccount;
		return this;
	}
	
	public NewAccountBuilder setAccountNumber (String accountNumber) {
		this.accountNumber = accountNumber;
		return this;
	}
	
	public NewAccountBuilder setAccountSite (String accountSite) {
		this.accountSite = accountSite;
		return this;
	}
	
	public NewAccountBuilder setType (String type) {
		this.type = type;
		return this;
	}
	
	public NewAccountBuilder setIndustry (String Industry) {
		this.Industry = Industry;
		return this;
	}
	
	public NewAccountBuilder setRevenue (String revenue) {
		this.revenue = revenue;
		return this;
	}
	
	public NewAccountBuilder setRating (String rating) {
		this.rating = rating;
		return this;
	}
	
	public NewAccountBuilder setPhone (String phone) {
		this.phone = phone;
		return this;
	}
	
	public NewAccountBuilder setWebSite (String webSite) {
		this.webSite = webSite;
		return this;
	}
	
	public NewAccountBuilder setFax (String fax) {
		this.fax = fax;
		return this;
	}
	
	public NewAccountBuilder setTickerSymbol (String tickerSymbol) {
		this.tickerSymbol = tickerSymbol;
		return this;
	}
	
	public NewAccountBuilder setOwnership (String ownership) {
		this.ownership = ownership;
		return this;
	}
	
	public NewAccountBuilder setEmployes (String employes) {
		this.employes = employes;
		return this;
	}
	
	public NewAccountBuilder setBillCity (String billCity) {
		this.billCity = billCity;
		return this;
	}
	
	public NewAccountBuilder setBillState (String billState) {
		this.billState = billState;
		return this;
	}
	
	public NewAccountBuilder setBillZip (String billZip) {
		this.billZip = billZip;
		return this;
	}
	
	public NewAccountBuilder setBillCountry (String billCountry) {
		this.billCountry = billCountry;
		return this;
	}
	
	public NewAccountBuilder setShipCity (String shipCity) {
		this.shipCity = shipCity;
		return this;
	}
	
	public NewAccountBuilder setShipState (String shipState) {
		this.shipState = shipState;
		return this;
	}
	
	public NewAccountBuilder setShipZip (String shipZip) {
		this.shipZip = shipZip;
		return this;
	}
	
	public NewAccountBuilder setShipCountry (String shipCountry) {
		this.shipCountry = shipCountry;
		return this;
	}
	
	public NewAccountForm build() {
        return new NewAccountForm(this);
    }

}
