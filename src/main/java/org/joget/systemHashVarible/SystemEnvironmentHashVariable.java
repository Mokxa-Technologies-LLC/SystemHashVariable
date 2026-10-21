package org.joget.systemHashVarible;

import java.util.ArrayList;
import java.util.Collection;
import org.joget.apps.app.model.DefaultHashVariablePlugin;
import org.joget.commons.util.LogUtil;

public class SystemEnvironmentHashVariable extends DefaultHashVariablePlugin {

    @Override
    public String getName() {
        return "System Environment Hash Variable";
    }

    @Override
    public String getVersion() {
        return "1.0.0";
    }

    @Override
    public String getDescription() {
        return "A hash variable that reads system environment variables.";
    }

    @Override
    public String getPrefix() {
        return "sysVar"; 
    }

    @Override
    public Collection<String> availableSyntax() {
        Collection<String> syntax = new ArrayList<>();
        syntax.add("sysVar.KEY");
        return syntax;
    }

    @Override
    public String processHashVariable(String variableKey) {
        try {
            if (variableKey != null && !variableKey.trim().isEmpty()) {
                String envValue = System.getenv(variableKey);
                return envValue != null ? envValue : null;
            }
        } catch (SecurityException e) {
            LogUtil.error(getClassName(), e, "Security restriction prevented reading environment variable: " + variableKey);
        } catch (Exception e) {
            LogUtil.error(getClassName(), e, "Error processing hash variable key: " + variableKey);
        }
        return null;
    }

    @Override
    public String getLabel() {
        return "System Environment Hash Variable";
    }

    @Override
    public String getClassName() {
        return getClass().getName();
    }

    @Override
    public String getPropertyOptions() {
        // Hash variable plugins do not use property configuration options
        return "";
    }
}