package cn.tju.selenium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(Parameterized.class)
public class Script {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	private String testName;
	private String testPwd;
	private String gitHubUrl;

	public Script(String testName, String testPwd, String githubUrl) {
		this.testName = testName;
		this.testPwd = testPwd;
		this.gitHubUrl = githubUrl;
	}

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "https://psych.liebes.top";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Parameterized.Parameters
	public static Collection<Object[]> getData() {
		Object[][] obj = new Object[97][];
		try {

			// 指定excel的路径
			File src = new File("input.xlsx");

			// 加载文件
			FileInputStream fis = new FileInputStream(src);

			// 加载workbook
			@SuppressWarnings("resource")
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// 加载sheet，这里我们只有一个sheet,默认是sheet1
			XSSFSheet sh1 = wb.getSheetAt(0);
			for (int i = 0; i < sh1.getPhysicalNumberOfRows(); i++) {
				obj[i] = new Object[] {
						sh1.getRow(i).getCell(0).getStringCellValue(),
						sh1.getRow(i).getCell(0).getStringCellValue()
								.substring(4),
						sh1.getRow(i).getCell(1).getStringCellValue() };

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Arrays.asList(obj);
	}

	@Test
	public void testUntitledTestCase() throws Exception {
		driver.get(baseUrl + "/st");
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys(this.testName);
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(this.testPwd);
		driver.findElement(By.id("submitButton")).click();
		assertEquals(this.gitHubUrl.trim(),
				driver.findElement(By.cssSelector("p.login-box-msg")).getText()
						.trim());
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
}
