package lr8;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class Lr8_Example8 {
	public static void main(String[] args) throws IOException {
		var filePath = "Labs/src/lr8/example7/task.xlsx";

		var is = new FileInputStream(filePath);

		var workbook = new XSSFWorkbook(is);
		var sheet = workbook.getSheet("Товары");

		for (var row : sheet) {
			for (var cell : row) {
				System.out.print(cell.toString() + "\t");
			}
			System.out.println();
		}

		workbook.close();
		is.close();
	}
}
