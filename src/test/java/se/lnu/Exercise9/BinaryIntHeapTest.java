package se.lnu.Exercise9;

import java.util.NoSuchElementException;
import java.util.Random;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryIntHeapTest {
	static final int ONE_MILLION = 1000000;

	@Test
	void testBinaryIntHeap() {
		BinaryIntHeap testH = new BinaryIntHeap();
        assertInstanceOf(BinaryIntHeap.class, testH);
	}

	@Test
	void testSize() {
		BinaryIntHeap testH = new BinaryIntHeap();

		Random random = new Random();
		for (int i = 0; i < ONE_MILLION; i++) {
			int randoms = random.nextInt(9000);
			assertEquals(i, testH.size());
			testH.insert(randoms);
		}
		for (int i = 0; i < ONE_MILLION; i++) {
			assertEquals(ONE_MILLION - i, testH.size());
			testH.pullHighest();
		}
	}

	@Test
	void testIsEmpty() {
		BinaryIntHeap testHeap = new BinaryIntHeap();

		assertTrue(testHeap.isEmpty());

		testHeap.insert(1);

		assertFalse(testHeap.isEmpty());
	}

	@Test
	void insertTest() {
		BinaryIntHeap testHeap = new BinaryIntHeap();

		// Add 1 item
		testHeap.insert(9000);

		testHeap = new BinaryIntHeap();

		Random randToFill = new Random();
		for (int i = 0; i < ONE_MILLION; i++) {
			int random = randToFill.nextInt(9000);
			assertEquals(i, testHeap.size());
			testHeap.insert(random);
		}

	}

	@Test
	void pullHighestTest() {
		final BinaryIntHeap emptyHeap = new BinaryIntHeap();

		assertThrows(NoSuchElementException.class, () -> emptyHeap.pullHighest());

		BinaryIntHeap testHeap = new BinaryIntHeap();
		testHeap.insert(9000);
		assertEquals(9000, testHeap.pullHighest());

		testHeap = new BinaryIntHeap();

		Random random = new Random();
		for (int i = 0; i < 1000; i++) {
			int randoms = random.nextInt(9000);
			testHeap.insert(randoms);
		}

		int high = testHeap.pullHighest();
		int low;
		while (testHeap.size() > 0) {
			low = testHeap.pullHighest();
			assertTrue(high > low);
		}

	}

}