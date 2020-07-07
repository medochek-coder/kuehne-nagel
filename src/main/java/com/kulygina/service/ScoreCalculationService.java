package com.kulygina.service;

import com.kulygina.model.DecathlonResultModel;

import java.util.List;

public interface ScoreCalculationService {
    List<DecathlonResultModel> calculatePlace(List<DecathlonResultModel> modelList);
}
