package com.redhat.ceylon.compiler.java.runtime.metamodel;

import java.util.LinkedHashMap;
import java.util.List;

import ceylon.language.Iterator;
import ceylon.language.Map;
import ceylon.language.Sequential;
import ceylon.language.finished_;
import ceylon.language.model.declaration.OpenParameterisedType$impl;
import ceylon.language.model.declaration.OpenType;
import ceylon.language.model.declaration.OpenType$impl;

import com.redhat.ceylon.compiler.java.Util;
import com.redhat.ceylon.compiler.java.language.InternalMap;
import com.redhat.ceylon.compiler.java.metadata.Ceylon;
import com.redhat.ceylon.compiler.java.metadata.Ignore;
import com.redhat.ceylon.compiler.java.metadata.TypeInfo;
import com.redhat.ceylon.compiler.java.metadata.TypeParameter;
import com.redhat.ceylon.compiler.java.metadata.TypeParameters;
import com.redhat.ceylon.compiler.java.metadata.Variance;
import com.redhat.ceylon.compiler.java.runtime.model.ReifiedType;
import com.redhat.ceylon.compiler.java.runtime.model.TypeDescriptor;

@Ceylon(major = 5)
@com.redhat.ceylon.compiler.java.metadata.Class
@TypeParameters({
    @TypeParameter(value = "DeclarationType", variance = Variance.OUT, satisfies = "ceylon.language.model.declaration::ClassOrInterfaceDeclaration"),
    })
