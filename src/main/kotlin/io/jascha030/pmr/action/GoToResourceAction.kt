package io.jascha030.pmr.action

import com.intellij.ide.BrowserUtil
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent

abstract class GoToResourceAction : AnAction() {
    abstract fun getResourceURI(): String?

    override fun actionPerformed(e: AnActionEvent) {
        getResourceURI()?.let {
            BrowserUtil.browse(it)
        }
    }
}