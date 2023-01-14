package reader;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileDecrypterTest {

    @Test
    void decryptFile() {
        assertEquals("ppcoloq",FileDecrypter.decryptFile("encrp.txt.enc","VkYp3s6"));
    }
}