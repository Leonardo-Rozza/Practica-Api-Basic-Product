package com.leonardorozza.products.service.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record ProductDto(
        Long id,

        @NotBlank
        @Size(max = 70, message = "El nombre no puede superar los 70 caracteres.")
        String name,

        @NotBlank
        @Size(max = 500, message = "Descripción muy larga, por favor redúzcala a 500 caracteres.")
        String description,

        @NotNull(message = "El precio es obligatorio.")
        @Digits(integer = 10, fraction = 2, message = "El precio debe tener hasta 10 dígitos enteros y 2 decimales.")
        @DecimalMin(value = "0.00", inclusive = true, message = "El precio no puede ser negativo.")
        BigDecimal price,

        @NotNull(message = "El stock es obligatorio.")
        @PositiveOrZero(message = "El stock no puede ser negativo")
        int stock)
{
}
