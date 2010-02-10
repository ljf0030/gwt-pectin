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

package com.pietschy.gwt.pectin.client.metadata.binding;

import com.pietschy.gwt.pectin.client.Field;
import com.pietschy.gwt.pectin.client.binding.AbstractBinder;
import com.pietschy.gwt.pectin.client.condition.Conditions;
import com.pietschy.gwt.pectin.client.metadata.MetadataPlugin;
import com.pietschy.gwt.pectin.client.value.ValueModel;

/**
 * Created by IntelliJ IDEA.
 * User: andrew
 * Date: Jul 13, 2009
 * Time: 12:44:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class MetadataBinder
extends AbstractBinder
{

   /** Binds all the metadata of the specific field to a widget.  The metadata will only be applied
    * if the widget has a supported binding.  No errors will be thrown if it doesn't.
    * @param field the field that has the metadata.
    * @return a builder to apply the styles to a widget.
    */
   public AllMetadataBindingBuilder bindMetadataOf(Field field)
   {
      return new AllMetadataBindingBuilder(this, MetadataPlugin.getMetadata(field));
   }
   
   public VisibilityBindingBuilder bindVisibilityOf(Field field)
   {
      return new VisibilityBindingBuilder(this, MetadataPlugin.getMetadata(field).getVisibleModel());
   }
   
   public EnabledBindingBuilder bindEnabledOf(Field field)
   {
      return new EnabledBindingBuilder(this, MetadataPlugin.getMetadata(field).getEnabledModel());
   }
   
   public EnabledBindingBuilder bindDisabledOf(Field field)
   {
      return new EnabledBindingBuilder(this, Conditions.isNot(MetadataPlugin.getMetadata(field).getEnabledModel()));
   }

   /**
    * Binds the value of an arbitrary boolean model to the enabledness and/or visibility of
    * component.
    * @param model the value model to bind to.
    * @return the
    */
   public ValueOfBindingBuilder bindValueOf(ValueModel<Boolean> model)
   {
      return new ValueOfBindingBuilder(this, model);
   }

}