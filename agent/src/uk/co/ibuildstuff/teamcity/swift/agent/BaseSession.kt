package uk.co.ibuildstuff.teamcity.swift.agent

import com.jonnyzzz.teamcity.plugins.node.agent.processes.ScriptWrappingCommandLineGenerator
import com.jonnyzzz.teamcity.plugins.node.common.log4j
import jetbrains.buildServer.agent.runner.BuildServiceAdapter
import jetbrains.buildServer.agent.runner.ProgramCommandLine
import jetbrains.buildServer.agent.runner.SimpleProgramCommandLine
import org.apache.log4j.Logger

abstract class BaseService : BuildServiceAdapter() {
    protected val LOG : Logger = log4j(this.javaClass)
    private val disposables = arrayListOf<() -> Unit>()

    fun disposeLater(action : () -> Unit) {
        disposables.add(action)
    }

    override fun afterProcessFinished() {
        super.afterProcessFinished()

        disposables.forEach { it() }
    }

    protected fun execute(executable:String, arguments:List<String>) : ProgramCommandLine {
        val that = this
        return object: ScriptWrappingCommandLineGenerator<ProgramCommandLine>(runnerContext) {
            override fun execute(executable: String, args: List<String>): ProgramCommandLine
                    = SimpleProgramCommandLine(build, executable, args)
            override fun disposeLater(action: () -> Unit) = that.disposeLater(action)
        }.generate(executable, arguments)
    }
}