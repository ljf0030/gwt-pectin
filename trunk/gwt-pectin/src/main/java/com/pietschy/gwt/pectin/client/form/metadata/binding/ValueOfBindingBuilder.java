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

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.FocusWidget;
import com.google.gwt.user.client.ui.UIObject;
import com.pietschy.gwt.pectin.client.binding.BindingContainer;
import com.pietschy.gwt.pectin.client.metadata.HasEnabled;
import com.pietschy.gwt.pectin.client.metadata.HasVisible;
import com.pietschy.gwt.pectin.client.value.ValueModel;

/**
 * Created by IntelliJ IDEA.
* User: andrew
* Date: Jul 17, 2009
* Time: 1:47:07 PM
* To change this template use File | Settings | File Templates.
*/
public class ValueOfBindingBuilder
{
   private ValueModel<Boolean> model;
   private BindingContainer container;

   public ValueOfBindingBuilder(BindingContainer container, ValueModel<Boolean> model)
   {
      this.container = container;
      this.model = model;
   }

   /**
    * Binds the visible metadata property to the speicified widget.
    *
    * @param widget the widget to bind to.
    */
   public void toVisibilityOf(UIObject widget)
   {
      container.registerBindingAndUpdateTarget(new VisibleBinding(model, widget));
   }

   /**
    * Binds the visible metadata property to the speicified widget.
    *
    * @param widget the widget to bind to.
    * @param others additional widgets to bind to.
    */
   public void toVisibilityOf(UIObject widget, UIObject... others)
   {
      container.registerBindingAndUpdateTarget(new VisibleBinding(model, widget, others));
   }

   /**
    * Binds the visible metadata property to the speicified widget.
    *
    * @param widget the widget to bind to.
    */
   public void toVisibilityOf(Element widget)
   {
      container.registerBindingAndUpdateTarget(new ElementVisibleBinding(model, widget));
   }

   /**
    * Binds the visible metadata property to the speicified widget.
    *
    * @param widget the element to bind to.
    * @param others additional elementsto bind to.
    */
   public void toVisibilityOf(Element widget, Element... others)
   {
      container.registerBindingAndUpdateTarget(new ElementVisibleBinding(model, widget, others));
   }

   /**
    * Binds the visible metadata property to the speicified widget.
    *
    * @param widget the widget to bind to.
    */
   public void toVisibilityOf(HasVisible widget)
   {
      container.registerBindingAndUpdateTarget(new HasVisibleBinding(model, widget));
   }

   /**
    * Binds the visible metadata property to the speicified widget.
    *
    * @param widget the widget to bind to.
    * @param others additional widgets to bind to.
    */
   public void toVisibilityOf(HasVisible widget, HasVisible... others)
   {
      container.registerBindingAndUpdateTarget(new HasVisibleBinding(model, widget, others));
   }

   /**
    * Binds the visible metadata property to the speicified widget.
    *
    * @param widget the widget to bind to.
    */
   public void toEnablednessOf(FocusWidget widget)
   {
      container.registerBindingAndUpdateTarget(new FocusWidgetEnabledBinding(model, widget));
   }

   /**
    * Binds the visible metadata property to the speicified widget.
    *
    * @param widget the widget to bind to.
    */
   public void toEnablednessOf(HasEnabled widget)
   {
      container.registerBindingAndUpdateTarget(new HasEnabledBinding(model, widget));
   }
}