public class FreeParameterisedType<DeclarationType extends ceylon.language.model.declaration.ClassOrInterfaceDeclaration>
    implements ceylon.language.model.declaration.OpenParameterisedType<DeclarationType>, ReifiedType {

    private volatile boolean initialised;
    final com.redhat.ceylon.compiler.typechecker.model.ProducedType producedType;
    protected com.redhat.ceylon.compiler.java.runtime.metamodel.FreeClassOrInterface declaration;
    protected ceylon.language.Map<? extends ceylon.language.model.declaration.TypeParameter, ? extends ceylon.language.model.declaration.OpenType> typeArguments;
    protected ceylon.language.model.declaration.OpenParameterisedType<ceylon.language.model.declaration.ClassDeclaration> superclass;
    protected Sequential<ceylon.language.model.declaration.OpenParameterisedType<ceylon.language.model.declaration.InterfaceDeclaration>> interfaces;
    
    public String toString() {
        return producedType.getProducedTypeName();
    }
    
    FreeParameterisedType(@Ignore TypeDescriptor $reifiedDeclarationType, com.redhat.ceylon.compiler.typechecker.model.ProducedType producedType){
        this.producedType = producedType;
    }

    @Override
    @Ignore
    public OpenType$impl $ceylon$language$model$declaration$OpenType$impl() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @Ignore
    public OpenParameterisedType$impl $ceylon$language$model$declaration$OpenParameterisedType$impl() {
        // TODO Auto-generated method stub
        return null;
    }

    protected void checkInit(){
        if(!initialised){
            // FIXME: lock on model loader?
            synchronized(this){
                if(!initialised){
                    init();
                    initialised = true;
                }
            }
        }
    }
    
    protected void init() {
        com.redhat.ceylon.compiler.typechecker.model.ClassOrInterface decl = (com.redhat.ceylon.compiler.typechecker.model.ClassOrInterface) producedType.getDeclaration();
        this.declaration = (FreeClassOrInterface) Metamodel.getOrCreateMetamodel(decl);
        java.util.Map<ceylon.language.model.declaration.TypeParameter, ceylon.language.model.declaration.OpenType> typeArguments 
            = new LinkedHashMap<ceylon.language.model.declaration.TypeParameter, ceylon.language.model.declaration.OpenType>();
        Iterator<? extends ceylon.language.model.declaration.TypeParameter> typeParameters = declaration.getTypeParameterDeclarations().iterator();
        Object it;
        java.util.Map<com.redhat.ceylon.compiler.typechecker.model.TypeParameter, com.redhat.ceylon.compiler.typechecker.model.ProducedType> ptArguments 
            = producedType.getTypeArguments();
        while((it = typeParameters.next()) != finished_.$get()){
            com.redhat.ceylon.compiler.java.runtime.metamodel.FreeTypeParameter tp = (com.redhat.ceylon.compiler.java.runtime.metamodel.FreeTypeParameter) it;
            com.redhat.ceylon.compiler.typechecker.model.TypeParameter tpDecl = (com.redhat.ceylon.compiler.typechecker.model.TypeParameter) tp.declaration;
            com.redhat.ceylon.compiler.typechecker.model.ProducedType ptArg = ptArguments.get(tpDecl);
            OpenType ptArgWrapped = Metamodel.getMetamodel(ptArg);
            typeArguments.put(tp, ptArgWrapped);
        }
        this.typeArguments = new InternalMap<ceylon.language.model.declaration.TypeParameter, 
                                             ceylon.language.model.declaration.OpenType>(ceylon.language.model.declaration.TypeParameter.$TypeDescriptor, 
                                                                                             ceylon.language.model.declaration.OpenType.$TypeDescriptor, 
                                                                                             typeArguments);
        
        com.redhat.ceylon.compiler.typechecker.model.ProducedType superType = decl.getExtendedType();
        if(superType != null){
            com.redhat.ceylon.compiler.typechecker.model.ProducedType superTypeResolved = superType.substitute(producedType.getTypeArguments());
            this.superclass = (ceylon.language.model.declaration.OpenParameterisedType<ceylon.language.model.declaration.ClassDeclaration>) Metamodel.getMetamodel(superTypeResolved);
        }
        
        List<com.redhat.ceylon.compiler.typechecker.model.ProducedType> satisfiedTypes = decl.getSatisfiedTypes();
        ceylon.language.model.declaration.OpenParameterisedType<ceylon.language.model.declaration.InterfaceDeclaration>[] interfaces 
            = new ceylon.language.model.declaration.OpenParameterisedType[satisfiedTypes.size()];
        int i=0;
        for(com.redhat.ceylon.compiler.typechecker.model.ProducedType pt : satisfiedTypes){
            com.redhat.ceylon.compiler.typechecker.model.ProducedType resolvedPt = pt.substitute(producedType.getTypeArguments());
            interfaces[i++] = (ceylon.language.model.declaration.OpenParameterisedType<ceylon.language.model.declaration.InterfaceDeclaration>) 
                    Metamodel.getMetamodel(resolvedPt);
        }
        this.interfaces = (Sequential)Util.sequentialInstance(FreeClassOrInterface.$InterfacesTypeDescriptor, interfaces);
    }

    @Override
    @TypeInfo("ceylon.language::Map<ceylon.language.model.declaration::TypeParameter,ceylon.language.model.declaration::OpenType>")
    public Map<? extends ceylon.language.model.declaration.TypeParameter, ? extends OpenType> getTypeArguments() {
        return typeArguments;
    }

    @Override
    @TypeInfo("DeclarationType")
    public DeclarationType getDeclaration() {
        checkInit();
        return (DeclarationType)declaration;
    }

    @Override
    @TypeInfo("ceylon.language::Sequential<ceylon.language.model.declaration::OpenParameterisedType<ceylon.language.model.declaration::InterfaceDeclaration>>")
    public Sequential<? extends ceylon.language.model.declaration.OpenParameterisedType<ceylon.language.model.declaration.InterfaceDeclaration>> getInterfaces() {
        checkInit();
        return interfaces;
    }

    @Override
    @TypeInfo("ceylon.language.model.declaration::OpenParameterisedType<ceylon.language.model.declaration::ClassDeclaration>|ceylon.language::Null")
    public ceylon.language.model.declaration.OpenParameterisedType<ceylon.language.model.declaration.ClassDeclaration> getSuperclass() {
        checkInit();
        return superclass;
    }

    @Override
    @Ignore
    public TypeDescriptor $getType() {
        checkInit();
        return TypeDescriptor.klass(FreeParameterisedType.class, declaration.$getType());
    }
}
