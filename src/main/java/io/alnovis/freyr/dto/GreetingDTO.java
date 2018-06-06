package io.alnovis.freyr.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class GreetingDTO {

    private final long id;
    private final String content;

    public GreetingDTO(long id, String content) {
        this.id = id;
        this.content = content;
    }
}
