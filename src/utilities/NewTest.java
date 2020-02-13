package utilities;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import commonfunlibrary.ERP_Functions;

public class NewTest {
	ERP_Functions erp=new ERP_Functions();
	@BeforeMethod
	public void adminlogin()
	{
		erp.launchApp("http://webapp.qedge.com/login.php");
		erp.login("admin", "master");
		
		
	}
  @Test
  public void f() throws Exception {
	  ExcelFileUtil exl=new ExcelFileUtil();
	  int rc=exl.rowCount("SUPPLIER");
	  for(int i=1;i<=rc;i++){
		  String sname=exl.getData("supplier", i, 0);
			String address=exl.getData("supplier", i, 1);
			String city=exl.getData("supplier", i, 2);
			String country=exl.getData("supplier", i, 3);
			String pnumber=exl.getData("supplier", i, 4);
			String cperson=exl.getData("supplier", i, 5);
			String mail=exl.getData("supplier", i,6);
			String mnum=exl.getData("supplier", i, 7);
			String note=exl.getData("supplier", i, 8);
			erp.launchApp("http://webapp.qedge.com/login.php");
			erp.login("admin", "master");
			String result=erp.supplier(sname, address, city, country, cperson, pnumber, mail, mnum, note);
		
			erp.closebrw();
			exl.setData("supplier", i, 9, result);
	  }
	  
	  
  }
  @AfterMethod
  public void logout(){
	  erp.closebrw();
  }
}
