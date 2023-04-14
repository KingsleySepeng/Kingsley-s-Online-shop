package com.example.demo7.resource;

public class resource {

//    public List<Customer> createCustomers(List<Customer> getCustomers) throws IOException {
//        BufferedWriter writer = new BufferedWriter(new FileWriter("/home/kingsley/Downloads/demo7/src/main/java/com/example/demo7/tblCustomer.txt", true));
//        customerService cs = new customerService();
//        for (Customer customer : getCustomers) {
//            writer.write(customer.getName() + ",");
//            writer.write(customer.getSurname() + ",");
//            writer.write(customer.getEmail() + ",");
//            writer.write(customer.getPassword() + ",");
//            writer.write(customer.getDOB());
//            writer.newLine();
//            writer.newLine();
//        }
//        writer.close();
//        return getCustomers;
//    }

    //read customers
//    public  boolean readUsers(String email, String password) {
//        try {
//            File myTxt = new File("/home/kingsley/Downloads/demo7/src/main/java/com/example/demo7/tblCustomer.txt");
//            Scanner read = new Scanner(myTxt);
//            boolean emailFound = false;
//            boolean passwordFound = false;
//            //------------------------------------------------
//            while (read.hasNextLine() && !(emailFound && passwordFound)) {
//                String found = read.nextLine();
//                if (found.contains(email) && found.contains(password)) {
//                    emailFound = true;
//                    passwordFound = true;
//                }
//            }
//            read.close();
//            if (emailFound && passwordFound) {
//                return true;
//            } else {
//                return false;
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        return false;
//    }

    //read products
//    public List<Product> readProductFromFile() throws IOException {
//        List<Product> products = new ArrayList<>();
//        BufferedReader reader = new BufferedReader(new FileReader("/home/kingsley/Downloads/demo7/src/main/java/com/example/demo7/tblProduct.txt"));
//        String line;
//
//        while ((line = reader.readLine()) != null) {
//            {
//                String[] parts = line.split(",");
//                int id = Integer.parseInt(parts[0]);
//                String photoPath = parts[1];
//                String productName = parts[2];
//                double price = Double.parseDouble(parts[3]);
//                int quantity = Integer.parseInt(parts[4]);
//                Product product = new Product(id, photoPath, productName, price, quantity);
//                products.add(product);
//            }
//        }
//        reader.close();
//        return products;
//    }

    //service
//    public List<Cart> getCartProducts(ArrayList<Cart> cartList) {
//        List<Cart> products = cartList;
//        Cart cart = new Cart();
//        try {
//            if (cartList.size() > 0) {
//                for (Cart ct : products) {
//                    cart.setId(ct.getId());
//                    cart.setProductImage(ct.getProductImage());
//                    cart.setProductName(ct.getProductName());
//                    cart.setPrice(ct.getPrice());
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        for(Cart c:products){
//            out.println(c);
//        }
//
//        return products;
//    }

//    public void printCart() throws IOException {
//        Cart ct = new Cart();
//        List<Cart> cartList = ct.getProducts();
//
//        BufferedWriter writer = new BufferedWriter(new FileWriter("/home/kingsley/Downloads/demo7/src/main/java/com/example/demo7/tblCart.txt"));
//        for (Cart cart : cartList) {
//            writer.write(cart.toString());
//            writer.newLine();
//            out.println(product);
//        }
//        writer.close();
//    }

//    public String removeUserRecord(String email, String password) throws FileNotFoundException {
//        File file = new File("/home/kingsley/Downloads/demo7/src/main/java/com/example/demo7/tblCustomer.txt");
//        BufferedReader rd = null;
//        PrintWriter wr = null;
//        try {
//            rd = new BufferedReader(new FileReader(file));
//            File tempFile = new File("/home/kingsley/Downloads/demo7/src/main/java/com/example/demo7/tblCustomer_temp.txt");
//            wr = new PrintWriter(new FileWriter(tempFile));
//
//            String line = rd.readLine();
//            boolean removed = false;
//            while (line != null) {
//                if (line.contains(email) && line.contains(password)) {
//                    removed = true;
//                } else {
//                    wr.println(line);
//                }
//                line = rd.readLine();
//            }
//            if (removed) {
//                file.delete();
//                tempFile.renameTo(file);
//                return "Removed";
//            } else {
//                return "Not found";
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//            return "Error";
//        } finally {
//            try {
//                if (rd != null) rd.close();
//                if (wr != null) wr.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }

}



