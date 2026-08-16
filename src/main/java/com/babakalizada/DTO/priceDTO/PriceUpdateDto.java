package com.babakalizada.DTO.priceDTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PriceUpdateDto {
    @NotNull(message = "Price field cannot be empty!")
    private Double price;
}
