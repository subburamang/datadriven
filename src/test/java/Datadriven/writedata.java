package Datadriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class writedata {
 
	public static void data() throws IOException {
		File f= new File("C:\\Users\\windows 10\\Desktop\\subbu.xlsx");
		FileInputStream fis =new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		wb.createSheet("Data2").createRow(0).createCell(0).setCellValue("username");
		wb.getSheet("Data2").getRow(0).createCell(1).setCellValue("password");
		wb.getSheet("Data2").createRow(1).createCell(0).setCellValue("shiva");
		wb.getSheet("Data2").createRow(1).createCell(1).setCellValue("siva@123");
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);
		System.exit(0);
		System.out.println("Write successfully");
		
		wb.close();
		
	}
	public static void main(String[] args) throws IOException {
		data(); 
		
		
	}
}
