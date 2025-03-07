package ca.cal.tp2.modele;

import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;
import lombok.Getter;

@Entity
@NoArgsConstructor
@Getter
public class Librarian extends User {
    public Librarian(String firstName, String lastName, String email, String phoneNumber) {
        super(firstName, lastName, email, phoneNumber);
    }

    @Override
    public String toString() {
        return "Bibliothécaire {" +
                " Prénom: " + super.firstName +
                ", Nom: " + super.lastName +
                ", Courriel: " + super.email +
                ", Numéro de Téléphone: " + super.phoneNumber +
                " }";
    }
}
