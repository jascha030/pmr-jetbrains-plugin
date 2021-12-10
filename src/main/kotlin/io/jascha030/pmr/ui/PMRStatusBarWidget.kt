package io.jascha030.pmr.ui

import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.popup.ListPopup
import com.intellij.openapi.util.Disposer
import com.intellij.openapi.wm.StatusBar
import com.intellij.openapi.wm.StatusBarWidget
import com.intellij.openapi.wm.StatusBarWidgetFactory
import com.intellij.util.Consumer
import java.awt.event.MouseEvent

private const val WIDGET_ID: String = "pmrWidget"

class PMRStatusBarWidgetFactory : StatusBarWidgetFactory {
    override fun getId(): String = WIDGET_ID

    override fun getDisplayName(): String = "PMR"

    override fun isAvailable(project: Project): Boolean = true

    override fun createWidget(project: Project): StatusBarWidget = PMRStatusBarWidget(project)

    override fun disposeWidget(widget: StatusBarWidget) = Disposer.dispose(widget)

    override fun canBeEnabledOn(statusBar: StatusBar): Boolean = true
}

private class PMRStatusBarWidget(private val project: Project) : StatusBarWidget, StatusBarWidget.MultipleTextValuesPresentation {
    private var statusBar: StatusBar? = null
    private var selectedValue: String? = null

    override fun ID(): String = WIDGET_ID

    override fun dispose() {
        statusBar = null
    }

    override fun install(statusBar: StatusBar) {
        this.statusBar = statusBar;
        statusBar.updateWidget(ID())
    }

    override fun getPresentation(): StatusBarWidget.WidgetPresentation = this

    override fun getTooltipText(): String = "Quick access to resources"

    override fun getClickConsumer(): Consumer<MouseEvent>? {
        TODO("Not yet implemented")
    }

    override fun getPopupStep(): ListPopup? {
        TODO("Not yet implemented")
    }

    override fun getSelectedValue(): String? = this.selectedValue
}
