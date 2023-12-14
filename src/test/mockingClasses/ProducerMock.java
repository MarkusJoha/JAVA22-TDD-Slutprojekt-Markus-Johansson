package test.mockingClasses;

import main.Item;
import main.Producer;

public class ProducerMock implements Producer {

    private final BufferMock buffer;

    public ProducerMock(BufferMock buffer) {
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
