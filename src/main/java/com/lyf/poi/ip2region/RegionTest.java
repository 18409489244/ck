package com.lyf.poi.ip2region;

import lombok.Cleanup;
import org.lionsoul.ip2region.xdb.Searcher;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @program: codepractice
 * @description: ip归属
 * @author: 刘耀福
 * @create: 2023-09-26 16:22
 **/
public class RegionTest {
    private static Searcher searcher;

    public String getIpAddress(String ip){
        if ("127.0.0.1".equals(ip) || ip.startsWith("192.168")) {
            return "|||局域网ip";

        }
        if (searcher == null) {
            try {
                File file = ResourceUtils.getFile("classpath:db/data_ip2region.xdb");
                String dbPath = file.getPath();
                searcher = Searcher.newWithFileOnly(dbPath);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String region = null;
        String errorMessage = null;
        try {
            region = searcher.search(ip);
        } catch (Exception e) {
            errorMessage = e.getMessage();
            if (errorMessage != null && errorMessage.length() > 256) {
                errorMessage = errorMessage.substring(0, 256);
            }
            e.printStackTrace();
        }
        // 输出 region
        System.out.println(region);
        return region;
    }

    public static String getIpCity(String ip) {
        if ("127.0.0.1".equals(ip) || ip.startsWith("192.168")) {
            return "|||局域网ip";

        }
        if (searcher == null) {
            try {
                //本地环境需要加上 classpath:
//                File file = ResourceUtils.getFile("db/data_ip2region.xdb");
//                String dbPath = file.getPath();
//                searcher = Searcher.newWithFileOnly(dbPath);
                //这里通过流获取 解决jar包无法读取文件问题
                ResponseEntity<byte[]> test = test("db/data_ip2region.xdb");
                searcher = Searcher.newWithBuffer(test.getBody());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String region = null;
        String errorMessage = null;
        try {
            region = searcher.search(ip);
        } catch (Exception e) {
            errorMessage = e.getMessage();
            if (errorMessage != null && errorMessage.length() > 256) {
                errorMessage = errorMessage.substring(0, 256);
            }
            e.printStackTrace();
        }
        // 输出 region
        return region;
    }

    public static ResponseEntity<byte[]> test(String templateName) throws IOException {
        ClassPathResource classPathResource = new ClassPathResource(templateName);
        String filename = classPathResource.getFilename();
        @Cleanup InputStream inputStream = classPathResource.getInputStream();
        byte[] bytes = FileCopyUtils.copyToByteArray(inputStream);
        String fileName = new String(filename.getBytes("UTF-8"), "iso-8859-1");// 为了解决中文名称乱码问题
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", fileName);
        return new ResponseEntity<>(bytes, headers, HttpStatus.CREATED);
    }


    public static void main(String[] args) {
        getIpCity("192.168.10.23");
    }
}
