package com.sunflower.java;

import java.lang.annotation.Annotation;

public class AnnotationTest {
    public static void main(String[] args) {
        Annotation[] annotations = AnnotationT2.class.getAnnotations();
        for (int i=0;i<annotations.length;i++){
            System.out.println(annotations[i]);
            /*@com.sunflower.java.MyAnnotations(value=
            [@com.sunflower.java.MyAnnotation(value=[11, 22], value1=[tt, ss]),
            @com.sunflower.java.MyAnnotation(value=[55, 66], value1=[qq, cc])])*/
        }
    }
}
@MyAnnotation(value = {"11","22"},value1 = {"tt","ss"})
@MyAnnotation(value = {"55","66"},value1 = {"qq","cc"})
class AnnotationT1{
}

class AnnotationT2 extends AnnotationT1{
}
