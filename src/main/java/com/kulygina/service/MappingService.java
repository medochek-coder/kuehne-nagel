package com.kulygina.service;

import com.kulygina.model.DecathlonResultModel;

import java.util.List;

public interface MappingService {
    List<DecathlonResultModel> mapStringListToModelList(List<String> inputList);
}
