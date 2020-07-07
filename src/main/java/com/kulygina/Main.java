package com.kulygina;

import com.kulygina.facade.DecathlonScoresCalculationFacade;
import com.kulygina.facade.impl.DecathlonScoresCalculationFacadeImpl;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws JAXBException, IOException {
        if (args.length < 3) {
            System.out.println("Wrong program arguments");
            return;
        }
        String pathToInputCSVFile = args[0];
        String pathToOutputXMLFile = args[1];
        String separator = args[2];
        DecathlonScoresCalculationFacade scoresCalculationFacade = new DecathlonScoresCalculationFacadeImpl();
        scoresCalculationFacade.calculateScoresAndWriteToXML(pathToInputCSVFile, pathToOutputXMLFile, separator);
    }
}
