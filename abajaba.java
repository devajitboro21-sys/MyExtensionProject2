package aaa; // Updated package name

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.runtime.ComponentContainer;
import com.google.appinventor.components.runtime.TextBox;
import com.google.appinventor.components.runtime.util.YailList;

@SimpleObject
public class abajaba extends AndroidNonvisibleComponent {

    public abajaba(ComponentContainer container) {
        super(container.$form());
    }

    @SimpleFunction(description = "Style a single TextBox")
    public void SetModernStyle(TextBox textBox, int bgColor, int brdColor, int radius, int thickness) {
        applyStyle(textBox, bgColor, brdColor, radius, thickness);
    }

    @SimpleFunction(description = "Style a list of TextBoxes at once")
    public void SetMultipleModernStyle(YailList textBoxList, int bgColor, int brdColor, int radius, int thickness) {
        for (Object obj : textBoxList.toArray()) {
            if (obj instanceof TextBox) {
                applyStyle((TextBox) obj, bgColor, brdColor, radius, thickness);
            }
        }
    }

    @SimpleFunction(description = "Adds a focus color effect (glow) when the user clicks the box")
    public void SetFocusEffect(final TextBox textBox, final int normalColor, final int focusColor, final int bgColor, final int radius, final int thickness) {
        View view = textBox.getView();
        if (view instanceof EditText) {
            final EditText editText = (EditText) view;
            
            // Set initial style so it's not blank before first click
            applyStyle(textBox, bgColor, normalColor, radius, thickness);

            editText.setOnFocusChangeListener(new OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    int currentColor = hasFocus ? focusColor : normalColor;
                    GradientDrawable gd = new GradientDrawable();
                    gd.setColor(bgColor);
                    gd.setCornerRadius(radius);
                    gd.setStroke(thickness, currentColor);
                    editText.setBackground(gd);
                    // Preserve padding during focus change
                    editText.setPadding(25, 20, 25, 20);
                }
            });
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

