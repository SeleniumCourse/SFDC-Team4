package com.selenium.course.testng;

import com.selenium.course.pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by Rina Espinoza on 8/28/2015.
 */
public class CreateAccount {
    private AccountForm accountForm;
    private TabPage accountTab;
    private AccountDetail accountDetail;
    private String name = "test001";
    private String number = "accountNumber";
    private String side = "accountSide";
    private String type = "Prospect";
    private String industry = "Apparel";
    private String rating = "Hot";
    private String revenue = "25";
    private String phone = "874521";
    private String fax = "5174874";
    private String webSite = "www.site.com";
    private String tickerSymbol = "ticker";
    private String ownership = "Public";
    private String employees = "15";
    private String sicCode = "sicCode";
    private String billingCity = "city";
    private String billingState = "state";
    private String billingZip = "zip";
    private String billingCountry = "country";
    private String shipCity = "city";
    private String shipState = "state";
    private String shipZip = "zip";
    private String shipCountry = "country";
    private String billingStreet = "street";
    private String shipStreet = "street";

    @BeforeClass
    public void setUp() {
        LoginPage loginPage = new LoginPage();
        ContentPage contentPage = loginPage.loginAsPrimaryUser();
        accountTab = contentPage.tabBar.clickAccounts();
        accountForm = new AccountForm(accountTab.clickNewBtn().getDriver());
    }


    @Test
    public void testCreateAccount() {
        accountForm.setAccountNameText(name)
                .setAccountNumberField(number)
                .setAccountSiteField(side)
                .setAccountTypeField(type)
                .setAccountIndustryField(industry)
                .setAccountRatingField(rating)
                .setAccountRevenueField(revenue)
                .setAccountPhoneField(phone)
                .setAccountFaxField(fax)
                .setAccountWebSiteField(webSite)
                .setAccountTickerField(tickerSymbol)
                .setAccountOwnershipField(ownership)
                .setAccountEmployeesField(employees)
                .setAccountSicCodeField(sicCode)
                .setAccountBillingCityField(billingCity)
                .setAccountBillingStateField(billingState)
                .setAccountBillingZipField(billingZip)
                .setAccountBillingCountryField(billingCountry)
                .setAccountShipCityField(shipCity)
                .setAccountShipStateField(shipState)
                .setAccountShipZipField(shipZip)
                .setAccountShipCountryField(shipCountry)
                .setAccountBillingStreetField(billingStreet)
                .setAccountShipStreetField(shipStreet);
        accountDetail = new AccountDetail(accountForm.clickSaveBtn().getDriver());
        Assert.assertEquals(accountDetail.getObjectName(), name);
        Assert.assertEquals(accountDetail.getAccountNumberField(), number);
        Assert.assertEquals(accountDetail.getAccountSiteField(), side);
        Assert.assertEquals(accountDetail.getTypeField(), type);
        Assert.assertEquals(accountDetail.getIndustryField(), industry);
        Assert.assertEquals(accountDetail.getRatingField(), rating);
        Assert.assertTrue(accountDetail.getRevenueField().contains(revenue));
        Assert.assertEquals(accountDetail.getPhoneField(), phone);
        Assert.assertEquals(accountDetail.getFaxField(), fax);
        Assert.assertTrue(accountDetail.getWebSiteField().contains(webSite));
        Assert.assertEquals(accountDetail.getTickerSymbolField(), tickerSymbol);
        Assert.assertEquals(accountDetail.getOwnershipField(), ownership);
        Assert.assertEquals(accountDetail.getEmployeesField(), employees);
        Assert.assertEquals(accountDetail.getSicCodeField(), sicCode);
        Assert.assertTrue(accountDetail.getBilling().contains(billingStreet));
        Assert.assertTrue(accountDetail.getBilling().contains(billingCity));
        Assert.assertTrue(accountDetail.getBilling().contains(billingState));
        Assert.assertTrue(accountDetail.getBilling().contains(billingZip));
        Assert.assertTrue(accountDetail.getBilling().contains(billingCountry));
        Assert.assertTrue(accountDetail.getShipping().contains(shipStreet));
        Assert.assertTrue(accountDetail.getShipping().contains(shipCity));
        Assert.assertTrue(accountDetail.getShipping().contains(shipState));
        Assert.assertTrue(accountDetail.getShipping().contains(shipZip));
        Assert.assertTrue(accountDetail.getShipping().contains(shipCountry));

    }

    @AfterClass
    public void tearDown() {
        accountTab = new TabPage(accountDetail.clickDeleteBtn().getDriver());
        NavigationLinks navigationLinks = new NavigationLinks(accountTab.goToNavigationLinks().getDriver());
        navigationLinks.clickLogoutBtn();
    }


}
