/*
 * Copyright 2006 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License")
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.configuration.event;

import java.util.EventObject;

/**
 * <p>
 * An event class for reporting updates on a configuration object.
 * </p>
 * <p>
 * Event objects of this type are used for &quot;raw&quot; events, i.e.
 * unfiltered modifications of any kind. A level with semantically higher events
 * (e.g. for property changes) may be built on top of this fundamental event
 * mechanism.
 * </p>
 * <p>
 * Each event can contain the following data:
 * <ul>
 * <li>A source object, which is usually the configuration object that was
 * modified.</li>
 * <li>The event's type. This is a numeric value that corresponds to constant
 * declarations in concrete configuration classes. It describes what exactly has
 * happended.</li>
 * <li>If available, the name of the property whose modification caused the
 * event.</li>
 * <li>If available, the value of the property that caused this event.</li>
 * <li>A flag whether this event was generated before or after the update of
 * the source configuration. A modification of a configuration typically causes
 * two events: one event before and one event after the modification is
 * performed. This allows event listeners to react at the correct point of time.</li>
 * </ul>
 * </p>
 *
 * @author <a
 * href="http://jakarta.apache.org/commons/configuration/team-list.html">Commons
 * Configuration team</a>
 * @version $Id$
 * @since 1.3
 */
public class ConfigurationEvent extends EventObject
{
    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 3277238219073504136L;

    /** Stores the event type. */
    private int type;

    /** Stores the property name. */
    private String propertyName;

    /** Stores the property value. */
    private Object propertyValue;

    /** Stores the before update flag. */
    private boolean beforeUpdate;

    /**
     * Creates a new instance of <code>ConfigurationEvent</code> and
     * initializes it.
     *
     * @param source the event source
     * @param type the event's type
     * @param propertyName the name of the affected property
     * @param propertyValue the value of the affected property
     * @param beforeUpdate the before update flag
     */
    public ConfigurationEvent(Object source, int type, String propertyName,
            Object propertyValue, boolean beforeUpdate)
    {
        super(source);
        this.type = type;
        this.propertyName = propertyName;
        this.propertyValue = propertyValue;
        this.beforeUpdate = beforeUpdate;
    }

    /**
     * Returns the name of the affected property. This can be <b>null</b> if no
     * property change has lead to this event.
     *
     * @return the name of the property
     */
    public String getPropertyName()
    {
        return propertyName;
    }

    /**
     * Returns the value of the affected property if available.
     *
     * @return the value of the property; can be <b>null</b>
     */
    public Object getPropertyValue()
    {
        return propertyValue;
    }

    /**
     * Returns the type of this event. This describes the update process that
     * caused this event.
     *
     * @return the event's type
     */
    public int getType()
    {
        return type;
    }

    /**
     * Returns a flag if this event was generated before or after an update.
     *
     * @return <b>true</b> if this event was generated before an update;
     * <b>false</b> otherwise
     */
    public boolean isBeforeUpdate()
    {
        return beforeUpdate;
    }
}
