package lk.ijse.HelankaShoeMarket.model.Tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class CustomerTm {
    private String Customer_id;
    private String Customer_name;
    private String Customer_address;
    private String Customer_tel;
}
