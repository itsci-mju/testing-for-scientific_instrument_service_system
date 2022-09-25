package TC016_AddTestItem;
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
		if (vIP.equals("ID")){
			vIP = StartUp.ID;
		}
		if (vIP.equals("Name")){
			vIP = StartUp.Name;
		}
		if (vIP.equals("Experment")){
			vIP = StartUp.Experment;
		}
		if (vIP.equals("Minqty")){
			vIP = StartUp.Minqty;
		}
		if (vIP.equals("TypeItem")){
			vIP = StartUp.TypeItem;
		}
		if (vIP.equals("Type_A")){
			vIP = StartUp.Type_A;
		}
		if (vIP.equals("Type_B")){
			vIP = StartUp.Type_B;
		}
		if (vIP.equals("Type_C")){
			vIP = StartUp.Type_C;
		}
		if (vIP.equals("Type_D")){
			vIP = StartUp.Type_D;
		}
		if (vIP.equals("Nextprice")){
			vIP = StartUp.Nextprice;
		}
	
		
	  return vIP;
	}
    //mapping to excel
	public void getData(int k) {
		StartUp.vUrl = StartUp.xTDdata[k][2];
		StartUp.Vuser = StartUp.xTDdata[k][4];
		StartUp.Vpwd = StartUp.xTDdata[k][5];
		StartUp.ID = StartUp.xTDdata[k][6];
		StartUp.Name = StartUp.xTDdata[k][7];
		StartUp.Experment = StartUp.xTDdata[k][8];
		StartUp.Minqty = StartUp.xTDdata[k][9];
		StartUp.TypeItem = StartUp.xTDdata[k][10];
		StartUp.Type_A = StartUp.xTDdata[k][11];
		StartUp.Type_B = StartUp.xTDdata[k][12];
		StartUp.Type_C = StartUp.xTDdata[k][13];
		StartUp.Type_D = StartUp.xTDdata[k][14];
		StartUp.Nextprice = StartUp.xTDdata[k][15];
		
	}
	
}