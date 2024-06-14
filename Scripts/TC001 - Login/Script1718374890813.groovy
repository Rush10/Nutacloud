import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

/* init data */
String companyId = "${companyId}"
String username = "${username}"
String password = "${password}"
String expected = "${expected}"

String expCompanyId = "NB"
String expUsername = "NB"
String expPassword = "test"

/* set data */

WebUI.waitForElementPresent(findTestObject('Object Repository/Login/buttonLogin'),GlobalVariable.timeoutNextPage)

if(!companyId.equals("")) {
	WebUI.setText(findTestObject('Object Repository/Login/inputCompanyId'), companyId)	
}

if(!username.equals("")) {
	WebUI.setText(findTestObject('Object Repository/Login/inputUsername'), username)	
}

if(!password.equals("")) {
	WebUI.setText(findTestObject('Object Repository/Login/inputPassword'), password)	
}

WebUI.click(findTestObject('Object Repository/Login/buttonLogin'))

/* validation data */

if(!companyId.equals(expCompanyId)) {
	WebUI.waitForElementPresent(findTestObject('Object Repository/Login/spanTxtWrongCompanyId'), GlobalVariable.timeoutNextPage)
	WebUI.verifyElementPresent(findTestObject('Object Repository/Login/spanTxtWrongCompanyId'), GlobalVariable.timeout)
	WebUI.verifyElementText(findTestObject('Object Repository/Login/spanTxtWrongCompanyId'), expected)
}else if(!username.equals(expUsername)) {
	WebUI.waitForElementPresent(findTestObject('Object Repository/Login/spanTxtWrongUsername'), GlobalVariable.timeoutNextPage)
	WebUI.verifyElementPresent(findTestObject('Object Repository/Login/spanTxtWrongUsername'), GlobalVariable.timeout)
	WebUI.verifyElementText(findTestObject('Object Repository/Login/spanTxtWrongUsername'), expected)
}else if(!password.equals(expPassword)) {
	WebUI.waitForElementPresent(findTestObject('Object Repository/Login/spanTxtWrongPassword'), GlobalVariable.timeoutNextPage)
	WebUI.verifyElementPresent(findTestObject('Object Repository/Login/spanTxtWrongPassword'), GlobalVariable.timeout)
	WebUI.verifyElementText(findTestObject('Object Repository/Login/spanTxtWrongPassword'), expected)
}else {
	WebUI.waitForElementPresent(findTestObject('Object Repository/Dashboard/spanTxtProfileName'), GlobalVariable.timeoutNextPage)
	WebUI.verifyElementPresent(findTestObject('Object Repository/Dashboard/spanTxtProfileName'), GlobalVariable.timeout)
	WebUI.verifyElementText(findTestObject('Object Repository/Dashboard/spanTxtProfileName'), expCompanyId)
	
	WebUI.click(findTestObject('Object Repository/Dashboard/aButtonDropDownProfile'))
	
	WebUI.waitForElementPresent(findTestObject('Object Repository/Dropdown Profile/spanTxtProfileName'), GlobalVariable.timeoutNextPage)
	WebUI.verifyElementPresent(findTestObject('Object Repository/Dropdown Profile/spanTxtProfileName'), GlobalVariable.timeout)
	WebUI.verifyElementText(findTestObject('Object Repository/Dropdown Profile/spanTxtProfileName'), expCompanyId)
	
	WebUI.click(findTestObject('Object Repository/Dropdown Profile/aButtonLogout'))
}






