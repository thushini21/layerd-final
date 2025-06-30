package lk.ijse.HelankaShoeMarket.model;

public class Product {
    private String product_id;
    private int product_qty_on_hand;
    private double unit_price;
    private String description;
    private String design;
    private String material_id;

    public String getMaterial_id() {
        return material_id;
    }

    public void setMaterial_id(String material_id) {
        this.material_id = material_id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_id='" + product_id + '\'' +
                ", product_qty_on_hand='" + product_qty_on_hand + '\'' +
                ", unit_price='" + unit_price + '\'' +
                ", description='" + description + '\'' +
                ", design='" + design + '\'' +
                ", material_id='" + material_id + '\'' +

                '}';
    }


    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public int getProduct_qty_on_hand() {
        return product_qty_on_hand;
    }

    public void setProduct_qty_on_hand(int product_qty_on_hand) {
        this.product_qty_on_hand = product_qty_on_hand;
    }

    public double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(double unit_price) {
        this.unit_price = unit_price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDesign() {
        return design;
    }

    public void setDesign(String design) {
        this.design = design;
    }

    public Product(String product_id, int product_qty_on_hand, double unit_price, String description, String design , String material_id) {
        this.product_id = product_id;
        this.product_qty_on_hand = product_qty_on_hand;
        this.unit_price = unit_price;
        this.description = description;
        this.design = design;
        this.material_id = material_id;

    }


}
