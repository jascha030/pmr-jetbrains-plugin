package io.jascha030.pmr.ui

import com.intellij.openapi.project.Project
import com.intellij.openapi.util.Disposer
import com.intellij.openapi.wm.StatusBar
import com.intellij.openapi.wm.StatusBarWidget
import com.intellij.openapi.wm.StatusBarWidgetFactory

private const val WIDGET_ID: String = "pmrWidget"

class PMRStatusBarWidgetFactory : StatusBarWidgetFactory {
    override fun getId(): String = WIDGET_ID

    override fun getDisplayName(): String = "PMR"

    override fun isAvailable(project: Project): Boolean = true

    override fun createWidget(project: Project): StatusBarWidget = PMRStatusBarWidget(project)

    override fun disposeWidget(widget: StatusBarWidget) = Disposer.dispose(widget)

    override fun canBeEnabledOn(statusBar: StatusBar): Boolean = true
}

private class PMRStatusBarWidget(private val project: Project) : StatusBarWidget {
    private var statusBar: StatusBar? = null

    override fun ID(): String = WIDGET_ID

    override fun dispose() {
        this.statusBar = null
    }

    override fun install(statusBar: StatusBar) {
        this.statusBar = statusBar;
        statusBar.updateWidget(ID())
    }
}
