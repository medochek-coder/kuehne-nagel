package com.kulygina.service.impl;

import com.kulygina.model.TestModel;
import com.kulygina.service.FileService;
import org.junit.gen5.api.DisplayName;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("File service should ")
class FileServiceImplTest {
    private static FileServiceImpl fileService;
    private String filePath = getClass().getClassLoader().getResource("test.csv").getPath();
    private String expectedXMLFilePath = getClass().getClassLoader().getResource("test.xml").getPath();

    @BeforeAll
    public static void init() {
        fileService = new FileServiceImpl();
    }

    @DisplayName("read lines from CSV file")
    @Test
    public void shouldReadLinesCSVFile() throws IOException {
        List<String> expected = new ArrayList<>();
        expected.add("1;2;3");
        expected.add("a;b;c");

        List<String> result = fileService.readLinesCSVFile(filePath);

        assertLinesMatch(expected, result);
    }

    @DisplayName("write model to XML file")
    @Test
    public void shouldWriteToXML() throws IOException, JAXBException {
        List<String> expected = new ArrayList<>();
        expected.add("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>");
        expected.add("<testModel>");
        expected.add("    <a>a</a>");
        expected.add("    <b>1.45</b>");
        expected.add("</testModel>");
        TestModel testModel = new TestModel("a", 1.45);

        fileService.writeToXML(expectedXMLFilePath, testModel, TestModel.class);

        List<String> result = Files.readAllLines(Paths.get(expectedXMLFilePath));

        assertLinesMatch(expected, result);
    }
}