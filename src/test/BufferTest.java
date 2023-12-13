package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;

public class BufferTest {
    
    @Test
    void checkItemReturnWhenBufferEmpty() {
        BufferHelper buffer = new BufferHelper();
        ConsumerMock mockConsumer = new ConsumerMock(buffer);

        assertThrows(NoSuchElementException.class, mockConsumer::removeItem);
    }
    
    @Test
    void checkRemove() {
    	BufferHelper buffer = new BufferHelper();
    	ProducerMock producer = new ProducerMock(buffer);
    	ItemHelper item = new ItemHelper("ABC");
    	producer.addItem(item);
    	ConsumerMock consumer = new ConsumerMock(buffer);
    	assertEquals(item, consumer.removeItem());
    }

    @Test
    void checkAddMethodAddsItemInBufferList() {
        BufferHelper buffer = new BufferHelper();
        ProducerMock producer = new ProducerMock(buffer);
        ItemHelper item = new ItemHelper("ABC");
        
        producer.addItem(item);
        
        assertTrue(buffer.getBufferSize().contains(item));
    }

    @Test
    void checkBufferListIsInitiallyEmpty() {
        BufferHelper buffer = new BufferHelper();
        
        assertTrue(buffer.getBufferSize().isEmpty());
    }

    @Test
    void checkBufferIsNotEmpty() {
        BufferHelper buffer = new BufferHelper();
        ProducerMock producer = new ProducerMock(buffer);
        ItemHelper item = new ItemHelper("ABC");
        producer.addItem(item);
        
        assertFalse(buffer.getBufferSize().isEmpty());
    }

    @Test
    void checkBufferIsEmpty() {
        BufferHelper buffer = new BufferHelper();
        
        assertTrue(buffer.getBufferSize().isEmpty());
    }

    @Test
    void checkSysoutAddingNullToList() {
        // Redirect standard output to capture sysout
        ByteArrayOutputStream sysoutContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(sysoutContent));
        
        try {
            BufferHelper buffer = new BufferHelper();
            ProducerMock producer = new ProducerMock(buffer);
            producer.addItem(null);
            
            assertEquals("[null]", sysoutContent.toString().trim());
        } finally {
            // Reset standard output
            System.setOut(System.out);
        }
    }

    @Test
    void checkBooleanIsTrue() {
        BufferHelper buffer = new BufferHelper();
        ProducerMock producer = new ProducerMock(buffer);
        ItemHelper item = new ItemHelper("ABC");
        
        assertTrue(producer.addItem(item));
    }

    @Test
    void checkAddWithRightIdInListOrNullSentIn() {
        BufferHelper buffer = new BufferHelper();
        ProducerMock producer = new ProducerMock(buffer);
        ItemHelper item = new ItemHelper("ABC");
        
        producer.addItem(item);
        producer.addItem(null);
        
        assertTrue(buffer.getBufferSize().contains(item));
        assertTrue(buffer.getBufferSize().contains(null));
    }

    @Test
    void checkConsoleListContents() {
        // Redirect standard output to capture sysout
        ByteArrayOutputStream sysoutContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(sysoutContent));
        
        try {
            BufferHelper buffer = new BufferHelper();
            ProducerMock producer = new ProducerMock(buffer);
            producer.addItem(null);
            producer.addItem(new ItemHelper("ABC"));
            
            assertEquals("[null]", sysoutContent.toString().trim());
            
            sysoutContent.reset();
            
            producer.addItem(new ItemHelper("ABC"));
            
            assertEquals("[null, abc]", sysoutContent.toString().trim());
        } finally {
            // Reset standard output
            System.setOut(System.out);
        }
    }

    @Test
    void checkRemoveFromEmptyList() {
        BufferHelper buffer = new BufferHelper();
        ConsumerMock consumer = new ConsumerMock(buffer);
        
        assertThrows(NoSuchElementException.class, consumer::removeItem);
    }
}


