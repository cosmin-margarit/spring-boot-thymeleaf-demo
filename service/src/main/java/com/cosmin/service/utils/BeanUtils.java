package com.cosmin.service.utils;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.BeansException;

import java.beans.FeatureDescriptor;
import java.util.stream.Stream;

public class BeanUtils extends org.springframework.beans.BeanUtils {

    public static void copyPropertiesNotNull(Object source, Object target) throws BeansException {
        copyPropertiesNotNull(source, target, getNullPropertyNames(source));
    }

    public static void copyPropertiesNotNull(Object source, Object target, String... ignoreProperties) throws BeansException {
        String[] nullPropertyNames = getNullPropertyNames(source);
        String[] completeIgnoreList = new String[nullPropertyNames.length + ignoreProperties.length];
        if (nullPropertyNames.length > 0) {
            System.arraycopy(nullPropertyNames, 0, completeIgnoreList, 0, nullPropertyNames.length);
        }
        if (ignoreProperties.length > 0) {
            System.arraycopy(ignoreProperties, 0, completeIgnoreList, nullPropertyNames.length, nullPropertyNames.length);
        }
        org.springframework.beans.BeanUtils.copyProperties(source, target, completeIgnoreList);
    }

    private static String[] getNullPropertyNames(Object source) {
        final BeanWrapper wrappedSource = new BeanWrapperImpl(source);
        return Stream.of(wrappedSource.getPropertyDescriptors())
                .map(FeatureDescriptor::getName)
                .filter(propertyName -> wrappedSource.getPropertyValue(propertyName) == null)
                .toArray(String[]::new);
    }
}