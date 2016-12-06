package uk.co.ibuildstuff.teamcity.swift.agent.build

import com.jonnyzzz.teamcity.plugins.node.common.fetchArguments
import jetbrains.buildServer.agent.runner.ProgramCommandLine
import uk.co.ibuildstuff.teamcity.swift.agent.BaseService
import uk.co.ibuildstuff.teamcity.swift.common.SwiftBuildBean
import java.util.*

class SwiftBuildSession : BaseService() {

    val bean = SwiftBuildBean()

    override fun makeProgramCommandLine(): ProgramCommandLine {
        val arguments = arrayListOf<String>()
        arguments.add("build")

        val parameters = TreeMap<String, String>()
        parameters.putAll(buildParameters.systemProperties)

        val parametersAll = TreeMap<String, String>()
        parametersAll.putAll(configParameters)
        parametersAll.putAll(buildParameters.allParameters)

        arguments.addAll(runnerParameters[bean.commandLineParameterKey].fetchArguments())

        return execute("swift", arguments)
    }

}