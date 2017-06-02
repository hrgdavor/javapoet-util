package hr.hrg.javapoet;

import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.MethodSpec;

public interface BeanCustomizer {
    void customize(
            FieldSpec.Builder field,
            MethodSpec.Builder getter,
            MethodSpec.Builder setter);
}
