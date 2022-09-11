import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import javax.xml.bind.annotation.XmlElementDecl.GLOBAL

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

Boolean textSuggestNominal = WebUI.waitForElementVisible(findTestObject('Object Repository/suggestNominalPO/textSuggestNominal'), GlobalVariable.timeout)
// opsional
WebUI.delay(GlobalVariable.timeout)

if(textSuggestNominal) {
	WebUI.callTestCase(findTestCase('PaymentPage/suggestNominal'), [:], FailureHandling.STOP_ON_FAILURE)
}


WebUI.callTestCase(findTestCase('General/bypass'), [:], FailureHandling.STOP_ON_FAILURE)

Boolean titleMetodePembayaran = WebUI.waitForElementVisible(findTestObject('Object Repository/metodePembayaranPO/titleMetodePembayaran'), GlobalVariable.timeout)

if(titleMetodePembayaran) {
	WebUI.callTestCase(findTestCase('PaymentMethodPage/paymentMethod'), [:], FailureHandling.STOP_ON_FAILURE)
}

WebUI.callTestCase(findTestCase('General/bypass'), [:], FailureHandling.STOP_ON_FAILURE)

String donasi = WebUI.getAttribute(findTestObject('Object Repository/paymentPO/inputNominalDonasi'), 'placeholder');

println("donasi >>>> " + donasi);

if(donasi == '0') {
	WebUI.delay(2)
	WebUI.setText(findTestObject('Object Repository/paymentPO/inputNominalDonasi'), GlobalVariable.nominalDonasi, FailureHandling.STOP_ON_FAILURE)
	
	WebUI.delay(2)
	
	WebUI.click(findTestObject('Object Repository/paymentPO/buttonPaymentMethod'))
	
	WebUI.callTestCase(findTestCase('General/bypass'), [:], FailureHandling.STOP_ON_FAILURE)
	
//	got stuck because cloudflare :((
	WebUI.callTestCase(findTestCase('PaymentMethodPage/paymentMethod'), [:], FailureHandling.STOP_ON_FAILURE)
	
}

// opsional
WebUI.delay(GlobalVariable.timeout)
// nama lengkap
WebUI.setText(findTestObject('Object Repository/paymentPO/inputNamaLengkap'), GlobalVariable.fullname, FailureHandling.STOP_ON_FAILURE)

// opsional
WebUI.delay(GlobalVariable.timeout)
// nomor ponsel atau email
WebUI.setText(findTestObject('Object Repository/paymentPO/inputNoPonselOrEmail'), GlobalVariable.username, FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/paymentPO/buttonLanjutPembayaran'), FailureHandling.STOP_ON_FAILURE)