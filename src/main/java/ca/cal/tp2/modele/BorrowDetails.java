package ca.cal.tp2.modele;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Getter;
import java.time.LocalDate;

@Entity
@Table(name = "BORROWDETAILS")
@NoArgsConstructor
@Getter
public class BorrowDetails {
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

    public BorrowDetails(LocalDate borrowDate, LocalDate dueDate, LocalDate returnDate, String status) {
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
        this.status = status;
    }

    public void updateStatus(String status) {
        this.status = status;
    }
}
