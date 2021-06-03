package io.yadnyesh.simplecourselistapp.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Course {
    private Long courseId;
    private String title;
    private String description;
}
