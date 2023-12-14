package test.mockingClasses;

import java.util.Queue;

import main.Buffer;
import main.Item;

public class BufferMock extends Buffer {
	

    public BufferMock() {
		super();
	}

	public Queue<Item> getBufferSize() {
        return buffer;
    }
}
