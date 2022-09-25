package TC04_FillTestingAnalysisForm;
import org.openqa.selenium.NoSuchElementException;


public class Driver {
  
	
	private Utility util = new Utility();
	
	public Utility getUtility() {
		return util;
	}

	public String keyword_executor(String vKeyword, String vIP1, String vIP2) throws Exception {
		
		String flag = "false";
	
		try {
		if (vKeyword.equals("browser_open")){		   
		    util.browser_open(getIP(vIP1));
		    flag = "True";
		    return "pass";
		}
		if (vKeyword.equals("radio_select")){
			util.radio_select(getIP(vIP1), getIP(vIP2));
			flag = "True";
		    return "pass";
		}
		if (vKeyword.equals("checkbox_set")){
			util.checkbox_set(getIP(vIP1), getIP(vIP2));
			flag = "True";
		    return "pass";
		}
		if (vKeyword.equals("list_selectName")){
			util.list_selectName(getIP(vIP1), getIP(vIP2));
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
			flag = "True";
		    return text;
		}
		if (vKeyword.equals("button_click")){
			util.button_click(getIP(vIP1));
			flag = "True";
		    return "pass";
		}
		if (vKeyword.equals("click_link")){
			util.click_link(getIP(vIP1));
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
		
		//get_text
		if (vKeyword.equals("get_textvalid")){
			String text = util.get_textvalid(getIP(vIP1));
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
		if (vIP.equals("Language")){
			vIP = StartUp.Language;
		}
		if (vIP.equals("Client_name")){
			vIP = StartUp.Client_name;
		}
		if (vIP.equals("Address")){
			vIP = StartUp.Address;
		}
		if (vIP.equals("Report_Address")){
			vIP = StartUp.Report_Address;
		}
		if (vIP.equals("Fax")){
			vIP = StartUp.Fax;
		}
		if (vIP.equals("Billing_Address")){
			vIP = StartUp.Billing_Address;
		}
		if (vIP.equals("SampleName")){
			vIP = StartUp.SampleName;
		}
		if (vIP.equals("Code")){
			vIP = StartUp.Code;
		}
		if (vIP.equals("Weight")){
			vIP = StartUp.Weight;
		}
		if (vIP.equals("Qty")){
			vIP = StartUp.Qty;
		}
		if (vIP.equals("TestItemid")){
			vIP = StartUp.TestItemid;
		}
		if (vIP.equals("Storage")){
			vIP = StartUp.Storage;
		}
		if (vIP.equals("Packing_style")){
			vIP = StartUp.Packing_style;
		}
		if (vIP.equals("Additional")){
			vIP = StartUp.Additional;
		}
		if (vIP.equals("Other_addit")){
			vIP = StartUp.Other_addit;
		}
		if (vIP.equals("Receive")){
			vIP = StartUp.Receive;
		}
		if (vIP.equals("Results")){
			vIP = StartUp.Results;
		}//xPath
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
		StartUp.Language = StartUp.xTDdata[k][6];
		StartUp.Client_name = StartUp.xTDdata[k][7];
		StartUp.Address = StartUp.xTDdata[k][8];
		StartUp.Report_Address = StartUp.xTDdata[k][9];
		StartUp.Fax = StartUp.xTDdata[k][10];
		StartUp.Billing_Address = StartUp.xTDdata[k][11];
		StartUp.SampleName = StartUp.xTDdata[k][12];
		StartUp.Code = StartUp.xTDdata[k][13];
		StartUp.Weight = StartUp.xTDdata[k][14];
		StartUp.Qty = StartUp.xTDdata[k][15];
		StartUp.TestItemid = StartUp.xTDdata[k][16];
		StartUp.Storage = StartUp.xTDdata[k][17];
		StartUp.Packing_style = StartUp.xTDdata[k][18];
		StartUp.Additional = StartUp.xTDdata[k][19];
		StartUp.Other_addit = StartUp.xTDdata[k][20];
		StartUp.Receive = StartUp.xTDdata[k][21];
		StartUp.Results = StartUp.xTDdata[k][22];
		StartUp.xPath = StartUp.xTDdata[k][28];

	}
	
}