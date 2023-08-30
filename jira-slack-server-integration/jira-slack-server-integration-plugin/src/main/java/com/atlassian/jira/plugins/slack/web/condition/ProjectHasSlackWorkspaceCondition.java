package com.atlassian.jira.plugins.slack.web.condition;

import com.atlassian.jira.plugins.slack.manager.ProjectConfigurationManager;
import com.atlassian.jira.project.Project;
import com.atlassian.plugin.PluginParseException;
import com.atlassian.plugin.web.Condition;

import java.util.Map;

public class ProjectHasSlackWorkspaceCondition implements Condition {

    private final ProjectConfigurationManager projectConfigurationManager;

    public ProjectHasSlackWorkspaceCondition(final ProjectConfigurationManager projectConfigurationManager) {
        this.projectConfigurationManager = projectConfigurationManager;
    }

    @Override
    public void init(Map<String, String> map) throws PluginParseException {
    }

    @Override
    public boolean shouldDisplay(Map<String, Object> context) {
        final Project project = (Project) context.get("project");
        return project != null && projectConfigurationManager.getConfiguration(project.getId()).getConfiguration().size() > 0;
    }
}
