package test;

import java.util.Queue;

import main.Buffer;
import main.Item;

public class BufferHelper extends Buffer {
	

    public BufferHelper() {
		super();
	}

	public Queue<Item> getBufferSize() {
        return buffer;
    }
}
