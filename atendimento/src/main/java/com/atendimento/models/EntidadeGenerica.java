package com.atendimento.models;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
public class EntidadeGenerica implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public EntidadeGenerica(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "EntidadeGenerica{" +
                "id=" + id +
                '}';
    }
}
