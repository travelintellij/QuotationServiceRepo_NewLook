package com.travelintellij.quotation.service;

import java.util.Map;

public interface  QuotationGenerateService {
    void generatePdfFile(String templateName, Map<String, Object> data, String pdfFileName);
}
