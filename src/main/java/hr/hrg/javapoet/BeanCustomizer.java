package hr.hrg.javapoet;

import com.palantir.javapoet.FieldSpec;
import com.palantir.javapoet.MethodSpec;

public interface BeanCustomizer {
    void customize(
            FieldSpec.Builder field,
            MethodSpec.Builder getter,
            MethodSpec.Builder setter);
}
