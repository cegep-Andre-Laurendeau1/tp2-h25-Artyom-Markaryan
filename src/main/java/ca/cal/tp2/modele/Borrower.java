package ca.cal.tp2.modele;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Getter;
import java.util.List;
import java.util.ArrayList;

@Entity
@NoArgsConstructor
@Getter
public class Borrower extends User {
    @OneToMany(mappedBy = "borrower", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Borrow> borrowsList = new ArrayList<>();

    @Column(name = "FINESBALANCE")
    private double finesBalance;

    public Borrower(String firstName, String lastName, String email, String phoneNumber) {
        super(firstName, lastName, email, phoneNumber);
    }

    @Override
    public String toString() {
        return "Emprunteur {" +
                " Prénom: " + super.firstName +
                ", Nom: " + super.lastName +
                ", Courriel: " + super.email +
                ", Numéro de Téléphone: " + super.phoneNumber +
                " }";
    }
}
