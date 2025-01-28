package com.ois3.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubjectDto {
    private Integer subjectId;
    private String subjectName;
    private String subjectCode;
    private Integer EAP;
    private String subjectDescription;
}
