package TC012_SubmitProofofPayment;
import org.openqa.selenium.NoSuchElementException;


public class Driver {
  
	
	private Utility util = new Utility();
	
	public Utility getUtility() {
		return util;
	}

	public String keyword_executor(String vKeyword, String vIP1, String vIP2, String vIP3, String vIP4) throws Exception {
		
		String flag = "false";
	
		try {
		if (vKeyword.equals("browser_open")){		   
		    util.browser_open(getIP(vIP1));
		    flag = "True";
		    return "pass";
		}
		if (vKeyword.equals("radio_select")){
			util.radio_select(getIP(vIP1), getIP(vIP2),getIP(vIP3), getIP(vIP4));
			flag = "True";
		    return "pass";
		}
		if (vKeyword.equals("checkbox_set")){
			util.checkbox_set(getIP(vIP1), getIP(vIP2));
			flag = "True";
		    return "pass";
		}
		if (vKeyword.equals("list_select")){
			util.list_select(getIP(vIP1), getIP(vIP2));
			flag = "True";
		    return "pass";
		}
		if (vKeyword.equals("edit_input")){
			util.edit_input(getIP(vIP1), getIP(vIP2));
			flag = "True";
		    return "pass";
		}
		
		//edit_inputByid
		if (vKeyword.equals("edit_inputById")){
			util.edit_inputById(getIP(vIP1), getIP(vIP2));
			flag = "True";
		    return "pass";
		}
	
		//get_text
		if (vKeyword.equals("get_text")){
			String text = util.get_text(getIP(vIP1));
			//util.get_text(getIP(vIP1));
			flag = "True";
		    return text;
		}
		if (vKeyword.equals("button_click")){
			util.button_click(getIP(vIP1));
			flag = "True";
		    return "pass";
		}
		
		if (vKeyword.equals("list_click")){
			util.list_click(getIP(vIP1));
			flag = "True";
		    return "pass";
		}
		
		if (vKeyword.equals("click_link")){
			util.click_link(getIP(vIP1));
			flag = "True";
		    return "pass";
		}
		
		//upload_picture
		if (vKeyword.equals("upload_picture")){
			util.upload_picture(getIP(vIP1), getIP(vIP2));
			flag = "True";
		    return "pass";
		}
		if (vKeyword.equals("dialog_click")){
			boolean works = util.dialog_click();
			if (works) {
		        flag = "True";
	            return "pass";
		    }
		}
		//get_text
		if (vKeyword.equals("get_textAlert")){
			String text = util.get_textAlert();
			flag = "True";
			return text;
		}
		if (vKeyword.equals("get_text1")){
			String text = util.get_text1(getIP(vIP1));
			flag = "True";
			return text;
		}
		
		if (vKeyword.equals("browser_close")){		   
		    util.browser_close();
		    flag = "True";
		    return "pass";
		}
		
		if (flag.equals("false")){
			System.out.println("Keyword is missing " + vKeyword);
			StartUp.vError = "Error";		
			return "False-Keyword Missing";
		  }
    	}
		catch (NoSuchElementException e){
			System.out.println("Error is " + e);
			StartUp.vError = String.valueOf(e);
			
			return "Fail";
		}
		return "Unknown Keyword";
	}
	
	// Add vaules
	public String getIP(String vIP){
		
		if (vIP.equals("vUrl")){
			vIP = StartUp.vUrl;
		}
		if (vIP.equals("Vuser")){
			vIP = StartUp.Vuser;
		}
		if (vIP.equals("Vpwd")){
			vIP = StartUp.Vpwd;
		}
		if (vIP.equals("Type")){
			vIP = StartUp.Type;
		}
		if (vIP.equals("Name")){
			vIP = StartUp.Name;
		}
		if (vIP.equals("Payment")){
			vIP = StartUp.Payment;
		}
		if (vIP.equals("Agency")){
			vIP = StartUp.Agency;
		}
		if (vIP.equals("photo")){
			vIP = StartUp.photo;
		}
		if (vIP.equals("Vlist_click")){
			vIP = StartUp.Vlist_click;
		}
		if (vIP.equals("xPath")){
			vIP = StartUp.xPath;
		}
		
	  return vIP;
	}
    //mapping to excel
	public void getData(int k) {
		StartUp.vUrl = StartUp.xTDdata[k][2];
		StartUp.Vuser = StartUp.xTDdata[k][4];
		StartUp.Vpwd = StartUp.xTDdata[k][5];
		StartUp.Type = StartUp.xTDdata[k][6];
		StartUp.Name = StartUp.xTDdata[k][7];
		StartUp.Payment = StartUp.xTDdata[k][8];
		StartUp.Agency = StartUp.xTDdata[k][9];
		StartUp.photo  = StartUp.xTDdata[k][10];
		StartUp.xPath  = StartUp.xTDdata[k][16];
		StartUp.Vlist_click  = StartUp.xTDdata[k][17];
		
	}
	
}