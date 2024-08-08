package com.example.ExcelFile_Generator.service;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public class ExcelService {


    public byte[] generateExcelFile() throws IOException {
        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            Sheet sheet = workbook.createSheet("Sheet1");
            Row headerRow = sheet.createRow(0);
            Cell headerCell1 = headerRow.createCell(0);
            headerCell1.setCellValue("ID");
            Cell headerCell2 = headerRow.createCell(1);
            headerCell2.setCellValue("Name");
            Row row = sheet.createRow(1);
            Cell cell1 = row.createCell(0);
            cell1.setCellValue(1);
            Cell cell2 = row.createCell(1);
            cell2.setCellValue("John Doe");
            workbook.write(baos);
            return baos.toByteArray();
        }
    }
}
