package com.devonfw.ide.sonarqube.common.impl.check.layer;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import com.devonfw.ide.sonarqube.common.api.JavaType;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureCheck;

/**
 * {@link DevonArchitectureCheck} verifying that only client layer code may depend on client layer.
 */
@Rule(key = "Devon4j:L2", name = "Devon Layer *-Client Check", //
    description = "Verify that only client layer may depend on client layer.", //
    priority = Priority.BLOCKER, tags = { "architecture-violation" })
public class DevonArchitectureLayerAny2ClientCheck extends DevonArchitectureCheck {

  @Override
  protected String checkDependency(JavaType source, JavaType target) {

    if (!source.isLayerClient() && target.isLayerClient()) {
      return "Code from any layer other than client shall not depend on client layer. ('" + source.getComponent() + "."
          + source.getLayer() + "' is dependent on '" + target.getComponent() + "." + target.getLayer() + "')";
    }
    return null;
  }

}