package com.gokhan.springpostgrerest.entities;



import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name="users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of={"id"})
@ToString
public class User {
    @Id
    @SequenceGenerator(name="user_sequence")
    @GeneratedValue(generator = "user_sequence",strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length =100, name="name")
    private String name;

    @Column(length =100, name="surname")
    private String surname;

    @OneToMany
    @JoinColumn(name = "user_address_id")
    List<Address> addresses;
}
