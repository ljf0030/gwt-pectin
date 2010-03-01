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

import com.pietschy.gwt.pectin.client.FormattedListFieldModel;
import com.pietschy.gwt.pectin.client.list.GuardedListModelChangedHandler;
import com.pietschy.gwt.pectin.client.list.ListModelChangedEvent;
import com.pietschy.gwt.pectin.client.list.MutableListModel;

import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * User: andrew
 * Date: Jul 1, 2009
 * Time: 4:53:36 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractFormattedListBinding<T> extends AbstractBinding
{
   private GuardedListModelChangedHandler<String> textListMonitor = new GuardedListModelChangedHandler<String>()
   {
      public void onGuardedListDataChanged(ListModelChangedEvent<String> event)
      {
         setWidgetValues(textList.asUnmodifiableList());
      }
   };

   private FormattedListFieldModel<T> list;
   private MutableListModel<String> textList;

   public AbstractFormattedListBinding(FormattedListFieldModel<T> field)
   {
      this.list = field;
      textList = field.getTextModel();
      registerHandler(textList.addListModelChangedHandler(textListMonitor));
   }

   public FormattedListFieldModel<T> getFieldModel()
   {
      return list;
   }

   public abstract Collection<String> getWidgetValues();

   protected abstract void setWidgetValues(Collection<String> values);

   public void updateTarget()
   {
      setWidgetValues(textList.asUnmodifiableList());
   }

   protected void onWidgetChanged(Collection<String> values)
   {
      textListMonitor.setIgnoreEvents(true);
      try
      {
         list.getTextModel().setElements(values);
      }
      finally
      {
         textListMonitor.setIgnoreEvents(false);
      }
   }
}