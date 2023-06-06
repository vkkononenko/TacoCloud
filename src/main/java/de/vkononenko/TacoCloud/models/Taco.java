package de.vkononenko.TacoCloud.models;

import de.vkononenko.TacoCloud.models.base.EntityBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

/**
 * The entity class of the tacos which has been made by users of application
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Taco extends EntityBase implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_taco")
    @SequenceGenerator(name = "seq_taco", allocationSize = 1)
    @Column(updatable = false)
    private Long id;

    @NotBlank(message = "Taco should be named")
    private String name;

    @ManyToMany
    @Size(min = 1, message = "Taco should have at least 1 ingredient")
    private List<Ingredient> ingredients;
}
