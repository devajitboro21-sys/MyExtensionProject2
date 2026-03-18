package dev;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.EditText;

import com.google.appinventor.components.annotations.*;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.*;
import com.google.appinventor.components.runtime.util.YailList;

@DesignerComponent(
    version = 1,
    description = "Modern TextBox Style Extension",
    category = ComponentCategory.EXTENSION,
    nonVisible = true,
    iconName = ""
)

@SimpleObject(external = true)
public class Dev extends AndroidNonvisibleComponent {

    public Dev(ComponentContainer container) {
        super(container.$form());
    }

    @SimpleFunction(description = "Apply modern styling to a TextBox.")
    public void SetModernStyle(TextBox textBox, int bgColor, int brdColor, int radius, int thickness) {
        View view = textBox.getView();
        if (view instanceof EditText) {
            EditText editText = (EditText) view;
            GradientDrawable gd = new GradientDrawable();
            gd.setColor(bgColor);
            gd.setCornerRadius(radius);
            gd.setStroke(thickness, brdColor);
            editText.setBackground(gd);
        }
    }

    @SimpleFunction(description = "Style multiple TextBoxes using a List.")
    public void SetMultipleModernStyle(YailList textBoxList, int bgColor, int brdColor, int radius, int thickness) {
        Object[] objects = textBoxList.toArray();
        for (Object obj : objects) {
            if (obj instanceof TextBox) {
                SetModernStyle((TextBox) obj, bgColor, brdColor, radius, thickness);
            }
        }
    }
}
