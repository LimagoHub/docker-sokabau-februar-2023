package com.example.schweineservice.adapter.repository.entity;


import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "tbl_schwein")
public class SchweinEntity {


    @Id
    @Column(length = 36, nullable = false)
    private String id;


    @Column(length = 30, nullable = false)
    private String name;

    @Column(nullable = false)
    private int gewicht;

    @PrePersist
    public void bar() {

    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SchweinEntity that = (SchweinEntity) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
