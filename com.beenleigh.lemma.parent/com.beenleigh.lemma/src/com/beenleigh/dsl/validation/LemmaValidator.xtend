/*
 * generated by Xtext 2.10.0
 */
package com.beenleigh.dsl.validation

import org.eclipse.xtext.validation.Check
import com.beenleigh.dsl.lemma.LemmaPackage
import com.beenleigh.dsl.lemma.DataClass
import com.beenleigh.dsl.lemma.DataElement
import com.beenleigh.dsl.lemma.DataModel

/**
 * This class contains custom validation rules. 
 *
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
class LemmaValidator extends AbstractLemmaValidator {
	
	public static val INVALID_NAME = 'invalidName'

	@Check
	def checkDataClassStartsWithCapital(DataClass dataClass) {
		if (!Character.isUpperCase(dataClass.name.charAt(0))) {
			warning('Name should start with a capital', 
					LemmaPackage.Literals.CONTAINER_ELEMENT__NAME,
					INVALID_NAME)
		}
	}
	
	@Check
	def checkDataElementStartsWithLowerCase(DataElement dataElement) {
		if (!Character.isLowerCase(dataElement.name.charAt(0))) {
			warning('Name should start with a lower case letter', 
					LemmaPackage.Literals.CONTAINER_ELEMENT__NAME,
					INVALID_NAME)
		}
	}
	
	@Check
    def void checkDataClassNameIsUnique(DataClass dc) {
    	if(dc.superType == DataClass){
	        var superEntity = (dc.eContainer as DataClass).superType
	        while (superEntity != null) {
	            for (other : superEntity.dataelements) {
	                if (dc.name == other.name) {
	                    error("DataClass names have to be unique",
	                        LemmaPackage.Literals.CONTAINER_ELEMENT__NAME)
	                    return
	                }
	            }
	            superEntity = superEntity.getSuperType();
	        }	       
        }
    }
    
    @Check
    def checkNoCycleInEntityHierarchy(DataClass dataclass) {
    if (dataclass.superType == null)
      return // nothing to check

      val visitedEntities = <DataClass>newHashSet()
    visitedEntities.add(dataclass)
    var current = dataclass.superType
    while (current != null) {
      if (visitedEntities.contains(current)) {
        error("cycle in hierarchy of entity '"+current.name+"'",  LemmaPackage.Literals.CONTAINER_ELEMENT__NAME)
        return
      }
      visitedEntities.add(current)
      current = current.superType
     }
    }

  
    
    
    
    
    
	
}
