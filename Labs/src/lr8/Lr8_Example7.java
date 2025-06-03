package lr8;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class Lr8_Example7 {
	public static void main(String[] args) throws IOException {
		var workbook = new XSSFWorkbook();
		var sheet = workbook.createSheet("Товары");

		var row = sheet.createRow(0);
		row.createCell(0).setCellValue("Товар");
		row.createCell(1).setCellValue("Характеристики");
		row.createCell(2).setCellValue("Стоимость");

		var row2 = sheet.createRow(1);
		row2.createCell(0).setCellValue("Книга");
		row2.createCell(1).setCellValue("Жанр: Фантастика, Автор: Иванов И.И");
		row2.createCell(2).setCellValue(500.0);

		var row3 = sheet.createRow(2);
		row3.createCell(0).setCellValue("Компьютер");
		row3.createCell(1).setCellValue("Процессор: AMD Ryzen 5 7600X, RAM: 32 GB, GPU: 6750 GRE 12GB");
		row3.createCell(2).setCellValue(25000.0);

		var filePath = "Labs/src/lr8/example7/task.xlsx";
		var os = new FileOutputStream(filePath);
		workbook.write(os);
		workbook.close();
		os.close();

		System.out.println("Данные записаны");
	}
}
