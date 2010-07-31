package com.pietschy.gwt.pectin.client.channel;

/**
 * Represents a Channel destination.
 * @see Channel#sendTo(Destination)
 */
public interface Destination<T>
{
   public void receive(T value);
}