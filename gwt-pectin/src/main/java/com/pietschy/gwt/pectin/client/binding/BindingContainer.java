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

import com.google.gwt.event.shared.HandlerRegistration;

/**
 * Created by IntelliJ IDEA.
 * User: andrew
 * Date: Jul 17, 2009
 * Time: 1:43:55 PM
 * To change this template use File | Settings | File Templates.
 */
public interface BindingContainer extends Disposable
{

   /**
    * Registers the binding with the container and ensures {@link com.pietschy.gwt.pectin.client.binding.AbstractBinding#updateTarget()}
    * is invoked.
    *  
    * @param binding the binding to register
    */
   void registerBindingAndUpdateTarget(AbstractBinding binding);

   void registerHandler(HandlerRegistration handlerRegistration);

   void registerDisposable(Disposable disposable);
}
