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

package com.pietschy.gwt.pectin.client.style;

import com.google.gwt.user.client.ui.UIObject;
import com.pietschy.gwt.pectin.client.binding.AbstractBinder;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: andrew
 * Date: Aug 14, 2009
 * Time: 12:14:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class StyleBinder 
   extends AbstractBinder
{
   public StyleBindingBuilder style(UIObject widget)
   {
      return new StyleBindingBuilder(this, Arrays.asList(widget));
   }

   public StyleBindingBuilder style(UIObject widget, UIObject... others)
   {
      ArrayList<UIObject> widgets = new ArrayList<UIObject>();
      widgets.add(widget);
      widgets.addAll(Arrays.asList(others));
      return new StyleBindingBuilder(this, widgets);
   }
}
