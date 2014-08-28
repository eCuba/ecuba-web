package com.ecuba.domain;

import java.util.Date;

/**
 * Created by rolando on 2014-08-28.
 */
public interface Timeable {

	public Date getStart();

	public Date getEnd();

	public void setStart(Date start);

	public void setEnd(Date end);
}
