package cn.tju.selenium;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadTest {

	public static void main(String[] args) {

		try {
			// ָ��excel��·��
			File src = new File("input.xlsx");

			// �����ļ�
			FileInputStream fis = new FileInputStream(src);

			// ����workbook
			@SuppressWarnings("resource")
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// ����sheet����������ֻ��һ��sheet,Ĭ����sheet1
			XSSFSheet sh1 = wb.getSheetAt(0);

			for (int i = 0; i < sh1.getPhysicalNumberOfRows(); i++) {
				// ��ʼ��ȡ��i+1�е�һ�е�����
				System.out.println(sh1.getRow(i).getCell(0)
						.getStringCellValue());
				// ��ȡ��i+1�еڶ�������
				System.out.println(sh1.getRow(i).getCell(0)
						.getStringCellValue().substring(4));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
