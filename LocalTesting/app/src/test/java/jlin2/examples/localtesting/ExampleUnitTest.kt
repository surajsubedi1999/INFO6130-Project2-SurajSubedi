package jlin2.examples.localtesting

import org.junit.Test
import org.junit.Assert.*
import org.junit.BeforeClass

class EmailValidatorTest {

    companion object {
        @BeforeClass
        @JvmStatic
        fun setup() {
            println("=== Starting EmailValidator Tests ===")
        }
    }

    @Test
    fun testCorrectEmailFormat() {
        println("Test 1: Testing 123@abc.com")
        assertTrue(EmailValidator.isValidEmail("123@abc.com"))
        println("✓ Test 1 passed")
    }

    @Test
    fun testCorrectSubdomainEmail() {
        println("Test 2: Testing 123@abc.co.ca")
        assertTrue(EmailValidator.isValidEmail("123@abc.co.ca"))
        println("✓ Test 2 passed")
    }

    @Test
    fun testIncorrectDomain() {
        println("Test 3: Testing 123@abc (should fail)")
        assertFalse(EmailValidator.isValidEmail("123@abc"))
        println("✓ Test 3 passed")
    }

    @Test
    fun testDoubleDots() {
        println("Test 4: Testing 123@abc..com (should fail)")
        assertFalse(EmailValidator.isValidEmail("123@abc..com"))
        println("✓ Test 4 passed")
    }

    @Test
    fun testNoUsername() {
        println("Test 5: Testing @abc.com (should fail)")
        assertFalse(EmailValidator.isValidEmail("@abc.com"))
        println("✓ Test 5 passed")
    }

    @Test
    fun testNoDomain() {
        println("Test 6: Testing testing123 (should fail)")
        assertFalse(EmailValidator.isValidEmail("testing123"))
        println("✓ Test 6 passed")
    }

    @Test
    fun testEmptyString() {
        println("Test 7: Testing empty string (should fail)")
        assertFalse(EmailValidator.isValidEmail(""))
        println("✓ Test 7 passed")
    }

    @Test
    fun testNullInput() {
        println("Test 8: Testing null (should fail)")
        assertFalse(EmailValidator.isValidEmail(null))
        println("✓ Test 8 passed")
    }
}