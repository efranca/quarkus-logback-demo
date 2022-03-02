package io.foo.now.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "project")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Project {

    @Id
    @SequenceGenerator(name = "id_seq", sequenceName = "id_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "id_seq", strategy = GenerationType.TABLE)
    private Long id;

    private String name;
}
