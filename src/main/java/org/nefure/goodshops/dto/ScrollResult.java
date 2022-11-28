package org.nefure.goodshops.dto;

import lombok.Data;

import java.util.List;

/**
 * @author nefure
 * @since 2022/11/24 15:21
 */
@Data
public class ScrollResult {
    private List<?> list;
    private Long minTime;
    private Integer offset;
}
