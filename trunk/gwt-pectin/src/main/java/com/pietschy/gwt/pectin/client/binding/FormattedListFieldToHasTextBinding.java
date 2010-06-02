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

package com.pietschy.gwt.pectin.client.binding;

import com.google.gwt.user.client.ui.HasText;
import com.pietschy.gwt.pectin.client.FormattedListFieldModel;
import com.pietschy.gwt.pectin.client.format.ListDisplayFormat;
import com.pietschy.gwt.pectin.client.list.ListModel;

/**
 *
 */
public class FormattedListFieldToHasTextBinding<T>
extends AbstractListBinding<T> implements HasListDisplayFormat<T>
{
   private HasText widget;
   private ListDisplayFormat<? super T> format;

   public FormattedListFieldToHasTextBinding(FormattedListFieldModel<T> field, HasText widget, ListDisplayFormat<? super T> format)
   {
      super(field);
      this.widget = widget;
      this.format = format;
   }

   public HasText getTarget()
   {
      return widget;
   }

   @Override
   protected void updateTarget(ListModel<T> model)
   {
      getTarget().setText(format.format(model.asUnmodifiableList()));
   }

   @Override
   protected FormattedListFieldModel<T> getModel()
   {
      return (FormattedListFieldModel<T>) super.getModel();
   }

   public void setFormat(ListDisplayFormat<? super T> format)
   {
      if (format == null)
      {
         throw new NullPointerException("format is null");
      }
      this.format = format;
      updateTarget();
   }
}