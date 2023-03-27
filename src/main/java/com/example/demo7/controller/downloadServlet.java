package com.example.demo7.controller;

import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet(name = "downloadServlet", value = "/downloadServlet")
public class downloadServlet extends HttpServlet {
    private static final int BYTES_DOWNLOAD = 1024; //common buffer size

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, IOException {
        String filepath = "/home/kingsley/Downloads/demo7/src/main/java/com/example/demo7/tblCart.txt";

        File file = new File(filepath);
        FileInputStream in = new FileInputStream(file);

        response.setContentType("text/plain");
        response.setHeader("Content-Disposition", "attachment; filename");

        ServletOutputStream out = response.getOutputStream();

        byte[] buffer = new byte[BYTES_DOWNLOAD];
        int bytesRead = 0;
        while ((bytesRead = in.read(buffer)) != -1) {
            out.write(buffer, 0, bytesRead);
        }
        in.close();
        out.flush();
        out.close();
    }
}
