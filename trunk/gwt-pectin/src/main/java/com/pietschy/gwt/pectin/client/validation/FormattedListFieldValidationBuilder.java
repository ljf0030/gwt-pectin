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

package com.pietschy.gwt.pectin.client.validation;

import com.pietschy.gwt.pectin.client.FormattedListFieldModel;
import com.pietschy.gwt.pectin.client.value.DelegatingValueModel;


/**
 * Created by IntelliJ IDEA.
 * User: andrew
 * Date: Jul 1, 2009
 * Time: 7:58:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class FormattedListFieldValidationBuilder<T>
{

   private FormattedListFieldValidatorImpl<T> fieldValidator;

   // create a delegating condition since we don't know if we're going to get one.  The
   // delegate returns true if there's no delegate (i.e. we alwasy validate if there's no
   // delegate
   private DelegatingValueModel<Boolean> conditionDelegate = new DelegatingValueModel<Boolean>(true);

   public FormattedListFieldValidationBuilder(ValidationManager validationManager, FormattedListFieldModel<T> field)
   {
      fieldValidator = validationManager.getFieldValidator(field, true);
   }

   public ConditionBuilder usingFieldFormat()
   {
      FieldFormatValidator<T> validator = new FieldFormatValidator<T>(fieldValidator.getFieldModel());
      fieldValidator.addTextValidator(validator, conditionDelegate);
      return new DelegatingConditionBuilder(conditionDelegate);
   }

   public ConditionBuilder usingTextValidator(ListValidator<String> validator, ListValidator<String>... others)
   {
      fieldValidator.addTextValidator(validator, conditionDelegate);

      for (ListValidator<? super String> other : others)
      {
         fieldValidator.addTextValidator(other, conditionDelegate);
      }

      return new DelegatingConditionBuilder(conditionDelegate);
   }

   public ConditionBuilder using(ListValidator<? super T> validator, ListValidator<? super T>... others)
   {
      fieldValidator.addValidator(validator, conditionDelegate);

      for (ListValidator<? super T> other : others)
      {
         fieldValidator.addValidator(other, conditionDelegate);
      }

      return new DelegatingConditionBuilder(conditionDelegate);
   }

}