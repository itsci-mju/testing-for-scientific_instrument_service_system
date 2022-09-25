package TC013_AddInstruments;
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

	public  void radio_selectPrice(String xPath, String fText,String xP_priceA, String priceA,String xP_priceB, String priceB,String xP_priceC, String priceC,String xP_priceD, String priceD,String xP_NpriceA, String NpriceA,String xP_NpriceB, String NpriceB,String xP_NpriceC, String NpriceC,String xP_NpriceD, String NpriceD) {
		List<WebElement> radio = webDriver.findElements(By.xpath(xPath));
	     for (int i = 0; i < radio.size(); i++) {
	    	 if (radio.get(i).getAttribute("value").equals(fText)) {
	    		 radio.get(i).click();
	    		 
	    		 try {
	    		     if(!priceA.equals("")) {
	    		    	 Thread.sleep(300);
	    	    		 webDriver.findElement(By.xpath(xP_priceA)).sendKeys(priceA); 
	    	    	 }
	    		     if(!priceB.equals("")) {
	    		    	 Thread.sleep(300);
	    	    		 webDriver.findElement(By.xpath(xP_priceB)).sendKeys(priceB); 
	    	    	 }
	    		     if(!priceC.equals("")) {
	    		    	 Thread.sleep(300);
	    	    		 webDriver.findElement(By.xpath(xP_priceC)).sendKeys(priceC); 
	    	    	 }
	    		     if(!priceD.equals("")) {
	    		    	 Thread.sleep(300);
	    	    		 webDriver.findElement(By.xpath(xP_priceD)).sendKeys(priceD); 
	    	    	 }
	    		     //-- Nextprice ---//
	    		     if(!NpriceA.equals("")) {
	    		    	 Thread.sleep(300);
	    	    		 webDriver.findElement(By.xpath(xP_NpriceA)).sendKeys(NpriceA); 
	    	    	 }
	    		     if(!NpriceB.equals("")) {
	    		    	 Thread.sleep(300);
	    	    		 webDriver.findElement(By.xpath(xP_NpriceB)).sendKeys(NpriceB); 
	    	    	 }
	    		     if(!NpriceC.equals("")) {
	    		    	 Thread.sleep(300);
	    	    		 webDriver.findElement(By.xpath(xP_NpriceC)).sendKeys(NpriceC); 
	    	    	 }
	    		     if(!NpriceD.equals("")) {
	    		    	 Thread.sleep(300);
	    	    		 webDriver.findElement(By.xpath(xP_NpriceD)).sendKeys(NpriceD); 
	    	    	 }
	    		    
	    		     }catch(Exception e){
	    		    	 System.out.println("--fail!--");
	    		     }
	    	     return ;
	        }		    	 
	     }
	     
	     throw new NoSuchElementException("Invalid Radio button Selected");
	}
	
	public  void radio_select(String xPath, String fText,String xP_priceA, String priceA,String xP_priceB, String priceB,String xP_priceC, String priceC,String xP_priceD, String priceD) {
		List<WebElement> radio = webDriver.findElements(By.xpath(xPath));
	     for (int i = 0; i < radio.size(); i++) {
	    	 if (radio.get(i).getAttribute("value").equals(fText)) {
	    		 radio.get(i).click();
	    		 
	    		 try {
	    		     if(!priceA.equals("")) {
	    		    	 Thread.sleep(300);
	    	    		 webDriver.findElement(By.xpath(xP_priceA)).sendKeys(priceA); 
	    	    	 }
	    		     if(!priceB.equals("")) {
	    		    	 Thread.sleep(300);
	    	    		 webDriver.findElement(By.xpath(xP_priceB)).sendKeys(priceB); 
	    	    	 }
	    		     if(!priceC.equals("")) {
	    		    	 Thread.sleep(300);
	    	    		 webDriver.findElement(By.xpath(xP_priceC)).sendKeys(priceC); 
	    	    	 }
	    		     if(!priceD.equals("")) {
	    		    	 Thread.sleep(300);
	    	    		 webDriver.findElement(By.xpath(xP_priceD)).sendKeys(priceD); 
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
	
	public void list_select(String xpath, String fText) { 
		 
 		Select select = new Select(webDriver.findElement(By.xpath(xpath)));
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

	public void button_click(String xPath) throws InterruptedException {
		Thread.sleep(800);
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
     
	    if (temp[0].trim().equals("ข้อมูลผิดพลาด"))		
	    		return false;
	    	else
	    	     return true;
	   } 
	public void upload_picture(String xPath, String fText) throws InterruptedException {
		Thread.sleep(800);
		webDriver.findElement(By.xpath(xPath)).sendKeys(fText);
		System.out.println(webDriver.findElement(By.xpath("//label[@id='pname']")).getText());
	}

	public String get_textAlert() throws InterruptedException {
		Thread.sleep(3000);
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
			FileUtils.copyFile(scrFile, new File("c:/Users/saram/MiniProject65/AlertMassage/TD013/"+ index +".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}   
	}
}	  
