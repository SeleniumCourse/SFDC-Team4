package com.selenium.course.framework;

import au.com.bytecode.opencsv.CSVReader;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.selenium.course.common.Globals.PATH_CONTACT;
import static com.selenium.course.common.Globals.PATH_EDIT_CONTACT;

/**
 * Created by Nelson Tapia on 9/5/2015.
 */
public class RegisterData {

    private String firstName;
    private String lastName;

    private String title;
    private String department;
    private String accountName;
    private String leadSource;
    private String phone;
    private String homePhone;
    private String mobile;
    private String otherPhone;
    private String fax;
    private String email;
    private String assistant;
    private String assistantPhone;
    private String mailingStreet;
    private String mailingCity;
    private String mailingState;
    private String mailingZip;
    private String mailingCountry;
    private String otherStreet;
    private String otherCity;
    private String otherState;
    private String otherZip;
    private String otherCountry;
    private String languages;
    private String level;
    private String description;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getLastName() {
        return lastName;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }

    public void setAccountName(String newAccountName) {
        this.accountName = newAccountName;
    }
    public String getAccountName() {
        return accountName;
    }

    public void setDepartment(String newDepartment) {
        this.department = newDepartment;
    }
    public String  getDepartment() {
        return department;
    }

    public void setLeadSource(String leadSource) {
        this.leadSource = leadSource;
    }
    public String getLeadSource() {
        return leadSource;
    }

    public void setPhone(String newPhone) {
        this.phone = newPhone;
    }
    public String getPhone() {
        return phone;
    }

    public void setHomePhone(String newHomePhone) {
        this.homePhone = newHomePhone;
    }
    public String getHomePhone() {
        return homePhone;
    }

    public void setMobile(String newMobile) {
        this.mobile = newMobile;
    }
    public String getMobile() {
        return mobile;
    }

    public void setOtherPhone(String newOtherPhone) {
        this.otherPhone = newOtherPhone;
    }
    public String getOtherPhone() {
        return otherPhone;
    }

    public void setFax(String newFax) {
        this.fax = newFax;
    }
    public String getFax() {
        return fax;
    }

    public void setEmail(String newEmail) {
        this.email = newEmail;
    }
    public String getEmail(){
        return email;
    }

    public void setAssistant(String newAssistant) {
        this.assistant = newAssistant;
    }
    public String getAssistant(){
        return assistant;
    }

    public void setAssistantPhone(String newAssistantPhone) {
        this.assistantPhone = newAssistantPhone;
    }
    public String getAssistantPhone(){
        return assistantPhone;
    }

    //Address information
    public void setMailingStreet(String newMailingStreet) {
        this.mailingStreet = newMailingStreet;
    }
    public String getMailingStreet(){
        return mailingStreet;
    }

    public void setMailingCity(String newMailingCity) {
        this.mailingCity = newMailingCity;
    }
    public String getMailingCity(){
        return mailingCity;
    }

    public void setMailingState(String newMailingState) {
        this.mailingState = newMailingState;
    }
    public String getMailingState(){
        return mailingState;
    }

    public void setMailingZipPostal(String newMailingZipPostal) {
        this.mailingZip = newMailingZipPostal;
    }
    public String getMailingZipPostal(){
        return mailingZip;
    }

    public void setMailingCountry(String newMailingCountry) {
        this.mailingCountry = newMailingCountry;
    }
    public String getMailingCountry(){
        return mailingCountry;
    }

    public void setOtherStreet(String newOtherStreet) {
        this.otherStreet = newOtherStreet;
    }
    public String getOtherStreet(){
        return otherStreet;
    }

    public void setOtherCity(String newOtherCity) {
        this.otherCity = newOtherCity;
    }
    public String getOtherCity(){
        return otherCity;
    }

    public void setOtherState(String newOtherState) {
        this.otherState = newOtherState;
    }
    public String getOtherState(){
        return otherState;
    }

    public void setOtherZipPostal(String newOtherZipPostal) {
        this.otherZip = newOtherZipPostal;
    }
    public String getOtherZip(){
        return otherZip;
    }

    public void setOtherCountry(String newOtherCountry) {
        this.otherCountry = newOtherCountry;
    }
    public String getOtherCountry(){
        return otherCountry;
    }

    public void setLanguages(String newLanguages) {
        this.languages = newLanguages;
    }
    public String getLanguages(){
        return languages;
    }

    public void selectLevel(String newLevel) {
        this.level = newLevel;
    }
    public String getLevel(){
        return level;
    }

