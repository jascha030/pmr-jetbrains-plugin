package io.jascha030.pmr.action

import com.intellij.openapi.actionSystem.ActionGroup
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent

class ResourceActionGroup : ActionGroup() {
    override fun getChildren(e: AnActionEvent?): Array<GoToResourceAction> = arrayOf(
        GoToResourceAction("https://google.nl", "Google", "Test", null)
    )
}