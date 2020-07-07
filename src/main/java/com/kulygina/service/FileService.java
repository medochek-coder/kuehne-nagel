package com.kulygina.service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

public interface FileService {
    List<String> readLinesCSVFile(String inputPath) throws IOException;
    void writeToXML(String outputPath,  Object model, Class clazz) throws JAXBException, IOException;
}