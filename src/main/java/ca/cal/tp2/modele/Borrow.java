package ca.cal.tp2.modele;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "BORROWS")
@NoArgsConstructor
@Getter
@Setter
public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "BORROWERID")
    private Borrower borrower;

    @OneToMany(mappedBy = "borrow", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<BorrowedDocument> borrowedDocumentsList = new ArrayList<>();

    @Column(name = "BORROWDATE")
    private LocalDate borrowDate;

    @Column(name = "STATUS")
    private String status;

    public Borrow(Borrower borrower, LocalDate borrowDate, String status) {
        this.borrower = borrower;
        this.borrowDate = borrowDate;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Emprunt {" +
                " " + borrowedDocumentsList +
                ", Date: " + this.borrowDate +
                ", Statut: " + this.status +
                " }";
    }
}
