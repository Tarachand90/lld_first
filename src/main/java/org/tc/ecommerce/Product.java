package org.tc.ecommerce;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Product {

    private String productName;
    private Double price;

}
