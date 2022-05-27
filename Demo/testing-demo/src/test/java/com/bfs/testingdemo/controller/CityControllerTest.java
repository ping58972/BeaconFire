package com.bfs.testingdemo.controller;

import com.bfs.testingdemo.domain.City;
import com.bfs.testingdemo.service.CityService;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(controllers = CityController.class)
class CityControllerTest {
    @MockBean
    private CityService service;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetCityById() throws Exception {
        City expected = new City(1, "Kabul", "AFG", "Kabol", 1780000);
        Mockito.when(service.getCityById(1)).thenReturn(expected);

        // 1st way
        mockMvc.perform(MockMvcRequestBuilders.get("/city/1"))
                .andExpect(MockMvcResultMatchers.status().isOk()) // status code 200
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().json(
                        "{'id': 1,'name': 'Kabul', 'countryCode': 'AFG', 'district': 'Kabol', 'population': 1780000}"));

        // 2nd way
//        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/city/{id}", "1"))
//                .andReturn();
//        Gson gson = new Gson();
//        City actual = gson.fromJson(result.getResponse().getContentAsString(), City.class);
//        assertEquals(expected, actual);

    }

    @Test
    void testSaveCity() throws Exception {
        City expected = new City(5000, "Some city", "ZZZ", "Some district", 100000000);
        Mockito.when(service.saveCity(expected)).thenReturn(expected);
        Gson gson = new Gson();
        String json = gson.toJson(expected);
        System.out.println(json);

        // 1st way
        mockMvc.perform(MockMvcRequestBuilders.post("/city")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.content().json("{'id': 5000,'name': 'Some city', 'countryCode': 'ZZZ', 'district': 'Some district', 'population': 100000000}"))
                .andExpect(MockMvcResultMatchers.content().json(json));

        // 1st way
//        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/city")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(json))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
////                .andExpect(MockMvcResultMatchers.content().json("{'id': 5000,'name': 'Some city', 'countryCode': 'ZZZ', 'district': 'Some district', 'population': 100000000}"))
//                .andExpect(MockMvcResultMatchers.content().json(json))
//                .andReturn();
//        City actual = gson.fromJson(result.getResponse().getContentAsString(), City.class);
//        assertEquals(expected.toString(), actual.toString());
    }
}
