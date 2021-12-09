package io.jascha030.pmr.ui

import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.StatusBar
import com.intellij.openapi.wm.StatusBarWidget
import com.intellij.openapi.wm.StatusBarWidgetFactory

private const val pmrWidgetId: String = "pmrWidget"

class PMRStatusBarWidgetFactory: StatusBarWidgetFactory {
    override fun getId(): String = pmrWidgetId

    override fun getDisplayName(): String {
        return "PMR"
    }

    override fun isAvailable(project: Project): Boolean {
        return true
    }

    override fun createWidget(project: Project): StatusBarWidget {
        TODO("Not yet implemented")
    }

    override fun disposeWidget(widget: StatusBarWidget) {
        TODO("Not yet implemented")
    }

    override fun canBeEnabledOn(statusBar: StatusBar): Boolean {
        TODO("Not yet implemented")
    }
}