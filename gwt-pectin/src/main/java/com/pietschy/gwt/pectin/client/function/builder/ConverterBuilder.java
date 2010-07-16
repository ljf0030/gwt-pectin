package com.pietschy.gwt.pectin.client.function.builder;

import com.pietschy.gwt.pectin.client.function.Function;
import com.pietschy.gwt.pectin.client.value.ComputedValueModel;
import com.pietschy.gwt.pectin.client.value.Converter;
import com.pietschy.gwt.pectin.client.value.ConvertingValueModel;
import com.pietschy.gwt.pectin.client.value.ValueModel;

/**
* Created by IntelliJ IDEA.
* User: andrew
* Date: Jul 16, 2010
* Time: 12:52:58 PM
* To change this template use File | Settings | File Templates.
*/
public class ConverterBuilder<S>
{
   private ValueModel<S> source;

   public ConverterBuilder(ValueModel<S> source)
   {
      this.source = source;
   }

   public <T> ValueModel<T> using(Function<T, ? super S> function)
   {
      return new ComputedValueModel<T, S>(source, function);
   }
   
   public <T> ValueModel<T> using(Converter<T, S> converter)
   {
      return new ConvertingValueModel<T, S>(source, converter);
   }
}
