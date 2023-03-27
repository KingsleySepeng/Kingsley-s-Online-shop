package com.example.demo7.resource;

import com.example.demo7.domain.Admin;
import com.example.demo7.service.adminService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class adminResource {

    public List<Admin> readAllAdmins() throws IOException {
            List<Admin> adminList = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader("/home/kingsley/Downloads/demo7/src/main/java/com/example/demo7/tblAdmin.txt"));
            String line;

            while ((line = reader.readLine()) != null) {
                {
                    String[] parts = line.split(",");
                    String email = parts[0];
                    String login = parts[1];
                   Admin admin = new Admin(email, login);
                    adminList.add(admin);
                    System.out.println(admin);
                }
            }
            reader.close();
            adminService adminService = new adminService();
            return adminList;
    }

    public void writeAdmin(Admin admin) throws IOException {
        PrintWriter printWriter = new PrintWriter(System.out);
        printWriter.println(admin.getEmail());
        printWriter.println(admin.getPassword());
        BufferedWriter writer = new BufferedWriter(new FileWriter("/home/kingsley/Downloads/demo7/src/main/java/com/example/demo7/tblAdmin.txt",true));
        writer.newLine();
        writer.write(admin.getEmail());
        writer.write(admin.getPassword());
        writer.newLine();
        writer.close();
    }



    public void searchAdmin(){

    }

    public boolean readAdmin(Admin admin){
        try{
            File adminFile = new File("/home/kingsley/Downloads/demo7/src/main/java/com/example/demo7/tblAdmin.txt");
            Scanner read = new Scanner(adminFile);
            boolean emailFound = false;
            boolean passwordFound = false;
            String email = admin.getEmail();
            String password = admin.getPassword();
            while(read.hasNext()&& !(emailFound && passwordFound)){
                String found = read.next();
                if(found.contains(email) && found.contains(password)){
                    emailFound = true;
                    passwordFound = true;
                }
            }
            read.close();
            if(emailFound && passwordFound){
                return true;
            } else{
                return false;
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void removeAdmin(String email){

    }


}
