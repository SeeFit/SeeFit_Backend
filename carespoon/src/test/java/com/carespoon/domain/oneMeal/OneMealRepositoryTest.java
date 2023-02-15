package com.carespoon.domain.oneMeal;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OneMealRepositoryTest {
    @Autowired
    OneMealRepository oneMealRepository;

    @After //Junit단위 테스트가 끝날 때 마다 수행되는 메소드를 여러 테스트가 동시에 수행되면 테스트용 데이터베이스인 H2에 데이터가 그대로 남아있을 수 있음
    public void cleanup() {
        oneMealRepository.deleteAll();
    }

    @Test
    public void 한끼저장_불러오기() {
        LocalDateTime mealTime = LocalDateTime.now();
        int kcal = 170;
        int carbon = 13;
        int fat = 20;
        int protein = 10;

        oneMealRepository.save(OneMeal.builder()
                .mealTime(mealTime)
                .meal_Kcal(kcal)
                .meal_Carbon(carbon)
                .meal_Fat(fat)
                .meal_Protein(protein)
                .build());

        //when
        List<OneMeal> oneMealList = oneMealRepository.findAll();

        //then
        OneMeal oneMeal = oneMealList.get(0);
        assertThat(oneMeal.getMeal_Carbon()).isEqualTo(carbon);
        assertThat(oneMeal.getMealTime()).isEqualTo(mealTime);
        assertThat(oneMeal.getMeal_Fat()).isEqualTo(fat);
        assertThat(oneMeal.getMeal_Protein()).isEqualTo(protein);
        assertThat(oneMeal.getMeal_Kcal()).isEqualTo(kcal);
    }
}
