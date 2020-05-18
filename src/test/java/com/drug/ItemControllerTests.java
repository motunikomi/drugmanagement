package com.drug;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc

class ItemControllerTests {

  @Autowired
  private MockMvc mockMvc;

  @Disabled
  @Test
  void init処理が走って200が返る() throws Exception {
    this.mockMvc.perform(get("/")).andExpect(status().is2xxSuccessful());
  }
}
