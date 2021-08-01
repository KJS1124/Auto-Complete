package com.psg.autocomplete.dto;

import lombok.*;

import javax.validation.constraints.NotNull;

/**
 * @author Karanjot Singh
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DataNodeDto {
    @NotNull
    private String data;
}
