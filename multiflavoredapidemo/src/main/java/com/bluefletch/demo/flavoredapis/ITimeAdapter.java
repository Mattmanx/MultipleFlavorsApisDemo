package com.bluefletch.demo.flavoredapis;

/**
 * Created by mattmehalso on 4/23/14.
 */
public interface ITimeAdapter {

    /**
     * Sets the system time to the provided value.
     * @param epochTimeMS
     */
    void setSystemTime(long epochTimeMS);
}
