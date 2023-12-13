package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ItemTest {

	ItemHelper item;

	@BeforeEach
	void beforeEach() {
		item = new ItemHelper("item");
	}

	@Test
	@DisplayName("lowercase setId")
	void setIdLowerCase() {
		String id = "item";
		item.setId(id);
		assertEquals(id, item.getId());
	}

	@Test
	@DisplayName("lowercase Constructor")
	void itemConstructorLowerCase() {
		assertEquals("item", item.getId());
	}

	@Test
	@DisplayName("test setId if upper case converts to lowercase")
	void setIdUpperCase() {
		String id = "ITEM";
		item.setId(id);
		assertEquals(id.toLowerCase(), item.getId());
	}

	@Test
	@DisplayName("test if item id isn't uppercase")
	void itemConstructorUpperCase() {
		String id = "ITEM";
		ItemHelper item = new ItemHelper(id);
		assertEquals(id.toLowerCase(), item.getId());
	}

	@Test
	@DisplayName("test if item id is empty string")
	void itemConstructorEmptyString() {
		String id = "";
		ItemHelper item = new ItemHelper(id);
		assertTrue(item.getId().isBlank());
	}

	@Test
	@DisplayName("test if item id is empty string")
	void setIdEmptyString() {
		String id = "";
		item.setId(id);
		assertTrue(item.getId().isBlank());
	}

	@Test
	@DisplayName("toString uppercase")
	void toStringUpperCase() {
		String id = "ITEM";
		item.setId(id);
		assertEquals(id.toLowerCase(), item.toString());
	}

	@Test
	@DisplayName("toString lowercase")
	void toStringLowerCase() {
		String id = "item";
		item.setId(id);
		assertEquals("item", item.toString());
	}

	@Test
	@DisplayName("if toString has empty string")
	void toStringEmptyString() {
		String id = "";
		item.setId(id);
		assertTrue(item.toString().isBlank());
	}

	@Test
	@DisplayName("test if setId is null")
	void setIdCheckNull() {
		assertThrows(NullPointerException.class, () -> item.setId(null));
	}

	@Test
	@DisplayName("test if constructor is null")
	void constructorCheckNull() {
		assertThrows(NullPointerException.class, () -> new ItemHelper(null));
	}

}
