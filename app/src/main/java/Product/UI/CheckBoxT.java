package Product.UI;

import facecat.topin.btn.FCCheckBox;
import facecat.topin.core.FCColor;
import facecat.topin.core.FCPaint;
import facecat.topin.core.FCRect;
import facecat.topin.core.FCSize;
import facecat.topin.core.FCTouchInfo;
import facecat.topin.core.FCView;

public class CheckBoxT extends FCCheckBox {
    public CheckBoxT() {
        FCSize cSize = new FCSize(40, 22);
        setButtonSize(cSize);
        setBorderColor(FCColor.None);
    }

    private int m_currentX = -1;

    private int m_timerID = FCView.getNewTimerID();

    @Override
    public void onClick(FCTouchInfo touchInfo) {
        boolean oldChecked = isChecked();
        super.onClick(touchInfo);
        boolean newChecked = isChecked();
        if (oldChecked != newChecked) {
            if (oldChecked) {
                m_currentX = (getButtonSize().cx - 22);
                startTimer(m_timerID, 20);

            } else {
                m_currentX = -(getButtonSize().cx - 22);
                startTimer(m_timerID, 20);
            }
        }
    }


    @Override
    public void onPaintCheckButton(FCPaint paint, FCRect clipRect) {
        FCRect drawRect = clipRect.clone();
        int width = getWidth(), height = getHeight();
        boolean isChecked = isChecked();
        int d = 22;
        int pHeight = 10;
        int round = 20;
        FCRect pRect = new FCRect(1, height / 2 - pHeight / 2, clipRect.right - 1, height / 2 + pHeight / 2);
        long backColor = FCColor.rgb(106, 108, 118);
        long backColor1 = FCColor.rgb(152, 152, 161);
        FCRect ellipseRect = new FCRect(1, (height - d) / 2, 1 + d, (height + d) / 2);
        if (isChecked) {
            backColor = FCColor.rgb(20, 99, 177);
            backColor1 = FCColor.rgb(20, 138, 253);
            ellipseRect.left = clipRect.right - 1 - d;
            ellipseRect.right = clipRect.right - 1;
        }
        if (m_currentX != -1) {
            ellipseRect.left += m_currentX;
            ellipseRect.right += m_currentX;
        }
        paint.fillRoundRect(backColor, pRect, round);
        paint.fillEllipse(backColor1, ellipseRect);
    }

    @Override
    public void onRemove() {
        super.onRemove();
        stopTimer(m_timerID);
    }

    @Override
    public void onTimer(int timerID) {
        super.onTimer(timerID);
        if (m_timerID == timerID) {
            int aimLeft = 0;
            if (m_currentX != -1) {
                int xSub = aimLeft - m_currentX;
                if (xSub != 0) {
                    if (xSub > 0) {
                        m_currentX += 2;
                    } else if (xSub < 0) {
                        m_currentX -= 2;
                    }
                    if (Math.abs(aimLeft - m_currentX) < 3) {
                        m_currentX = aimLeft;
                        stopTimer(m_timerID);
                    }
                    invalidate();
                }
            }
        }
    }
}
