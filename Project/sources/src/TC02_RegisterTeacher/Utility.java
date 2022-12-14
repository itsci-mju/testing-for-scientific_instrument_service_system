package TC02_RegisterTeacher;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

public class Utility {
	private WebDriver webDriver = null;
	
	public void browser_open(String fURL) {
		if (webDriver == null){
			System.setProperty("webdriver.chrome.driver", "c:/Users/saram/Chromdriver_v104/chromedriver.exe");
	        webDriver = new ChromeDriver(); 
	        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	        webDriver.manage().window().maximize();
		}
		else
			webDriver = new ChromeDriver(); 
		webDriver.manage().window().maximize();
			
		webDriver.get(fURL);	
	}

	public  void radio_select(String xPath, String fText,String xPath2, String tText) {
		List<WebElement> radio = webDriver.findElements(By.xpath(xPath));
	     for (int i = 0; i < radio.size(); i++) {
	    	 if (radio.get(i).getAttribute("value").equals(fText)) {
	    		 radio.get(i).click();
	    		 
	    		 try {
	    		     if(!tText.equals("")) {
	    	    		 webDriver.findElement(By.xpath(xPath2)).sendKeys(tText); 
	    	    	 }
	    		     }catch(Exception e){
	    		    	 System.out.println("--fail!--");
	    		     }
	    	     return ;
	        }		    	 
	     }
	     
	     throw new NoSuchElementException("Invalid Radio button Selected");
	}
		
	public void edit_input(String xPath, String fText) {
		webDriver.findElement(By.xpath(xPath)).clear();
			webDriver.findElement(By.xpath(xPath)).sendKeys(fText);
	}
	
	public void edit_inputById(String id, String fText) {
		webDriver.findElement(By.id(id)).sendKeys(fText);
    }
	
	public void list_select(String xPath, String fText) { 
		 
 		Select select = new Select(webDriver.findElement(By.xpath(xPath)));
		List <WebElement> options = select.getOptions(); 

		for (int i = 0; i < options.size(); i++) { 
		if (options.get(i).getText().equals(fText)){ 
			System.out.println(options.get(i).getText());
			if (!options.get(i).isSelected())
				options.get(i).click(); 
		      return; 
		    } 
		  }
		throw new NoSuchElementException("Invalid list Selected");
	} 
	

	public void checkbox_set(String xPath, String fText) {
		String [] extract = fText.split(",");
            if (extract.length == 4) {
		    List <WebElement> checkBox = webDriver.findElements(By.xpath(xPath));
		    for (int i = 0; i < extract.length; i++){
			    if (extract[i].equalsIgnoreCase("ON")){
				    checkBox.get(i).click();
			    }
		       }   
            }
            else {
            	throw new NoSuchElementException("Invalid CheckBox Selected");
            }	
	}
	public String get_text(String xPath) {
		 return webDriver.findElement(By.xpath(xPath)).getText();
	}

	public void button_click(String xPath) {
		 webDriver.findElement(By.xpath(xPath)).click();
	}

	public void click_link(String fText) {
		 webDriver.findElement(By.linkText(fText)).click();
	}

	public boolean dialog_click() {
		String text ="";
        WebDriverWait wait = new WebDriverWait(webDriver,10);
	    wait.until(ExpectedConditions.alertIsPresent());
	    Alert alert = webDriver.switchTo().alert();
	    text = alert.getText();
	    alert.accept();
	    String[] temp = text.split(":");
     
	    if (temp[0].trim().equals("???????????????????????????????????????"))		
	    		return false;
	    	else
	    	     return true;
	   } 
	public String get_text1(String xPath) throws InterruptedException {
		String actualResult = "";
		try {
		if(!xPath.equals("")) {
			Thread.sleep(2000);
			actualResult = webDriver.findElement(By.xpath(xPath)).getText();
		}else {
			Thread.sleep(2000);
			Alert alert = webDriver.switchTo().alert();
			actualResult = alert.getText();
			alert.accept();
		}
		}catch(Exception e){
			
		}
		return actualResult;
	}
	public String get_textAlert() throws InterruptedException {
		Thread.sleep(5000);
		String actualResult="";
		try {
			Alert alert = webDriver.switchTo().alert();
			 actualResult = alert.getText();
			alert.accept();
		}catch(Exception e){
		
		}
		return actualResult;
	}
	  public void browser_close(){
		  //webDriver.navigate().refresh();
		  webDriver.close();
	}
	  public void saveScreen(String index) throws InterruptedException { 
		 File scrFile = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
		 try {
			FileUtils.copyFile(scrFile, new File("c:/Users/saram/MiniProject65/AlertMassage/TC02_T/"+ index +".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}   
	}
}	  
