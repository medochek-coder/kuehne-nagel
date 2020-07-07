package com.kulygina.service.impl;

import com.kulygina.model.DecathlonResultModel;
import com.kulygina.model.DecathlonResultModelsWrapper;
import com.kulygina.service.FileService;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileServiceImpl implements FileService {

    @Override
    public List<String> readLinesCSVFile(String inputPath) throws IOException {
        return Files.readAllLines(Paths.get(inputPath));
    }

    @Override
    public void writeToXML(String outputPath, Object model, Class clazz) throws JAXBException, IOException {
        JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        File file = Paths.get(outputPath).toFile();
        file.createNewFile();
        jaxbMarshaller.marshal(model, file);

        System.out.println("File saved: " + outputPath);
    }
}
