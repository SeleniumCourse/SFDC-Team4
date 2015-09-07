package com.selenium.course.testng;

import com.selenium.course.pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Rina Espinoza on 8/28/2015.
 */
public class EditAccount {
    private AccountForm accountForm;
    private TabPage accountTab;
    private AccountDetail accountDetail;
    private String accountNameEdited = "test001Edited";
    private String numberEdited = "accountNumberEdited";
    private String sideEdited = "accountSiteEdited";
    private String typeEdited = "Other";
    private String industryEdited = "Banking";
    private String ratingEdited = "Cold";
    private String revenueEdited = "50";
    private String phoneEdited = "8745213";
    private String faxEdited = "51748734";
    private String webSiteEdited = "www.siteedited.com";
    private String tickerSymbolEdited = "tickeredited";
    private String ownershipEdited = "Other";
    private String employeesEdited = "12";
    private String sicCodeEdited = "sicCodeEdited";
    private String billingCityEdited = "cityEdited";
    private String billingStateEdited = "stateEdited";
    private String billingZipEdited = "zipEd";
    private String billingCountryEdited = "countryEdited";
    private String shipCityEdited = "cityEdited";
    private String shipStateEdited = "stateEdited";
    private String shipZipEdited = "zipEdi";
    private String shipCountryEdited = "countryEdited";
    private String billingStreetEdited = "streetEdited";
    private String shipStreetEdited = "streetEdited";

    @BeforeClass
    public void setUp() {
        String name = "test001";
        String number = "accountNumber";
        String side = "accountSide";
        String type = "Prospect";
        String industry = "Apparel";
        String rating = "Hot";
        String revenue = "25";
        String phone = "874521";
        String fax = "5174874";
        String webSite = "www.site.com";
        String tickerSymbol = "ticker";
        String ownership = "Public";
        String employees = "15";
        String sicCode = "sicCode";
        String billingCity = "city";
        String billingState = "state";
        String billingZip = "zip";
        String billingCountry = "country";
        String shipCity = "city";
        String shipState = "state";
        String shipZip = "zip";
        String shipCountry = "country";
        String billingStreet = "street";
        String shipStreet = "street";
        LoginPage loginPage = new LoginPage();
        ContentPage contentPage = loginPage.loginAsPrimaryUser();
        accountTab = contentPage.tabBar.clickAccounts();
        accountForm = new AccountForm(accountTab.clickNewBtn().getDriver());
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
    }


    @Test
    public void testEditAccount() {

        accountForm = new AccountForm(accountDetail.clickEditBtn().getDriver());
        accountForm.setAccountNameText(accountNameEdited)
                .setAccountNumberField(numberEdited)
                .setAccountSiteField(sideEdited)
                .setAccountTypeField(typeEdited)
                .setAccountIndustryField(industryEdited)
                .setAccountRatingField(ratingEdited)
                .setAccountRevenueField(revenueEdited)
                .setAccountPhoneField(phoneEdited)
                .setAccountFaxField(faxEdited)
                .setAccountWebSiteField(webSiteEdited)
                .setAccountTickerField(tickerSymbolEdited)
                .setAccountOwnershipField(ownershipEdited)
                .setAccountEmployeesField(employeesEdited)
                .setAccountSicCodeField(sicCodeEdited)
                .setAccountBillingStreetField(billingStreetEdited)
                .setAccountBillingCityField(billingCityEdited)
                .setAccountBillingStateField(billingStateEdited)
                .setAccountBillingZipField(billingZipEdited)
                .setAccountBillingCountryField(billingCountryEdited)
                .setAccountShipStreetField(shipStreetEdited)
                .setAccountShipCityField(shipCityEdited)
                .setAccountShipStateField(shipStateEdited)
                .setAccountShipZipField(shipZipEdited)
                .setAccountShipCountryField(shipCountryEdited);
        accountDetail = new AccountDetail(accountForm.clickSaveBtn().getDriver());
        Assert.assertEquals(accountDetail.getObjectName(), accountNameEdited);
        Assert.assertEquals(accountDetail.getAccountNumberField(), numberEdited);
        Assert.assertEquals(accountDetail.getAccountSiteField(), sideEdited);
        Assert.assertEquals(accountDetail.getTypeField(), typeEdited);
        Assert.assertEquals(accountDetail.getIndustryField(), industryEdited);
        Assert.assertEquals(accountDetail.getRatingField(), ratingEdited);
        Assert.assertTrue(accountDetail.getRevenueField().contains(revenueEdited));
        Assert.assertEquals(accountDetail.getPhoneField(), phoneEdited);
        Assert.assertEquals(accountDetail.getFaxField(), faxEdited);
        Assert.assertTrue(accountDetail.getWebSiteField().contains(webSiteEdited));
        Assert.assertEquals(accountDetail.getTickerSymbolField(), tickerSymbolEdited);
        Assert.assertEquals(accountDetail.getOwnershipField(), ownershipEdited);
        Assert.assertEquals(accountDetail.getEmployeesField(), employeesEdited);
        Assert.assertEquals(accountDetail.getSicCodeField(), sicCodeEdited);
        Assert.assertTrue(accountDetail.getBilling().contains(billingStreetEdited));
        Assert.assertTrue(accountDetail.getBilling().contains(billingCityEdited));
        Assert.assertTrue(accountDetail.getBilling().contains(billingStateEdited));
        Assert.assertTrue(accountDetail.getBilling().contains(billingZipEdited));
        Assert.assertTrue(accountDetail.getBilling().contains(billingCountryEdited));
        Assert.assertTrue(accountDetail.getShipping().contains(shipStreetEdited));
        Assert.assertTrue(accountDetail.getShipping().contains(shipCityEdited));
        Assert.assertTrue(accountDetail.getShipping().contains(shipStateEdited));
        Assert.assertTrue(accountDetail.getShipping().contains(shipZipEdited));
        Assert.assertTrue(accountDetail.getShipping().contains(shipCountryEdited));
    }

    @AfterClass
    public void tearDown() {
        accountTab = accountDetail.clickDeleteBtn();
        accountTab.goToNavigationLinks().clickLogoutBtn();
    }


}
