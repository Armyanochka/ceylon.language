package com.redhat.ceylon.compiler.java.runtime.metamodel;

import ceylon.language.model.declaration.Declaration$impl;
import ceylon.language.model.declaration.TypeParameter$impl;

import com.redhat.ceylon.compiler.java.metadata.Ceylon;
import com.redhat.ceylon.compiler.java.metadata.Ignore;
import com.redhat.ceylon.compiler.java.runtime.model.ReifiedType;
import com.redhat.ceylon.compiler.java.runtime.model.TypeDescriptor;
import com.redhat.ceylon.compiler.typechecker.model.TypeParameter;

@Ceylon(major = 5)
@com.redhat.ceylon.compiler.java.metadata.Class
public class FreeTypeParameter
    implements ceylon.language.model.declaration.TypeParameter, ReifiedType {

    @Ignore
    public static final TypeDescriptor $TypeDescriptor = TypeDescriptor.klass(FreeTypeParameter.class);
    
    TypeParameter declaration;
    
    @Override
    public String toString() {
        String string = declaration.getName();
        return string;
    }
    
    public FreeTypeParameter(com.redhat.ceylon.compiler.typechecker.model.TypeParameter declaration) {
        this.declaration = declaration;
    }

    @Override
    @Ignore
    public Declaration$impl $ceylon$language$model$declaration$Declaration$impl() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @Ignore
    public TypeParameter$impl $ceylon$language$model$declaration$TypeParameter$impl() {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    @Ignore
    public TypeDescriptor $getType() {
        return $TypeDescriptor;
    }

    @Override
    public String getName() {
        return declaration.getName();
    }
}
