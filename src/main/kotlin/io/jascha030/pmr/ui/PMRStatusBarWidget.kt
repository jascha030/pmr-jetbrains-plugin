package io.jascha030.pmr.ui

import com.intellij.openapi.project.Project
import com.intellij.openapi.util.Disposer
import com.intellij.openapi.wm.StatusBar
import com.intellij.openapi.wm.StatusBarWidget
import com.intellij.openapi.wm.StatusBarWidgetFactory
import com.intellij.util.Consumer
import java.awt.Component
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

private class PMRStatusBarWidget(private val project: Project) : StatusBarWidget {
    private lateinit var statusBar: StatusBar

    override fun ID(): String = WIDGET_ID

    override fun install(statusBar: StatusBar) {
        this.statusBar = statusBar

        statusBar.updateWidget(ID())
    }

    override fun getPresentation(): StatusBarWidget.WidgetPresentation =
        object : StatusBarWidget.TextPresentation {
            override fun getTooltipText(): String = "PM resources"

            override fun getClickConsumer(): Consumer<MouseEvent>? = null

            override fun getText(): String = "Resources"

            override fun getAlignment(): Float = Component.CENTER_ALIGNMENT;

            // override fun getIcon(): Icon = com.intellij.icons.AllIcons.General.ShowInfos
        }

    //    override fun getPresentation(): StatusBarWidget.WidgetPresentation = object : StatusBarWidget.MultipleTextValuesPresentation {
    //        override fun getTooltipText(): String = "PMR quick access"
    //
    //        override fun getPopupStep(): ListPopup {
    //            return JBPopupFactory.getInstance().createActionGroupPopup(
    //                "Resources",
    //                ResourceActionGroup(),
    //                DataManager.getInstance().getDataContext(statusBar.component),
    //                JBPopupFactory.ActionSelectionAid.NUMBERING,
    //                true
    //            )
    //        }
    //
    //        override fun getClickConsumer(): Consumer<MouseEvent>? = null
    //
    //        override fun getSelectedValue(): String? = null
    //    }


    override fun dispose() {}
}
