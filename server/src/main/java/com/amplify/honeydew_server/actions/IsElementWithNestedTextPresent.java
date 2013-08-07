package com.amplify.honeydew_server.actions;

import com.amplify.honeydew_server.*;
import com.android.uiautomator.core.*;

import java.util.Map;

public class IsElementWithNestedTextPresent extends Action {
    public IsElementWithNestedTextPresent(UiDevice uiDevice) {
        super(uiDevice);
    }

    @Override
    public Result execute(Map<String, Object> arguments) throws UiObjectNotFoundException {
        String parentDescription = (String) arguments.get("parent_description");
        String childText = (String) arguments.get("child_text");

        UiCollection parentElement = new UiCollection(new UiSelector().description(parentDescription));
        UiObject child = parentElement.getChild(new UiSelector().text(childText));

        return isUiObjectAvailable(child, arguments) ? Result.OK : Result.FAILURE;
    }

}
