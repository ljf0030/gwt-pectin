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

package com.pietschy.gwt.pectin.demo.client.activity;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.*;
import com.pietschy.gwt.pectin.client.FieldModelBase;
import com.pietschy.gwt.pectin.client.ListFieldModelBase;
import com.pietschy.gwt.pectin.client.activity.Activity;
import com.pietschy.gwt.pectin.client.activity.binding.ActivityBinder;
import com.pietschy.gwt.pectin.client.binding.WidgetBinder;
import com.pietschy.gwt.pectin.client.components.AbstractDynamicList;
import com.pietschy.gwt.pectin.client.components.EnhancedTextBox;
import com.pietschy.gwt.pectin.client.format.DisplayFormat;
import com.pietschy.gwt.pectin.client.metadata.binding.MetadataBinder;
import com.pietschy.gwt.pectin.client.validation.binding.ValidationBinder;
import com.pietschy.gwt.pectin.client.validation.component.ValidationDisplayLabel;
import com.pietschy.gwt.pectin.demo.client.domain.Gender;
import com.pietschy.gwt.pectin.demo.client.domain.Wine;
import com.pietschy.gwt.pectin.demo.client.misc.VerySimpleForm;

/**
 *
 */
public class EditPersonForm extends VerySimpleForm
{
   protected EditPersonModel model;

   // we'll use an EnhancedTextBox as it fires value change events as
   // you type, much more exciting for the demo (c:
   private TextBox givenName = new EnhancedTextBox();
   private TextBox surname = new EnhancedTextBox();

   private String buttonGroupId = DOM.createUniqueId();
   private RadioButton maleRadio = new RadioButton(buttonGroupId, "Male");
   private RadioButton femaleRadio = new RadioButton(buttonGroupId, "Female");

   private CheckBox cabSavCheckBox = new CheckBox("Cab Sav");
   private CheckBox merlotCheckBox = new CheckBox("Merlot");
   private CheckBox shirazCheckBox = new CheckBox("Shiraz");

   private AbstractDynamicList<String> favoriteCheeses = new AbstractDynamicList<String>("Add Cheese")
   {
      protected HasValue<String> createWidget()
      {
         return new EnhancedTextBox();
      }
   };

   private Button saveButton = new Button("Save");
   private Button cancelButton = new Button("Cancel");

   private Label savingMessage = new Label("Saving.... (I'm faking an errors based on Random.nextBoolean())");
   private HTML statusMessage = new HTML();

   private WidgetBinder widgets = new WidgetBinder();
   private MetadataBinder metadata = new MetadataBinder();
   private ValidationBinder validation = new ValidationBinder();
   private ActivityBinder activities = new ActivityBinder();


   public EditPersonForm(EditPersonModel model,  SaveActivity save, Activity cancel)
   {
      this.model = model;

      // bind our widgets to our model.  In normal practice I'd combine the
      // binding, widget creation and form layout into some nice reusable methods.
      widgets.bind(model.givenName).to(givenName);
      widgets.bind(model.surname).to(surname);

      // now lets bind a value using radio buttons
      widgets.bind(model.gender).withValue(Gender.MALE).to(maleRadio);
      widgets.bind(model.gender).withValue(Gender.FEMALE).to(femaleRadio);

      // and a list model to a collection of check boxes
      widgets.bind(model.favoriteWines).containingValue(Wine.CAB_SAV).to(cabSavCheckBox);
      widgets.bind(model.favoriteWines).containingValue(Wine.MERLOT).to(merlotCheckBox);
      widgets.bind(model.favoriteWines).containingValue(Wine.SHIRAZ).to(shirazCheckBox);

      // and a list model to a HasValue<Collection<T>>
      widgets.bind(model.favoriteCheeses).to(favoriteCheeses);

      // we're using an activity for our save behaviour
      activities.bind(save).to(saveButton);
      activities.bind(cancel).to(cancelButton);

      // and when it works we'll show a little status message.. normally you'd send this to
      // a NotificationArea that would display if with nice colors and make it fade after
      // a few seconds.
      activities.sendResultOf(save)
         .formattedWith(new StaticMessage("The save worked!"))
         .to(statusMessage);

      // and we'd do something better with the errors.
      activities.sendErrorOf(save)
         .formattedWith(new StaticMessage("Arrggghhh, the save failed!!!"))
         .to(statusMessage);

      // and lets display a message while we're saving... it's a bit of a hack, I'd
      // rather use a proper NotificationArea...
      metadata.show(savingMessage).when(save.isActive());
      metadata.hide(statusMessage).when(save.isActive());

      // putting two messages on the same line is a little ugly, have I mentioned that
      // I'd like to be use a NotificationArea???...
      addRow("", hpWithNoGap(savingMessage, statusMessage));
      addRow("Given Name", givenName, createValidationLabel(model.givenName));
      addRow("Surname", surname, createValidationLabel(model.surname));
      addRow("Gender", maleRadio, femaleRadio, createValidationLabel(model.gender));
      addRow("Favorite Wines", cabSavCheckBox, merlotCheckBox, shirazCheckBox);
      addTallRow("Favorite Cheeses", favoriteCheeses);
      addRow("",createValidationLabel(model.favoriteCheeses));
      addGap();
      addRow("", saveButton, cancelButton);      

   }

   private ValidationDisplayLabel createValidationLabel(FieldModelBase<?> field)
   {
      ValidationDisplayLabel label = new ValidationDisplayLabel();
      validation.bindValidationOf(field).to(label);
      return label;
   }

   private ValidationDisplayLabel createValidationLabel(ListFieldModelBase<?> field)
   {
      ValidationDisplayLabel label = new ValidationDisplayLabel();
      validation.bindValidationOf(field).to(label);
      return label;
   }

   private static class StaticMessage implements DisplayFormat<Object>
   {
      private String text;

      public StaticMessage(String text)
      {
         this.text = text;
      }

      public String format(Object value)
      {
         return text;
      }
   }
}