package com.AlbertAbuav.DogAndOwner.beans;

import com.AlbertAbuav.DogAndOwner.utils.DateUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Dog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private Date birthday;

    @Enumerated(EnumType.ORDINAL)
    private Color color;

    @Column(columnDefinition = "FLOAT(2,1)")
    private float weight;

    @Override
    public String toString() {
        return "Dog{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + DateUtils.beautifyDate(birthday) +
                ", color=" + color +
                ", weight=" + weight +
                '}';
    }
}
