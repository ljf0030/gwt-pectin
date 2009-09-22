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

package com.pietschy.gwt.pectin.client;

import com.pietschy.gwt.pectin.client.binding.AbstractFieldBinding;
import com.pietschy.gwt.pectin.client.binding.AbstractFormattedBinding;
import com.pietschy.gwt.pectin.client.binding.AbstractListBinding;
import com.pietschy.gwt.pectin.client.binding.WidgetBinder;

/**
 * BindingCallbacks can be added to {@link FormModel}s by plugins to be notified when new
 * bindings are created by {@link WidgetBinder}.  This allows plugins to hook into the binding
 * process and install custom functionality.
 */
public interface BindingCallback
{
   <T> void onWidgetBinding(AbstractFieldBinding<T> binding, FieldModel<T> model, Object target);

   <T> void onWidgetBinding(AbstractFormattedBinding<T> binding, FormattedFieldModel<T> model, Object target);

   <T> void onWidgetBinding(AbstractListBinding binding, ListFieldModel<T> model, Object target);

}
