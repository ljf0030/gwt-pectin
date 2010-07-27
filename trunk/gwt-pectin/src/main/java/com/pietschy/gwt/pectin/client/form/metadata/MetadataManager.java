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

package com.pietschy.gwt.pectin.client.form.metadata;

import com.google.gwt.user.client.ui.TextBox;
import com.pietschy.gwt.pectin.client.binding.AbstractBinding;
import com.pietschy.gwt.pectin.client.form.*;
import com.pietschy.gwt.pectin.client.form.metadata.binding.AllMetadataBindingBuilder;
import com.pietschy.gwt.pectin.client.form.metadata.binding.TextBoxWatermarkable;
import com.pietschy.gwt.pectin.client.form.metadata.binding.WatermarkBinding;
import com.pietschy.gwt.pectin.client.value.ValueModel;

import java.util.HashMap;

/**
 * Created by IntelliJ IDEA.
 * User: andrew
 * Date: Aug 1, 2009
 * Time: 12:28:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class MetadataManager
   implements BindingCallback
{
   private HashMap<Field, Metadata> metadataMap = new HashMap<Field, Metadata>();

   public Metadata getMetadata(Field fieldModel)
   {
      Metadata metadata = metadataMap.get(fieldModel);

      if (metadata == null)
      {
         metadata = new Metadata();
         metadataMap.put(fieldModel, metadata);
      }

      return metadata;
   }

   public <T> void onWidgetBinding(AbstractBinding binding, FieldModel<T> model, Object target)
   {
      new AllMetadataBindingBuilder(binding, getMetadata(model)).to(target);

      // if we're a FieldModel<String> then we're capable of a water mark.
      if (String.class.getName().equals(model.getValueClass().getName()))
      {
         doWatermarkBindings(binding, (ValueModel<String>) model, getMetadata(model).getWatermarkModel(), target);
      }

   }

   public <T> void onWidgetBinding(AbstractBinding binding, FormattedFieldModel<T> model, Object target)
   {
      doWatermarkBindings(binding, model.getTextModel(), getMetadata(model).getWatermarkModel(), target);

      new AllMetadataBindingBuilder(binding, getMetadata(model)).to(target);
   }

   private void doWatermarkBindings(AbstractBinding binding, ValueModel<String> textModel, ValueModel<String> watermarkModel, Object target)
   {
      Watermarkable watermarkable = prepareWatermarkable(target);
      if (watermarkable != null)
      {
         binding.registerDisposableAndUpdateTarget(new WatermarkBinding(textModel, watermarkModel, watermarkable));
      }
   }

   Watermarkable prepareWatermarkable(Object target)
   {
      if (target instanceof Watermarkable)
      {
         return (TextBoxWatermarkable) target;
      }
      else if (target instanceof TextBox)
      {
         return new TextBoxWatermarkable((TextBox) target);
      }
      else
      {
         return null;
      }
   }

   public <T> void onWidgetBinding(AbstractBinding binding, ListFieldModel<T> model, Object target)
   {
      new AllMetadataBindingBuilder(binding, getMetadata(model)).to(target);
   }

   public <T> void onWidgetBinding(AbstractBinding binding, FormattedListFieldModel<T> model, Object target)
   {
      // todo: should really support water marks here too....
      new AllMetadataBindingBuilder(binding, getMetadata(model)).to(target);
   }
}
