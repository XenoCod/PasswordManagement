package com.epam.passwordManager.Tasks;

import org.junit.Test;

import static org.junit.Assert.*;

public class EncryptionTest {
    @Test
    public void isValidEncrypted() throws Exception {
        assertEquals(new Encryption().encrypt("abc").getClass(), new byte[]{}.getClass());
    }
}