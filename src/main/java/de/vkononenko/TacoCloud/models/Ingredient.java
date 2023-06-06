package de.vkononenko.TacoCloud.models;

import de.vkononenko.TacoCloud.models.base.EntityBase;
import de.vkononenko.TacoCloud.models.enums.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * The entity class of the ingredients from which the taco will be made
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Ingredient extends EntityBase implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_ingredient")
    @SequenceGenerator(name = "seq_ingredient", allocationSize = 1)
    @Column(updatable = false)
    private Long id;

    private String name;

    private Type type;
}
