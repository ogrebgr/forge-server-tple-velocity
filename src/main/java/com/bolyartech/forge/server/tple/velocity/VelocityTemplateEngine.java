package com.bolyartech.forge.server.tple.velocity;

import com.bolyartech.forge.server.misc.TemplateEngine;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import java.io.StringWriter;


public class VelocityTemplateEngine implements TemplateEngine {
    private final VelocityEngine mVelocityEngine;
    private final VelocityContext mVelocityContext;
    private final String mTemplatePathPrefix;


    public VelocityTemplateEngine(VelocityEngine velocityEngine, String templatePathPrefix) {
        mVelocityEngine = velocityEngine;
        mVelocityContext = new VelocityContext();
        mTemplatePathPrefix = templatePathPrefix;
    }


    @Override
    public void assign(String varName, Object object) {
        mVelocityContext.put(varName, object);
    }


    @Override
    public String render(String templateName) {
        StringWriter sw = new StringWriter();
        Template t = mVelocityEngine.getTemplate(mTemplatePathPrefix + templateName);
        t.merge(mVelocityContext, sw);
        return sw.toString();
    }
}
