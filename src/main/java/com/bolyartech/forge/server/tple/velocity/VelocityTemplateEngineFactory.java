package com.bolyartech.forge.server.tple.velocity;

import com.bolyartech.forge.server.misc.TemplateEngine;
import com.bolyartech.forge.server.misc.TemplateEngineFactory;
import org.apache.velocity.app.VelocityEngine;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


public class VelocityTemplateEngineFactory implements TemplateEngineFactory {
    private final VelocityEngine mVelocityEngine;
    private final String mTemplatePathPrefix;


    public VelocityTemplateEngineFactory(String templatePathPrefix, Map<String, String> additionalSettings) {
        mVelocityEngine = new VelocityEngine();
        Properties properties = new Properties();
        properties.setProperty("resource.loader", "class");
        properties.setProperty(
                "class.resource.loader.class",
                "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");

        for(String key : additionalSettings.keySet()) {
            properties.setProperty(key, additionalSettings.get(key));
        }

        mVelocityEngine.init(properties);

        mTemplatePathPrefix = templatePathPrefix;
    }


    public VelocityTemplateEngineFactory(String templatePathPrefix) {
        this(templatePathPrefix, new HashMap<>());
    }


    @Override
    public TemplateEngine createNew() {
        return new VelocityTemplateEngine(mVelocityEngine, mTemplatePathPrefix);
    }
}
