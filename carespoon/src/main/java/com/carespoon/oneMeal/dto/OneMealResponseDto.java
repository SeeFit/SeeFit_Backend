package com.carespoon.oneMeal.dto;

import com.carespoon.oneMeal.domain.OneMeal;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

import java.util.Date;

@Getter
public class OneMealResponseDto {

    private Long id;
    private double meal_Kcal;
    private double meal_Carbon;
    private double meal_Fat;
    private double meal_Protein;

    private String eatDate;
    private String eatMonth;
    private String imageUrl;

    public OneMealResponseDto(OneMeal entity){
        this.id = entity.getId();
        this.meal_Kcal = entity.getMeal_Kcal();
        this.meal_Fat = entity.getMeal_Fat();
        this.meal_Carbon = entity.getMeal_Carbon();
        this.meal_Protein = entity.getMeal_Protein();
        this.eatDate = entity.getEatDate();
        this.eatMonth =entity.getEatMonth();
        this.imageUrl = entity.getImageUrl();
    }

}
