package com.example.superkassa;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class MyJson implements Serializable {
    private int current;
}
