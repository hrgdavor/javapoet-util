# Utility for my personal style when using [JavaPoet](https://github.com/square/javapoet)

## checkstyle
using checkstyle settings from javapoet library, but ignored some rules 
 - MethodName (uppercase method names for modifier builder)

# Example code-producing changes with this utility and abse for requesting changes in original javapoet

## Add field
intended declaration:

```java
private String type;
```

normal JavaPoet

```java
builder.addField(FieldSpec.builder( String.class, "type", Modifier.PRIVATE).build());
```

with this utility

```java
addField(builder, PRIVATE(), String.class, "type");
```

## Add field with initializer

intended declaration:

```java
public static final String PRIMARY = null;
```

normal JavaPoet

```java
builder.addField(
		FieldSpec.builder(String.class, "PRIMARY", Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
		.initializer("return $L", varName).build() );
```

with this utility

```java
addField(builder, PUBLIC().STATIC().FINAL(), String.class, "PRIMARY", "return $L", varName);

with this utility (different line break)
```

```java
addField(builder, PUBLIC().STATIC().FINAL(), 
	String.class, "PRIMARY", "return $L", varName);
```

## Add parameter to a method

intended declaration for one of the parameters:

```
...(..., boolean primitive)...
```

normal JavaPoet

```java
method.addParameter(ParameterSpec.builder(boolean.class, "primitive").build());
```

with this utility
```java
addParameter(method, boolean.class, "primitive");
```

## Add field with getter and setter (bean style)

intended declaration for one of the parameters:

```java
private boolean primitive;
public booelan isPrimitive(){ 
	return primitive; 
}
public booelan setPrimitive(boolean primitive){ 
	this.primitive = primitive; 
}
```

normal JavaPoet

```java
builder.addField(FieldSpec.builder( boolean.class, "primitive", Modifier.PRIVATE).build());

builder.addMethod( MethodSpec.methodBuilder("isPrimitive")
	.addModifiers(Modifier.PUBLIC)
	.addCode("return primitive;").build());

builder.addMethod( MethodSpec.methodBuilder("setPrimitive")
		.addModifiers(Modifier.PUBLIC)
		.addParameter(boolean.class,"primitive")
		.addCode("this.primitive = primitive;\n").build());
```

with this utility

```java
addBeanField(enumbuilder, boolean.class, "primitive");
```
