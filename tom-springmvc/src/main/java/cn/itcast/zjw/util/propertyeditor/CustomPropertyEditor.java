package cn.itcast.zjw.util.propertyeditor;

import java.beans.PropertyEditor;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.propertyeditors.CustomDateEditor;

/**
 *
 * <p>Title:CustomPropertyEditor.java</p>
 * <p>Description:</p>
 * @author TOM
 * @date 2017年2月8日下午10:43:23
 */
public class CustomPropertyEditor implements PropertyEditorRegistrar{

	public void registerCustomEditors(PropertyEditorRegistry registry) {
		registry.registerCustomEditor(Date.class, (PropertyEditor) new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"),true));
	}

}
