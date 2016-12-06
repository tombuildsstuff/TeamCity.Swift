package uk.co.ibuildstuff.teamcity.swift.server

import jetbrains.buildServer.requirements.Requirement
import uk.co.ibuildstuff.teamcity.swift.common.SwiftBuildBean

class SwiftBuildRunType : SwiftRunTypeBase() {
    private val bean : SwiftBuildBean = SwiftBuildBean()

    override fun getType(): String = bean.runTypeName
    override fun getDisplayName(): String = "Swift Build"
    override fun getDescription(): String = "Builds a Swift Project"
    override fun getEditJsp(): String = "swift.edit.jsp"
    override fun getViewJsp(): String = "swift.view.jsp"

    override fun getRunnerSpecificRequirements(runParameters: Map<String, String>): MutableList<Requirement> {
        val result = arrayListOf<Requirement>()
        val list = super.getRunnerSpecificRequirements(runParameters)
        result.addAll(list)
        return result
    }
}