package com.nhnacademy.taskapi.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "tasktags")
public class Tasktags {
    @EmbeddedId
    private TasktagsPk tasktagsPk;
}
