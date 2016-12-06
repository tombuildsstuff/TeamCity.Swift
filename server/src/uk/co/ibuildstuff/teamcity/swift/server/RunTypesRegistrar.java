package uk.co.ibuildstuff.teamcity.swift.server;

import jetbrains.buildServer.serverSide.RunTypeRegistry;

public class RunTypesRegistrar {
  public RunTypesRegistrar(RunTypeRegistry registry, SwiftBuildRunType swiftBuildRunType) {
    registry.registerRunType(swiftBuildRunType);
  }
}
