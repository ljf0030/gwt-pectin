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

package com.pietschy.gwt.pectin.client.metadata;

import com.pietschy.gwt.pectin.client.value.ValueModel;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * User: andrew
 * Date: Oct 27, 2009
 * Time: 1:24:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class WatermarkBuilder
{
   private Collection<Metadata> allMetadata;

   protected WatermarkBuilder(Metadata metadata)
   {
      this(Arrays.asList(metadata));
   }
   
   protected WatermarkBuilder(Collection<Metadata> metadata)
   {
      this.allMetadata = metadata;
   }

   public void with(String watermark)
   {
      for (Metadata metadata : allMetadata)
      {
         metadata.setWatermark(watermark);
      }
   }

   public void with(ValueModel<String> model)
   {
      for (Metadata metadata : allMetadata)
      {
         metadata.setWatermarkModel(model);
      }
   }

   public <T> WatermarkFormatBuilder<T> withValueOf(ValueModel<T> model)
   {
      return new WatermarkFormatBuilder<T>(allMetadata, model);
   }
}
