package ca.cal.tp2.modele;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Getter;
import java.time.LocalDate;

@Entity
@Table(name = "FINES")
@NoArgsConstructor
@Getter
public class Fine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "BORROWERID")
    private Borrower borrower;

    @Column(name = "AMOUNT")
    private double amount;

    @Column(name = "CREATIONDATE")
    private LocalDate creationDate;

    @Column(name = "PAID")
    private boolean paid = false;

    public Fine(double amount, LocalDate creationDate) {
        this.amount = amount;
        this.creationDate = creationDate;
    }

    public void updateStatus(boolean isPaid) {
        this.paid = isPaid;
    }
}
