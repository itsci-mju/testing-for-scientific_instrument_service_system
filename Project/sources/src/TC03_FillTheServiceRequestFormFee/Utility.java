package TC03_FillTheServiceRequestFormFee;
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

	public  void radio_course(String xPath, String fText,String xPath_ct, String ct_Text,String xPath_ci, String ci_Text
			                 ,String xPath_cn, String cn_Text,String xPath_mj, String mj_Text,String xPath_tt, String tt_Text
			                 ,String xPath_rp, String rp_Text,String xPath_fs, String fs_Text,String xPath_pl, String pl_Text) {
	
		List<WebElement> radio = webDriver.findElements(By.xpath(xPath));
	     for (int i = 0; i < radio.size(); i++) {
	    	 if (radio.get(i).getAttribute("value").equals(fText)) {
	    		 radio.get(i).click();
	    	     if(fText.equals("1")) {
	    	    	 
	    	    	 List<WebElement> radio_courseT = webDriver.findElements(By.xpath(xPath_ct));
	    		     for (int j = 0; j < radio_courseT.size(); j++) {
	    		    	 if (radio_courseT.get(j).getAttribute("value").equals(ct_Text)) {
	    		    		 radio_courseT.get(j).click();
	    		    	 }
	    		    }
	    		    
	    		    webDriver.findElement(By.id(xPath_ci)).sendKeys(ci_Text);
	    		    webDriver.findElement(By.id(xPath_cn)).sendKeys(cn_Text);
	    		    webDriver.findElement(By.id(xPath_mj)).sendKeys(mj_Text);
	    		    webDriver.findElement(By.id(xPath_tt)).sendKeys(tt_Text);
	    	     }else {
	    	    	 webDriver.findElement(By.id(xPath_rp)).sendKeys(rp_Text);
		    		 webDriver.findElement(By.id(xPath_fs)).sendKeys(fs_Text);
		    		 webDriver.findElement(By.id(xPath_pl)).sendKeys(pl_Text);
	    	     }
	   
	    	     return ;
	        }		    	 
	     }
	     
	     throw new NoSuchElementException("Invalid Radio button Selected");
	}
	
	public void serch_input(String xPath, String fText,String xPath_date, String D_Text,String xPath_stime, String st_Text,String xPath_etime, String et_Text) {
		try {
			webDriver.findElement(By.xpath(xPath)).sendKeys(fText);
				if(fText.equals("เครื่องชั่งไฟฟ้า 4 ตำแหน่ง")) {
					webDriver.findElement(By.xpath("//button[@id='f_btnadd216']")).click();
					webDriver.findElement(By.xpath(xPath_date)).sendKeys(D_Text);
					webDriver.findElement(By.xpath(xPath_stime)).sendKeys(st_Text);
					webDriver.findElement(By.xpath(xPath_etime)).sendKeys(et_Text);
				}
			}catch(Exception e) {
				System.out.println("input fail");
			}
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
	public String get_text1(String xPath) throws InterruptedException {
		String actualResult = "";
		try {
		if(!xPath.equals("")) {
			Thread.sleep(2000);
			actualResult = webDriver.findElement(By.xpath(xPath)).getAttribute("validationMessage");
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
			FileUtils.copyFile(scrFile, new File("c:/Users/saram/MiniProject65/AlertMassage/TD03_Fee/"+ index +".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}   
	}
}	  
