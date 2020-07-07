package com.kulygina.facade.impl;

import com.kulygina.facade.DecathlonScoresCalculationFacade;
import com.kulygina.model.DecathlonResultModel;
import com.kulygina.model.DecathlonResultModelsWrapper;
import com.kulygina.service.FileService;
import com.kulygina.service.MappingService;
import com.kulygina.service.ScoreCalculationService;
import com.kulygina.service.impl.FileServiceImpl;
import com.kulygina.service.impl.MappingServiceImpl;
import com.kulygina.service.impl.ScoreCalculationServiceImpl;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

public class DecathlonScoresCalculationFacadeImpl implements DecathlonScoresCalculationFacade {
    @Override
    public void calculateScoresAndWriteToXML(String inputPath, String outputPath, String separator) throws JAXBException, IOException {
        FileService fileService = new FileServiceImpl();
        List<String> stringList = fileService.readLinesCSVFile(inputPath);

        MappingService mappingService = new MappingServiceImpl(separator);
        List<DecathlonResultModel> resultModels = mappingService.mapStringListToModelList(stringList);

        ScoreCalculationService calculationService = new ScoreCalculationServiceImpl();
        resultModels = calculationService.calculatePlace(resultModels);

        fileService.writeToXML(outputPath, new DecathlonResultModelsWrapper(resultModels), DecathlonResultModelsWrapper.class);
    }
}
