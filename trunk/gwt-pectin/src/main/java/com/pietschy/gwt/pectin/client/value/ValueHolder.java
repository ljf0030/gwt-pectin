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

/**
 * Created by IntelliJ IDEA.
 * User: andrew
 * Date: Jun 30, 2009
 * Time: 7:36:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class ValueHolder<T> 
extends AbstractMutableValueModel<T>
{
   private T value;

   public ValueHolder()
   {
   }

   public ValueHolder(T value)
   {
      this.value = value;
   }

   public T getValue()
   {
      return value;
   }

   public void setValue(T newValue)
   {
      this.value = newValue;
      fireValueChangeEvent(newValue);
   }
}
