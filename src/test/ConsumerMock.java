package test;

import main.Consumer;
import main.Item;

public class ConsumerMock implements Consumer {

    private final BufferHelper buffer;

    public ConsumerMock(BufferHelper buffer) {
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
