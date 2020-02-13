package utilities;

import commonfunlibrary.ERP_Functions;

public class DriverScript {

	public static void main(String[] args) throws Exception {
		ExcelFileUtil exl=new ExcelFileUtil();
		int rc=exl.rowCount("SUPPLIER");
		ERP_Functions erp=new ERP_Functions();
		
			for(int i=0;i<=rc;i++)
			{
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

}
