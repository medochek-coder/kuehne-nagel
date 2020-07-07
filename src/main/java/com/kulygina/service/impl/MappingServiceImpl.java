package com.kulygina.service.impl;

import com.kulygina.model.DecathlonResultModel;
import com.kulygina.service.MappingService;

import java.util.List;
import java.util.stream.Collectors;

public class MappingServiceImpl implements MappingService {
    private final String separator;

    public MappingServiceImpl(String separator) {
        this.separator = separator;
    }

    @Override
    public List<DecathlonResultModel> mapStringListToModelList(List<String> inputList) {
        return inputList.stream()
                .filter(line -> !line.isEmpty())
                .map(this::mapStringToModel)
                .collect(Collectors.toList());
    }

    private DecathlonResultModel mapStringToModel(String line) {
        String[] resultsArray = line.split(separator);
        String sportsmanName = resultsArray[0];
        double run100m = Double.parseDouble(resultsArray[1]);
        double longJump = Double.parseDouble(resultsArray[2]);
        double shotPut = Double.parseDouble(resultsArray[3]);
        double highJump = Double.parseDouble(resultsArray[4]);
        double run400m = Double.parseDouble(resultsArray[5]);
        double run110mHurdles = Double.parseDouble(resultsArray[6]);
        double discusThrow = Double.parseDouble(resultsArray[7]);
        double poleVault = Double.parseDouble(resultsArray[8]);
        double javelinThrow = Double.parseDouble(resultsArray[9]);
        String[] splitRun1500m = resultsArray[10].split(":");
        double run1500m = Double.parseDouble(splitRun1500m[0]) * 60 + Double.parseDouble(splitRun1500m[1]);

        return new DecathlonResultModel(sportsmanName, run100m, longJump, shotPut, highJump, run400m,
                run110mHurdles, discusThrow, poleVault, javelinThrow, run1500m);
    }
}
