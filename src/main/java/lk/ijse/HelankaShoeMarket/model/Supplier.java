package lk.ijse.HelankaShoeMarket.model;

public class Supplier {
    private String Supplier_id;
    private String Supplier_name;
    private String Supplier_address;
    private String Supplier_tel;

    @Override
    public String toString() {
        return "Supplier{" +
                "Supplier_id='" + Supplier_id + '\'' +
                ", Supplier_name='" + Supplier_name + '\'' +
                ", Supplier_address='" + Supplier_address + '\'' +
                ", Supplier_tel='" + Supplier_tel + '\'' +
                '}';
    }

    public String getSupplier_id() {
        return Supplier_id;
    }

    public void setSupplier_id(String supplier_id) {
        Supplier_id = supplier_id;
    }

    public String getSupplier_name() {
        return Supplier_name;
    }

    public void setSupplier_name(String supplier_name) {
        Supplier_name = supplier_name;
    }

    public String getSupplier_address() {
        return Supplier_address;
    }

    public void setSupplier_address(String supplier_address) {
        Supplier_address = supplier_address;
    }

    public String getSupplier_tel() {
        return Supplier_tel;
    }

    public void setSupplier_tel(String supplier_tel) {
        Supplier_tel = supplier_tel;
    }

    public Supplier(String supplier_id, String supplier_name, String supplier_address, String supplier_tel) {
        Supplier_id = supplier_id;
        Supplier_name = supplier_name;
        Supplier_address = supplier_address;
        Supplier_tel = supplier_tel;
    }
}
