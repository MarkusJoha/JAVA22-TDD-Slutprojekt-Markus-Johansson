package test.mockingClasses;

import main.Item;

public class ItemMock extends Item {

    public ItemMock(String id) {
		super(id);
	}
    public String getId() {
    	return id;
    }
}
