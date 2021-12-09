package io.jascha030.pmr.ui

import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.StatusBar
import com.intellij.openapi.wm.StatusBarWidget
import com.intellij.openapi.wm.StatusBarWidgetFactory

class PMRStatusBarWidgetFactory: StatusBarWidgetFactory {
    override fun getId(): String {
        TODO("Not yet implemented")
    }

    override fun getDisplayName(): String {
        TODO("Not yet implemented")
    }

    override fun isAvailable(project: Project): Boolean {
        TODO("Not yet implemented")
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