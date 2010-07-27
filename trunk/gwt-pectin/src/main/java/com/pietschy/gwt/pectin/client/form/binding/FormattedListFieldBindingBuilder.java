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

package com.pietschy.gwt.pectin.client.form.binding;

import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HasValue;
import com.pietschy.gwt.pectin.client.binding.BindingBuilderCallback;
import com.pietschy.gwt.pectin.client.binding.ListDisplayFormatBuilder;
import com.pietschy.gwt.pectin.client.form.FormattedListFieldModel;
import com.pietschy.gwt.pectin.client.format.CollectionToStringFormat;

import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * User: andrew
 * Date: Jul 1, 2009
 * Time: 4:48:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class FormattedListFieldBindingBuilder<T>
{
   private BindingBuilderCallback callback;
   private FormattedListFieldModel<T> field;

   public FormattedListFieldBindingBuilder(FormattedListFieldModel<T> field, BindingBuilderCallback callback)
   {
      this.callback = callback;
      this.field = field;
   }

   public SanitiseTextBuilder to(HasValue<Collection<String>> widget)
   {
      FormattedListFieldToHasValueBinding<T> binding = new FormattedListFieldToHasValueBinding<T>(field, widget);
      callback.onBindingCreated(binding, widget);
      return new SanitiseTextBuilder(binding, widget);
   }

   @Deprecated
   public ListDisplayFormatBuilder<T> toLabel(HasText label)
   {
      return toTextOf(label);
   }

   public ListDisplayFormatBuilder<T> toTextOf(HasText label)
   {
      FormattedListFieldToHasTextBinding<T> binding = new FormattedListFieldToHasTextBinding<T>(field, label, CollectionToStringFormat.DEFAULT_INSTANCE);

      callback.onBindingCreated(binding, label);

      return new ListDisplayFormatBuilder<T>(binding);
   }
}