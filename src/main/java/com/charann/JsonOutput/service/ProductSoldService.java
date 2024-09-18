package com.charann.JsonOutput.service;

import com.charann.JsonOutput.entity.*;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface ProductSoldService {
    Optional<ProductSold> getProductById(Long id);

    ProductSold addSoldProduct(ProductSold productSold);

    String monthlyReport();

//    TotalSales getTotalSales();

    String mostSold();

    String yearlyReport();

    String dailyReport();

    ProductSold updateProductSold(String sku);

    void generateMonthlyReport(HttpServletResponse response) throws IOException;

    void generateYearlyReport(HttpServletResponse response) throws IOException;

    void generateDailyReport(HttpServletResponse response) throws IOException;

    List<MonthlyProducts> getMonthlyProducts(String month);

    List<YearlyProducts> getYearlyProducts(String year);

    void generateEachMonthReport(HttpServletResponse response) throws IOException;

    void generateEachYearReport(HttpServletResponse response) throws IOException;

}

