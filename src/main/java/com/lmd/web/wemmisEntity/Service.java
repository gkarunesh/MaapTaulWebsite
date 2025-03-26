package com.lmd.web.wemmisEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Service {
  private Integer serviceId;
  private Integer subServiceId;
  private String name;
}
