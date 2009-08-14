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

package com.pietschy.gwt.pectin.client.value;

import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.pietschy.gwt.pectin.client.value.Function;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: andrew
 * Date: Jul 1, 2009
 * Time: 11:42:05 AM
 * To change this template use File | Settings | File Templates.
 */
public class ValueModelFunction<T, S>
extends AbstractValueModel<T>
{
   private Function<T,S> function;
   private ArrayList<ValueModel<S>> sourceModels = new ArrayList<ValueModel<S>>();
   private ValueChangeHandler<S> changeMonitor = new ValueChangeHandler<S>()
   {
      public void onValueChange(ValueChangeEvent<S> event)
      {
         recompute();
      }
   };
   
   private T computedValue = null;

   public ValueModelFunction(Function<T, S> function)
   {
      if (function == null)
      {
         throw new NullPointerException("function is null");
      }
      this.function = function;
   }

   public void addSourceModels(ValueModel<S>[] models)
   {
      for (ValueModel<S> model : models)
      {
         addImpl(model, false);
      }
      
      recompute();
   }
   
   public void addSourceModels(List<ValueModel<S>> models)
   {
      for (ValueModel<S> model : models)
      {
         addImpl(model, false);
      }
      
      recompute();
   }
   
   public void addSourceModels(ValueModel<S> first, ValueModel<S>... others)
   {
      addImpl(first, false);
      for (ValueModel<S> other : others)
      {
         addImpl(other, false);
      }
      
      recompute();
   }

   public void addSourceModel(ValueModel<S> model)
   {
      addImpl(model, true);
   }
   
   private void addImpl(ValueModel<S> model, boolean recompute)
   {
      model.addValueChangeHandler(changeMonitor);
      sourceModels.add(model);
      if (recompute)
      {
         recompute();
      }
   }

   private void recompute()
   {
      ArrayList<S> values = new ArrayList<S>();
      for (ValueModel<S> model : sourceModels)
      {
         values.add(model.getValue()); 
      }
      
      computedValue = function.compute(values);
      
      fireValueChangeEvent(computedValue);
   }

   public T getValue()
   {
      return computedValue;
   }
}