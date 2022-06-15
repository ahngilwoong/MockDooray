package com.nhnacademy.taskapi.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
@Embeddable
@Getter
@Setter
public class TasktagsPk implements Serializable {
    private static final long serialVersionUID = 6346845636539849873L;
    @ManyToOne
    @JoinColumn(name = "tag_num")
    private Tags tagNum;

    @ManyToOne
    @JoinColumn(name = "task_num")
    private Tasks taskNum;
}
