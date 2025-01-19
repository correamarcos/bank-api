package correa.marcos.bank_api.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity(name = "cards")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,
            unique = true)
    private String number;

    @Column(name = "available_limit",
            nullable = false,
            scale = 2,
            precision = 13)
    private BigDecimal limit;

    @Column(nullable = false)
    private String validity;

    @Column(nullable = false)
    private String cvc;

    @Column(nullable = false)
    private Boolean blocked;

    @Column(nullable = false)
    private Boolean isDigital;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "conta_id")
    private Account account;

    public Card(Long id,
                String number,
                BigDecimal limit,
                String validity,
                String cvc,
                Boolean blocked,
                Boolean isDigital){
        this.id = id;
        this.number = number;
        this.limit = limit;
        this.validity = validity;
        this.cvc = cvc;
        this.blocked = blocked;
        this.isDigital = isDigital;
    }
}

