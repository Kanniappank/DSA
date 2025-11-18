package org.example.modal;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Location {
    private String address;
    private String city;
    private String state;
    private String zipCode;
}
