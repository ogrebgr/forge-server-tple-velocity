package com.bolyartech.forge.server.tple.velocity;

import com.bolyartech.forge.server.misc.TemplateEngine;
import com.bolyartech.forge.server.misc.TemplateEngineFactory;
import org.apache.velocity.app.VelocityEngine;

import java.util.Properties;


public class VelocityTemplateEngineFactory implements TemplateEngineFactory {
    private final VelocityEngine mVelocityEngine;
    private final String mTemplatePathPrefix;


    public VelocityTemplateEngineFactory(String templatePathPrefix) {
        mVelocityEngine = new VelocityEngine();
        Properties properties = new Properties();
        properties.setProperty("resource.loader", "class");
        properties.setProperty(
                "class.resource.loader.class",
                "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        mVelocityEngine.init(properties);

        mTemplatePathPrefix = templatePathPrefix;
    }


    @Override
    public TemplateEngine createNew() {
        return new VelocityTemplateEngine(mVelocityEngine, mTemplatePathPrefix);
    }
}
