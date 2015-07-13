package com.vrv.im;

import java.lang.annotation.Retention;
import java.lang.annotation.*;

/** 
 * @author 作者chengnl  E-mail: chengnengliang@vrvmail.com.cn
 * @version 创建时间：2013-6-24 下午09:08:21 
 * 类说明 
 */
@Retention(RetentionPolicy.RUNTIME)
public abstract @interface Order  {
	public int order();
}
