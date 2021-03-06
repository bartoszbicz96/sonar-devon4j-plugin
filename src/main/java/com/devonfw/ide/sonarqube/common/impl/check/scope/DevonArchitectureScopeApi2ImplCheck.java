package com.devonfw.ide.sonarqube.common.impl.check.scope;

import org.sonar.check.Priority;
import org.sonar.check.Rule;

import com.devonfw.ide.sonarqube.common.api.JavaType;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureCheck;
import com.devonfw.ide.sonarqube.common.impl.check.DevonArchitectureImportCheck;

/**
 * {@link DevonArchitectureCheck} to verify that code from api scope does not depend on impl scope.
 */
@Rule(key = "S1", name = "devonfw Scope Api-Impl Check", //
    priority = Priority.BLOCKER, tags = { "architecture-violation", "devonfw", "scope" })
public class DevonArchitectureScopeApi2ImplCheck extends DevonArchitectureImportCheck {

  @Override
  protected String checkDependency(JavaType source, JavaType target) {

    if (source.isScopeApi() && target.isScopeImpl()) {
      return "Code from api scope shall not depend on impl scope. ('" + source.getComponent() + "." + source.getLayer()
          + "." + source.getScope() + "' is dependent on '" + target.getComponent() + "." + target.getLayer() + "."
          + target.getScope() + "')";
    }
    return null;
  }

}
