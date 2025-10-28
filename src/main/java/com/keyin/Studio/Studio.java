package com.keyin.Studio;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Studio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String studioName;
    private String studioAddress;
    private String studioPhone;
    private String studioEmail;


    public Studio(String studioName, String studioAddress, String studioPhone, String studioEmail) {
        this.studioName = studioName;
        this.studioAddress = studioAddress;
        this.studioPhone = studioPhone;
        this.studioEmail = studioEmail;
    }


}
