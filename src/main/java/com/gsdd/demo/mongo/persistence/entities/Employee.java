package com.gsdd.demo.mongo.persistence.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.gsdd.demo.mongo.constants.DemoConstants;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

// Using @Document allows to use a different collection name,
// defaults to class name.
@Generated
@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Document(collection = "Empleado")
public class Employee {

  @Id
  @Default
  private Long employeeId = System.nanoTime();
  private String name;
  @Default
  private String app = DemoConstants.NO_SQL;

}
