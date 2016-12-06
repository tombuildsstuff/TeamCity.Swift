package uk.co.ibuildstuff.teamcity.swift.agent.build

import jetbrains.buildServer.agent.AgentBuildRunnerInfo
import jetbrains.buildServer.agent.BuildAgentConfiguration
import jetbrains.buildServer.agent.runner.CommandLineBuildService
import jetbrains.buildServer.agent.runner.CommandLineBuildServiceFactory
import uk.co.ibuildstuff.teamcity.swift.common.SwiftBuildBean

class SwiftBuildServiceFactory : CommandLineBuildServiceFactory {
    private val bean = SwiftBuildBean()

    override fun getBuildRunnerInfo(): AgentBuildRunnerInfo = object : AgentBuildRunnerInfo {
        override fun getType(): String = bean.runTypeName
        override fun canRun(agentConfiguration: BuildAgentConfiguration): Boolean = true
    }

    override fun createService(): CommandLineBuildService = SwiftBuildSession()
}