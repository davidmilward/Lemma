/*
 * generated by Xtext 2.10.0
 */
package com.beenleigh.dsl.serializer;

import com.beenleigh.dsl.lemma.DataClass;
import com.beenleigh.dsl.lemma.DataElement;
import com.beenleigh.dsl.lemma.DataModel;
import com.beenleigh.dsl.lemma.DataType;
import com.beenleigh.dsl.lemma.Import;
import com.beenleigh.dsl.lemma.LemmaPackage;
import com.beenleigh.dsl.lemma.Lemmamodel;
import com.beenleigh.dsl.services.LemmaGrammarAccess;
import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class LemmaSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private LemmaGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == LemmaPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case LemmaPackage.DATA_CLASS:
				sequence_DataClass(context, (DataClass) semanticObject); 
				return; 
			case LemmaPackage.DATA_ELEMENT:
				sequence_DataElement(context, (DataElement) semanticObject); 
				return; 
			case LemmaPackage.DATA_MODEL:
				sequence_DataModel(context, (DataModel) semanticObject); 
				return; 
			case LemmaPackage.DATA_TYPE:
				sequence_DataType(context, (DataType) semanticObject); 
				return; 
			case LemmaPackage.IMPORT:
				sequence_Import(context, (Import) semanticObject); 
				return; 
			case LemmaPackage.LEMMAMODEL:
				sequence_Lemmamodel(context, (Lemmamodel) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Contexts:
	 *     AbstractItem returns DataClass
	 *     ContainerElement returns DataClass
	 *     DataClass returns DataClass
	 *
	 * Constraint:
	 *     (name=ID superType=[DataClass|ID]? dataelements+=ContainerElement*)
	 */
	protected void sequence_DataClass(ISerializationContext context, DataClass semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     ContainerElement returns DataElement
	 *     DataElement returns DataElement
	 *
	 * Constraint:
	 *     (name=ID type=[DataType|QualifiedName])
	 */
	protected void sequence_DataElement(ISerializationContext context, DataElement semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, LemmaPackage.Literals.CONTAINER_ELEMENT__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, LemmaPackage.Literals.CONTAINER_ELEMENT__NAME));
			if (transientValues.isValueTransient(semanticObject, LemmaPackage.Literals.DATA_ELEMENT__TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, LemmaPackage.Literals.DATA_ELEMENT__TYPE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getDataElementAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getDataElementAccess().getTypeDataTypeQualifiedNameParserRuleCall_3_0_1(), semanticObject.getType());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     DataModel returns DataModel
	 *     AbstractItem returns DataModel
	 *
	 * Constraint:
	 *     (name=QualifiedName elements+=AbstractItem*)
	 */
	protected void sequence_DataModel(ISerializationContext context, DataModel semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     AbstractItem returns DataType
	 *     DataType returns DataType
	 *
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_DataType(ISerializationContext context, DataType semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, LemmaPackage.Literals.DATA_TYPE__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, LemmaPackage.Literals.DATA_TYPE__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getDataTypeAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     AbstractItem returns Import
	 *     Import returns Import
	 *
	 * Constraint:
	 *     importedNamespace=QualifiedNameWithWildcard
	 */
	protected void sequence_Import(ISerializationContext context, Import semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, LemmaPackage.Literals.IMPORT__IMPORTED_NAMESPACE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, LemmaPackage.Literals.IMPORT__IMPORTED_NAMESPACE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameWithWildcardParserRuleCall_1_0(), semanticObject.getImportedNamespace());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Lemmamodel returns Lemmamodel
	 *
	 * Constraint:
	 *     elements+=AbstractItem+
	 */
	protected void sequence_Lemmamodel(ISerializationContext context, Lemmamodel semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
}