    public void setDescription(String newDescription) {
        this.description = newDescription;
    }
    public String getDescription(){
        return description;
    }

////
    @DataProvider(name="regData")
    public static Object[][] pages() throws IOException {

        CSVReader csvReader = new CSVReader(new FileReader(
                RegisterData.class.getResource(PATH_CONTACT).getPath()));
        List<String[]> dataList = csvReader.readAll();
        Object[][] data = new Object[dataList.size()][1];
        List<RegisterData> regList = new ArrayList<RegisterData>();

        Integer le = regList.size();

        System.out.println(le);


        for (String[] strArray : dataList) {
            RegisterData registrationData = new RegisterData();

            registrationData.setFirstName(strArray[0].trim());
            registrationData.setLastName(strArray[1].trim());
            registrationData.setAccountName(strArray[2].trim());
            registrationData.setTitle(strArray[3].trim());
            registrationData.setDepartment(strArray[4].trim());
            registrationData.setLeadSource(strArray[5].trim());
            registrationData.setPhone(strArray[6].trim());
            registrationData.setHomePhone(strArray[7].trim());
            registrationData.setMobile(strArray[8].trim());
            registrationData.setOtherPhone(strArray[9].trim());
            registrationData.setFax(strArray[10].trim());
            registrationData.setEmail(strArray[11].trim());
            registrationData.setAssistant(strArray[12].trim());
            registrationData.setAssistantPhone(strArray[13].trim());
            registrationData.setMailingStreet(strArray[14].trim());
            registrationData.setMailingCity(strArray[15].trim());
            registrationData.setMailingState(strArray[16].trim());
            registrationData.setMailingZipPostal(strArray[17].trim());
            registrationData.setMailingCountry(strArray[18].trim());
            registrationData.setOtherStreet(strArray[19].trim());
            registrationData.setOtherCity(strArray[20].trim());
            registrationData.setOtherState(strArray[21].trim());
            registrationData.setOtherZipPostal(strArray[22].trim());
            registrationData.setOtherCountry(strArray[23].trim());
            registrationData.setLanguages(strArray[24].trim());
            registrationData.selectLevel(strArray[25].trim());
            registrationData.setDescription(strArray[26].trim());
            regList.add(registrationData);
        }
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                data[i][j] = regList.get(i);
            }
        }
        csvReader.close();
        return data;

    }

    @DataProvider(name="editData")
    public static Object[][] editPages() throws IOException {

        CSVReader csvReader = new CSVReader(new FileReader(
                RegisterData.class.getResource(PATH_EDIT_CONTACT).getPath()));
        List<String[]> dataList = csvReader.readAll();
        Object[][] data = new Object[dataList.size()][1];
        List<RegisterData> regList = new ArrayList<RegisterData>();
        for (String[] strArray:dataList) {
            RegisterData registrationData = new RegisterData();

            registrationData.setFirstName(strArray[0].trim());
            registrationData.setLastName(strArray[1].trim());
            registrationData.setAccountName(strArray[2].trim());
            registrationData.setTitle(strArray[3].trim());
            registrationData.setDepartment(strArray[4].trim());
            registrationData.setLeadSource(strArray[5].trim());
            registrationData.setPhone(strArray[6].trim());
            registrationData.setHomePhone(strArray[7].trim());
            registrationData.setMobile(strArray[8].trim());
            registrationData.setOtherPhone(strArray[9].trim());
            registrationData.setFax(strArray[10].trim());
            registrationData.setEmail(strArray[11].trim());
            registrationData.setAssistant(strArray[12].trim());
            registrationData.setAssistantPhone(strArray[13].trim());
            registrationData.setMailingStreet(strArray[14].trim());
            registrationData.setMailingCity(strArray[15].trim());
            registrationData.setMailingState(strArray[16].trim());
            registrationData.setMailingZipPostal(strArray[17].trim());
            registrationData.setMailingCountry(strArray[18].trim());
            registrationData.setOtherStreet(strArray[19].trim());
            registrationData.setOtherCity(strArray[20].trim());
            registrationData.setOtherState(strArray[21].trim());
            registrationData.setOtherZipPostal(strArray[22].trim());
            registrationData.setOtherCountry(strArray[23].trim());
            registrationData.setLanguages(strArray[24].trim());
            registrationData.selectLevel(strArray[25].trim());
            registrationData.setDescription(strArray[26].trim());
            regList.add(registrationData);

            regList.add(registrationData);
        }
        for(int i=0; i<data.length; i++) {
            for(int j=0; j<data[i].length; j++) {
                data[i][j]=regList.get(i);
            }
        }
        csvReader.close();
        return data;
    }

}
