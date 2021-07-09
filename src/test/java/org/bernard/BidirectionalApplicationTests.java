package org.bernard;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.bernard.model.AppUser;
import org.bernard.model.Item;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BidirectionalApplicationTests {

	@Test
	void contextLoads() {
	}
	@Test
	public void givenBidirectionRelation_whenDeserializingUsingIdentity_thenCorrect() throws JsonProcessingException, IOException {
		final String json = "{\"id\":2,\"name\":\"bike\",\"appUser\":{\"id\":1,\"name\":\"Bernard\",\"items\":[2]}}";

		final Item item = new ObjectMapper().readerFor(Item.class)
				.readValue(json);

		assertEquals(2, item.getId());
		assertEquals("bike", item.getName());
		assertEquals("Bernard", item.getAppUser().getName());
	}

}
