package com.demo;

import com.demo.domain.DroneModel;
import com.demo.domain.DroneState;
import com.demo.web.data.DroneDto;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class DroneControllerTest extends DronesApiApplicationTests {

    @Test
    void when_register_drone_with_valid_data_should_save_drone_and_return_201_created() throws Exception {
        var drone = new DroneDto();
        drone.setSerialNumber("Dummy_Serial-number");
        drone.setWeight(300);
        drone.setBatteryCapacity(100);
        drone.setModel(DroneModel.LIGHT_WEIGHT);
        drone.setState(DroneState.IDLE);

        this.mockMvc.perform(post("/api/drones")
                        .content(objectMapper.writeValueAsString(drone))
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", CoreMatchers.notNullValue()))
                .andExpect(status().isCreated()).andDo(print());
    }

    @Test
    void when_register_drone_with_invalid_serial_number_should_return_400_bad_request() throws Exception {
        var drone = new DroneDto();
        drone.setWeight(300);
        drone.setBatteryCapacity(100);
        drone.setModel(DroneModel.LIGHT_WEIGHT);
        drone.setState(DroneState.IDLE);

        this.mockMvc.perform(post("/api/drones")
                        .content(objectMapper.writeValueAsString(drone))
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message", CoreMatchers.equalTo("serialNumber: must not be blank")))
                .andExpect(status().isBadRequest())
                .andDo(print());
    }

    @Test
    void when_register_drone_with_weight_exceeding_max_should_return_400_bad_request() throws Exception {
        var drone = new DroneDto();
        drone.setSerialNumber("Dummy_Serial-number");
        drone.setWeight(600);
        drone.setBatteryCapacity(100);
        drone.setModel(DroneModel.LIGHT_WEIGHT);
        drone.setState(DroneState.IDLE);

        this.mockMvc.perform(post("/api/drones")
                        .content(objectMapper.writeValueAsString(drone))
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message", CoreMatchers.equalTo("weight: must be less than or equal to 500")))
                .andExpect(status().isBadRequest())
                .andDo(print());
    }
}
