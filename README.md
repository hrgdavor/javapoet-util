
## checkstyle
ignored
 - MethodName (uppercase method names for modifier builder)


Add field example

```java
// intended declaration:
private String type;

// normal JavaPoet
builder.addField(FieldSpec.builder( String.class, "type", Modifier.PRIVATE).build());

// versus with utility
addField(builder, PRIVATE(), String.class, "type");
```

Add field with initializer

```java
// intended declaration:
public static final PRIMARY = null;

// normal JavaPoet
builder.addField(
		FieldSpec.builder( String.class,"PRIMARY",Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
		.initializer("null").build() );

// versus with utility
addField(builder, PUBLIC().STATIC().FINAL(), String.class, "PRIMARY", field-> {
	field.initializer("null");
});
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
