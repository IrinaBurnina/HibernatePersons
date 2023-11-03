package ir.bu.hibernatepersons.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@Embeddable
public class Contact implements Serializable {
    @Column
    @NonNull
    private String name;
    @Column
    @NonNull
    private String surname;
    @Column
    @NonNull
    private int age;

    public Contact() {
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }
}
