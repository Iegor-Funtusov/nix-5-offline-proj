package com.keyplate.project.lib;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
@EqualsAndHashCode
public class BaseEntity {
   private long id;

   public BaseEntity() {
      id = Math.abs(new Random().nextLong());
   }
}
