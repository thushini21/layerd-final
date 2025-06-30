package lk.ijse.HelankaShoeMarket.model;


public  class Customer {
    private String Customer_id;
    private String Customer_name;
    private String Customer_address;
    private String Customer_tel;

    public String getCustomer_id() {
        return Customer_id;
    }

    public void setCustomer_id(String customer_id) {
        Customer_id = customer_id;
    }

    public String getCustomer_name() {
        return Customer_name;
    }

    public void setCustomer_name(String customer_name) {
        Customer_name = customer_name;
    }

    public String getCustomer_address() {
        return Customer_address;
    }

    public void setCustomer_address(String customer_address) {
        Customer_address = customer_address;
    }

    public String getCustomer_tel() {
        return Customer_tel;
    }

    public void setCustomer_tel(String customer_tel) {
        Customer_tel = customer_tel;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + Customer_id + '\'' +
                ", name='" + Customer_name + '\'' +
                ", address='" + Customer_address + '\'' +
                ", tel='" + Customer_tel + '\'' +
                '}';
    }

    public String getId() {
        return Customer_id;
    }

    public void setId(String id) {
        this.Customer_id = id;
    }


    public Customer(String id, String name, String address, String tel) {
        this.Customer_id = id;
        this.Customer_name = name;
        this.Customer_address = address;
        this.Customer_tel = tel;
    }


    public String generateNextCustomer() {
        return null;
    }

    public String generateNextOrderID() {
        return null;
    }

    public boolean isValidCustomer(Customer customerRepo) {
        return false;
    }

    public void save(Customer customerRepo) {

    }

    public String getName() {

        return null;

    }
}