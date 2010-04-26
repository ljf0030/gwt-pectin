package com.pietschy.gwt.pectin.client.binding;

import com.pietschy.gwt.pectin.client.util.Utils;

/**
 * Created by IntelliJ IDEA.
 * User: andrew
 * Date: Apr 13, 2010
 * Time: 12:52:08 PM
 * To change this template use File | Settings | File Templates.
 */
class TransitionToBinding<T> extends TransitionBindingSupport<T>
{
   protected TransitionToBinding(T triggerValue, T lastKnownValue)
   {
      super(lastKnownValue, triggerValue);
   }

   @Override
   boolean isTrigger(T triggerValue, T lastKnownValue, T newValue)
   {
      return Utils.areEqual(triggerValue, newValue);
   }
}