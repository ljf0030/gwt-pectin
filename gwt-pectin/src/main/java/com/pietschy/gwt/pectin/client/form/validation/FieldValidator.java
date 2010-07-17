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

package com.pietschy.gwt.pectin.client.form.validation;

import com.pietschy.gwt.pectin.client.form.validation.message.ValidationMessage;

/**
 * Created by IntelliJ IDEA.
 * User: andrew
 * Date: Jul 13, 2009
 * Time: 9:01:36 AM
 * To change this template use File | Settings | File Templates.
 */
public interface FieldValidator<T> extends HasValidation
{

   /**
    * Runs all the validator and stores the result in the specified collector.  The validation result
    * is not updated and no widgets will be affected.  This allows you to check the validation of a
    * field without affecting the model state.
    * 
    * @param collector the result collector.
    */
   void runValidators(ValidationResultCollector collector);

   /**
    * Adds a validation message from an external source.
    * 
    * @param message the message to add.
    */
   void addExternalMessage(ValidationMessage message);

}
