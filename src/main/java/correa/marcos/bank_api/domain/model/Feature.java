package correa.marcos.bank_api.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity(name = "features")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Feature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String cod;

    private String icon;

    @Column(nullable = false)
    private String description;

    @ManyToMany(mappedBy = "features")
    private List<User> users;

    public Feature(Long id,
                   String cod,
                   String icon,
                   String description) {
        this.id = id;
        this.cod = cod;
        this.icon = icon;
        this.description = description;
    }
}
