package de.kuschku.cytubebot2.utils;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.stream.Collectors;

public class ClassPathScanner {
    public static List<Class<?>> findAnnotatedClasses(String scanPackage, Class<? extends Annotation> clazz) {
        return createComponentScanner(clazz)
                .findCandidateComponents(scanPackage)
                .stream()
                .map(BeanDefinition::getBeanClassName)
                .<Class<?>>map(OptionalUtils.wrapException(Class::forName, System.err::println))
                .collect(Collectors.toList());
    }

    private static ClassPathScanningCandidateComponentProvider createComponentScanner(
            Class<? extends Annotation> clazz) {
        ClassPathScanningCandidateComponentProvider provider
                = new ClassPathScanningCandidateComponentProvider(false);
        provider.addIncludeFilter(new AnnotationTypeFilter(clazz));
        return provider;
    }
}
