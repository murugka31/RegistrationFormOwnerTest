package com.emurugova.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/${platform}.properties"})
public interface ConfigForTests extends Config {

    @Config.Key("browserName")
    String getBrowser();

    @Config.Key("browserVersion")
    String getVersion();

    @Config.Key("browserSize")
    String getSize();

    @Config.Key("remoteUrl")
    String getRemoteUrl();

    @Config.Key("login")
    String getLogin();

    @Config.Key("password")
    String getPassword();
}
