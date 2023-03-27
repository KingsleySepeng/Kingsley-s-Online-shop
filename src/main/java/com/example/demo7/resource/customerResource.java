package com.example.demo7.resource;

import com.example.demo7.domain.Customer;
import com.example.demo7.service.customerService;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class customerResource {
    public void createCustomers(List<Customer> getCustomers) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("/home/kingsley/Downloads/demo7/src/main/java/com/example/demo7/tblCustomer.txt", true));
        customerService cs = new customerService();
        for (Customer customer : getCustomers) {
            writer.write(customer.getName() + ",");
            writer.write(customer.getSurname() + ",");
            writer.write(customer.getEmail() + ",");
            writer.write(customer.getPassword() + ",");
            writer.write(customer.getDob());
            writer.newLine();
            writer.newLine();
        }
        writer.close();
    }

    public boolean readUsers(String email, String password) {
        try { //make variables descriptive
            File customerFile = new File("/home/kingsley/Downloads/demo7/src/main/java/com/example/demo7/tblCustomer.txt");
            Scanner read = new Scanner(customerFile);
            boolean emailFound = false;
            boolean passwordFound = false;
            //------------------------------------------------
            while (read.hasNextLine() && !(emailFound && passwordFound)) {
                String found = read.nextLine();
                if (found.contains(email) && found.contains(password)) {
                    emailFound = true;
                    passwordFound = true;
                }
            }
            read.close();
            if (emailFound && passwordFound) {
                return true;
            } else {
                return false;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
    //try with resoruces

    public void removeUserRecord(String email, String password) throws FileNotFoundException {
        File file = new File("/home/kingsley/Downloads/demo7/src/main/java/com/example/demo7/tblCustomer.txt");
        BufferedReader rd = null;
        PrintWriter wr = null;
        try {
            rd = new BufferedReader(new FileReader(file));
            File tempFile = new File("/home/kingsley/Downloads/demo7/src/main/java/com/example/demo7/tblCustomer_temp.txt");
            wr = new PrintWriter(new FileWriter(tempFile));

            String line = rd.readLine();
            boolean removed = false;
            while (line != null) {
                if (line.contains(email) && line.contains(password)) {
                    removed = true;
                } else {
                    wr.println(line);
                }
                line = rd.readLine();
            }
            if (removed) {
                file.delete();
                tempFile.renameTo(file);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rd != null) rd.close();
                if (wr != null) wr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
