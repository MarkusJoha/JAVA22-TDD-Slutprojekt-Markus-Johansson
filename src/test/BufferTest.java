package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import test.mockingClasses.BufferMock;
import test.mockingClasses.ConsumerMock;
import test.mockingClasses.ItemMock;
import test.mockingClasses.ProducerMock;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class BufferTest {
	BufferMock buffer;
	ProducerMock producer;
	ConsumerMock consumer;
	ItemMock item;

    @BeforeEach
    void beforeEach() {
        buffer = new BufferMock();
        producer = new ProducerMock(buffer);
        consumer = new ConsumerMock(buffer);
    }

	@Test
	@DisplayName("Check item return when buffer is empty")
	void checkItemReturnWhenBufferEmpty() {
		Thread thread = new Thread(() -> assertThrows(InterruptedException.class, () -> buffer.remove()));
		thread.start();
		thread.interrupt();
	}

	@Test
	@DisplayName("Check remove item from buffer")
	void checkRemove() {
		ItemMock item = new ItemMock("ABC");
		producer.addItem(item);
		assertEquals(item, consumer.removeItem());
	}

	@Test
	@DisplayName("Check add method adds item in buffer list")
	void checkAddMethodAddsItemInBufferList() {
		ItemMock item = new ItemMock("ABC");
		producer.addItem(item);

		assertTrue(buffer.getBufferSize().contains(item));
	}

	@Test
	@DisplayName("Check buffer list is initially empty")
	void checkBufferListIsInitiallyEmpty() {
		assertTrue(buffer.getBufferSize().isEmpty());
	}

	@Test
	@DisplayName("Check buffer is not empty")
	void checkBufferIsNotEmpty() {
		ItemMock item = new ItemMock("ABC");
		producer.addItem(item);

		assertFalse(buffer.getBufferSize().isEmpty());
	}

	@Test
	@DisplayName("Check buffer is empty")
	void checkBufferIsEmpty() {
		assertTrue(buffer.getBufferSize().isEmpty());
	}

	@Test
	@DisplayName("Check sysout adding null to list")
	void checkSysoutAddingNullToList() {
		ByteArrayOutputStream sysoutContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(sysoutContent));

		try {
			producer.addItem(null);

			assertEquals("[null]", sysoutContent.toString().trim());
		} finally {
			System.setOut(System.out);
		}
	}

	@Test
	@DisplayName("Check boolean is true")
	void checkBooleanIsTrue() {
		ItemMock item = new ItemMock("ABC");

		assertTrue(producer.addItem(item));
	}

	@Test
	@DisplayName("Check add with right ID in list or null sent in")
	void checkAddWithRightIdInListOrNullSentIn() {
		ItemMock item = new ItemMock("ABC");

		producer.addItem(item);
		producer.addItem(null);

		assertTrue(buffer.getBufferSize().contains(item));
		assertTrue(buffer.getBufferSize().contains(null));
	}
}