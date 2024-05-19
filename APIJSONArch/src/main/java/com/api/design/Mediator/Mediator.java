package com.api.design.Mediator;

import java.util.UUID;

/**
 *
 */
public interface Mediator {
    /**
     * @param request The request that will be handled by its registered handler, if it exists.
     * @param <T>     The type of the response that will be returned.
     * @return The result of the executed handler.
     */
	 <T> T send( Request<T> request);
	 <T> UUID usend( Request<T> request);
}
