package test;

import main.Item;
import main.Producer;

public class ProducerMock implements Producer {

    private final BufferHelper buffer;

    public ProducerMock(BufferHelper buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
    }
    
    public boolean addItem(Item item) {
    	return buffer.add(item);
    }

    @Override
    public void stopRunning() {
    }
}
