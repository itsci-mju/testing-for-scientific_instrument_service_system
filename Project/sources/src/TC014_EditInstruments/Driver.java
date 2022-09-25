package TC014_EditInstruments;
import org.openqa.selenium.NoSuchElementException;


public class Driver {
  
	
	private Utility util = new Utility();
	
	public Utility getUtility() {
		return util;
	}

	public String keyword_executor(String vKeyword, String vIP1, String vIP2, String vIP3, String vIP4, String vIP5, String vIP6
			, String vIP7, String vIP8, String vIP9, String vIP10, String vIP11, String vIP12, String vIP13, String vIP14
			, String vIP15, String vIP16, String vIP17, String vIP18) throws Exception {
		
		String flag = "false";
	
		try {
		if (vKeyword.equals("browser_open")){		   
		    util.browser_open(getIP(vIP1));
		    flag = "True";
		    return "pass";
		}
		if (vKeyword.equals("radio_select")){
			util.radio_select(getIP(vIP1), getIP(vIP2),getIP(vIP3), getIP(vIP4),getIP(vIP5), getIP(vIP6)
					,getIP(vIP7), getIP(vIP8),getIP(vIP9), getIP(vIP10));
			flag = "True";
		    return "pass";
		}
		if (vKeyword.equals("radio_selectPrice")){
			util.radio_selectPrice(getIP(vIP1), getIP(vIP2),getIP(vIP3), getIP(vIP4),getIP(vIP5), getIP(vIP6)
					,getIP(vIP7), getIP(vIP8),getIP(vIP9), getIP(vIP10),getIP(vIP11), getIP(vIP12)
					,getIP(vIP13), getIP(vIP14),getIP(vIP15), getIP(vIP16),getIP(vIP17), getIP(vIP18));
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
		if (vIP.equals("Photo")){
			vIP = StartUp.Photo;
		}
		if (vIP.equals("Sci_ID")){
			vIP = StartUp.Sci_ID;
		}
		if (vIP.equals("Sci_Name")){
			vIP = StartUp.Sci_Name;
		}
		if (vIP.equals("Detail")){
			vIP = StartUp.Detail;
		}
		if (vIP.equals("Staff")){
			vIP = StartUp.Staff;
		}
		if (vIP.equals("Course")){
			vIP = StartUp.Course;
		}
		
		//-------------------//
		if (vIP.equals("R_price")){
			vIP = StartUp.R_price;
		}
		if (vIP.equals("priceA")){
			vIP = StartUp.priceA;
		}
		if (vIP.equals("priceB")){
			vIP = StartUp.priceB;
		}
		if (vIP.equals("priceC")){
			vIP = StartUp.priceC;
		}
		if (vIP.equals("priceD")){
			vIP = StartUp.priceD;
		}
		if (vIP.equals("N_priceA")){
			vIP = StartUp.N_priceA;
		}
		if (vIP.equals("N_priceB")){
			vIP = StartUp.N_priceB;
		}
		if (vIP.equals("N_priceC")){
			vIP = StartUp.N_priceC;
		}
		if (vIP.equals("N_priceD")){
			vIP = StartUp.N_priceD;
		}
		//--------1----------//
		if (vIP.equals("R_price1")){
			vIP = StartUp.R_price1;
		}
		if (vIP.equals("priceA1")){
			vIP = StartUp.priceA1;
		}
		if (vIP.equals("priceB1")){
			vIP = StartUp.priceB1;
		}
		if (vIP.equals("priceC1")){
			vIP = StartUp.priceC1;
		}
		if (vIP.equals("priceD1")){
			vIP = StartUp.priceD1;
		}
		//---------2----------//
		if (vIP.equals("R_price2")){
			vIP = StartUp.R_price2;
		}
		if (vIP.equals("priceA2")){
			vIP = StartUp.priceA2;
		}
		if (vIP.equals("priceB2")){
			vIP = StartUp.priceB2;
		}
		if (vIP.equals("priceC2")){
			vIP = StartUp.priceC2;
		}
		if (vIP.equals("priceD2")){
			vIP = StartUp.priceD2;
		}
		//---------3----------//
		if (vIP.equals("R_price3")){
			vIP = StartUp.R_price3;
		}
		if (vIP.equals("priceA3")){
			vIP = StartUp.priceA3;
		}
		if (vIP.equals("priceB3")){
			vIP = StartUp.priceB3;
		}
		if (vIP.equals("priceC3")){
			vIP = StartUp.priceC3;
		}
		if (vIP.equals("priceD3")){
			vIP = StartUp.priceD3;
		}
		if (vIP.equals("selectT")){
			vIP = StartUp.selectT;
		}
		
	  return vIP;
	}
    //mapping to excel
	public void getData(int k) {
		StartUp.vUrl = StartUp.xTDdata[k][2];
		StartUp.Vuser = StartUp.xTDdata[k][4];
		StartUp.Vpwd = StartUp.xTDdata[k][5];
		StartUp.Photo = StartUp.xTDdata[k][6];
		StartUp.Sci_ID = StartUp.xTDdata[k][7];
		StartUp.Sci_Name = StartUp.xTDdata[k][8];
		StartUp.Detail = StartUp.xTDdata[k][9];
		StartUp.Staff = StartUp.xTDdata[k][10];
		StartUp.Course = StartUp.xTDdata[k][11];
		StartUp.R_price = StartUp.xTDdata[k][12];
		StartUp.priceA = StartUp.xTDdata[k][13];
		StartUp.priceB = StartUp.xTDdata[k][14];
		StartUp.priceC = StartUp.xTDdata[k][15];
		StartUp.priceD = StartUp.xTDdata[k][16];
		StartUp.N_priceA = StartUp.xTDdata[k][17];
		StartUp.N_priceB = StartUp.xTDdata[k][18];
		StartUp.N_priceC = StartUp.xTDdata[k][19];
		StartUp.N_priceD = StartUp.xTDdata[k][20];
		StartUp.R_price1 = StartUp.xTDdata[k][21];
		StartUp.priceA1 = StartUp.xTDdata[k][22];
		StartUp.priceB1 = StartUp.xTDdata[k][23];
		StartUp.priceC1 = StartUp.xTDdata[k][24];
		StartUp.priceD1 = StartUp.xTDdata[k][25];
		StartUp.R_price2 = StartUp.xTDdata[k][26];
		StartUp.priceA2 = StartUp.xTDdata[k][27];
		StartUp.priceB2 = StartUp.xTDdata[k][28];
		StartUp.priceC2 = StartUp.xTDdata[k][29];
		StartUp.priceD2 = StartUp.xTDdata[k][30];
		StartUp.R_price3 = StartUp.xTDdata[k][31];
		StartUp.priceA3 = StartUp.xTDdata[k][32];
		StartUp.priceB3 = StartUp.xTDdata[k][33];
		StartUp.priceC3 = StartUp.xTDdata[k][34];
		StartUp.priceD3 = StartUp.xTDdata[k][35];
		StartUp.selectT = StartUp.xTDdata[k][36];
		
	}
	
}