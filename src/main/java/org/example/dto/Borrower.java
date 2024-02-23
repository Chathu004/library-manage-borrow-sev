package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Borrower {
    private Long id;
    private String BId;
    private String name;
    private String contact;
    private String address;
    private String nic;

}
