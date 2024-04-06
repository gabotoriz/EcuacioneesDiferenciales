package org.example.ecuacionesjava.Models;

import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
public class Question {
    int IdQuestion;
    String Question;
    String Option1;
    String Option2;
    String Option3;
    String Answer;
    int Points;


}
