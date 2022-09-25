package TC014_EditInstruments;

import java.text.DecimalFormat;

public class StartUp {
	
	public static String vUrl, Vuser, Vpwd,Photo,Sci_ID,Sci_Name,Detail,Staff,Course,
	                     R_price,priceA,priceB,priceC,priceD,N_priceA,N_priceB,N_priceC,N_priceD,
	                     R_price1,priceA1,priceB1,priceC1,priceD1,
	                     R_price2,priceA2,priceB2,priceC2,priceD2,
	                     R_price3,priceA3,priceB3,priceC3,priceD3,selectT;
	public static String vResult, vError, vflag; 
	public static String xTDdata[][];
	public static int passes, fails;
	public static double priority,dataAll;
	
	//public static void main(String[] args) throws Exception {
	public void main() throws  Throwable {
		DecimalFormat df = new DecimalFormat();
		df.applyPattern("0.00");
		
		String xTSdata[][]; 
		String xTCdata[][]; 
		String vKeyword, vIP1, vIP2, vIP3, vIP4, vIP5, vIP6, vIP7, vIP8, vIP9, vIP10, vIP11, vIP12, vIP13, vIP14, vIP15, vIP16
	       , vIP17, vIP18;
		String xlPath_tc = "c:/Users/saram/MiniProject65/Resultsummary/TC/TC014_EditInstruments.xlsx";
		String xlPath_ts = "c:/Users/saram/MiniProject65/Resultsummary/TS/TS014_EditInstruments.xlsx";
		String xlPath_td = "c:/Users/saram/MiniProject65/Resultsummary/TD/TD014_EditInstruments.xlsx";
	    String xlPath ="c:/Users/saram/MiniProject65/Excel/TC014_EditInstruments.xlsx";

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
							vIP5 = xTSdata[j][9];
							vIP6 = xTSdata[j][10];
							vIP7 = xTSdata[j][11];
							vIP8 = xTSdata[j][12];
							vIP9 = xTSdata[j][13];
							vIP10 = xTSdata[j][14];
							vIP11 = xTSdata[j][15];
							vIP12 = xTSdata[j][16];
							vIP13 = xTSdata[j][17];
							vIP14 = xTSdata[j][18];
							vIP15 = xTSdata[j][19];
							vIP16 = xTSdata[j][20];
							vIP17 = xTSdata[j][21];
							vIP18 = xTSdata[j][22];
							System.out.println("---" + vKeyword + "````" + vIP1 + "````" + vIP2);
							vResult = "Pass";
	                		vError = "No Error";
	                		vResult = myDriver.keyword_executor( vKeyword, vIP1, vIP2, vIP3, vIP4, vIP5, vIP6, vIP7, vIP8, vIP9, vIP10, vIP11, vIP12, vIP13, vIP14, vIP15, vIP16
	                			       , vIP17, vIP18);
	                        
	                		if (vResult.equalsIgnoreCase("Pass")) {
	                			xTSdata[j][23] = "Pass";
	                		}else if(vResult.equalsIgnoreCase("Fail")) {
	                			xTSdata[j][23] = "Fail";
	                		}else {
	                			String expected = xTDdata[k][37];
	                			if(vKeyword.contains("get_textAlert")) {
	                				if(vKeyword.contains("")) {
	                					xTDdata[k][38] = vResult;
	                					xTDdata[k][39] = "Fail";
	                				}
	                				if(vResult.equals(expected)) {
	                					xTDdata[k][39] = vResult;
	                					xTDdata[k][38] = "Pass";
	                					StartUp.xTDdata[k][40] = StartUp.vError;
	                				}else
	                				if(expected.equals("แก้ไขเครื่องมือวิทยาศาสตร์สำเร็จ") && vResult.equals("บันทึกสำเร็จสำเร็จ !!!!")) {
	                					xTDdata[k][39] = vResult;
	                					xTDdata[k][38] = "Pass";
	                					StartUp.xTDdata[k][40] = StartUp.vError;
	                				}else {
	                					xTDdata[k][39] = vResult;
	                					xTDdata[k][38] = "Fail";
	                					StartUp.xTDdata[k][40] = "Error : Not match expected result.";
	                					myDriver.getUtility().saveScreen(xTDdata[k][0]);  

	                				}
	                				
	                			}
	                		}
	                		
						  }
				        }

					System.out.println(StartUp.xTDdata[k][0]);
					System.out.println("Expected = " + StartUp.xTDdata[k][37]);
					System.out.println("Result = " + StartUp.xTDdata[k][38]);
					System.out.println("Actual = " + StartUp.xTDdata[k][39]);					
			}
					if (xTDdata[k][38] == "Fail") {
						fails += 1;
					} else if (xTDdata[k][38] == "Pass") {
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


	
