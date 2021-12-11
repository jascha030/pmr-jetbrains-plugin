package io.jascha030.pmr.ui

import com.intellij.openapi.actionSystem.DefaultActionGroup
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.popup.JBPopupFactory
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

private class PMRStatusBarWidget(private val project: Project) :
    StatusBarWidget,
    StatusBarWidget.MultipleTextValuesPresentation {
    private lateinit var statusBar: StatusBar

    override fun ID(): String = WIDGET_ID

    override fun install(statusBar: StatusBar) {
        this.statusBar = statusBar;
        statusBar.updateWidget(ID())
    }

    override fun getPresentation(): StatusBarWidget.WidgetPresentation = this

    override fun getTooltipText(): String = "PMR quick access"

    override fun getClickConsumer(): Consumer<MouseEvent>? = null

    override fun getPopupStep(): ListPopup? {
        TODO("Not yet implemented")
        //        JBPopupFactory.getInstance().createActionGroupPopup(
        //            "Resources",
        //            "",
        //            ""
        //        )
    }

    override fun getSelectedValue(): String? {
        TODO("Not yet implemented")
    }

    override fun dispose() {}
}
