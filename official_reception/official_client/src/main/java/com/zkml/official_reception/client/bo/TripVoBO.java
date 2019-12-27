package com.zkml.official_reception.client.bo;

import lombok.Data;

import java.util.List;

/**
 * Created by fanghui on 2019/5/22.
 */
@Data
public class TripVoBO {

    private  String  tripName;

    private List<TripPlanBO> tripPlanDTOList;
}
