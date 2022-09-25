package TC02_RegisterAgency;

import java.text.DecimalFormat;

public class StartUp {
	
	public static String vUrl, Vuser, Vpwd, Vcpwd, VlistOc, VradioT,Vother,Vname,
	                     Vlastname,Vcompany,Vemail,Vphone,xPath;
	public static String vResult, vError, vflag; 
	public static String xTDdata[][];
	public static int passes, fails;
	public static double priority,dataAll;
	
	public void main() throws  Throwable {
		DecimalFormat df = new DecimalFormat();
		df.applyPattern("0.00");
		
		String xTSdata[][]; 
		String xTCdata[][]; 
		String vKeyword, vIP1, vIP2, vIP3, vIP4;
		String xlPath_tc = "c:/Users/saram/MiniProject65/Resultsummary/TC/TC02_RegisterAgency.xlsx";
		String xlPath_ts = "c:/Users/saram/MiniProject65/Resultsummary/TS/TS02_RegisterAgency.xlsx";
		String xlPath_td = "c:/Users/saram/MiniProject65/Resultsummary/TD/TD02_RegisterAgency.xlsx";
	    String xlPath ="c:/Users/saram/MiniProject65/Excel/TC02_RegisterAgency.xlsx";

		Driver myDriver = new Driver();
		
		ManageExcel kdf = new ManageExcel();
		xTCdata = kdf.xlRead(xlPath, 0);
		xTSdata = kdf.xlRead(xlPath, 1);
		xTDdata = kdf.xlRead(xlPath, 2);
		
		for (int i = 1; i < xTCdata.length; i++) {
			if (xTCdata[i][4].equals("Y")) {
		 		vflag = "Pass";
		 		dataAll = 0.00;
		 		//xTDdata.length
		 		for (int k = 1; k < xTDdata.length ; k++) {
					if (xTDdata[k][1].equals("Y")) {
						myDriver.getData(k);
						dataAll += 1;
					
					for (int j = 1; j <xTSdata.length; j++){
						if (xTCdata[i][1].equals(xTSdata[j][0])){	
							vKeyword = xTSdata[j][4];
							vIP1 = xTSdata[j][5];
							vIP2 = xTSdata[j][6];
							vIP3 = xTSdata[j][7];
							vIP4 = xTSdata[j][8];
							System.out.println("---" + vKeyword + "````" + vIP1 + "````" + vIP2);
							vResult = "Pass";
	                		vError = "No Error";
	                		vResult = myDriver.keyword_executor( vKeyword, vIP1, vIP2, vIP3, vIP4);
	                        
	                		if (vResult.equalsIgnoreCase("Pass")) {
	                			xTSdata[j][9] = "Pass";
	                		}else if(vResult.equalsIgnoreCase("Fail")) {
	                			xTSdata[j][9] = "Fail";
	                		}else {
	                			if(vKeyword.contains("get_text1")) {
	                				if(vKeyword.contains("")) {
		                					xTDdata[k][16] = "Fail";
		                					xTDdata[k][17] = vResult;
	                					}
	                				
	                				if(vResult.contains(xTDdata[k][15])) {
	                					xTDdata[k][16] = "Pass";
	                					xTDdata[k][17] = vResult;
                					}
	                				
	                				if(xTDdata[k][15].equals("สมัครสมาชิกสำเร็จ") && vResult.equals("สมัครสมาชิกสำเร็จ !!!!")) {
	                					xTDdata[k][17] = vResult;
	                					xTDdata[k][16] = "Pass";
	                					StartUp.xTDdata[k][18] = StartUp.vError;
	                				}else {
	                					xTDdata[k][17] = vResult;
	                					xTDdata[k][16] = "Fail";
	                					StartUp.xTDdata[k][18] = "Error : Not match expected result.";
	                					myDriver.getUtility().saveScreen(xTDdata[k][0]);  

	                				}
	                			}
	                		}
	                		
						  }
				        }

					System.out.println(StartUp.xTDdata[k][0]);
					System.out.println("Expected = " + StartUp.xTDdata[k][15]);
					System.out.println("Result = " + StartUp.xTDdata[k][16]);
					System.out.println("Actual = " + StartUp.xTDdata[k][17]);						
			}
					if (xTDdata[k][16] == "Fail") {
						fails += 1;
					} else if (xTDdata[k][16] == "Pass") {
						passes += 1;
					}
		}	
		 		if (fails != 0) {
					priority = 100.00 * (passes * 1.0 / (fails + passes));
					xTCdata[i][6] = passes + "";
					xTCdata[i][7] = fails + "";
					xTCdata[i][8] = (int) dataAll + "";
					xTCdata[i][9] = (int) priority + "%";
					if (xTCdata[i][5].equals("High")) {
						if (priority < 95) {
							xTCdata[i][10] = "Fail";
						} else {
							xTCdata[i][10] = vflag;
						}
					} else if (xTCdata[i][5].equals("Medium")) {
						if (priority < 97) {
							xTCdata[i][10] = "Fail";
						} else {
							xTCdata[i][10] = vflag;
						}
					} else if (xTCdata[i][5].equals("Low")) {
						if (priority < 100) {
							xTCdata[i][10] = "Fail";
						} else {
							xTCdata[i][10] = vflag;
						}
					}
				} else if (passes == 0) {
					priority = 0;
					xTCdata[i][6] = passes + "";
					xTCdata[i][7] = fails + "";
					xTCdata[i][8] = (int) dataAll + "";
					xTCdata[i][9] = (int) priority + "%";
					xTCdata[i][10] = "Fail";
				} else {
					priority = 100;
					xTCdata[i][6] = passes + "";
					xTCdata[i][7] = fails + "";
					xTCdata[i][8] = (int) dataAll + "";
					xTCdata[i][9] = (int) priority + "%";
					xTCdata[i][10] = vflag;
				}
		 		
		kdf.xlWrite(xlPath_tc, xTCdata, xTCdata.length, xTCdata[1].length);
		kdf.xlWrite(xlPath_ts, xTSdata, xTSdata.length, xTSdata[1].length);	
		kdf.xlWrite(xlPath_td, xTDdata, xTDdata.length, xTDdata[1].length);		
	  }		
    }
  }
		
}


	
