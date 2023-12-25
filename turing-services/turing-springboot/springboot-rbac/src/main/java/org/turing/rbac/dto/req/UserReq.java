package org.turing.rbac.dto.req;

import java.util.List;
import lombok.Data;

/**
 * @descri:
 *
 * @author: lj.michale
 * @date: 2023/12/25 10:31
 */
@Data
public class UserReq {

    private Long id;

    private String username;

    private List<Long> roleIds;

}
