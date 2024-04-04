package com.example.niitiproduct.helpers;

import com.example.niitiproduct.models.Category;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Csv {
    public static String TYPE = "text/csv";
    public static String[] HEADERs = {"Tên danh mục", "Tóm tắt", "Mô tả"};

    public static boolean checkCsvFormat(MultipartFile file) {
        if (!TYPE.equals(file.getContentType())) {
            return false;
        }
        return true;
    }

    public static List<Category> csvToCategoryList(InputStream is) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
             CSVParser csvParser = new CSVParser(bufferedReader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim())
        ) {
            List<Category> categoryList = new ArrayList<Category>();
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            for (CSVRecord csvRecord: csvRecords) {
                Category category = new Category();
                category.setName(csvRecord.get("Tên danh mục"));
                category.setSlug(csvRecord.get("Slug"));
                category.setImage(csvRecord.get("Hình ảnh minh họa"));
                category.setSummary(csvRecord.get("Tóm tắt"));
                category.setDescription(csvRecord.get("Mô tả"));
                category.setDisplay_order(null);
                category.setIs_actived(1);
                category.setCreated_at(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                category.setCreated_by(String.valueOf(1));
                category.setUpdated_at(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                category.setUpdated_by(String.valueOf(1));
                categoryList.add(category);
            }
            return categoryList;
        } catch (IOException e) {
            throw new RuntimeException("CSV data is failed to parse: " + e.getMessage());
        }
    }
}
