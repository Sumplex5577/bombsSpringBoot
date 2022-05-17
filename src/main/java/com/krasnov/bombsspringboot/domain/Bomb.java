package com.krasnov.bombsspringboot.domain;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "bombs")
public class Bomb {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;
    private String name;
    private int weight;
    private String country;
   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
   private LocalDateTime date;
   private boolean isNuclear;
@JsonIgnore
   private Boolean isDeleted;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public boolean isNuclear() {
        return isNuclear;
   }

    public void setNuclear(boolean nuclear) {
        isNuclear = nuclear;
    }
    @JsonIgnore
    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bomb bomb = (Bomb) o;
        return weight == bomb.weight && isNuclear == bomb.isNuclear && id.equals(bomb.id) && name.equals(bomb.name) && country.equals(bomb.country) && date.equals(bomb.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, weight, country, date, isNuclear);
    }
}























