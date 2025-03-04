package com.landingis.api.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.landingis.api.enumeration.CourseState;
import com.landingis.api.model.audit.Auditable;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "`courses`")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class Course extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String code;

    @Enumerated(EnumType.STRING)
    private CourseState status;

    @JsonIgnore
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserCourse> userCourses = new ArrayList<>();
}
