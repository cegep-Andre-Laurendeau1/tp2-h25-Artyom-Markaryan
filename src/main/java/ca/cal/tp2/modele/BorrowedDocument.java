package ca.cal.tp2.modele;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Getter;
import java.time.LocalDate;

@Entity
@Table(name = "BORROWEDDOCUMENTS")
@NoArgsConstructor
@Getter
public class BorrowedDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "ID")
    private Borrow borrow;

    @Column(name = "BORROWDATE")
    private LocalDate borrowDate;

    @Column(name = "DUEDATE")
    private LocalDate dueDate;

    @Column(name = "RETURNDATE")
    private LocalDate returnDate;

    @Column(name = "STATUS")
    private String status;

    public BorrowedDocument(LocalDate borrowDate, LocalDate dueDate, LocalDate returnDate, String status) {
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
        this.status = status;
    }

    public void updateStatus(String status) {
        this.status = status;
    }
}
