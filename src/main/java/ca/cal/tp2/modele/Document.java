package ca.cal.tp2.modele;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Getter;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

@Entity
@Table(name = "DOCUMENTS")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@NoArgsConstructor
@Getter
public abstract class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long id;

    @OneToMany(mappedBy = "document", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    protected List<BorrowDetails> borrowDetailsList = new ArrayList<>();

    @Column(name = "TITLE")
    protected String title;

    @Column(name = "AUTHOR")
    protected String author;

    @Column(name = "DATEPUBLISHED")
    protected LocalDate datePublished;

    public Document(String title, String author, LocalDate datePublished) {
        this.title = title;
        this.author = author;
        this.datePublished = datePublished;
    }
}
