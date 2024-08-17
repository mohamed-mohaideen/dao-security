package com.msoft.security.demo.dto;

import java.util.List;

public record UserInfo(String username, String password, List<String> roles) {

}
