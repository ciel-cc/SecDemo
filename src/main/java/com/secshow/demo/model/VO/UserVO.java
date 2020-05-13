package com.secshow.demo.model.VO;

import com.secshow.demo.model.User;
import lombok.Data;

@Data
public class UserVO {
    private String returnMsg;
    private User user;
}
