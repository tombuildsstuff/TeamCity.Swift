package uk.co.ibuildstuff.teamcity.swift.server

import jetbrains.buildServer.serverSide.InvalidProperty
import jetbrains.buildServer.serverSide.PropertiesProcessor
import jetbrains.buildServer.serverSide.RunType
import jetbrains.buildServer.web.openapi.PluginDescriptor
import org.springframework.beans.factory.annotation.Autowired

abstract class SwiftRunTypeBase : RunType() {
    @Autowired
    lateinit var descriptor: PluginDescriptor

    protected abstract fun getEditJsp(): String
    protected abstract fun getViewJsp(): String

    abstract override fun getType(): String
    abstract override fun getDisplayName(): String
    abstract override fun getDescription(): String

    override fun getRunnerPropertiesProcessor(): PropertiesProcessor {
        val that = this
        return PropertiesProcessor { p0 ->
            if (p0 == null) return@PropertiesProcessor arrayListOf()
            that.validateParameters(p0)
        }
    }

    protected open fun validateParameters(parameters: Map<String, String>): MutableCollection<InvalidProperty> {
        return arrayListOf()
    }

    override fun describeParameters(parameters: Map<String, String>): String {
        return ""
    }

    override fun getDefaultRunnerProperties(): MutableMap<String, String>? = hashMapOf()

    override fun getEditRunnerParamsJspFilePath(): String {
        return descriptor.getPluginResourcesPath(getEditJsp())
    }

    override fun getViewRunnerParamsJspFilePath(): String {
        return descriptor.getPluginResourcesPath(getViewJsp())
    }
}