package aaa;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.EditText;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.runtime.ComponentContainer;
import com.google.appinventor.components.runtime.TextBox;
import com.google.appinventor.components.runtime.util.YailList;

@SimpleObject
public class aaa extends AndroidNonvisibleComponent {

    public aaa(ComponentContainer container) {
        super(container.$form());
    }

    @SimpleFunction(description = "Style one TextBox")
    public void SetModernStyle(TextBox textBox, int bgColor, int brdColor, int radius, int thickness) {
        applyStyle(textBox, bgColor, brdColor, radius, thickness);
    }

    @SimpleFunction(description = "Style multiple TextBoxes using a List")
    public void SetMultipleModernStyle(YailList textBoxList, int bgColor, int brdColor, int radius, int thickness) {
        for (Object obj : textBoxList.toArray()) {
            if (obj instanceof TextBox) {
                applyStyle((TextBox) obj, bgColor, brdColor, radius, thickness);
            }
        }
    }

    private void applyStyle(TextBox textBox, int bgColor, int brdColor, int radius, int thickness) {
        View view = textBox.getView();
        if (view instanceof EditText) {
            EditText editText = (EditText) view;
            GradientDrawable gd = new GradientDrawable();
            gd.setColor(bgColor);
            gd.setCornerRadius(radius);
            gd.setStroke(thickness, brdColor);
            editText.setBackground(gd);
            editText.setPadding(25, 20, 25, 20);
        }
    }
}
