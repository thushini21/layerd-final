package lk.ijse.HelankaShoeMarket.model;

public class Material {
    private String material_id;
    private int material_qty_on_hand;
    private double unit_cost ;
    private String description ;
    private String design;
    private String supplier_id ;

    @Override
    public String toString() {
        return "Material{" +
                "material_id='" + material_id + '\'' +
                ", material_qty_on_hand=" + material_qty_on_hand +
                ", unit_cost=" + unit_cost +
                ", description='" + description + '\'' +
                ", design='" + design + '\'' +
                ", supplier_id='" + supplier_id + '\'' +
                '}';
    }

    public String getMaterial_id() {
        return material_id;
    }

    public int getMaterial_qty_on_hand() {
        return material_qty_on_hand;
    }

    public double getUnit_cost() {
        return unit_cost;
    }

    public String getDescription() {
        return description;
    }

    public String getDesign() {
        return design;
    }

    public String getSupplier_id() {
        return supplier_id;
    }

    public void setMaterial_id(String material_id) {
        this.material_id = material_id;
    }

    public void setMaterial_qty_on_hand(int material_qty_on_hand) {
        this.material_qty_on_hand = material_qty_on_hand;
    }

    public void setUnit_cost(double unit_cost) {
        this.unit_cost = unit_cost;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDesign(String design) {
        this.design = design;
    }

    public void setSupplier_id(String supplier_id) {
        this.supplier_id = supplier_id;
    }

    public Material(String material_id, int material_qty_on_hand, double unit_cost, String description, String design, String supplier_id) {
        this.material_id = material_id;
        this.material_qty_on_hand = material_qty_on_hand;
        this.unit_cost = unit_cost;
        this.description = description;
        this.design = design;
        this.supplier_id = supplier_id;
    }
}
