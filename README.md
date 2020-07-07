# Kuehne-Nagel test task

### Build

For build go to the project root directory and run command: 

``mvn clean install``

### How to use

1. Go to the ``kuehne-nagel\target\`` and find ``kuehne-nagel-test-1.0-SNAPSHOT.jar``
2. Run command ``java -jar kuehne-nagel-test-1.0-SNAPSHOT.jar <inpuntFilePath>
 <outputFilePath> <csvFileSeparator>``. 
 Example: ``java -jar kuehne-nagel-test-1.0-SNAPSHOT.jar "/Users/irinakulygina/Downloads/results.csv"
                                                  "/Users/irinakulygina/Downloads/output.xml" ";"``
