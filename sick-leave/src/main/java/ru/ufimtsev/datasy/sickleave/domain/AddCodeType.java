package ru.ufimtsev.datasy.sickleave.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "add_code_type")
@AllArgsConstructor
@NoArgsConstructor
public class AddCodeType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private int addCode;
    private String addDecode;
/*    @EqualsAndHashCode.Exclude
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "addCodeType")
    private List<SickLeave> sickLeaves;*/
}
