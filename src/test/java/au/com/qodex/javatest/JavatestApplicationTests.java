package au.com.qodex.javatest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import au.com.qodex.javatest.utils.Truncator;

@SpringBootTest
class JavatestApplicationTests {

	@Autowired
	Truncator trunc;

	@Test
	void contextLoads() {
	}

	@Test
	void testTruncatorTrancates() {
		assert "12 ... (truncated) ... 90".equals(trunc.truncate("123456789012345678901234567890", 25));
		assert "besser  ... (truncated) ... em Dach".equals(trunc.truncate("besser Ein Statz in der hand als eine taube auf dem Dach", 35));
	}
	@Test
	void testTruncatorDoesNotTruncateShortStrings() {
		assert "1234567890".equals(trunc.truncate("1234567890", 5));
		assert "123456789012345678901234567890".equals(trunc.truncate("123456789012345678901234567890", 31));
		assert "qqqqqqqqqqqwwrreeerrereerrererereer".equals(trunc.truncate("qqqqqqqqqqqwwrreeerrereerrererereer", 1000));
	}

}
