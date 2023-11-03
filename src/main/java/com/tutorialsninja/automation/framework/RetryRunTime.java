package com.tutorialsninja.automation.framework;

import com.tutorialsninja.automation.util.ListenerClass;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.IFactoryAnnotation;
import org.testng.annotations.IListenersAnnotation;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class RetryRunTime extends ListenerClass implements IAnnotationTransformer {



    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        annotation.setRetryAnalyzer(Retry.class);
    }
}
