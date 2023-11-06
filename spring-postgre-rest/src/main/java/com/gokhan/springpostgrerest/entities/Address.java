package com.gokhan.springpostgrerest.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name="user_address")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of={"id"})
@ToString
public class Address {
    @Id
    @SequenceGenerator(name="user_address_sequence")
    @GeneratedValue(generator = "user_address_sequence",strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length =500, name="address")
    private String address;

    @Enumerated
    private AddressType addressType;

    @Column( name="active")
    private Boolean active;

    @ManyToOne()
    @JoinColumn(name="user_address_id")
    private User user;

    public enum AddressType{
        HOME_ADDRESS,
        WORKER_ADDRESS,
        OTHER

    }
}
