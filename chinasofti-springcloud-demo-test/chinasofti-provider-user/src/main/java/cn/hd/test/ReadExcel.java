package cn.hd.test;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import cn.hd.entity.User;

public class ReadExcel {
	
	public static List<User> listUser = new ArrayList<User>();
	
	public static List<User> getData() {
		String excelPath = "d:\\t_user.xlsx";
		try {
			File excel = new File(excelPath);
			if (excel.isFile() && excel.exists()) {
				
				String[] split = excel.getName().split("\\.");//.是特殊字符，需要转义！！！！！
				Workbook wb = null;
				if ("xlsx".equals(split[1])) {
					wb = new XSSFWorkbook(excel);
				}else{
					System.out.println("文件类型错误!");
				}
				//开始解析
				Sheet sheet = wb.getSheetAt(0);
				int firstRowIndex = sheet.getFirstRowNum() +1;//第一行是列名，所以不读
				int lastRowIndex = sheet.getLastRowNum();
				System.out.println("firstRowIndex:" +firstRowIndex);
				System.out.println("lastRowIndex:" +lastRowIndex);
				
				for(int rIndex = firstRowIndex; rIndex <= lastRowIndex; rIndex++){//遍历行
					Row row = sheet.getRow(rIndex);//每一行Row数据
					User user = new User();
					if (row != null) {
						Cell cell = row.getCell(0);
						user.setId(cell.toString());//id
						
						Cell cell1 = row.getCell(1);
						user.setName(cell1.toString());//name
						
						Cell cell2 = row.getCell(2);
						user.setAge(cell2.toString());//age
						
						Cell cell3 = row.getCell(3);
						user.setAddress(cell3.toString());//address
						
						Cell cell4 = row.getCell(4);
						user.setBalance(cell4.toString());//balance
					}
					listUser.add(user);
				}
				
			}else{
				System.out.println("找不到指定文件");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listUser;
		
	}

}
