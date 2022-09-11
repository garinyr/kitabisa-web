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

//WebUI.openBrowser("https://kitabisa.com/campaign/bantusembuhkanperutbuncitwinda/donation-amount?slug=bantusembuhkanperutbuncitwinda")

// scroll ke text minimal donasi
WebUI.scrollToElement(findTestObject('Object Repository/suggestNominalPO/textMinimalDonasi'), 0)

// opsional
WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/suggestNominalPO/inputNominal'))
WebUI.delay(2)

WebUI.setText(findTestObject('Object Repository/suggestNominalPO/inputNominal'), GlobalVariable.nominalDonasi, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementClickable(findTestObject('Object Repository/suggestNominalPO/buttonLanjutkanPembayaran'), FailureHandling.STOP_ON_FAILURE)

// opsional
WebUI.delay(GlobalVariable.timeout)

WebUI.click(findTestObject('Object Repository/suggestNominalPO/buttonLanjutkanPembayaran'), FailureHandling.STOP_ON_FAILURE)