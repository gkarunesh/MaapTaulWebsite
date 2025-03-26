package com.lmd.web.dto;
/* @author sudhakar
*
*/

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public @Data class Param {
  private String param1, param2, param3, param5;
  private Integer param4;
  
  @Override
  public String toString() {
    return "{\"param1\":\"" + param1 + "\", \"param2\":\"" + param2 +"\", \"param3\":\""+param3+"\", \"param4\":\""+param4+"\"}";
  }
  
  
}