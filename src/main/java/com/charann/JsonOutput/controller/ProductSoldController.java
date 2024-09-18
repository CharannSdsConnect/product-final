package com.charann.JsonOutput.controller;

import com.charann.JsonOutput.entity.MonthlyProducts;
import com.charann.JsonOutput.entity.ProductSold;
import com.charann.JsonOutput.entity.YearlyProducts;
import com.charann.JsonOutput.service.ProductSoldService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class ProductSoldController {

    @Autowired
    ProductSoldService productSoldService;

    @PostMapping("/buy-products")
    public ResponseEntity<ProductSold> buyProduct(@RequestBody ProductSold productSold) {
        return new ResponseEntity<>(
                productSoldService.addSoldProduct(productSold),
                HttpStatus.CREATED);
    }

    @GetMapping("/monthly-sales-report")
    public ResponseEntity<String> monthlyReport() {
        return new ResponseEntity<>(
                productSoldService.monthlyReport(),
                HttpStatus.ACCEPTED);
    }

    @GetMapping("/most-sold-product")
    public ResponseEntity<String> mostSoldProduct() {
        return new ResponseEntity<>(
                productSoldService.mostSold(),
                HttpStatus.ACCEPTED
        );
    }

    @GetMapping("/yearly-sales-report")
    public ResponseEntity<String> yearlyReport() {
        return new ResponseEntity<>(
            productSoldService.yearlyReport(),
                HttpStatus.ACCEPTED
        );
    }

    @GetMapping("/daily-sales-report")
    public ResponseEntity<String> dailyReport() {
        return new ResponseEntity<>(
                productSoldService.dailyReport(),
                HttpStatus.ACCEPTED
        );
    }

    @GetMapping("/download-daily-report")
    public void generateDailyExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");

        String headerkey = "Content-Disposition";
        String headerValue = "attachment;filename=daily_report.xls";

        response.setHeader(headerkey, headerValue);

        productSoldService.generateDailyReport(response);
    }

    @GetMapping("/download-monthly-report")
    public void generateMonthlyExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");

        String headerkey = "Content-Disposition";
        String headerValue = "attachment;filename=monthly_report.xls";

        response.setHeader(headerkey, headerValue);

        productSoldService.generateMonthlyReport(response);
    }

    @GetMapping("/download-yearly-report")
    public void generateYearlyExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");

        String headerkey = "Content-Disposition";
        String headerValue = "attachment;filename=yearly_report.xls";

        response.setHeader(headerkey, headerValue);

        productSoldService.generateYearlyReport(response);
    }

    @GetMapping("/get-month-report/{month}")
    public ResponseEntity<List<MonthlyProducts>> monthlySale(@PathVariable String month) {
        return new ResponseEntity<>(
                productSoldService.getMonthlyProducts(month),
                HttpStatus.ACCEPTED);
    }

    @GetMapping("/get-yearly-report/{year}")
    public ResponseEntity<List<YearlyProducts>> yearlySale(@PathVariable String year) {
        return new ResponseEntity<>(
                productSoldService.getYearlyProducts(year),
                HttpStatus.ACCEPTED);
    }

    @GetMapping("/download-each-month-report")
    public void generateEacMonthExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");

        String headerkey = "Content-Disposition";
        String headerValue = "attachment;filename=single_month_report.xls";

        response.setHeader(headerkey, headerValue);

        productSoldService.generateEachMonthReport(response);
    }

    @GetMapping("/download-each-year-report")
    public void generateEacYearExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");

        String headerkey = "Content-Disposition";
        String headerValue = "attachment;filename=single_year_report.xls";

        response.setHeader(headerkey, headerValue);

        productSoldService.generateEachYearReport(response);
    }
}
