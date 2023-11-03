package ir.bu.hibernatepersons.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
@Entity
@Table(name = "persons", schema = "homework")
public class Person {
    @EmbeddedId
    private Contact contact;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "city_of_living")
    private String cityOfLiving;

    public Person() {
    }

    @Override
    public String  toString() {
        return "Person{" +
                "contact=" + contact +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", cityOfLiving='" + cityOfLiving + '\'' +
                '}';
    }
}
