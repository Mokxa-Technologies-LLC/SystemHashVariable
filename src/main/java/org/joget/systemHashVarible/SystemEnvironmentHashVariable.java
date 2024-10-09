package org.joget.systemHashVarible;

import org.joget.apps.app.model.DefaultHashVariablePlugin;

public class SystemEnvironmentHashVariable extends DefaultHashVariablePlugin{

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
    public String processHashVariable(String variableKey) {
        String envValue = System.getenv(variableKey);
        if(envValue != null) {
        	return envValue;
        }else{
        	return "";
        }
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
		// TODO Auto-generated method stub
		return null;
	}

}
