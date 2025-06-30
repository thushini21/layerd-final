package lk.ijse.HelankaShoeMarket.model.Tm;

import com.jfoenix.controls.JFXButton;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartTm {
    private String product_id;
    private String description;
    private int qty;
    private double unitPrice;
    private double total;
    private JFXButton btnRemove;

}
