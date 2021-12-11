package io.jascha030.pmr.action

import com.intellij.openapi.util.NlsActions
import javax.swing.Icon

class GoToResourceAction(
    private var resourceUri: String?,
    text: @NlsActions.ActionText String?,
    description: @NlsActions.ActionDescription String?,
    icon: Icon?
) : OpenInBrowserAction(
    text,
    description,
    icon
) {
    override fun getResourceURI(): String? = this.resourceUri
}