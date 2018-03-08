package cdi;

import exceptions.JsonFileNotFound;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileUploadProcessorBeanTest {

    @Test
    void isJsonFileUploaded() {

        Throwable exception = assertThrows(JsonFileNotFound.class, () -> {
            new FileUploadProcessorBean().uploadJsonFile(null);
        });

        assertEquals("No json file has been uploaded #1", exception.getMessage());
    }
}