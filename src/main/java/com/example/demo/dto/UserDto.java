package com.example.demo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Id;
import java.util.UUID;

@Getter
@Setter
@ToString
@Builder
public class UserDto {
    @Id
    private UUID id;
    private String name;
    private String email;
    private String dob;
}
