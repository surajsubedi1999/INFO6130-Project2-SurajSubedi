package jlin2.examples.localtesting

import org.junit.Test
import org.junit.Assert.*

class EmailValidatorTest {

    @Test
    fun testCorrectEmailFormat() {
        assertTrue(EmailValidator.isValidEmail("123@abc.com"))
    }

    @Test
    fun testCorrectSubdomainEmail() {
        assertTrue(EmailValidator.isValidEmail("123@abc.co.ca"))
    }

    @Test
    fun testIncorrectDomain() {
        assertFalse(EmailValidator.isValidEmail("123@abc"))
    }

    @Test
    fun testDoubleDots() {
        assertFalse(EmailValidator.isValidEmail("123@abc..com"))
    }
}