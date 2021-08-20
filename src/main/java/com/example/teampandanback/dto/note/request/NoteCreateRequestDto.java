package com.example.teampandanback.dto.note.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class NoteCreateRequestDto {
    private String title;
    private String content;
    private String deadline;
    private String step;

    @Builder
    public NoteCreateRequestDto(String title, String content, String deadline, String step) {
        this.title = title;
        this.content = content;
        this.deadline = deadline;
        this.step = step;
    }
}
