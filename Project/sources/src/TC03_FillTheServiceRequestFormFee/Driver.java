package TC03_FillTheServiceRequestFormFee;
import org.openqa.selenium.NoSuchElementException;


public class Driver {
  
	
	private Utility util = new Utility();
	
	public Utility getUtility() {
		return util;
	}

	public String keyword_executor(String vKeyword, String vIP1, String vIP2, String vIP3, String vIP4, String vIP5, String vIP6
			, String vIP7, String vIP8, String vIP9, String vIP10, String vIP11, String vIP12
			, String vIP13, String vIP14, String vIP15, String vIP16, String vIP17, String vIP18) throws Exception {
		
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
		if (vKeyword.equals("radio_course")){
			util.radio_course(getIP(vIP1), getIP(vIP2),getIP(vIP3), getIP(vIP4),getIP(vIP5), getIP(vIP6),getIP(vIP7), getIP(vIP8),
					getIP(vIP9), getIP(vIP10),getIP(vIP11), getIP(vIP12),getIP(vIP13), getIP(vIP14),getIP(vIP15), getIP(vIP16)
					,getIP(vIP17), getIP(vIP18));
			flag = "True";
		    return "pass";
		}
		if (vKeyword.equals("serch_input")){
			util.serch_input(getIP(vIP1), getIP(vIP2),getIP(vIP3), getIP(vIP4),getIP(vIP5), getIP(vIP6),getIP(vIP7), getIP(vIP8));
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
		if (vKeyword.equals("get_text1")){
			String text = util.get_text1(getIP(vIP1));
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
		if (vIP.equals("Typeform")){
			vIP = StartUp.Typeform;
		}
		if (vIP.equals("Typework")){
			vIP = StartUp.Typework;
		}
		if (vIP.equals("OtherT_work")){
			vIP = StartUp.OtherT_work;
		}
		if (vIP.equals("Subj")){
			vIP = StartUp.Subj;
		}
		if (vIP.equals("Usage")){
			vIP = StartUp.Usage;
		}
		if (vIP.equals("Other_usage")){
			vIP = StartUp.Other_usage;
		}
		if (vIP.equals("Typetitle")){
			vIP = StartUp.Typetitle;
		}
		if (vIP.equals("Course_Type")){
			vIP = StartUp.Course_Type;
		}
		if (vIP.equals("ID_course")){
			vIP = StartUp.ID_course;
		}
		if (vIP.equals("Name_course")){
			vIP = StartUp.Name_course;
		}
		if (vIP.equals("Major")){
			vIP = StartUp.Major;
		}
		if (vIP.equals("Title")){
			vIP = StartUp.Title;
		}
		if (vIP.equals("Research_p")){
			vIP = StartUp.Research_p;
		}
		if (vIP.equals("Funding")){
			vIP = StartUp.Funding;
		}
		if (vIP.equals("Projectleader")){
			vIP = StartUp.Projectleader;
		}
		if (vIP.equals("Intrs")){
			vIP = StartUp.Intrs;
		}
		if (vIP.equals("S_Date")){
			vIP = StartUp.S_Date;
		}
		if (vIP.equals("E_Date")){
			vIP = StartUp.E_Date;
		}
		if (vIP.equals("Term")){
			vIP = StartUp.Term;
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
		StartUp.Typeform = StartUp.xTDdata[k][6];
		StartUp.Typework = StartUp.xTDdata[k][7];
		StartUp.OtherT_work = StartUp.xTDdata[k][8];
		StartUp.Subj = StartUp.xTDdata[k][9];
		StartUp.Usage = StartUp.xTDdata[k][10];
		StartUp.Other_usage = StartUp.xTDdata[k][11];
		StartUp.Typetitle = StartUp.xTDdata[k][12];
		StartUp.Course_Type = StartUp.xTDdata[k][13];
		StartUp.ID_course = StartUp.xTDdata[k][14];
		StartUp.Name_course = StartUp.xTDdata[k][15];
		StartUp.Major = StartUp.xTDdata[k][16];
		StartUp.Title = StartUp.xTDdata[k][17];
		StartUp.Research_p = StartUp.xTDdata[k][17];
		StartUp.Funding = StartUp.xTDdata[k][18];
		StartUp.Projectleader = StartUp.xTDdata[k][19];
		StartUp.Intrs = StartUp.xTDdata[k][20];
		StartUp.S_Date = StartUp.xTDdata[k][21];
		StartUp.E_Date = StartUp.xTDdata[k][22];
		StartUp.Term = StartUp.xTDdata[k][23];
		StartUp.xPath = StartUp.xTDdata[k][29];
		
	}
	
}