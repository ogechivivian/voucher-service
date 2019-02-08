package com.voucherz.voucherservice.api;

public class hdhd {

    /*
package com.iswAcademy.Voucherz.Util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class JwtTokenProviderTest {
@Autowired
private MockMvc mvc;

@Test
public void existentUserCanGetTokenAndAuthentication() throws Exception{
String username= "existentuser";
String password = "password";

String body = "{\"username\":\"" + username + "\", \"password\":\" + password + "\"}";

MvcResult result = mvc.perform(MockMvcRequestBuilders.post("/")
.content(body)).andExpect(status().isOk()).andReturn();
String response = result.getResponse().getContentAsString();
response = response.replace("{\"access_token\":\"","");
String token = response.replace("\"}", "");
mvc.perform(MockMvcRequestBuilders.get("/test")
.header("Authorization", "Bearer" + token))
.andExpect(status().isOk());
}

@Test
public void nonexistentUserCannotGetToken() throws Exception{
String username = "existentuser";
String password = "password";
//String body = "{\username\":\"" + username + "\", \"password\":\" + password + "\"}";

mvc.perform(MockMvcRequestBuilders.post("/")
.content(body))
.andExpect(status().isForbidden()).andReturn();
}



}
*/

}
