/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.configuration.reloading;

import org.apache.commons.configuration.event.Event;
import org.apache.commons.configuration.event.EventType;

/**
 * <p>
 * An event that is fired when a reload operation is required.
 * </p>
 * <p>
 * Events of this type are generated by {@link ReloadingController} if the need
 * for a reload operation is detected. From the pay-load of the event
 * information about the components involved is available.
 * </p>
 *
 * @version $Id$
 * @since 2.0
 */
public class ReloadingEvent extends Event
{
    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 20140701L;

    /** The common event super type for all reloading events. */
    public static final EventType<ReloadingEvent> ANY =
            new EventType<ReloadingEvent>(Event.ANY, "RELOAD");

    /** Stores additional data about this event. */
    private final Object data;

    /**
     * Creates a new instance of {@code ReloadingEvent} and initializes it.
     *
     * @param source the controller which generated this event
     * @param addData an arbitrary data object to be evaluated by event
     *        listeners
     */
    public ReloadingEvent(ReloadingController source, Object addData)
    {
        super(source, ANY);
        data = addData;
    }

    /**
     * Returns the {@code ReloadingController} which caused this event.
     *
     * @return the responsible {@code ReloadingController}
     */
    public ReloadingController getController()
    {
        return (ReloadingController) getSource();
    }

    /**
     * Returns an object with additional data about the reload operation. This
     * is the object that was passed to the {@link ReloadingController} when it
     * was asked to do a reloading check. This is a generic mechanism to pass
     * arbitrary data to reloading listeners.
     *
     * @return additional data about the reload operation (can be <b>null</b>)
     */
    public Object getData()
    {
        return data;
    }
}
