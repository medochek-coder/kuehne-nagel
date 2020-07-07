package com.kulygina.facade;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public interface DecathlonScoresCalculationFacade {
    void calculateScoresAndWriteToXML(String inputPath, String outputPath, String separator) throws JAXBException, IOException;
}
