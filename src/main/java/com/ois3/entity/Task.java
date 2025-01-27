package com.ois3.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "task")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer taskId;

    @Column(name = "task_name", length = 100, nullable = false)
    private String taskName;

    @Column(name = "max_points")
    private Integer maxPoints;

    @Column(name = "description", length = 1000)
    private String description;
}
