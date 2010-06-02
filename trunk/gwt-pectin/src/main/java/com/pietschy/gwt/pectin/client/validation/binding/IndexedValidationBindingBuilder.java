/*
 * Copyright 2009 Andrew Pietsch 
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you 
 * may not use this file except in compliance with the License. You may 
 * obtain a copy of the License at 
 *      
 *      http://www.apache.org/licenses/LICENSE-2.0 
 *
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or 
 * implied. See the License for the specific language governing permissions 
 * and limitations under the License. 
 */

package com.pietschy.gwt.pectin.client.validation.binding;

import com.google.gwt.user.client.ui.UIObject;
import com.pietschy.gwt.pectin.client.validation.HasIndexedValidationResult;
import com.pietschy.gwt.pectin.client.validation.component.IndexedValidationDisplay;
import com.pietschy.gwt.pectin.client.validation.component.ValidationStyles;

/**
 * Created by IntelliJ IDEA.
* User: andrew
* Date: Sep 15, 2009
* Time: 12:09:52 PM
* To change this template use File | Settings | File Templates.
*/
public class IndexedValidationBindingBuilder
{
   private HasIndexedValidationResult validator;
   private ValidationBinder binder;
   private ValidationStyles validationStyles;

   public IndexedValidationBindingBuilder(ValidationBinder binder, HasIndexedValidationResult validator, ValidationStyles validationStyles)
   {
      this.binder = binder;
      this.validator = validator;
      this.validationStyles = validationStyles;
   }
   
   public void to(final IndexedValidationDisplay validationDisplay)
   {
      binder.registerDisposableAndUpdateTarget(new IndexedValidationDisplayBinding(validator, validationDisplay));
   }
   
   public void toStyle(UIObject widget)
   {
      binder.registerDisposableAndUpdateTarget(new ValidationStyleBinding(validator, widget, validationStyles));
   }
   
   
}
