package com.zkml.official_reception.client.query.meeting;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by fanghui on 2019/4/17.
 */
@Data
public class MeetingQuery implements Serializable {

    private String title;

    private String type;

    private String status;

    private String state;
    /**
     * 分页参数
     */
    private long max = 10L;

    /**
     * 分页参数
     */
    private long offset = 0L;
}
