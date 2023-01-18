package ru.ufimtsev.datasy.vacation.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Data
@Entity
@Table(name = "vacation_type")
public class VacationType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String typeName;
    private Integer minVacationLen;
    private Integer maxVacationLen;
    /*@ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "vacationType")
    private  List<Vacation> vacations;*/
}
