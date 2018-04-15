package cn.tju.selenium;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadTest {

	public static void main(String[] args) {

		try {
			// 指定excel的路径
			File src = new File("input.xlsx");

			// 加载文件
			FileInputStream fis = new FileInputStream(src);

			// 加载workbook
			@SuppressWarnings("resource")
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// 加载sheet，这里我们只有一个sheet,默认是sheet1
			XSSFSheet sh1 = wb.getSheetAt(0);

			for (int i = 0; i < sh1.getPhysicalNumberOfRows(); i++) {
				// 开始读取第i+1行第一列的数据
				System.out.println(sh1.getRow(i).getCell(0)
						.getStringCellValue());
				// 读取第i+1行第二列内容
				System.out.println(sh1.getRow(i).getCell(0)
						.getStringCellValue().substring(4));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
