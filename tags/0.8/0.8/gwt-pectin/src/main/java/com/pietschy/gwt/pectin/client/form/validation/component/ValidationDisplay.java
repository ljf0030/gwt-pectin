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

package com.pietschy.gwt.pectin.client.form.validation.component;

import com.pietschy.gwt.pectin.client.form.validation.ValidationResult;

/**
 * ValidationDisplay denotes components that can display {@link ValidationResult}s.
 */
public interface ValidationDisplay
{
   /**
    * Sets the {@link ValidationResult} to display.
    * @param result the validation result to display.
    */
   void setValidationResult(ValidationResult result);
}
