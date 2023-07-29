package com.yflash.tech.SampleAPI.model.in;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostUserRequest implements Serializable {
    private String firstName;
    private String lastName;
}
