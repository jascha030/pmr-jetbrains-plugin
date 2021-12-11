package io.jascha030.pmr.action

import com.intellij.ide.BrowserUtil
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.util.NlsActions
import javax.swing.Icon

abstract class OpenInBrowserAction(
    text: @NlsActions.ActionText String?,
    description: @NlsActions.ActionDescription String?,
    icon: Icon?
) : AnAction(text, description, icon) {
    abstract fun getResourceURI(): String?

    override fun actionPerformed(e: AnActionEvent) {
        getResourceURI()?.let {
            BrowserUtil.browse(it)
        }
    }

    override fun update(e: AnActionEvent) {
        getResourceURI().let {
            e.presentation.isEnabled = (it != null)
        }
    }
}