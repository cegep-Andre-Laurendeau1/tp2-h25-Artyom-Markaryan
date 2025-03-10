package ca.cal.tp2.modele;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Table(name = "BORROWEDDOCUMENTS")
@NoArgsConstructor
@Getter
@Setter
public class BorrowedDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "BORROWID")
    private Borrow borrow;

    @ManyToOne
    @JoinColumn(name = "DOCUMENTID")
    private Document document;

    @Column(name = "BORROWDATE")
    private LocalDate borrowDate;

    @Column(name = "DUEDATE")
    private LocalDate dueDate;

    @Column(name = "RETURNDATE")
    private LocalDate returnDate;

    @Column(name = "STATUS")
    private String status;

    public BorrowedDocument(Borrow borrow, Document document, LocalDate borrowDate, LocalDate dueDate, LocalDate returnDate, String status) {
        this.borrow = borrow;
        this.document = document;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Document emprunté {" +
                " " + this.document.toString() +
                ", Date d'emprunt: " + this.borrowDate +
                ", Date d'échéance: " + this.dueDate +
                ", Date de retour: " + this.returnDate +
                ", Statut: " + this.status +
                " }";
    }
}
