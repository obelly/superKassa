package com.example.superkassa;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;


@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Request {

    private int id;
    private int add;
}
