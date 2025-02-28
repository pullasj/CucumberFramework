////package org.QaScript.Utils;
//
//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//public class ExcelUtils {
//
//    private XSSFWorkbook workbook = null;  // Represents the Excel workbook
//    private FileInputStream fis = null;  // Input stream to read the file
//    private Sheet sheet = null;  // Represents a sheet within the workbook
//    private Row headerRow = null;  // The first row that contains column headers
//    private Row row = null;  // Represents a row in the sheet
//    private Cell cell = null;  // Represents a cell in a row
//    private int rowCount = 0;  // To store the number of rows in the sheet
//    private int colNum = 0;  // To store the column index of the desired column
//    private List<String> columnData = new ArrayList<>();  // List to store data from a specific column
//
//    /**
//     * Constructor to initialize the Excel file and open it.
//     *
//     * @param filePath The path of the Excel file.
//     */
//    public ExcelUtils(String filePath) {
//        try {
//            // Open the Excel file using FileInputStream
//            fis = new FileInputStream(filePath);
//            workbook = new XSSFWorkbook(fis);  // Load the workbook
//            fis.close();  // Close the FileInputStream after loading the workbook
//        } catch (IOException e) {
//            // If there's an error while loading the Excel file, throw a runtime exception with a message
//            System.err.println("Error loading Excel file: " + e.getMessage());
//            throw new RuntimeException(e);
//        }
//    }
//
//    /**
//     * Reads data from the specified column of a given sheet.
//     *
//     * @param sheetName The name of the sheet from which data is to be read.
//     * @param columnName The name of the column whose data needs to be fetched.
//     * @return A List of strings containing the data from the specified column.
//     */
//    public List<String> readExcelData(String sheetName, String columnName) {
//        // Get the specified sheet from the workbook
//        sheet = workbook.getSheet(sheetName);
//        if (sheet == null) {
//            throw new IllegalArgumentException("Sheet " + sheetName + " does not exist.");
//        }
//
//        // Get the first row (header row) to find the column index
//        headerRow = sheet.getRow(0);
//        if (headerRow == null) {
//            throw new IllegalArgumentException("Header row is missing in the sheet " + sheetName);
//        }
//
//        // Get the total number of rows in the sheet
//        rowCount = sheet.getPhysicalNumberOfRows();
//
//        // Loop through all the rows in the sheet
//        for (int j = 1; j < rowCount; j++) {  // Start from 1 to skip the header row
//            row = sheet.getRow(j);  // Get the current row
//            if (row == null) continue;
//
//            // Loop through all cells in the row to find the desired column
//            for (int i = 0; i < row.getLastCellNum(); i++) {
//                // Check if the current cell in the header matches the column name
//                if (headerRow.getCell(i).getStringCellValue().trim().equals(columnName.trim())) {
//                    colNum = i;  // Store the index of the column
//                    break;
//                }
//            }
//
//            // Get the value of the cell in the specified column and handle different types
//            cell = row.getCell(colNum);
//            if (cell != null) {
//                String cellValue = getCellValue(cell);
//                columnData.add(cellValue);
//            }
//        }
//
//        // Return the list containing the data from the specified column
//        return columnData;
//    }
//
//    /**
//     * Get the value of a cell based on its type.
//     *
//     * @param cell The cell whose value is to be retrieved.
//     * @return The value of the cell as a String.
//     */
//    private String getCellValue(Cell cell) {
//        String cellValue = "";
//        switch (cell.getCellType()) {
//            case STRING:
//                cellValue = cell.getStringCellValue().trim();
//                break;
//            case NUMERIC:
//                if (DateUtil.isCellDateFormatted(cell)) {
//                    // Handle date cells
//                    Date date = cell.getDateCellValue();
//                    cellValue = date.toString();
//                } else {
//                    // Handle numeric cells
//                    cellValue = String.valueOf(cell.getNumericCellValue());
//                }
//                break;
//            case BOOLEAN:
//                cellValue = String.valueOf(cell.getBooleanCellValue());
//                break;
//            case FORMULA:
//                cellValue = cell.getCellFormula();
//                break;
//            default:
//                cellValue = "";
//        }
//        return cellValue;
//    }
//}
