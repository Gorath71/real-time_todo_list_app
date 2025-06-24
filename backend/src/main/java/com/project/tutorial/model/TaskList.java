package com.project.tutorial.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TaskList {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private User owner;

    @OneToMany(mappedBy = "taskList", cascade = CascadeType.ALL)
    @Column(nullable = false)
    @JsonIgnoreProperties("taskList")
    private List<Task> tasks;
}
