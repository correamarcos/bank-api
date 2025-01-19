package correa.marcos.bank_api.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity(name = "accounts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,
            unique = true)
    private String number;

    @Column(nullable = false)
    private String agency;

    @Column(nullable = false,
            scale = 2,
            precision = 13)
    private BigDecimal balance;

    @Column(name = "additional_limit",
            nullable = false,
            scale = 2,
            precision = 13)
    private BigDecimal limit;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "account",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Card> cards;

    public Account(Long id,
                   String number,
                   String agency,
                   BigDecimal balance,
                   BigDecimal limit){
        this.id = id;
        this.number = number;
        this.agency = agency;
        this.balance = balance;
        this.limit = limit;
    }
}
