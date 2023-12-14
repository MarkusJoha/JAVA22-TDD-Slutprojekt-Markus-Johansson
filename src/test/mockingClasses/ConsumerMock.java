package test.mockingClasses;

import main.Consumer;
import main.Item;

public class ConsumerMock implements Consumer {

    private final BufferMock buffer;

    public ConsumerMock(BufferMock buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
    }
    public Item removeItem() {
        return buffer.remove();
    }
    @Override
    public void stopRunning() {
    }
    
    
}
