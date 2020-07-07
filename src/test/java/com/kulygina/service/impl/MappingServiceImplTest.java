package com.kulygina.service.impl;

import com.kulygina.model.DecathlonResultModel;
import org.junit.gen5.api.DisplayName;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Mapping service should ")
class MappingServiceImplTest {
    private static MappingServiceImpl mappingService;

    @BeforeAll
    public static void init() {
        mappingService = new MappingServiceImpl(";");
    }

    @DisplayName("map list of strings to list of models")
    @Test
    public void shouldMapStringListToModelList() {
        List<String> stringsList = new ArrayList<>();
        stringsList.add("John Smith;12.61;5.00;9.22;1.50;60.39;16.43;21.60;2.60;35.81;5:25.72");
        stringsList.add("Jane Doe;13.04;4.53;7.79;1.55;64.72;18.74;24.20;2.40;28.20;6:50.76");

        List<DecathlonResultModel> expected = new ArrayList<>();
        expected.add(new DecathlonResultModel("John Smith", 12.61, 5.00,
                9.22, 1.50, 60.39, 16.43, 21.60, 2.60,
                35.81, 325.72));
        expected.add(new DecathlonResultModel("Jane Doe", 13.04, 4.53, 7.79,
                1.55, 64.72, 18.74, 24.20, 2.40, 28.20,
                410.76));

        List<DecathlonResultModel> result = mappingService.mapStringListToModelList(stringsList);

        assertEquals(expected, result);
    }
}