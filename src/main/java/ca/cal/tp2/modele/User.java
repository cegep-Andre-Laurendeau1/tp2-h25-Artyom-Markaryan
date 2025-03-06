package ca.cal.tp2.modele;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Getter;

@Entity
@Table(name = "USERS")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@NoArgsConstructor
@Getter
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long id;

    @Column(name = "FIRSTNAME")
    protected String firstName;

    @Column(name = "LASTNAME")
    protected String lastName;

    @Column(name = "EMAIL")
    protected String email;

    @Column(name = "PHONENUMBER")
    protected String phoneNumber;

    public User(String firstName, String lastName, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
