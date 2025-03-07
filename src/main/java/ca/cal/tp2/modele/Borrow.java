package ca.cal.tp2.modele;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Getter;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "BORROWS")
@NoArgsConstructor
@Getter
public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "BORROWERID")
    private Borrower borrower;

    @OneToMany(mappedBy = "borrow", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<BorrowDetails> borrowDetailsList = new ArrayList<>();

    @Column(name = "BORROWDATE")
    private LocalDate borrowDate;

    @Column(name = "STATUS")
    private String status;

    public Borrow(LocalDate borrowDate, List<BorrowDetails> borrowDetailsList, String status) {
        this.borrowDate = borrowDate;
        this.borrowDetailsList = borrowDetailsList;
        this.status = status;
    }

    public int getTotalDocuments() {
        return borrowDetailsList.size();
    }

    public void updateStatus(String status) {
        this.status = status;
    }
}
