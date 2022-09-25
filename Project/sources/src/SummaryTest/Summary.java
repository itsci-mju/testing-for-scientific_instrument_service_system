package SummaryTest;
import java.io.File;
import java.text.DecimalFormat;

public class Summary {
	
	  // public static void main(String[] args) throws  Throwable {  //เปิดตอนที่รันใน class Summary เท่านั้น 
		public void main() throws  Throwable {  //เปิดตอนที่รันรวม
	
		DecimalFormat df = new DecimalFormat();
		df.applyPattern("0.00");
		
		 
		String Xpath_file = "C:\\Users\\saram\\MiniProject65\\Resultsummary\\TD\\";
		String Writefile = "c:/Users/saram/MiniProject65/result/SummaryRusult.xlsx";
		
		
		String[][] xSum;
		
		ManageExcel kdf = new ManageExcel(); 
		File directory = new File(Xpath_file); 
		File[] fList = directory.listFiles();
		String[][] Testresult = new String[fList.length+2][6];
		int x = 1;
		int count_pass = 0;
		int count_fail = 0;
		
		Testresult[0][0] = "TestCase";
		Testresult[0][1] = "TestData";
		Testresult[0][2] = "Pass";
		Testresult[0][3] = "Fail";
		Testresult[0][4] = "%Pass";
		Testresult[0][5] = "%Fail";
		
		for (File file : fList){
			System.out.println(file.getName());
			
			
			xSum = kdf.xlRead(Xpath_file+file.getName(), 0);
			int Pass = 0;
			int fail = 0 ;
			for(int i=1;i<xSum.length;i++) {
				if(file.getName().equals("TD012_SubmitProofofPayment.xlsx")) {
					System.out.println("print : "+xSum[i][kdf.getxCols()-6]); 
					
					if(xSum[i][kdf.getxCols()-6].trim().equalsIgnoreCase("Pass")) {
						Pass++;
					}
					if(xSum[i][kdf.getxCols()-6].trim().equalsIgnoreCase("Fail")) {
						fail++;
					}
				}else {
					System.out.println("print : "+xSum[i][kdf.getxCols()-5]); 
					
					if(xSum[i][kdf.getxCols()-5].trim().equalsIgnoreCase("Pass")) {
						Pass++;
					}
					if(xSum[i][kdf.getxCols()-5].trim().equalsIgnoreCase("Fail")) {
						fail++;
					}
				}
			}
			Testresult[x][0] = ""+ file.getName();
			Testresult[x][1] = ""+ (Pass + fail);
			Testresult[x][2] = ""+ (Pass);
			Testresult[x][3] = ""+ (fail);
			Testresult[x][4] = ""+ df.format((Pass*100.00/(Pass + fail)));
			Testresult[x][5] = ""+ df.format((fail*100.00/(Pass + fail)));
			count_pass = count_pass+Pass;
			count_fail = count_fail+fail;
			x++;
			System.out.println(x);
			
		}
		
		
		Testresult[x][0] = "Total";
		Testresult[x][1] = ""+ (count_pass + count_fail);
		Testresult[x][2] = ""+ (count_pass);
		Testresult[x][3] = ""+ (count_fail);
		Testresult[x][4] = ""+ df.format((count_pass*100.00/(count_pass + count_fail)));
		Testresult[x][5] = ""+ df.format((count_fail*100.00/(count_pass + count_fail)));
		kdf.xlwrite(Writefile, Testresult, Testresult.length, Testresult[0].length);
		System.out.println("Summary is successful!!.");
		
	}

}

