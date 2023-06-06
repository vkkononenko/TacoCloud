package de.vkononenko.TacoCloud.models;

import de.vkononenko.TacoCloud.models.base.EntityBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * The entity class of the orders of tacos
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TacoOrder extends EntityBase implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_taco_order")
    @SequenceGenerator(name = "seq_taco_order", allocationSize = 1)
    @Column(updatable = false)
    private Long id;

    //@NotBlank(message="Delivery name is required")
    private String deliveryName;

    //@NotBlank(message="Delivery street is required")
    private String deliveryStreet;

    //@NotBlank(message="Delivery city is required")
    private String deliveryCity;

    //@NotBlank(message="Delivery state is required")
    private String deliveryState;

    //@NotBlank(message="Delivery zip is required")
    private String deliveryZip;

    //@CreditCardNumber(message = "Not a credit card number")
    private String ccNumber;

    //@Pattern(regexp = "=\"^(0[1-9]|1[0-2])([\\\\/])([2-9][0-9])$",
    //message = "Must be formatted MM/YY")
    private String ccExpiration;

    //@Digits(integer = 3, fraction = 0, message = "Invalid CVV")
    private Integer ccCVV;

    @ManyToMany
    //@Size(min = 1, message = "Order should contain at least one taco")
    private List<Taco> tacos;
}
