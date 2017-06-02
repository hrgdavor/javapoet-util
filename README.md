# Utility for my personal style when using [https://github.com/square/javapoet](JavaPoet)

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

with utility

```java
addField(builder, PRIVATE(), String.class, "type");
```

## Add field with initializer

intended declaration:

```java
public static final PRIMARY = null;
```

normal JavaPoet

```java
builder.addField(
		FieldSpec.builder( String.class,"PRIMARY", Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
		.initializer("return $L", varName).build() );
```

versus with utility

```java
addField(builder, PUBLIC().STATIC().FINAL(), String.class, "PRIMARY", "return $L", varName);
//or
addField(builder, PUBLIC().STATIC().FINAL(), 
	String.class, "PRIMARY", "return $L", varName);
```

Add parameter to a method

```java
// intended declaration for one of the parameters:
method(boolean primitive)

// normal JavaPoet
method.addParameter(ParameterSpec.builder(boolean.class, "primitive").build());

// versus with utility
addParameter(method, boolean.class, "primitive");
```

Add field with getter and setter (bean style)
```java
// intended declaration for one of the parameters:
private boolean primitive;
public booelan isPrimitive(){ 
	return primitive; 
}
public booelan setPrimitive(boolean primitive){ 
	this.primitive = primitive; 
}


// normal JavaPoet
builder.addField(FieldSpec.builder( boolean.class, "primitive", Modifier.PRIVATE).build());

builder.addMethod( MethodSpec.methodBuilder("isPrimitive")
	.addModifiers(Modifier.PUBLIC)
	.addCode("return primitive;").build());

builder.addMethod( MethodSpec.methodBuilder("setPrimitive")
		.addModifiers(Modifier.PUBLIC)
		.addParameter(boolean.class,"primitive")
		.addCode("this.primitive = primitive;\n").build());


// versus with utility
addBeanField(enumbuilder, boolean.class, "primitive");
```
