package ru.ufimtsev.datasy.sickleave.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "sick_type")
@AllArgsConstructor
@NoArgsConstructor
public class SickType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private int code;
    private String typeDecode;

/*    @EqualsAndHashCode.Exclude
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "sickType")
    private List<SickLeave> sickLeaves;*/
}
