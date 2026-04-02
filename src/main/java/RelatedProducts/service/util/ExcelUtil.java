package RelatedProducts.service.util;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtil {
    public static List<List<Object>> getDataFromFile(String filePath, boolean hasHeader) throws IOException {
        List<List<Object>> data = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = WorkbookFactory.create(fis)){
            Sheet sheet = workbook.getSheetAt(workbook.getActiveSheetIndex());

            int startRow = hasHeader ? 1 : 0;

            for (int i = startRow; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);

                Cell firstCell = row.getCell(0);
                if (firstCell == null || isCellEmpty(firstCell)) {
                    continue;
                }

                List<Object> rowData = new ArrayList<>();

                for (int j = 0; j < row.getLastCellNum(); j++) {
                    rowData.add(getCellValue(row.getCell(j)));
                }
                data.add(rowData);
            }
        }
        return data;
    }
    public static boolean isCellEmpty(Cell cell) {
        if (cell == null) return true;
        String value = cell.toString().trim();
        return value.isEmpty() || value.equalsIgnoreCase("null");
    }
    public static Object getCellValue(Cell cell) {
        if (cell == null) return null;

        return switch (cell.getCellType()) {
            case NUMERIC -> {
                if (DateUtil.isCellDateFormatted(cell)) {
                    yield cell.getLocalDateTimeCellValue();
                }
                yield cell.getNumericCellValue();
            }
            case STRING -> cell.getStringCellValue().trim();
            case BOOLEAN -> cell.getBooleanCellValue();
            case FORMULA -> cell.getCellFormula();
            default -> null;
        };

    }
}
