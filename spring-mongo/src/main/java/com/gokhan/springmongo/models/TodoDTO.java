package com.gokhan.springmongo.models;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "todos")
public class TodoDTO {
    @Id
    private String id;
    @NotNull(message = "Todo cannot be null!")

    private String todo;

    @NotNull(message = "description cannot be null!")

    private String description;

    @NotNull(message = "completed cannot be null!")

    private Boolean completed;
    
    private Date createdAt;
    private Date updatedAt;
}
