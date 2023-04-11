package com.template.data.entity;

import com.template.data.entity.ennum.Shift;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "meteorological")
@Data
public class MeteorologicalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "city")
    private String city;
    @Column(name = "wind-speed")
    private Float windSpeed;
    @Column(name = "max-temperature")
    private Float maxTemp;
    @Column(name = "min-temperature")
    private Float minTemp;
    @Column(name = "humidity")
    private Float humidity;
    @Column(name = "precipitation")
    private Float precipitation;
    @Column(name = "date")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date date;

    @Column(name = "shift")
    private Shift shift;

    public MeteorologicalEntity(long id, String city, Float windSpeed, Float maxTemp, Float minTemp, Float humidity, Float precipitation, Date date, Shift shift) {
        this.id = id;
        this.city = city;
        this.windSpeed = windSpeed;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
        this.humidity = humidity;
        this.precipitation = precipitation;
        this.date = date;
        this.shift = shift;
    }
}
