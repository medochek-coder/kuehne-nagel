package com.kulygina.service.impl;

import com.kulygina.model.DecathlonResultModel;
import com.kulygina.model.helper.DecathlonParametersTable;
import com.kulygina.model.helper.Parameter;
import com.kulygina.service.ScoreCalculationService;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class ScoreCalculationServiceImpl implements ScoreCalculationService {

    @Override
    public List<DecathlonResultModel> calculatePlace(List<DecathlonResultModel> modelList) {
        calculateScore(modelList);

        modelList = modelList.stream()
                .sorted(Comparator.comparing(DecathlonResultModel::getTotalScore).reversed())
                .collect(Collectors.toList());

        AtomicInteger preparatoryPlace = new AtomicInteger();
        modelList.forEach(model -> model.setPlace(String.valueOf(preparatoryPlace.incrementAndGet())));

        Map<Integer, List<DecathlonResultModel>> grouppedByTotalScore = modelList.stream()
                .collect(groupingBy(DecathlonResultModel::getTotalScore,
                        toSortedList(Comparator.comparing(DecathlonResultModel::getPlace))));

        grouppedByTotalScore.forEach((totalScore, sportsmans) -> {
            if (sportsmans.size() > 1) {
                String totalPlace = sportsmans.get(0).getPlace() + "-" + sportsmans.get(sportsmans.size() - 1).getPlace();
                sportsmans.forEach(sportsman -> sportsman.setPlace(totalPlace));
            }
        });

        return modelList;
    }

    private void calculateScore(List<DecathlonResultModel> modelList) {
        modelList.forEach(model -> model.setTotalScore(calculateTotalScore(model)));
    }

    static <T> Collector<T, ?, List<T>> toSortedList(Comparator<? super T> comparator) {
        return Collectors.collectingAndThen(
                Collectors.toCollection(ArrayList::new), list -> {
                    list.sort(comparator);
                    return list;
                });
    }

    private Double calculateFormula(Parameter parameter, double resultInEvent) {
        return parameter.getA() * Math.pow(Math.abs(resultInEvent - parameter.getB()), parameter.getC());
    }

    private int calculateTotalScore(DecathlonResultModel model) {
        return calculateFormula(DecathlonParametersTable.run100m, model.getRun100m()).intValue()
                + calculateFormula(DecathlonParametersTable.longJump, model.getLongJump()).intValue()
                + calculateFormula(DecathlonParametersTable.shotPut, model.getShotPut()).intValue()
                + calculateFormula(DecathlonParametersTable.highJump, model.getHighJump()).intValue()
                + calculateFormula(DecathlonParametersTable.run400m, model.getRun400m()).intValue()
                + calculateFormula(DecathlonParametersTable.run110mHurdles, model.getRun110mHurdles()).intValue()
                + calculateFormula(DecathlonParametersTable.discusThrow, model.getDiscusThrow()).intValue()
                + calculateFormula(DecathlonParametersTable.poleVault, model.getPoleVault()).intValue()
                + calculateFormula(DecathlonParametersTable.javelinThrow, model.getJavelinThrow()).intValue()
                + calculateFormula(DecathlonParametersTable.run1500m, model.getRun1500m()).intValue();
    }
}
