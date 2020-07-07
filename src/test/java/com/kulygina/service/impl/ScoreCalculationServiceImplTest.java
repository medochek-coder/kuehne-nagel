package com.kulygina.service.impl;

import com.kulygina.model.DecathlonResultModel;
import org.junit.gen5.api.DisplayName;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Score calculation service should ")
class ScoreCalculationServiceImplTest {
    private static ScoreCalculationServiceImpl calculationService;

    @BeforeAll
    public static void init() {
        calculationService = new ScoreCalculationServiceImpl();
    }

    @DisplayName("calculate total scores and places")
    @Test
    public void shouldCalculatePlace() {
        List<DecathlonResultModel> modelList = new ArrayList<>();
        modelList.add(new DecathlonResultModel("John Smith", 12.61, 5.00, 9.22,
                1.50, 60.39, 16.43, 21.60, 2.60, 35.81,
                325.72));
        modelList.add(new DecathlonResultModel("Jane Doe", 13.04, 4.53, 7.79,
                1.55, 64.72, 18.74, 24.20, 2.40, 28.20,
                410.76));
        modelList.add(new DecathlonResultModel("Jane Doe2", 13.04, 4.53, 7.79,
                1.55, 64.72, 18.74, 24.20, 2.40, 28.20,
                410.76));
        modelList.add(new DecathlonResultModel("Jane Doe3", 13.04, 4.53, 7.79,
                1.55, 64.72, 18.74, 24.20, 2.40, 28.20,
                410.76));

        List<DecathlonResultModel> result = calculationService.calculatePlace(modelList);

        List<DecathlonResultModel> expected = new ArrayList<>();
        expected.add(new DecathlonResultModel("John Smith", 12.61, 5.00, 9.22,
                1.50, 60.39, 16.43, 21.60, 2.60, 35.81,
                325.72, 4200, "1"));
        expected.add(new DecathlonResultModel("Jane Doe", 13.04, 4.53, 7.79,
                1.55, 64.72, 18.74, 24.20, 2.40, 28.20,
                410.76, 3199, "2-4"));
        expected.add(new DecathlonResultModel("Jane Doe2", 13.04, 4.53, 7.79,
                1.55, 64.72, 18.74, 24.20, 2.40, 28.20,
                410.76, 3199, "2-4"));
        expected.add(new DecathlonResultModel("Jane Doe3", 13.04, 4.53, 7.79,
                1.55, 64.72, 18.74, 24.20, 2.40, 28.20,
                410.76, 3199, "2-4"));

        assertEquals(expected, result);
    }
}