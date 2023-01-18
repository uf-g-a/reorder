package ru.ufimtsev.datasy.sickleave.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "sick_leave")
@AllArgsConstructor
@NoArgsConstructor
public class SickLeave {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private LocalDate dateBegin;
    private LocalDate dateEnd;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id")
    private Employee employee;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sick_type_id")
    private SickType sickType;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "add_code_id")
    private AddCodeType addCodeType;

}
