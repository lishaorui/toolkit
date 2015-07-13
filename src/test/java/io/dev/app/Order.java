package io.dev.app;

import java.lang.annotation.Retention;
import java.lang.annotation.*;

/** 
 */
@Retention(RetentionPolicy.RUNTIME)
public abstract @interface Order  {
	public int order();
}
