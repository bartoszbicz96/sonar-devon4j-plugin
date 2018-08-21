package io.oasp.ide.sonarqube.common.impl;

import org.sonar.api.Plugin;
import org.sonar.api.PropertyType;
import org.sonar.api.config.PropertyDefinition;

/**
 * TODO
 */
public class DevonSonarPlugin implements Plugin {

  static final String CONFIG_KEY = "sonar.devon.config";

  static final String FORBIDDEN_CONF_KEY = "sonar.devon.forbiddenConf";

  static final String DISABLED = "Disabled";

  static final String ISSUES_SEVERITY_KEY = "sonar.Devon.preview.issuesSeverity";

  @Override
  public void define(Context context) {

    context.addExtensions(DevonSonarDefinition.class, DevonSonarRegistrar.class);
    context.addExtension(PropertyDefinition.builder(CONFIG_KEY).name("Config JSON")
        .description("Configuration of business architecture, etc. TODO").category("Devon").subCategory("")
        .type(PropertyType.TEXT)
        .defaultValue(
            "{\"businessArchitecture\":{\"components\":[\n{\"name\":\"component1\",\\\"dependencies\\\":[]}}\n]}}")
        .build());
  }
}
