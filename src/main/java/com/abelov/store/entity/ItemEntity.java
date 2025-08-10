package com.abelov.store.entity;

import com.abelov.store.enums.StatusEnum;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString(callSuper = true)
@Table(schema = "item", name = "item")
@Inheritance(strategy = InheritanceType.JOINED)
public class ItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    private String owner;
    private String name;
    @Enumerated(value = EnumType.STRING)
    private StatusEnum status; // Опубликован, закрыт, заморожен и тд
    private String price;
    @Column(columnDefinition = "TEXT")
    private String description;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public ItemEntity() {
    }

    public ItemEntity(String owner, String name, StatusEnum status,
                      String price, String description, LocalDateTime created_at, LocalDateTime updated_at) {
        this.owner = owner;
        this.name = name;
        this.status = status;
        this.price = price;
        this.description = description;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }
}
