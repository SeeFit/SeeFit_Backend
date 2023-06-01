package com.carespoon.oneMeal.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PredictResponseDto {
    String menuNames;
    double amount;
}